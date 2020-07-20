//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.14 alle 12:42:37 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjadesioneconvenzione.connector.ws.gen.convenzioniservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfPortafoglio_Adesione complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPortafoglio_Adesione"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Portafoglio_Adesione" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione}Portafoglio_Adesione" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPortafoglio_Adesione", propOrder = {
    "portafoglioAdesione"
})
public class ArrayOfPortafoglioAdesione {

    @XmlElement(name = "Portafoglio_Adesione", nillable = true)
    protected List<PortafoglioAdesione> portafoglioAdesione;

    /**
     * Gets the value of the portafoglioAdesione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portafoglioAdesione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortafoglioAdesione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PortafoglioAdesione }
     * 
     * 
     */
    public List<PortafoglioAdesione> getPortafoglioAdesione() {
        if (portafoglioAdesione == null) {
            portafoglioAdesione = new ArrayList<PortafoglioAdesione>();
        }
        return this.portafoglioAdesione;
    }

}
