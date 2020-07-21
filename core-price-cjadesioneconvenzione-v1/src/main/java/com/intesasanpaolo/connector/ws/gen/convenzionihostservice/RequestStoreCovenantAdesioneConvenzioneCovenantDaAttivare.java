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
 * <p>Classe Java per Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BeneficioCondizionato_DataFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioCondizionato_DataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIncondizionato_DataFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIncondizionato_DataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIncondizionato_NumRilevazioni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIncondizionato_Presente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIngresso_DataFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIngresso_DataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BeneficioIngresso_Presente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Cod_Condizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Cod_CondizioneReale_MLT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Covenant_DataFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Covenant_DataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Flag_EntitaPrincipale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Progressivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Conto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Rapporto_Filiale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="condizioniFiglie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livelloGerarchia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare", propOrder = {
    "beneficioCondizionatoDataFine",
    "beneficioCondizionatoDataInizio",
    "beneficioIncondizionatoDataFine",
    "beneficioIncondizionatoDataInizio",
    "beneficioIncondizionatoNumRilevazioni",
    "beneficioIncondizionatoPresente",
    "beneficioIngressoDataFine",
    "beneficioIngressoDataInizio",
    "beneficioIngressoPresente",
    "codCondizione",
    "codCondizioneRealeMLT",
    "covenantDataFine",
    "covenantDataInizio",
    "flagEntitaPrincipale",
    "progressivo",
    "rapportoCategoria",
    "rapportoConto",
    "rapportoFiliale",
    "codiceTemplate",
    "condizioniFiglie",
    "livelloGerarchia",
    "versioneTemplate"
})
public class RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare {

