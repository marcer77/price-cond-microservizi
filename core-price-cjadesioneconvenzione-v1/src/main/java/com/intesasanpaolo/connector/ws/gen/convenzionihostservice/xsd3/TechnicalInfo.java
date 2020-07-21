//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:02 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice.xsd3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per TechnicalInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="TechnicalInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApplicationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CallerProgramName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CallerServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ChannelIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TechnicalInfo", propOrder = {
    "applicationID",
    "callerProgramName",
    "callerServerName",
    "channelIDCode"
})
public class TechnicalInfo {

    @XmlElementRef(name = "ApplicationID", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationID;
    @XmlElementRef(name = "CallerProgramName", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> callerProgramName;
    @XmlElementRef(name = "CallerServerName", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> callerServerName;
    @XmlElementRef(name = "ChannelIDCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> channelIDCode;

    /**
     * Recupera il valore della proprietà applicationID.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicationID() {
        return applicationID;
    }

    /**
     * Imposta il valore della proprietà applicationID.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicationID(JAXBElement<String> value) {
        this.applicationID = value;
    }

    /**
     * Recupera il valore della proprietà callerProgramName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCallerProgramName() {
        return callerProgramName;
    }

    /**
     * Imposta il valore della proprietà callerProgramName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCallerProgramName(JAXBElement<String> value) {
        this.callerProgramName = value;
    }

    /**
     * Recupera il valore della proprietà callerServerName.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCallerServerName() {
        return callerServerName;
    }

    /**
     * Imposta il valore della proprietà callerServerName.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCallerServerName(JAXBElement<String> value) {
        this.callerServerName = value;
    }

    /**
     * Recupera il valore della proprietà channelIDCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChannelIDCode() {
        return channelIDCode;
    }

    /**
     * Imposta il valore della proprietà channelIDCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChannelIDCode(JAXBElement<String> value) {
        this.channelIDCode = value;
    }

}
