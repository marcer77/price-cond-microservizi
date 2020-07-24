package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountOutput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.PropostaCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.WrapperMap;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.GestioneService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType.AdditionalBusinessInfo.Param;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends BaseCommand<EsitoResource> {

	private Logger log = Logger.getLogger(CJDispositivaInserimentoCommand.class);

	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	private DispositivaRequestDTO dispositivaRequestDTO;
	private NewAccountInput newAccountInput;

	@Autowired
	private GestioneService gestioneService;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Override
	public EsitoResource execute() throws Exception {
		log.info("execute START");
		EsitoResource esitoResource = new EsitoResource("KO", "Si è verificato un errore.");
		if (canExecute()) {

			// BS PCMK Recupero informazioni superpratica (…)
			// TODO

			// IIB PCK8 PCGESTIXME/Gestione aggiornamento Condizioni
			newAccountInput = new NewAccountInput();
			NewAccountOutput output = _callWsGestione();

			// WS VDM StoreCovenantAdesioneConvenzione
			// TODO

			// WS COND0 GESTCJPOSV.inviaPropostaV2
			dispositivaRequestDTO = new DispositivaRequestDTO();
			EsitoOperazioneCJPOSV2 esitoOperazione = _inviaPropostaV2();

			// BS PCMK registrazione elenco cod.prop. “fittizie”
			// TODO

			// return
			esitoResource.setCodErrore(esitoOperazione.getEsitoCodice());
			esitoResource.setDescErrore(esitoOperazione.getEsitoMessaggio());
			log.info("execute SUCCESS ");
			return esitoResource;
		} else {
			log.info("execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private EsitoOperazioneCJPOSV2 _inviaPropostaV2() throws BearForbiddenException {
		log.info("_inviaPropostaV2 START");

		EsitoOperazioneCJPOSV2 esitoOperazione = new EsitoOperazioneCJPOSV2();
		if (dispositivaRequestDTO != null) {
			InviaPropostaV2 request = ProposteCJPOSWSUtils._buildMockInviaPropostaV2();
//			InviaPropostaV2 request = _assemblaRequest(dispositivaRequestDTO);
			log.info("_inviaPropostaV2 CAN EXECUTE");
			esitoOperazione = proposteCJPOSWSService.inviaPropostaV2(request, ispWebservicesHeaderType);
		} else {
			log.info("_inviaPropostaV2 ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
		log.info("_inviaPropostaV2 END");
		return esitoOperazione;
	}

	@Override
	public boolean canExecute() {
		log.info("canExecute START");
		boolean esitoControlli = false;
		esitoControlli = ispWebservicesHeaderType != null;
		log.info("canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	private NewAccountOutput _callWsGestione() throws BearForbiddenException {
		log.info("callWsGestione START");
		if (newAccountInput != null) {
			log.info("callWsGestione CAN EXECUTE");

			HashMap<String, String> headerParams = new HashMap<String, String>();
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceID",
					ispWebservicesHeaderType.getRequestInfo().getServiceID());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPCallerCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPCallerCompanyIDCode());
			headerParams.put("ISPWebservicesHeader.CompanyInfo.ISPServiceCompanyIDCode",
					ispWebservicesHeaderType.getCompanyInfo().getISPServiceCompanyIDCode());
			List<Param> listParams = ispWebservicesHeaderType.getAdditionalBusinessInfo().getParam();
			if (listParams != null && listParams.size() > 0) {
				for (Param param : listParams) {
					if (ParamList.COD_ABI.equals(param.getName().COD_ABI)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodABI", param.getValue());
					}
					if (ParamList.COD_UNITA_OPERATIVA.equals(param.getName().COD_UNITA_OPERATIVA)) {
						headerParams.put("ISPWebservicesHeader.AdditionalBusinessInfo.CodUnitaOperativa",
								param.getValue());
					}
				}
			}
			headerParams.put("ISPWebservicesHeader.BusinessInfo.CustomerID",
					ispWebservicesHeaderType.getBusinessInfo().getCustomerID());
			headerParams.put("ISPWebservicesHeader.OperatorInfo.UserID",
					ispWebservicesHeaderType.getOperatorInfo().getUserID());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Language",
					ispWebservicesHeaderType.getRequestInfo().getLanguage());
			headerParams.put("ISPWebservicesHeader.RequestInfo.ServiceVersion",
					ispWebservicesHeaderType.getRequestInfo().getServiceVersion());
			headerParams.put("ISPWebservicesHeader.RequestInfo.Timestamp",
					ispWebservicesHeaderType.getRequestInfo().getTimestamp() + "");
			headerParams.put("ISPWebservicesHeader.RequestInfo.TransactionId",
					ispWebservicesHeaderType.getRequestInfo().getTransactionId());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ApplicationID",
					ispWebservicesHeaderType.getTechnicalInfo().getApplicationID());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.CallerProgramName",
					ispWebservicesHeaderType.getTechnicalInfo().getCallerProgramName());
			headerParams.put("ISPWebservicesHeader.TechnicalInfo.ChannelIDCode",
					ispWebservicesHeaderType.getTechnicalInfo().getChannelIDCode());

			log.info("- callWsGestione END");

			return gestioneService.gestione(newAccountInput, headerParams);

		} else {
			log.info("callWsGestione ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	private InviaPropostaV2 _assemblaRequest(DispositivaRequestDTO dispositivaRequestDTO) {

		InviaPropostaV2 inviaPropostaV2 = new InviaPropostaV2();
		PropostaCJPOSV2 propostaCJPOSV2 = new PropostaCJPOSV2();

		propostaCJPOSV2.setTipoChiamata("INS"); // costante
		propostaCJPOSV2.setCodiceOrigine("IN"); // costante
		propostaCJPOSV2.setRapportoReale("11653632401932571");
		propostaCJPOSV2.setAttributoRapporto("RB6324");
//		propostaCJPOSV2.setDatiProposta(anagraficaPropostaCJPOS);
//		propostaCJPOSV2.setDatiCliente(datiCliente);
		propostaCJPOSV2.setAttributiPricing(new WrapperMap());
		propostaCJPOSV2.getListaCondizioni().add(new CondizioneCJPOS());
//		inviaPropostaV2.setDatiProposta(propostaCJPOSV2);

//        <ns0:datiProposta>
//        <ns0:tipoChiamata>INS</ns0:tipoChiamata>
//        <ns0:codiceOrigine>IN</ns0:codiceOrigine>
//        <ns0:rapportoReale>11653632401932571</ns0:rapportoReale>
//        <ns0:attributoRapporto></ns0:attributoRapporto>
//        <!--lista dei profili in input al momento ignorata <ns0:profili>YAP9C1</ns0:profili>-->
//        <ns0:datiProposta>
//           <ns0:codiceAbiProposta>01025</ns0:codiceAbiProposta>
//           <ns0:annoProposta>2020</ns0:annoProposta>
//           <ns0:codiceTipoOperazione></ns0:codiceTipoOperazione>
//           <ns0:codiceOggettoProposta>01</ns0:codiceOggettoProposta>
//           <ns0:attributo>RB6324</ns0:attributo>
//           <ns0:matricolaProponente>U004835</ns0:matricolaProponente>
//           <!--U004835 Avonto Giovanni : UO: 01383-->
//           <ns0:uoProponente>01383</ns0:uoProponente>
//        </ns0:datiProposta>
//        <ns0:datiCliente>
//           <ns0:abiCliente></ns0:abiCliente>
//           <ns0:ndgCliente>2896811838000</ns0:ndgCliente>
//           <ns0:pivaCliente>02417880032</ns0:pivaCliente>
//           <ns0:uoGestore></ns0:uoGestore>
//           <ns0:nominativoCliente></ns0:nominativoCliente>
//        </ns0:datiCliente>
//        <ns0:attributiPricing/>
//        <ns0:listaCondizioni>
//           <ns0:codiceCondizione>03229</ns0:codiceCondizione>
//           <ns0:tipoDeroga>N</ns0:tipoDeroga>
//           <ns0:tipoValore>1</ns0:tipoValore>
//           <ns0:indPresenzaValProp>S</ns0:indPresenzaValProp>
//           <ns0:valoreProposto>100</ns0:valoreProposto>
//        </ns0:listaCondizioni>
		return inviaPropostaV2;
	}

	public void setIspWebservicesHeaderType(ISPWebservicesHeaderType ispWebservicesHeaderType) {
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

}
