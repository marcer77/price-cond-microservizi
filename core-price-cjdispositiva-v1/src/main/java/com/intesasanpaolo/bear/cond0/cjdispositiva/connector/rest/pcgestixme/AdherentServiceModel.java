package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdherentServiceModel {

    private Integer adherentId;
    private ServiceModel service;
    private BigDecimal grossPremium;
    private BigDecimal noSalePremium;
}
