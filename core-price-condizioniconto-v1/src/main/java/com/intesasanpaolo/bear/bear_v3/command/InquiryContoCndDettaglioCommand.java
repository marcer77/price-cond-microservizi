package com.intesasanpaolo.bear.bear_v3.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.AttributoValore;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.CollectionDrivers;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.DatiApplicativi;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.Driver;
import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSResponseType;
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
import com.intesasanpaolo.bear.bear_v3.service.exception.IIBWebServiceException;
import com.intesasanpaolo.bear.core.command.BaseCommand;

@Component
@Scope("prototype")
public class InquiryContoCndDettaglioCommand extends BaseCommand<InquiryContoCndDettaglioOutput> {

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

	private Map<String, String> etichette = new HashMap<String, String>();
	
	public InquiryContoCndDettaglioCommand(InquiryContoCndRequest request) {
		this.request = request;
	}

	@Override
	public InquiryContoCndDettaglioOutput doExecute() throws Exception {
		InquiryContoCndDettaglioOutput output = new InquiryContoCndDettaglioOutput();
		
		try {
			List<CondizioneContoDettaglio> condizioniOut = new ArrayList<>();
			
			List<CondizioneContoDettaglio> condizioniStd = null; // una singola copia della lista di
																// STD
																// intera lista di condizioni -
																// eventualmente ripetute per tipo
																// livello

			//Recupero le condizioni STD da COND0
			condizioniStd = getCondizioniStd(request);
			
			if (CollectionUtils.isEmpty(condizioniStd)) {
				throw new IIBWebServiceException("Nessuna condizione standard recuperata da WEBSERVICE IIB", null);
			}
			
			//estraggo le etichette dalle condizioni standard 
			etichette = getEtichette(condizioniStd);
			
			String cdIstituto = jdbcService.getIstitutoFromAbi(request.getCdAbi());
			logger.info("cdIstituto per ABI {} -->{}",request.getCdAbi(), cdIstituto);

			//
			IIBCDPRCMSRequest iibCdprcmsRequest = new IIBCDPRCMSRequest();
			IIBCDPRCMSHeader header = new IIBCDPRCMSHeader();
			header.setUserID(request.getCdMatricola());
			header.setIspBranchCode(request.getCdUO());
			header.setCodABI(request.getCdAbi());
			header.setIspCallerCompanyIDCode(cdIstituto);
			iibCdprcmsRequest.setHeader(header);
			
//			//recupero condizioni standard
//			List<CondizioneContoDettaglio> condizioniStd=this.recuperaCondizioniStandard(iibCdprcmsRequest, request, cdIstituto);
			logger.info("prima elaborazione - condizioniStandard={}",condizioniStd);
			condizioniOut.addAll(condizioniStd);
			
			// RECUPERO ALTRI PREZZI
			//Gestione Promo
			List<IIBCDPRCMSSingleRequestType> req = buildCNDPRICEMSRequest(request);
			
			List<CondizioneContoDettaglio> condizioniPromo=new ArrayList<CondizioneContoDettaglio>();
			if (!CollectionUtils.isEmpty(request.getPromozioni())) { // CASO PROMO					
				if (StringUtils.isEmpty(request.getCdRapporto())|| request.getCdRapporto().length()!=17){							
					for (String promo : request.getPromozioni()) {
						if (!promo.isEmpty()) {
							req =buildCNDPRICEMSRequestForPromo(request, promo);
							iibCdprcmsRequest.setBody(req);
							IIBCDPRCMSResponseType response=service.inquiryContoCndV2(iibCdprcmsRequest);
						    condizioniPromo=buildResponseFromCNDPRICEMS(response.getOutputProdotto(), condizioniStd);
							if (condizioniPromo!=null)
								condizioniPromo.forEach(cd->cd.setCdRifLivello(promo));
							condizioniOut.addAll(condizioniPromo);
						}					
					}					
				}					
			}
			
			//gestione convenzione/rapporto
			List<CondizioneContoDettaglio> condizioniRapportoConvenzione=new ArrayList<CondizioneContoDettaglio>();
			req = buildCNDPRICEMSRequest(request);		   
			if (!CollectionUtils.isEmpty(req)) {
				iibCdprcmsRequest.setBody(req);
				IIBCDPRCMSResponseType response=service.inquiryContoCndV2(iibCdprcmsRequest);	
				condizioniRapportoConvenzione=buildResponseFromCNDPRICEMS(response.getOutputProdotto(), condizioniStd);
				condizioniOut.addAll(condizioniRapportoConvenzione);
			}
			
					
	    	// Verifico le esposizioni dei prezzi promozionati
	    	for (CondizioneContoDettaglio condizionePromo : condizioniOut) {
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
				buildCdRifLivello(condizionePromo);
			}
			
			output.setCdEsito(CondizioniContoUtils.ESITO_OK);
    		output.setMsgEsito("");		
			output.setCondizioni(condizioniOut);
			
			logger.info("Output finale={}",output);
		
		} catch (IIBWebServiceException e) {
			
			logger.error("Errore in INQUIRY", e);
			
			output.setCdEsito(CondizioniContoUtils.ESITO_KO);
			
			output.setMsgEsito(e.getMessage());			
		
		} catch (Exception e) {
			
			logger.error("Errore in INQURY", e);
			
			throw e;
		}

		return output;
	}

