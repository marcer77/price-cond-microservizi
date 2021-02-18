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
import javax.xml.namespace.QName;


/**
 * <p>Classe Java per NBP_ErrorInfoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="NBP_ErrorInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ErrCode" type="{http://ws.intesasanpaolo.com/}codeEnum"/&gt;
 *         &lt;element name="ErrSubcode" type="{http://ws.intesasanpaolo.com/}subcodeEnum"/&gt;
 *         &lt;element name="ErrReason" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ErrSource" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AdditionalInfo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NBP_ErrorInfoType", namespace = "http://ws.intesasanpaolo.com/", propOrder = {

})
public class NBPErrorInfoType {

    @XmlElement(name = "ErrCode", required = true)
    protected QName errCode;
    @XmlElement(name = "ErrSubcode", required = true)
    protected QName errSubcode;
    @XmlElement(name = "ErrReason", required = true)
    protected String errReason;
    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "ErrSource", required = true)
    protected String errSource;
    @XmlElement(name = "AdditionalInfo", required = true)
    protected String additionalInfo;

    /**
     * Recupera il valore della proprietà errCode.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getErrCode() {
        return errCode;
    }

    /**
     * Imposta il valore della proprietà errCode.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setErrCode(QName value) {
        this.errCode = value;
    }

    /**
     * Recupera il valore della proprietà errSubcode.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getErrSubcode() {
        return errSubcode;
    }

    /**
     * Imposta il valore della proprietà errSubcode.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setErrSubcode(QName value) {
        this.errSubcode = value;
    }

    /**
     * Recupera il valore della proprietà errReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrReason() {
        return errReason;
    }

    /**
     * Imposta il valore della proprietà errReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrReason(String value) {
        this.errReason = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Imposta il valore della proprietà message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Recupera il valore della proprietà errSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrSource() {
        return errSource;
    }

    /**
     * Imposta il valore della proprietà errSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrSource(String value) {
        this.errSource = value;
    }

    /**
     * Recupera il valore della proprietà additionalInfo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Imposta il valore della proprietà additionalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

}
