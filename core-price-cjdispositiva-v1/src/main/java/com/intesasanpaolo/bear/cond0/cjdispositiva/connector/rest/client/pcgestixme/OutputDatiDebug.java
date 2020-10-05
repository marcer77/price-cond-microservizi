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
 * OutputDatiDebug
 */
@Setter
public class OutputDatiDebug {

    private String returnCode;
    private String codMessaggio;
    private String txTMessaggio;
    private String campoErrore;
    private OutputDatiDebugDatiErrore datiErrore;

    @JsonProperty("ReturnCode")
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @JsonProperty("CodMessaggio")
    public String getCodMessaggio() {
        return codMessaggio;
    }

    @JsonProperty("TXTMessaggio")
    public String getTxTMessaggio() {
        return txTMessaggio;
    }

    @JsonProperty("CampoErrore")
    public String getCampoErrore() {
        return campoErrore;
    }

    @JsonProperty("DatiErrore")
    public OutputDatiDebugDatiErrore getDatiErrore() {
        return datiErrore;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OutputDatiDebug outputDatiDebug = (OutputDatiDebug) o;
        return Objects.equals(returnCode, outputDatiDebug.returnCode) &&
                Objects.equals(codMessaggio, outputDatiDebug.codMessaggio) &&
                Objects.equals(txTMessaggio, outputDatiDebug.txTMessaggio) &&
                Objects.equals(campoErrore, outputDatiDebug.campoErrore) &&
                Objects.equals(datiErrore, outputDatiDebug.datiErrore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returnCode, codMessaggio, txTMessaggio, campoErrore, datiErrore);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OutputDatiDebug {\n");

        sb.append("    returnCode: ").append(toIndentedString(returnCode)).append("\n");
        sb.append("    codMessaggio: ").append(toIndentedString(codMessaggio)).append("\n");
        sb.append("    txTMessaggio: ").append(toIndentedString(txTMessaggio)).append("\n");
        sb.append("    campoErrore: ").append(toIndentedString(campoErrore)).append("\n");
        sb.append("    datiErrore: ").append(toIndentedString(datiErrore)).append("\n");
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

