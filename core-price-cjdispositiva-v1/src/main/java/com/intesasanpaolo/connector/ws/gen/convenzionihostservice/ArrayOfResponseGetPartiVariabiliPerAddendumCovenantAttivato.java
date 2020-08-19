//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.08.19 alle 12:00:12 PM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato" type="{http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities}Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato", propOrder = {
    "responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato"
})
public class ArrayOfResponseGetPartiVariabiliPerAddendumCovenantAttivato {

    @XmlElement(name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato", nillable = true)
    protected List<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato> responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato;

    /**
     * Gets the value of the responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }
     * 
     * 
     */
    public List<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato> getResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato() {
        if (responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato == null) {
            responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato = new ArrayList<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato>();
        }
        return this.responseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato;
    }

}
