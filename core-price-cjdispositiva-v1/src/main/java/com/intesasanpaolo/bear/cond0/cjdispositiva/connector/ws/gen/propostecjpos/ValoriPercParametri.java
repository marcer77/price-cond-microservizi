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
 * <p>Classe Java per valoriPercParametri complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="valoriPercParametri"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceParametro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceSottoparametro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreParametro" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "valoriPercParametri", propOrder = {
    "codiceParametro",
    "codiceSottoparametro",
    "valoreParametro"
})
public class ValoriPercParametri {

    protected String codiceParametro;
    protected String codiceSottoparametro;
    protected Double valoreParametro;

    /**
     * Recupera il valore della proprietà codiceParametro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceParametro() {
        return codiceParametro;
    }

    /**
     * Imposta il valore della proprietà codiceParametro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceParametro(String value) {
        this.codiceParametro = value;
    }

    /**
     * Recupera il valore della proprietà codiceSottoparametro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSottoparametro() {
        return codiceSottoparametro;
    }

    /**
     * Imposta il valore della proprietà codiceSottoparametro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSottoparametro(String value) {
        this.codiceSottoparametro = value;
    }

    /**
     * Recupera il valore della proprietà valoreParametro.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValoreParametro() {
        return valoreParametro;
    }

    /**
     * Imposta il valore della proprietà valoreParametro.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValoreParametro(Double value) {
        this.valoreParametro = value;
    }

}
