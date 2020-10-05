package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubjectModel {

    private Integer id;
    private String abi;
    private String fiscalCode;
    private String birthMunicipalityCode;
    private String birthNationCode;
    private String lastName;
    private String birthMunicipality;
    private LocalDate birthDate;
    private String instituteCode;
    private String birthNation;
    private String name;
    private String nsg;
    private String birthProvince;
    private String personType;
    private boolean pIva;
    private boolean validIdentifyingDoc;

    private String residenceMunicipality;
    private String residenceProvince;
    private String residenceToponym;
    private String residenceAddress;
    private String residenceCivic;
    private String residencePostalCode;
    private String residenceMunicipalityCode;
    private String mobile;
    private String email;

    private String btCode;

    private SexTypeEnum sex;
    private String nationality;

    // Used only by SubjectProposal
    private Integer proposalId;
}
