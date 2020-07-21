package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdesioneResponseAdesioneDettaglio {
     private String flagRequisito;
     private String indicatoreRequisito;
     private String valoreAlfanumericoRequisito;
     private BigDecimal valoreNumericoRequisisto;
}
