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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Condizione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Condizione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Codice_Condizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Configurazione_Fasce_Approvato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Configurazione_Fasce" minOccurs="0"/&gt;
 *         &lt;element name="Configurazione_Fasce_Proposto" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Configurazione_Fasce" minOccurs="0"/&gt;
 *         &lt;element name="Data_Decorrenza_Approvata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Decorrenza_Proposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Scadenza_Approvata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Data_Scadenza_Proposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TipoValore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Approvato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Blocco_Valore" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Post_Approvato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Blocco_Valore" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Post_Proposto" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Blocco_Valore" minOccurs="0"/&gt;
 *         &lt;element name="Valore_Proposto" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Blocco_Valore" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condizione", propOrder = {
    "codiceCondizione",
    "configurazioneFasceApprovato",
    "configurazioneFasceProposto",
    "dataDecorrenzaApprovata",
    "dataDecorrenzaProposta",
    "dataScadenzaApprovata",
    "dataScadenzaProposta",
    "tipoValore",
    "valoreApprovato",
    "valorePostApprovato",
    "valorePostProposto",
    "valoreProposto"
})
public class Condizione {

    @XmlElementRef(name = "Codice_Condizione", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceCondizione;
    @XmlElementRef(name = "Configurazione_Fasce_Approvato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ConfigurazioneFasce> configurazioneFasceApprovato;
    @XmlElementRef(name = "Configurazione_Fasce_Proposto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ConfigurazioneFasce> configurazioneFasceProposto;
    @XmlElementRef(name = "Data_Decorrenza_Approvata", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataDecorrenzaApprovata;
    @XmlElementRef(name = "Data_Decorrenza_Proposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataDecorrenzaProposta;
    @XmlElementRef(name = "Data_Scadenza_Approvata", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataScadenzaApprovata;
    @XmlElementRef(name = "Data_Scadenza_Proposta", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dataScadenzaProposta;
    @XmlElementRef(name = "TipoValore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoValore;
    @XmlElementRef(name = "Valore_Approvato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BloccoValore> valoreApprovato;
    @XmlElementRef(name = "Valore_Post_Approvato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BloccoValore> valorePostApprovato;
    @XmlElementRef(name = "Valore_Post_Proposto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BloccoValore> valorePostProposto;
    @XmlElementRef(name = "Valore_Proposto", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BloccoValore> valoreProposto;

    /**
     * Recupera il valore della proprietà codiceCondizione.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceCondizione() {
        return codiceCondizione;
    }

    /**
     * Imposta il valore della proprietà codiceCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceCondizione(JAXBElement<String> value) {
        this.codiceCondizione = value;
    }

    /**
     * Recupera il valore della proprietà configurazioneFasceApprovato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public JAXBElement<ConfigurazioneFasce> getConfigurazioneFasceApprovato() {
        return configurazioneFasceApprovato;
    }

    /**
     * Imposta il valore della proprietà configurazioneFasceApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public void setConfigurazioneFasceApprovato(JAXBElement<ConfigurazioneFasce> value) {
        this.configurazioneFasceApprovato = value;
    }

    /**
     * Recupera il valore della proprietà configurazioneFasceProposto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public JAXBElement<ConfigurazioneFasce> getConfigurazioneFasceProposto() {
        return configurazioneFasceProposto;
    }

    /**
     * Imposta il valore della proprietà configurazioneFasceProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     *     
     */
    public void setConfigurazioneFasceProposto(JAXBElement<ConfigurazioneFasce> value) {
        this.configurazioneFasceProposto = value;
    }

    /**
     * Recupera il valore della proprietà dataDecorrenzaApprovata.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataDecorrenzaApprovata() {
        return dataDecorrenzaApprovata;
    }

    /**
     * Imposta il valore della proprietà dataDecorrenzaApprovata.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataDecorrenzaApprovata(JAXBElement<String> value) {
        this.dataDecorrenzaApprovata = value;
    }

    /**
     * Recupera il valore della proprietà dataDecorrenzaProposta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataDecorrenzaProposta() {
        return dataDecorrenzaProposta;
    }

    /**
     * Imposta il valore della proprietà dataDecorrenzaProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataDecorrenzaProposta(JAXBElement<String> value) {
        this.dataDecorrenzaProposta = value;
    }

    /**
     * Recupera il valore della proprietà dataScadenzaApprovata.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataScadenzaApprovata() {
        return dataScadenzaApprovata;
    }

    /**
     * Imposta il valore della proprietà dataScadenzaApprovata.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataScadenzaApprovata(JAXBElement<String> value) {
        this.dataScadenzaApprovata = value;
    }

    /**
     * Recupera il valore della proprietà dataScadenzaProposta.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDataScadenzaProposta() {
        return dataScadenzaProposta;
    }

    /**
     * Imposta il valore della proprietà dataScadenzaProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDataScadenzaProposta(JAXBElement<String> value) {
        this.dataScadenzaProposta = value;
    }

    /**
     * Recupera il valore della proprietà tipoValore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoValore() {
        return tipoValore;
    }

    /**
     * Imposta il valore della proprietà tipoValore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoValore(JAXBElement<String> value) {
        this.tipoValore = value;
    }

    /**
     * Recupera il valore della proprietà valoreApprovato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public JAXBElement<BloccoValore> getValoreApprovato() {
        return valoreApprovato;
    }

    /**
     * Imposta il valore della proprietà valoreApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public void setValoreApprovato(JAXBElement<BloccoValore> value) {
        this.valoreApprovato = value;
    }

    /**
     * Recupera il valore della proprietà valorePostApprovato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public JAXBElement<BloccoValore> getValorePostApprovato() {
        return valorePostApprovato;
    }

    /**
     * Imposta il valore della proprietà valorePostApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public void setValorePostApprovato(JAXBElement<BloccoValore> value) {
        this.valorePostApprovato = value;
    }

    /**
     * Recupera il valore della proprietà valorePostProposto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public JAXBElement<BloccoValore> getValorePostProposto() {
        return valorePostProposto;
    }

    /**
     * Imposta il valore della proprietà valorePostProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public void setValorePostProposto(JAXBElement<BloccoValore> value) {
        this.valorePostProposto = value;
    }

    /**
     * Recupera il valore della proprietà valoreProposto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public JAXBElement<BloccoValore> getValoreProposto() {
        return valoreProposto;
    }

    /**
     * Imposta il valore della proprietà valoreProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     *     
     */
    public void setValoreProposto(JAXBElement<BloccoValore> value) {
        this.valoreProposto = value;
    }

}
