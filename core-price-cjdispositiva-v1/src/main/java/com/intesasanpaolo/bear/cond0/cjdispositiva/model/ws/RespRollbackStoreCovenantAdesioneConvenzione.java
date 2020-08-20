package com.intesasanpaolo.bear.cond0.cjdispositiva.model.ws;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespRollbackStoreCovenantAdesioneConvenzione {
	
	private String errorDescription;
	private Boolean isHasError;

}
