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
import com.ibm.ctg.server.logging.Log;
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
	    	//stampa con log la lista
	    	logger.info(stampaIIBCDPRCMSSingleResponseType(outSTD, "outSTD").toString());
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
				logger.info("condizioneDeroga from jdbcService-->{}",stampaOggetto(condizioneDeroga));
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
	    logger.info("condizioniOut: {}",  stampaCondizioneContoDettaglioList(condizioniOut) );
	   
		//RECUPERO ALTRI PREZZI
		
	    req = buildCNDPRICEMSRequest(request);
	    logger.info("request: {}" , new Gson().toJson(req));
	    if(!CollectionUtils.isEmpty(req)) {
	    	iibCdprcmsRequest.setBody(req);
	    	out.addAll(service.inquiryContoCnd(iibCdprcmsRequest));
		    logger.info("response: {}" , new Gson().toJson(out));
	    }
	    
	    logger.info("Print condizioniStd: {}", stampaCondizioneContoDettaglioList(condizioniStd));
	    logger.info(stampaIIBCDPRCMSSingleResponseType(out, "out").toString());
	    
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
		
		logger.info("End doExecute with output: {}", stampaInquiryContoCndDettaglioOutput(output));
		
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
	    
	    logger.info("End buildCNDPRICEMSRequestSTD: {}", stampaIIBCDPRCMSSingleRequestType(rSTD));
	    
		return req;
	}
	
	private List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequest(InquiryContoCndRequest request) {
		
		logger.info("Start buildCNDPRICEMSRequest");

	    List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();
	    	     
	    
	    if(request.getCdRapporto() != null && !request.getCdRapporto().equals("") && request.getCdRapporto().length()==17) { //CASO RAPP
	    	
			logger.info("buildCNDPRICEMSRequest aggiungo alla request il rapporto: {}", request.getCdRapporto());
			
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
	    	
		    if(!CollectionUtils.isEmpty(request.getPromozioni())) { //CASO PROMO
		    	
				logger.info("buildCNDPRICEMSRequest rapporto non presente considero le PROMO: {}", request.getPromozioni());
			    for(String promo : request.getPromozioni()) {
			    	
			    	if(!promo.isEmpty()) {
						logger.info("buildCNDPRICEMSRequest aggiungo alla request la PROMO: {}", promo);
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
		    	
				logger.info("buildCNDPRICEMSRequest aggiungo alla request la CONVENZIONE: {}", request.getCdConv());
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
	    
	    logger.info("End buildCNDPRICEMSRequest with request: {}",stampaIIBCDPRCMSSingleRequestTypeList(req));
	    
	    
		return req;
	}
	
	private List<CondizioneContoDettaglio> buildResponseFromCNDPRICEMS (List<IIBCDPRCMSSingleResponseType> response, List<CondizioneContoDettaglio> condizioneDip){ //se condizioneDip = null => chiamata STD
		
		logger.info("Start buildResponseFromCNDPRICEMS with: ");
		logger.info(stampaIIBCDPRCMSSingleResponseType(response, "response").toString());
		logger.info("condizioneDip: {}", stampaCondizioneContoDettaglioList(condizioneDip));
		
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
		
		logger.info("End buildResponseFromCNDPRICEMS with response: {}", stampaCondizioneContoDettaglioList(out));
		
		return out;
	}
	
	private BigDecimal calcolaValorePromo(CondizioneConto cond, BigDecimal prezzoRif, List<CondizioneContoDettaglio> condizioneDip) {

		logger.info("Start calcolaValorePromo with: ");
		//stampa ogni singolo oggetto complesso
		logger.info("1 - cond = {}",stampaOggettoWithParentClass(cond));
		logger.info("2 - prezzoRif = {}",prezzoRif);
		logger.info("3 - condizioneDip: {}",stampaCondizioneContoDettaglioList(condizioneDip));
		
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
		logger.info("buildCdRifLivello START");
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
		logger.info("buildCdRifLivello END");
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
				f.setAccessible(true);//per rendere accessibili i campi non pubblici
				buffer.append(f.getName() + " = " + f.get(obj)).append(" - ");
			} catch (Exception e) {
			}
		});
		buffer.append("]");
		return buffer;
	}
	
	
	/**
	 * permette di stampare i campi di un oggetto e quelli ereditati da una superclasse
	 * @param obj
	 * @return
	 */
	private StringBuilder stampaOggettoWithParentClass(Object obj) {
		StringBuilder buffer = new StringBuilder("[");
		java.util.Arrays.asList(obj.getClass().getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true);//per rendere accessibili i campi non pubblici
				buffer.append(f.getName() + " = " + f.get(obj)).append(" - ");
			} catch (Exception e) {
			}
		});
		java.util.Arrays.asList(obj.getClass().getSuperclass().getDeclaredFields()).forEach(s -> {
			try {
				s.setAccessible(true);//per rendere accessibili i campi non pubblici
				buffer.append(s.getName() + " = " + s.get(obj)).append(" - ");
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		});
		buffer.append("]");
		return buffer;
	}
	
	
	/**
	 * permette di stampare una lista di oggetti di tipo IIBCDPRCMSSingleResponseType
	 * @param outSTD
	 * @param objectName
	 * @return StringBuilder
	 */
	private StringBuilder stampaIIBCDPRCMSSingleResponseType(List<IIBCDPRCMSSingleResponseType> outSTD,String objectName) {
		
		StringBuilder buffer = new StringBuilder(objectName+" [");;
		if(outSTD!=null) {
			for(IIBCDPRCMSSingleResponseType elem : outSTD) {
				buffer.append("OutputFactory: "+stampaOggetto(elem.getOutputFactory()));
				buffer.append("OutputPrice: "+stampaOggetto(elem.getOutputPrice()));
				buffer.append("Valori: ");
				for(OutValori val :elem.getValori() ) {
					
					buffer.append("outValore: "+stampaOggetto(val));
					
				}
				buffer.append("NbpErrorInfo: "+elem.getNbpErrorInfo());
				
			}
		}
		buffer.append("]");
		return buffer;
	}
	
	
	/**
	 * Permette di stampare a log l'oggetto complesso di tipo IIBCDPRCMSSingleRequestType
	 * @param elem
	 * @return
	 */
	private StringBuilder stampaIIBCDPRCMSSingleRequestType(IIBCDPRCMSSingleRequestType elem) {
		
		StringBuilder buffer =new StringBuilder("Result: [");
		
		buffer.append(" datiApplicativi = "+stampaOggetto(elem.getDatiApplicativi()));
		buffer.append(" parametriComuni = "+stampaOggetto(elem.getParametriComuni()));
		buffer.append(" parametriFactory = "+stampaOggetto(elem.getParametriFactory()));
		buffer.append(" parametriPrice = "+stampaOggetto(elem.getParametriPrice()));
		buffer.append("]");
		
		return buffer;
		
	}
	
	
	/**
	 * permette di stampare a log una lista di oggetti di tipo IIBCDPRCMSSingleRequestType
	 * @param list
	 * @return
	 */
	private StringBuilder stampaIIBCDPRCMSSingleRequestTypeList(List<IIBCDPRCMSSingleRequestType> list) {
		StringBuilder buffer =new StringBuilder("{");
		for (IIBCDPRCMSSingleRequestType iibcdprcmsSingleRequestType : list) {
			buffer.append(stampaIIBCDPRCMSSingleRequestType(iibcdprcmsSingleRequestType));
		}
		buffer.append("}");
		
		return buffer;
	}
	
	/**
	 * permette di stampare a log un oggetto di tipo InquiryContoCndDettaglioOutput
	 * @param elem
	 * @return
	 */
	private StringBuilder stampaInquiryContoCndDettaglioOutput(InquiryContoCndDettaglioOutput elem) {
		
		StringBuilder buffer =new StringBuilder("[");
		buffer.append(" cdEsito: "+elem.getCdEsito());
		buffer.append(" MsgEsito: "+elem.getMsgEsito());
		buffer.append(stampaCondizioneContoDettaglioList(elem.getCondizioni()));
		buffer.append("]");
		
		return buffer;
	}

	/**
	 * permette di stampare a log una lista di oggetti di tipo CondizioneContoDettaglio
	 * @param lista
	 * @return
	 */
	private StringBuilder stampaCondizioneContoDettaglioList(List<CondizioneContoDettaglio> lista) {
		
		StringBuilder buffer =new StringBuilder("Condizioni ContoDettaglio: {");
		if(lista != null) {
			for(CondizioneContoDettaglio cond : lista) {
				buffer.append("ContoDettaglio: "+stampaOggettoWithParentClass(cond));
			}
		}
		buffer.append("}");
		
		return buffer;
	}
}
