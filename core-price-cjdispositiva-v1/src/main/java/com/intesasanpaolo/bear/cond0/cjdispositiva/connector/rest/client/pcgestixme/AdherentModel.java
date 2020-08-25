package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AdherentModel {
    private Integer id;

    private SubjectModel subject;

    private List<AdherentConsentModel> consents;
    private List<AdherentServiceModel> services;

    private LocalDate terminationDate;
    private LocalDate endValidityDate;
    private LocalDate startValidityDate;
    private LocalDate insertDate;
    private LocalDate activationDate;

    private Integer contractId;
    private AdherentStatusEnum adherentState;
    private AdherentTypeEnum role;
    private Integer adherentIndex;

    private String branchCC;
    private String instituteCC;
    private String iban;
    private String categoryCC;
    private String accountNumber;

    // Used in pmed
    private String operativity;
}
