package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

public enum CustomerProfilerEnum {
    BLACK("BLACK"),
    WHITE("WHITE");
    
    private String code;

    private CustomerProfilerEnum(String code){
        this.code = code;
    }

    public static CustomerProfilerEnum getCode(String customerProfiler) {
        for (CustomerProfilerEnum en : CustomerProfilerEnum.values()) {
            if (en.code.equals(customerProfiler)) {
                return en;
            }
        }
        return null;
    }

    public String getCode(){
        return code;
    }
}
