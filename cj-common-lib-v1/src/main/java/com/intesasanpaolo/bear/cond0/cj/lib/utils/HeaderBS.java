package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HeaderBS {
	private int retCode;
	private String codicestato;
	private String idServizio;
	private String codiceTipoCanale;
	private String codiceSocieta;
	private String codiceSportello;
	private String codiceUoRich;
	private String codiceUserid;
	private String mqmNameDest;
	private String codRisRich;
	private String codRichCanale;
	private String dataCont;
	private int lunghezzaMsg;
	private String indMqSincrono;
	private String codTipoLingua;
	private String tipoSicApplInp;
	private String tipoSicApplOut;
	private String indCompressInp;
	private String indCompressOut;
	private String indRoutingMsg;
	private String codSsaServizio;
	private String indInoltroReply;
	private String codAbi;
	private String codAziendaDest;
	private String codOperativita;
	private String flagPaperless;
	private String flagRacf;
	private String codRicTrac;
	private String hspIndAtom;
	private String hspTrnAtom;
	private String hspPgmAtom;
	private String hspTimeout;
	private String hspAcronimo;
	private String hspFlag24X7;
	private String hspConvNull;
	private String hspAcronimoProvider;
	private String hspTimeiib;
	private String codBsm;
	private String sicTimestamp;
	private String sicKey;
	private String sicMac;
	private String codVersSic;
	private String codCliRich;
	private String codTermCics;
	private String codVersioneBs;
}
