//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IIBCDPRCMSResponseType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IIBCDPRCMSResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outputProdotto" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}IIBCDPRCMSSingleResponseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="Response" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}responseNBP_ErrorInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IIBCDPRCMSResponseType", propOrder = {
    "outputProdotto",
    "response"
})
public class IIBCDPRCMSResponseType {

    protected List<IIBCDPRCMSSingleResponseType> outputProdotto;
    @XmlElement(name = "Response")
    protected ResponseNBPErrorInfo response;

    /**
     * Gets the value of the outputProdotto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputProdotto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputProdotto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IIBCDPRCMSSingleResponseType }
     * 
     * 
     */
    public List<IIBCDPRCMSSingleResponseType> getOutputProdotto() {
        if (outputProdotto == null) {
            outputProdotto = new ArrayList<IIBCDPRCMSSingleResponseType>();
        }
        return this.outputProdotto;
    }

    /**
     * Recupera il valore della proprietà response.
     * 
     * @return
     *     possible object is
     *     {@link ResponseNBPErrorInfo }
     *     
     */
    public ResponseNBPErrorInfo getResponse() {
        return response;
    }

    /**
     * Imposta il valore della proprietà response.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseNBPErrorInfo }
     *     
     */
    public void setResponse(ResponseNBPErrorInfo value) {
        this.response = value;
    }

}
