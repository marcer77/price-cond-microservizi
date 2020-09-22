package com.intesasanpaolo.bear.bear_v3.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.AttributoValore;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.CollectionDrivers;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.DatiApplicativi;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.Driver;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleResponseType;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.InpFunctionId;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.OutValori;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriComuni;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriFactory;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.ParametriPrice;
import com.intesasanpaolo.bear.bear_v3.dto.CondizioneDeroga;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.CondizioneConto;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.CondizioneContoDettaglio;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.DriverInq;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSHeader;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.IIBCDPRCMSRequest;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndDettaglioOutput;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndRequest;
import com.intesasanpaolo.bear.bear_v3.service.InquiryContoCndService;
import com.intesasanpaolo.bear.bear_v3.service.JDBCService;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope("prototype")
public class InquiryContoCndDettaglioCommand extends BaseCommand<InquiryContoCndDettaglioOutput>{

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
	
	private int indicePromozione;
	
	public InquiryContoCndDettaglioCommand(InquiryContoCndRequest request) {
		this.request = request;
	}
	
	@Override
	public InquiryContoCndDettaglioOutput doExecute() throws Exception {
		
		logger.info("Start doExecute");
		
		InquiryContoCndDettaglioOutput output = new InquiryContoCndDettaglioOutput();		
		List<CondizioneContoDettaglio> condizioniStd = new ArrayList<>(); //una singola copia della lista di condizioni - per recuperare il val STD
		List<CondizioneContoDettaglio> condizioniOut = new ArrayList<>(); //intera lista di condizioni - eventualmente ripetute per tipo livello

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
	    logger.info("IspCallerCompanyIDCode found with cdAbi {}--->{}",request.getCdAbi(),header.getIspServiceCompanyIDCode());
	    iibCdprcmsRequest.setHeader(header);

	    //RECUPERO STD
	    reqSTD = buildCNDPRICEMSRequestSTD(request);
	    if(!CollectionUtils.isEmpty(reqSTD)) {
	    	iibCdprcmsRequest.setBody(reqSTD);
	    	outSTD.addAll(service.inquiryContoCnd(iibCdprcmsRequest));
	    	logger.info("outSTD--->{}",outSTD);
	    }
	    condizioniStd = buildResponseFromCNDPRICEMS(outSTD,null);

		String cdIstituto = jdbcService.getIstitutoFromAbi(request.getCdAbi());
		logger.info("cdIstituto from service -->{}",cdIstituto);
		
		for (CondizioneContoDettaglio cond : condizioniStd) {
			String cdCnd = cond.getCdCnd();
			String etichetta = etichette.containsKey(cdCnd) ? etichette.get(cdCnd):"";
			CondizioneDeroga condizioneDeroga = new CondizioneDeroga();
			if(cdCnd!=null) {
				condizioneDeroga = jdbcService.getDatiCondizione(cdCnd);
				logger.info("condizioneDeroga from jdbcService-->{}",condizioneDeroga);
			}
			if(condizioneDeroga!=null) {
				if(condizioneDeroga.getCD_UDM().equals("3")) {
					condizioneDeroga.setValCodiceStandard(jdbcService.getCdSTD(condizioneDeroga.getCD_CONDIZIONE(), cdIstituto, request.getDtOperazione()));
					logger.info("CD_UDM = 3,condizioneDeroga ValCodiceStandard from jdbcService -->{}",condizioneDeroga.getValCodiceStandard());
				}
					
				else {
					condizioneDeroga.setValNumericoStandard(jdbcService.getValSTD(condizioneDeroga.getCD_CONDIZIONE(), cdIstituto, request.getDtOperazione()));
					logger.info("CD_UDM != 3,condizioneDeroga ValNumericoStandard from jdbcService -->{}",condizioneDeroga.getValNumericoStandard());
				}
			}
				
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
	    logger.info("request: {}" , new Gson().toJson(req));
	    if(!CollectionUtils.isEmpty(req)) {
	    	iibCdprcmsRequest.setBody(req);
	    	out.addAll(service.inquiryContoCnd(iibCdprcmsRequest));
		    logger.info("response: {}" , new Gson().toJson(out));
	    }
	    
    	if( condizioniStd.isEmpty() || !CollectionUtils.isEmpty(out) && !CollectionUtils.isEmpty(out.get(0).getNbpErrorInfo()) ) { //ERR
    		output.setCdEsito(CondizioniContoUtils.ESITO_KO);
    		if(out.get(0).getNbpErrorInfo().get(0)!=null) {
    			output.setMsgEsito(out.get(0).getNbpErrorInfo().get(0).getErrReason());
    		}else {
    			output.setMsgEsito("Errore inquiryContoCnd Response: Impossibile verificare l'errore ");
    		}
    	}
    	else {        	
    		output.setCdEsito(CondizioniContoUtils.ESITO_OK);
    		output.setMsgEsito("");
    		if(!CollectionUtils.isEmpty(out))
    			condizioniOut.addAll(buildResponseFromCNDPRICEMS(out,condizioniStd));
    	}
    	
    	// Verifico le esposizioni dei prezzi promozionati
    	indicePromozione = 0;
    	logger.info("Lista promozioni: {}",request.getPromozioni());
    	for (CondizioneContoDettaglio condizionePromo : condizioniOut) {
			if(condizionePromo.getCdTipoLivello().equalsIgnoreCase("P")) {

				BigDecimal prezzoConv = null;
				BigDecimal prezzoRapp = null;
				for(CondizioneContoDettaglio condizionePrezzo : condizioniOut) {
					if(condizionePrezzo.getCdCnd().equals(condizionePromo.getCdCnd()) && condizionePrezzo.getCdTipoLivello().equalsIgnoreCase("CN"))
						prezzoConv=condizionePrezzo.getNrValore();
					else if(condizionePrezzo.getCdCnd().equals(condizionePromo.getCdCnd()) && condizionePrezzo.getCdTipoLivello().equalsIgnoreCase("R"))
						prezzoRapp=condizionePrezzo.getNrValore();
				}
				condizionePromo.setNrValCalcolatoPro(calcolaValorePromo(condizionePromo, prezzoRapp==null?prezzoConv:prezzoRapp, condizioniStd));
			}
			buildCdRifLivello(condizionePromo);
		}

		output.setCondizioni(condizioniOut);	
		
		logger.info("End doExecute with output -->{}", output);
		
		return output;
	}

	private List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequestSTD(InquiryContoCndRequest request){

		logger.info("Start buildCNDPRICEMSRequestSTD");
		
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
	    
	    logger.info("End buildCNDPRICEMSRequestSTD: result -->{}",stampaOggetto(rSTD));
	    
		return req;
	}
	
	private List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequest(InquiryContoCndRequest request) {
		
		logger.info("Start buildCNDPRICEMSRequest");

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
	    
	    logger.info("End buildCNDPRICEMSRequest with request -->{}",req);
	    
		return req;
	}
	
	private List<CondizioneContoDettaglio> buildResponseFromCNDPRICEMS (List<IIBCDPRCMSSingleResponseType> response, List<CondizioneContoDettaglio> condizioneDip){ //se condizioneDip = null => chiamata STD
		
		logger.info("Start buildResponseFromCNDPRICEMS with response --> {} and condizioneDip --> {}",response,condizioneDip);
		
		List<CondizioneContoDettaglio> out = new ArrayList<>();
		
		if (!CollectionUtils.isEmpty(response)) {
			for (IIBCDPRCMSSingleResponseType res : response) {
					
			    for (OutValori cnd : res.getValori()) {
			    	
			    	if(condizioneDip!=null && cnd.getOrigine()!=null && cnd.getOrigine().equalsIgnoreCase("I")) 
			    		continue; //SE L'ORIGINE E' STD, LA SALTO (Es: risposta a chiamata CONV che ritorna valore STD => non devo esporlo)
		
			    	CondizioneContoDettaglio c = new CondizioneContoDettaglio();
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
		
		logger.info("End buildResponseFromCNDPRICEMS with response--->{}", out);
		
		return out;
	}
	
	private BigDecimal calcolaValorePromo(CondizioneConto cond, BigDecimal prezzoRif, List<CondizioneContoDettaglio> condizioneDip) {

		logger.info("Start calcolaValorePromo with cond = {} and prezzoRif = {} and condizioneDip = {}",cond, prezzoRif, condizioneDip);
		
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
			if(valCalc!= null && valCalc.compareTo(BigDecimal.ZERO)<0)
				valCalc=BigDecimal.ZERO;
			valCalcolatoPro = valCalc;
		}
		
		logger.info("End calcolaValorePromo --->{}", valCalcolatoPro);
		
		return valCalcolatoPro;
	}
	
	//recupero etichette
	private HashMap<String, String> getEtichette(InquiryContoCndRequest request) {
		logger.info("Start getEtichette");
		
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("cdProd", request.getCdProdotto());
		for(int i = 0; i < 10; i++) {
		    params.put("cdDriver" + (i+1), i < request.getDriver().size()  ? request.getDriver().get(i).val : "*");			
		}
	    HashMap<String, String> result = jdbcService.getEtichette(params);
	    
	    logger.info("End getEtichette: result-->{}",result);
		
	    return result;
	}
	
	private void buildCdRifLivello(CondizioneContoDettaglio condizione) {
		if(condizione!=null) {
			
			logger.info("Cd Tipo livello condizione: {}",condizione.getCdTipoLivello());
			
			if("CN".equals(condizione.getCdTipoLivello())) {
				condizione.setCdRifLivello(request.getCdConv());
			
			}else if("R".equals(condizione.getCdTipoLivello())||"RCN".equals(condizione.getCdTipoLivello())||"RP".equals(condizione.getCdTipoLivello())) {
				condizione.setCdRifLivello(request.getCdRapporto());
			
			}else if("P".equals(condizione.getCdTipoLivello())) {
				
				logger.info("IndicePromozione vale: {}",indicePromozione);
				
				condizione.setCdRifLivello(!CollectionUtils.isEmpty(request.getPromozioni()) 
						&& indicePromozione<=(request.getPromozioni().size()-1) ? 
								request.getPromozioni().get(indicePromozione) : null
						);
				indicePromozione++;
			}else {
				condizione.setCdRifLivello("");
			}
			logger.info("Cd Rif livello condizione: {}",condizione.getCdRifLivello());
		}
	}
	
	
	/**
	 * Stampa a log tutto l' oggetto
	 * @param obj
	 * @return
	 */
	private StringBuilder stampaOggetto(Object obj) {
		StringBuilder buffer = new StringBuilder("[");
		java.util.Arrays.asList(obj.getClass().getDeclaredFields()).forEach(f -> {
			try {
				buffer.append(f.getName() + " = " + f.get(obj)).append(" - ");
			} catch (Exception e) {
			}
		});
		buffer.append("]");
		return buffer;
	}
}
