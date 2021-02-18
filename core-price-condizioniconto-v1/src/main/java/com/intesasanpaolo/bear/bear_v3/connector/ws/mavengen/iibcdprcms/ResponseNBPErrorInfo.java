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
 * <p>Classe Java per responseNBP_ErrorInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseNBP_ErrorInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NBP_ErrorInfo" type="{http://ws.intesasanpaolo.com/}NBP_ErrorInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseNBP_ErrorInfo", propOrder = {
    "nbpErrorInfo"
})
public class ResponseNBPErrorInfo {

    @XmlElement(name = "NBP_ErrorInfo")
    protected NBPErrorInfoType nbpErrorInfo;

    /**
     * Recupera il valore della proprietà nbpErrorInfo.
     * 
     * @return
     *     possible object is
     *     {@link NBPErrorInfoType }
     *     
     */
    public NBPErrorInfoType getNBPErrorInfo() {
        return nbpErrorInfo;
    }

    /**
     * Imposta il valore della proprietà nbpErrorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link NBPErrorInfoType }
     *     
     */
    public void setNBPErrorInfo(NBPErrorInfoType value) {
        this.nbpErrorInfo = value;
    }

}
