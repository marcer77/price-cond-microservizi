//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:35:12 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare", propOrder = {
    "responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare"
})
public class ArrayOfResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare {

    @XmlElement(name = "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare", nillable = true)
    protected List<ResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare> responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare;

    /**
     * Gets the value of the responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare }
     * 
     * 
     */
    public List<ResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare> getResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare() {
        if (responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare == null) {
            responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare = new ArrayList<ResponseStoreCovenantAdesioneConvenzioneCovenantDaCessare>();
        }
        return this.responseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare;
    }

}
