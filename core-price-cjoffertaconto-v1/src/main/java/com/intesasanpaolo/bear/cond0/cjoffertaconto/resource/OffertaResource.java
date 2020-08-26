package com.intesasanpaolo.bear.cond0.cjoffertaconto.resource;

import java.util.List;

import lombok.Data;

@Data
public class OffertaResource {
	
	private String codice;
	private List<ValoriOffertaResource> valori;

}
