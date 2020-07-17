package com.intesasanpaolo.bear.cond0.cjdispositiva.dto;

import java.util.List;

import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.CondizioneV2Response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EsitoOperazioneCJPOSDTO extends EsitoOperazioneDTO {

    protected String faseIter;
    protected String statoIter;
    protected String esitoIter;
    protected List<CondizioneV2Response> condizioni;
    
}
