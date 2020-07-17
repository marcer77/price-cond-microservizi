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

package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Objects;

/**
 * OutputDatiDebugDatiErroreAreaErroreCics
 */
@Setter
public class OutputDatiDebugDatiErroreAreaErroreCics {

    private String codErrCics;
    private String filler;
    private String codAbendCics;

    @JsonProperty("CodErrCics")
    public String getCodErrCics() {
        return codErrCics;
    }

    @JsonProperty("Filler")
    public String getFiller() {
        return filler;
    }

    @JsonProperty("CodAbendCics")
    public String getCodAbendCics() {
        return codAbendCics;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OutputDatiDebugDatiErroreAreaErroreCics outputDatiDebugDatiErroreAreaErroreCics = (OutputDatiDebugDatiErroreAreaErroreCics) o;
        return Objects.equals(codErrCics, outputDatiDebugDatiErroreAreaErroreCics.codErrCics) &&
                Objects.equals(filler, outputDatiDebugDatiErroreAreaErroreCics.filler) &&
                Objects.equals(codAbendCics, outputDatiDebugDatiErroreAreaErroreCics.codAbendCics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codErrCics, filler, codAbendCics);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OutputDatiDebugDatiErroreAreaErroreCics {\n");

        sb.append("    codErrCics: ").append(toIndentedString(codErrCics)).append("\n");
        sb.append("    filler: ").append(toIndentedString(filler)).append("\n");
        sb.append("    codAbendCics: ").append(toIndentedString(codAbendCics)).append("\n");
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
