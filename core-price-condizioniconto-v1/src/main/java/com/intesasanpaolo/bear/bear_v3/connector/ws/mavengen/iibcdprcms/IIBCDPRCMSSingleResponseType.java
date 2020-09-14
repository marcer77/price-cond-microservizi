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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IIBCDPRCMSSingleResponseType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IIBCDPRCMSSingleResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="outputFactory" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}OutOutputFactory" minOccurs="0"/&gt;
 *         &lt;element name="outputPrice" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}OutOutputPrice" minOccurs="0"/&gt;
 *         &lt;element name="valori" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}OutValori" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nbpErrorInfo" type="{http://ws.intesasanpaolo.com/}NBP_ErrorInfoType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IIBCDPRCMSSingleResponseType", propOrder = {
    "outputFactory",
    "outputPrice",
    "valori",
    "nbpErrorInfo"
})
public class IIBCDPRCMSSingleResponseType {

    protected OutOutputFactory outputFactory;
    protected OutOutputPrice outputPrice;
    protected List<OutValori> valori;
    protected List<NBPErrorInfoType> nbpErrorInfo;

    /**
     * Recupera il valore della proprietà outputFactory.
     * 
     * @return
     *     possible object is
     *     {@link OutOutputFactory }
     *     
     */
    public OutOutputFactory getOutputFactory() {
        return outputFactory;
    }

    /**
     * Imposta il valore della proprietà outputFactory.
     * 
     * @param value
     *     allowed object is
     *     {@link OutOutputFactory }
     *     
     */
    public void setOutputFactory(OutOutputFactory value) {
        this.outputFactory = value;
    }

    /**
     * Recupera il valore della proprietà outputPrice.
     * 
     * @return
     *     possible object is
     *     {@link OutOutputPrice }
     *     
     */
    public OutOutputPrice getOutputPrice() {
        return outputPrice;
    }

    /**
     * Imposta il valore della proprietà outputPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link OutOutputPrice }
     *     
     */
    public void setOutputPrice(OutOutputPrice value) {
        this.outputPrice = value;
    }

    /**
     * Gets the value of the valori property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valori property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValori().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutValori }
     * 
     * 
     */
    public List<OutValori> getValori() {
        if (valori == null) {
            valori = new ArrayList<OutValori>();
        }
        return this.valori;
    }

    /**
     * Gets the value of the nbpErrorInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbpErrorInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNbpErrorInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NBPErrorInfoType }
     * 
     * 
     */
    public List<NBPErrorInfoType> getNbpErrorInfo() {
        if (nbpErrorInfo == null) {
            nbpErrorInfo = new ArrayList<NBPErrorInfoType>();
        }
        return this.nbpErrorInfo;
    }

}
