package com.intesasanpaolo.bear.bear_v3.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.AttributoValore;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.CollectionDrivers;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.DatiApplicativi;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.Driver;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.InpFunctionId;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.OutValori;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriComuni;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriFactory;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriPrice;
import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.CondizioneConto;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.DriverInq;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSHeader;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndOutput;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndRequest;
import com.intesasanpaolo.bear.bear_v3.service.InquiryContoCndService;
import com.intesasanpaolo.bear.bear_v3.service.JDBCService;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope("prototype")
public class InquiryContoCndCommand extends BaseCommand<InquiryContoCndOutput>{
	
	private InquiryContoCndRequest request;
	public static final String INQ_STD = "000001";
	public static final String INQ_RAPP = "000003";
	public static final String INQ_CONV = "000002";
	public static final String INQ_PROM = "000005";
	public static final String CALLER_ID = "PHCP0";
	public static final String PRODUCT_AREA = "PRICING";
	
	@Autowired
	private InquiryContoCndService service;

	@Autowired
	private JDBCService jdbcService;
	
	private HashMap<String, String> etichette = new HashMap<String, String>();
	
	public InquiryContoCndCommand(InquiryContoCndRequest request) {
		this.request = request;
	}
	
	@Override
	public InquiryContoCndOutput doExecute() throws Exception {
		InquiryContoCndOutput output = new InquiryContoCndOutput();		
		List<CondizioneConto> condizioniStd = new ArrayList<>(); //una singola copia della lista di condizioni - per recuperare il val STD
		List<CondizioneConto> condizioniOut = new ArrayList<>(); //intera lista di condizioni - eventualmente ripetute per tipo livello

	    List<IIBCDPRCMSSingleRequestType> req = new ArrayList<>();
	    List<IIBCDPRCMSSingleRequestType> reqSTD = new ArrayList<>();
	    List<IIBCDPRCMSSingleResponseType> out = new ArrayList<>();
	    List<IIBCDPRCMSSingleResponseType> outSTD = new ArrayList<>();
	    etichette = getEtichette(request);
	    
	    IIBCDPRCMSRequest iibCdprcmsRequest = new IIBCDPRCMSRequest();
	    IIBCDPRCMSHeader header = new IIBCDPRCMSHeader();
	    header.setUserID(request.getCdMatricola());
	    header.setIspBranchCode(request.getCdUO());
	    header.setCodABI(request.getCdAbi());
	    header.setIspCallerCompanyIDCode(jdbcService.getIstitutoFromAbi(request.getCdAbi()));
	    iibCdprcmsRequest.setHeader(header);
	    
	    /*
		String prod = request.getCdProdotto();
		List<DriverInq> driver = request.getDriver();
		
		String conv = request.getCdConv();
		String rapp = request.getCdRapporto();
		
		List<String> promo = request.getPromozioni();
		*/

	    //RECUPERO STD
	    reqSTD = buildCNDPRICEMSRequestSTD(request);
	    if(reqSTD.size()>0) {
	    	iibCdprcmsRequest.setBody(reqSTD);
	    	outSTD.addAll(service.inquiryContoCnd(iibCdprcmsRequest));
	    }
	    condizioniStd = buildResponseFromCNDPRICEMS(outSTD,null);

		String cdIstituto = jdbcService.getIstitutoFromAbi(request.getCdAbi());
		
		for (CondizioneConto cond : condizioniStd) {
			String cdCnd = cond.getCdCnd();
			String etichetta = etichette.containsKey(cdCnd) ? etichette.get(cdCnd):"";
			CondizioneDeroga condizioneDeroga = new CondizioneDeroga();
			if(cdCnd!=null) 
				condizioneDeroga = jdbcService.getDatiCondizione(cdCnd);
			if(condizioneDeroga!=null)
				if(condizioneDeroga.getCD_UDM().equals("3"))
					condizioneDeroga.setValCodiceStandard(jdbcService.getCdSTD(condizioneDeroga.getCD_CONDIZIONE(), cdIstituto, request.getDtOperazione()));
				else
					condizioneDeroga.setValNumericoStandard(jdbcService.getValSTD(condizioneDeroga.getCD_CONDIZIONE(), cdIstituto, request.getDtOperazione()));
			cond.setCdCnd(condizioneDeroga.getCD_CONDIZIONE());
			cond.setCdDescCnd(condizioneDeroga.getDS_CONDIZIONE());
			cond.setCdUDM(condizioneDeroga.getCD_UDM());
			cond.setCdTipoLivello("S");
			cond.setCdEtichetta(etichetta);
			if(cond.getCdTipoValore().equals("3"))
				cond.setCdValore(condizioneDeroga.getValCodiceStandard());
			else
				cond.setNrValore(cond.getNrValore());
			condizioniOut.add(cond);
		}
		
		//RECUPERO ALTRI PREZZI
		
	    req = buildCNDPRICEMSRequest(request);
	    logger.info("request:" + new Gson().toJson(req));
	    if(req.size()>0) {
	    	iibCdprcmsRequest.setBody(req);
	    	out.addAll(service.inquiryContoCnd(iibCdprcmsRequest));
		    logger.info("response:" + new Gson().toJson(out));
	    }
	    
    	if(condizioniStd.isEmpty() || (out.size()>0 && out.get(0).getNbpErrorInfo()!=null && out.get(0).getNbpErrorInfo().size()>0)) { //ERR
    		output.setCdEsito(CondizioniContoUtils.ESITO_KO);
		    output.setMsgEsito(out.get(0).getNbpErrorInfo().get(0).getErrReason());
    	}
    	else {        	
    		output.setCdEsito(CondizioniContoUtils.ESITO_OK);
    		output.setMsgEsito("");
    		if(out.size()>0)
    			condizioniOut.addAll(buildResponseFromCNDPRICEMS(out,condizioniStd));
    	}
    	
    	// Verifico le esposizioni dei prezzi promozionati
    	for (CondizioneConto condizionePromo : condizioniOut) {
			if(condizionePromo.getCdTipoLivello().equalsIgnoreCase("P")) {

				BigDecimal prezzoConv = null;
				BigDecimal prezzoRapp = null;
				for(CondizioneConto condizionePrezzo : condizioniOut) {
					if(condizionePrezzo.getCdCnd().equals(condizionePromo.getCdCnd()) && condizionePrezzo.getCdTipoLivello().equalsIgnoreCase("CN"))
						prezzoConv=condizionePrezzo.getNrValore();
					else if(condizionePrezzo.getCdCnd().equals(condizionePromo.getCdCnd()) && condizionePrezzo.getCdTipoLivello().equalsIgnoreCase("R"))
						prezzoRapp=condizionePrezzo.getNrValore();
				}
				condizionePromo.setNrValCalcolatoPro(calcolaValorePromo(condizionePromo, prezzoRapp==null?prezzoConv:prezzoRapp, condizioniStd));
			}
		}

		output.setCondizioni(condizioniOut);		
		
		return output;
	}

