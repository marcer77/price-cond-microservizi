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
 * <p>Classe Java per inquiryRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="inquiryRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceAbiProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inquiryRequest", propOrder = {
    "codiceAbiProposta",
    "annoProposta",
    "codiceProposta"
})
public class InquiryRequest {

    protected String codiceAbiProposta;
    protected String annoProposta;
    protected String codiceProposta;

    /**
     * Recupera il valore della proprietà codiceAbiProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAbiProposta() {
        return codiceAbiProposta;
    }

    /**
     * Imposta il valore della proprietà codiceAbiProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAbiProposta(String value) {
        this.codiceAbiProposta = value;
    }

    /**
     * Recupera il valore della proprietà annoProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoProposta() {
        return annoProposta;
    }

    /**
     * Imposta il valore della proprietà annoProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoProposta(String value) {
        this.annoProposta = value;
    }

    /**
     * Recupera il valore della proprietà codiceProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProposta() {
        return codiceProposta;
    }

    /**
     * Imposta il valore della proprietà codiceProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProposta(String value) {
        this.codiceProposta = value;
    }

}
