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
 * <p>Classe Java per condizioneV2Response complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="condizioneV2Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codUOFacolta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggioCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "condizioneV2Response", propOrder = {
    "codiceCondizione",
    "codUOFacolta",
    "esitoCondizione",
    "messaggioCondizione"
})
public class CondizioneV2Response {

    protected String codiceCondizione;
    protected String codUOFacolta;
    protected String esitoCondizione;
    protected String messaggioCondizione;

    /**
     * Recupera il valore della proprietà codiceCondizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCondizione() {
        return codiceCondizione;
    }

    /**
     * Imposta il valore della proprietà codiceCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCondizione(String value) {
        this.codiceCondizione = value;
    }

    /**
     * Recupera il valore della proprietà codUOFacolta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodUOFacolta() {
        return codUOFacolta;
    }

    /**
     * Imposta il valore della proprietà codUOFacolta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodUOFacolta(String value) {
        this.codUOFacolta = value;
    }

    /**
     * Recupera il valore della proprietà esitoCondizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoCondizione() {
        return esitoCondizione;
    }

    /**
     * Imposta il valore della proprietà esitoCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoCondizione(String value) {
        this.esitoCondizione = value;
    }

    /**
     * Recupera il valore della proprietà messaggioCondizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessaggioCondizione() {
        return messaggioCondizione;
    }

    /**
     * Imposta il valore della proprietà messaggioCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessaggioCondizione(String value) {
        this.messaggioCondizione = value;
    }

}
