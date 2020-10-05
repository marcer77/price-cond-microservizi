//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per OutValori complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="OutValori"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="origine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="liv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="etichetta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numdec" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="val" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="div" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrCond" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attrVal" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}AttributoValore" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutValori", propOrder = {
    "cod",
    "deco",
    "deca",
    "origine",
    "liv",
    "etichetta",
    "tipo",
    "dim",
    "numdec",
    "val",
    "div",
    "attrCond",
    "attrVal"
})
public class OutValori {

    protected String cod;
    protected String deco;
    protected String deca;
    protected String origine;
    protected String liv;
    protected String etichetta;
    protected String tipo;
    protected String dim;
    protected String numdec;
    protected String val;
    protected String div;
    protected String attrCond;
    protected List<AttributoValore> attrVal;

    /**
     * Recupera il valore della proprietà cod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCod() {
        return cod;
    }

    /**
     * Imposta il valore della proprietà cod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCod(String value) {
        this.cod = value;
    }

    /**
     * Recupera il valore della proprietà deco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeco() {
        return deco;
    }

    /**
     * Imposta il valore della proprietà deco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeco(String value) {
        this.deco = value;
    }

    /**
     * Recupera il valore della proprietà deca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeca() {
        return deca;
    }

    /**
     * Imposta il valore della proprietà deca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeca(String value) {
        this.deca = value;
    }

    /**
     * Recupera il valore della proprietà origine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Imposta il valore della proprietà origine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigine(String value) {
        this.origine = value;
    }

    /**
     * Recupera il valore della proprietà liv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLiv() {
        return liv;
    }

    /**
     * Imposta il valore della proprietà liv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLiv(String value) {
        this.liv = value;
    }

    /**
     * Recupera il valore della proprietà etichetta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtichetta() {
        return etichetta;
    }

    /**
     * Imposta il valore della proprietà etichetta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtichetta(String value) {
        this.etichetta = value;
    }

    /**
     * Recupera il valore della proprietà tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Imposta il valore della proprietà tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Recupera il valore della proprietà dim.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDim() {
        return dim;
    }

    /**
     * Imposta il valore della proprietà dim.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDim(String value) {
        this.dim = value;
    }

    /**
     * Recupera il valore della proprietà numdec.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumdec() {
        return numdec;
    }

    /**
     * Imposta il valore della proprietà numdec.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumdec(String value) {
        this.numdec = value;
    }

    /**
     * Recupera il valore della proprietà val.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVal() {
        return val;
    }

    /**
     * Imposta il valore della proprietà val.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVal(String value) {
        this.val = value;
    }

    /**
     * Recupera il valore della proprietà div.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiv() {
        return div;
    }

    /**
     * Imposta il valore della proprietà div.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiv(String value) {
        this.div = value;
    }

    /**
     * Recupera il valore della proprietà attrCond.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttrCond() {
        return attrCond;
    }

    /**
     * Imposta il valore della proprietà attrCond.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttrCond(String value) {
        this.attrCond = value;
    }

    /**
     * Gets the value of the attrVal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attrVal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttrVal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributoValore }
     * 
     * 
     */
    public List<AttributoValore> getAttrVal() {
        if (attrVal == null) {
            attrVal = new ArrayList<AttributoValore>();
        }
        return this.attrVal;
    }

}
