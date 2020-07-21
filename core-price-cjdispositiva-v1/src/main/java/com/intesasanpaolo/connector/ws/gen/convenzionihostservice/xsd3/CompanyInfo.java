//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:10:20 PM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice.xsd3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CompanyInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CompanyInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ISPBranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ISPCallerCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ISPServiceCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NotISPCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyInfo", propOrder = {
    "ispBranchCode",
    "ispCallerCompanyIDCode",
    "ispServiceCompanyIDCode",
    "notISPCompanyIDCode"
})
public class CompanyInfo {

    @XmlElementRef(name = "ISPBranchCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ispBranchCode;
    @XmlElementRef(name = "ISPCallerCompanyIDCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ispCallerCompanyIDCode;
    @XmlElementRef(name = "ISPServiceCompanyIDCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ispServiceCompanyIDCode;
    @XmlElementRef(name = "NotISPCompanyIDCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Services.CovenantPerConvenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> notISPCompanyIDCode;

    /**
     * Recupera il valore della proprietà ispBranchCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getISPBranchCode() {
        return ispBranchCode;
    }

    /**
     * Imposta il valore della proprietà ispBranchCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setISPBranchCode(JAXBElement<String> value) {
        this.ispBranchCode = value;
    }

    /**
     * Recupera il valore della proprietà ispCallerCompanyIDCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getISPCallerCompanyIDCode() {
        return ispCallerCompanyIDCode;
    }

    /**
     * Imposta il valore della proprietà ispCallerCompanyIDCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setISPCallerCompanyIDCode(JAXBElement<String> value) {
        this.ispCallerCompanyIDCode = value;
    }

    /**
     * Recupera il valore della proprietà ispServiceCompanyIDCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getISPServiceCompanyIDCode() {
        return ispServiceCompanyIDCode;
    }

    /**
     * Imposta il valore della proprietà ispServiceCompanyIDCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setISPServiceCompanyIDCode(JAXBElement<String> value) {
        this.ispServiceCompanyIDCode = value;
    }

    /**
     * Recupera il valore della proprietà notISPCompanyIDCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNotISPCompanyIDCode() {
        return notISPCompanyIDCode;
    }

    /**
     * Imposta il valore della proprietà notISPCompanyIDCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNotISPCompanyIDCode(JAXBElement<String> value) {
        this.notISPCompanyIDCode = value;
    }

}
