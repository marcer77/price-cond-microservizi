/*
 * GESTIONE
 * test
 *
 * OpenAPI spec version: 1.0.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.client.pcgestixme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Objects;

/**
 * OutputDatiDebugDatiErrore
 */
@Setter
public class OutputDatiDebugDatiErrore {

    private String returnCodeLink;
    private String nomeModulo;
    private String funzErrore;
    private OutputDatiDebugDatiErroreAreaErroreDB2 areaErroreDB2;
    private OutputDatiDebugDatiErroreAreaErroreCics areaErroreCics;
    private String labelErrore;

    @JsonProperty("ReturnCodeLink")
    public String getReturnCodeLink() {
        return returnCodeLink;
    }

    @JsonProperty("NomeModulo")
    public String getNomeModulo() {
        return nomeModulo;
    }

    @JsonProperty("FunzErrore")
    public String getFunzErrore() {
        return funzErrore;
    }

    @JsonProperty("AreaErroreDB2")
    public OutputDatiDebugDatiErroreAreaErroreDB2 getAreaErroreDB2() {
        return areaErroreDB2;
    }

    @JsonProperty("AreaErroreCics")
    public OutputDatiDebugDatiErroreAreaErroreCics getAreaErroreCics() {
        return areaErroreCics;
    }

    @JsonProperty("LabelErrore")
    public String getLabelErrore() {
        return labelErrore;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OutputDatiDebugDatiErrore outputDatiDebugDatiErrore = (OutputDatiDebugDatiErrore) o;
        return Objects.equals(returnCodeLink, outputDatiDebugDatiErrore.returnCodeLink) &&
                Objects.equals(nomeModulo, outputDatiDebugDatiErrore.nomeModulo) &&
                Objects.equals(funzErrore, outputDatiDebugDatiErrore.funzErrore) &&
                Objects.equals(areaErroreDB2, outputDatiDebugDatiErrore.areaErroreDB2) &&
                Objects.equals(areaErroreCics, outputDatiDebugDatiErrore.areaErroreCics) &&
                Objects.equals(labelErrore, outputDatiDebugDatiErrore.labelErrore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnCodeLink, nomeModulo, funzErrore, areaErroreDB2, areaErroreCics, labelErrore);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OutputDatiDebugDatiErrore {\n");

        sb.append("    returnCodeLink: ").append(toIndentedString(returnCodeLink)).append("\n");
        sb.append("    nomeModulo: ").append(toIndentedString(nomeModulo)).append("\n");
        sb.append("    funzErrore: ").append(toIndentedString(funzErrore)).append("\n");
        sb.append("    areaErroreDB2: ").append(toIndentedString(areaErroreDB2)).append("\n");
        sb.append("    areaErroreCics: ").append(toIndentedString(areaErroreCics)).append("\n");
        sb.append("    labelErrore: ").append(toIndentedString(labelErrore)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
