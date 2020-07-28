//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:45 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per condizioneCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="condizioneCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceCondizioneAtomico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descrizioneCondizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flagCondizioneTestoLibero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indicatoreOperativita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoValore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceUDM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prezzoDiRiferimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioProposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataFineProposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceProposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indPresenzaValProp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreProposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codicePropostoPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indPresenzaValPropPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valorePropostoPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="presenzaCovenantProposto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataFineApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indPresenzaValApp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceApprovatoPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indPresenzaValAppPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreApprovatoPostDeroga" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="presenzaCovenantApprovato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataFineAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indPresenzaValAtt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="valoreAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="presenzaCovenantAttuale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceCondizioneInderogabile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoDelibera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="origine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="testoLibero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="livelloGerarchia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indCondizionePriceRange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="condizioniFiglie" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parametroCondizioneDerogaProposto" type="{http://ws.price.isp.com/proposteCJPOS/}parametroCondizioneDeroga" minOccurs="0"/&gt;
 *         &lt;element name="parametroCondizioneDerogaApprovato" type="{http://ws.price.isp.com/proposteCJPOS/}parametroCondizioneDeroga" minOccurs="0"/&gt;
 *         &lt;element name="ParametroCondizioneDerogaAttuale" type="{http://ws.price.isp.com/proposteCJPOS/}parametroCondizioneDeroga" minOccurs="0"/&gt;
 *         &lt;element name="listaDriver" type="{http://ws.price.isp.com/proposteCJPOS/}driver" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "condizioneCJPOS", propOrder = {
    "codiceCondizione",
    "codiceCondizioneAtomico",
    "descrizioneCondizione",
    "flagCondizioneTestoLibero",
    "tipoDeroga",
    "indicatoreOperativita",
    "tipoValore",
    "codiceUDM",
    "prezzoDiRiferimento",
    "dataInizioProposto",
    "dataFineProposto",
    "codiceProposto",
    "indPresenzaValProp",
    "valoreProposto",
    "codicePropostoPostDeroga",
    "indPresenzaValPropPostDeroga",
    "valorePropostoPostDeroga",
    "presenzaCovenantProposto",
    "dataInizioApprovato",
    "dataFineApprovato",
    "codiceApprovato",
    "indPresenzaValApp",
    "valoreApprovato",
    "codiceApprovatoPostDeroga",
    "indPresenzaValAppPostDeroga",
    "valoreApprovatoPostDeroga",
    "presenzaCovenantApprovato",
    "dataInizioAttuale",
    "dataFineAttuale",
    "codiceAttuale",
    "indPresenzaValAtt",
    "valoreAttuale",
    "presenzaCovenantAttuale",
    "codiceCondizioneInderogabile",
    "esitoDelibera",
    "origine",
    "testoLibero",
    "livelloGerarchia",
    "indCondizionePriceRange",
    "condizioniFiglie",
    "parametroCondizioneDerogaProposto",
    "parametroCondizioneDerogaApprovato",
    "parametroCondizioneDerogaAttuale",
    "listaDriver"
})
public class CondizioneCJPOS {

    protected String codiceCondizione;
    protected String codiceCondizioneAtomico;
    protected String descrizioneCondizione;
    protected String flagCondizioneTestoLibero;
    protected String tipoDeroga;
    protected String indicatoreOperativita;
    protected String tipoValore;
    protected String codiceUDM;
    protected String prezzoDiRiferimento;
    protected String dataInizioProposto;
    protected String dataFineProposto;
    protected String codiceProposto;
    protected String indPresenzaValProp;
    protected String valoreProposto;
    protected String codicePropostoPostDeroga;
    protected String indPresenzaValPropPostDeroga;
    protected String valorePropostoPostDeroga;
    protected String presenzaCovenantProposto;
    protected String dataInizioApprovato;
    protected String dataFineApprovato;
    protected String codiceApprovato;
    protected String indPresenzaValApp;
    protected String valoreApprovato;
    protected String codiceApprovatoPostDeroga;
    protected String indPresenzaValAppPostDeroga;
    protected String valoreApprovatoPostDeroga;
    protected String presenzaCovenantApprovato;
    protected String dataInizioAttuale;
    protected String dataFineAttuale;
    protected String codiceAttuale;
    protected String indPresenzaValAtt;
    protected String valoreAttuale;
    protected String presenzaCovenantAttuale;
    protected String codiceCondizioneInderogabile;
    protected String esitoDelibera;
    protected String origine;
    protected String testoLibero;
    protected String livelloGerarchia;
    protected String indCondizionePriceRange;
    @XmlElement(nillable = true)
    protected List<String> condizioniFiglie;
    protected ParametroCondizioneDeroga parametroCondizioneDerogaProposto;
    protected ParametroCondizioneDeroga parametroCondizioneDerogaApprovato;
    @XmlElement(name = "ParametroCondizioneDerogaAttuale")
    protected ParametroCondizioneDeroga parametroCondizioneDerogaAttuale;
    protected List<Driver> listaDriver;

