package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountModel {
    private String branch;
    private String category;
    private String accountNumber;
    private String iban;
    private String description;//intestazione/owner
    private BigDecimal balance;

    //multichannelChecker
    private String abilitations;

}
