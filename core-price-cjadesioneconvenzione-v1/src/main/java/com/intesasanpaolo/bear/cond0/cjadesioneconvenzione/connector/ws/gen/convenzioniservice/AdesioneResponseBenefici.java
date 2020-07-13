//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.13 alle 10:14:52 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Adesione_Response.Benefici complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Adesione_Response.Benefici"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Configurazione_Fasce_Approvato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Configurazione_Fasce" minOccurs="0"/&gt;
 *         &lt;element name="beneficio_Tipologia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficio_ValoreCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficio_ValoreNumerico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="beneficio_ValoreParametrato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Adesione_Response.beneficio_ValoreParametrato" minOccurs="0"/&gt;
 *         &lt;element name="codiceCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceFascia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataDecorrenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataScadenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driver1_Tipologia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driver1_ValoreCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driver1_ValoreNumerico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="driver2_Tipologia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driver2_ValoreCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="driver2_ValoreNumerico" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="flagRolling" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroFascia" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adesione_Response.Benefici", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "configurazioneFasceApprovato",
    "beneficioTipologia",
    "beneficioValoreCodice",
    "beneficioValoreNumerico",
    "beneficioValoreParametrato",
    "codiceCondizione",
    "codiceFascia",
    "dataDecorrenza",
    "dataScadenza",
    "driver1Tipologia",
    "driver1ValoreCodice",
    "driver1ValoreNumerico",
    "driver2Tipologia",
    "driver2ValoreCodice",
    "driver2ValoreNumerico",
    "flagRolling",
    "numeroFascia"
})
public class AdesioneResponseBenefici {

