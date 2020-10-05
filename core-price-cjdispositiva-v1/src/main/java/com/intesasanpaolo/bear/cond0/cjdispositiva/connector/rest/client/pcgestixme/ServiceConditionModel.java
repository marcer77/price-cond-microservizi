package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiceConditionModel {
    private Integer id;
    private Integer serviceId;
    private Integer productId;
    private ConditionEnum condition;
    private String proposalDesc;
    private String contractDesc;
    private String proposalPrint;
    private String contractPrint;
    private String role;
    private BigDecimal percRetroFirstYear;
    private BigDecimal percRetroFollowYear;
    private BigDecimal percIva;
    private String priceIdCondition;
    private String priceLabelCondition;
}
