//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.19 alle 12:00:10 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per inquiryResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="inquiryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esitoInquiry" type="{http://ws.price.isp.com/proposteCJPOS/}esitoInquiryCJPOS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inquiryResponse", propOrder = {
    "esitoInquiry"
})
public class InquiryResponse {

    protected EsitoInquiryCJPOS esitoInquiry;

    /**
     * Recupera il valore della proprietà esitoInquiry.
     * 
     * @return
     *     possible object is
     *     {@link EsitoInquiryCJPOS }
     *     
     */
    public EsitoInquiryCJPOS getEsitoInquiry() {
        return esitoInquiry;
    }

    /**
     * Imposta il valore della proprietà esitoInquiry.
     * 
     * @param value
     *     allowed object is
     *     {@link EsitoInquiryCJPOS }
     *     
     */
    public void setEsitoInquiry(EsitoInquiryCJPOS value) {
        this.esitoInquiry = value;
    }

}
