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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Convenzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Convenzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodiceConvenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ControGaranzia_Stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Controparte" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Controparte" minOccurs="0"/&gt;
 *         &lt;element name="DataDecorrenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataScadenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Delibera" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Delibera" minOccurs="0"/&gt;
 *         &lt;element name="DescrizioneConvenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Durata_Beneficio_Minimo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="GG_Mancata_Scadenza" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="ListaCondizione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfCondizione" minOccurs="0"/&gt;
 *         &lt;element name="ListaIndicatore_Differenziazione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfIndicatore_Differenziazione" minOccurs="0"/&gt;
 *         &lt;element name="ListaPortafoglio_Adesione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfPortafoglio_Adesione" minOccurs="0"/&gt;
 *         &lt;element name="ListaRating" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfRating" minOccurs="0"/&gt;
 *         &lt;element name="ListaRequisitiAdesioneGenerici" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfRequisitiAdesioneGenerico" minOccurs="0"/&gt;
 *         &lt;element name="ListaRequisitiEstinzioneGenerici" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfRequisitiEstinzioneGenerico" minOccurs="0"/&gt;
 *         &lt;element name="Percentuale_ControGaranzia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="Percentuale_Garanzia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="Presenza_Garanzia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Proposta" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Proposta" minOccurs="0"/&gt;
 *         &lt;element name="Requisiti_Adesione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Req_Adesione" minOccurs="0"/&gt;
 *         &lt;element name="Requisiti_Estinzione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Req_Estinzione" minOccurs="0"/&gt;
 *         &lt;element name="Stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Tipo_Differenziazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Convenzione", propOrder = {
    "codiceABI",
    "codiceConvenzione",
    "controGaranziaStato",
    "controparte",
    "dataDecorrenza",
    "dataScadenza",
    "delibera",
    "descrizioneConvenzione",
    "durataBeneficioMinimo",
    "ggMancataScadenza",
    "listaCondizione",
    "listaIndicatoreDifferenziazione",
    "listaPortafoglioAdesione",
    "listaRating",
    "listaRequisitiAdesioneGenerici",
    "listaRequisitiEstinzioneGenerici",
    "percentualeControGaranzia",
    "percentualeGaranzia",
    "presenzaGaranzia",
    "proposta",
    "requisitiAdesione",
    "requisitiEstinzione",
    "stato",
    "tipoDifferenziazione"
})
public class Convenzione {

