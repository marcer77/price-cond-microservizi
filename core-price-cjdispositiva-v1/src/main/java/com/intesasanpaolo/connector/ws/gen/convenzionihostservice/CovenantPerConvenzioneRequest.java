//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.19 alle 12:00:12 PM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CovenantPerConvenzione_Request complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CovenantPerConvenzione_Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Applicativo_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodConvenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataDiNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Adesione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Filiale_UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ID_ProdottoCovenant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RapportoABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RapportoCategoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RapportoConto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RapportoFiliale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovenantPerConvenzione_Request", propOrder = {
    "abi",
    "applicativoId",
    "codConvenzione",
    "dataDiNascita",
    "dataAdesione",
    "filialeUserId",
    "idProdottoCovenant",
    "rapportoABI",
    "rapportoCategoria",
    "rapportoConto",
    "rapportoFiliale",
    "userId"
})
public class CovenantPerConvenzioneRequest {

    @XmlElementRef(name = "ABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> abi;
    @XmlElementRef(name = "Applicativo_Id", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicativoId;
    @XmlElementRef(name = "CodConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codConvenzione;
    @XmlElementRef(name = "DataDiNascita", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataDiNascita;
    @XmlElementRef(name = "Data_Adesione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataAdesione;
    @XmlElementRef(name = "Filiale_UserId", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filialeUserId;
    @XmlElementRef(name = "ID_ProdottoCovenant", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idProdottoCovenant;
    @XmlElementRef(name = "RapportoABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoABI;
    @XmlElementRef(name = "RapportoCategoria", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCategoria;
    @XmlElementRef(name = "RapportoConto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoConto;
    @XmlElementRef(name = "RapportoFiliale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoFiliale;
    @XmlElementRef(name = "UserId", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userId;

    /**
     * Recupera il valore della proprietà abi.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getABI() {
        return abi;
    }

    /**
     * Imposta il valore della proprietà abi.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setABI(JAXBElement<String> value) {
        this.abi = value;
    }

    /**
     * Recupera il valore della proprietà applicativoId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicativoId() {
        return applicativoId;
    }

    /**
     * Imposta il valore della proprietà applicativoId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicativoId(JAXBElement<String> value) {
        this.applicativoId = value;
    }

    /**
     * Recupera il valore della proprietà codConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodConvenzione() {
        return codConvenzione;
    }

    /**
     * Imposta il valore della proprietà codConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodConvenzione(JAXBElement<String> value) {
        this.codConvenzione = value;
    }

    /**
     * Recupera il valore della proprietà dataDiNascita.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataDiNascita() {
        return dataDiNascita;
    }

    /**
     * Imposta il valore della proprietà dataDiNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataDiNascita(JAXBElement<String> value) {
        this.dataDiNascita = value;
    }

    /**
     * Recupera il valore della proprietà dataAdesione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataAdesione() {
        return dataAdesione;
    }

    /**
     * Imposta il valore della proprietà dataAdesione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataAdesione(JAXBElement<String> value) {
        this.dataAdesione = value;
    }

    /**
     * Recupera il valore della proprietà filialeUserId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFilialeUserId() {
        return filialeUserId;
    }

    /**
     * Imposta il valore della proprietà filialeUserId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFilialeUserId(JAXBElement<String> value) {
        this.filialeUserId = value;
    }

    /**
     * Recupera il valore della proprietà idProdottoCovenant.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIDProdottoCovenant() {
        return idProdottoCovenant;
    }

    /**
     * Imposta il valore della proprietà idProdottoCovenant.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDProdottoCovenant(JAXBElement<String> value) {
        this.idProdottoCovenant = value;
    }

    /**
     * Recupera il valore della proprietà rapportoABI.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoABI() {
        return rapportoABI;
    }

    /**
     * Imposta il valore della proprietà rapportoABI.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoABI(JAXBElement<String> value) {
        this.rapportoABI = value;
    }

    /**
     * Recupera il valore della proprietà rapportoCategoria.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoCategoria() {
        return rapportoCategoria;
    }

    /**
     * Imposta il valore della proprietà rapportoCategoria.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoCategoria(JAXBElement<String> value) {
        this.rapportoCategoria = value;
    }

    /**
     * Recupera il valore della proprietà rapportoConto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoConto() {
        return rapportoConto;
    }

    /**
     * Imposta il valore della proprietà rapportoConto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoConto(JAXBElement<String> value) {
        this.rapportoConto = value;
    }

    /**
     * Recupera il valore della proprietà rapportoFiliale.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoFiliale() {
        return rapportoFiliale;
    }

    /**
     * Imposta il valore della proprietà rapportoFiliale.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoFiliale(JAXBElement<String> value) {
        this.rapportoFiliale = value;
    }

    /**
     * Recupera il valore della proprietà userId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserId() {
        return userId;
    }

    /**
     * Imposta il valore della proprietà userId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserId(JAXBElement<String> value) {
        this.userId = value;
    }

}
