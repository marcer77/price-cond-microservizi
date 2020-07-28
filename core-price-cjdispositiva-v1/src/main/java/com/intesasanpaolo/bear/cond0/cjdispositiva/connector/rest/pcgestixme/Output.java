package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.rest.pcgestixme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.Objects;

@Setter
public class Output {
    private OutputDatiDebug datiDebug;
    private OutputAreaDati areaDati;

    @JsonProperty("DatiDebug")
    public OutputDatiDebug getDatiDebug() {
        return datiDebug;
    }

    @JsonProperty("AreaDati")
    public OutputAreaDati getAreaDati() {
        return areaDati;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Output newAccountOutput = (Output) o;
        return Objects.equals(datiDebug, newAccountOutput.datiDebug) &&
                Objects.equals(areaDati, newAccountOutput.areaDati);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datiDebug, areaDati);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewAccountOutput {\n");

        sb.append("    datiDebug: ").append(toIndentedString(datiDebug)).append("\n");
        sb.append("    areaDati: ").append(toIndentedString(areaDati)).append("\n");
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
