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
 * <p>Classe Java per esitoInquiryCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="esitoInquiryCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="proposta" type="{http://ws.price.isp.com/proposteCJPOS/}propostaCJPOS" minOccurs="0"/&gt;
 *         &lt;element name="esitoCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoMessaggio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esitoInquiryCJPOS", propOrder = {
    "proposta",
    "esitoCodice",
    "esitoMessaggio"
})
public class EsitoInquiryCJPOS {

    protected PropostaCJPOS proposta;
    protected String esitoCodice;
    protected String esitoMessaggio;

    /**
     * Recupera il valore della proprietà proposta.
     * 
     * @return
     *     possible object is
     *     {@link PropostaCJPOS }
     *     
     */
    public PropostaCJPOS getProposta() {
        return proposta;
    }

    /**
     * Imposta il valore della proprietà proposta.
     * 
     * @param value
     *     allowed object is
     *     {@link PropostaCJPOS }
     *     
     */
    public void setProposta(PropostaCJPOS value) {
        this.proposta = value;
    }

    /**
     * Recupera il valore della proprietà esitoCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoCodice() {
        return esitoCodice;
    }

    /**
     * Imposta il valore della proprietà esitoCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoCodice(String value) {
        this.esitoCodice = value;
    }

    /**
     * Recupera il valore della proprietà esitoMessaggio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoMessaggio() {
        return esitoMessaggio;
    }

    /**
     * Imposta il valore della proprietà esitoMessaggio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoMessaggio(String value) {
        this.esitoMessaggio = value;
    }

}
