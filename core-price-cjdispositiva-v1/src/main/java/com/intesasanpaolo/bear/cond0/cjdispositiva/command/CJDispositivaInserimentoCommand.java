package com.intesasanpaolo.bear.cond0.cjdispositiva.command;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.AnagraficaPropostaCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneCJPOS;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.DatiCliente;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoOperazioneCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.PropostaCJPOSV2;
import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.WrapperMap;
import com.intesasanpaolo.bear.cond0.cjdispositiva.dto.DispositivaRequestDTO;
import com.intesasanpaolo.bear.cond0.cjdispositiva.resource.EsitoResource;
import com.intesasanpaolo.bear.cond0.cjdispositiva.service.ProposteCJPOSWSService;
import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
import com.intesasanpaolo.bear.core.command.BaseCommand;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.exceptions.BearForbiddenException;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CJDispositivaInserimentoCommand extends BaseCommand<EsitoResource> {

	private Logger log = Logger.getLogger(CJDispositivaInserimentoCommand.class);

	private ISPWebservicesHeaderType header;
	private DispositivaRequestDTO inviaPropostaV2;

	@Autowired
	private ProposteCJPOSWSService proposteCJPOSWSService;

	@Override
	public EsitoResource execute() throws Exception {
		log.info("- execute START");
		if (canExecute()) {
			log.info("- execute OK");
			InviaPropostaV2 request = ProposteCJPOSWSUtils._buildMockInviaPropostaV2();
			EsitoResource esitoResource = new EsitoResource("KO", "Si è verificato un errore.");

			EsitoOperazioneCJPOSV2 esitoOperazione = proposteCJPOSWSService.inviaPropostaV2(request, header);

			esitoResource.setCodErrore(esitoOperazione.getEsitoCodice());
			esitoResource.setDescErrore(esitoOperazione.getEsitoMessaggio());
			return esitoResource;
		} else {
			log.info("- execute ERROR");
			throw new BearForbiddenException("Cannot execute command");
		}
	}

	@Override
	public boolean canExecute() {
		log.info("- canExecute START");
		boolean esitoControlli = false;
		esitoControlli = inviaPropostaV2 != null && header != null;
		log.info("- canExecute END - " + esitoControlli);
		return esitoControlli;
	}

	private InviaPropostaV2 assemblaRequest(String tipoChiamata, String codiceOrigine, String rapportoReale,
			String attributoRapporto, AnagraficaPropostaCJPOS anagraficaPropostaCJPOS, DatiCliente datiCliente) {

		InviaPropostaV2 inviaPropostaV2 = new InviaPropostaV2();
		PropostaCJPOSV2 propostaCJPOSV2 = new PropostaCJPOSV2();

		propostaCJPOSV2.setTipoChiamata("INS"); // costante
		propostaCJPOSV2.setCodiceOrigine("IN"); // costante
		propostaCJPOSV2.setRapportoReale("11653632401932571");
		propostaCJPOSV2.setAttributoRapporto("RB6324");
		propostaCJPOSV2.setDatiProposta(anagraficaPropostaCJPOS);
		propostaCJPOSV2.setDatiCliente(datiCliente);
		propostaCJPOSV2.setAttributiPricing(new WrapperMap());
		propostaCJPOSV2.getListaCondizioni().add(new CondizioneCJPOS());
		inviaPropostaV2.setDatiProposta(propostaCJPOSV2);

//        <ns0:datiProposta>
//        <ns0:tipoChiamata>INS</ns0:tipoChiamata>
//        <ns0:codiceOrigine>IN</ns0:codiceOrigine>
//        <ns0:rapportoReale>11653632401932571</ns0:rapportoReale>
//        <ns0:attributoRapporto></ns0:attributoRapporto>
//        <!--lista dei profili in input al momento ignorata <ns0:profili>YAP9C1</ns0:profili>-->
//        <ns0:datiProposta>
//           <ns0:codiceAbiProposta>01025</ns0:codiceAbiProposta>
//           <ns0:annoProposta>2020</ns0:annoProposta>
//           <ns0:codiceTipoOperazione></ns0:codiceTipoOperazione>
//           <ns0:codiceOggettoProposta>01</ns0:codiceOggettoProposta>
//           <ns0:attributo>RB6324</ns0:attributo>
//           <ns0:matricolaProponente>U004835</ns0:matricolaProponente>
//           <!--U004835 Avonto Giovanni : UO: 01383-->
//           <ns0:uoProponente>01383</ns0:uoProponente>
//        </ns0:datiProposta>
//        <ns0:datiCliente>
//           <ns0:abiCliente></ns0:abiCliente>
//           <ns0:ndgCliente>2896811838000</ns0:ndgCliente>
//           <ns0:pivaCliente>02417880032</ns0:pivaCliente>
//           <ns0:uoGestore></ns0:uoGestore>
//           <ns0:nominativoCliente></ns0:nominativoCliente>
//        </ns0:datiCliente>
//        <ns0:attributiPricing/>
//        <ns0:listaCondizioni>
//           <ns0:codiceCondizione>03229</ns0:codiceCondizione>
//           <ns0:tipoDeroga>N</ns0:tipoDeroga>
//           <ns0:tipoValore>1</ns0:tipoValore>
//           <ns0:indPresenzaValProp>S</ns0:indPresenzaValProp>
//           <ns0:valoreProposto>100</ns0:valoreProposto>
//        </ns0:listaCondizioni>
		return inviaPropostaV2;
	}

	public void setHeader(ISPWebservicesHeaderType header) {
		this.header = header;
	}

	public void setInviaPropostaV2(DispositivaRequestDTO inviaPropostaV2) {
		this.inviaPropostaV2 = inviaPropostaV2;
	}

}
