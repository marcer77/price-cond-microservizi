//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per OutOutputFactory complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="OutOutputFactory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codProd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codRegolaODM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutOutputFactory", propOrder = {
    "codProd",
    "codRegolaODM"
})
public class OutOutputFactory {

    protected String codProd;
    protected String codRegolaODM;

    /**
     * Recupera il valore della proprietà codProd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProd() {
        return codProd;
    }

    /**
     * Imposta il valore della proprietà codProd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProd(String value) {
        this.codProd = value;
    }

    /**
     * Recupera il valore della proprietà codRegolaODM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRegolaODM() {
        return codRegolaODM;
    }

    /**
     * Imposta il valore della proprietà codRegolaODM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRegolaODM(String value) {
        this.codRegolaODM = value;
    }

}
