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

import static com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ApplicationConstants.COBOL_EMPTY;
/**
 * InputDatiInputAreaArrayPromo
 */
@Setter
public class InputDatiInputAreaArrayPromo {

    private String codPromozione = COBOL_EMPTY;
    private String dataDecoPromR = COBOL_EMPTY;
    private String dataDecaPromR = COBOL_EMPTY;
    private String filler = COBOL_EMPTY;

    @JsonProperty("CodPromozione")
    public String getCodPromozione() {
        return codPromozione;
    }

    @JsonProperty("DataDecoPromR")
    public String getDataDecoPromR() {
        return dataDecoPromR;
    }

    @JsonProperty("DataDecaPromR")
    public String getDataDecaPromR() {
        return dataDecaPromR;
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
        InputDatiInputAreaArrayPromo inputDatiInputAreaArrayPromo = (InputDatiInputAreaArrayPromo) o;
        return Objects.equals(codPromozione, inputDatiInputAreaArrayPromo.codPromozione) &&
                Objects.equals(dataDecoPromR, inputDatiInputAreaArrayPromo.dataDecoPromR) &&
                Objects.equals(dataDecaPromR, inputDatiInputAreaArrayPromo.dataDecaPromR) &&
                Objects.equals(filler, inputDatiInputAreaArrayPromo.filler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPromozione, dataDecoPromR, dataDecaPromR, filler);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InputDatiInputAreaArrayPromo {\n");

        sb.append("    codPromozione: ").append(toIndentedString(codPromozione)).append("\n");
        sb.append("    dataDecoPromR: ").append(toIndentedString(dataDecoPromR)).append("\n");
        sb.append("    dataDecaPromR: ").append(toIndentedString(dataDecaPromR)).append("\n");
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