package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

@Data
public class UserInfoModel {
    private String userID;
    private String instituteCode;
    private String abi;
    private String branch;
    private UserTypeEnum userType;
}
