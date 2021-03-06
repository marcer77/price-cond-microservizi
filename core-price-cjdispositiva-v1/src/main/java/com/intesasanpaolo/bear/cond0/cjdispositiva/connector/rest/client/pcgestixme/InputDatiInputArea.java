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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ApplicationConstants.COBOL_EMPTY;

/**
 * InputDatiInputArea
 */
@Setter
public class InputDatiInputArea {

    private InputDatiInputAreaRapportoAccessorio rapportoAccessorio = null;
    private InputDatiInputAreaRapportoPrincipale rapportoPrincipale = null;
    private String codAttributo = COBOL_EMPTY;
    private String flagCM = COBOL_EMPTY;
    private String tipoServizio = COBOL_EMPTY;
    private String codFilDipendente = COBOL_EMPTY;
    private String dataRiferimento = COBOL_EMPTY;
    private String origineChiamante = COBOL_EMPTY;
    private String codPromozione = COBOL_EMPTY;
    private String dataScadenza = COBOL_EMPTY;
    private String tipoDA = COBOL_EMPTY;
    private String codConvenzione = COBOL_EMPTY;
    private String codProdotto = COBOL_EMPTY;
    private String flagCartaDC = COBOL_EMPTY;
    private String codCondizione = COBOL_EMPTY;
    private String utente = COBOL_EMPTY;
    private String flagEntrata = COBOL_EMPTY;
    private String codCanale = COBOL_EMPTY;
    private String cfPiva = COBOL_EMPTY;
    private String numPromozioni = COBOL_EMPTY;
    private List<InputDatiInputAreaArrayPromo> arrayPromo = null;
    private InputDatiInputAreaY1CXCHSP y1CXCHSP = null;

    @JsonProperty("RapportoAccessorio")
    public InputDatiInputAreaRapportoAccessorio getRapportoAccessorio() {
        return rapportoAccessorio;
    }

    @JsonProperty("RapportoPrincipale")
    public InputDatiInputAreaRapportoPrincipale getRapportoPrincipale() {
        return rapportoPrincipale;
    }

    @JsonProperty("CodAttributo")
    public String getCodAttributo() {
        return codAttributo;
    }

    @JsonProperty("FlagCM")
    public String getFlagCM() {
        return flagCM;
    }

    @JsonProperty("TipoServizio")
    public String getTipoServizio() {
        return tipoServizio;
    }

    @JsonProperty("CodFilDipendente")
    public String getCodFilDipendente() {
        return codFilDipendente;
    }

    @JsonProperty("DataRiferimento")
    public String getDataRiferimento() {
        return dataRiferimento;
    }

    @JsonProperty("OrigineChiamante")
    public String getOrigineChiamante() {
        return origineChiamante;
    }

    @JsonProperty("CodPromozione")
    public String getCodPromozione() {
        return codPromozione;
    }

    @JsonProperty("DataScadenza")
    public String getDataScadenza() {
        return dataScadenza;
    }

    @JsonProperty("TipoDA")
    public String getTipoDA() {
        return tipoDA;
    }

    @JsonProperty("CodConvenzione")
    public String getCodConvenzione() {
        return codConvenzione;
    }

    @JsonProperty("CodProdotto")
    public String getCodProdotto() {
        return codProdotto;
    }

    @JsonProperty("FlagCartaDC")
    public String getFlagCartaDC() {
        return flagCartaDC;
    }

    @JsonProperty("CodCondizione")
    public String getCodCondizione() {
        return codCondizione;
    }

    @JsonProperty("Utente")
    public String getUtente() {
        return utente;
    }

    @JsonProperty("FlagEntrata")
    public String getFlagEntrata() {
        return flagEntrata;
    }

    @JsonProperty("CodCanale")
    public String getCodCanale() {
        return codCanale;
    }

    @JsonProperty("CFPiva")
    public String getCfPiva() {
        return cfPiva;
    }

    @JsonProperty("NumPromozioni")
    public String getNumPromozioni() {
        return numPromozioni;
    }

    public void addArrayPromoItem(InputDatiInputAreaArrayPromo arrayPromoItem) {
        getArrayPromo().add(arrayPromoItem);
    }

    @JsonProperty("ArrayPromo")
    public List<InputDatiInputAreaArrayPromo> getArrayPromo() {
        if (arrayPromo == null) {
            arrayPromo = new ArrayList<>();
        }
        return arrayPromo;
    }

    public void setArrayPromo(List<InputDatiInputAreaArrayPromo> arrayPromo) {
        this.arrayPromo = arrayPromo;
    }

