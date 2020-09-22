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

import static com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ApplicationConstants.COBOL_EMPTY;
/**
 * InputDatiInput
 */

@Setter
public class NewAccountDatiInput {

    private String funzione = COBOL_EMPTY;
    private InputDatiInputArea area = null;
    private String flagFunzione = COBOL_EMPTY;
    private String NDG = COBOL_EMPTY;
    private String tipoNDG = COBOL_EMPTY;
    private String dataAccensione = COBOL_EMPTY;
    private String flgProdModulOld = COBOL_EMPTY;
    private String flgProdModulNew = COBOL_EMPTY;
    private String filler = COBOL_EMPTY;

    @JsonProperty("Funzione")
    public String getFunzione() {
        return funzione;
    }

    @JsonProperty("Area")
    public InputDatiInputArea getArea() {
        return area;
    }

    @JsonProperty("FlagFunzione")
    public String getFlagFunzione() {
        return flagFunzione;
    }

    @JsonProperty("NDG")
    public String getNDG() {
        return NDG;
    }

    @JsonProperty("TipoNDG")
    public String getTipoNDG() {
        return tipoNDG;
    }

    @JsonProperty("DataAccensione")
    public String getDataAccensione() {
        return dataAccensione;
    }

    @JsonProperty("FlgProdModulOld")
    public String getFlgProdModulOld() {
        return flgProdModulOld;
    }

    @JsonProperty("FlgProdModulNew")
    public String getFlgProdModulNew() {
        return flgProdModulNew;
    }

    @JsonProperty("Filler")
    public String getFiller() {
        return filler;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewAccountDatiInput inputDatiInput = (NewAccountDatiInput) o;
        return Objects.equals(funzione, inputDatiInput.funzione) &&
                Objects.equals(area, inputDatiInput.area) &&
                Objects.equals(flagFunzione, inputDatiInput.flagFunzione) &&
                Objects.equals(NDG, inputDatiInput.NDG) &&
                Objects.equals(tipoNDG, inputDatiInput.tipoNDG) &&
                Objects.equals(dataAccensione, inputDatiInput.dataAccensione) &&
                Objects.equals(flgProdModulOld, inputDatiInput.flgProdModulOld) &&
                Objects.equals(flgProdModulNew, inputDatiInput.flgProdModulNew) &&
                Objects.equals(filler, inputDatiInput.filler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funzione, area, flagFunzione, NDG, tipoNDG, dataAccensione, flgProdModulOld, flgProdModulNew, filler);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewAccountDatiInput {\n");

        sb.append("    funzione: ").append(toIndentedString(funzione)).append("\n");
        sb.append("    area: ").append(toIndentedString(area)).append("\n");
        sb.append("    flagFunzione: ").append(toIndentedString(flagFunzione)).append("\n");
        sb.append("    NDG: ").append(toIndentedString(NDG)).append("\n");
        sb.append("    tipoNDG: ").append(toIndentedString(tipoNDG)).append("\n");
        sb.append("    dataAccensione: ").append(toIndentedString(dataAccensione)).append("\n");
        sb.append("    flgProdModulOld: ").append(toIndentedString(flgProdModulOld)).append("\n");
        sb.append("    flgProdModulNew: ").append(toIndentedString(flgProdModulNew)).append("\n");
        sb.append("    filler: ").append(toIndentedString(filler)).append("\n");
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