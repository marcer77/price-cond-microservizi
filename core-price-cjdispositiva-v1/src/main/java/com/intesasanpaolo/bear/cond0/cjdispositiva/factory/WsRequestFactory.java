package com.intesasanpaolo.bear.cond0.cjdispositiva.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;

import com.intesasanpaolo.bear.cond0.cjdispositiva.command.CJDispositivaAnnulloCommand;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.InputDatiInputArea;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.InputDatiInputAreaRapportoAccessorio;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountDatiInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme.NewAccountInput.Input;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.PropostaCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.RevocaProposta;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.WrapperMap;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.InformazioniPraticaDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.AdesioneEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.CovenantEntity;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.Covenant;
import com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws.ReqStoreCovenantAdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;

public class WsRequestFactory {
	
	private Logger log = Logger.getLogger(WsRequestFactory.class);
	
	public InviaPropostaV2 assemblaRequestInviaProposta(InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("assemblaRequestInviaProposta START");
		InviaPropostaV2 inviaPropostaV2 = new InviaPropostaV2();
		PropostaCJPOSV2 propostaCJPOSV2 = new PropostaCJPOSV2();
		propostaCJPOSV2.setTipoChiamata("INS"); // costante
		propostaCJPOSV2.setCodiceOrigine("IN"); // costante
		propostaCJPOSV2.setRapportoReale("11653632401932571");
		propostaCJPOSV2.setAttributoRapporto("RB6324");
		propostaCJPOSV2.setDatiProposta(informazioniPraticaDTO.getAnagraficaPropostaCJPOS());
		propostaCJPOSV2.setDatiCliente(informazioniPraticaDTO.getDatiCliente());
		propostaCJPOSV2.setAttributiPricing(new WrapperMap());
		propostaCJPOSV2.getListaCondizioni().add(new CondizioneCJPOS());
		inviaPropostaV2.setDatiProposta(propostaCJPOSV2);
		log.info("assemblaRequestInviaProposta END");
		return ProposteCJPOSWSUtils._buildMockInviaPropostaV2();
	}
	
	public RevocaProposta assemblaRequestRevocaProposta(InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("assemblaRequestRevocaProposta START");
		log.info("assemblaRequestRevocaProposta END");
		return ProposteCJPOSWSUtils._buildMockRevocaProposta();
	}
	
	//per annullo
	public ReqStoreCovenantAdesioneConvenzione assemblaRequestConvenzione(InformazioniPraticaDTO informazioniPraticaDTO) {
		log.info("assemblaRequestConvenzione START");
		ReqStoreCovenantAdesioneConvenzione request = new ReqStoreCovenantAdesioneConvenzione();
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

	public NewAccountInput assemblaRequestGestione(DispositivaRequestDTO dispositivaRequestDTO, AdesioneEntity adesione, String codFilDipendente, String codCanale) {
		log.info("assemblaRequestGestione START");
		NewAccountInput newAccountInput = new NewAccountInput();
		
		Input input = new Input();
		
		NewAccountDatiInput newAccountDatiInput = new NewAccountDatiInput();
		
		InputDatiInputArea inputDatiInputArea = new InputDatiInputArea();
		
		InputDatiInputAreaRapportoAccessorio rapportoAccessorio = new InputDatiInputAreaRapportoAccessorio();
		
		inputDatiInputArea.setRapportoAccessorio(rapportoAccessorio);
		
		newAccountDatiInput.setArea(inputDatiInputArea);
		
		input.setDatiInput(newAccountDatiInput);
		
		newAccountInput.setInput(input);

		newAccountInput.getInput().getDatiInput().setFunzione(dispositivaRequestDTO.getCodProcesso());
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setFiLRappAcc(adesione.getRapportoCodFiliale());
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setCaTRappAcc(adesione.getRapportoCodCategoria());
		
		newAccountInput.getInput().getDatiInput().getArea().getRapportoAccessorio().setNumProgRappAcc(adesione.getRapportoCodProgressivo());
		
		newAccountInput.getInput().getDatiInput().getArea().setCodFilDipendente(codFilDipendente);
		
		newAccountInput.getInput().getDatiInput().getArea().setDataRiferimento(adesione.getInfoStampaData());
		
		newAccountInput.getInput().getDatiInput().getArea().setCodCanale(codCanale);
		
		newAccountInput.getInput().setNumSuperPratica(dispositivaRequestDTO.getPraticaDTO().getCodSuperPratica());
		
		newAccountInput.getInput().setNumPratica(dispositivaRequestDTO.getPraticaDTO().getCodPratica());
		
		log.info("assemblaRequestGestione END");
		return newAccountInput;
	}
	
	
}
