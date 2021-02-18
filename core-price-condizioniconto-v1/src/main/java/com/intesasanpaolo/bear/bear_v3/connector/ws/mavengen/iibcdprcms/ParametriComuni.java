//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ParametriComuni complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ParametriComuni"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataoper" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpDataoper"/&gt;
 *         &lt;element name="ndg" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpNdg" minOccurs="0"/&gt;
 *         &lt;element name="filrapp" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpFilrapp" minOccurs="0"/&gt;
 *         &lt;element name="catrapp" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpCatrapp" minOccurs="0"/&gt;
 *         &lt;element name="numrapp" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpNumrapp" minOccurs="0"/&gt;
 *         &lt;element name="callerid" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpCallerid"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametriComuni", propOrder = {
    "dataoper",
    "ndg",
    "filrapp",
    "catrapp",
    "numrapp",
    "callerid"
})
public class ParametriComuni {

    @XmlElement(required = true)
    protected String dataoper;
    protected String ndg;
    protected String filrapp;
    protected String catrapp;
    protected String numrapp;
    @XmlElement(required = true)
    protected String callerid;

    /**
     * Recupera il valore della proprietà dataoper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataoper() {
        return dataoper;
    }

    /**
     * Imposta il valore della proprietà dataoper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataoper(String value) {
        this.dataoper = value;
    }

    /**
     * Recupera il valore della proprietà ndg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNdg() {
        return ndg;
    }

    /**
     * Imposta il valore della proprietà ndg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNdg(String value) {
        this.ndg = value;
    }

    /**
     * Recupera il valore della proprietà filrapp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilrapp() {
        return filrapp;
    }

    /**
     * Imposta il valore della proprietà filrapp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilrapp(String value) {
        this.filrapp = value;
    }

    /**
     * Recupera il valore della proprietà catrapp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatrapp() {
        return catrapp;
    }

    /**
     * Imposta il valore della proprietà catrapp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatrapp(String value) {
        this.catrapp = value;
    }

    /**
     * Recupera il valore della proprietà numrapp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumrapp() {
        return numrapp;
    }

    /**
     * Imposta il valore della proprietà numrapp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumrapp(String value) {
        this.numrapp = value;
    }

    /**
     * Recupera il valore della proprietà callerid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerid() {
        return callerid;
    }

    /**
     * Imposta il valore della proprietà callerid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerid(String value) {
        this.callerid = value;
    }

}
