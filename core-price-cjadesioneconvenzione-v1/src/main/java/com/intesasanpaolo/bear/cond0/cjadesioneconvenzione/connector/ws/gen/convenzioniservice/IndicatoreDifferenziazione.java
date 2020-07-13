//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.13 alle 10:14:52 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Indicatore_Differenziazione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Indicatore_Differenziazione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FasciaFatturato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}FasciaFatturato" minOccurs="0"/&gt;
 *         &lt;element name="FasciaPortafoglioSSC" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}FasciaPortafoglioSSC" minOccurs="0"/&gt;
 *         &lt;element name="NumeroFascia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Indicatore_Differenziazione", propOrder = {
    "fasciaFatturato",
    "fasciaPortafoglioSSC",
    "numeroFascia"
})
public class IndicatoreDifferenziazione {

    @XmlElementRef(name = "FasciaFatturato", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<FasciaFatturato> fasciaFatturato;
    @XmlElementRef(name = "FasciaPortafoglioSSC", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<FasciaPortafoglioSSC> fasciaPortafoglioSSC;
    @XmlElement(name = "NumeroFascia")
    protected Short numeroFascia;

    /**
     * Recupera il valore della proprietà fasciaFatturato.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     *     
     */
    public JAXBElement<FasciaFatturato> getFasciaFatturato() {
        return fasciaFatturato;
    }

    /**
     * Imposta il valore della proprietà fasciaFatturato.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     *     
     */
    public void setFasciaFatturato(JAXBElement<FasciaFatturato> value) {
        this.fasciaFatturato = value;
    }

    /**
     * Recupera il valore della proprietà fasciaPortafoglioSSC.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     *     
     */
    public JAXBElement<FasciaPortafoglioSSC> getFasciaPortafoglioSSC() {
        return fasciaPortafoglioSSC;
    }

    /**
     * Imposta il valore della proprietà fasciaPortafoglioSSC.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     *     
     */
    public void setFasciaPortafoglioSSC(JAXBElement<FasciaPortafoglioSSC> value) {
        this.fasciaPortafoglioSSC = value;
    }

    /**
     * Recupera il valore della proprietà numeroFascia.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroFascia() {
        return numeroFascia;
    }

    /**
     * Imposta il valore della proprietà numeroFascia.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroFascia(Short value) {
        this.numeroFascia = value;
    }

}
