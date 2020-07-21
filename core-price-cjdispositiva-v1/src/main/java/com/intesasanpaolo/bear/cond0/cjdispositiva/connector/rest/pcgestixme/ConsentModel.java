package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

//import com.intesasanpaolo.xme.salute.tools.util.enums.AdherentTypeEnum;
//import com.intesasanpaolo.xme.salute.tools.util.enums.AnswerTypeEnum;
//import com.intesasanpaolo.xme.salute.tools.util.enums.ConsentEnum;
//import com.intesasanpaolo.xme.salute.tools.util.enums.ConsentSectionEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsentModel {

    private ConsentEnum consentCode;
    private Integer id;

    private String text;
    private LocalDate startValidityDate;
    private LocalDate endValidityDate;
    private ConsentSectionEnum section;
    private AnswerTypeEnum consentType;
    private Integer productId;
    private AdherentTypeEnum adherentType;
}
