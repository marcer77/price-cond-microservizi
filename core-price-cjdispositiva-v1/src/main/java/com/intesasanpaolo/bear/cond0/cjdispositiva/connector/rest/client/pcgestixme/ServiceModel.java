package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

@Data
public class ServiceModel {
    private Integer id;

    private String cdmCode;
    private String externalCode; // serviceCode
    private String packageCode;
    private String packageDescription;
    private String serviceDescription;
    private Integer productId;
}
