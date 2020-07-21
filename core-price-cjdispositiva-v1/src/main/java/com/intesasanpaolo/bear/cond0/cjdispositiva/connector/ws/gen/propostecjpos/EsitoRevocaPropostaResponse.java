//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.13 alle 12:58:12 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per esitoRevocaPropostaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="esitoRevocaPropostaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esito" type="{http://ws.price.isp.com/proposteCJPOS/}esitoRevocaPropostaCJPOS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esitoRevocaPropostaResponse", propOrder = {
    "esito"
})
public class EsitoRevocaPropostaResponse {

    protected EsitoRevocaPropostaCJPOS esito;

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link EsitoRevocaPropostaCJPOS }
     *     
     */
    public EsitoRevocaPropostaCJPOS getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoRevocaPropostaCJPOS }
     *     
     */
    public void setEsito(EsitoRevocaPropostaCJPOS value) {
        this.esito = value;
    }

}
