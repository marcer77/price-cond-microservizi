package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HeaderModel {

    private String abi;
    private String branchCode;
    private ChannelEnum channel;
    private String instituteCode;
    private String productCode;
    private LocalDate referenceDate;
    private String transactionId;
    private UserInfoModel userInfo = new UserInfoModel();
    private String function;
    private String headerCustomerID;

}
