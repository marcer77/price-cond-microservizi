//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:45 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per propostaCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="propostaCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tipoChiamata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceOrigine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rapportoReale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataAccensioneRapportoReale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attributoRapporto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="profili" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="datiProposta" type="{http://ws.price.isp.com/proposteCJPOS/}anagraficaPropostaCJPOS" minOccurs="0"/&gt;
 *         &lt;element name="datiCliente" type="{http://ws.price.isp.com/proposteCJPOS/}datiCliente" minOccurs="0"/&gt;
 *         &lt;element name="listaAttributi" type="{http://ws.price.isp.com/proposteCJPOS/}wrapperMap" minOccurs="0"/&gt;
 *         &lt;element name="attributiPricing" type="{http://ws.price.isp.com/proposteCJPOS/}wrapperMap" minOccurs="0"/&gt;
 *         &lt;element name="listaCondizioni" type="{http://ws.price.isp.com/proposteCJPOS/}condizioneCJPOS" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propostaCJPOS", propOrder = {
    "tipoChiamata",
    "codiceOrigine",
    "rapportoReale",
    "dataAccensioneRapportoReale",
    "attributoRapporto",
    "profili",
    "datiProposta",
    "datiCliente",
    "listaAttributi",
    "attributiPricing",
    "listaCondizioni"
})
@XmlSeeAlso({
    PropostaCJPOSV2 .class
})
public class PropostaCJPOS {

    protected String tipoChiamata;
    protected String codiceOrigine;
    protected String rapportoReale;
    protected String dataAccensioneRapportoReale;
    protected String attributoRapporto;
    @XmlElement(nillable = true)
    protected List<String> profili;
    protected AnagraficaPropostaCJPOS datiProposta;
    protected DatiCliente datiCliente;
    protected WrapperMap listaAttributi;
    protected WrapperMap attributiPricing;
    protected List<CondizioneCJPOS> listaCondizioni;

    /**
     * Recupera il valore della proprietà tipoChiamata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoChiamata() {
        return tipoChiamata;
    }

    /**
     * Imposta il valore della proprietà tipoChiamata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoChiamata(String value) {
        this.tipoChiamata = value;
    }

    /**
     * Recupera il valore della proprietà codiceOrigine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceOrigine() {
        return codiceOrigine;
    }

    /**
     * Imposta il valore della proprietà codiceOrigine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceOrigine(String value) {
        this.codiceOrigine = value;
    }

    /**
     * Recupera il valore della proprietà rapportoReale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRapportoReale() {
        return rapportoReale;
    }

    /**
     * Imposta il valore della proprietà rapportoReale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRapportoReale(String value) {
        this.rapportoReale = value;
    }

    /**
     * Recupera il valore della proprietà dataAccensioneRapportoReale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAccensioneRapportoReale() {
        return dataAccensioneRapportoReale;
    }

    /**
     * Imposta il valore della proprietà dataAccensioneRapportoReale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAccensioneRapportoReale(String value) {
        this.dataAccensioneRapportoReale = value;
    }

    /**
     * Recupera il valore della proprietà attributoRapporto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributoRapporto() {
        return attributoRapporto;
    }

    /**
     * Imposta il valore della proprietà attributoRapporto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributoRapporto(String value) {
        this.attributoRapporto = value;
    }

    /**
     * Gets the value of the profili property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profili property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfili().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProfili() {
        if (profili == null) {
            profili = new ArrayList<String>();
        }
        return this.profili;
    }

    /**
     * Recupera il valore della proprietà datiProposta.
     * 
     * @return
     *     possible object is
     *     {@link AnagraficaPropostaCJPOS }
     *     
     */
    public AnagraficaPropostaCJPOS getDatiProposta() {
        return datiProposta;
    }

    /**
     * Imposta il valore della proprietà datiProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link AnagraficaPropostaCJPOS }
     *     
     */
    public void setDatiProposta(AnagraficaPropostaCJPOS value) {
        this.datiProposta = value;
    }

    /**
     * Recupera il valore della proprietà datiCliente.
     * 
     * @return
     *     possible object is
     *     {@link DatiCliente }
     *     
     */
    public DatiCliente getDatiCliente() {
        return datiCliente;
    }

    /**
     * Imposta il valore della proprietà datiCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiCliente }
     *     
     */
    public void setDatiCliente(DatiCliente value) {
        this.datiCliente = value;
    }

    /**
     * Recupera il valore della proprietà listaAttributi.
     * 
     * @return
     *     possible object is
     *     {@link WrapperMap }
     *     
     */
    public WrapperMap getListaAttributi() {
        return listaAttributi;
    }

    /**
     * Imposta il valore della proprietà listaAttributi.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperMap }
     *     
     */
    public void setListaAttributi(WrapperMap value) {
        this.listaAttributi = value;
    }

    /**
     * Recupera il valore della proprietà attributiPricing.
     * 
     * @return
     *     possible object is
     *     {@link WrapperMap }
     *     
     */
    public WrapperMap getAttributiPricing() {
        return attributiPricing;
    }

    /**
     * Imposta il valore della proprietà attributiPricing.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperMap }
     *     
     */
    public void setAttributiPricing(WrapperMap value) {
        this.attributiPricing = value;
    }

    /**
     * Gets the value of the listaCondizioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCondizioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCondizioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CondizioneCJPOS }
     * 
     * 
     */
    public List<CondizioneCJPOS> getListaCondizioni() {
        if (listaCondizioni == null) {
            listaCondizioni = new ArrayList<CondizioneCJPOS>();
        }
        return this.listaCondizioni;
    }

}