	private List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequestSTD(InquiryContoCndRequest request){

	    List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();
	    	    
	    //CASO STD
    	IIBCDPRCMSSingleRequestType rSTD = new IIBCDPRCMSSingleRequestType();

		DatiApplicativi datiapplicativiSTD = new DatiApplicativi();
		datiapplicativiSTD.setFunctionId(InpFunctionId.INQ);
		ParametriComuni parametriComuniSTD = new ParametriComuni();
		parametriComuniSTD.setDataoper(request.getDtOperazione());
		parametriComuniSTD.setCallerid(CALLER_ID);
	    ParametriFactory parametriFactorySTD =new ParametriFactory();
	    parametriFactorySTD.setProductArea(PRODUCT_AREA);
	    parametriFactorySTD.setProductId(request.getCdProdotto());
	    ParametriPrice parametriPriceSTD = new ParametriPrice();
	    parametriPriceSTD.setFunctionApp(INQ_STD);
	    parametriPriceSTD.setAttrCond(request.getCdAttrCnd());
	    CollectionDrivers collectionDriversSTD = new CollectionDrivers();
	    for(DriverInq driver : request.getDriver()) {
	    	Driver d = new Driver();
	    	d.setEtichetta(driver.etichetta);
	    	d.setVal(driver.val);
	    	collectionDriversSTD.getDriver().add(d);
	    }
	    rSTD.setDatiApplicativi(datiapplicativiSTD);
	    rSTD.setParametriComuni(parametriComuniSTD);
	    rSTD.setParametriFactory(parametriFactorySTD);
	    rSTD.setParametriPrice(parametriPriceSTD);
	    rSTD.setCollectionDrivers(collectionDriversSTD);
	    
	    req.add(rSTD);
	    
		return req;
	}
	
