package com.intesasanpaolo.bear.bear_v3.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.CondizioneConto;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.CondizioneContoDettaglio;
import com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd.InquiryContoCndRequest;

@RunWith(SpringRunner.class)
public class InquiryContoCndDettaglioCommandTest {

	@Test
	public void testCalcolaValorePromo01() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdTipoLivello("P");
		cond.setNrValore(new BigDecimal("1"));
		BigDecimal res=cmd.calcolaValorePromo(cond, new BigDecimal("10"), null);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo02() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdTipoCndTec("S");
		cond.setCdTipoLivello("P");
		cond.setNrValore(new BigDecimal("1"));
		BigDecimal res=cmd.calcolaValorePromo(cond, new BigDecimal("10"), null);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo03() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdTipoLivello("P");
		cond.setCdTipoCndTec("D");		
		cond.setNrValore(new BigDecimal("1"));
		BigDecimal res=cmd.calcolaValorePromo(cond, new BigDecimal("10"), null);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo04() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdTipoLivello("P");
		cond.setCdTipoCndTec("D");		
		cond.setNrValore(new BigDecimal("1"));
		List<CondizioneContoDettaglio> condizioneDip=new ArrayList<CondizioneContoDettaglio>();
		CondizioneContoDettaglio ccd=new CondizioneContoDettaglio();
		ccd.setNrValore(new BigDecimal("2"));
		BigDecimal res=cmd.calcolaValorePromo(cond, new BigDecimal("10"), condizioneDip);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo05() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdCnd("01234");		
		cond.setCdTipoLivello("P");
		cond.setCdTipoCndTec("D");		
		cond.setNrValore(new BigDecimal("1"));
		List<CondizioneContoDettaglio> condizioneDip=new ArrayList<CondizioneContoDettaglio>();
		CondizioneContoDettaglio ccd=new CondizioneContoDettaglio();
		ccd.setNrValore(new BigDecimal("2"));
		ccd.setCdCnd("01234");
		condizioneDip.add(ccd);
		BigDecimal res=cmd.calcolaValorePromo(cond, null, condizioneDip);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo07() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdCnd("01234");		
		cond.setCdTipoLivello("P");
		cond.setCdTipoCndTec("S");		
		cond.setNrValore(new BigDecimal("1"));
		List<CondizioneContoDettaglio> condizioneDip=new ArrayList<CondizioneContoDettaglio>();
		CondizioneContoDettaglio ccd=new CondizioneContoDettaglio();
		ccd.setNrValore(new BigDecimal("2"));
		ccd.setCdCnd("01234");
		condizioneDip.add(ccd);
		BigDecimal res=cmd.calcolaValorePromo(cond, null, condizioneDip);
		assertTrue(res.intValue()>0);
	}
	
	@Test
	public void testCalcolaValorePromo06() {
		InquiryContoCndRequest request=new InquiryContoCndRequest();
		InquiryContoCndDettaglioCommand cmd=new InquiryContoCndDettaglioCommand(request);
		CondizioneConto cond=new CondizioneConto();
		cond.setCdTipoLivello("P");
		cond.setNrValore(new BigDecimal("1"));
		BigDecimal res=cmd.calcolaValorePromo(cond,null, null);
		assertTrue(res.intValue()>0);
	}
	
	/*protected BigDecimal calcolaValorePromo(CondizioneConto cond, BigDecimal prezzoRif,
			List<CondizioneContoDettaglio> condizioneDip) {

		logger.info("Start calcolaValorePromo with: ");
		// stampa ogni singolo oggetto complesso
		//logger.info("1 - cond = {}", stampaOggettoWithParentClass(cond));
		//logger.info("2 - prezzoRif = {}", prezzoRif);
		//logger.info("3 - condizioneDip: {}", stampaCondizioneContoDettaglioList(condizioneDip));

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

		logger.info("End calcolaValorePromo --->{}", valCalcolatoPro);

		return valCalcolatoPro;
	}*/
	
}
