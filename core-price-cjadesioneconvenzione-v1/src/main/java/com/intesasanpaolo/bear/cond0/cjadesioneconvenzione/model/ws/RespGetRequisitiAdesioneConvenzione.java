package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws;

import java.util.List;


import lombok.Data;


@Data
public class RespGetRequisitiAdesioneConvenzione {

    
    private String esitoErrorMessage;
    
    private String responseLogHasError;
    private String responseLogResultSize;
    private String reponseLogErrorDescription;
    
    private List<AdesioneResponseBenefici> tabellaBenefici;
    
    private Integer tabellaBeneficiLength;
    
    protected List<AdesioneResponseAdesioneDettaglio> tabellaRequisiti;
    
    protected Integer tabellaRequisitiLength;
    
}