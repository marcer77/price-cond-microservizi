//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:35:12 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ErroriListaCovenantDaAttivare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaAttivare" minOccurs="0"/&gt;
 *         &lt;element name="ErroriListaCovenantDaCessare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare" minOccurs="0"/&gt;
 *         &lt;element name="Esito" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Class.Esito" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione", propOrder = {
    "erroriListaCovenantDaAttivare",
    "erroriListaCovenantDaCessare",
    "esito"
})
public class ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione {

    @XmlElementRef(name = "ErroriListaCovenantDaAttivare", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaAttivare> erroriListaCovenantDaAttivare;
    @XmlElementRef(name = "ErroriListaCovenantDaCessare", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare> erroriListaCovenantDaCessare;
    @XmlElementRef(name = "Esito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ClassEsito> esito;

    /**
     * Recupera il valore della proprietà erroriListaCovenantDaAttivare.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaAttivare> getErroriListaCovenantDaAttivare() {
        return erroriListaCovenantDaAttivare;
    }

    /**
     * Imposta il valore della proprietà erroriListaCovenantDaAttivare.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     *     
     */
    public void setErroriListaCovenantDaAttivare(JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaAttivare> value) {
        this.erroriListaCovenantDaAttivare = value;
    }

    /**
     * Recupera il valore della proprietà erroriListaCovenantDaCessare.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare> getErroriListaCovenantDaCessare() {
        return erroriListaCovenantDaCessare;
    }

    /**
     * Imposta il valore della proprietà erroriListaCovenantDaCessare.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     *     
     */
    public void setErroriListaCovenantDaCessare(JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare> value) {
        this.erroriListaCovenantDaCessare = value;
    }

    /**
     * Recupera il valore della proprietà esito.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     *     
     */
    public JAXBElement<ClassEsito> getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della proprietà esito.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     *     
     */
    public void setEsito(JAXBElement<ClassEsito> value) {
        this.esito = value;
    }

}
