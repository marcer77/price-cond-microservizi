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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per GetBaselinePerHost_Request complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="GetBaselinePerHost_Request"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CodCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Prodotto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TemplateVer" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="UserABI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserUO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceAmbitoEvento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceEvento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceModaitaRilevazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codicePeriodicitaRilevazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoBaseline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipologiaTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreAmbito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBaselinePerHost_Request", propOrder = {
    "abi",
    "codCondizione",
    "language",
    "prodotto",
    "templateVer",
    "userABI",
    "userId",
    "userUO",
    "codTemplate",
    "codiceAmbitoEvento",
    "codiceEvento",
    "codiceModaitaRilevazione",
    "codicePeriodicitaRilevazione",
    "codiceTipoBaseline",
    "dataRichiesta",
    "tipologiaTemplate",
    "valoreAmbito"
})
public class GetBaselinePerHostRequest {

    @XmlElementRef(name = "ABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> abi;
    @XmlElementRef(name = "CodCondizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codCondizione;
    @XmlElementRef(name = "Language", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> language;
    @XmlElementRef(name = "Prodotto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> prodotto;
    @XmlElement(name = "TemplateVer")
    protected Integer templateVer;
    @XmlElementRef(name = "UserABI", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userABI;
    @XmlElementRef(name = "UserId", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userId;
    @XmlElementRef(name = "UserUO", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userUO;
    @XmlElementRef(name = "codTemplate", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codTemplate;
    @XmlElementRef(name = "codiceAmbitoEvento", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceAmbitoEvento;
    @XmlElementRef(name = "codiceEvento", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceEvento;
    @XmlElementRef(name = "codiceModaitaRilevazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceModaitaRilevazione;
    @XmlElementRef(name = "codicePeriodicitaRilevazione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codicePeriodicitaRilevazione;
    @XmlElementRef(name = "codiceTipoBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceTipoBaseline;
    @XmlElementRef(name = "dataRichiesta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataRichiesta;
    @XmlElementRef(name = "tipologiaTemplate", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipologiaTemplate;
    @XmlElementRef(name = "valoreAmbito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<String> valoreAmbito;

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
     * Recupera il valore della proprietà language.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLanguage() {
        return language;
    }

    /**
     * Imposta il valore della proprietà language.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<String> value) {
        this.language = value;
    }

    /**
     * Recupera il valore della proprietà prodotto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProdotto() {
        return prodotto;
    }

    /**
     * Imposta il valore della proprietà prodotto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProdotto(JAXBElement<String> value) {
        this.prodotto = value;
    }

    /**
     * Recupera il valore della proprietà templateVer.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTemplateVer() {
        return templateVer;
    }

    /**
     * Imposta il valore della proprietà templateVer.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTemplateVer(Integer value) {
        this.templateVer = value;
    }

    /**
     * Recupera il valore della proprietà userABI.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserABI() {
        return userABI;
    }

    /**
     * Imposta il valore della proprietà userABI.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserABI(JAXBElement<String> value) {
        this.userABI = value;
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

    /**
     * Recupera il valore della proprietà userUO.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserUO() {
        return userUO;
    }

    /**
     * Imposta il valore della proprietà userUO.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserUO(JAXBElement<String> value) {
        this.userUO = value;
    }

    /**
     * Recupera il valore della proprietà codTemplate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodTemplate() {
        return codTemplate;
    }

    /**
     * Imposta il valore della proprietà codTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodTemplate(JAXBElement<String> value) {
        this.codTemplate = value;
    }

    /**
     * Recupera il valore della proprietà codiceAmbitoEvento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceAmbitoEvento() {
        return codiceAmbitoEvento;
    }

    /**
     * Imposta il valore della proprietà codiceAmbitoEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceAmbitoEvento(JAXBElement<String> value) {
        this.codiceAmbitoEvento = value;
    }

    /**
     * Recupera il valore della proprietà codiceEvento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceEvento() {
        return codiceEvento;
    }

    /**
     * Imposta il valore della proprietà codiceEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceEvento(JAXBElement<String> value) {
        this.codiceEvento = value;
    }

    /**
     * Recupera il valore della proprietà codiceModaitaRilevazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceModaitaRilevazione() {
        return codiceModaitaRilevazione;
    }

    /**
     * Imposta il valore della proprietà codiceModaitaRilevazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceModaitaRilevazione(JAXBElement<String> value) {
        this.codiceModaitaRilevazione = value;
    }

    /**
     * Recupera il valore della proprietà codicePeriodicitaRilevazione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodicePeriodicitaRilevazione() {
        return codicePeriodicitaRilevazione;
    }

    /**
     * Imposta il valore della proprietà codicePeriodicitaRilevazione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodicePeriodicitaRilevazione(JAXBElement<String> value) {
        this.codicePeriodicitaRilevazione = value;
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
     * Recupera il valore della proprietà dataRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataRichiesta() {
        return dataRichiesta;
    }

    /**
     * Imposta il valore della proprietà dataRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataRichiesta(JAXBElement<String> value) {
        this.dataRichiesta = value;
    }

    /**
     * Recupera il valore della proprietà tipologiaTemplate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipologiaTemplate() {
        return tipologiaTemplate;
    }

    /**
     * Imposta il valore della proprietà tipologiaTemplate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipologiaTemplate(JAXBElement<String> value) {
        this.tipologiaTemplate = value;
    }

    /**
     * Recupera il valore della proprietà valoreAmbito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValoreAmbito() {
        return valoreAmbito;
    }

    /**
     * Imposta il valore della proprietà valoreAmbito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValoreAmbito(JAXBElement<String> value) {
        this.valoreAmbito = value;
    }

}