    @XmlElementRef(name = "Configurazione_Fasce_Approvato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ConfigurazioneFasce> configurazioneFasceApprovato;
    @XmlElementRef(name = "beneficio_Tipologia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioTipologia;
    @XmlElementRef(name = "beneficio_ValoreCodice", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioValoreCodice;
    @XmlElementRef(name = "beneficio_ValoreNumerico", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> beneficioValoreNumerico;
    @XmlElementRef(name = "beneficio_ValoreParametrato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<AdesioneResponseBeneficioValoreParametrato> beneficioValoreParametrato;
    @XmlElementRef(name = "codiceCondizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceCondizione;
    @XmlElementRef(name = "codiceFascia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceFascia;
    @XmlElementRef(name = "dataDecorrenza", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataDecorrenza;
    @XmlElementRef(name = "dataScadenza", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataScadenza;
    @XmlElementRef(name = "driver1_Tipologia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> driver1Tipologia;
    @XmlElementRef(name = "driver1_ValoreCodice", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> driver1ValoreCodice;
    @XmlElementRef(name = "driver1_ValoreNumerico", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> driver1ValoreNumerico;
    @XmlElementRef(name = "driver2_Tipologia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> driver2Tipologia;
    @XmlElementRef(name = "driver2_ValoreCodice", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> driver2ValoreCodice;
    @XmlElementRef(name = "driver2_ValoreNumerico", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> driver2ValoreNumerico;
    @XmlElementRef(name = "flagRolling", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flagRolling;
    @XmlElementRef(name = "numeroFascia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<Short> numeroFascia;

    /**
     * Recupera il valore della proprietà configurazioneFasceApprovato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public JAXBElement<ConfigurazioneFasce> getConfigurazioneFasceApprovato() {
        return configurazioneFasceApprovato;
    }

    /**
     * Imposta il valore della proprietà configurazioneFasceApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public void setConfigurazioneFasceApprovato(JAXBElement<ConfigurazioneFasce> value) {
        this.configurazioneFasceApprovato = value;
    }

    /**
     * Recupera il valore della proprietà beneficioTipologia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioTipologia() {
        return beneficioTipologia;
    }

    /**
     * Imposta il valore della proprietà beneficioTipologia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioTipologia(JAXBElement<String> value) {
        this.beneficioTipologia = value;
    }

    /**
     * Recupera il valore della proprietà beneficioValoreCodice.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioValoreCodice() {
        return beneficioValoreCodice;
    }

    /**
     * Imposta il valore della proprietà beneficioValoreCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioValoreCodice(JAXBElement<String> value) {
        this.beneficioValoreCodice = value;
    }

    /**
     * Recupera il valore della proprietà beneficioValoreNumerico.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getBeneficioValoreNumerico() {
        return beneficioValoreNumerico;
    }

    /**
     * Imposta il valore della proprietà beneficioValoreNumerico.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setBeneficioValoreNumerico(JAXBElement<BigDecimal> value) {
        this.beneficioValoreNumerico = value;
    }

    /**
     * Recupera il valore della proprietà beneficioValoreParametrato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     *     
     */
    public JAXBElement<AdesioneResponseBeneficioValoreParametrato> getBeneficioValoreParametrato() {
        return beneficioValoreParametrato;
    }

    /**
     * Imposta il valore della proprietà beneficioValoreParametrato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     *     
     */
    public void setBeneficioValoreParametrato(JAXBElement<AdesioneResponseBeneficioValoreParametrato> value) {
        this.beneficioValoreParametrato = value;
    }

    /**
     * Recupera il valore della proprietà codiceCondizione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceCondizione() {
        return codiceCondizione;
    }

    /**
     * Imposta il valore della proprietà codiceCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceCondizione(JAXBElement<String> value) {
        this.codiceCondizione = value;
    }

    /**
     * Recupera il valore della proprietà codiceFascia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceFascia() {
        return codiceFascia;
    }

    /**
     * Imposta il valore della proprietà codiceFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceFascia(JAXBElement<String> value) {
        this.codiceFascia = value;
    }

    /**
     * Recupera il valore della proprietà dataDecorrenza.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataDecorrenza() {
        return dataDecorrenza;
    }

    /**
     * Imposta il valore della proprietà dataDecorrenza.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataDecorrenza(JAXBElement<String> value) {
        this.dataDecorrenza = value;
    }

    /**
     * Recupera il valore della proprietà dataScadenza.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Imposta il valore della proprietà dataScadenza.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataScadenza(JAXBElement<String> value) {
        this.dataScadenza = value;
    }

    /**
     * Recupera il valore della proprietà driver1Tipologia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDriver1Tipologia() {
        return driver1Tipologia;
    }

    /**
     * Imposta il valore della proprietà driver1Tipologia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDriver1Tipologia(JAXBElement<String> value) {
        this.driver1Tipologia = value;
    }

    /**
     * Recupera il valore della proprietà driver1ValoreCodice.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDriver1ValoreCodice() {
        return driver1ValoreCodice;
    }

    /**
     * Imposta il valore della proprietà driver1ValoreCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDriver1ValoreCodice(JAXBElement<String> value) {
        this.driver1ValoreCodice = value;
    }

    /**
     * Recupera il valore della proprietà driver1ValoreNumerico.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDriver1ValoreNumerico() {
        return driver1ValoreNumerico;
    }

    /**
     * Imposta il valore della proprietà driver1ValoreNumerico.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDriver1ValoreNumerico(JAXBElement<BigDecimal> value) {
        this.driver1ValoreNumerico = value;
    }

    /**
     * Recupera il valore della proprietà driver2Tipologia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDriver2Tipologia() {
        return driver2Tipologia;
    }

    /**
     * Imposta il valore della proprietà driver2Tipologia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDriver2Tipologia(JAXBElement<String> value) {
        this.driver2Tipologia = value;
    }

    /**
     * Recupera il valore della proprietà driver2ValoreCodice.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDriver2ValoreCodice() {
        return driver2ValoreCodice;
    }

    /**
     * Imposta il valore della proprietà driver2ValoreCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDriver2ValoreCodice(JAXBElement<String> value) {
        this.driver2ValoreCodice = value;
    }

    /**
     * Recupera il valore della proprietà driver2ValoreNumerico.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getDriver2ValoreNumerico() {
        return driver2ValoreNumerico;
    }

    /**
     * Imposta il valore della proprietà driver2ValoreNumerico.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setDriver2ValoreNumerico(JAXBElement<BigDecimal> value) {
        this.driver2ValoreNumerico = value;
    }

    /**
     * Recupera il valore della proprietà flagRolling.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagRolling() {
        return flagRolling;
    }

    /**
     * Imposta il valore della proprietà flagRolling.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagRolling(JAXBElement<String> value) {
        this.flagRolling = value;
    }

    /**
     * Recupera il valore della proprietà numeroFascia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public JAXBElement<Short> getNumeroFascia() {
        return numeroFascia;
    }

    /**
     * Imposta il valore della proprietà numeroFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Short }{@code >}
     *     
     */
    public void setNumeroFascia(JAXBElement<Short> value) {
        this.numeroFascia = value;
    }

}
