package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.connector.ctg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.dsi.business.SSA_WK.integration.jdo.P_WKNBS00.C_WKNBS00;



@Configuration
public class CtgConnectorConfig {
	
	@Bean
	@Scope("prototype")
	public C_WKNBS00 getWKNBS00ConnectorClient() {
		return new C_WKNBS00();
	}
	
}