	private List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequest(InquiryContoCndRequest request) {

	    List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();
	    	     
	    
	    if(request.getCdRapporto() != null && !request.getCdRapporto().equals("") && request.getCdRapporto().length()==17) { //CASO RAPP
	    	IIBCDPRCMSSingleRequestType r = new IIBCDPRCMSSingleRequestType();
	    	
	    	HashMap<String, String> infoRapp = CondizioniContoUtils.getInfoRapporto(request.getCdRapporto());
	    	
			DatiApplicativi datiapplicativi = new DatiApplicativi();
			datiapplicativi.setFunctionId(InpFunctionId.INQ);
			ParametriComuni parametriComuni = new ParametriComuni();
			parametriComuni.setDataoper(request.getDtOperazione());
			parametriComuni.setCallerid(CALLER_ID);
			parametriComuni.setFilrapp(infoRapp.get(CondizioniContoUtils.RAPP_FILIALE));
			parametriComuni.setCatrapp(infoRapp.get(CondizioniContoUtils.RAPP_CATEGORIA));
			parametriComuni.setNumrapp(infoRapp.get(CondizioniContoUtils.RAPP_CONTO));
		    ParametriFactory parametriFactory =new ParametriFactory();
		    parametriFactory.setProductArea(PRODUCT_AREA);
		    parametriFactory.setProductId(request.getCdProdotto());
		    ParametriPrice parametriPrice = new ParametriPrice();
		    parametriPrice.setFunctionApp(INQ_RAPP);
		    parametriPrice.setAttrCond(request.getCdAttrCnd());
		    CollectionDrivers collectionDrivers = new CollectionDrivers();
		    for(DriverInq driver : request.getDriver()) {
		    	Driver d = new Driver();
		    	d.setEtichetta(driver.etichetta);
		    	d.setVal(driver.val);
		    	collectionDrivers.getDriver().add(d);
		    }
		    
		    r.setDatiApplicativi(datiapplicativi);
		    r.setParametriComuni(parametriComuni);
		    r.setParametriFactory(parametriFactory);
		    r.setParametriPrice(parametriPrice);
		    r.setCollectionDrivers(collectionDrivers);
		    
		    req.add(r);
	    }
	    else { //CONSIDERO PROMO E CONV SOLO SE NON C'E' RAPPORTO
	    	
		    if(request.getPromozioni()!= null && request.getPromozioni().size()>0) { //CASO PROMO
			    for(String promo : request.getPromozioni()) {
			    	
			    	if(!promo.isEmpty()) {
				    	IIBCDPRCMSSingleRequestType r = new IIBCDPRCMSSingleRequestType();
				    	
						DatiApplicativi datiapplicativi = new DatiApplicativi();
						datiapplicativi.setFunctionId(InpFunctionId.INQ);
						ParametriComuni parametriComuni = new ParametriComuni();
						parametriComuni.setDataoper(request.getDtOperazione());
						parametriComuni.setCallerid(CALLER_ID);
					    ParametriFactory parametriFactory =new ParametriFactory();
					    parametriFactory.setProductArea(PRODUCT_AREA);
					    parametriFactory.setProductId(request.getCdProdotto());
					    ParametriPrice parametriPrice = new ParametriPrice();
					    parametriPrice.setFunctionApp(INQ_PROM);
					    parametriPrice.setAttrCond(request.getCdAttrCnd());
					    parametriPrice.setCodPromozione(promo);
					    parametriPrice.setCodConvenzione(request.getCdConv());
					    CollectionDrivers collectionDrivers = new CollectionDrivers();
					    for(DriverInq driver : request.getDriver()) {
					    	Driver d = new Driver();
					    	d.setEtichetta(driver.etichetta);
					    	d.setVal(driver.val);
					    	collectionDrivers.getDriver().add(d);
					    }
					    
					    r.setDatiApplicativi(datiapplicativi);
					    r.setParametriComuni(parametriComuni);
					    r.setParametriFactory(parametriFactory);
					    r.setParametriPrice(parametriPrice);
					    r.setCollectionDrivers(collectionDrivers);
					    
					    req.add(r);
			    	}
			    }
		    }
	
		    if(request.getCdConv()!= null && !request.getCdConv().equals("")) { //CASO CONV
		    	IIBCDPRCMSSingleRequestType r = new IIBCDPRCMSSingleRequestType();
		    	
				DatiApplicativi datiapplicativi = new DatiApplicativi();
				datiapplicativi.setFunctionId(InpFunctionId.INQ);
				ParametriComuni parametriComuni = new ParametriComuni();
				parametriComuni.setDataoper(request.getDtOperazione());
				parametriComuni.setCallerid(CALLER_ID);
			    ParametriFactory parametriFactory =new ParametriFactory();
			    parametriFactory.setProductArea(PRODUCT_AREA);
			    parametriFactory.setProductId(request.getCdProdotto());
			    ParametriPrice parametriPrice = new ParametriPrice();
			    parametriPrice.setFunctionApp(INQ_CONV);
			    parametriPrice.setAttrCond(request.getCdAttrCnd());
			    parametriPrice.setCodConvenzione(request.getCdConv());
			    CollectionDrivers collectionDrivers = new CollectionDrivers();
			    for(DriverInq driver : request.getDriver()) {
			    	Driver d = new Driver();
			    	d.setEtichetta(driver.etichetta);
			    	d.setVal(driver.val);
			    	collectionDrivers.getDriver().add(d);
			    }
			    
			    r.setDatiApplicativi(datiapplicativi);
			    r.setParametriComuni(parametriComuni);
			    r.setParametriFactory(parametriFactory);
			    r.setParametriPrice(parametriPrice);
			    r.setCollectionDrivers(collectionDrivers);
			    
			    req.add(r);
		    }
	    }
		return req;
	}
	
