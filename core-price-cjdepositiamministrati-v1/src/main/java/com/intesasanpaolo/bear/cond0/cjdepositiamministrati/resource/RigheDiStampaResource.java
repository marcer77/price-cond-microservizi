package com.intesasanpaolo.bear.cond0.cjdepositiamministrati.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RigheDiStampaResource {
	
	private String prgStp;
	private String prgStrut;
	private String tipoStrut;

	private String flContinua;

	private IntestazioneStampaResource intestazione;
	private TitoloStampaResource titolo;
	private CondizioneStampaResource condizione;
	private NotaStampaResource nota;
	private PromozioneStampaResource promozione;
}
