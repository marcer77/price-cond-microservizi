//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Valore_Indicatore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Valore_Indicatore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AlfanumericoSoglia_A" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AlfanumericoSoglia_Da" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Codice_Fascia_Indicatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumericoSoglia_A" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="NumericoSoglia_Da" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Numero_Fascia_Differenziazione" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="TipoIndicatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Valore" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Valore" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Valore_Indicatore", propOrder = {
    "alfanumericoSogliaA",
    "alfanumericoSogliaDa",
    "codiceFasciaIndicatore",
    "numericoSogliaA",
    "numericoSogliaDa",
    "numeroFasciaDifferenziazione",
    "tipoIndicatore",
    "valore"
})
public class ValoreIndicatore {

    @XmlElementRef(name = "AlfanumericoSoglia_A", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> alfanumericoSogliaA;
    @XmlElementRef(name = "AlfanumericoSoglia_Da", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> alfanumericoSogliaDa;
    @XmlElementRef(name = "Codice_Fascia_Indicatore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codiceFasciaIndicatore;
    @XmlElementRef(name = "NumericoSoglia_A", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> numericoSogliaA;
    @XmlElementRef(name = "NumericoSoglia_Da", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<BigDecimal> numericoSogliaDa;
    @XmlElement(name = "Numero_Fascia_Differenziazione")
    protected Short numeroFasciaDifferenziazione;
    @XmlElementRef(name = "TipoIndicatore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tipoIndicatore;
    @XmlElementRef(name = "Valore", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", type = JAXBElement.class, required = false)
    protected JAXBElement<Valore> valore;

    /**
     * Recupera il valore della proprietà alfanumericoSogliaA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlfanumericoSogliaA() {
        return alfanumericoSogliaA;
    }

    /**
     * Imposta il valore della proprietà alfanumericoSogliaA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlfanumericoSogliaA(JAXBElement<String> value) {
        this.alfanumericoSogliaA = value;
    }

    /**
     * Recupera il valore della proprietà alfanumericoSogliaDa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAlfanumericoSogliaDa() {
        return alfanumericoSogliaDa;
    }

    /**
     * Imposta il valore della proprietà alfanumericoSogliaDa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAlfanumericoSogliaDa(JAXBElement<String> value) {
        this.alfanumericoSogliaDa = value;
    }

    /**
     * Recupera il valore della proprietà codiceFasciaIndicatore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodiceFasciaIndicatore() {
        return codiceFasciaIndicatore;
    }

    /**
     * Imposta il valore della proprietà codiceFasciaIndicatore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodiceFasciaIndicatore(JAXBElement<String> value) {
        this.codiceFasciaIndicatore = value;
    }

    /**
     * Recupera il valore della proprietà numericoSogliaA.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumericoSogliaA() {
        return numericoSogliaA;
    }

    /**
     * Imposta il valore della proprietà numericoSogliaA.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumericoSogliaA(JAXBElement<BigDecimal> value) {
        this.numericoSogliaA = value;
    }

    /**
     * Recupera il valore della proprietà numericoSogliaDa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public JAXBElement<BigDecimal> getNumericoSogliaDa() {
        return numericoSogliaDa;
    }

    /**
     * Imposta il valore della proprietà numericoSogliaDa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     *     
     */
    public void setNumericoSogliaDa(JAXBElement<BigDecimal> value) {
        this.numericoSogliaDa = value;
    }

    /**
     * Recupera il valore della proprietà numeroFasciaDifferenziazione.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getNumeroFasciaDifferenziazione() {
        return numeroFasciaDifferenziazione;
    }

    /**
     * Imposta il valore della proprietà numeroFasciaDifferenziazione.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setNumeroFasciaDifferenziazione(Short value) {
        this.numeroFasciaDifferenziazione = value;
    }

    /**
     * Recupera il valore della proprietà tipoIndicatore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTipoIndicatore() {
        return tipoIndicatore;
    }

    /**
     * Imposta il valore della proprietà tipoIndicatore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTipoIndicatore(JAXBElement<String> value) {
        this.tipoIndicatore = value;
    }

    /**
     * Recupera il valore della proprietà valore.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Valore }{@code >}
     *     
     */
    public JAXBElement<Valore> getValore() {
        return valore;
    }

    /**
     * Imposta il valore della proprietà valore.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Valore }{@code >}
     *     
     */
    public void setValore(JAXBElement<Valore> value) {
        this.valore = value;
    }

}
