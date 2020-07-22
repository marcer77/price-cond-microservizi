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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getBaselineResponse" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}GetBaselinePerHost_Response" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getBaselineResponse"
})
@XmlRootElement(name = "Response_Body_GetBaseline", namespace = "http://tempuri.org/")
public class ResponseBodyGetBaseline {

    @XmlElementRef(name = "getBaselineResponse", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<GetBaselinePerHostResponse> getBaselineResponse;

    /**
     * Recupera il valore della proprietà getBaselineResponse.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     *     
     */
    public JAXBElement<GetBaselinePerHostResponse> getGetBaselineResponse() {
        return getBaselineResponse;
    }

    /**
     * Imposta il valore della proprietà getBaselineResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     *     
     */
    public void setGetBaselineResponse(JAXBElement<GetBaselinePerHostResponse> value) {
        this.getBaselineResponse = value;
    }

}
