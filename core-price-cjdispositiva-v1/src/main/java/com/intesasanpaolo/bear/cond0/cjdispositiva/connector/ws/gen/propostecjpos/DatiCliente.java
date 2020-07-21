//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:16:56 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per datiCliente complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datiCliente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="abiCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ndgCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sndgCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cfCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pivaCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoGestore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceRapporto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nominativoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cfCointestatari" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiCliente", propOrder = {
    "abiCliente",
    "ndgCliente",
    "sndgCliente",
    "cfCliente",
    "pivaCliente",
    "uoGestore",
    "codiceRapporto",
    "nominativoCliente",
    "cfCointestatari"
})
public class DatiCliente {

    protected String abiCliente;
    protected String ndgCliente;
    protected String sndgCliente;
    protected String cfCliente;
    protected String pivaCliente;
    protected String uoGestore;
    protected String codiceRapporto;
    protected String nominativoCliente;
    @XmlElement(nillable = true)
    protected List<String> cfCointestatari;

    /**
     * Recupera il valore della proprietà abiCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbiCliente() {
        return abiCliente;
    }

    /**
     * Imposta il valore della proprietà abiCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbiCliente(String value) {
        this.abiCliente = value;
    }

    /**
     * Recupera il valore della proprietà ndgCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNdgCliente() {
        return ndgCliente;
    }

    /**
     * Imposta il valore della proprietà ndgCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNdgCliente(String value) {
        this.ndgCliente = value;
    }

    /**
     * Recupera il valore della proprietà sndgCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSndgCliente() {
        return sndgCliente;
    }

    /**
     * Imposta il valore della proprietà sndgCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSndgCliente(String value) {
        this.sndgCliente = value;
    }

    /**
     * Recupera il valore della proprietà cfCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCfCliente() {
        return cfCliente;
    }

    /**
     * Imposta il valore della proprietà cfCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCfCliente(String value) {
        this.cfCliente = value;
    }

    /**
     * Recupera il valore della proprietà pivaCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPivaCliente() {
        return pivaCliente;
    }

    /**
     * Imposta il valore della proprietà pivaCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPivaCliente(String value) {
        this.pivaCliente = value;
    }

    /**
     * Recupera il valore della proprietà uoGestore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoGestore() {
        return uoGestore;
    }

    /**
     * Imposta il valore della proprietà uoGestore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoGestore(String value) {
        this.uoGestore = value;
    }

    /**
     * Recupera il valore della proprietà codiceRapporto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceRapporto() {
        return codiceRapporto;
    }

    /**
     * Imposta il valore della proprietà codiceRapporto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceRapporto(String value) {
        this.codiceRapporto = value;
    }

    /**
     * Recupera il valore della proprietà nominativoCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNominativoCliente() {
        return nominativoCliente;
    }

    /**
     * Imposta il valore della proprietà nominativoCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNominativoCliente(String value) {
        this.nominativoCliente = value;
    }

    /**
     * Gets the value of the cfCointestatari property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cfCointestatari property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCfCointestatari().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCfCointestatari() {
        if (cfCointestatari == null) {
            cfCointestatari = new ArrayList<String>();
        }
        return this.cfCointestatari;
    }

}
