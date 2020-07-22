//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:47 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cod_Condizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Progressivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Conto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Filiale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtApplicazioneBeneficio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtBaseline1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtBaseline2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtEventoComposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtModalitaRilevazione1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtModalitaRilevazione2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtPerimetroMonitoraggio1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtPerimetroMonitoraggio2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtPeriodicitaRilevazione1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTxtPeriodicitaRilevazione2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="versioneTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato", propOrder = {
    "codCondizione",
    "progressivo",
    "rapportoCategoria",
    "rapportoConto",
    "rapportoFiliale",
    "codiceTemplate",
    "errorMessage",
    "idTxtApplicazioneBeneficio",
    "idTxtBaseline1",
    "idTxtBaseline2",
    "idTxtEventoComposto",
    "idTxtModalitaRilevazione1",
    "idTxtModalitaRilevazione2",
    "idTxtPerimetroMonitoraggio1",
    "idTxtPerimetroMonitoraggio2",
    "idTxtPeriodicitaRilevazione1",
    "idTxtPeriodicitaRilevazione2",
    "resultCode",
    "versioneTemplate"
})
public class ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato {

    @XmlElementRef(name = "Cod_Condizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codCondizione;
    @XmlElementRef(name = "Progressivo", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> progressivo;
    @XmlElementRef(name = "Rapporto_Categoria", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoCategoria;
    @XmlElementRef(name = "Rapporto_Conto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoConto;
    @XmlElementRef(name = "Rapporto_Filiale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rapportoFiliale;
    @XmlElementRef(name = "codiceTemplate", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceTemplate;
    @XmlElementRef(name = "errorMessage", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    @XmlElementRef(name = "idTxtApplicazioneBeneficio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtApplicazioneBeneficio;
    @XmlElementRef(name = "idTxtBaseline1", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtBaseline1;
    @XmlElementRef(name = "idTxtBaseline2", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtBaseline2;
    @XmlElementRef(name = "idTxtEventoComposto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtEventoComposto;
    @XmlElementRef(name = "idTxtModalitaRilevazione1", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtModalitaRilevazione1;
    @XmlElementRef(name = "idTxtModalitaRilevazione2", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtModalitaRilevazione2;
    @XmlElementRef(name = "idTxtPerimetroMonitoraggio1", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtPerimetroMonitoraggio1;
    @XmlElementRef(name = "idTxtPerimetroMonitoraggio2", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtPerimetroMonitoraggio2;
    @XmlElementRef(name = "idTxtPeriodicitaRilevazione1", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtPeriodicitaRilevazione1;
    @XmlElementRef(name = "idTxtPeriodicitaRilevazione2", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idTxtPeriodicitaRilevazione2;
    @XmlElementRef(name = "resultCode", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resultCode;
    @XmlElementRef(name = "versioneTemplate", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> versioneTemplate;

    /**
     * Recupera il valore della proprietà codCondizione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodCondizione() {
        return codCondizione;
    }

    /**
     * Imposta il valore della proprietà codCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodCondizione(JAXBElement<String> value) {
        this.codCondizione = value;
    }

    /**
     * Recupera il valore della proprietà progressivo.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProgressivo() {
        return progressivo;
    }

    /**
     * Imposta il valore della proprietà progressivo.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProgressivo(JAXBElement<String> value) {
        this.progressivo = value;
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
     * Recupera il valore della proprietà codiceTemplate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceTemplate() {
        return codiceTemplate;
    }

    /**
     * Imposta il valore della proprietà codiceTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceTemplate(JAXBElement<String> value) {
        this.codiceTemplate = value;
    }

    /**
     * Recupera il valore della proprietà errorMessage.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Imposta il valore della proprietà errorMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorMessage(JAXBElement<String> value) {
        this.errorMessage = value;
    }

    /**
     * Recupera il valore della proprietà idTxtApplicazioneBeneficio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtApplicazioneBeneficio() {
        return idTxtApplicazioneBeneficio;
    }

    /**
     * Imposta il valore della proprietà idTxtApplicazioneBeneficio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtApplicazioneBeneficio(JAXBElement<String> value) {
        this.idTxtApplicazioneBeneficio = value;
    }

    /**
     * Recupera il valore della proprietà idTxtBaseline1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtBaseline1() {
        return idTxtBaseline1;
    }

    /**
     * Imposta il valore della proprietà idTxtBaseline1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtBaseline1(JAXBElement<String> value) {
        this.idTxtBaseline1 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtBaseline2.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtBaseline2() {
        return idTxtBaseline2;
    }

    /**
     * Imposta il valore della proprietà idTxtBaseline2.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtBaseline2(JAXBElement<String> value) {
        this.idTxtBaseline2 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtEventoComposto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtEventoComposto() {
        return idTxtEventoComposto;
    }

    /**
     * Imposta il valore della proprietà idTxtEventoComposto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtEventoComposto(JAXBElement<String> value) {
        this.idTxtEventoComposto = value;
    }

    /**
     * Recupera il valore della proprietà idTxtModalitaRilevazione1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtModalitaRilevazione1() {
        return idTxtModalitaRilevazione1;
    }

    /**
     * Imposta il valore della proprietà idTxtModalitaRilevazione1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtModalitaRilevazione1(JAXBElement<String> value) {
        this.idTxtModalitaRilevazione1 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtModalitaRilevazione2.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtModalitaRilevazione2() {
        return idTxtModalitaRilevazione2;
    }

    /**
     * Imposta il valore della proprietà idTxtModalitaRilevazione2.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtModalitaRilevazione2(JAXBElement<String> value) {
        this.idTxtModalitaRilevazione2 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtPerimetroMonitoraggio1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtPerimetroMonitoraggio1() {
        return idTxtPerimetroMonitoraggio1;
    }

    /**
     * Imposta il valore della proprietà idTxtPerimetroMonitoraggio1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtPerimetroMonitoraggio1(JAXBElement<String> value) {
        this.idTxtPerimetroMonitoraggio1 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtPerimetroMonitoraggio2.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtPerimetroMonitoraggio2() {
        return idTxtPerimetroMonitoraggio2;
    }

    /**
     * Imposta il valore della proprietà idTxtPerimetroMonitoraggio2.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtPerimetroMonitoraggio2(JAXBElement<String> value) {
        this.idTxtPerimetroMonitoraggio2 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtPeriodicitaRilevazione1.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtPeriodicitaRilevazione1() {
        return idTxtPeriodicitaRilevazione1;
    }

    /**
     * Imposta il valore della proprietà idTxtPeriodicitaRilevazione1.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtPeriodicitaRilevazione1(JAXBElement<String> value) {
        this.idTxtPeriodicitaRilevazione1 = value;
    }

    /**
     * Recupera il valore della proprietà idTxtPeriodicitaRilevazione2.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdTxtPeriodicitaRilevazione2() {
        return idTxtPeriodicitaRilevazione2;
    }

    /**
     * Imposta il valore della proprietà idTxtPeriodicitaRilevazione2.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdTxtPeriodicitaRilevazione2(JAXBElement<String> value) {
        this.idTxtPeriodicitaRilevazione2 = value;
    }

    /**
     * Recupera il valore della proprietà resultCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultCode() {
        return resultCode;
    }

    /**
     * Imposta il valore della proprietà resultCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultCode(JAXBElement<String> value) {
        this.resultCode = value;
    }

    /**
     * Recupera il valore della proprietà versioneTemplate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVersioneTemplate() {
        return versioneTemplate;
    }

    /**
     * Imposta il valore della proprietà versioneTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVersioneTemplate(JAXBElement<String> value) {
        this.versioneTemplate = value;
    }

}
