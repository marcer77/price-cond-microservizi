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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per DatiApplicativi complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="DatiApplicativi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FunctionId" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}InpFunctionId"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatiApplicativi", propOrder = {
    "functionId"
})
public class DatiApplicativi {

    @XmlElement(name = "FunctionId", required = true)
    @XmlSchemaType(name = "string")
    protected InpFunctionId functionId;

    /**
     * Recupera il valore della proprietà functionId.
     * 
     * @return
     *     possible object is
     *     {@link InpFunctionId }
     *     
     */
    public InpFunctionId getFunctionId() {
        return functionId;
    }

    /**
     * Imposta il valore della proprietà functionId.
     * 
     * @param value
     *     allowed object is
     *     {@link InpFunctionId }
     *     
     */
    public void setFunctionId(InpFunctionId value) {
        this.functionId = value;
    }

}
