package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespGetRequisitiAdesioneConvenzione {

    private String esitoResultCode;
    private String esitoErrorMessage;
    
    private Boolean responseLogHasError;
    private Long responseLogResultSize;
    private String reponseLogErrorDescription;
    
    private List<AdesioneResponseBenefici> tabellaBenefici;
    
    private Integer tabellaBeneficiLength;
    
    protected List<AdesioneResponseAdesioneDettaglio> tabellaRequisiti;
    
    protected Integer tabellaRequisitiLength;
    
}