    @XmlElementRef(name = "CodiceABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceABI;
    @XmlElementRef(name = "CodiceConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceConvenzione;
    @XmlElementRef(name = "ControGaranzia_Stato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> controGaranziaStato;
    @XmlElementRef(name = "Controparte", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<Controparte> controparte;
    @XmlElementRef(name = "DataDecorrenza", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataDecorrenza;
    @XmlElementRef(name = "DataScadenza", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataScadenza;
    @XmlElementRef(name = "Delibera", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<Delibera> delibera;
    @XmlElementRef(name = "DescrizioneConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> descrizioneConvenzione;
    @XmlElement(name = "Durata_Beneficio_Minimo")
    protected Short durataBeneficioMinimo;
    @XmlElement(name = "GG_Mancata_Scadenza")
    protected Short ggMancataScadenza;
    @XmlElementRef(name = "ListaCondizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCondizione> listaCondizione;
    @XmlElementRef(name = "ListaIndicatore_Differenziazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIndicatoreDifferenziazione> listaIndicatoreDifferenziazione;
    @XmlElementRef(name = "ListaPortafoglio_Adesione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPortafoglioAdesione> listaPortafoglioAdesione;
    @XmlElementRef(name = "ListaRating", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRating> listaRating;
    @XmlElementRef(name = "ListaRequisitiAdesioneGenerici", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRequisitiAdesioneGenerico> listaRequisitiAdesioneGenerici;
    @XmlElementRef(name = "ListaRequisitiEstinzioneGenerici", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRequisitiEstinzioneGenerico> listaRequisitiEstinzioneGenerici;
    @XmlElement(name = "Percentuale_ControGaranzia")
    protected Short percentualeControGaranzia;
    @XmlElement(name = "Percentuale_Garanzia")
    protected Short percentualeGaranzia;
    @XmlElementRef(name = "Presenza_Garanzia", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> presenzaGaranzia;
    @XmlElementRef(name = "Proposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<Proposta> proposta;
    @XmlElementRef(name = "Requisiti_Adesione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ReqAdesione> requisitiAdesione;
    @XmlElementRef(name = "Requisiti_Estinzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ReqEstinzione> requisitiEstinzione;
    @XmlElementRef(name = "Stato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stato;
    @XmlElementRef(name = "Tipo_Differenziazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoDifferenziazione;

    /**
     * Recupera il valore della proprietà codiceABI.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceABI() {
        return codiceABI;
    }

    /**
     * Imposta il valore della proprietà codiceABI.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceABI(JAXBElement<String> value) {
        this.codiceABI = value;
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
     * Recupera il valore della proprietà controGaranziaStato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getControGaranziaStato() {
        return controGaranziaStato;
    }

    /**
     * Imposta il valore della proprietà controGaranziaStato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setControGaranziaStato(JAXBElement<String> value) {
        this.controGaranziaStato = value;
    }

    /**
     * Recupera il valore della proprietà controparte.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     *     
     */
    public JAXBElement<Controparte> getControparte() {
        return controparte;
    }

    /**
     * Imposta il valore della proprietà controparte.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     *     
     */
    public void setControparte(JAXBElement<Controparte> value) {
        this.controparte = value;
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
     * Recupera il valore della proprietà delibera.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     *     
     */
    public JAXBElement<Delibera> getDelibera() {
        return delibera;
    }

    /**
     * Imposta il valore della proprietà delibera.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     *     
     */
    public void setDelibera(JAXBElement<Delibera> value) {
        this.delibera = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDescrizioneConvenzione() {
        return descrizioneConvenzione;
    }

    /**
     * Imposta il valore della proprietà descrizioneConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDescrizioneConvenzione(JAXBElement<String> value) {
        this.descrizioneConvenzione = value;
    }

    /**
     * Recupera il valore della proprietà durataBeneficioMinimo.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getDurataBeneficioMinimo() {
        return durataBeneficioMinimo;
    }

    /**
     * Imposta il valore della proprietà durataBeneficioMinimo.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setDurataBeneficioMinimo(Short value) {
        this.durataBeneficioMinimo = value;
    }

    /**
     * Recupera il valore della proprietà ggMancataScadenza.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getGGMancataScadenza() {
        return ggMancataScadenza;
    }

    /**
     * Imposta il valore della proprietà ggMancataScadenza.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setGGMancataScadenza(Short value) {
        this.ggMancataScadenza = value;
    }

    /**
     * Recupera il valore della proprietà listaCondizione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCondizione> getListaCondizione() {
        return listaCondizione;
    }

    /**
     * Imposta il valore della proprietà listaCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     *     
     */
    public void setListaCondizione(JAXBElement<ArrayOfCondizione> value) {
        this.listaCondizione = value;
    }

    /**
     * Recupera il valore della proprietà listaIndicatoreDifferenziazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIndicatoreDifferenziazione> getListaIndicatoreDifferenziazione() {
        return listaIndicatoreDifferenziazione;
    }

    /**
     * Imposta il valore della proprietà listaIndicatoreDifferenziazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     *     
     */
    public void setListaIndicatoreDifferenziazione(JAXBElement<ArrayOfIndicatoreDifferenziazione> value) {
        this.listaIndicatoreDifferenziazione = value;
    }

    /**
     * Recupera il valore della proprietà listaPortafoglioAdesione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPortafoglioAdesione> getListaPortafoglioAdesione() {
        return listaPortafoglioAdesione;
    }

    /**
     * Imposta il valore della proprietà listaPortafoglioAdesione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     *     
     */
    public void setListaPortafoglioAdesione(JAXBElement<ArrayOfPortafoglioAdesione> value) {
        this.listaPortafoglioAdesione = value;
    }

    /**
     * Recupera il valore della proprietà listaRating.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRating> getListaRating() {
        return listaRating;
    }

    /**
     * Imposta il valore della proprietà listaRating.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     *     
     */
    public void setListaRating(JAXBElement<ArrayOfRating> value) {
        this.listaRating = value;
    }

    /**
     * Recupera il valore della proprietà listaRequisitiAdesioneGenerici.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRequisitiAdesioneGenerico> getListaRequisitiAdesioneGenerici() {
        return listaRequisitiAdesioneGenerici;
    }

    /**
     * Imposta il valore della proprietà listaRequisitiAdesioneGenerici.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     *     
     */
    public void setListaRequisitiAdesioneGenerici(JAXBElement<ArrayOfRequisitiAdesioneGenerico> value) {
        this.listaRequisitiAdesioneGenerici = value;
    }

    /**
     * Recupera il valore della proprietà listaRequisitiEstinzioneGenerici.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRequisitiEstinzioneGenerico> getListaRequisitiEstinzioneGenerici() {
        return listaRequisitiEstinzioneGenerici;
    }

    /**
     * Imposta il valore della proprietà listaRequisitiEstinzioneGenerici.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     *     
     */
    public void setListaRequisitiEstinzioneGenerici(JAXBElement<ArrayOfRequisitiEstinzioneGenerico> value) {
        this.listaRequisitiEstinzioneGenerici = value;
    }

    /**
     * Recupera il valore della proprietà percentualeControGaranzia.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getPercentualeControGaranzia() {
        return percentualeControGaranzia;
    }

    /**
     * Imposta il valore della proprietà percentualeControGaranzia.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setPercentualeControGaranzia(Short value) {
        this.percentualeControGaranzia = value;
    }

    /**
     * Recupera il valore della proprietà percentualeGaranzia.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getPercentualeGaranzia() {
        return percentualeGaranzia;
    }

    /**
     * Imposta il valore della proprietà percentualeGaranzia.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setPercentualeGaranzia(Short value) {
        this.percentualeGaranzia = value;
    }

    /**
     * Recupera il valore della proprietà presenzaGaranzia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPresenzaGaranzia() {
        return presenzaGaranzia;
    }

    /**
     * Imposta il valore della proprietà presenzaGaranzia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPresenzaGaranzia(JAXBElement<String> value) {
        this.presenzaGaranzia = value;
    }

    /**
     * Recupera il valore della proprietà proposta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     *     
     */
    public JAXBElement<Proposta> getProposta() {
        return proposta;
    }

    /**
     * Imposta il valore della proprietà proposta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     *     
     */
    public void setProposta(JAXBElement<Proposta> value) {
        this.proposta = value;
    }

    /**
     * Recupera il valore della proprietà requisitiAdesione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     *     
     */
    public JAXBElement<ReqAdesione> getRequisitiAdesione() {
        return requisitiAdesione;
    }

    /**
     * Imposta il valore della proprietà requisitiAdesione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     *     
     */
    public void setRequisitiAdesione(JAXBElement<ReqAdesione> value) {
        this.requisitiAdesione = value;
    }

    /**
     * Recupera il valore della proprietà requisitiEstinzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     *     
     */
    public JAXBElement<ReqEstinzione> getRequisitiEstinzione() {
        return requisitiEstinzione;
    }

    /**
     * Imposta il valore della proprietà requisitiEstinzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     *     
     */
    public void setRequisitiEstinzione(JAXBElement<ReqEstinzione> value) {
        this.requisitiEstinzione = value;
    }

    /**
     * Recupera il valore della proprietà stato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStato() {
        return stato;
    }

    /**
     * Imposta il valore della proprietà stato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStato(JAXBElement<String> value) {
        this.stato = value;
    }

    /**
     * Recupera il valore della proprietà tipoDifferenziazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoDifferenziazione() {
        return tipoDifferenziazione;
    }

    /**
     * Imposta il valore della proprietà tipoDifferenziazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoDifferenziazione(JAXBElement<String> value) {
        this.tipoDifferenziazione = value;
    }

}
