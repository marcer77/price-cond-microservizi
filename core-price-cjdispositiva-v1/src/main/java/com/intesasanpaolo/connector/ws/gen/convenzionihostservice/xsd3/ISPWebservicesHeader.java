//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:47 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice.xsd3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ISPWebservicesHeader complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ISPWebservicesHeader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AdditionalBusinessInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}AdditionalBusinessInfo" minOccurs="0"/&gt;
 *         &lt;element name="BusinessInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}BusinessInfo" minOccurs="0"/&gt;
 *         &lt;element name="CompanyInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}CompanyInfo" minOccurs="0"/&gt;
 *         &lt;element name="OperatorInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}OperatorInfo" minOccurs="0"/&gt;
 *         &lt;element name="RequestInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}RequestInfo" minOccurs="0"/&gt;
 *         &lt;element name="TechnicalInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione}TechnicalInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ISPWebservicesHeader", propOrder = {
    "additionalBusinessInfo",
    "businessInfo",
    "companyInfo",
    "operatorInfo",
    "requestInfo",
    "technicalInfo"
})
public class ISPWebservicesHeader {

    @XmlElementRef(name = "AdditionalBusinessInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<AdditionalBusinessInfo> additionalBusinessInfo;
    @XmlElementRef(name = "BusinessInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BusinessInfo> businessInfo;
    @XmlElementRef(name = "CompanyInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<CompanyInfo> companyInfo;
    @XmlElementRef(name = "OperatorInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<OperatorInfo> operatorInfo;
    @XmlElementRef(name = "RequestInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<RequestInfo> requestInfo;
    @XmlElementRef(name = "TechnicalInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<TechnicalInfo> technicalInfo;

    /**
     * Recupera il valore della proprietà additionalBusinessInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AdditionalBusinessInfo }{@code >}
     *     
     */
    public JAXBElement<AdditionalBusinessInfo> getAdditionalBusinessInfo() {
        return additionalBusinessInfo;
    }

    /**
     * Imposta il valore della proprietà additionalBusinessInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AdditionalBusinessInfo }{@code >}
     *     
     */
    public void setAdditionalBusinessInfo(JAXBElement<AdditionalBusinessInfo> value) {
        this.additionalBusinessInfo = value;
    }

    /**
     * Recupera il valore della proprietà businessInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BusinessInfo }{@code >}
     *     
     */
    public JAXBElement<BusinessInfo> getBusinessInfo() {
        return businessInfo;
    }

    /**
     * Imposta il valore della proprietà businessInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BusinessInfo }{@code >}
     *     
     */
    public void setBusinessInfo(JAXBElement<BusinessInfo> value) {
        this.businessInfo = value;
    }

    /**
     * Recupera il valore della proprietà companyInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CompanyInfo }{@code >}
     *     
     */
    public JAXBElement<CompanyInfo> getCompanyInfo() {
        return companyInfo;
    }

    /**
     * Imposta il valore della proprietà companyInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CompanyInfo }{@code >}
     *     
     */
    public void setCompanyInfo(JAXBElement<CompanyInfo> value) {
        this.companyInfo = value;
    }

    /**
     * Recupera il valore della proprietà operatorInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OperatorInfo }{@code >}
     *     
     */
    public JAXBElement<OperatorInfo> getOperatorInfo() {
        return operatorInfo;
    }

    /**
     * Imposta il valore della proprietà operatorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OperatorInfo }{@code >}
     *     
     */
    public void setOperatorInfo(JAXBElement<OperatorInfo> value) {
        this.operatorInfo = value;
    }

    /**
     * Recupera il valore della proprietà requestInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RequestInfo }{@code >}
     *     
     */
    public JAXBElement<RequestInfo> getRequestInfo() {
        return requestInfo;
    }

    /**
     * Imposta il valore della proprietà requestInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RequestInfo }{@code >}
     *     
     */
    public void setRequestInfo(JAXBElement<RequestInfo> value) {
        this.requestInfo = value;
    }

    /**
     * Recupera il valore della proprietà technicalInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TechnicalInfo }{@code >}
     *     
     */
    public JAXBElement<TechnicalInfo> getTechnicalInfo() {
        return technicalInfo;
    }

    /**
     * Imposta il valore della proprietà technicalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TechnicalInfo }{@code >}
     *     
     */
    public void setTechnicalInfo(JAXBElement<TechnicalInfo> value) {
        this.technicalInfo = value;
    }

}
