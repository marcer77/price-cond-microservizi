//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Driver complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Driver"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="etichetta" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="val" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="len" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="dec" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Driver", propOrder = {
    "etichetta",
    "val",
    "tipo",
    "len",
    "dec"
})
public class Driver {

    @XmlElement(required = true)
    protected String etichetta;
    @XmlElement(required = true)
    protected String val;
    protected String tipo;
    protected BigDecimal len;
    protected BigDecimal dec;

    /**
     * Recupera il valore della proprietà etichetta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtichetta() {
        return etichetta;
    }

    /**
     * Imposta il valore della proprietà etichetta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtichetta(String value) {
        this.etichetta = value;
    }

    /**
     * Recupera il valore della proprietà val.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVal() {
        return val;
    }

    /**
     * Imposta il valore della proprietà val.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVal(String value) {
        this.val = value;
    }

    /**
     * Recupera il valore della proprietà tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Imposta il valore della proprietà tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Recupera il valore della proprietà len.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLen() {
        return len;
    }

    /**
     * Imposta il valore della proprietà len.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLen(BigDecimal value) {
        this.len = value;
    }

    /**
     * Recupera il valore della proprietà dec.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDec() {
        return dec;
    }

    /**
     * Imposta il valore della proprietà dec.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDec(BigDecimal value) {
        this.dec = value;
    }

}
