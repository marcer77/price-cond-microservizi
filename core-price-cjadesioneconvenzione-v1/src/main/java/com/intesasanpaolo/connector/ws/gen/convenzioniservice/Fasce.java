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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Fasce complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Fasce"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Valore_Indicatore" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Valore_Indicatore" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fasce", propOrder = {
    "valoreIndicatore"
})
public class Fasce {

    @XmlElementRef(name = "Valore_Indicatore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ValoreIndicatore> valoreIndicatore;

    /**
     * Recupera il valore della proprietà valoreIndicatore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     *     
     */
    public JAXBElement<ValoreIndicatore> getValoreIndicatore() {
        return valoreIndicatore;
    }

    /**
     * Imposta il valore della proprietà valoreIndicatore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     *     
     */
    public void setValoreIndicatore(JAXBElement<ValoreIndicatore> value) {
        this.valoreIndicatore = value;
    }

}
