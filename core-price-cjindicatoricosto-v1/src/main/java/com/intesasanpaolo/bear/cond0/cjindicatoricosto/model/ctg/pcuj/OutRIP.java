package com.intesasanpaolo.bear.cond0.cjindicatoricosto.model.ctg.pcuj;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutRIP {
	private String codFt;
	private String dataScadenzaFido;
	private String divisaFido;
	private Integer importoFido;
	private Integer importoFidoEur;
	private String tipoFt;
	private String descrFt;
	
	private String codCatRapRip;
	private String codFilRappRip;
	private String numProgRappRip;
	
	private Double valTaeg; 	
	private Double valCDF; 	
	private Double valTeg; 	
	
	
	@Builder.Default
	private List<OutTAS> outTasList=new ArrayList<>();
}
