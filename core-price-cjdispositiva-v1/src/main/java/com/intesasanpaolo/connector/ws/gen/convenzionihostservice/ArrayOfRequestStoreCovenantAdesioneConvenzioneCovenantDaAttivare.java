//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:47 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare", propOrder = {
    "requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare"
})
public class ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare {

    @XmlElement(name = "Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare", nillable = true)
    protected List<RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare;

    /**
     * Gets the value of the requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }
     * 
     * 
     */
    public List<RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> getRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare() {
        if (requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare == null) {
            requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare = new ArrayList<RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare>();
        }
        return this.requestStoreCovenantAdesioneConvenzioneCovenantDaAttivare;
    }

}
