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
 * <p>Classe Java per Response_StoreCovenantAdesioneConvenzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Response_StoreCovenantAdesioneConvenzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseStoreCovenantAdesioneConvenzione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_StoreCovenantAdesioneConvenzione", propOrder = {
    "responseStoreCovenantAdesioneConvenzione"
})
public class ResponseStoreCovenantAdesioneConvenzione {

    @XmlElementRef(name = "ResponseStoreCovenantAdesioneConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione> responseStoreCovenantAdesioneConvenzione;

    /**
     * Recupera il valore della proprietà responseStoreCovenantAdesioneConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     *     
     */
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione> getResponseStoreCovenantAdesioneConvenzione() {
        return responseStoreCovenantAdesioneConvenzione;
    }

    /**
     * Imposta il valore della proprietà responseStoreCovenantAdesioneConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     *     
     */
    public void setResponseStoreCovenantAdesioneConvenzione(JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione> value) {
        this.responseStoreCovenantAdesioneConvenzione = value;
    }

}
