package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.transformers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTBST;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTESI;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTHEADER;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.OUTSEG;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutCNF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRAF;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRAP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRC4;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRCZ;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRNO;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRPR;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutRTS;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.OutSTP;
import com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.wkcj.WKCJResponse;
import com.intesasanpaolo.bear.connector.ctg.response.CtgConnectorResponse;
import com.intesasanpaolo.bear.connector.ctg.transformer.ICtgResponseTransformer;

@Service
public class WKCJCtgResponseTansformer implements ICtgResponseTransformer<C_WKCJS00, WKCJResponse> {

	private static <T> boolean hasSomething(T[] objArray) {
		return objArray != null && objArray.length > 0 && objArray[0] != null;
	}

	@Override
	public WKCJResponse transform(CtgConnectorResponse<C_WKCJS00> ctgResponse) {
		C_WKCJS00 connector = ctgResponse.getResult();

		OUTHEADER outHeader = hasSomething(connector.OUTHEADER) ? connector.OUTHEADER[0] : new OUTHEADER();

		OUTBST outBody = hasSomething(connector.OUTBST) ? connector.OUTBST[0] : new OUTBST();
		OUTESI outEsi = hasSomething(connector.OUTESI) ? connector.OUTESI[0] : new OUTESI();
		OUTSEG outSeg = hasSomething(connector.OUTSEG) ? connector.OUTSEG[0] : new OUTSEG();

		List<OutCNF> outCNFList=new ArrayList<OutCNF>();
		if (hasSomething(outBody.OUTCNF)) {
			Arrays.asList(outBody.OUTCNF).forEach(out->{
				OutCNF outCNF=OutCNF.builder().codCnd(out.COD_CND).build();
				outCNFList.add(outCNF);
			});
		}
		
		List<OutRAF> outRAFList=new ArrayList<OutRAF>();
		if (hasSomething(outBody.OUTRAF)) {
			Arrays.asList(outBody.OUTRAF).forEach(out->{
				OutRAF outRAF=OutRAF.builder()
						.codDds(out.COD_DDS)
						.codDip(out.COD_DIP)
						.codPar(out.COD_PAR)
						.codSet(out.COD_SET)
						.numRap(out.NUM_RAP)
						.prgInv(out.PRG_INV)
						.build();
				outRAFList.add(outRAF);
			});
		}
		
		List<OutRAP> outRAPList=new ArrayList<OutRAP>();
		if (hasSomething(outBody.OUTRAP)) {
			Arrays.asList(outBody.OUTRAP).forEach(out->{
				OutRAP outRAP=OutRAP.builder()
						.dds(out.DDS)
						.prgInv(out.PRG_INV)
						.build();
				outRAPList.add(outRAP);
			});
		}
		
		List<OutSTP> outSTPList=new ArrayList<OutSTP>();
		if (hasSomething(outBody.OUTSTP)) {
			
			List<OutRC4> outRC4List=new ArrayList<>();
			List<OutRCZ> outRCZList=new ArrayList<>();
			List<OutRNO> outRNOList=new ArrayList<>();
			List<OutRPR> outRPRList=new ArrayList<>();
			List<OutRTS> outRTSList=new ArrayList<>();
			
			Arrays.asList(outBody.OUTSTP).forEach(out->{
				
				
				if (hasSomething(out.OUTRC4)) {
					Arrays.asList(out.OUTRC4).forEach(tmp->{
						OutRC4 outRC4=OutRC4.builder()
								.campi41(tmp.CAMPI4_1)
								.campi42(tmp.CAMPI4_2)
								.campi43(tmp.CAMPI4_3)
								.campi44(tmp.CAMPI4_4)
								.build();
						outRC4List.add(outRC4);
					});
				}
				if (hasSomething(out.OUTRCZ)) {
					Arrays.asList(out.OUTRCZ).forEach(tmp->{
						OutRCZ outRCZ=OutRCZ.builder()
								.dataDeco(tmp.DATA_DECO)
								.descrCdz(tmp.DESCR_CDZ)
								.evidDescr(tmp.EVID_DESCR)
								.evidDtdec(tmp.EVID_DTDEC)
								.evidNota(tmp.EVID_NOTA)
								.evidVal(tmp.EVID_VAL)
								.indNota(tmp.IND_NOTA)
								.valore(tmp.VALORE)
								.build();
							
						outRCZList.add(outRCZ);
					});
				}
				if (hasSomething(out.OUTRNO)) {
					Arrays.asList(out.OUTRNO).forEach(tmp->{
						OutRNO outRNO=OutRNO.builder()
								.evidNrNota(tmp.EVID_NR_NOTA)
								.evidTxNota(tmp.EVID_TX_NOTA)
								.numNota(tmp.NUM_NOTA)
								.txNota(tmp.TX_NOTA)
								.build();
							
						outRNOList.add(outRNO);
					});
				}
				if (hasSomething(out.OUTRPR)) {
					Arrays.asList(out.OUTRPR).forEach(tmp->{
						OutRPR outRPR=OutRPR.builder()
								.testoProm(tmp.TESTO_PROM)
								.build();
						outRPRList.add(outRPR);
					});
				}
				if (hasSomething(out.OUTRTS)) {
					Arrays.asList(out.OUTRTS).forEach(tmp->{
						OutRTS outRTS=OutRTS.builder()
								.evidTesto(tmp.EVID_TESTO)
								.testo(tmp.TESTO)
								.build();
							
						outRTSList.add(outRTS);
					});
				}
				
				OutSTP outSTP=OutSTP
						.builder()
						.flContinua(out.FL_CONTINUA)
						.keyPrecontr(out.KEY_PRECONTR)
						.progrStp(out.PROGR_STP)
						.progStrut(out.PROG_STRUT)
						.tipoSez(out.TIPO_SEZ)
						.tipoStrut(out.TIPO_STRUT)
						.outRC4List(outRC4List)
						.outRNOList(outRNOList)
						.outRCZList(outRCZList)
						.outRPRList(outRPRList)
						.outRTSList(outRTSList)
						.build();
				
				outSTPList.add(outSTP);
				
				
				
			});
			
		}
		
		
		
		return WKCJResponse.builder()
				.esito(outEsi.ESITO)
				.livelloSegnalazione(outSeg.LIVELLO_SEGNALAZIONE)
				.txtSegnalazione(outSeg.TXT_SEGNALAZIONE)
				.flCnf(outBody.FL_CNF)
				.flRaf(outBody.FL_RAF)
				.flRap(outBody.FL_RAP)
				.flStp(outBody.FL_STP)
				.retCode(outBody.RET_CODE)
				.outCNFList(outCNFList)
				.outRAFList(outRAFList)
				.outRAPList(outRAPList)
				.outSTPList(outSTPList)
				.build();
	}

}
