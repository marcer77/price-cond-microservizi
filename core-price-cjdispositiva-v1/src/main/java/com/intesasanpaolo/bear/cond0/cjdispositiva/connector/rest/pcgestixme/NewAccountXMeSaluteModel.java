package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewAccountXMeSaluteModel extends HeaderModel {

    private String pratica;
    private String superPratica;
    private ContractModel contract;

    /*
    I primi 8 char costituiscono l’ultimo qualificatore della coda MQ specifica su cui vanno depositate le richieste del Business Service
I primi 4 char costituiscono il codice transazione associato alla tipologia di Business Service.
Nome servizio

    * */
    private String MQQualificator;//(regole di valorizzazione nel tracciato; queste informazioni servono per aggiornare l’adesione a promozione su TdR)
}
