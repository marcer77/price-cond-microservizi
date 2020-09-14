//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per OutOutputPrice complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="OutOutputPrice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codConv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codMotorePrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutOutputPrice", propOrder = {
    "codConv",
    "codMotorePrice"
})
public class OutOutputPrice {

    protected String codConv;
    protected String codMotorePrice;

    /**
     * Recupera il valore della proprietà codConv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodConv() {
        return codConv;
    }

    /**
     * Imposta il valore della proprietà codConv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodConv(String value) {
        this.codConv = value;
    }

    /**
     * Recupera il valore della proprietà codMotorePrice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMotorePrice() {
        return codMotorePrice;
    }

    /**
     * Imposta il valore della proprietà codMotorePrice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMotorePrice(String value) {
        this.codMotorePrice = value;
    }

}
