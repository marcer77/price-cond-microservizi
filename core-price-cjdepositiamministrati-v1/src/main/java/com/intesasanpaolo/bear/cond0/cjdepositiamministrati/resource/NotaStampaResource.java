package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotaStampaResource {
	
	private String num;
	private String testo;
	private String evidNum;
	private String evidTesto;
		
}
