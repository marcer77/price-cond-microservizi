package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.utils.JUnitUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InputStampaValCampiRapporto_Test extends JUnitUtils {

	private Logger log = Logger.getLogger(InputStampaValCampiRapporto_Test.class);

	private InputStampaDTO inputStampaDTO;

	private String codAppl = "Codice appl di test";
	private String codProcesso = "Codice processo di test";
	private PraticaDTO praticaDTO;
	private RapportoDTO rapportoDTO;
	private IntestatarioDTO intestatarioDTO;
	private List<FirmatarioDTO> listaFirmatari;
	public int numFirmatari;
	private InfoStampaDTO infoStampa;

	@Before
	public void setUp() {
	}
	
	@Before
	public void initMocks() throws Exception {

		inputStampaDTO = new InputStampaDTO();
		inputStampaDTO.setCodAppl(codAppl);
		inputStampaDTO.setCodProcesso(codProcesso);

		praticaDTO = new PraticaDTO();
		praticaDTO.setCodSuperPratica("1234561234");
		praticaDTO.setCodPratica("1234561234");
		praticaDTO.setCodPropostaComm("1234561234123");
		inputStampaDTO.setPratica(praticaDTO);
		
		rapportoDTO = new RapportoDTO();
		rapportoDTO.setCodFiliale("12345");
		rapportoDTO.setCodCategoria("1234");
		rapportoDTO.setCodProgressivo("12345678");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		intestatarioDTO = new IntestatarioDTO();
		
		intestatarioDTO.setNdg("1234561234560");
		intestatarioDTO.setIntestazione("Intestazione di test");
		intestatarioDTO.setSpecieGiur("PERSO");
		intestatarioDTO.setCodFiscale("RSSMRA80A01H703F");
		intestatarioDTO.setPIVA("12345678901");

		ArrayList<RecapitoDTO> recapiti = new ArrayList<RecapitoDTO>();

		RecapitoDTO recapitoDTO = new RecapitoDTO();
		recapitoDTO.setTipo("test tipo");
		recapitoDTO.setIndirizzo("via dei test");
		recapitoDTO.setCap("00000");
		recapitoDTO.setComune("Comune di test");
		recapitoDTO.setFrazione("Frazione di test");
		recapitoDTO.setProvincia("TE");
		recapiti.add(recapitoDTO);

		intestatarioDTO.setRecapiti(recapiti);
		
		inputStampaDTO.setIntestatario(intestatarioDTO);

		listaFirmatari = new ArrayList<FirmatarioDTO>();

		for (int i = 0; i < 13; i++) {
			listaFirmatari.add(new FirmatarioDTO("1234561234560","Intestazione di test"));
		}

		inputStampaDTO.setFirmatari(listaFirmatari);

		infoStampa = new InfoStampaDTO();
		infoStampa.setData(new Date(System.currentTimeMillis()));
		infoStampa.setTipoStampa("Stampa di test");
		infoStampa.setTipoOfferta("Offerta di test");
		infoStampa.setTipoFirma("Firma di test");
		infoStampa.setCodLingua("Lingua di test");
		infoStampa.setKeyOper("123456789012345678901234567890");
		
		inputStampaDTO.setInfoStampa(infoStampa);

	}
	
	/*
	Caso di test per cod processo CJ_AFFIDAMENTI 
	vanno rispettate le seguenti regole di validazione:
	- CodFiliale obbligatorio numerico a 5 cifre
	- CodCategoria obbligatorio numerico a 4 cifre
	- CodProgressivo obbligatorio numerico a 8 cifre
	*/
	@Test
	public void testCampiRapportoOK() {
		
		//Valorizzazione corretta in caso di CJAFF
		inputStampaDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
		RapportoDTO rapportoDTO = new RapportoDTO();
		rapportoDTO.setCodFiliale("12345");
		rapportoDTO.setCodCategoria("1234");
		rapportoDTO.setCodProgressivo("12345678");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		boolean esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertTrue(esito);
		
		
		//Valorizzazione NON corretta per altri tipi di processo NON CJ_AFFIDAMENTI
		inputStampaDTO.setCodProcesso(codProcesso);
		
		rapportoDTO.setCodFiliale("");
		rapportoDTO.setCodCategoria("");
		rapportoDTO.setCodProgressivo("");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertTrue(esito);
		
		rapportoDTO.setCodFiliale("1");
		rapportoDTO.setCodCategoria("1");
		rapportoDTO.setCodProgressivo("1");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertTrue(esito);
		
		rapportoDTO.setCodFiliale("TEST");
		rapportoDTO.setCodCategoria("TEST");
		rapportoDTO.setCodProgressivo("TEST");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertTrue(esito);
		
		rapportoDTO.setCodFiliale(null);
		rapportoDTO.setCodCategoria(null);
		rapportoDTO.setCodProgressivo(null);
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertTrue(esito);

	}
	
	@Test
	public void testCampiRapportoKO() {

		inputStampaDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		
		//Valorizzazione NON corretta per altri tipi di processo NON CJ_AFFIDAMENTI
		
		rapportoDTO.setCodFiliale("");
		rapportoDTO.setCodCategoria("");
		rapportoDTO.setCodProgressivo("");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		boolean esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertFalse(esito);
		
		rapportoDTO.setCodFiliale("1");
		rapportoDTO.setCodCategoria("1");
		rapportoDTO.setCodProgressivo("1");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();
		
		Assert.assertFalse(esito);
		
		rapportoDTO.setCodFiliale("123456");
		rapportoDTO.setCodCategoria("12345");
		rapportoDTO.setCodProgressivo("123456789");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertFalse(esito);
		
		rapportoDTO.setCodFiliale("TEST");
		rapportoDTO.setCodCategoria("TEST");
		rapportoDTO.setCodProgressivo("TEST");
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertFalse(esito);
		
		rapportoDTO.setCodFiliale(null);
		rapportoDTO.setCodCategoria(null);
		rapportoDTO.setCodProgressivo(null);
		inputStampaDTO.setRapporto(rapportoDTO);
		
		esito = inputStampaDTO.isValidCampiRapporto();

		Assert.assertFalse(esito);

	}

}
