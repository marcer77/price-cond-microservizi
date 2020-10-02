package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.command;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodApplEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodLinguaEnum;
import com.intesasanpaolo.bear.cond0.cj.lib.enums.CodProcessoEnum;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.InfoStampaDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.IntestatarioDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.RapportoDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.dto.StampaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource.StampaResponseResource;

@RunWith(SpringRunner.class)
public class CJDepositiAmministratiCommandTest {
	
	private StampaRequestDTO stampaRequestDTO;
	
	@Test
	public void testMock() {
		
		stampaRequestDTO = new StampaRequestDTO();

		stampaRequestDTO.setCodAppl(CodApplEnum.FIDI.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CARTE_AZIENDALI_PG.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setCodAppl(CodApplEnum.CARTE.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_CUI_DA.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setCodAppl(CodApplEnum.AREA_FINANZA.toString());
		stampaRequestDTO.setCodProcesso(CodProcessoEnum.CJ_AFFIDAMENTI.toString());
		stampaRequestDTO.isValidCodAppl(); //chiamata explicita per copertura codice
		stampaRequestDTO.isValidCodProcesso(); //chiamata explicita per copertura codice
		stampaRequestDTO.setRapporto(new RapportoDTO("12345", "1234", "12345678", "att"));
		stampaRequestDTO.setIntestatario(new IntestatarioDTO("1234567890123", "mock di test", "P"));
		stampaRequestDTO.setInfoStampa(new InfoStampaDTO(new Date(), "T", CodLinguaEnum.TEDESCO.toString()));
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.FRANCESE.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.INGLESE.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.SPAGNOLO.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		stampaRequestDTO.getInfoStampa().setCodLingua(CodLinguaEnum.ITALIANO.toString());
		stampaRequestDTO.getInfoStampa().isValidCodLingua();
		
		CJDepositiAmministratiCommand depositiAmministratiCommand=new CJDepositiAmministratiCommand();
		depositiAmministratiCommand.setStampaRequestDTO(stampaRequestDTO);
		StampaResponseResource res=depositiAmministratiCommand.buildStampaResponseResourceMock();
		Assert.assertTrue(res.getEsitoStampaResource()!=null);
	}
}
