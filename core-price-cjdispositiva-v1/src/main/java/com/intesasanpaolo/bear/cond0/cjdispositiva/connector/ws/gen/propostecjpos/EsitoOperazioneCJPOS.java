//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:10:16 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per esitoOperazioneCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="esitoOperazioneCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.price.isp.com/proposteCJPOS/}esitoOperazione"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="faseIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esitoOperazioneCJPOS", propOrder = {
    "faseIter",
    "statoIter",
    "esitoIter"
})
@XmlSeeAlso({
    EsitoOperazioneCJPOSV2 .class
})
public class EsitoOperazioneCJPOS
    extends EsitoOperazione
{

    protected String faseIter;
    protected String statoIter;
    protected String esitoIter;

    /**
     * Recupera il valore della proprietà faseIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaseIter() {
        return faseIter;
    }

    /**
     * Imposta il valore della proprietà faseIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaseIter(String value) {
        this.faseIter = value;
    }

    /**
     * Recupera il valore della proprietà statoIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoIter() {
        return statoIter;
    }

    /**
     * Imposta il valore della proprietà statoIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoIter(String value) {
        this.statoIter = value;
    }

    /**
     * Recupera il valore della proprietà esitoIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoIter() {
        return esitoIter;
    }

    /**
     * Imposta il valore della proprietà esitoIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoIter(String value) {
        this.esitoIter = value;
    }

}