    @XmlElementRef(name = "BeneficioCondizionato_DataFine", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioCondizionatoDataFine;
    @XmlElementRef(name = "BeneficioCondizionato_DataInizio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioCondizionatoDataInizio;
    @XmlElementRef(name = "BeneficioIncondizionato_DataFine", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIncondizionatoDataFine;
    @XmlElementRef(name = "BeneficioIncondizionato_DataInizio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIncondizionatoDataInizio;
    @XmlElementRef(name = "BeneficioIncondizionato_NumRilevazioni", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIncondizionatoNumRilevazioni;
    @XmlElementRef(name = "BeneficioIncondizionato_Presente", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIncondizionatoPresente;
    @XmlElementRef(name = "BeneficioIngresso_DataFine", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIngressoDataFine;
    @XmlElementRef(name = "BeneficioIngresso_DataInizio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIngressoDataInizio;
    @XmlElementRef(name = "BeneficioIngresso_Presente", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> beneficioIngressoPresente;
    @XmlElementRef(name = "Cod_Condizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codCondizione;
    @XmlElementRef(name = "Cod_CondizioneReale_MLT", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codCondizioneRealeMLT;
    @XmlElementRef(name = "Covenant_DataFine", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> covenantDataFine;
    @XmlElementRef(name = "Covenant_DataInizio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> covenantDataInizio;
    @XmlElementRef(name = "Flag_EntitaPrincipale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flagEntitaPrincipale;
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
    @XmlElementRef(name = "condizioniFiglie", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> condizioniFiglie;
    @XmlElementRef(name = "livelloGerarchia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> livelloGerarchia;
    @XmlElementRef(name = "versioneTemplate", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> versioneTemplate;

    /**
     * Recupera il valore della proprietà beneficioCondizionatoDataFine.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioCondizionatoDataFine() {
        return beneficioCondizionatoDataFine;
    }

    /**
     * Imposta il valore della proprietà beneficioCondizionatoDataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioCondizionatoDataFine(JAXBElement<String> value) {
        this.beneficioCondizionatoDataFine = value;
    }

    /**
     * Recupera il valore della proprietà beneficioCondizionatoDataInizio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioCondizionatoDataInizio() {
        return beneficioCondizionatoDataInizio;
    }

    /**
     * Imposta il valore della proprietà beneficioCondizionatoDataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioCondizionatoDataInizio(JAXBElement<String> value) {
        this.beneficioCondizionatoDataInizio = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIncondizionatoDataFine.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIncondizionatoDataFine() {
        return beneficioIncondizionatoDataFine;
    }

    /**
     * Imposta il valore della proprietà beneficioIncondizionatoDataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIncondizionatoDataFine(JAXBElement<String> value) {
        this.beneficioIncondizionatoDataFine = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIncondizionatoDataInizio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIncondizionatoDataInizio() {
        return beneficioIncondizionatoDataInizio;
    }

    /**
     * Imposta il valore della proprietà beneficioIncondizionatoDataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIncondizionatoDataInizio(JAXBElement<String> value) {
        this.beneficioIncondizionatoDataInizio = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIncondizionatoNumRilevazioni.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIncondizionatoNumRilevazioni() {
        return beneficioIncondizionatoNumRilevazioni;
    }

    /**
     * Imposta il valore della proprietà beneficioIncondizionatoNumRilevazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIncondizionatoNumRilevazioni(JAXBElement<String> value) {
        this.beneficioIncondizionatoNumRilevazioni = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIncondizionatoPresente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIncondizionatoPresente() {
        return beneficioIncondizionatoPresente;
    }

    /**
     * Imposta il valore della proprietà beneficioIncondizionatoPresente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIncondizionatoPresente(JAXBElement<String> value) {
        this.beneficioIncondizionatoPresente = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIngressoDataFine.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIngressoDataFine() {
        return beneficioIngressoDataFine;
    }

    /**
     * Imposta il valore della proprietà beneficioIngressoDataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIngressoDataFine(JAXBElement<String> value) {
        this.beneficioIngressoDataFine = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIngressoDataInizio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIngressoDataInizio() {
        return beneficioIngressoDataInizio;
    }

    /**
     * Imposta il valore della proprietà beneficioIngressoDataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIngressoDataInizio(JAXBElement<String> value) {
        this.beneficioIngressoDataInizio = value;
    }

    /**
     * Recupera il valore della proprietà beneficioIngressoPresente.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBeneficioIngressoPresente() {
        return beneficioIngressoPresente;
    }

    /**
     * Imposta il valore della proprietà beneficioIngressoPresente.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBeneficioIngressoPresente(JAXBElement<String> value) {
        this.beneficioIngressoPresente = value;
    }

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
     * Recupera il valore della proprietà codCondizioneRealeMLT.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodCondizioneRealeMLT() {
        return codCondizioneRealeMLT;
    }

    /**
     * Imposta il valore della proprietà codCondizioneRealeMLT.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodCondizioneRealeMLT(JAXBElement<String> value) {
        this.codCondizioneRealeMLT = value;
    }

    /**
     * Recupera il valore della proprietà covenantDataFine.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCovenantDataFine() {
        return covenantDataFine;
    }

    /**
     * Imposta il valore della proprietà covenantDataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCovenantDataFine(JAXBElement<String> value) {
        this.covenantDataFine = value;
    }

    /**
     * Recupera il valore della proprietà covenantDataInizio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCovenantDataInizio() {
        return covenantDataInizio;
    }

    /**
     * Imposta il valore della proprietà covenantDataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCovenantDataInizio(JAXBElement<String> value) {
        this.covenantDataInizio = value;
    }

    /**
     * Recupera il valore della proprietà flagEntitaPrincipale.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFlagEntitaPrincipale() {
        return flagEntitaPrincipale;
    }

    /**
     * Imposta il valore della proprietà flagEntitaPrincipale.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFlagEntitaPrincipale(JAXBElement<String> value) {
        this.flagEntitaPrincipale = value;
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
     * Recupera il valore della proprietà condizioniFiglie.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCondizioniFiglie() {
        return condizioniFiglie;
    }

    /**
     * Imposta il valore della proprietà condizioniFiglie.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCondizioniFiglie(JAXBElement<String> value) {
        this.condizioniFiglie = value;
    }

    /**
     * Recupera il valore della proprietà livelloGerarchia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLivelloGerarchia() {
        return livelloGerarchia;
    }

    /**
     * Imposta il valore della proprietà livelloGerarchia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLivelloGerarchia(JAXBElement<String> value) {
        this.livelloGerarchia = value;
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
