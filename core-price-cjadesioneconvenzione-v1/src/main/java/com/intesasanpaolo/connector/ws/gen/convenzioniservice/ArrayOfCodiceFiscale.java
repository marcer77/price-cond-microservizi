//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfCodiceFiscale complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCodiceFiscale"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodiceFiscale" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}CodiceFiscale" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCodiceFiscale", namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", propOrder = {
    "codiceFiscale"
})
public class ArrayOfCodiceFiscale {

    @XmlElement(name = "CodiceFiscale", nillable = true)
    protected List<CodiceFiscale> codiceFiscale;

    /**
     * Gets the value of the codiceFiscale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codiceFiscale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodiceFiscale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodiceFiscale }
     * 
     * 
     */
    public List<CodiceFiscale> getCodiceFiscale() {
        if (codiceFiscale == null) {
            codiceFiscale = new ArrayList<CodiceFiscale>();
        }
        return this.codiceFiscale;
    }

}
