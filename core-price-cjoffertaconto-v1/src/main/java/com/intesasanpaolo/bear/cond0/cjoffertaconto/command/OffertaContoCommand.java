package com.intesasanpaolo.bear.cond0.cjoffertaconto.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cj.lib.utils.DateUtils;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.InputEsponiDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.dto.PromozioniDTO;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.InPPRM;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutCPR;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutOFF;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.OutPRD;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYRequest;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.model.PCMYResponse;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.OffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ProdottoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriOffertaResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.ValoriProdottoResource;
import com.intesasanpaolo.bear.cond0.cjoffertaconto.service.ctg.PCMYServiceBS;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.properties.PropertiesManager;


@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class OffertaContoCommand extends BaseCommand<EsponiResponseResource> {

	private ISPWebservicesHeaderType ispWebservicesHeaderType;

	private InputEsponiDTO dto;
	
	@Autowired
    private PropertiesManager propertiesManager;
	
	@Autowired
	private PCMYServiceBS pcmyServiceBS;

	public OffertaContoCommand(InputEsponiDTO inputEsponiDTO, ISPWebservicesHeaderType ispWebservicesHeaderType) {
		super();
		this.dto = inputEsponiDTO;
		this.ispWebservicesHeaderType = ispWebservicesHeaderType;
	}

	@Override
	public boolean canExecute() {
		logger.info("canExecute START");
		logger.info("canExecute END");
		return true;
	}

	@Override
	protected EsponiResponseResource doExecute() {
		logger.info("doExecute START");
		EsponiResponseResource result = null;
		if(propertiesManager!=null && propertiesManager.get("CALL_MOCK")!=null && "S".equals(propertiesManager.get("CALL_MOCK", String.class, "N"))) {
			logger.info("doExecute CALL MOCKED");
			return getMockResponse();
		}
		
		PCMYResponse response = pcmyServiceBS.callBS(buildRequest());
		result = buildResponse(response);
		
		logger.info("doExecute END");
		return result ;
	}

	private PCMYRequest buildRequest() {
		logger.info("buildRequest START");
		List<InPPRM> inList = new ArrayList<InPPRM>();
		if( CollectionUtils.isNotEmpty(dto.getPromozioni()) ) {
			for(PromozioniDTO p : dto.getPromozioni()) {
				InPPRM promozione = InPPRM.builder()
						.codPromo(p.getCodice())
						.decoPromo(DateUtils.dateToString(p.getDataDecorrenza(),DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
						.decaPromo(DateUtils.dateToString(p.getDataScadenza(),DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
						.build();
				inList.add(promozione);
			}
		}
		logger.info("buildRequest Promozioni in lista "+inList.size());
		PCMYRequest request = PCMYRequest.builder()
				.ispWebservicesHeaderType(ispWebservicesHeaderType)
				.codCatRapp(dto.getRapporto().getCodCategoria())
				.codFilRapp(dto.getRapporto().getCodFiliale())
				.dataRiferimento(DateUtils.dateToString(dto.getDataRif(),DateUtils.DATE_FORMAT_YYYY_MM_DD_SOLID))
				.numProgRapp(dto.getRapporto().getCodProgressivo())
				.funzione(dto.getCodAppl())
				.tipoDA(dto.getTipoDA())
				.inList(inList)
				.build();
		logger.info("buildRequest END");
		return request;
	}
	
	private List<ValoriOffertaResource> popolaValori(PCMYResponse res){
		List<ValoriOffertaResource> valori = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(res.getOutOffList())) {
			for(OutOFF offerta : res.getOutOffList()) {
				valori.add(ValoriOffertaResource.builder()
						.costo(offerta.getCostoOfferta().toString())
						.costoListino(offerta.getCostoListino().toString())
						.decorrenza(offerta.getDecoOfferta())
						.scadenza(offerta.getDecaOfferta())
						.flAgevolato(offerta.getFlAgevolato())
						.build());
			}
		}
		logger.info("buildResponse lista Valori "+valori.size());
		return valori;
	}
	
	private List<ProdottoResource> popolaProdotti(PCMYResponse res){
		List<ProdottoResource> prodotti = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(res.getOutPrdList())) {
			for(OutPRD prodotto : res.getOutPrdList()) {
				prodotti.add(ProdottoResource.builder().codice(prodotto.getCodCondizione())
						.descrizione(prodotto.getDescrProdotto())
						.prodotti(popolaValoriProdotto(prodotto))
						.build());
			}
		}
		logger.info("buildResponse lista prodotti "+prodotti.size());
		return prodotti;
	}
	
	private List<ValoriProdottoResource> popolaValoriProdotto(OutPRD prodotto){
		List<ValoriProdottoResource> valoriProdotto = new ArrayList<ValoriProdottoResource>();
		if( CollectionUtils.isNotEmpty(prodotto.getOutCPRList() )) {	
			for(OutCPR prod : prodotto.getOutCPRList()) {
				valoriProdotto.add(ValoriProdottoResource.builder()
						.costo(prod.getCostoProdotto().toString())
						.costoPromo(prod.getCostoProdottoPRM().toString())
						.decorrenza(prod.getDecoProdotto())
						.scadenza(prod.getDecaProdotto())
						.flAcceso(prod.getFlgProdotto())
						.flPromo(prod.getFlgValPromo())
						.build());
			}
		}
		logger.info("buildResponse lista Valori prodotto "+valoriProdotto.size());
		return valoriProdotto;
	}
	
	private EsponiResponseResource buildResponse(PCMYResponse res) {
		logger.info("buildResponse START");
		EsponiResponseResource response =new EsponiResponseResource();
		
		response.setEsito(new EsitoResource(res.getCodEsito(), ""));

		OffertaResource offerta = OffertaResource.builder()
				.codice(res.getCodOfferta()).
				valori(popolaValori(res)).build();
		
		response.setOfferta(offerta);
		
		response.setProdotti(popolaProdotti(res));
		
		logger.info("buildResponse END");
		return response;
	}

	//MOCK
	protected EsponiResponseResource getMockResponse() {
		
		EsponiResponseResource response =new EsponiResponseResource();
		
		response.setEsito(new EsitoResource("00", ""));
		
		List<ValoriOffertaResource> valori = new ArrayList<>();
		valori.add(ValoriOffertaResource.builder().costo("13.34582")
				.costoListino("14.034522")
				.decorrenza("20200901")
				.scadenza("20210303")
				.flAgevolato("S")
				.build());
		
		valori.add(ValoriOffertaResource.builder().costo("13.34582")
				.costoListino("15.034522")
				.decorrenza("20200901")
				.scadenza("20210303")
				.flAgevolato("N")
				.build());
		
		OffertaResource offerta = OffertaResource.builder().codice("OFFH99C").valori(valori).build();
		response.setOfferta(offerta);
		
		List<ProdottoResource> prodotti = new ArrayList<>();
		
		List<ValoriProdottoResource> valoriProdotto = new ArrayList<>();
		
		valoriProdotto.add(ValoriProdottoResource.builder()
				.costo("16.034532")
				.costoPromo("15")
				.decorrenza("20201005")
				.scadenza("20201120")
				.flAcceso("N")
				.flPromo("S")
				.build());
		
		valoriProdotto.add(ValoriProdottoResource.builder()
				.costo("11.034532")
				.costoPromo("10")
				.decorrenza("20201005")
				.scadenza("20201120")
				.flAcceso("S")
				.flPromo("S")
				.build());
		
		prodotti.add(ProdottoResource.builder().codice("PRNH99C")
				.descrizione("XMESALUTE")
				.prodotti(valoriProdotto)
				.build());
		
		prodotti.add(ProdottoResource.builder().codice("PRNH94C")
				.descrizione("XMESALUTE-FAMILY")
				.prodotti(valoriProdotto)
				.build());
		
		
		
		response.setProdotti(prodotti);
		
		return response;
		
	}

}
