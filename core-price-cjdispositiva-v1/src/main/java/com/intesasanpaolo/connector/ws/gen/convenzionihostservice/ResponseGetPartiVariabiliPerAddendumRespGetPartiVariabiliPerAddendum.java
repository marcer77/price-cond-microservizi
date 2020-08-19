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
 * <p>Classe Java per Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Esito" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Class.Esito" minOccurs="0"/&gt;
 *         &lt;element name="ListaCovenantAttivati" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato" minOccurs="0"/&gt;
 *         &lt;element name="ListaGlossario" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.Glossario" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum", propOrder = {
    "esito",
    "listaCovenantAttivati",
    "listaGlossario"
})
public class ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum {

    @XmlElementRef(name = "Esito", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ClassEsito> esito;
    @XmlElementRef(name = "ListaCovenantAttivati", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato> listaCovenantAttivati;
    @XmlElementRef(name = "ListaGlossario", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumGlossario> listaGlossario;

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

    /**
     * Recupera il valore della proprietà listaCovenantAttivati.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato> getListaCovenantAttivati() {
        return listaCovenantAttivati;
    }

    /**
     * Imposta il valore della proprietà listaCovenantAttivati.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     *     
     */
    public void setListaCovenantAttivati(JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato> value) {
        this.listaCovenantAttivati = value;
    }

    /**
     * Recupera il valore della proprietà listaGlossario.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumGlossario }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumGlossario> getListaGlossario() {
        return listaGlossario;
    }

    /**
     * Imposta il valore della proprietà listaGlossario.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumGlossario }{@code >}
     *     
     */
    public void setListaGlossario(JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumGlossario> value) {
        this.listaGlossario = value;
    }

}