	private Map<String, String> getEtichette(List<CondizioneContoDettaglio> condizioniStd) {
		Map<String, String> ret = new HashMap<String, String>(); 
		for (CondizioneContoDettaglio condizioneContoDettaglio : condizioniStd) {
			ret.put(condizioneContoDettaglio.getCdCnd(),condizioneContoDettaglio.getCdEtichetta());
		}
		return ret;
	}

	protected List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequestSTD(InquiryContoCndRequest request) {

		List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();

		// CASO STD
		IIBCDPRCMSSingleRequestType rSTD = new IIBCDPRCMSSingleRequestType();

		DatiApplicativi datiapplicativiSTD = new DatiApplicativi();
		datiapplicativiSTD.setFunctionId(InpFunctionId.INQ);
		ParametriComuni parametriComuniSTD = new ParametriComuni();
		parametriComuniSTD.setDataoper(request.getDtOperazione());
		parametriComuniSTD.setCallerid(CALLER_ID);
		ParametriFactory parametriFactorySTD = new ParametriFactory();
		parametriFactorySTD.setProductArea(PRODUCT_AREA);
		parametriFactorySTD.setProductId(request.getCdProdotto());
		ParametriPrice parametriPriceSTD = new ParametriPrice();
		parametriPriceSTD.setFunctionApp(INQ_STD);
		parametriPriceSTD.setAttrCond(request.getCdAttrCnd());
		CollectionDrivers collectionDriversSTD = new CollectionDrivers();
		for (DriverInq driver : request.getDriver()) {
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

	protected List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequest(InquiryContoCndRequest request) {

		
		List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();

		if (request.getCdRapporto() != null && !request.getCdRapporto().equals("")
				&& request.getCdRapporto().length() == 17) { // CASO RAPP

	
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
			ParametriFactory parametriFactory = new ParametriFactory();
			parametriFactory.setProductArea(PRODUCT_AREA);
			parametriFactory.setProductId(request.getCdProdotto());
			ParametriPrice parametriPrice = new ParametriPrice();
			parametriPrice.setFunctionApp(INQ_RAPP);
			parametriPrice.setAttrCond(request.getCdAttrCnd());
			CollectionDrivers collectionDrivers = new CollectionDrivers();
			for (DriverInq driver : request.getDriver()) {
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
		} else { 
			if (request.getCdConv() != null && !request.getCdConv().equals("")) { // CASO CONV

				IIBCDPRCMSSingleRequestType r = new IIBCDPRCMSSingleRequestType();

				DatiApplicativi datiapplicativi = new DatiApplicativi();
				datiapplicativi.setFunctionId(InpFunctionId.INQ);
				ParametriComuni parametriComuni = new ParametriComuni();
				parametriComuni.setDataoper(request.getDtOperazione());
				parametriComuni.setCallerid(CALLER_ID);
				ParametriFactory parametriFactory = new ParametriFactory();
				parametriFactory.setProductArea(PRODUCT_AREA);
				parametriFactory.setProductId(request.getCdProdotto());
				ParametriPrice parametriPrice = new ParametriPrice();
				parametriPrice.setFunctionApp(INQ_CONV);
				parametriPrice.setAttrCond(request.getCdAttrCnd());
				parametriPrice.setCodConvenzione(request.getCdConv());
				CollectionDrivers collectionDrivers = new CollectionDrivers();
				for (DriverInq driver : request.getDriver()) {
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

	protected List<CondizioneContoDettaglio> buildResponseFromCNDPRICEMS(List<IIBCDPRCMSSingleResponseType> response,
			List<CondizioneContoDettaglio> condizioneDip) { // se condizioneDip = null => chiamata STD

		
		List<CondizioneContoDettaglio> out = new ArrayList<>();

		if (!CollectionUtils.isEmpty(response)) {
			for (IIBCDPRCMSSingleResponseType res : response) {

				for (OutValori cnd : res.getValori()) {

					if (condizioneDip != null && cnd.getOrigine() != null && cnd.getOrigine().equalsIgnoreCase("I"))
						continue; // SE L'ORIGINE E' STD, LA SALTO (Es: risposta a chiamata CONV che ritorna
									// valore STD => non devo esporlo)

					CondizioneContoDettaglio c = new CondizioneContoDettaglio();
					BigDecimal std = BigDecimal.ZERO;

					if (condizioneDip != null)
						for (CondizioneConto cond : condizioneDip) {
							if (cond.getCdCnd().equals(cnd.getCod())) {
								c.setCdDescCnd(cond.getCdDescCnd());// DA DB
								std = cond.getNrValore();
								continue;
							}
						}
					c.setCdEtichetta(etichette.containsKey(cnd.getCod()) ? etichette.get(cnd.getCod()) : "");
					c.setCdCnd(cnd.getCod());
					c.setCdTipoLivello(
							cnd.getOrigine() != null && !cnd.getOrigine().isEmpty() ? cnd.getOrigine() : cnd.getLiv());
					c.setCdUDM(cnd.getTipo());
					c.setCdAttrCond(cnd.getAttrCond());
					for (AttributoValore attr : cnd.getAttrVal()) {
						if (attr.getAttributo().equalsIgnoreCase("BLINDATURA_CDZ"))
							c.setFlBlindaturaCnd(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("COVENANT_CDZ"))
							c.setFlCovenantCnd(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("VISUALIZZA_CDZ"))
							c.setFlVisualizzaCnd(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("STAMPA_CDZ"))
							c.setFlStampaCnd(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("TIPO_CONDIZIONE_TEC"))
							c.setCdTipoCndTec(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("SEGNO-CONDIZ-TEC"))
							c.setCdSegnoCndTec(attr.getValore());
						else if (attr.getAttributo().equalsIgnoreCase("TIPO_CDZ"))
							c.setCdTipoCnd(attr.getValore());
					}

					c.setCdTipoValore(cnd.getTipo());// DA DB
					c.setDtDecorrenza(cnd.getDeco());
					c.setDtScadenza(cnd.getDeca());
					c.setCdSegnoValore("");
					if (c.getCdTipoValore().equals("3"))
						c.setCdValore(cnd.getVal());
					else
						c.setNrValore(BigDecimal.valueOf(Double.valueOf(cnd.getVal())));

					out.add(c);
				}
			}
		}
		return out;
	}

	protected BigDecimal calcolaValorePromo(CondizioneConto cond, BigDecimal prezzoRif,
			List<CondizioneContoDettaglio> condizioneDip) {

		BigDecimal valCalcolatoPro = BigDecimal.ZERO;
		BigDecimal std = BigDecimal.ZERO;

		if (condizioneDip != null)
			for (CondizioneConto c : condizioneDip) {
				if (c.getCdCnd().equals(cond.getCdCnd())) {
					std = c.getNrValore();
					continue;
				}
			}

		if (cond.getCdTipoLivello().equalsIgnoreCase("P")) { // VA CALCOLATO A PARTIRE DAL VALORE, IN BASE AL TIPO PROMO
			BigDecimal valCalc = cond.getNrValore();
			if (cond.getCdTipoCndTec() != null && cond.getCdTipoCndTec().equalsIgnoreCase("S")) {// SCONTO (percentuale
																									// su applicato =
																									// prodotto->convenzione->std)
				if (prezzoRif != null)
					valCalc = prezzoRif
							.multiply(BigDecimal.ONE.subtract(cond.getNrValore().divide(BigDecimal.valueOf(100d))));
				else
					valCalc = std
							.multiply(BigDecimal.ONE.subtract(cond.getNrValore().divide(BigDecimal.valueOf(100d))));
			} else if (cond.getCdTipoCndTec() != null && cond.getCdTipoCndTec().equalsIgnoreCase("D")) { // DELTA
																											// (valore
																											// assoluto
																											// su
																											// applicato
																											// =
																											// prodotto->convenzione->std)
				if (prezzoRif != null)
					valCalc = prezzoRif.subtract(cond.getNrValore());
				else
					valCalc = std.subtract(cond.getNrValore());
			}
			if (valCalc != null && valCalc.compareTo(BigDecimal.ZERO) < 0)
				valCalc = BigDecimal.ZERO;
			valCalcolatoPro = valCalc;
		}
	
		return valCalcolatoPro;
	}

	// recupero etichette
	protected HashMap<String, String> getEtichette(InquiryContoCndRequest request) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("cdProd", request.getCdProdotto());
		for (int i = 0; i < 10; i++) {
			params.put("cdDriver" + (i + 1), i < request.getDriver().size() ? request.getDriver().get(i).val : "*");
		}
		HashMap<String, String> result = jdbcService.getEtichette(params);

		logger.info("End getEtichette: result-->{}", result);

		return result;
	}

	protected void buildCdRifLivello(CondizioneContoDettaglio condizione) {
		if (condizione != null) {
			logger.info("getCdTipoLivello vale: {}", condizione.getCdTipoLivello());
			if ("CN".equals(condizione.getCdTipoLivello())) {
				condizione.setCdRifLivello(request.getCdConv());

			} else if ("R".equals(condizione.getCdTipoLivello()) || "RCN".equals(condizione.getCdTipoLivello())
					|| "RP".equals(condizione.getCdTipoLivello())) {
				condizione.setCdRifLivello(request.getCdRapporto());

			} else if ("P".equals(condizione.getCdTipoLivello())) {
				//caso già elaborato
			} else {
				condizione.setCdRifLivello("");
			}
		}
	}
	
	
	
	protected List<IIBCDPRCMSSingleRequestType> buildCNDPRICEMSRequestForPromo(InquiryContoCndRequest request, String promo) {		
		List<IIBCDPRCMSSingleRequestType> req = new ArrayList<IIBCDPRCMSSingleRequestType>();

		
		IIBCDPRCMSSingleRequestType r = new IIBCDPRCMSSingleRequestType();
		DatiApplicativi datiapplicativi = new DatiApplicativi();
		datiapplicativi.setFunctionId(InpFunctionId.INQ);
		ParametriComuni parametriComuni = new ParametriComuni();
		parametriComuni.setDataoper(request.getDtOperazione());
		parametriComuni.setCallerid(CALLER_ID);
		ParametriFactory parametriFactory = new ParametriFactory();
		parametriFactory.setProductArea(PRODUCT_AREA);
		parametriFactory.setProductId(request.getCdProdotto());
		ParametriPrice parametriPrice = new ParametriPrice();
		parametriPrice.setFunctionApp(INQ_PROM);
		parametriPrice.setAttrCond(request.getCdAttrCnd());
		parametriPrice.setCodPromozione(promo);
		parametriPrice.setCodConvenzione(request.getCdConv());
		CollectionDrivers collectionDrivers = new CollectionDrivers();
		for (DriverInq driver : request.getDriver()) {
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
		return req;

	}
	protected List<CondizioneContoDettaglio> getCondizioniStd(InquiryContoCndRequest request) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("ABI", request.getCdAbi());
		params.put("DATA", request.getDtOperazione());
		params.put("cdProd", request.getCdProdotto());
		params.put("CdAttrCond",request.getCdAttrCnd());
		
		for (int i = 0; i < 10; i++) {
			params.put("cdEtichetta" + (i + 1), i < request.getDriver().size() ? request.getDriver().get(i).etichetta : "?");
			params.put("cdDriver" + (i + 1), i < request.getDriver().size() ? request.getDriver().get(i).val : "*");
		}
		List<CondizioneContoDettaglio> result = jdbcService.getCondizioniStd(params);

		logger.info("End getEtichette: result-->{}", result);

		return result;
	}

}
