package com.intesasanpaolo.bear.cond0.cjindicatoricosto.connector.ctg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.dsi.business.SSA_PC.integration.jdo.P_PCUJS00.C_PCUJS00;
import com.dsi.business.SSA_WK.integration.jdo.P_WKCJS00.C_WKCJS00;

@Configuration
public class CtgConnectorConfig {
	@Bean
	@Scope("prototype")
	public C_WKCJS00 getWKCJS00ConnectorClient() {
		return new C_WKCJS00();
	}
	
	
	@Bean
	@Scope("prototype")
	public C_PCUJS00 getPCUJS00ConnectorClient() {
		return new C_PCUJS00();
	}

}
