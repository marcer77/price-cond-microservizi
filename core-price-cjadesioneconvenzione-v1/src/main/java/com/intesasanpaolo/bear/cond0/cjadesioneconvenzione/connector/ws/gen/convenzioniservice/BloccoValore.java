//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.14 alle 12:42:37 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Blocco_Valore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Blocco_Valore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Numerico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Parametrato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Valore_Parametrato" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Blocco_Valore", propOrder = {
    "codice",
    "tipoDeroga",
    "valoreNumerico",
    "valoreParametrato"
})
public class BloccoValore {

    @XmlElementRef(name = "Codice", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codice;
    @XmlElementRef(name = "TipoDeroga", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoDeroga;
    @XmlElementRef(name = "Valore_Numerico", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> valoreNumerico;
    @XmlElementRef(name = "Valore_Parametrato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ValoreParametrato> valoreParametrato;

    /**
     * Recupera il valore della proprietà codice.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodice() {
        return codice;
    }

    /**
     * Imposta il valore della proprietà codice.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodice(JAXBElement<String> value) {
        this.codice = value;
    }

    /**
     * Recupera il valore della proprietà tipoDeroga.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoDeroga() {
        return tipoDeroga;
    }

    /**
     * Imposta il valore della proprietà tipoDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoDeroga(JAXBElement<String> value) {
        this.tipoDeroga = value;
    }

    /**
     * Recupera il valore della proprietà valoreNumerico.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getValoreNumerico() {
        return valoreNumerico;
    }

    /**
     * Imposta il valore della proprietà valoreNumerico.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setValoreNumerico(JAXBElement<BigDecimal> value) {
        this.valoreNumerico = value;
    }

    /**
     * Recupera il valore della proprietà valoreParametrato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     *     
     */
    public JAXBElement<ValoreParametrato> getValoreParametrato() {
        return valoreParametrato;
    }

    /**
     * Imposta il valore della proprietà valoreParametrato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     *     
     */
    public void setValoreParametrato(JAXBElement<ValoreParametrato> value) {
        this.valoreParametrato = value;
    }

}
