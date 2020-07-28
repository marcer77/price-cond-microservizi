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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Adesione_Request complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Adesione_Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ApplicativoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Codice_Convenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataAccensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Adesione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Filiale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Flag_Tipo_Cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ListaCodiciFiscali" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfCodiceFiscale" minOccurs="0"/&gt;
 *         &lt;element name="NDG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PIVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ROL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Categoria_Stipendio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Codice_Stipendio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Filiale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Filiale_Stipendio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Tipo_Chiamata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Adesione_Request", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "abi",
    "applicativoId",
    "codiceConvenzione",
    "dataAccensione",
    "dataAdesione",
    "filiale",
    "flagTipoCliente",
    "listaCodiciFiscali",
    "ndg",
    "piva",
    "rol",
    "rapportoCategoria",
    "rapportoCategoriaStipendio",
    "rapportoCodice",
    "rapportoCodiceStipendio",
    "rapportoFiliale",
    "rapportoFilialeStipendio",
    "rating",
    "tipoChiamata",
    "userId"
})
public class AdesioneRequest {

    @XmlElementRef(name = "ABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> abi;
    @XmlElementRef(name = "ApplicativoId", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicativoId;
    @XmlElementRef(name = "Codice_Convenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceConvenzione;
    @XmlElementRef(name = "DataAccensione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataAccensione;
    @XmlElementRef(name = "Data_Adesione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataAdesione;
    @XmlElementRef(name = "Filiale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> filiale;
    @XmlElementRef(name = "Flag_Tipo_Cliente", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flagTipoCliente;
    @XmlElementRef(name = "ListaCodiciFiscali", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCodiceFiscale> listaCodiciFiscali;
    @XmlElementRef(name = "NDG", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ndg;
    @XmlElementRef(name = "PIVA", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> piva;
    @XmlElementRef(name = "ROL", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rol;
    @XmlElementRef(name = "Rapporto_Categoria", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCategoria;
    @XmlElementRef(name = "Rapporto_Categoria_Stipendio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCategoriaStipendio;
    @XmlElementRef(name = "Rapporto_Codice", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCodice;
    @XmlElementRef(name = "Rapporto_Codice_Stipendio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCodiceStipendio;
    @XmlElementRef(name = "Rapporto_Filiale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoFiliale;
    @XmlElementRef(name = "Rapporto_Filiale_Stipendio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoFilialeStipendio;
    @XmlElementRef(name = "Rating", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rating;
    @XmlElementRef(name = "Tipo_Chiamata", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoChiamata;
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
     * Recupera il valore della proprietà codiceConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceConvenzione() {
        return codiceConvenzione;
    }

    /**
     * Imposta il valore della proprietà codiceConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceConvenzione(JAXBElement<String> value) {
        this.codiceConvenzione = value;
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
     * Recupera il valore della proprietà filiale.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFiliale() {
        return filiale;
    }

    /**
     * Imposta il valore della proprietà filiale.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFiliale(JAXBElement<String> value) {
        this.filiale = value;
    }

    /**
     * Recupera il valore della proprietà flagTipoCliente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagTipoCliente() {
        return flagTipoCliente;
    }

    /**
     * Imposta il valore della proprietà flagTipoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagTipoCliente(JAXBElement<String> value) {
        this.flagTipoCliente = value;
    }

    /**
     * Recupera il valore della proprietà listaCodiciFiscali.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCodiceFiscale> getListaCodiciFiscali() {
        return listaCodiciFiscali;
    }

    /**
     * Imposta il valore della proprietà listaCodiciFiscali.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     *     
     */
    public void setListaCodiciFiscali(JAXBElement<ArrayOfCodiceFiscale> value) {
        this.listaCodiciFiscali = value;
    }

    /**
     * Recupera il valore della proprietà ndg.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNDG() {
        return ndg;
    }

    /**
     * Imposta il valore della proprietà ndg.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNDG(JAXBElement<String> value) {
        this.ndg = value;
    }

    /**
     * Recupera il valore della proprietà piva.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPIVA() {
        return piva;
    }

    /**
     * Imposta il valore della proprietà piva.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPIVA(JAXBElement<String> value) {
        this.piva = value;
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
     * Recupera il valore della proprietà rapportoCategoriaStipendio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoCategoriaStipendio() {
        return rapportoCategoriaStipendio;
    }

    /**
     * Imposta il valore della proprietà rapportoCategoriaStipendio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoCategoriaStipendio(JAXBElement<String> value) {
        this.rapportoCategoriaStipendio = value;
    }

    /**
     * Recupera il valore della proprietà rapportoCodice.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoCodice() {
        return rapportoCodice;
    }

    /**
     * Imposta il valore della proprietà rapportoCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoCodice(JAXBElement<String> value) {
        this.rapportoCodice = value;
    }

    /**
     * Recupera il valore della proprietà rapportoCodiceStipendio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoCodiceStipendio() {
        return rapportoCodiceStipendio;
    }

    /**
     * Imposta il valore della proprietà rapportoCodiceStipendio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoCodiceStipendio(JAXBElement<String> value) {
        this.rapportoCodiceStipendio = value;
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
     * Recupera il valore della proprietà rapportoFilialeStipendio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRapportoFilialeStipendio() {
        return rapportoFilialeStipendio;
    }

    /**
     * Imposta il valore della proprietà rapportoFilialeStipendio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRapportoFilialeStipendio(JAXBElement<String> value) {
        this.rapportoFilialeStipendio = value;
    }

    /**
     * Recupera il valore della proprietà rating.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRating() {
        return rating;
    }

    /**
     * Imposta il valore della proprietà rating.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRating(JAXBElement<String> value) {
        this.rating = value;
    }

    /**
     * Recupera il valore della proprietà tipoChiamata.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoChiamata() {
        return tipoChiamata;
    }

    /**
     * Imposta il valore della proprietà tipoChiamata.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoChiamata(JAXBElement<String> value) {
        this.tipoChiamata = value;
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