    @JsonProperty("Y1CXCHSP")
    public InputDatiInputAreaY1CXCHSP getY1CXCHSP() {
        return y1CXCHSP;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InputDatiInputArea inputDatiInputArea = (InputDatiInputArea) o;
        return Objects.equals(rapportoAccessorio, inputDatiInputArea.rapportoAccessorio) &&
                Objects.equals(rapportoPrincipale, inputDatiInputArea.rapportoPrincipale) &&
                Objects.equals(codAttributo, inputDatiInputArea.codAttributo) &&
                Objects.equals(flagCM, inputDatiInputArea.flagCM) &&
                Objects.equals(tipoServizio, inputDatiInputArea.tipoServizio) &&
                Objects.equals(codFilDipendente, inputDatiInputArea.codFilDipendente) &&
                Objects.equals(dataRiferimento, inputDatiInputArea.dataRiferimento) &&
                Objects.equals(origineChiamante, inputDatiInputArea.origineChiamante) &&
                Objects.equals(codPromozione, inputDatiInputArea.codPromozione) &&
                Objects.equals(dataScadenza, inputDatiInputArea.dataScadenza) &&
                Objects.equals(tipoDA, inputDatiInputArea.tipoDA) &&
                Objects.equals(codConvenzione, inputDatiInputArea.codConvenzione) &&
                Objects.equals(codProdotto, inputDatiInputArea.codProdotto) &&
                Objects.equals(flagCartaDC, inputDatiInputArea.flagCartaDC) &&
                Objects.equals(codCondizione, inputDatiInputArea.codCondizione) &&
                Objects.equals(utente, inputDatiInputArea.utente) &&
                Objects.equals(flagEntrata, inputDatiInputArea.flagEntrata) &&
                Objects.equals(codCanale, inputDatiInputArea.codCanale) &&
                Objects.equals(cfPiva, inputDatiInputArea.cfPiva) &&
                Objects.equals(numPromozioni, inputDatiInputArea.numPromozioni) &&
                Objects.equals(arrayPromo, inputDatiInputArea.arrayPromo) &&
                Objects.equals(y1CXCHSP, inputDatiInputArea.y1CXCHSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rapportoAccessorio, rapportoPrincipale, codAttributo, flagCM, tipoServizio, codFilDipendente, dataRiferimento, origineChiamante, codPromozione, dataScadenza, tipoDA, codConvenzione, codProdotto, flagCartaDC, codCondizione, utente, flagEntrata, codCanale, cfPiva, numPromozioni, arrayPromo, y1CXCHSP);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InputDatiInputArea {\n");

        sb.append("    rapportoAccessorio: ").append(toIndentedString(rapportoAccessorio)).append("\n");
        sb.append("    rapportoPrincipale: ").append(toIndentedString(rapportoPrincipale)).append("\n");
        sb.append("    codAttributo: ").append(toIndentedString(codAttributo)).append("\n");
        sb.append("    flagCM: ").append(toIndentedString(flagCM)).append("\n");
        sb.append("    tipoServizio: ").append(toIndentedString(tipoServizio)).append("\n");
        sb.append("    codFilDipendente: ").append(toIndentedString(codFilDipendente)).append("\n");
        sb.append("    dataRiferimento: ").append(toIndentedString(dataRiferimento)).append("\n");
        sb.append("    origineChiamante: ").append(toIndentedString(origineChiamante)).append("\n");
        sb.append("    codPromozione: ").append(toIndentedString(codPromozione)).append("\n");
        sb.append("    dataScadenza: ").append(toIndentedString(dataScadenza)).append("\n");
        sb.append("    tipoDA: ").append(toIndentedString(tipoDA)).append("\n");
        sb.append("    codConvenzione: ").append(toIndentedString(codConvenzione)).append("\n");
        sb.append("    codProdotto: ").append(toIndentedString(codProdotto)).append("\n");
        sb.append("    flagCartaDC: ").append(toIndentedString(flagCartaDC)).append("\n");
        sb.append("    codCondizione: ").append(toIndentedString(codCondizione)).append("\n");
        sb.append("    utente: ").append(toIndentedString(utente)).append("\n");
        sb.append("    flagEntrata: ").append(toIndentedString(flagEntrata)).append("\n");
        sb.append("    codCanale: ").append(toIndentedString(codCanale)).append("\n");
        sb.append("    cfPiva: ").append(toIndentedString(cfPiva)).append("\n");
        sb.append("    numPromozioni: ").append(toIndentedString(numPromozioni)).append("\n");
        sb.append("    arrayPromo: ").append(toIndentedString(arrayPromo)).append("\n");
        sb.append("    y1CXCHSP: ").append(toIndentedString(y1CXCHSP)).append("\n");
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
