package com.intesasanpaolo.bear.cond0.cjdispositiva.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputArea;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.InputDatiInputAreaRapportoAccessorio;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountDatiInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme.NewAccountInput.Input;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.AnagraficaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.DatiCliente;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.ParametroCondizioneDeroga;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.PropostaCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaPropostaRequest;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.ValoriPercParametri;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.WrapperMap;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.RapportoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.TassoEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.Covenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqRollbackStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;

public class WsRequestFactory {
	
	private Logger log = Logger.getLogger(WsRequestFactory.class);
	
	public InviaPropostaV2 assemblaRequestInviaProposta(String codAbi, String codUnitaOperativa, AdesioneEntity adesione,RapportoEntity rapporto,List<TassoEntity> tassiAbbattuti) {
		log.info("assemblaRequestInviaProposta START");
		InviaPropostaV2 inviaPropostaV2 = new InviaPropostaV2();
		PropostaCJPOSV2 propostaCJPOSV2 = new PropostaCJPOSV2();
		propostaCJPOSV2.setTipoChiamata("INS"); // costante
		propostaCJPOSV2.setCodiceOrigine("CJ"); // costante
		propostaCJPOSV2.setRapportoReale(rapporto.getFiliale()+rapporto.getCategoria()+rapporto.getNumero());
		propostaCJPOSV2.setAttributoRapporto(tassiAbbattuti!=null && tassiAbbattuti.size()>0 ? tassiAbbattuti.get(0).getAttributoRP() : null); //Dalle verifiche sono tutti uguali quindi basta il primo
		
		AnagraficaPropostaCJPOS anagrafica = new AnagraficaPropostaCJPOS();
		anagrafica.setCodiceAbiProposta(codAbi);
		
		String annoProposta = "";
		DatiCliente datiCliente = new DatiCliente();
		if(adesione!=null) {
			
			datiCliente.setNdgCliente(adesione.getIntestatarioNDG());
			datiCliente.setNominativoCliente(adesione.getIntestatazione());
			datiCliente.setCfCliente(adesione.getIntestatarioCodFiscale());
			datiCliente.setPivaCliente(adesione.getIntestatarioPIVA());
		
			if(adesione.getInfoStampaData()!=null) {
				annoProposta = adesione.getInfoStampaData();
				if(adesione.getInfoStampaData().length()>=4) {
					annoProposta = adesione.getInfoStampaData().substring(0,4);
				}
			}
			

		}
		anagrafica.setAnnoProposta(annoProposta);
		anagrafica.setCodiceTipoOperazione("N");
		anagrafica.setCodiceOggettoProposta("01");
		anagrafica.setMatricolaProponente("AUTODEL");
		anagrafica.setUoProponente(codUnitaOperativa);
		propostaCJPOSV2.setDatiProposta(anagrafica);

		datiCliente.setAbiCliente(codAbi);

		propostaCJPOSV2.setDatiCliente(datiCliente);
		
		propostaCJPOSV2.setAttributiPricing(new WrapperMap());
		
		if(CollectionUtils.isNotEmpty(tassiAbbattuti)) {
			for(TassoEntity tasso : tassiAbbattuti) {
				CondizioneCJPOS condizione = new CondizioneCJPOS() ;
				condizione.setCodiceCondizione(tasso.getCodCondizioneTX());
				condizione.setTipoDeroga("N");
				condizione.setTipoValore("1");
				condizione.setIndPresenzaValApp("S");
				condizione.setValoreProposto(tasso.getValoreSprdTX().toString());
				condizione.setDataInizioProposto(tasso.getDecaCdzTX());
				condizione.setDataFineProposto(tasso.getDecaCdzTX());
				if("P".equals(tasso.getTipoValCdzTX())) {
					ParametroCondizioneDeroga parametroCondizioneDerogaProposto = new ParametroCondizioneDeroga();
					parametroCondizioneDerogaProposto.setSegnoSpread(tasso.getSegnoSpreadTX());
					parametroCondizioneDerogaProposto.setSpread(tasso.getValoreSprdTX().doubleValue());
					ValoriPercParametri valoriPercParametri = new ValoriPercParametri();
					valoriPercParametri.setCodiceParametro(tasso.getCdParamTX());
					valoriPercParametri.setValoreParametro(tasso.getPercApplParTX().doubleValue());
					parametroCondizioneDerogaProposto.getValoriPercParametri().add(valoriPercParametri);
					condizione.setParametroCondizioneDerogaProposto(parametroCondizioneDerogaProposto);
				}
				propostaCJPOSV2.getListaCondizioni().add(condizione);
			}
		}

		inviaPropostaV2.setDatiProposta(propostaCJPOSV2);
		log.info("assemblaRequestInviaProposta END");
		return inviaPropostaV2;
	}
	
