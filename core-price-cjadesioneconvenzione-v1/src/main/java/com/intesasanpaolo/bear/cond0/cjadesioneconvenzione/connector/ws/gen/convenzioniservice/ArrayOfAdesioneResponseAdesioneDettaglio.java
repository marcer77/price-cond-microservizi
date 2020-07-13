//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.13 alle 10:14:52 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfAdesione_Response.Adesione_Dettaglio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAdesione_Response.Adesione_Dettaglio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Adesione_Response.Adesione_Dettaglio" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Adesione_Response.Adesione_Dettaglio" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAdesione_Response.Adesione_Dettaglio", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "adesioneResponseAdesioneDettaglio"
})
public class ArrayOfAdesioneResponseAdesioneDettaglio {

    @XmlElement(name = "Adesione_Response.Adesione_Dettaglio", nillable = true)
    protected List<AdesioneResponseAdesioneDettaglio> adesioneResponseAdesioneDettaglio;

    /**
     * Gets the value of the adesioneResponseAdesioneDettaglio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adesioneResponseAdesioneDettaglio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdesioneResponseAdesioneDettaglio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdesioneResponseAdesioneDettaglio }
     * 
     * 
     */
    public List<AdesioneResponseAdesioneDettaglio> getAdesioneResponseAdesioneDettaglio() {
        if (adesioneResponseAdesioneDettaglio == null) {
            adesioneResponseAdesioneDettaglio = new ArrayList<AdesioneResponseAdesioneDettaglio>();
        }
        return this.adesioneResponseAdesioneDettaglio;
    }

}
