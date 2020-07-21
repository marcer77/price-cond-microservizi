//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Req_Estinzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Req_Estinzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AccreditoStipendio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DataScadenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Validata_Documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EstinzioneAnticipata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Mancata_Attivazione_ROL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Presenza_Garanzie_Eleggibile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RateImpagate_MLT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Sconfinamento_BT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Req_Estinzione", propOrder = {
    "accreditoStipendio",
    "dataScadenza",
    "dataValidataDocumento",
    "estinzioneAnticipata",
    "mancataAttivazioneROL",
    "presenzaGaranzieEleggibile",
    "rateImpagateMLT",
    "sconfinamentoBT"
})
public class ReqEstinzione {

    @XmlElementRef(name = "AccreditoStipendio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accreditoStipendio;
    @XmlElementRef(name = "DataScadenza", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataScadenza;
    @XmlElementRef(name = "Data_Validata_Documento", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataValidataDocumento;
    @XmlElementRef(name = "EstinzioneAnticipata", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estinzioneAnticipata;
    @XmlElementRef(name = "Mancata_Attivazione_ROL", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mancataAttivazioneROL;
    @XmlElementRef(name = "Presenza_Garanzie_Eleggibile", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> presenzaGaranzieEleggibile;
    @XmlElementRef(name = "RateImpagate_MLT", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rateImpagateMLT;
    @XmlElementRef(name = "Sconfinamento_BT", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sconfinamentoBT;

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
     * Recupera il valore della proprietà estinzioneAnticipata.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEstinzioneAnticipata() {
        return estinzioneAnticipata;
    }

    /**
     * Imposta il valore della proprietà estinzioneAnticipata.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEstinzioneAnticipata(JAXBElement<String> value) {
        this.estinzioneAnticipata = value;
    }

    /**
     * Recupera il valore della proprietà mancataAttivazioneROL.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMancataAttivazioneROL() {
        return mancataAttivazioneROL;
    }

    /**
     * Imposta il valore della proprietà mancataAttivazioneROL.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMancataAttivazioneROL(JAXBElement<String> value) {
        this.mancataAttivazioneROL = value;
    }

    /**
     * Recupera il valore della proprietà presenzaGaranzieEleggibile.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPresenzaGaranzieEleggibile() {
        return presenzaGaranzieEleggibile;
    }

    /**
     * Imposta il valore della proprietà presenzaGaranzieEleggibile.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPresenzaGaranzieEleggibile(JAXBElement<String> value) {
        this.presenzaGaranzieEleggibile = value;
    }

    /**
     * Recupera il valore della proprietà rateImpagateMLT.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRateImpagateMLT() {
        return rateImpagateMLT;
    }

    /**
     * Imposta il valore della proprietà rateImpagateMLT.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRateImpagateMLT(JAXBElement<String> value) {
        this.rateImpagateMLT = value;
    }

    /**
     * Recupera il valore della proprietà sconfinamentoBT.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSconfinamentoBT() {
        return sconfinamentoBT;
    }

    /**
     * Imposta il valore della proprietà sconfinamentoBT.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSconfinamentoBT(JAXBElement<String> value) {
        this.sconfinamentoBT = value;
    }

}
