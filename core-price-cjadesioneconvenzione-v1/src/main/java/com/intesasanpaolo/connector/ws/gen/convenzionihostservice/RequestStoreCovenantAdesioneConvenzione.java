//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:02 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Request_StoreCovenantAdesioneConvenzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Request_StoreCovenantAdesioneConvenzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Applicativo_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodConvenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodConvenzione_OLD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Operazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Filiale_UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ID_ProdottoCovenant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ListaCovenantDaAttivare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare" minOccurs="0"/&gt;
 *         &lt;element name="ListaCovenantDaCessare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaCessare" minOccurs="0"/&gt;
 *         &lt;element name="NSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumeroProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoOperazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Request_StoreCovenantAdesioneConvenzione", propOrder = {
    "abi",
    "applicativoId",
    "codConvenzione",
    "codConvenzioneOLD",
    "dataProposta",
    "dataOperazione",
    "filialeUserId",
    "idProdottoCovenant",
    "listaCovenantDaAttivare",
    "listaCovenantDaCessare",
    "nsg",
    "numeroProposta",
    "tipoOperazione",
    "userId"
})
public class RequestStoreCovenantAdesioneConvenzione {

    @XmlElementRef(name = "ABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> abi;
    @XmlElementRef(name = "Applicativo_id", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicativoId;
    @XmlElementRef(name = "CodConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codConvenzione;
    @XmlElementRef(name = "CodConvenzione_OLD", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codConvenzioneOLD;
    @XmlElementRef(name = "DataProposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataProposta;
    @XmlElementRef(name = "Data_Operazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataOperazione;
    @XmlElementRef(name = "Filiale_UserId", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filialeUserId;
    @XmlElementRef(name = "ID_ProdottoCovenant", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idProdottoCovenant;
    @XmlElementRef(name = "ListaCovenantDaAttivare", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> listaCovenantDaAttivare;
    @XmlElementRef(name = "ListaCovenantDaCessare", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> listaCovenantDaCessare;
    @XmlElementRef(name = "NSG", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nsg;
    @XmlElementRef(name = "NumeroProposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> numeroProposta;
    @XmlElementRef(name = "TipoOperazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoOperazione;
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
     * Recupera il valore della proprietà codConvenzioneOLD.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodConvenzioneOLD() {
        return codConvenzioneOLD;
    }

    /**
     * Imposta il valore della proprietà codConvenzioneOLD.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodConvenzioneOLD(JAXBElement<String> value) {
        this.codConvenzioneOLD = value;
    }

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
     * Recupera il valore della proprietà dataOperazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataOperazione() {
        return dataOperazione;
    }

    /**
     * Imposta il valore della proprietà dataOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataOperazione(JAXBElement<String> value) {
        this.dataOperazione = value;
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
     * Recupera il valore della proprietà listaCovenantDaAttivare.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> getListaCovenantDaAttivare() {
        return listaCovenantDaAttivare;
    }

    /**
     * Imposta il valore della proprietà listaCovenantDaAttivare.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     *     
     */
    public void setListaCovenantDaAttivare(JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> value) {
        this.listaCovenantDaAttivare = value;
    }

    /**
     * Recupera il valore della proprietà listaCovenantDaCessare.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> getListaCovenantDaCessare() {
        return listaCovenantDaCessare;
    }

    /**
     * Imposta il valore della proprietà listaCovenantDaCessare.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     *     
     */
    public void setListaCovenantDaCessare(JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> value) {
        this.listaCovenantDaCessare = value;
    }

    /**
     * Recupera il valore della proprietà nsg.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNSG() {
        return nsg;
    }

    /**
     * Imposta il valore della proprietà nsg.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNSG(JAXBElement<String> value) {
        this.nsg = value;
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
     * Recupera il valore della proprietà tipoOperazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoOperazione() {
        return tipoOperazione;
    }

    /**
     * Imposta il valore della proprietà tipoOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoOperazione(JAXBElement<String> value) {
        this.tipoOperazione = value;
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