	public RevocaProposta assemblaRequestRevocaProposta(String codAbi, String annoProposta, String codiceProposta, String dataRespinta,String userId,String codUnitaOperativa ) {
		log.info("assemblaRequestRevocaProposta START");
		RevocaProposta revocaProposta = new RevocaProposta();
		RevocaPropostaRequest revocaPropostaRequest = new RevocaPropostaRequest();
		revocaPropostaRequest.setAnnoProposta(annoProposta);
		revocaPropostaRequest.setCodiceAbiProposta(codAbi);
		revocaPropostaRequest.setCodiceProposta(codiceProposta);
		revocaPropostaRequest.setDataRespinta(dataRespinta);
		revocaPropostaRequest.setMatricolaRespinta(userId);
		revocaPropostaRequest.setNoteRespinta("ANNULLO DISPOSITIVA CJ");
		revocaPropostaRequest.setUoRespinta(codUnitaOperativa);
		revocaProposta.setDatiProposta(revocaPropostaRequest);
		log.info("assemblaRequestRevocaProposta END");
		return revocaProposta;
	}
	
	//per annullo
	public ReqRollbackStoreCovenantAdesioneConvenzione assemblaRequestConvenzione(InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("assemblaRequestConvenzione START");
		ReqRollbackStoreCovenantAdesioneConvenzione request = new ReqRollbackStoreCovenantAdesioneConvenzione();
		log.info("assemblaRequestConvenzione END");
		return request;
	}
	
