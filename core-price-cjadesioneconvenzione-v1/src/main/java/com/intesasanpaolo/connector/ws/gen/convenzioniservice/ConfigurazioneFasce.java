//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Configurazione_Fasce complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Configurazione_Fasce"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Codice_Fascia_Indicatore_Benefici_In" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Codifica_Indicatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Codifica_Indicatore_Sottorequisito" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="Disabilita_Monitoraggio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ListaFasce" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}ArrayOfFasce" minOccurs="0"/&gt;
 *         &lt;element name="Numero_Fascia_Differenziazione_Benefici_In" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="Periodicita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configurazione_Fasce", propOrder = {
    "codiceFasciaIndicatoreBeneficiIn",
    "codificaIndicatore",
    "codificaIndicatoreSottorequisito",
    "disabilitaMonitoraggio",
    "listaFasce",
    "numeroFasciaDifferenziazioneBeneficiIn",
    "periodicita"
})
public class ConfigurazioneFasce {

    @XmlElementRef(name = "Codice_Fascia_Indicatore_Benefici_In", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceFasciaIndicatoreBeneficiIn;
    @XmlElementRef(name = "Codifica_Indicatore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codificaIndicatore;
    @XmlElement(name = "Codifica_Indicatore_Sottorequisito")
    protected Short codificaIndicatoreSottorequisito;
    @XmlElementRef(name = "Disabilita_Monitoraggio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> disabilitaMonitoraggio;
    @XmlElementRef(name = "ListaFasce", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfFasce> listaFasce;
    @XmlElement(name = "Numero_Fascia_Differenziazione_Benefici_In")
    protected Short numeroFasciaDifferenziazioneBeneficiIn;
    @XmlElementRef(name = "Periodicita", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> periodicita;

    /**
     * Recupera il valore della proprietà codiceFasciaIndicatoreBeneficiIn.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceFasciaIndicatoreBeneficiIn() {
        return codiceFasciaIndicatoreBeneficiIn;
    }

    /**
     * Imposta il valore della proprietà codiceFasciaIndicatoreBeneficiIn.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceFasciaIndicatoreBeneficiIn(JAXBElement<String> value) {
        this.codiceFasciaIndicatoreBeneficiIn = value;
    }

    /**
     * Recupera il valore della proprietà codificaIndicatore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodificaIndicatore() {
        return codificaIndicatore;
    }

    /**
     * Imposta il valore della proprietà codificaIndicatore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodificaIndicatore(JAXBElement<String> value) {
        this.codificaIndicatore = value;
    }

    /**
     * Recupera il valore della proprietà codificaIndicatoreSottorequisito.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCodificaIndicatoreSottorequisito() {
        return codificaIndicatoreSottorequisito;
    }

    /**
     * Imposta il valore della proprietà codificaIndicatoreSottorequisito.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCodificaIndicatoreSottorequisito(Short value) {
        this.codificaIndicatoreSottorequisito = value;
    }

    /**
     * Recupera il valore della proprietà disabilitaMonitoraggio.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDisabilitaMonitoraggio() {
        return disabilitaMonitoraggio;
    }

    /**
     * Imposta il valore della proprietà disabilitaMonitoraggio.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDisabilitaMonitoraggio(JAXBElement<String> value) {
        this.disabilitaMonitoraggio = value;
    }

    /**
     * Recupera il valore della proprietà listaFasce.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFasce> getListaFasce() {
        return listaFasce;
    }

    /**
     * Imposta il valore della proprietà listaFasce.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     *     
     */
    public void setListaFasce(JAXBElement<ArrayOfFasce> value) {
        this.listaFasce = value;
    }

    /**
     * Recupera il valore della proprietà numeroFasciaDifferenziazioneBeneficiIn.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroFasciaDifferenziazioneBeneficiIn() {
        return numeroFasciaDifferenziazioneBeneficiIn;
    }

    /**
     * Imposta il valore della proprietà numeroFasciaDifferenziazioneBeneficiIn.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroFasciaDifferenziazioneBeneficiIn(Short value) {
        this.numeroFasciaDifferenziazioneBeneficiIn = value;
    }

    /**
     * Recupera il valore della proprietà periodicita.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPeriodicita() {
        return periodicita;
    }

    /**
     * Imposta il valore della proprietà periodicita.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPeriodicita(JAXBElement<String> value) {
        this.periodicita = value;
    }

}
