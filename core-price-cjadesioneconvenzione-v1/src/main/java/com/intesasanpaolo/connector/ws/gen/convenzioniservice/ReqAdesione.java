//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Req_Adesione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Req_Adesione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccreditoStipendio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Adesione_Data_Accensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataAccensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Validata_Documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EvaCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EvaCliente_A" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EvaCliente_Da" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Fatturato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Fatturato_A" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Fatturato_Da" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Flag_Data_Accensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GG_Data_Accensione" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="Minter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Minter_A" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Minter_DA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Portafoglio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ROL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RatingOnline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="VersoControllo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Req_Adesione", propOrder = {
    "accreditoStipendio",
    "adesioneDataAccensione",
    "dataAccensione",
    "dataValidataDocumento",
    "evaCliente",
    "evaClienteA",
    "evaClienteDa",
    "fatturato",
    "fatturatoA",
    "fatturatoDa",
    "flagDataAccensione",
    "ggDataAccensione",
    "minter",
    "minterA",
    "minterDA",
    "portafoglio",
    "rol",
    "ratingOnline",
    "versoControllo"
})
public class ReqAdesione {

    @XmlElementRef(name = "AccreditoStipendio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accreditoStipendio;
    @XmlElementRef(name = "Adesione_Data_Accensione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adesioneDataAccensione;
    @XmlElementRef(name = "DataAccensione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataAccensione;
    @XmlElementRef(name = "Data_Validata_Documento", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataValidataDocumento;
    @XmlElementRef(name = "EvaCliente", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> evaCliente;
    @XmlElementRef(name = "EvaCliente_A", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> evaClienteA;
    @XmlElementRef(name = "EvaCliente_Da", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> evaClienteDa;
    @XmlElementRef(name = "Fatturato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fatturato;
    @XmlElementRef(name = "Fatturato_A", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> fatturatoA;
    @XmlElementRef(name = "Fatturato_Da", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> fatturatoDa;
    @XmlElementRef(name = "Flag_Data_Accensione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flagDataAccensione;
    @XmlElement(name = "GG_Data_Accensione")
    protected Short ggDataAccensione;
    @XmlElementRef(name = "Minter", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> minter;
    @XmlElementRef(name = "Minter_A", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> minterA;
    @XmlElementRef(name = "Minter_DA", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> minterDA;
    @XmlElementRef(name = "Portafoglio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> portafoglio;
    @XmlElementRef(name = "ROL", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rol;
    @XmlElementRef(name = "RatingOnline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ratingOnline;
    @XmlElementRef(name = "VersoControllo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> versoControllo;

    /**
     * Recupera il valore della proprietà accreditoStipendio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccreditoStipendio() {
        return accreditoStipendio;
    }

    /**
     * Imposta il valore della proprietà accreditoStipendio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccreditoStipendio(JAXBElement<String> value) {
        this.accreditoStipendio = value;
    }

    /**
     * Recupera il valore della proprietà adesioneDataAccensione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdesioneDataAccensione() {
        return adesioneDataAccensione;
    }

    /**
     * Imposta il valore della proprietà adesioneDataAccensione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdesioneDataAccensione(JAXBElement<String> value) {
        this.adesioneDataAccensione = value;
    }

    /**
     * Recupera il valore della proprietà dataAccensione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataAccensione() {
        return dataAccensione;
    }

    /**
     * Imposta il valore della proprietà dataAccensione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataAccensione(JAXBElement<String> value) {
        this.dataAccensione = value;
    }

    /**
     * Recupera il valore della proprietà dataValidataDocumento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataValidataDocumento() {
        return dataValidataDocumento;
    }

    /**
     * Imposta il valore della proprietà dataValidataDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataValidataDocumento(JAXBElement<String> value) {
        this.dataValidataDocumento = value;
    }

    /**
     * Recupera il valore della proprietà evaCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEvaCliente() {
        return evaCliente;
    }

    /**
     * Imposta il valore della proprietà evaCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEvaCliente(JAXBElement<String> value) {
        this.evaCliente = value;
    }

    /**
     * Recupera il valore della proprietà evaClienteA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEvaClienteA() {
        return evaClienteA;
    }

    /**
     * Imposta il valore della proprietà evaClienteA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEvaClienteA(JAXBElement<String> value) {
        this.evaClienteA = value;
    }

    /**
     * Recupera il valore della proprietà evaClienteDa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEvaClienteDa() {
        return evaClienteDa;
    }

    /**
     * Imposta il valore della proprietà evaClienteDa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEvaClienteDa(JAXBElement<String> value) {
        this.evaClienteDa = value;
    }

    /**
     * Recupera il valore della proprietà fatturato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFatturato() {
        return fatturato;
    }

    /**
     * Imposta il valore della proprietà fatturato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFatturato(JAXBElement<String> value) {
        this.fatturato = value;
    }

    /**
     * Recupera il valore della proprietà fatturatoA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFatturatoA() {
        return fatturatoA;
    }

    /**
     * Imposta il valore della proprietà fatturatoA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFatturatoA(JAXBElement<BigDecimal> value) {
        this.fatturatoA = value;
    }

    /**
     * Recupera il valore della proprietà fatturatoDa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getFatturatoDa() {
        return fatturatoDa;
    }

    /**
     * Imposta il valore della proprietà fatturatoDa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setFatturatoDa(JAXBElement<BigDecimal> value) {
        this.fatturatoDa = value;
    }

    /**
     * Recupera il valore della proprietà flagDataAccensione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagDataAccensione() {
        return flagDataAccensione;
    }

    /**
     * Imposta il valore della proprietà flagDataAccensione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagDataAccensione(JAXBElement<String> value) {
        this.flagDataAccensione = value;
    }

    /**
     * Recupera il valore della proprietà ggDataAccensione.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getGGDataAccensione() {
        return ggDataAccensione;
    }

    /**
     * Imposta il valore della proprietà ggDataAccensione.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setGGDataAccensione(Short value) {
        this.ggDataAccensione = value;
    }

    /**
     * Recupera il valore della proprietà minter.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinter() {
        return minter;
    }

    /**
     * Imposta il valore della proprietà minter.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinter(JAXBElement<String> value) {
        this.minter = value;
    }

    /**
     * Recupera il valore della proprietà minterA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMinterA() {
        return minterA;
    }

    /**
     * Imposta il valore della proprietà minterA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMinterA(JAXBElement<BigDecimal> value) {
        this.minterA = value;
    }

    /**
     * Recupera il valore della proprietà minterDA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getMinterDA() {
        return minterDA;
    }

    /**
     * Imposta il valore della proprietà minterDA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setMinterDA(JAXBElement<BigDecimal> value) {
        this.minterDA = value;
    }

    /**
     * Recupera il valore della proprietà portafoglio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPortafoglio() {
        return portafoglio;
    }

    /**
     * Imposta il valore della proprietà portafoglio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPortafoglio(JAXBElement<String> value) {
        this.portafoglio = value;
    }

    /**
     * Recupera il valore della proprietà rol.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getROL() {
        return rol;
    }

    /**
     * Imposta il valore della proprietà rol.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setROL(JAXBElement<String> value) {
        this.rol = value;
    }

    /**
     * Recupera il valore della proprietà ratingOnline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRatingOnline() {
        return ratingOnline;
    }

    /**
     * Imposta il valore della proprietà ratingOnline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRatingOnline(JAXBElement<String> value) {
        this.ratingOnline = value;
    }

    /**
     * Recupera il valore della proprietà versoControllo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersoControllo() {
        return versoControllo;
    }

    /**
     * Imposta il valore della proprietà versoControllo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersoControllo(JAXBElement<String> value) {
        this.versoControllo = value;
    }

}
