//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.19 alle 12:00:12 PM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per GetBaselinePerHost_Response.Baseline complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="GetBaselinePerHost_Response.Baseline"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="baselineValida" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceUDMBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizioneBreveTipoBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizioneEstesaTipoBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizioneUDMBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="messaggio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoDataA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoDataDa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoDescrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreBaseline" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBaselinePerHost_Response.Baseline", propOrder = {
    "baselineValida",
    "codiceTipoBaseline",
    "codiceUDMBaseline",
    "descrizioneBreveTipoBaseline",
    "descrizioneEstesaTipoBaseline",
    "descrizioneUDMBaseline",
    "esito",
    "messaggio",
    "periodoDataA",
    "periodoDataDa",
    "periodoDescrizione",
    "tipoBaseline",
    "valoreBaseline"
})
public class GetBaselinePerHostResponseBaseline {

    protected Boolean baselineValida;
    @XmlElementRef(name = "codiceTipoBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceTipoBaseline;
    @XmlElementRef(name = "codiceUDMBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceUDMBaseline;
    @XmlElementRef(name = "descrizioneBreveTipoBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrizioneBreveTipoBaseline;
    @XmlElementRef(name = "descrizioneEstesaTipoBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrizioneEstesaTipoBaseline;
    @XmlElementRef(name = "descrizioneUDMBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrizioneUDMBaseline;
    @XmlElementRef(name = "esito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> esito;
    @XmlElementRef(name = "messaggio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messaggio;
    @XmlElementRef(name = "periodoDataA", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodoDataA;
    @XmlElementRef(name = "periodoDataDa", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodoDataDa;
    @XmlElementRef(name = "periodoDescrizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodoDescrizione;
    @XmlElementRef(name = "tipoBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoBaseline;
    @XmlElementRef(name = "valoreBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> valoreBaseline;

    /**
     * Recupera il valore della proprietà baselineValida.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBaselineValida() {
        return baselineValida;
    }

    /**
     * Imposta il valore della proprietà baselineValida.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBaselineValida(Boolean value) {
        this.baselineValida = value;
    }

    /**
     * Recupera il valore della proprietà codiceTipoBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceTipoBaseline() {
        return codiceTipoBaseline;
    }

    /**
     * Imposta il valore della proprietà codiceTipoBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceTipoBaseline(JAXBElement<String> value) {
        this.codiceTipoBaseline = value;
    }

    /**
     * Recupera il valore della proprietà codiceUDMBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceUDMBaseline() {
        return codiceUDMBaseline;
    }

    /**
     * Imposta il valore della proprietà codiceUDMBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceUDMBaseline(JAXBElement<String> value) {
        this.codiceUDMBaseline = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneBreveTipoBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrizioneBreveTipoBaseline() {
        return descrizioneBreveTipoBaseline;
    }

    /**
     * Imposta il valore della proprietà descrizioneBreveTipoBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrizioneBreveTipoBaseline(JAXBElement<String> value) {
        this.descrizioneBreveTipoBaseline = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneEstesaTipoBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrizioneEstesaTipoBaseline() {
        return descrizioneEstesaTipoBaseline;
    }

    /**
     * Imposta il valore della proprietà descrizioneEstesaTipoBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrizioneEstesaTipoBaseline(JAXBElement<String> value) {
        this.descrizioneEstesaTipoBaseline = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneUDMBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrizioneUDMBaseline() {
        return descrizioneUDMBaseline;
    }

    /**
     * Imposta il valore della proprietà descrizioneUDMBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrizioneUDMBaseline(JAXBElement<String> value) {
        this.descrizioneUDMBaseline = value;
    }

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEsito(JAXBElement<String> value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della proprietà messaggio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessaggio() {
        return messaggio;
    }

    /**
     * Imposta il valore della proprietà messaggio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessaggio(JAXBElement<String> value) {
        this.messaggio = value;
    }

    /**
     * Recupera il valore della proprietà periodoDataA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriodoDataA() {
        return periodoDataA;
    }

    /**
     * Imposta il valore della proprietà periodoDataA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriodoDataA(JAXBElement<String> value) {
        this.periodoDataA = value;
    }

    /**
     * Recupera il valore della proprietà periodoDataDa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriodoDataDa() {
        return periodoDataDa;
    }

    /**
     * Imposta il valore della proprietà periodoDataDa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriodoDataDa(JAXBElement<String> value) {
        this.periodoDataDa = value;
    }

    /**
     * Recupera il valore della proprietà periodoDescrizione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriodoDescrizione() {
        return periodoDescrizione;
    }

    /**
     * Imposta il valore della proprietà periodoDescrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriodoDescrizione(JAXBElement<String> value) {
        this.periodoDescrizione = value;
    }

    /**
     * Recupera il valore della proprietà tipoBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoBaseline() {
        return tipoBaseline;
    }

    /**
     * Imposta il valore della proprietà tipoBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoBaseline(JAXBElement<String> value) {
        this.tipoBaseline = value;
    }

    /**
     * Recupera il valore della proprietà valoreBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getValoreBaseline() {
        return valoreBaseline;
    }

    /**
     * Imposta il valore della proprietà valoreBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setValoreBaseline(JAXBElement<BigDecimal> value) {
        this.valoreBaseline = value;
    }

}
