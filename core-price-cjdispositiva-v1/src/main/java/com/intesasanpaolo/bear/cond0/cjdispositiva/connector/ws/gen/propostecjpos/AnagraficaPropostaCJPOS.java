//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.22 alle 11:41:45 AM CEST 
//


package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anagraficaPropostaCJPOS complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anagraficaPropostaCJPOS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dataScadenzaProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceAbiProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="annoProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceTipoOperazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codiceOggettoProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInserimentoProposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="indicatoreConcordata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="attributo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataInizioIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataFineIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="faseIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statoIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="esitoIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avviaIter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaProponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoProponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoDestinazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoCarico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataParere1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaParere1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoParere1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parere1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteParere1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataParere2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaParere2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoParere2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parere2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteParere2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataParere3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaParere3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoParere3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parere3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteParere3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataDelibera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giorniValidita" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="matricolaDelibera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoDelibera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteDelibera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataAccettazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaAccettazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoAccettazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteAccettazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataAttivazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaAttivazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoAttivazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteAttivazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteAutorizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataConferma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaConferma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoConferma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteConferma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dataRespinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="matricolaRespinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uoRespinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteRespinta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noteEmissione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flagPropostaCorporate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anagraficaPropostaCJPOS", propOrder = {
    "dataScadenzaProposta",
    "codiceAbiProposta",
    "annoProposta",
    "codiceProposta",
    "codiceTipoOperazione",
    "codiceOggettoProposta",
    "dataInserimentoProposta",
    "indicatoreConcordata",
    "attributo",
    "dataInizioIter",
    "dataFineIter",
    "faseIter",
    "statoIter",
    "esitoIter",
    "avviaIter",
    "matricolaProponente",
    "uoProponente",
    "uoDestinazione",
    "uoCarico",
    "dataParere1",
    "matricolaParere1",
    "uoParere1",
    "parere1",
    "noteParere1",
    "dataParere2",
    "matricolaParere2",
    "uoParere2",
    "parere2",
    "noteParere2",
    "dataParere3",
    "matricolaParere3",
    "uoParere3",
    "parere3",
    "noteParere3",
    "dataDelibera",
    "giorniValidita",
    "matricolaDelibera",
    "uoDelibera",
    "noteDelibera",
    "dataAccettazione",
    "matricolaAccettazione",
    "uoAccettazione",
    "noteAccettazione",
    "dataAttivazione",
    "matricolaAttivazione",
    "uoAttivazione",
    "noteAttivazione",
    "dataAutorizzazione",
    "matricolaAutorizzazione",
    "uoAutorizzazione",
    "noteAutorizzazione",
    "dataConferma",
    "matricolaConferma",
    "uoConferma",
    "noteConferma",
    "dataRespinta",
    "matricolaRespinta",
    "uoRespinta",
    "noteRespinta",
    "noteEmissione",
    "flagPropostaCorporate"
})
public class AnagraficaPropostaCJPOS {

    protected String dataScadenzaProposta;
    protected String codiceAbiProposta;
    protected String annoProposta;
    protected String codiceProposta;
    protected String codiceTipoOperazione;
    protected String codiceOggettoProposta;
    protected String dataInserimentoProposta;
    protected String indicatoreConcordata;
    protected String attributo;
    protected String dataInizioIter;
    protected String dataFineIter;
    protected String faseIter;
    protected String statoIter;
    protected String esitoIter;
    protected String avviaIter;
    protected String matricolaProponente;
    protected String uoProponente;
    protected String uoDestinazione;
    protected String uoCarico;
    protected String dataParere1;
    protected String matricolaParere1;
    protected String uoParere1;
    protected String parere1;
    protected String noteParere1;
    protected String dataParere2;
    protected String matricolaParere2;
    protected String uoParere2;
    protected String parere2;
    protected String noteParere2;
    protected String dataParere3;
    protected String matricolaParere3;
    protected String uoParere3;
    protected String parere3;
    protected String noteParere3;
    protected String dataDelibera;
    protected Integer giorniValidita;
    protected String matricolaDelibera;
    protected String uoDelibera;
    protected String noteDelibera;
    protected String dataAccettazione;
    protected String matricolaAccettazione;
    protected String uoAccettazione;
    protected String noteAccettazione;
    protected String dataAttivazione;
    protected String matricolaAttivazione;
    protected String uoAttivazione;
    protected String noteAttivazione;
    protected String dataAutorizzazione;
    protected String matricolaAutorizzazione;
    protected String uoAutorizzazione;
    protected String noteAutorizzazione;
    protected String dataConferma;
    protected String matricolaConferma;
    protected String uoConferma;
    protected String noteConferma;
    protected String dataRespinta;
    protected String matricolaRespinta;
    protected String uoRespinta;
    protected String noteRespinta;
    protected String noteEmissione;
    protected String flagPropostaCorporate;

