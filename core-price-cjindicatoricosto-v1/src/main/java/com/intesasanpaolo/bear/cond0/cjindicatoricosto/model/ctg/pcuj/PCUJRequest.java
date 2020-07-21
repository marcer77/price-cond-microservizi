package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PCUJRequest {
	
	private ISPWebservicesHeaderType ispWebservicesHeaderType;
	//TODO:mappare i campi
	
}
