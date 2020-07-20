//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.14 alle 12:42:37 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

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
 *         &lt;element name="input" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Anagrafica_Request" minOccurs="0"/&gt;
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
@XmlRootElement(name = "GetAnagraficaConvenzione", namespace = "http://tempuri.org/")
public class GetAnagraficaConvenzione {

    @XmlElementRef(name = "input", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<AnagraficaRequest> input;

    /**
     * Recupera il valore della proprietà input.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     *     
     */
    public JAXBElement<AnagraficaRequest> getInput() {
        return input;
    }

    /**
     * Imposta il valore della proprietà input.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     *     
     */
    public void setInput(JAXBElement<AnagraficaRequest> value) {
        this.input = value;
    }

}