    /**
     * Recupera il valore della proprietà dataScadenzaProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataScadenzaProposta() {
        return dataScadenzaProposta;
    }

    /**
     * Imposta il valore della proprietà dataScadenzaProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataScadenzaProposta(String value) {
        this.dataScadenzaProposta = value;
    }

    /**
     * Recupera il valore della proprietà codiceAbiProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAbiProposta() {
        return codiceAbiProposta;
    }

    /**
     * Imposta il valore della proprietà codiceAbiProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAbiProposta(String value) {
        this.codiceAbiProposta = value;
    }

    /**
     * Recupera il valore della proprietà annoProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnoProposta() {
        return annoProposta;
    }

    /**
     * Imposta il valore della proprietà annoProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnoProposta(String value) {
        this.annoProposta = value;
    }

    /**
     * Recupera il valore della proprietà codiceProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceProposta() {
        return codiceProposta;
    }

    /**
     * Imposta il valore della proprietà codiceProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceProposta(String value) {
        this.codiceProposta = value;
    }

    /**
     * Recupera il valore della proprietà codiceTipoOperazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoOperazione() {
        return codiceTipoOperazione;
    }

    /**
     * Imposta il valore della proprietà codiceTipoOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoOperazione(String value) {
        this.codiceTipoOperazione = value;
    }

    /**
     * Recupera il valore della proprietà codiceOggettoProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceOggettoProposta() {
        return codiceOggettoProposta;
    }

    /**
     * Imposta il valore della proprietà codiceOggettoProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceOggettoProposta(String value) {
        this.codiceOggettoProposta = value;
    }

    /**
     * Recupera il valore della proprietà dataInserimentoProposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInserimentoProposta() {
        return dataInserimentoProposta;
    }

    /**
     * Imposta il valore della proprietà dataInserimentoProposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInserimentoProposta(String value) {
        this.dataInserimentoProposta = value;
    }

    /**
     * Recupera il valore della proprietà indicatoreConcordata.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatoreConcordata() {
        return indicatoreConcordata;
    }

    /**
     * Imposta il valore della proprietà indicatoreConcordata.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatoreConcordata(String value) {
        this.indicatoreConcordata = value;
    }

    /**
     * Recupera il valore della proprietà attributo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributo() {
        return attributo;
    }

    /**
     * Imposta il valore della proprietà attributo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributo(String value) {
        this.attributo = value;
    }

    /**
     * Recupera il valore della proprietà dataInizioIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioIter() {
        return dataInizioIter;
    }

    /**
     * Imposta il valore della proprietà dataInizioIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioIter(String value) {
        this.dataInizioIter = value;
    }

    /**
     * Recupera il valore della proprietà dataFineIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineIter() {
        return dataFineIter;
    }

    /**
     * Imposta il valore della proprietà dataFineIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineIter(String value) {
        this.dataFineIter = value;
    }

    /**
     * Recupera il valore della proprietà faseIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaseIter() {
        return faseIter;
    }

    /**
     * Imposta il valore della proprietà faseIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaseIter(String value) {
        this.faseIter = value;
    }

    /**
     * Recupera il valore della proprietà statoIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoIter() {
        return statoIter;
    }

    /**
     * Imposta il valore della proprietà statoIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoIter(String value) {
        this.statoIter = value;
    }

    /**
     * Recupera il valore della proprietà esitoIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoIter() {
        return esitoIter;
    }

    /**
     * Imposta il valore della proprietà esitoIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoIter(String value) {
        this.esitoIter = value;
    }

    /**
     * Recupera il valore della proprietà avviaIter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvviaIter() {
        return avviaIter;
    }

    /**
     * Imposta il valore della proprietà avviaIter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvviaIter(String value) {
        this.avviaIter = value;
    }

    /**
     * Recupera il valore della proprietà matricolaProponente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaProponente() {
        return matricolaProponente;
    }

    /**
     * Imposta il valore della proprietà matricolaProponente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaProponente(String value) {
        this.matricolaProponente = value;
    }

    /**
     * Recupera il valore della proprietà uoProponente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoProponente() {
        return uoProponente;
    }

    /**
     * Imposta il valore della proprietà uoProponente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoProponente(String value) {
        this.uoProponente = value;
    }

    /**
     * Recupera il valore della proprietà uoDestinazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoDestinazione() {
        return uoDestinazione;
    }

    /**
     * Imposta il valore della proprietà uoDestinazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoDestinazione(String value) {
        this.uoDestinazione = value;
    }

    /**
     * Recupera il valore della proprietà uoCarico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoCarico() {
        return uoCarico;
    }

    /**
     * Imposta il valore della proprietà uoCarico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoCarico(String value) {
        this.uoCarico = value;
    }

    /**
     * Recupera il valore della proprietà dataParere1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataParere1() {
        return dataParere1;
    }

    /**
     * Imposta il valore della proprietà dataParere1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataParere1(String value) {
        this.dataParere1 = value;
    }

    /**
     * Recupera il valore della proprietà matricolaParere1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaParere1() {
        return matricolaParere1;
    }

    /**
     * Imposta il valore della proprietà matricolaParere1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaParere1(String value) {
        this.matricolaParere1 = value;
    }

    /**
     * Recupera il valore della proprietà uoParere1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoParere1() {
        return uoParere1;
    }

    /**
     * Imposta il valore della proprietà uoParere1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoParere1(String value) {
        this.uoParere1 = value;
    }

    /**
     * Recupera il valore della proprietà parere1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParere1() {
        return parere1;
    }

    /**
     * Imposta il valore della proprietà parere1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParere1(String value) {
        this.parere1 = value;
    }

    /**
     * Recupera il valore della proprietà noteParere1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteParere1() {
        return noteParere1;
    }

    /**
     * Imposta il valore della proprietà noteParere1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteParere1(String value) {
        this.noteParere1 = value;
    }

    /**
     * Recupera il valore della proprietà dataParere2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataParere2() {
        return dataParere2;
    }

    /**
     * Imposta il valore della proprietà dataParere2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataParere2(String value) {
        this.dataParere2 = value;
    }

    /**
     * Recupera il valore della proprietà matricolaParere2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaParere2() {
        return matricolaParere2;
    }

    /**
     * Imposta il valore della proprietà matricolaParere2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaParere2(String value) {
        this.matricolaParere2 = value;
    }

    /**
     * Recupera il valore della proprietà uoParere2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoParere2() {
        return uoParere2;
    }

    /**
     * Imposta il valore della proprietà uoParere2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoParere2(String value) {
        this.uoParere2 = value;
    }

    /**
     * Recupera il valore della proprietà parere2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParere2() {
        return parere2;
    }

    /**
     * Imposta il valore della proprietà parere2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParere2(String value) {
        this.parere2 = value;
    }

    /**
     * Recupera il valore della proprietà noteParere2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteParere2() {
        return noteParere2;
    }

    /**
     * Imposta il valore della proprietà noteParere2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteParere2(String value) {
        this.noteParere2 = value;
    }

    /**
     * Recupera il valore della proprietà dataParere3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataParere3() {
        return dataParere3;
    }

    /**
     * Imposta il valore della proprietà dataParere3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataParere3(String value) {
        this.dataParere3 = value;
    }

    /**
     * Recupera il valore della proprietà matricolaParere3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaParere3() {
        return matricolaParere3;
    }

    /**
     * Imposta il valore della proprietà matricolaParere3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaParere3(String value) {
        this.matricolaParere3 = value;
    }

    /**
     * Recupera il valore della proprietà uoParere3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoParere3() {
        return uoParere3;
    }

    /**
     * Imposta il valore della proprietà uoParere3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoParere3(String value) {
        this.uoParere3 = value;
    }

    /**
     * Recupera il valore della proprietà parere3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParere3() {
        return parere3;
    }

    /**
     * Imposta il valore della proprietà parere3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParere3(String value) {
        this.parere3 = value;
    }

    /**
     * Recupera il valore della proprietà noteParere3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteParere3() {
        return noteParere3;
    }

    /**
     * Imposta il valore della proprietà noteParere3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteParere3(String value) {
        this.noteParere3 = value;
    }

    /**
     * Recupera il valore della proprietà dataDelibera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataDelibera() {
        return dataDelibera;
    }

    /**
     * Imposta il valore della proprietà dataDelibera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataDelibera(String value) {
        this.dataDelibera = value;
    }

    /**
     * Recupera il valore della proprietà giorniValidita.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiorniValidita() {
        return giorniValidita;
    }

    /**
     * Imposta il valore della proprietà giorniValidita.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiorniValidita(Integer value) {
        this.giorniValidita = value;
    }

    /**
     * Recupera il valore della proprietà matricolaDelibera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaDelibera() {
        return matricolaDelibera;
    }

    /**
     * Imposta il valore della proprietà matricolaDelibera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaDelibera(String value) {
        this.matricolaDelibera = value;
    }

    /**
     * Recupera il valore della proprietà uoDelibera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoDelibera() {
        return uoDelibera;
    }

    /**
     * Imposta il valore della proprietà uoDelibera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoDelibera(String value) {
        this.uoDelibera = value;
    }

    /**
     * Recupera il valore della proprietà noteDelibera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteDelibera() {
        return noteDelibera;
    }

    /**
     * Imposta il valore della proprietà noteDelibera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteDelibera(String value) {
        this.noteDelibera = value;
    }

    /**
     * Recupera il valore della proprietà dataAccettazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAccettazione() {
        return dataAccettazione;
    }

    /**
     * Imposta il valore della proprietà dataAccettazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAccettazione(String value) {
        this.dataAccettazione = value;
    }

    /**
     * Recupera il valore della proprietà matricolaAccettazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaAccettazione() {
        return matricolaAccettazione;
    }

    /**
     * Imposta il valore della proprietà matricolaAccettazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaAccettazione(String value) {
        this.matricolaAccettazione = value;
    }

    /**
     * Recupera il valore della proprietà uoAccettazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoAccettazione() {
        return uoAccettazione;
    }

    /**
     * Imposta il valore della proprietà uoAccettazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoAccettazione(String value) {
        this.uoAccettazione = value;
    }

    /**
     * Recupera il valore della proprietà noteAccettazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteAccettazione() {
        return noteAccettazione;
    }

    /**
     * Imposta il valore della proprietà noteAccettazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteAccettazione(String value) {
        this.noteAccettazione = value;
    }

    /**
     * Recupera il valore della proprietà dataAttivazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAttivazione() {
        return dataAttivazione;
    }

    /**
     * Imposta il valore della proprietà dataAttivazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAttivazione(String value) {
        this.dataAttivazione = value;
    }

    /**
     * Recupera il valore della proprietà matricolaAttivazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaAttivazione() {
        return matricolaAttivazione;
    }

    /**
     * Imposta il valore della proprietà matricolaAttivazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaAttivazione(String value) {
        this.matricolaAttivazione = value;
    }

    /**
     * Recupera il valore della proprietà uoAttivazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoAttivazione() {
        return uoAttivazione;
    }

    /**
     * Imposta il valore della proprietà uoAttivazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoAttivazione(String value) {
        this.uoAttivazione = value;
    }

    /**
     * Recupera il valore della proprietà noteAttivazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteAttivazione() {
        return noteAttivazione;
    }

    /**
     * Imposta il valore della proprietà noteAttivazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteAttivazione(String value) {
        this.noteAttivazione = value;
    }

    /**
     * Recupera il valore della proprietà dataAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAutorizzazione() {
        return dataAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà dataAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAutorizzazione(String value) {
        this.dataAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà matricolaAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaAutorizzazione() {
        return matricolaAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà matricolaAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaAutorizzazione(String value) {
        this.matricolaAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà uoAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoAutorizzazione() {
        return uoAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà uoAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoAutorizzazione(String value) {
        this.uoAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà noteAutorizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteAutorizzazione() {
        return noteAutorizzazione;
    }

    /**
     * Imposta il valore della proprietà noteAutorizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteAutorizzazione(String value) {
        this.noteAutorizzazione = value;
    }

    /**
     * Recupera il valore della proprietà dataConferma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataConferma() {
        return dataConferma;
    }

    /**
     * Imposta il valore della proprietà dataConferma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataConferma(String value) {
        this.dataConferma = value;
    }

    /**
     * Recupera il valore della proprietà matricolaConferma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaConferma() {
        return matricolaConferma;
    }

    /**
     * Imposta il valore della proprietà matricolaConferma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaConferma(String value) {
        this.matricolaConferma = value;
    }

    /**
     * Recupera il valore della proprietà uoConferma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoConferma() {
        return uoConferma;
    }

    /**
     * Imposta il valore della proprietà uoConferma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoConferma(String value) {
        this.uoConferma = value;
    }

    /**
     * Recupera il valore della proprietà noteConferma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteConferma() {
        return noteConferma;
    }

    /**
     * Imposta il valore della proprietà noteConferma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteConferma(String value) {
        this.noteConferma = value;
    }

    /**
     * Recupera il valore della proprietà dataRespinta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRespinta() {
        return dataRespinta;
    }

    /**
     * Imposta il valore della proprietà dataRespinta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRespinta(String value) {
        this.dataRespinta = value;
    }

    /**
     * Recupera il valore della proprietà matricolaRespinta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricolaRespinta() {
        return matricolaRespinta;
    }

    /**
     * Imposta il valore della proprietà matricolaRespinta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricolaRespinta(String value) {
        this.matricolaRespinta = value;
    }

    /**
     * Recupera il valore della proprietà uoRespinta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUoRespinta() {
        return uoRespinta;
    }

    /**
     * Imposta il valore della proprietà uoRespinta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUoRespinta(String value) {
        this.uoRespinta = value;
    }

    /**
     * Recupera il valore della proprietà noteRespinta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteRespinta() {
        return noteRespinta;
    }

    /**
     * Imposta il valore della proprietà noteRespinta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteRespinta(String value) {
        this.noteRespinta = value;
    }

    /**
     * Recupera il valore della proprietà noteEmissione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteEmissione() {
        return noteEmissione;
    }

    /**
     * Imposta il valore della proprietà noteEmissione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteEmissione(String value) {
        this.noteEmissione = value;
    }

    /**
     * Recupera il valore della proprietà flagPropostaCorporate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagPropostaCorporate() {
        return flagPropostaCorporate;
    }

    /**
     * Imposta il valore della proprietà flagPropostaCorporate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagPropostaCorporate(String value) {
        this.flagPropostaCorporate = value;
    }

}
