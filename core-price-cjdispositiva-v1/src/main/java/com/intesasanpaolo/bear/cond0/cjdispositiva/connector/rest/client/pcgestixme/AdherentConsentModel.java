package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdherentConsentModel {

    private ConsentModel consent;

    private Integer subjectId;
    private Integer contractId;
    private Integer adherentId;
    private Boolean accorded;
    // consent code
    //private ConsentEnum code;
    // when the adherentConsent is inserted
    private LocalDate startValidityDate;
}
