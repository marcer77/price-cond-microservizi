//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:16:56 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per esitoRevocaPropostaCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="esitoRevocaPropostaCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoMessaggio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "esitoRevocaPropostaCJPOS", propOrder = {
    "codiceProposta",
    "esitoCodice",
    "esitoMessaggio"
})
public class EsitoRevocaPropostaCJPOS {

    protected String codiceProposta;
    protected String esitoCodice;
    protected String esitoMessaggio;

    /**
     * Recupera il valore della proprietà codiceProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProposta() {
        return codiceProposta;
    }

    /**
     * Imposta il valore della proprietà codiceProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProposta(String value) {
        this.codiceProposta = value;
    }

    /**
     * Recupera il valore della proprietà esitoCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoCodice() {
        return esitoCodice;
    }

    /**
     * Imposta il valore della proprietà esitoCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoCodice(String value) {
        this.esitoCodice = value;
    }

    /**
     * Recupera il valore della proprietà esitoMessaggio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoMessaggio() {
        return esitoMessaggio;
    }

    /**
     * Imposta il valore della proprietà esitoMessaggio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoMessaggio(String value) {
        this.esitoMessaggio = value;
    }

}
