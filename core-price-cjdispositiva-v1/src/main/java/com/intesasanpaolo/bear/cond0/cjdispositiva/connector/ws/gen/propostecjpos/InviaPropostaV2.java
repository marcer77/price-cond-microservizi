//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:16:56 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per inviaPropostaV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="inviaPropostaV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datiProposta" type="{http://ws.price.isp.com/proposteCJPOS/}propostaCJPOSV2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inviaPropostaV2", propOrder = {
    "datiProposta"
})
public class InviaPropostaV2 {

    protected PropostaCJPOSV2 datiProposta;

    /**
     * Recupera il valore della proprietà datiProposta.
     * 
     * @return
     *     possible object is
     *     {@link PropostaCJPOSV2 }
     *     
     */
    public PropostaCJPOSV2 getDatiProposta() {
        return datiProposta;
    }

    /**
     * Imposta il valore della proprietà datiProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link PropostaCJPOSV2 }
     *     
     */
    public void setDatiProposta(PropostaCJPOSV2 value) {
        this.datiProposta = value;
    }

}