	private List<CondizioneConto> buildResponseFromCNDPRICEMS (List<IIBCDPRCMSSingleResponseType> response, List<CondizioneConto> condizioneDip){ //se condizioneDip = null => chiamata STD
		List<CondizioneConto> out = new ArrayList<>();
		
		if (response.size() > 0) {
			for (IIBCDPRCMSSingleResponseType res : response) {
					
			    for (OutValori cnd : res.getValori()) {
			    	
			    	if(condizioneDip!=null && cnd.getOrigine()!=null && cnd.getOrigine().equalsIgnoreCase("I")) 
			    		continue; //SE L'ORIGINE E' STD, LA SALTO (Es: risposta a chiamata CONV che ritorna valore STD => non devo esporlo)
		
			    	CondizioneConto c = new CondizioneConto();
			    	BigDecimal std = BigDecimal.ZERO;  	
			    	
			    	if(condizioneDip!=null)
				    	for (CondizioneConto cond : condizioneDip) {
							if(cond.getCdCnd().equals(cnd.getCod())) {
					    		c.setCdDescCnd(cond.getCdDescCnd());//DA DB
					    		std=cond.getNrValore();
					    		continue;
							}
						}
			    	//c.setCdEtichetta(cnd.getEtichetta());
			    	c.setCdEtichetta(etichette.containsKey(cnd.getCod()) ? etichette.get(cnd.getCod()):"");
		    		c.setCdCnd(cnd.getCod());
		    		c.setCdTipoLivello(cnd.getOrigine()!=null && !cnd.getOrigine().isEmpty() ? cnd.getOrigine() : cnd.getLiv());
		    		c.setCdUDM(cnd.getTipo());
		    		c.setCdAttrCond(cnd.getAttrCond());
		    		for(AttributoValore attr : cnd.getAttrVal()){
		    			if(attr.getAttributo().equalsIgnoreCase("BLINDATURA_CDZ"))
				    		c.setFlBlindaturaCnd(attr.getValore());
			    		else if(attr.getAttributo().equalsIgnoreCase("COVENANT_CDZ"))
				    		c.setFlCovenantCnd(attr.getValore());
				    	else if(attr.getAttributo().equalsIgnoreCase("VISUALIZZA_CDZ"))
				    		c.setFlVisualizzaCnd(attr.getValore());
			    		else if(attr.getAttributo().equalsIgnoreCase("STAMPA_CDZ"))
				    		c.setFlStampaCnd(attr.getValore());
			    		else if(attr.getAttributo().equalsIgnoreCase("TIPO_CONDIZIONE_TEC"))
			    			c.setCdTipoCndTec(attr.getValore());
			    		else if(attr.getAttributo().equalsIgnoreCase("SEGNO-CONDIZ-TEC"))
			    			c.setCdSegnoCndTec(attr.getValore());
			    		else if(attr.getAttributo().equalsIgnoreCase("TIPO_CDZ"))
			    			c.setCdTipoCnd(attr.getValore());
		    		}
		
		
					c.setCdTipoValore(cnd.getTipo());//DA DB
		    		c.setDtDecorrenza(cnd.getDeco());
		    		c.setDtScadenza(cnd.getDeca());
		    		c.setCdSegnoValore("");
		    		if(c.getCdTipoValore().equals("3"))
		        		c.setCdValore(cnd.getVal());
		    		else
		    			c.setNrValore(BigDecimal.valueOf(Double.valueOf(cnd.getVal())));
		    		
		    		
		    		out.add(c);
				}
			}
		}
		return out;
	}
	
