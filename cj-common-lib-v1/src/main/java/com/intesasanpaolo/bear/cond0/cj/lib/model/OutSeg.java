package com.intesasanpaolo.bear.cond0.cj.lib.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OutSeg {
	private String livelloSegnalazione;
	private String txtSegnalazione;
}

