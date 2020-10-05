//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:35:11 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Adesione_Response complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Adesione_Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Esito" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Class.Esito" minOccurs="0"/&gt;
 *         &lt;element name="ResponseLog" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.Entities}ResponseLog" minOccurs="0"/&gt;
 *         &lt;element name="TabellaBenefici" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfAdesione_Response.Benefici" minOccurs="0"/&gt;
 *         &lt;element name="TabellaBenefici_Length" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="TabellaRequisiti" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfAdesione_Response.Adesione_Dettaglio" minOccurs="0"/&gt;
 *         &lt;element name="TabellaRequisiti_Length" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adesione_Response", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "esito",
    "responseLog",
    "tabellaBenefici",
    "tabellaBeneficiLength",
    "tabellaRequisiti",
    "tabellaRequisitiLength"
})
public class AdesioneResponse {

    @XmlElementRef(name = "Esito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ClassEsito> esito;
    @XmlElementRef(name = "ResponseLog", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ResponseLog> responseLog;
    @XmlElementRef(name = "TabellaBenefici", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAdesioneResponseBenefici> tabellaBenefici;
    @XmlElement(name = "TabellaBenefici_Length")
    protected Integer tabellaBeneficiLength;
    @XmlElementRef(name = "TabellaRequisiti", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio> tabellaRequisiti;
    @XmlElement(name = "TabellaRequisiti_Length")
    protected Integer tabellaRequisitiLength;

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     *     
     */
    public JAXBElement<ClassEsito> getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     *     
     */
    public void setEsito(JAXBElement<ClassEsito> value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà responseLog.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     *     
     */
    public JAXBElement<ResponseLog> getResponseLog() {
        return responseLog;
    }

    /**
     * Imposta il valore della proprietà responseLog.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     *     
     */
    public void setResponseLog(JAXBElement<ResponseLog> value) {
        this.responseLog = value;
    }

    /**
     * Recupera il valore della proprietà tabellaBenefici.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAdesioneResponseBenefici> getTabellaBenefici() {
        return tabellaBenefici;
    }

    /**
     * Imposta il valore della proprietà tabellaBenefici.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     *     
     */
    public void setTabellaBenefici(JAXBElement<ArrayOfAdesioneResponseBenefici> value) {
        this.tabellaBenefici = value;
    }

    /**
     * Recupera il valore della proprietà tabellaBeneficiLength.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTabellaBeneficiLength() {
        return tabellaBeneficiLength;
    }

    /**
     * Imposta il valore della proprietà tabellaBeneficiLength.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTabellaBeneficiLength(Integer value) {
        this.tabellaBeneficiLength = value;
    }

    /**
     * Recupera il valore della proprietà tabellaRequisiti.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio> getTabellaRequisiti() {
        return tabellaRequisiti;
    }

    /**
     * Imposta il valore della proprietà tabellaRequisiti.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     *     
     */
    public void setTabellaRequisiti(JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio> value) {
        this.tabellaRequisiti = value;
    }

    /**
     * Recupera il valore della proprietà tabellaRequisitiLength.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTabellaRequisitiLength() {
        return tabellaRequisitiLength;
    }

    /**
     * Imposta il valore della proprietà tabellaRequisitiLength.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTabellaRequisitiLength(Integer value) {
        this.tabellaRequisitiLength = value;
    }

}
