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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per GetBaselinePerHost_Response complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="GetBaselinePerHost_Response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ListaBaseline" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfGetBaselinePerHost_Response.Baseline" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBaselinePerHost_Response", propOrder = {
    "listaBaseline"
})
public class GetBaselinePerHostResponse {

    @XmlElementRef(name = "ListaBaseline", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline> listaBaseline;

    /**
     * Recupera il valore della proprietà listaBaseline.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     *     
     */
    public JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline> getListaBaseline() {
        return listaBaseline;
    }

    /**
     * Imposta il valore della proprietà listaBaseline.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     *     
     */
    public void setListaBaseline(JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline> value) {
        this.listaBaseline = value;
    }

}
