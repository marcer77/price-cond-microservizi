//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.14 alle 12:42:37 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Proposta complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Proposta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DataProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserInfo" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}UserInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Proposta", propOrder = {
    "dataProposta",
    "numeroProposta",
    "userInfo"
})
public class Proposta {

    @XmlElementRef(name = "DataProposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataProposta;
    @XmlElementRef(name = "NumeroProposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> numeroProposta;
    @XmlElementRef(name = "UserInfo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<UserInfo> userInfo;

    /**
     * Recupera il valore della proprietà dataProposta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataProposta() {
        return dataProposta;
    }

    /**
     * Imposta il valore della proprietà dataProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataProposta(JAXBElement<String> value) {
        this.dataProposta = value;
    }

    /**
     * Recupera il valore della proprietà numeroProposta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumeroProposta() {
        return numeroProposta;
    }

    /**
     * Imposta il valore della proprietà numeroProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumeroProposta(JAXBElement<String> value) {
        this.numeroProposta = value;
    }

    /**
     * Recupera il valore della proprietà userInfo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     *     
     */
    public JAXBElement<UserInfo> getUserInfo() {
        return userInfo;
    }

    /**
     * Imposta il valore della proprietà userInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     *     
     */
    public void setUserInfo(JAXBElement<UserInfo> value) {
        this.userInfo = value;
    }

}
