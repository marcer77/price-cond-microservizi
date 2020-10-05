//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per IIBCDPRCMSSingleRequestType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="IIBCDPRCMSSingleRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datiApplicativi" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}DatiApplicativi"/&gt;
 *         &lt;element name="parametriComuni" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}ParametriComuni"/&gt;
 *         &lt;element name="parametriFactory" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}ParametriFactory"/&gt;
 *         &lt;element name="parametriPrice" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}ParametriPrice"/&gt;
 *         &lt;element name="collectionDrivers" type="{http://www.intesa.org/T1IB0/IIBCDPRCMS/}CollectionDrivers"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IIBCDPRCMSSingleRequestType", propOrder = {
    "datiApplicativi",
    "parametriComuni",
    "parametriFactory",
    "parametriPrice",
    "collectionDrivers"
})
public class IIBCDPRCMSSingleRequestType {

    @XmlElement(required = true)
    protected DatiApplicativi datiApplicativi;
    @XmlElement(required = true)
    protected ParametriComuni parametriComuni;
    @XmlElement(required = true)
    protected ParametriFactory parametriFactory;
    @XmlElement(required = true)
    protected ParametriPrice parametriPrice;
    @XmlElement(required = true)
    protected CollectionDrivers collectionDrivers;

    /**
     * Recupera il valore della proprietà datiApplicativi.
     * 
     * @return
     *     possible object is
     *     {@link DatiApplicativi }
     *     
     */
    public DatiApplicativi getDatiApplicativi() {
        return datiApplicativi;
    }

    /**
     * Imposta il valore della proprietà datiApplicativi.
     * 
     * @param value
     *     allowed object is
     *     {@link DatiApplicativi }
     *     
     */
    public void setDatiApplicativi(DatiApplicativi value) {
        this.datiApplicativi = value;
    }

    /**
     * Recupera il valore della proprietà parametriComuni.
     * 
     * @return
     *     possible object is
     *     {@link ParametriComuni }
     *     
     */
    public ParametriComuni getParametriComuni() {
        return parametriComuni;
    }

    /**
     * Imposta il valore della proprietà parametriComuni.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametriComuni }
     *     
     */
    public void setParametriComuni(ParametriComuni value) {
        this.parametriComuni = value;
    }

    /**
     * Recupera il valore della proprietà parametriFactory.
     * 
     * @return
     *     possible object is
     *     {@link ParametriFactory }
     *     
     */
    public ParametriFactory getParametriFactory() {
        return parametriFactory;
    }

    /**
     * Imposta il valore della proprietà parametriFactory.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametriFactory }
     *     
     */
    public void setParametriFactory(ParametriFactory value) {
        this.parametriFactory = value;
    }

    /**
     * Recupera il valore della proprietà parametriPrice.
     * 
     * @return
     *     possible object is
     *     {@link ParametriPrice }
     *     
     */
    public ParametriPrice getParametriPrice() {
        return parametriPrice;
    }

    /**
     * Imposta il valore della proprietà parametriPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametriPrice }
     *     
     */
    public void setParametriPrice(ParametriPrice value) {
        this.parametriPrice = value;
    }

    /**
     * Recupera il valore della proprietà collectionDrivers.
     * 
     * @return
     *     possible object is
     *     {@link CollectionDrivers }
     *     
     */
    public CollectionDrivers getCollectionDrivers() {
        return collectionDrivers;
    }

    /**
     * Imposta il valore della proprietà collectionDrivers.
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionDrivers }
     *     
     */
    public void setCollectionDrivers(CollectionDrivers value) {
        this.collectionDrivers = value;
    }

}