    /**
     * Recupera il valore della proprietà codiceCondizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCondizione() {
        return codiceCondizione;
    }

    /**
     * Imposta il valore della proprietà codiceCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCondizione(String value) {
        this.codiceCondizione = value;
    }

    /**
     * Recupera il valore della proprietà codiceCondizioneAtomico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCondizioneAtomico() {
        return codiceCondizioneAtomico;
    }

    /**
     * Imposta il valore della proprietà codiceCondizioneAtomico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCondizioneAtomico(String value) {
        this.codiceCondizioneAtomico = value;
    }

    /**
     * Recupera il valore della proprietà descrizioneCondizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneCondizione() {
        return descrizioneCondizione;
    }

    /**
     * Imposta il valore della proprietà descrizioneCondizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneCondizione(String value) {
        this.descrizioneCondizione = value;
    }

    /**
     * Recupera il valore della proprietà flagCondizioneTestoLibero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagCondizioneTestoLibero() {
        return flagCondizioneTestoLibero;
    }

    /**
     * Imposta il valore della proprietà flagCondizioneTestoLibero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagCondizioneTestoLibero(String value) {
        this.flagCondizioneTestoLibero = value;
    }

    /**
     * Recupera il valore della proprietà tipoDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDeroga() {
        return tipoDeroga;
    }

    /**
     * Imposta il valore della proprietà tipoDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDeroga(String value) {
        this.tipoDeroga = value;
    }

    /**
     * Recupera il valore della proprietà indicatoreOperativita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatoreOperativita() {
        return indicatoreOperativita;
    }

    /**
     * Imposta il valore della proprietà indicatoreOperativita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatoreOperativita(String value) {
        this.indicatoreOperativita = value;
    }

    /**
     * Recupera il valore della proprietà tipoValore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoValore() {
        return tipoValore;
    }

    /**
     * Imposta il valore della proprietà tipoValore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoValore(String value) {
        this.tipoValore = value;
    }

    /**
     * Recupera il valore della proprietà codiceUDM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceUDM() {
        return codiceUDM;
    }

    /**
     * Imposta il valore della proprietà codiceUDM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceUDM(String value) {
        this.codiceUDM = value;
    }

    /**
     * Recupera il valore della proprietà prezzoDiRiferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrezzoDiRiferimento() {
        return prezzoDiRiferimento;
    }

    /**
     * Imposta il valore della proprietà prezzoDiRiferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrezzoDiRiferimento(String value) {
        this.prezzoDiRiferimento = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioProposto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioProposto() {
        return dataInizioProposto;
    }

    /**
     * Imposta il valore della proprietà dataInizioProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioProposto(String value) {
        this.dataInizioProposto = value;
    }

    /**
     * Recupera il valore della proprietà dataFineProposto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineProposto() {
        return dataFineProposto;
    }

    /**
     * Imposta il valore della proprietà dataFineProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineProposto(String value) {
        this.dataFineProposto = value;
    }

    /**
     * Recupera il valore della proprietà codiceProposto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProposto() {
        return codiceProposto;
    }

    /**
     * Imposta il valore della proprietà codiceProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProposto(String value) {
        this.codiceProposto = value;
    }

    /**
     * Recupera il valore della proprietà indPresenzaValProp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndPresenzaValProp() {
        return indPresenzaValProp;
    }

    /**
     * Imposta il valore della proprietà indPresenzaValProp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndPresenzaValProp(String value) {
        this.indPresenzaValProp = value;
    }

    /**
     * Recupera il valore della proprietà valoreProposto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreProposto() {
        return valoreProposto;
    }

    /**
     * Imposta il valore della proprietà valoreProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreProposto(String value) {
        this.valoreProposto = value;
    }

    /**
     * Recupera il valore della proprietà codicePropostoPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodicePropostoPostDeroga() {
        return codicePropostoPostDeroga;
    }

    /**
     * Imposta il valore della proprietà codicePropostoPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodicePropostoPostDeroga(String value) {
        this.codicePropostoPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà indPresenzaValPropPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndPresenzaValPropPostDeroga() {
        return indPresenzaValPropPostDeroga;
    }

    /**
     * Imposta il valore della proprietà indPresenzaValPropPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndPresenzaValPropPostDeroga(String value) {
        this.indPresenzaValPropPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà valorePropostoPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorePropostoPostDeroga() {
        return valorePropostoPostDeroga;
    }

    /**
     * Imposta il valore della proprietà valorePropostoPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorePropostoPostDeroga(String value) {
        this.valorePropostoPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà presenzaCovenantProposto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresenzaCovenantProposto() {
        return presenzaCovenantProposto;
    }

    /**
     * Imposta il valore della proprietà presenzaCovenantProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresenzaCovenantProposto(String value) {
        this.presenzaCovenantProposto = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioApprovato() {
        return dataInizioApprovato;
    }

    /**
     * Imposta il valore della proprietà dataInizioApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioApprovato(String value) {
        this.dataInizioApprovato = value;
    }

    /**
     * Recupera il valore della proprietà dataFineApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineApprovato() {
        return dataFineApprovato;
    }

    /**
     * Imposta il valore della proprietà dataFineApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineApprovato(String value) {
        this.dataFineApprovato = value;
    }

    /**
     * Recupera il valore della proprietà codiceApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceApprovato() {
        return codiceApprovato;
    }

    /**
     * Imposta il valore della proprietà codiceApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceApprovato(String value) {
        this.codiceApprovato = value;
    }

    /**
     * Recupera il valore della proprietà indPresenzaValApp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndPresenzaValApp() {
        return indPresenzaValApp;
    }

    /**
     * Imposta il valore della proprietà indPresenzaValApp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndPresenzaValApp(String value) {
        this.indPresenzaValApp = value;
    }

    /**
     * Recupera il valore della proprietà valoreApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreApprovato() {
        return valoreApprovato;
    }

    /**
     * Imposta il valore della proprietà valoreApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreApprovato(String value) {
        this.valoreApprovato = value;
    }

    /**
     * Recupera il valore della proprietà codiceApprovatoPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceApprovatoPostDeroga() {
        return codiceApprovatoPostDeroga;
    }

    /**
     * Imposta il valore della proprietà codiceApprovatoPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceApprovatoPostDeroga(String value) {
        this.codiceApprovatoPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà indPresenzaValAppPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndPresenzaValAppPostDeroga() {
        return indPresenzaValAppPostDeroga;
    }

    /**
     * Imposta il valore della proprietà indPresenzaValAppPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndPresenzaValAppPostDeroga(String value) {
        this.indPresenzaValAppPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà valoreApprovatoPostDeroga.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreApprovatoPostDeroga() {
        return valoreApprovatoPostDeroga;
    }

    /**
     * Imposta il valore della proprietà valoreApprovatoPostDeroga.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreApprovatoPostDeroga(String value) {
        this.valoreApprovatoPostDeroga = value;
    }

    /**
     * Recupera il valore della proprietà presenzaCovenantApprovato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresenzaCovenantApprovato() {
        return presenzaCovenantApprovato;
    }

    /**
     * Imposta il valore della proprietà presenzaCovenantApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresenzaCovenantApprovato(String value) {
        this.presenzaCovenantApprovato = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioAttuale() {
        return dataInizioAttuale;
    }

    /**
     * Imposta il valore della proprietà dataInizioAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioAttuale(String value) {
        this.dataInizioAttuale = value;
    }

    /**
     * Recupera il valore della proprietà dataFineAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineAttuale() {
        return dataFineAttuale;
    }

    /**
     * Imposta il valore della proprietà dataFineAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineAttuale(String value) {
        this.dataFineAttuale = value;
    }

    /**
     * Recupera il valore della proprietà codiceAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAttuale() {
        return codiceAttuale;
    }

    /**
     * Imposta il valore della proprietà codiceAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAttuale(String value) {
        this.codiceAttuale = value;
    }

    /**
     * Recupera il valore della proprietà indPresenzaValAtt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndPresenzaValAtt() {
        return indPresenzaValAtt;
    }

    /**
     * Imposta il valore della proprietà indPresenzaValAtt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndPresenzaValAtt(String value) {
        this.indPresenzaValAtt = value;
    }

    /**
     * Recupera il valore della proprietà valoreAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValoreAttuale() {
        return valoreAttuale;
    }

    /**
     * Imposta il valore della proprietà valoreAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValoreAttuale(String value) {
        this.valoreAttuale = value;
    }

    /**
     * Recupera il valore della proprietà presenzaCovenantAttuale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresenzaCovenantAttuale() {
        return presenzaCovenantAttuale;
    }

    /**
     * Imposta il valore della proprietà presenzaCovenantAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresenzaCovenantAttuale(String value) {
        this.presenzaCovenantAttuale = value;
    }

    /**
     * Recupera il valore della proprietà codiceCondizioneInderogabile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCondizioneInderogabile() {
        return codiceCondizioneInderogabile;
    }

    /**
     * Imposta il valore della proprietà codiceCondizioneInderogabile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCondizioneInderogabile(String value) {
        this.codiceCondizioneInderogabile = value;
    }

    /**
     * Recupera il valore della proprietà esitoDelibera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoDelibera() {
        return esitoDelibera;
    }

    /**
     * Imposta il valore della proprietà esitoDelibera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoDelibera(String value) {
        this.esitoDelibera = value;
    }

    /**
     * Recupera il valore della proprietà origine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Imposta il valore della proprietà origine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigine(String value) {
        this.origine = value;
    }

    /**
     * Recupera il valore della proprietà testoLibero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestoLibero() {
        return testoLibero;
    }

    /**
     * Imposta il valore della proprietà testoLibero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestoLibero(String value) {
        this.testoLibero = value;
    }

    /**
     * Recupera il valore della proprietà livelloGerarchia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLivelloGerarchia() {
        return livelloGerarchia;
    }

    /**
     * Imposta il valore della proprietà livelloGerarchia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLivelloGerarchia(String value) {
        this.livelloGerarchia = value;
    }

    /**
     * Recupera il valore della proprietà indCondizionePriceRange.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndCondizionePriceRange() {
        return indCondizionePriceRange;
    }

    /**
     * Imposta il valore della proprietà indCondizionePriceRange.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndCondizionePriceRange(String value) {
        this.indCondizionePriceRange = value;
    }

    /**
     * Gets the value of the condizioniFiglie property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the condizioniFiglie property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCondizioniFiglie().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCondizioniFiglie() {
        if (condizioniFiglie == null) {
            condizioniFiglie = new ArrayList<String>();
        }
        return this.condizioniFiglie;
    }

    /**
     * Recupera il valore della proprietà parametroCondizioneDerogaProposto.
     * 
     * @return
     *     possible object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public ParametroCondizioneDeroga getParametroCondizioneDerogaProposto() {
        return parametroCondizioneDerogaProposto;
    }

    /**
     * Imposta il valore della proprietà parametroCondizioneDerogaProposto.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public void setParametroCondizioneDerogaProposto(ParametroCondizioneDeroga value) {
        this.parametroCondizioneDerogaProposto = value;
    }

    /**
     * Recupera il valore della proprietà parametroCondizioneDerogaApprovato.
     * 
     * @return
     *     possible object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public ParametroCondizioneDeroga getParametroCondizioneDerogaApprovato() {
        return parametroCondizioneDerogaApprovato;
    }

    /**
     * Imposta il valore della proprietà parametroCondizioneDerogaApprovato.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public void setParametroCondizioneDerogaApprovato(ParametroCondizioneDeroga value) {
        this.parametroCondizioneDerogaApprovato = value;
    }

    /**
     * Recupera il valore della proprietà parametroCondizioneDerogaAttuale.
     * 
     * @return
     *     possible object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public ParametroCondizioneDeroga getParametroCondizioneDerogaAttuale() {
        return parametroCondizioneDerogaAttuale;
    }

    /**
     * Imposta il valore della proprietà parametroCondizioneDerogaAttuale.
     * 
     * @param value
     *     allowed object is
     *     {@link ParametroCondizioneDeroga }
     *     
     */
    public void setParametroCondizioneDerogaAttuale(ParametroCondizioneDeroga value) {
        this.parametroCondizioneDerogaAttuale = value;
    }

    /**
     * Gets the value of the listaDriver property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDriver property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDriver().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Driver }
     * 
     * 
     */
    public List<Driver> getListaDriver() {
        if (listaDriver == null) {
            listaDriver = new ArrayList<Driver>();
        }
        return this.listaDriver;
    }

}
