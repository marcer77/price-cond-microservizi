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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per propostaCJPOSV2 complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="propostaCJPOSV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.price.isp.com/proposteCJPOS/}propostaCJPOS"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="allegatiProposta" type="{http://ws.price.isp.com/proposteCJPOS/}allegatoProposta" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propostaCJPOSV2", propOrder = {
    "allegatiProposta"
})
public class PropostaCJPOSV2
    extends PropostaCJPOS
{

    protected List<AllegatoProposta> allegatiProposta;

    /**
     * Gets the value of the allegatiProposta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allegatiProposta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllegatiProposta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllegatoProposta }
     * 
     * 
     */
    public List<AllegatoProposta> getAllegatiProposta() {
        if (allegatiProposta == null) {
            allegatiProposta = new ArrayList<AllegatoProposta>();
        }
        return this.allegatiProposta;
    }

}
