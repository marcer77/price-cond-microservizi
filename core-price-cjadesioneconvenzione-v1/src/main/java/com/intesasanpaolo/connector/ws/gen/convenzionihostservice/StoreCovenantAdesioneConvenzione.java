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
 *         &lt;element name="input" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Request_StoreCovenantAdesioneConvenzione" minOccurs="0"/&gt;
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
    "input"
})
@XmlRootElement(name = "StoreCovenantAdesioneConvenzione", namespace = "http://tempuri.org/")
public class StoreCovenantAdesioneConvenzione {

    @XmlElementRef(name = "input", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<RequestStoreCovenantAdesioneConvenzione> input;

    /**
     * Recupera il valore della proprietà input.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     *     
     */
    public JAXBElement<RequestStoreCovenantAdesioneConvenzione> getInput() {
        return input;
    }

    /**
     * Imposta il valore della proprietà input.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     *     
     */
    public void setInput(JAXBElement<RequestStoreCovenantAdesioneConvenzione> value) {
        this.input = value;
    }

}
