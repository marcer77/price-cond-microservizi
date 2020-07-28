package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

@Data
public class ProductModel {

    private Integer id;

    private String cdmCode;
    private String productCode; // externalCode
    private String productArea; // externalAreaCode
    private String company;
    private String productDescription;
    private Boolean saleable;
    private Boolean saleablePfUnabled;
    private Boolean saleablePFInterdicted;
    private Boolean saleablePFUnderage;
    private Boolean saleablePG;
    private String wfmProductArea;
    private String wfmProductCategory;
    private String technicalForm;
    private String wfmProdoctCategoryPv;
    private String scope;
    private String productPriceCode;
    private CustomerProfilerEnum customerProfiler;
    private String categoryAnag;
}
