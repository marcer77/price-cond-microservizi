package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.dto.InputStampaDTO;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.entity.TB59R009;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.AdesioneConvenzione;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.BeneficiBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.InfoCovenantBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.InputStampaBuilder;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.AdesioneResponseBenefici;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetCovenantPerConvenzioneCovenantDaAttivare;
import com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.model.ws.RespGetRequisitiAdesioneConvenzione;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.model.ispHeaders.ParamList;

@Component
public class AdesioneConvenzioneFactory {
	public AdesioneConvenzione createAdesioneConvenzione(ISPWebservicesHeaderType ispWebservicesHeaderType, InputStampaDTO dto, List<RespGetCovenantPerConvenzioneCovenantDaAttivare> getCovPerConResp, RespGetRequisitiAdesioneConvenzione getReqAdesConResp,String codiceConvenzione) {
		
		//
		List<TB59R009> modelList=new ArrayList<>();
		//
		
		String rapporto = dto.getRapporto().getCodFiliale() + dto.getRapporto().getCodCategoria() + dto.getRapporto().getCodProgressivo();
		
		if(CollectionUtils.isNotEmpty(getCovPerConResp)) {
			int progDati=1;
			for (RespGetCovenantPerConvenzioneCovenantDaAttivare covenant : getCovPerConResp) {
				InfoCovenantBuilder infoCovenantBuilder = new InfoCovenantBuilder(covenant);
				String datiEntita=infoCovenantBuilder.build();
				TB59R009 entity = TB59R009.builder()
						.nrSuperpratica(dto.getPratica().getCodSuperPratica())
						.nrPratica(dto.getPratica().getCodPratica())
						.idEntita("00003")
						.stato("")
						.progrEntita(1)
						.progrDati(progDati++)
						.codEntita(rapporto+covenant.getCodCondizione()) 
						.datiEntita(datiEntita)
						.tipoAggiornamento("I")
						.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID())
						.build();

				modelList.add(entity);
			}
		}
		//
		if(getReqAdesConResp!=null) {
			int progBen=1;
			int progRol=1;
			List<AdesioneResponseBenefici> benefici = getReqAdesConResp.getTabellaBenefici();
			if(CollectionUtils.isNotEmpty(benefici)) {
				for (AdesioneResponseBenefici beneficio : benefici) {
					BeneficiBuilder beneficiBuilder = new BeneficiBuilder(beneficio);

					String datiEntita=beneficiBuilder.build();
					boolean checkRolling=StringUtils.isNotEmpty(beneficio.getFlagRolling())&& beneficio.getFlagRolling().trim().equalsIgnoreCase("S");

					TB59R009 entity = TB59R009.builder()
							.nrSuperpratica(dto.getPratica().getCodSuperPratica())
							.nrPratica(dto.getPratica().getCodPratica())
							.idEntita(checkRolling?"00005":"00004")
							.stato("")
							.progrEntita(1)
							.progrDati(checkRolling?progRol++:progBen++)
							.codEntita(rapporto+beneficio.getCodiceCondizione())
							.datiEntita(datiEntita)
							.tipoAggiornamento("I")
							.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID())
							.build();

					modelList.add(entity);
				}
			}
		}
		//
		InputStampaBuilder inputStampaBuilder = new InputStampaBuilder(dto);
		TB59R009 entityDTADE = TB59R009.builder()
				.nrSuperpratica(dto.getPratica().getCodSuperPratica())
				.nrPratica(dto.getPratica().getCodPratica())
				.idEntita("DTADE")
				.stato("N")
				.progrEntita(1)
				.progrDati(1)
				.codEntita(codiceConvenzione!=null?codiceConvenzione:"")
				.datiEntita(inputStampaBuilder.build())
				.tipoAggiornamento("I")
				.codOpeUltModif(ispWebservicesHeaderType.getOperatorInfo().getUserID()).build();
		modelList.add(entityDTADE);
			
		return AdesioneConvenzione.builder()
				.codSuperPratica(dto.getPratica().getCodSuperPratica())
				.codPratica(dto.getPratica().getCodPratica())
				.codAbi(ServiceUtil.getAdditionalBusinessInfo(ispWebservicesHeaderType, ParamList.COD_ABI))
				.tb59r009List(modelList)
				.build();
		
	}
}
