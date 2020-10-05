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
 * InputDatiInputAreaY1CXCHSP
 */
@Setter
public class InputDatiInputAreaY1CXCHSP {

    private String abi = COBOL_EMPTY;
    private String sportello = COBOL_EMPTY;
    private String canale = COBOL_EMPTY;
    private String codIstituto = COBOL_EMPTY;
    private String codUO = COBOL_EMPTY;
    private String dataREQ = COBOL_EMPTY;
    private String codUtente = COBOL_EMPTY;
    private String TSID = COBOL_EMPTY;
    private String datacontabile = COBOL_EMPTY;
    private Object idCliente = null;
    private String terminale = COBOL_EMPTY;
    private String aziendaDest = COBOL_EMPTY;
    private String codRisRich = COBOL_EMPTY;
    private String idServizio = COBOL_EMPTY;
    private String versioneServizio = COBOL_EMPTY;
    private String tipoLingua = COBOL_EMPTY;
    private String SSA = COBOL_EMPTY;
    private String flagPaperless = COBOL_EMPTY;

    @JsonProperty("Abi")
    public String getAbi() {
        return abi;
    }

    @JsonProperty("Sportello")
    public String getSportello() {
        return sportello;
    }

    @JsonProperty("Canale")
    public String getCanale() {
        return canale;
    }

    @JsonProperty("CodIstituto")
    public String getCodIstituto() {
        return codIstituto;
    }

    @JsonProperty("CodUO")
    public String getCodUO() {
        return codUO;
    }

    @JsonProperty("DataREQ")
    public String getDataREQ() {
        return dataREQ;
    }

    @JsonProperty("CodUtente")
    public String getCodUtente() {
        return codUtente;
    }

    @JsonProperty("TSID")
    public String getTSID() {
        return TSID;
    }

    @JsonProperty("Datacontabile")
    public String getDatacontabile() {
        return datacontabile;
    }

    @JsonProperty("IDCliente")
    public Object getIdCliente() {
        return idCliente;
    }

    @JsonProperty("Terminale")
    public String getTerminale() {
        return terminale;
    }

    @JsonProperty("AziendaDest")
    public String getAziendaDest() {
        return aziendaDest;
    }

    @JsonProperty("CodRisRich")
    public String getCodRisRich() {
        return codRisRich;
    }

    @JsonProperty("IDServizio")
    public String getIdServizio() {
        return idServizio;
    }

    @JsonProperty("VersioneServizio")
    public String getVersioneServizio() {
        return versioneServizio;
    }

    @JsonProperty("TipoLingua")
    public String getTipoLingua() {
        return tipoLingua;
    }

    @JsonProperty("SSA")
    public String getSSA() {
        return SSA;
    }

    @JsonProperty("FlagPaperless")
    public String getFlagPaperless() {
        return flagPaperless;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputDatiInputAreaY1CXCHSP inputDatiInputAreaY1CXCHSP = (InputDatiInputAreaY1CXCHSP) o;
        return Objects.equals(abi, inputDatiInputAreaY1CXCHSP.abi) &&
                Objects.equals(sportello, inputDatiInputAreaY1CXCHSP.sportello) &&
                Objects.equals(canale, inputDatiInputAreaY1CXCHSP.canale) &&
                Objects.equals(codIstituto, inputDatiInputAreaY1CXCHSP.codIstituto) &&
                Objects.equals(codUO, inputDatiInputAreaY1CXCHSP.codUO) &&
                Objects.equals(dataREQ, inputDatiInputAreaY1CXCHSP.dataREQ) &&
                Objects.equals(codUtente, inputDatiInputAreaY1CXCHSP.codUtente) &&
                Objects.equals(TSID, inputDatiInputAreaY1CXCHSP.TSID) &&
                Objects.equals(datacontabile, inputDatiInputAreaY1CXCHSP.datacontabile) &&
                Objects.equals(idCliente, inputDatiInputAreaY1CXCHSP.idCliente) &&
                Objects.equals(terminale, inputDatiInputAreaY1CXCHSP.terminale) &&
                Objects.equals(aziendaDest, inputDatiInputAreaY1CXCHSP.aziendaDest) &&
                Objects.equals(codRisRich, inputDatiInputAreaY1CXCHSP.codRisRich) &&
                Objects.equals(idServizio, inputDatiInputAreaY1CXCHSP.idServizio) &&
                Objects.equals(versioneServizio, inputDatiInputAreaY1CXCHSP.versioneServizio) &&
                Objects.equals(tipoLingua, inputDatiInputAreaY1CXCHSP.tipoLingua) &&
                Objects.equals(SSA, inputDatiInputAreaY1CXCHSP.SSA) &&
                Objects.equals(flagPaperless, inputDatiInputAreaY1CXCHSP.flagPaperless);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abi, sportello, canale, codIstituto, codUO, dataREQ, codUtente, TSID, datacontabile, idCliente, terminale, aziendaDest, codRisRich, idServizio, versioneServizio, tipoLingua, SSA, flagPaperless);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InputDatiInputAreaY1CXCHSP {\n");

        sb.append("    abi: ").append(toIndentedString(abi)).append("\n");
        sb.append("    sportello: ").append(toIndentedString(sportello)).append("\n");
        sb.append("    canale: ").append(toIndentedString(canale)).append("\n");
        sb.append("    codIstituto: ").append(toIndentedString(codIstituto)).append("\n");
        sb.append("    codUO: ").append(toIndentedString(codUO)).append("\n");
        sb.append("    dataREQ: ").append(toIndentedString(dataREQ)).append("\n");
        sb.append("    codUtente: ").append(toIndentedString(codUtente)).append("\n");
        sb.append("    TSID: ").append(toIndentedString(TSID)).append("\n");
        sb.append("    datacontabile: ").append(toIndentedString(datacontabile)).append("\n");
        sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
        sb.append("    terminale: ").append(toIndentedString(terminale)).append("\n");
        sb.append("    aziendaDest: ").append(toIndentedString(aziendaDest)).append("\n");
        sb.append("    codRisRich: ").append(toIndentedString(codRisRich)).append("\n");
        sb.append("    idServizio: ").append(toIndentedString(idServizio)).append("\n");
        sb.append("    versioneServizio: ").append(toIndentedString(versioneServizio)).append("\n");
        sb.append("    tipoLingua: ").append(toIndentedString(tipoLingua)).append("\n");
        sb.append("    SSA: ").append(toIndentedString(SSA)).append("\n");
        sb.append("    flagPaperless: ").append(toIndentedString(flagPaperless)).append("\n");
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
