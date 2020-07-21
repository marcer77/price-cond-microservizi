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
 * <p>Classe Java per parametroCondizioneDeroga complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="parametroCondizioneDeroga"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="segnoSpread" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="spread" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="valoriPercParametri" type="{http://ws.price.isp.com/proposteCJPOS/}valoriPercParametri" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametroCondizioneDeroga", propOrder = {
    "segnoSpread",
    "spread",
    "valoriPercParametri"
})
public class ParametroCondizioneDeroga {

    protected String segnoSpread;
    protected Double spread;
    @XmlElement(nillable = true)
    protected List<ValoriPercParametri> valoriPercParametri;

    /**
     * Recupera il valore della proprietà segnoSpread.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegnoSpread() {
        return segnoSpread;
    }

    /**
     * Imposta il valore della proprietà segnoSpread.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegnoSpread(String value) {
        this.segnoSpread = value;
    }

    /**
     * Recupera il valore della proprietà spread.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSpread() {
        return spread;
    }

    /**
     * Imposta il valore della proprietà spread.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSpread(Double value) {
        this.spread = value;
    }

    /**
     * Gets the value of the valoriPercParametri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valoriPercParametri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValoriPercParametri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValoriPercParametri }
     * 
     * 
     */
    public List<ValoriPercParametri> getValoriPercParametri() {
        if (valoriPercParametri == null) {
            valoriPercParametri = new ArrayList<ValoriPercParametri>();
        }
        return this.valoriPercParametri;
    }

}
