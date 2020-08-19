//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.19 alle 12:00:10 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ISPWebservicesHeaderType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ISPWebservicesHeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="RequestInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *                   &lt;element name="ServiceID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ServiceVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="OperatorInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="UserID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                 &lt;attribute name="IsVirtualUser" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *                 &lt;attribute name="NotISPUserID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CompanyInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="ISPCallerCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="NotISPCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="ISPBranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="ISPServiceCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="BusinessInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="BusinessProcessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="BusinessProcessID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="BusinessOperation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="BusinessFileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TechnicalInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="ChannelIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ApplicationID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="CallerServerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="CallerProgramName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AdditionalBusinessInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Param" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="Name" use="required" type="{http://intesasanpaolo.it/}ParamList" /&gt;
 *                           &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ISPWebservicesHeaderType", namespace = "http://intesasanpaolo.it/", propOrder = {

})
public class ISPWebservicesHeaderType {

    @XmlElement(name = "RequestInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.RequestInfo requestInfo;
    @XmlElement(name = "OperatorInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.OperatorInfo operatorInfo;
    @XmlElement(name = "CompanyInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.CompanyInfo companyInfo;
    @XmlElement(name = "BusinessInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.BusinessInfo businessInfo;
    @XmlElement(name = "TechnicalInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.TechnicalInfo technicalInfo;
    @XmlElement(name = "AdditionalBusinessInfo", namespace = "", required = true)
    protected ISPWebservicesHeaderType.AdditionalBusinessInfo additionalBusinessInfo;

    /**
     * Recupera il valore della proprietà requestInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.RequestInfo }
     *     
     */
    public ISPWebservicesHeaderType.RequestInfo getRequestInfo() {
        return requestInfo;
    }

    /**
     * Imposta il valore della proprietà requestInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.RequestInfo }
     *     
     */
    public void setRequestInfo(ISPWebservicesHeaderType.RequestInfo value) {
        this.requestInfo = value;
    }

    /**
     * Recupera il valore della proprietà operatorInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.OperatorInfo }
     *     
     */
    public ISPWebservicesHeaderType.OperatorInfo getOperatorInfo() {
        return operatorInfo;
    }

    /**
     * Imposta il valore della proprietà operatorInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.OperatorInfo }
     *     
     */
    public void setOperatorInfo(ISPWebservicesHeaderType.OperatorInfo value) {
        this.operatorInfo = value;
    }

    /**
     * Recupera il valore della proprietà companyInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.CompanyInfo }
     *     
     */
    public ISPWebservicesHeaderType.CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    /**
     * Imposta il valore della proprietà companyInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.CompanyInfo }
     *     
     */
    public void setCompanyInfo(ISPWebservicesHeaderType.CompanyInfo value) {
        this.companyInfo = value;
    }

    /**
     * Recupera il valore della proprietà businessInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.BusinessInfo }
     *     
     */
    public ISPWebservicesHeaderType.BusinessInfo getBusinessInfo() {
        return businessInfo;
    }

    /**
     * Imposta il valore della proprietà businessInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.BusinessInfo }
     *     
     */
    public void setBusinessInfo(ISPWebservicesHeaderType.BusinessInfo value) {
        this.businessInfo = value;
    }

    /**
     * Recupera il valore della proprietà technicalInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.TechnicalInfo }
     *     
     */
    public ISPWebservicesHeaderType.TechnicalInfo getTechnicalInfo() {
        return technicalInfo;
    }

    /**
     * Imposta il valore della proprietà technicalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.TechnicalInfo }
     *     
     */
    public void setTechnicalInfo(ISPWebservicesHeaderType.TechnicalInfo value) {
        this.technicalInfo = value;
    }

    /**
     * Recupera il valore della proprietà additionalBusinessInfo.
     * 
     * @return
     *     possible object is
     *     {@link ISPWebservicesHeaderType.AdditionalBusinessInfo }
     *     
     */
    public ISPWebservicesHeaderType.AdditionalBusinessInfo getAdditionalBusinessInfo() {
        return additionalBusinessInfo;
    }

    /**
     * Imposta il valore della proprietà additionalBusinessInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ISPWebservicesHeaderType.AdditionalBusinessInfo }
     *     
     */
    public void setAdditionalBusinessInfo(ISPWebservicesHeaderType.AdditionalBusinessInfo value) {
        this.additionalBusinessInfo = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Param" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="Name" use="required" type="{http://intesasanpaolo.it/}ParamList" /&gt;
     *                 &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "param"
    })
    public static class AdditionalBusinessInfo {

        @XmlElement(name = "Param", namespace = "", required = true)
        protected List<ISPWebservicesHeaderType.AdditionalBusinessInfo.Param> param;

        /**
         * Gets the value of the param property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the param property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getParam().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ISPWebservicesHeaderType.AdditionalBusinessInfo.Param }
         * 
         * 
         */
        public List<ISPWebservicesHeaderType.AdditionalBusinessInfo.Param> getParam() {
            if (param == null) {
                param = new ArrayList<ISPWebservicesHeaderType.AdditionalBusinessInfo.Param>();
            }
            return this.param;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="Name" use="required" type="{http://intesasanpaolo.it/}ParamList" /&gt;
         *       &lt;attribute name="Value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Param {

            @XmlAttribute(name = "Name", required = true)
            protected ParamList name;
            @XmlAttribute(name = "Value", required = true)
            protected String value;

            /**
             * Recupera il valore della proprietà name.
             * 
             * @return
             *     possible object is
             *     {@link ParamList }
             *     
             */
            public ParamList getName() {
                return name;
            }

            /**
             * Imposta il valore della proprietà name.
             * 
             * @param value
             *     allowed object is
             *     {@link ParamList }
             *     
             */
            public void setName(ParamList value) {
                this.name = value;
            }

            /**
             * Recupera il valore della proprietà value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Imposta il valore della proprietà value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="BusinessProcessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="BusinessProcessID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="BusinessOperation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="BusinessFileID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class BusinessInfo {

        @XmlElement(name = "CustomerID", namespace = "", required = true)
        protected String customerID;
        @XmlElement(name = "BusinessProcessName", namespace = "")
        protected String businessProcessName;
        @XmlElement(name = "BusinessProcessID", namespace = "")
        protected String businessProcessID;
        @XmlElement(name = "BusinessOperation", namespace = "")
        protected String businessOperation;
        @XmlElement(name = "BusinessFileID", namespace = "")
        protected String businessFileID;

        /**
         * Recupera il valore della proprietà customerID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerID() {
            return customerID;
        }

        /**
         * Imposta il valore della proprietà customerID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerID(String value) {
            this.customerID = value;
        }

        /**
         * Recupera il valore della proprietà businessProcessName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusinessProcessName() {
            return businessProcessName;
        }

        /**
         * Imposta il valore della proprietà businessProcessName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusinessProcessName(String value) {
            this.businessProcessName = value;
        }

        /**
         * Recupera il valore della proprietà businessProcessID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusinessProcessID() {
            return businessProcessID;
        }

        /**
         * Imposta il valore della proprietà businessProcessID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusinessProcessID(String value) {
            this.businessProcessID = value;
        }

        /**
         * Recupera il valore della proprietà businessOperation.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusinessOperation() {
            return businessOperation;
        }

        /**
         * Imposta il valore della proprietà businessOperation.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusinessOperation(String value) {
            this.businessOperation = value;
        }

        /**
         * Recupera il valore della proprietà businessFileID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBusinessFileID() {
            return businessFileID;
        }

        /**
         * Imposta il valore della proprietà businessFileID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBusinessFileID(String value) {
            this.businessFileID = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="ISPCallerCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="NotISPCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="ISPBranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="ISPServiceCompanyIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class CompanyInfo {

        @XmlElement(name = "ISPCallerCompanyIDCode", namespace = "", required = true)
        protected String ispCallerCompanyIDCode;
        @XmlElement(name = "NotISPCompanyIDCode", namespace = "")
        protected String notISPCompanyIDCode;
        @XmlElement(name = "ISPBranchCode", namespace = "")
        protected String ispBranchCode;
        @XmlElement(name = "ISPServiceCompanyIDCode", namespace = "", required = true)
        protected String ispServiceCompanyIDCode;

        /**
         * Recupera il valore della proprietà ispCallerCompanyIDCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getISPCallerCompanyIDCode() {
            return ispCallerCompanyIDCode;
        }

        /**
         * Imposta il valore della proprietà ispCallerCompanyIDCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setISPCallerCompanyIDCode(String value) {
            this.ispCallerCompanyIDCode = value;
        }

        /**
         * Recupera il valore della proprietà notISPCompanyIDCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotISPCompanyIDCode() {
            return notISPCompanyIDCode;
        }

        /**
         * Imposta il valore della proprietà notISPCompanyIDCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotISPCompanyIDCode(String value) {
            this.notISPCompanyIDCode = value;
        }

        /**
         * Recupera il valore della proprietà ispBranchCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getISPBranchCode() {
            return ispBranchCode;
        }

        /**
         * Imposta il valore della proprietà ispBranchCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setISPBranchCode(String value) {
            this.ispBranchCode = value;
        }

        /**
         * Recupera il valore della proprietà ispServiceCompanyIDCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getISPServiceCompanyIDCode() {
            return ispServiceCompanyIDCode;
        }

        /**
         * Imposta il valore della proprietà ispServiceCompanyIDCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setISPServiceCompanyIDCode(String value) {
            this.ispServiceCompanyIDCode = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="UserID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="IsVirtualUser" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
     *       &lt;attribute name="NotISPUserID" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class OperatorInfo {

        @XmlAttribute(name = "UserID", required = true)
        protected String userID;
        @XmlAttribute(name = "IsVirtualUser", required = true)
        protected boolean isVirtualUser;
        @XmlAttribute(name = "NotISPUserID")
        protected String notISPUserID;

        /**
         * Recupera il valore della proprietà userID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUserID() {
            return userID;
        }

        /**
         * Imposta il valore della proprietà userID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUserID(String value) {
            this.userID = value;
        }

        /**
         * Recupera il valore della proprietà isVirtualUser.
         * 
         */
        public boolean isIsVirtualUser() {
            return isVirtualUser;
        }

        /**
         * Imposta il valore della proprietà isVirtualUser.
         * 
         */
        public void setIsVirtualUser(boolean value) {
            this.isVirtualUser = value;
        }

        /**
         * Recupera il valore della proprietà notISPUserID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNotISPUserID() {
            return notISPUserID;
        }

        /**
         * Imposta il valore della proprietà notISPUserID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNotISPUserID(String value) {
            this.notISPUserID = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
     *         &lt;element name="ServiceID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ServiceVersion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class RequestInfo {

        @XmlElement(name = "TransactionId", namespace = "", required = true)
        protected String transactionId;
        @XmlElement(name = "Timestamp", namespace = "")
        protected long timestamp;
        @XmlElement(name = "ServiceID", namespace = "", required = true)
        protected String serviceID;
        @XmlElement(name = "ServiceVersion", namespace = "", required = true)
        protected String serviceVersion;
        @XmlElement(name = "Language", namespace = "")
        protected String language;

        /**
         * Recupera il valore della proprietà transactionId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransactionId() {
            return transactionId;
        }

        /**
         * Imposta il valore della proprietà transactionId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransactionId(String value) {
            this.transactionId = value;
        }

        /**
         * Recupera il valore della proprietà timestamp.
         * 
         */
        public long getTimestamp() {
            return timestamp;
        }

        /**
         * Imposta il valore della proprietà timestamp.
         * 
         */
        public void setTimestamp(long value) {
            this.timestamp = value;
        }

        /**
         * Recupera il valore della proprietà serviceID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceID() {
            return serviceID;
        }

        /**
         * Imposta il valore della proprietà serviceID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceID(String value) {
            this.serviceID = value;
        }

        /**
         * Recupera il valore della proprietà serviceVersion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceVersion() {
            return serviceVersion;
        }

        /**
         * Imposta il valore della proprietà serviceVersion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceVersion(String value) {
            this.serviceVersion = value;
        }

        /**
         * Recupera il valore della proprietà language.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLanguage() {
            return language;
        }

        /**
         * Imposta il valore della proprietà language.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguage(String value) {
            this.language = value;
        }

    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element name="ChannelIDCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ApplicationID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="CallerServerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="CallerProgramName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class TechnicalInfo {

        @XmlElement(name = "ChannelIDCode", namespace = "", required = true)
        protected String channelIDCode;
        @XmlElement(name = "ApplicationID", namespace = "", required = true)
        protected String applicationID;
        @XmlElement(name = "CallerServerName", namespace = "", required = true)
        protected String callerServerName;
        @XmlElement(name = "CallerProgramName", namespace = "", required = true)
        protected String callerProgramName;

        /**
         * Recupera il valore della proprietà channelIDCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getChannelIDCode() {
            return channelIDCode;
        }

        /**
         * Imposta il valore della proprietà channelIDCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setChannelIDCode(String value) {
            this.channelIDCode = value;
        }

        /**
         * Recupera il valore della proprietà applicationID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplicationID() {
            return applicationID;
        }

        /**
         * Imposta il valore della proprietà applicationID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplicationID(String value) {
            this.applicationID = value;
        }

        /**
         * Recupera il valore della proprietà callerServerName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCallerServerName() {
            return callerServerName;
        }

        /**
         * Imposta il valore della proprietà callerServerName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCallerServerName(String value) {
            this.callerServerName = value;
        }

        /**
         * Recupera il valore della proprietà callerProgramName.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCallerProgramName() {
            return callerProgramName;
        }

        /**
         * Imposta il valore della proprietà callerProgramName.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCallerProgramName(String value) {
            this.callerProgramName = value;
        }

    }

}
