<<<<<<< HEAD
package com.intesasanpaolo.bear.cond0.cjoffertaconto.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromozioniDTO {
	private String codice;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@NotNull(message = "Il campo dataDecorrenza non puo essere vuoto")
	private Date dataDecorrenza;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@NotNull(message = "Il campo dataScadenza non puo essere vuoto")
	private Date dataScadenza;

}
=======
package com.intesasanpaolo.bear.cond0.cjoffertaconto.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromozioniDTO {
	private String codice;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@NotNull(message = "Il campo dataDecorrenza non puo essere vuoto")
	private Date dataDecorrenza;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@NotNull(message = "Il campo dataScadenza non puo essere vuoto")
	private Date dataScadenza;

}
>>>>>>> env/sviluppo
