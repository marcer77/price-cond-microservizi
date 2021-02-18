//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2019.09.03 alle 11:46:10 AM CEST 
//


package com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per InpTipodriver.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="InpTipodriver"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;length value="1"/&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="D"/&gt;
 *     &lt;enumeration value="H"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="I"/&gt;
 *     &lt;enumeration value="P"/&gt;
 *     &lt;enumeration value="C"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "InpTipodriver")
@XmlEnum
public enum InpTipodriver {

    N,
    D,
    H,
    E,
    I,
    P,
    C;

    public String value() {
        return name();
    }

    public static InpTipodriver fromValue(String v) {
        return valueOf(v);
    }

}
