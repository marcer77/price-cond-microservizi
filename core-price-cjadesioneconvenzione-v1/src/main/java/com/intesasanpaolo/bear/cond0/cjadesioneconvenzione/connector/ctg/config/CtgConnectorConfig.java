package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ctg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.dsi.business.SSA_T1.integration.jdo.P_T1SJS00.C_T1SJS00;

@Configuration
public class CtgConnectorConfig{
	@Bean
    @Scope("prototype")
    public C_T1SJS00 getC_T1SJS00ConnectorClient() {
        return new C_T1SJS00();
    }
 
    
}
