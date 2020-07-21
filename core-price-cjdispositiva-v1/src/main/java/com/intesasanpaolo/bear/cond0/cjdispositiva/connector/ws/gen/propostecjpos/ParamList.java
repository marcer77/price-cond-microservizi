//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:16:56 PM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ParamList.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <p>
 * <pre>
 * &lt;simpleType name="ParamList"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CodABI"/&gt;
 *     &lt;enumeration value="CodUnitaOperativa"/&gt;
 *     &lt;enumeration value="DataContabile"/&gt;
 *     &lt;enumeration value="FlagPaperless"/&gt;
 *     &lt;enumeration value="CodOperativita"/&gt;
 *     &lt;enumeration value="CodTerminaleCics"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ParamList", namespace = "http://intesasanpaolo.it/")
@XmlEnum
public enum ParamList {

    @XmlEnumValue("CodABI")
    COD_ABI("CodABI"),
    @XmlEnumValue("CodUnitaOperativa")
    COD_UNITA_OPERATIVA("CodUnitaOperativa"),
    @XmlEnumValue("DataContabile")
    DATA_CONTABILE("DataContabile"),
    @XmlEnumValue("FlagPaperless")
    FLAG_PAPERLESS("FlagPaperless"),
    @XmlEnumValue("CodOperativita")
    COD_OPERATIVITA("CodOperativita"),
    @XmlEnumValue("CodTerminaleCics")
    COD_TERMINALE_CICS("CodTerminaleCics");
    private final String value;

    ParamList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParamList fromValue(String v) {
        for (ParamList c: ParamList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
