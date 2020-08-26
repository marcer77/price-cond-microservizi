package com.intesasanpaolo.bear.cond0.cjoffertaconto.resource;

import java.util.List;

import lombok.Data;

@Data
public class ProdottoResource {
	
	private String codice;
	private String descrizione;
	private List<ValoriProdottoResource> prodotti;

}
