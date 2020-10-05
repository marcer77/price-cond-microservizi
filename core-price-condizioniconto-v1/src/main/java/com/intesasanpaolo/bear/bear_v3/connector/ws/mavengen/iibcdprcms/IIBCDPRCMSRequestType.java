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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IIBCDPRCMSRequestType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IIBCDPRCMSRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="prodotto" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}IIBCDPRCMSSingleRequestType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="flagODM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IIBCDPRCMSRequestType", propOrder = {
    "prodotto",
    "flagODM"
})
public class IIBCDPRCMSRequestType {

    @XmlElement(required = true)
    protected List<IIBCDPRCMSSingleRequestType> prodotto;
    protected String flagODM;

    /**
     * Gets the value of the prodotto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prodotto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProdotto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IIBCDPRCMSSingleRequestType }
     * 
     * 
     */
    public List<IIBCDPRCMSSingleRequestType> getProdotto() {
        if (prodotto == null) {
            prodotto = new ArrayList<IIBCDPRCMSSingleRequestType>();
        }
        return this.prodotto;
    }

    /**
     * Recupera il valore della proprietà flagODM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagODM() {
        return flagODM;
    }

    /**
     * Imposta il valore della proprietà flagODM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagODM(String value) {
        this.flagODM = value;
    }

}
