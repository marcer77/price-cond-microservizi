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
 * <p>Classe Java per ParametriPrice complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ParametriPrice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="functionApp" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="codConvenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrCond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codPromozione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametriPrice", propOrder = {
    "functionApp",
    "codConvenzione",
    "attrCond",
    "codPromozione"
})
public class ParametriPrice {

    @XmlElement(required = true)
    protected String functionApp;
    protected String codConvenzione;
    protected String attrCond;
    protected String codPromozione;

    /**
     * Recupera il valore della proprietà functionApp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionApp() {
        return functionApp;
    }

    /**
     * Imposta il valore della proprietà functionApp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionApp(String value) {
        this.functionApp = value;
    }

    /**
     * Recupera il valore della proprietà codConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodConvenzione() {
        return codConvenzione;
    }

    /**
     * Imposta il valore della proprietà codConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodConvenzione(String value) {
        this.codConvenzione = value;
    }

    /**
     * Recupera il valore della proprietà attrCond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrCond() {
        return attrCond;
    }

    /**
     * Imposta il valore della proprietà attrCond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrCond(String value) {
        this.attrCond = value;
    }

    /**
     * Recupera il valore della proprietà codPromozione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPromozione() {
        return codPromozione;
    }

    /**
     * Imposta il valore della proprietà codPromozione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPromozione(String value) {
        this.codPromozione = value;
    }

}
