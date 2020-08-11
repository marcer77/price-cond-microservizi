//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:35:11 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Adesione_Response.Adesione_Dettaglio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Adesione_Response.Adesione_Dettaglio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flagRequisito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indicatoreRequisito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreAlfanumericoRequisito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreNumericoRequisisto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adesione_Response.Adesione_Dettaglio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "flagRequisito",
    "indicatoreRequisito",
    "valoreAlfanumericoRequisito",
    "valoreNumericoRequisisto"
})
public class AdesioneResponseAdesioneDettaglio {

    @XmlElementRef(name = "flagRequisito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flagRequisito;
    @XmlElementRef(name = "indicatoreRequisito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> indicatoreRequisito;
    @XmlElementRef(name = "valoreAlfanumericoRequisito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> valoreAlfanumericoRequisito;
    @XmlElementRef(name = "valoreNumericoRequisisto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> valoreNumericoRequisisto;

    /**
     * Recupera il valore della proprietà flagRequisito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagRequisito() {
        return flagRequisito;
    }

    /**
     * Imposta il valore della proprietà flagRequisito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagRequisito(JAXBElement<String> value) {
        this.flagRequisito = value;
    }

    /**
     * Recupera il valore della proprietà indicatoreRequisito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIndicatoreRequisito() {
        return indicatoreRequisito;
    }

    /**
     * Imposta il valore della proprietà indicatoreRequisito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIndicatoreRequisito(JAXBElement<String> value) {
        this.indicatoreRequisito = value;
    }

    /**
     * Recupera il valore della proprietà valoreAlfanumericoRequisito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValoreAlfanumericoRequisito() {
        return valoreAlfanumericoRequisito;
    }

    /**
     * Imposta il valore della proprietà valoreAlfanumericoRequisito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValoreAlfanumericoRequisito(JAXBElement<String> value) {
        this.valoreAlfanumericoRequisito = value;
    }

    /**
     * Recupera il valore della proprietà valoreNumericoRequisisto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getValoreNumericoRequisisto() {
        return valoreNumericoRequisisto;
    }

    /**
     * Imposta il valore della proprietà valoreNumericoRequisisto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setValoreNumericoRequisisto(JAXBElement<BigDecimal> value) {
        this.valoreNumericoRequisisto = value;
    }

}
