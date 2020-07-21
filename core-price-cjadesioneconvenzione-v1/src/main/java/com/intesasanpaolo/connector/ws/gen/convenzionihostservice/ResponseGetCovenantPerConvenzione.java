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
 * <p>Classe Java per Response_GetCovenantPerConvenzione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Response_GetCovenantPerConvenzione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseGetCovenantPerConvenzione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Response_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_GetCovenantPerConvenzione", propOrder = {
    "responseGetCovenantPerConvenzione"
})
public class ResponseGetCovenantPerConvenzione {

    @XmlElementRef(name = "ResponseGetCovenantPerConvenzione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione> responseGetCovenantPerConvenzione;

    /**
     * Recupera il valore della proprietà responseGetCovenantPerConvenzione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     *     
     */
    public JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione> getResponseGetCovenantPerConvenzione() {
        return responseGetCovenantPerConvenzione;
    }

    /**
     * Imposta il valore della proprietà responseGetCovenantPerConvenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     *     
     */
    public void setResponseGetCovenantPerConvenzione(JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione> value) {
        this.responseGetCovenantPerConvenzione = value;
    }

}