	public ReqStoreCovenantAdesioneConvenzione assemblaRequestConvenzione(AdesioneEntity adesione, List<CovenantEntity> covenantDaAttivare, List<CovenantEntity> covenantDaCessare, String codAbi, String codProcesso, String branchCode , String userId) {
		log.info("assemblaRequestConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = new ReqStoreCovenantAdesioneConvenzione();
		
		request.setAbi(codAbi);
		request.setApplicativoId(codProcesso);
		request.setCodiceConvenzione(adesione.getCodConvenzione());
//		request.setCodiceConvenzioneOld(codiceConvenzioneOld);
		request.setDataProposta(adesione.getInfoStampaData());
		request.setDataOperazione(adesione.getInfoStampaData());
		request.setFilialeUserId(branchCode);
		request.setIdProdottoCovenant("03");
		
		List<Covenant> listaCovenantDaAttivare = new ArrayList<Covenant>();
		
		if(CollectionUtils.isNotEmpty(covenantDaAttivare)) {
			log.info("Covenant da ATTIVARE: "+ covenantDaAttivare.size());
			for(CovenantEntity covenantEntity :covenantDaAttivare) {
				
				Covenant covenant = new Covenant();
				
				covenant.setBeneficioCondizionatoDataFine(covenantEntity.getBeneficioCondizionatoDataFine());
				covenant.setBeneficioCondizionatoDataInizio(covenantEntity.getBeneficioCondizionatoDataInizio());
				covenant.setBeneficioIncondizionatoDataFine(covenantEntity.getBeneficioIncondizionatoDataFine());
				covenant.setBeneficioIncondizionatoDatainizio(covenantEntity.getBeneficioIncondizionatoDatainizio());
				covenant.setBeneficioIncondizionatoNumRilevazioni(covenantEntity.getBeneficioIncondizionatoNumRilevazioni());
				covenant.setBeneficioIncondizionatoPresente(covenantEntity.getBeneficioIncondizionatoPresente());
				covenant.setBeneficioIngressoDataFine(covenantEntity.getBeneficioIngressoDataFine());
				covenant.setBeneficioIngressoDataInizio(covenantEntity.getBeneficioIngressoDataInizio());
				covenant.setBeneficioIngressoPresente(covenantEntity.getBeneficioIngressoPresente());
				covenant.setCodCondizione(covenantEntity.getCodCondizione());
				covenant.setCovenantDataFine(covenantEntity.getCovenantDataFine());
				covenant.setCovenantDataInizio(covenantEntity.getCovenantDataInizio());
				covenant.setFlagEntitaPrincipale(covenantEntity.getFlagEntitaPrincipale());
				covenant.setProgressivo(covenantEntity.getProgressivo());
				covenant.setRapportoCategoria(covenantEntity.getRapportoCategoria());
				covenant.setRapportoConto(covenantEntity.getRapportoConto());
				covenant.setRapportoFiliale(covenantEntity.getRapportoFiliale());
				covenant.setCodiceTemplate(covenantEntity.getCodiceTemplate());
				covenant.setCondizioniFiglie(covenantEntity.getCondizioniFiglie());
				covenant.setLivelloGerarchia(covenantEntity.getLivelloGerarchia());
				covenant.setVersioneTemplate(covenantEntity.getVersioneTemplate());
				
				listaCovenantDaAttivare.add(covenant);
			}
		}
		request.setListaCovenantDaAttivare(listaCovenantDaAttivare);
		
		List<Covenant> listaCovenantDaCessare = new ArrayList<Covenant>();
		
		if(CollectionUtils.isNotEmpty(covenantDaCessare)) {
			log.info("Covenant da CESSARE: "+ covenantDaCessare.size());
			for(CovenantEntity covenantEntity :covenantDaCessare) {
				
				Covenant covenant = new Covenant();
				
				covenant.setBeneficioCondizionatoDataFine(covenantEntity.getBeneficioCondizionatoDataFine());
				covenant.setBeneficioCondizionatoDataInizio(covenantEntity.getBeneficioCondizionatoDataInizio());
				covenant.setBeneficioIncondizionatoDataFine(covenantEntity.getBeneficioIncondizionatoDataFine());
				covenant.setBeneficioIncondizionatoDatainizio(covenantEntity.getBeneficioIncondizionatoDatainizio());
				covenant.setBeneficioIncondizionatoNumRilevazioni(covenantEntity.getBeneficioIncondizionatoNumRilevazioni());
				covenant.setBeneficioIncondizionatoPresente(covenantEntity.getBeneficioIncondizionatoPresente());
				covenant.setBeneficioIngressoDataFine(covenantEntity.getBeneficioIngressoDataFine());
				covenant.setBeneficioIngressoDataInizio(covenantEntity.getBeneficioIngressoDataInizio());
				covenant.setBeneficioIngressoPresente(covenantEntity.getBeneficioIngressoPresente());
				covenant.setCodCondizione(covenantEntity.getCodCondizione());
				covenant.setCovenantDataFine(covenantEntity.getCovenantDataFine());
				covenant.setCovenantDataInizio(covenantEntity.getCovenantDataInizio());
				covenant.setFlagEntitaPrincipale(covenantEntity.getFlagEntitaPrincipale());
				covenant.setProgressivo(covenantEntity.getProgressivo());
				covenant.setRapportoCategoria(covenantEntity.getRapportoCategoria());
				covenant.setRapportoConto(covenantEntity.getRapportoConto());
				covenant.setRapportoFiliale(covenantEntity.getRapportoFiliale());
				covenant.setCodiceTemplate(covenantEntity.getCodiceTemplate());
				covenant.setCondizioniFiglie(covenantEntity.getCondizioniFiglie());
				covenant.setLivelloGerarchia(covenantEntity.getLivelloGerarchia());
				covenant.setVersioneTemplate(covenantEntity.getVersioneTemplate());
				
				listaCovenantDaCessare.add(covenant);
			}
		}
		request.setListaCovenantDaCessare(listaCovenantDaCessare);
		
		request.setNsg(adesione.getIntestatarioNDG());
//		request.setNumeroProposta(numeroProposta);
		request.setTipoOperazione("A");
		request.setUserId(userId);
		
		log.info("assemblaRequestConvenzione END");
		return request;
	}

	public NewAccountInput assemblaRequestGestione(String codFunzione, DispositivaRequestDTO dispositivaRequestDTO, AdesioneEntity adesione, String codFilDipendente, String codCanale) {
		log.info("assemblaRequestGestione START");
		NewAccountInput newAccountInput = new NewAccountInput();
		
		Input input = new Input();
		
		NewAccountDatiInput newAccountDatiInput = new NewAccountDatiInput();
		
		InputDatiInputArea inputDatiInputArea = new InputDatiInputArea();
		
		inputDatiInputArea.setNumPromozioni("0"); //necessario inizializzare, quindi inserisco 0
		
		InputDatiInputAreaRapportoAccessorio rapportoAccessorio = new InputDatiInputAreaRapportoAccessorio();
		
		inputDatiInputArea.setRapportoAccessorio(rapportoAccessorio);
		
		newAccountDatiInput.setArea(inputDatiInputArea);
		
		input.setDatiInput(newAccountDatiInput);
		
		newAccountInput.setInput(input);

		newAccountInput.getInput().getDatiInput().setFunzione(codFunzione);
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setFiLRappAcc(adesione.getRapportoCodFiliale());
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setCaTRappAcc(adesione.getRapportoCodCategoria());
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setNumProgRappAcc(adesione.getRapportoCodProgressivo());
		
		newAccountInput.getInput().getDatiInput().getArea().setCodFilDipendente(codFilDipendente);
		
		newAccountInput.getInput().getDatiInput().getArea().setDataRiferimento(adesione.getInfoStampaData());
		
		newAccountInput.getInput().getDatiInput().getArea().setCodCanale(codCanale);
		
		newAccountInput.getInput().setNumSuperPratica(dispositivaRequestDTO.getPratica().getCodSuperPratica());
		
		newAccountInput.getInput().setNumPratica(dispositivaRequestDTO.getPratica().getCodPratica());
		
		log.info("assemblaRequestGestione END");
		return newAccountInput;
	}
	
	
}