	private BigDecimal calcolaValorePromo(CondizioneConto cond, BigDecimal prezzoRif, List<CondizioneConto> condizioneDip) {

		BigDecimal valCalcolatoPro = BigDecimal.ZERO;
		BigDecimal std = BigDecimal.ZERO;  	
    	
    	if(condizioneDip!=null)
	    	for (CondizioneConto c : condizioneDip) {
				if(c.getCdCnd().equals(cond.getCdCnd())) {
		    		std=c.getNrValore();
		    		continue;
				}
			}
		
		if(cond.getCdTipoLivello().equalsIgnoreCase("P")) { //VA CALCOLATO A PARTIRE DAL VALORE, IN BASE AL TIPO PROMO
			BigDecimal valCalc = cond.getNrValore();
			if(cond.getCdTipoCndTec() != null && cond.getCdTipoCndTec().equalsIgnoreCase("S")) {// SCONTO (percentuale su applicato = prodotto->convenzione->std)
				if(prezzoRif!=null)
					valCalc = prezzoRif.multiply(BigDecimal.ONE.subtract(cond.getNrValore().divide(BigDecimal.valueOf(100d))));
				else
					valCalc = std.multiply(BigDecimal.ONE.subtract(cond.getNrValore().divide(BigDecimal.valueOf(100d))));
			}
			else if(cond.getCdTipoCndTec() != null && cond.getCdTipoCndTec().equalsIgnoreCase("D")) { // DELTA (valore assoluto su applicato = prodotto->convenzione->std)
				if(prezzoRif!=null)
					valCalc = prezzoRif.subtract(cond.getNrValore());
				else
					valCalc = std.subtract(cond.getNrValore());
			}
			if(valCalc.compareTo(BigDecimal.ZERO)<0)
				valCalc=BigDecimal.ZERO;
			valCalcolatoPro = valCalc;
		}
		
		return valCalcolatoPro;
	}
	
	//recupero etichette
	private HashMap<String, String> getEtichette(InquiryContoCndRequest request) {
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("cdProd", request.getCdProdotto());
		for(int i = 0; i < 10; i++) {
		    params.put("cdDriver" + (i+1), i < request.getDriver().size()  ? request.getDriver().get(i).val : "*");			
		}
	    HashMap<String, String> result = jdbcService.getEtichette(params);
		return result;
	}
}
