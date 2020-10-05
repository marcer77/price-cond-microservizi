package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import lombok.Data;

@Data
public class InvoiceDeliveryModel {

    private String invoiceEmail;
    private String invoiceCertifiedEmail;
    private Boolean invoiceResidenceFlag;
    private String invoiceMunicipality;
    private String invoiceProvince;
    private String invoiceToponym;
    private String invoiceAddress;
    private String invoiceCivic;
    private String invoicePostalCode;
    private String invoiceMunicipalityCode;
    private Boolean invoiceSdiFlag;
    private String invoiceSdi;


}
