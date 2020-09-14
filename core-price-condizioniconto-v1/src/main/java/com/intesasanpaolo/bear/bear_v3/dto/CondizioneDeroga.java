package com.intesasanpaolo.bear.bear_v3.dto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.intesasanpaolo.bear.bear_v3.dto.utils.Format;
import com.intesasanpaolo.bear.bear_v3.dto.utils.Number;
import com.intesasanpaolo.bear.bear_v3.dto.utils.StrUtils;

/**
 * Oggetto che rappresenta una CONDIZIONE Se è regime memorizza la lista di: -
 * condizioni controllate con valore regime iniziale (quelle che restitutisce
 * host alla prima richiesta della condizioni, quindi prima che venga cachata)
 * Tale lista deve essere utilizzata per visualizzare le controllate utilizzando
 * l'albero/ricerca condizioni - condizioni controllate con valore regime scelto
 * dall'utente (in fase di proposta l'utente puà scegliere dinamicamente il
 * valore del regime, a seconda di questo verranno abbinate al regime le
 * condizioni controllate)
 */
public class CondizioneDeroga implements java.io.Serializable {

	private static Log log = LogFactory.getLog(CondizioneDeroga.class);
	private static final long serialVersionUID = 8628004252497935060L;

	public static String getCodNoVariazione() {
		return COD_NO_VARIAZIONE;
	}
	public static String getCodOrigDerogaConvenzione() {
		return COD_ORIG_DEROGA_CONVENZIONE;
	}
	public static String getCodOrigDerogaConvenzioneParametrata() {
		return COD_ORIG_DEROGA_CONVENZIONE_PARAMETRATA;
	}
	public static String getCodOrigDerogaConvenzioneServizio() {
		return COD_ORIG_DEROGA_CONVENZIONE_SERVIZIO;
	}
	public static String getCodOrigDerogaConvenzioneServizioParametrata() {
		return COD_ORIG_DEROGA_CONVENZIONE_SERVIZIO_PARAMETRATA;
	}
	public static String getCodOrigDerogaGruppo() {
		return COD_ORIG_DEROGA_GRUPPO;
	}
	public static String getCodOrigDerogaGruppoParametrata() {
		return COD_ORIG_DEROGA_GRUPPO_PARAMETRATA;
	}
	public static String getCodOrigDerogaRapporto() {
		return COD_ORIG_DEROGA_RAPPORTO;
	}
	public static String getCodOrigDerogaRapportoParametrata() {
		return COD_ORIG_DEROGA_RAPPORTO_PARAMETRATA;
	}
	public static String getCodOrigDerogaSchedario() {
		return COD_ORIG_DEROGA_SCHEDARIO;
	}
	public static String getCodOrigStandardIstituto() {
		return COD_ORIG_STANDARD_ISTITUTO;
	}
	public static String getCodOrigStandardIstitutoParametrato() {
		return COD_ORIG_STANDARD_ISTITUTO_PARAMETRATO;
	}
	public static String getCodVariazioneCond() {
		return COD_VARIAZIONE_COND;
	}
	public static String getCodVariazioneParametro() {
		return COD_VARIAZIONE_PARAMETRO;
	}
	public static String getCodVariazionePercent() {
		return COD_VARIAZIONE_PERCENT;
	}
	public static String getCodVariazionePercentSpread() {
		return COD_VARIAZIONE_PERCENT_SPREAD;
	}
	public static String getCodVariazioneSpread() {
		return COD_VARIAZIONE_SPREAD;
	}
	public static Log getLog() {
		return log;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setLog(Log log) {
		CondizioneDeroga.log = log;
	}
	// Campi per progetto covenant su BDR, impostati a livello di anagrafica
	// sottogruppo
	private boolean spreadBDR = false;
	private double importoBDR_Da;
	private double importoBDR_A;
	private String dataScadenzaBDR_Da = "";
	private String dataScadenzaBDR_A = "";
	//private ArrayList<Opzione> listaDurateAmmesseBDR = new ArrayList<Opzione>();
	private double valoreCondizioneFLOOR;
	private double valoreCondizioneCAP;
	private int durataBDR_Selezionata = 0; // Campo Host PCP0-O-DURATA-IN-GG
											// Num05 "BdR - Durata in giorni"
	private String dataScadenzaBDR_Selezionata = ""; // Campo Host
														// PCP0-O-DECA-BDR
														// Char08 "Data scadenza
														// BdR (formato
														// ssaammgg)"
	private boolean indTITmanualeBDR = false; // Campo Host
												// PCP0-O-IND-TIT-MANUALE Char01
												// "Indicatore TIT manuale"
	private boolean penaleEstinzioneAzzerataBDR = false;
	private String indVersoMigliorativoTassoCreditoreBDR = "-"; // I valori
																// calcolati di
																// TIT, ADJ,
																// MRK, Tasso
																// Cliente,
																// devono
																// rappresentare
																// una
																// simulazione,
																// per lo spread
																// impostato, di
																// quel che sarà
																// il
	private String descUnitaMisuraTassoCreditoreBDR = "%"; // tasso applicato al
															// cliente sulla
															// condizione 00001.
															// Perciò devono
															// usare le logiche
															// previste dal
															// verso
															// migliorativo e
															// UDM della 00001.
	// (In futuro il recupero di tali valori potrà essere reso dinamico da
	// anagrafica)
	// COVENANTS
	private String codiceTipoCovenantAttuale = ""; // E se in estinzione
//	private ArrayList<Covenant> covenants = new ArrayList<Covenant>();
//	private Covenant covenantSelezionato;
//	private Covenant covenantProposto;
//	private Covenant covenantAttuale;
//	private Covenant covenantAllaData;
//	private BeneficioInEssere beneficioInEssereCovenant;
	private int idCovenantInEstinzione = 0;
	private boolean dataDecorrenzaForzataOggiPerEstinzione = false;
	private boolean dataDecoForzataOggiPerEstinzioneAntergazione = false;
	private boolean dataDecoForzataOggiPerEstinzioneBeneficio = false;
	private boolean prevedeCovenants = false;

	private boolean presenteCovenantAllaData = false;
	private boolean presenteCovenantAttuale = false;
	private boolean presenteCovenantProposto = false;
	private boolean presenteCovenantApprovato = false;
	private boolean presenteCovenantNonVendibile = false;
	private boolean presenteCovenantNonEstinguibile = false;
	private boolean flagCovenantMacroGruppo = false;
	private String flagCovenantSottogruppo = "N";

	private String flagCovenantCondizione = "N";
	//private Opzione derogaConsentitaPresenzaCovenant;
	private boolean presenteModifcaFinessMLT = false;
	private String flagPrevedePersonalizzatoConsigliato = "A";
	private String notaCovenant = "";
	private String descTipoCondizione = "";
	private int famigliaCond = 0;
	private String CD_CONDIZIONE_MACROGRUPPO = "";

	private String CD_CONDIZIONE_SOTTOGRUPPO = "";
	private String DS_CONDIZIONE_MACROGRUPPO = "";
	private String DS_CONDIZIONE_SOTTOGRUPPO = "";
	private boolean cambioTrimestreBaseline = false;
	// DRIVER
	private String VALORE_DRIVER = "";
	private String VALORE_SECONDO_DRIVER = "";
	private String CD_SECONDO_DRIVER_TIPO = "";
	private String DS_SECONDO_DRIVER = "";
	private String CD_SECONDO_DRIVER_UDM = "";
	private String PERC_NEW_OPER = "0";
	private String CONV_ALTRI_PRD = "0";

	private String REMUN_PRD_CONV = "0";
	public static final String COD_NO_VARIAZIONE = "0";
	public static final String COD_VARIAZIONE_COND = "1";
	public static final String COD_VARIAZIONE_PARAMETRO = "3";
	public static final String COD_VARIAZIONE_PERCENT = "5";
	public static final String COD_VARIAZIONE_SPREAD = "6";

	public static final String COD_VARIAZIONE_PERCENT_SPREAD = "7";
	public static final String COD_UDM_CODICE = "3";
	public static final String COD_MACROGRUPPO_CDF = "8";
	/* codice origine */
	public static final String COD_ORIG_STANDARD_ISTITUTO = "I";
	public static final String COD_ORIG_STANDARD_ISTITUTO_PARAMETRATO = "IPAR";
	public static final String COD_ORIG_DEROGA_SCHEDARIO = "SG";

	public static final String COD_ORIG_DEROGA_RAPPORTO = "R";
	public static final String COD_ORIG_DEROGA_RAPPORTO_PARAMETRATA = "RPAR";
	public static final String COD_ORIG_DEROGA_CONVENZIONE_SERVIZIO = "CS";

	public static final String COD_ORIG_DEROGA_CONVENZIONE_SERVIZIO_PARAMETRATA = "CSPAR";
	public static final String COD_ORIG_DEROGA_CONVENZIONE = "RCN";
	public static final String COD_ORIG_DEROGA_CONVENZIONE_PARAMETRATA = "RCPAR";
	public static final String COD_ORIG_DEROGA_GRUPPO = "RGC";
	public static final String COD_ORIG_DEROGA_GRUPPO_PARAMETRATA = "RGPAR";
	private String TIPO_OPERAZIONE = "";
	private String TIPO_OPERAZIONE_PCV = ""; // gestione tipo operazione per il
												// post conv.
	private String descOrigineCondizAttuale = "";
	private String descOrigineCondizAttualeShort = "";
	private String descCodiceAttuale = "";
	private String tipoValoreFromDecoder = "";
	private Condizione condizione = new Condizione("", "");
	private String codiceCondizione = null;
	private String codiceSottocondizione = null;
	private String tipoValore = "";
	private String descCondizione = "";
	private String descCondizioneVis = "";
	private String flagBlindatura = "";
	private String codiceCondizioneInderogabile = "";
	private int livelloApplicativo = 0;
	private String codDivisa = "";
	private String unitaMisura = "";
	private String descUnitaMisura = "";
	private String codOrigineCondizAttuale = "";
	private String tipoEntitaAdesione = "";
	private String valNumericoAttuale = "";
	private String segnoValNumericoAttuale = "+";
	private String valCodiceAttuale = "";

	private String valoreTestoAttuale = "";
	private String valoreTestoProposto = "";
	private String descrizioneValoreProposto = "";

	private String formulaAttuale = "";
	private String dataDecorrenzaAttuale = "";
	private String dataScadenzaAttuale = "";

	// JBilling
	private String codiceProdottoJBilling = "";
	private String descrizioneProdottoJBilling = "";
	private String progressivoJBilling = "";
	private String soggettaARegolaDiBilling = "N";
	private String codiceScenario = "";
	private String billingAccount = "";

	private String stringaFacolta = "";
	private String stringaFacoltaParametrata = "";
	private String facoltaUoSup = "";
	private String facoltaUoSupParametrata = "";
	private String descFacoltaUoSup = "";
	// indicatore controllo facolta'
	public String indControlloFacolta = "S";
	private String segnoValNumericoProposto = "+";
	private String valNumericoProposto = "";
	private String valCodiceProposto = "";
	private String dataDecorrenzaProposta = "";
	private String dataScadenzaProposta = "";
	/*
	 * per la gestione del tooltip sulle condizioni controllate di I livello per
	 * i regimi IF++ in proposta
	 */
	private String descAggValCodice = "";
	/*
	 * per la gestione del tooltip sulle condizioni controllate di I livello per
	 * i regimi IF++ in inquiry
	 */
	private String descAggValCodice2 = "";
	/* per nuova lettera Bersani */
	private String valParametro = "";
	private String valParametroSegno = "";
	private String valorePostConvDesc = ""; // preso da PCN6
	private boolean presenzaFasceAllaData;
	private String codiceFasciaConvenzione = "";
	private String dataRilevazione = "";

	private String driver1RilevatoDesc = "";

	private String driver2RilevatoDesc = "";

	private boolean parametrata = false;
	private boolean regime = false;
	private boolean tassoPlus = false; // attributo della condizione regime se
										// si è selezionato un parametro che
										// attiva la gestione tassi plus
	private boolean regimeIsTassoPlus = false; // attributo della condizione
												// CONTROLLATA se si è
												// selezionato un parametro
												// sulla REGIME che attiva la
												// gestione tassi plus
	private boolean controllateParametrate = false;
	private boolean controllata = false;
	private boolean primaControllata = false;
	private boolean controllataScaglione = false;
	private boolean controllataTasso = false;
	private boolean controllataCommissione = false;

	private boolean controllataForfait = false;
	private String tipoControllata = "";
	private boolean selezionabile = true;
	private String listaTipiPropostaNonSelezionabile = "";
	private String azione = "I"; // di default Inserimento

	private boolean regimeSconto = false;
	private String codiceRegimeSconto = "";
	private boolean assoggettataARegimeSconto = false;

	private String abiProvenienza = "";

	// se valorizzato indica il valore che non può essere utilizzato in fase di
	// emissione proposta (es. regime con vecchio valore non piu utilizzato, 0 -
	// 0S)
	private String valoreNonPiuProponibile = "";

	private ArrayList<CondizioneDeroga> listaControllate;

	// Tale lista deve essere utilizzata per visualizzare le controllate
	// utilizzando l'albero/ricerca condizioni
	private ArrayList listaControllateDefault;

	// condizioni controllate con valore regime scelto dall'utente (in fase di
	// proposta)
	private ArrayList listaControllateInCompilaProposta;

	/*
	 * Attributi di integrazione che riguardano i vincoli per la compilazione
	 * della proposta. Vengono settati in CompilaPropostaCommand
	 */

	// lista delle condizioni Correlate alla condizione in questione
	private ArrayList listaCorrelate;
	private ArrayList listaCorrelateFull;
	// Codice della condizione padre (se la condizione è una correlata)
	private String codCorrelataPadre = "";
	// lista delle condizioni Incompatibili alla condizione in questione
	private ArrayList listaIncompatibili;
	private Hashtable hashControllateGerarchia;
	private Hashtable hashControllateDefault;
	private Hashtable hashControllateInCompilaProposta;
	// lista dei codici delle sottocondizioni associate ad una condizione padre
	// (che ha sottocondizione 000)
	private ArrayList listaCodSottocondizioni;
	private int numSottocondizioni = 0;
	private ArrayList elencoSottocondizioni = new ArrayList();
	private boolean sottocondizione = false;
	private String descCodiceAttualeSottocondizione_SHORT = "";

	// flag di visualizzazione della checkbox per proposta Normale e Parametrata
	private boolean viewProposalCheckbox = false;

	private boolean viewParametrataProposalCheckbox = false;

	// flag di proponibilita della condizione
	private boolean parametrabile = true;
	// indica se unca condizione può essere scollegata da una proposta normale
	private boolean scollegabileDaPropostaNormale = false;

	// indica se unca condizione può essere solamente scollegata da una proposta
	// normale
	private boolean soloScollegabileDaPropostaNormale = false;
	// indica se una condizione parametrata deve essere gestita in compila
	// proposta come fosse una condizione normale (scollegamento attivo, etc..)
	private boolean parametrataConGestioneNormaleInCompilazione = false;
	// flag che indica che la condizione è in delibera o meno (utilizzato in
	// fase di ripristino proposta =>
	// => se sono in RipristinaProposta e la cond. è in delibera => non posso
	// eliminare la condizione)
	private boolean faseNonEmissioneInRipristinaProposta = false;

	// flag di selezione della condizione (valido solo per le condizioni non
	// controllate, per le controllate se il regime è selezionate vengono prese
	// in considerazione)
	private boolean checked = false;
	private String valoreMassimo = "";
	private String valoreMinimo = "";

	private String formatoCifreIntere = "";
	private String formatoCifreDecimali = "";

	private String minDataDeco = "";
	private String maxDataDeco = "";
	private String indVersoMigliorativo = "";
	private ArrayList valoriDescrizioniCodice = new ArrayList();// ArrayList di
																// Opzione (per
																// valorizzare
																// la select in
																// caso di
																// tipoValore=3
	private String indValore = ""; // indica se il valore della condizione può
									// essere modificato o meno
	private boolean peggiorativa = false;
	// memorizza il valore del flag perggiorativa per discriminare la tipologia
	// di Bersani da stampare: flag=C stampa bersani per CDF anche per proposte
	// migliorative
	private String flagPeggiorativa = "";
	/*
	 * AGGIUNTO IN DATA 6/07/2006 PER LA GESTIONE DELLE CONDIIZONI DI TIPO H v.
	 * tab T_PC2_COND_VOCE
	 */
	private String tipoCondizione = "";
	/*
	 * AGGIUNTO IN DATA 22/02/2016 PER LA GESTIONE DELLE CONDIIZONI REGIME CON
	 * TASSO NEGATIVO tab T_PC2_COND_REGIME
	 */
	// TODO TASSINEG2016
	private String tipoCondizioneAttMst = "";
	private boolean scollegamentoAttrGKCondH = false;
	/*
	 * 08/09/2006 L.De Rossi se true indica che la condizione può essere
	 * selezionata e portata in una proposta da sola (non assieme ad altre
	 * condizioni) monoderogaDb: valore proveniente dal DB =>
	 * T_PC2_ANAG_CONDIZIONI.IND_MONODEROGA monoderogaHost: valore proveniente
	 * da Host
	 */
	private boolean unicaSelezionabileDb = false;

	private boolean unicaSelezionabileHost = false;
	/* se la condizione ammette la proposta parametrata ... */
//	private ParametriCondizioneDeroga parametriCondizioneDeroga = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
//	private ParametriCondizioneDeroga parametriCondizioneDerogaApprovati = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
//
//	private ParametriCondizioneDeroga parametriCondizioneDerogaAttuali = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
	/* Per le segnalazioni host */
	private String esitoCondizione = "";

	private String messaggioCondizione = "";
	private String autonomia = "";
	private String tipoDeroga = ""; // Vale "N" o "P". Per Normale o
									// Parametrata. (Permette di poter
									// discrminare il tipo di condizione
									// all'interno del tipo di proposta).

	private boolean provenienzaDaHost = false;
	/* AGGIUNTE PER GESTIONE DELLA COMPILA PROPOSTA PER GRUPPI DI GIACENZA */
	private String dataDecorrenzaApprovata = "";

	private String dataScadenzaApprovata = "";
	private String segnoValNumericoApprovato = "+";
	private String valNumericoApprovato = "";

	private String valCodiceApprovato = "";

	private String descCodiceApprovato = "";
	private String formulaApprovata = "";
	private String formulaProposta = "";

	private String messaggioErrore = "";

	private String condizioneErrore = "";
	private String codiceErrore = "";
	/*
	 * AGGIUNTE PER LA GESTIONE DELLA SIMULAZIONE DI UN'ADESIONE A CONVENZIONE
	 */
	private String condRaggruppamento = "";
	private String indicatoreRegime = "";
	private String flagCoerenza = "";
	//PartitaPortafoglio datiPartitaPortafoglio = new PartitaPortafoglio(); // contiene
																			// informazioni
																			// specifiche
																			// per
																			// la
																			// proposta
																			// con
																			// oggetto
																			// (12)
																			// partite
																			// di
																			// portafoglio

	private boolean isPresenteValorePostConv = false;

	private String valNumericoPostConvProposto = "";
	private String valCodicePostConvProposto = "";
	private String descCodicePostConvProposto = "";
//	private ParametriCondizioneDeroga parametriPostConvenzione = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
//
//	private ParametriCondizioneDeroga parametriCondizioneDerogaPostConvProposti = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
	private String valNumericoPostConvApprovato = "";
	private String valCodicePostConvApprovato = "";
	private String descCodicePostConvApprovato = "";

//	private ParametriCondizioneDeroga parametriCondizioneDerogaPostConvApprovati = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");
	private String formulaPostConvenzione = "";
	private String formulaPropostaPostConvenzione = "";

	private String formulaApprovataPostConvenzione = "";
	// GESTIONE CONDIZIONE Q_POS
	private String gestioneDatePos = "";
	// modifica DO 08/10/2007
	private String tipologiaAggregazione = "";
	private int pesoLivelloDeroga = 0;
	private String codAggregOriginAtt = "";
	// campi descrittivi
	private String descPesoLivelloDeroga = "";
	private String descCodAggregOriginAtt = "";

	private String tipoCodAggregOriginAtt = "";

	// 18/06/2008 gestione blindatura se una figlia eredita una condizione
	// blindata da una madre la condizione non può + essere selezionata per una
	// deroga su convenzione
	boolean isBlindaturaNonDerogabileSuConvenzione = false;
	// gestione condizione SWITCH e controllate
	boolean condizioneSWITCH = false;
	boolean controllataCondizioneSWITCH = false;

	boolean condizioneTipoCliente = false;
	boolean blindaturaSWITCHNonDerogata = false;

	// ottimizzazione deroghe TQM campi aggiuntivi
	//private InfoSelezionabilitaScollegabilita infoSelezionabilitaScollegabilita = new InfoSelezionabilitaScollegabilita();
	private String codCondIncompatibili = "";

	private String strControllate = "";
	private String strOrigineControllate = "";

	private String codiceIdentificativo = "";
	private String codiceProvenienza = "";
	private String codiceProvenienzaDesc = "";
	// campi per condizioni di tipo canone per conto modulare
	private String tipoRendicontazione = "";

	private String desTipoRendicontazione = "";
	private String composizioneDA = "";
	private String desComposizioneDA = "";
	private String codiceRegime = "";
	private String strCorrelate = "";
	private boolean correlata = false;
	private boolean vincoliValorizzati = false;

	private String indScadenzaObbligatoria = "N";
	private String minScadenzaObbligatoria = "";
	private String maxScadenzaObbligatoria = "";

	private int minMesiScadenzaObbligatoria = 0;
	private int maxMesiScadenzaObbligatoria = 0;

	private String indStampaBersani = "N";
	private String indStampaPresenteCovenant = "N";
	private String codVariazione = "0";
	private String numOrdine = "";
	private String valoreDerogaPrevistoPerControllata = "N";
	private String macroGruppo = "";

	private String sottoGruppo = "";

	private String descMacroGruppo = "";
	private String descSottoGruppo = "";
	private String indPresenzaStandard = "N";
	private String segnoValoreStandard = "+";

	private String valNumericoStandard = "";
	private String valCodiceStandard = "";
	private String descCodiceStandard = "";
	private String dataDecorrenzaStandard = "";
	private String dataScadenzaStandard = "";
	private String indPresenzaValoreTrimestrePrec = "N";
	private String valoreTrimestrePrec = "";
	private String segnoValoreTrimestrePrec = "+";
	private boolean condizioneGestionePrivateTop = false;

	private String indControlloCrescenza = "N";
	private boolean eva = false;

	private String segnoEva = "+";
	private String valoreEva = "";
	private String presenzaEva = "N";
	private String prevedeEva = "N";
	private String indCondizioneTassoSpread = "ND";
	private String formulaStandard = "";

	private String valoreTestoStandard = "";

	private String facoltaApice = "N";

	private String tipoOperazioneObbligatoria = "";
	// Campi per deroga su Promozione da TdR
	private String tipoCondizionePromo = "";

	private String descTipoCondizionePromo = "";

	private String codListino = "";
	private String desListino = "";

	private String segnoBeneficio = "+";

	private ArrayList listini;

	private String visibilitaAbc = "S";
	private boolean condizionePriceLab = false;
	private boolean derogaObbligata = false; // forza la selezione e la deroga
												// in proposta
	private String flagBdrInPerdita = "N";
	private String flagPilotaBdrInPerdita = "N";
	// dati Prange
	private Long idPraticaPrange = new Long(0);
	private Long idLineaPrange = new Long(0);
	private Long idScenarioPrange = new Long(0);
	private String idCondizionePrange = "";

	private String formaTecnicaPrangeHost = "                    ";

	private String valuePrangeHost = "";

	// private FasceSuConvenzione fasceSuConvenzioneProposto = new
	// FasceSuConvenzione();
	//private FasceSuConvenzione fasceSuConvenzioneProposto = null;
	private boolean presentiFasceSuConvenzioneProposto = false;
	// private FasceSuConvenzione fasceSuConvenzioneApprovato = new
	// FasceSuConvenzione();
	//private FasceSuConvenzione fasceSuConvenzioneApprovato = null;

	private boolean presentiFasceSuConvenzioneApprovato = false;

	private boolean presenteCovenant = false;

	private boolean popupPerConvenzioneModificato = false;
	private boolean popupFasceModificatoInIter = false;
	// 21/9/15 aggiunto per allineamento con PCEE
	private String flagDisabilitaMonitoraggio = "";
	// CAMPO AGGIUNTO 18/11/2015 PER MIGLIORIE PRICE - STORICO CONDIZIONI
	// (U.SARTORE)
	private String provenienza = "";
	// indicatore Correlata
	private String indTipoCorr = "";
	private String pacchettoCorr = "";
	private String pacchettoCorrTecniche = "";
	private String strCorrelateTecniche = "";
	private String strCorrelateCompatibilita = "";
	private String strCorrelateFull = "";
	private String strCorrelateLight = "";
	private String strCorrelateAll = "";
	private String indCapoFila = "";
	private String indCapoFilaTecnica = "";
	// NUOVO CAMPO PER MIGLIORIE PRICE 28/18/15
	protected String flagObbligatoriaMlt = "";
	// EVACORP2016
	private boolean flagEvaNonObbligatorio = false;
	private int numeroFasciaConvenzione = 1;
	private String fasceJSON = "";
	private boolean riferimentoSalvadanio = false;
	// flag esclusione stampa condizione vecchia Bersani
	private String indEsclVecchiaBersani = "N";
	private String valTassoCreditorePerSalvadanaio = ""; // il valore tasso
															// creditore del
															// conto padre
	// GERARCHIA
	private String livelloGerarchia = "0"; // 0 (default), 1 (I livello "mamma")
											// , 2 (II livello "figlia") , R
											// (regola)

	private String strCondizioniGerarchia = "";
	private ArrayList<Condizione> listaCondizioniOutGER = new ArrayList<Condizione>();
	private String condizionePrimoLivelloGerarchia = "";
	private String strControllatePrimoLivelloGerarchia = "";
	private String strControllateGerarchia = "";
	private String condizioneRegolaGerarchia = "";
	private String dataPubblicazioneGerarchia = "";
	private String valoreRegolaGerarchia = "F";

	private String strValoreAttualeCondizioniGerarchia = "";

	private String statoGerarchia = "";

	private String valNumericoAttualeGerarchia = "";

	private String segnoValoreAttualeGerarchia = "+";

	private String valNumericoStandardGerarchia = "";

	private String segnoValoreStandardGerarchia = "+";

	private String codiceValoreStandardGerarchia = "";

	private String descCodiceValoreStandardGerarchia = "";

	private String codiceValoreAttualeGerarchia = "";

	private String descCodiceValoreAttualeGerarchia = "";
	private String strCorrelateGR = "";
	//private Opzione derogaConsentitaPresenzaCovenantGerarchiaFiglie;

	// moltiplicatori
	private boolean PresenzaMoltiplicatori = false;

	private String moltiplicatoreTerritoriale = "1,0";
	private String moltiplicatoreSegmento = "1,0";
	private String moltiplicatoreRating = "1,0";

	private String moltiplicatoreFamMerc = "1,0";
	private String moltiplicatoreSottoSegComm = "1,0";

	// Addizione Valore Canale Proposta
	private String valoreCanaleProposta = "0";
	private String FlagPdrPrezzoApplicato = "";
	private String flagPdrCappatoFloorato = "0";

	//ArrayList<CondizioneDerogaPricing> listFiglie = new ArrayList<CondizioneDerogaPricing>();
	private int progressivoSequenzaMLT = 0;

	// indica se la condizione e' di tipo testo libero o meno
	// (campo aggiunto per mapping con tabella dipartimentale PROPOSTE_CONDIZ)
	private String indTestoLibero = "N";
	private String indCondizionePriceRange = "N";
	private String flagCondizioneModificata = "N";

	// 2017 FLAG CHE INDICA SE SU UNA CONVENZIONE POSSONO ESSERE DEORGATE FASCE
	private String flagFasce = "S";
	// DEROGA ROLLING - 2017
	private boolean presenteDerogaRollingProposto = false;

	private boolean presenteDerogaRollingApprovato = false;
	private boolean presenzaRollingAllaData = false;
	// flag rolling normale parametrato
	private String TIPO_OPERAZIONE_ROLLING = "N";
	// valori proposti
	private String valNumericoRollingProposto = "";

	// FINE DEROGA ROLLING

	private String valCodiceRollingProposto = "";
	private String descCodiceRollingProposto = "";

//	private ParametriCondizioneDeroga parametriCondizioneDerogaRollingProposti = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");

	private String formulaParametriRollingProposti = "";

	// valori approvati
	private String valNumericoRollingApprovato = "";

	private String valCodiceRollingApprovato = "";

	private String descCodiceRollingApprovato = "";

//	private ParametriCondizioneDeroga parametriCondizioneDerogaRollingApprovati = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");

	private String formulaParametriRollingApprovati = "";

	// valori attuali
	private String valNumericoRollingAttuale = "";

	private String valCodiceRollingAttuale = "";

	private String descCodiceRollingAttuale = "";

//	private ParametriCondizioneDeroga parametriCondizioneDerogaRollingAttuali = new ParametriCondizioneDeroga(
//			new ArrayList(), new ArrayList(), 0, "", "");

	private String formulaParametriRollingAttuali = "";

	// durate
	private String durataRollingProposto = "";

	private String durataRollingApprovato = "";

	private String durataRollingAttuale = "";

	private String durataRollingMax = "";

	// BonusVenduto
	public String bonusVenduto = "N";

	// 22062018 indicatore deroga da PDR
	private String indValorePDR = "";

	// campi per controlli proposta deroga
	private String codBloccoAntergazione = "";
	private int numMinAntergazione = 0;
	private int numMaxPostergazione = 0;
	private String flagAnterga = "N";
	private String flagParametrataObbligatoria = "";
	private String indDefault = "N";
	private String indLiquidazione = "N";
	private String valNumericoAttualePerDeroga = "";
	private String soloDateInizioFineTrimestre = "N";
	
	private String CD_UDM = "";
	private String DS_CONDIZIONE = "";
	private String CD_CONDIZIONE = "";

	// Oggetto usato per dialogare con OUTBST di PCEECNDALO
	public CondizioneDeroga() {
		this.listaControllateDefault = new ArrayList();
		this.listaControllateInCompilaProposta = new ArrayList();
		this.listaCorrelate = new ArrayList();
		this.listaCorrelateFull = new ArrayList();
		this.listaIncompatibili = new ArrayList();
		this.hashControllateDefault = new Hashtable();
		this.hashControllateInCompilaProposta = new Hashtable();
		this.listaCodSottocondizioni = new ArrayList();
		// this.hashCondizioniGerarchia = new Hashtable();
		setCodiceCondizioneInderogabile(null);
		setLivelloApplicativo(0);
	}
	
	

	public String getCD_CONDIZIONE() {
		return CD_CONDIZIONE;
	}
	public void setCD_CONDIZIONE(String cD_CONDIZIONE) {
		CD_CONDIZIONE = cD_CONDIZIONE;
	}
	public String getCD_UDM() {
		return CD_UDM;
	}
	public void setCD_UDM(String cD_UDM) {
		CD_UDM = cD_UDM;
	}
	public String getDS_CONDIZIONE() {
		return DS_CONDIZIONE;
	}
	public void setDS_CONDIZIONE(String dS_CONDIZIONE) {
		DS_CONDIZIONE = dS_CONDIZIONE;
	}
	public String getCodBloccoAntergazione() {
		return codBloccoAntergazione;
	}

	public void setCodBloccoAntergazione(String codBloccoAntergazione) {
		if (codBloccoAntergazione != null)
			this.codBloccoAntergazione = codBloccoAntergazione;
	}

	public int getNumMinAntergazione() {
		return numMinAntergazione;
	}

	public void setNumMinAntergazione(int numMinAntergazione) {
		this.numMinAntergazione = numMinAntergazione;
	}

	public int getNumMaxPostergazione() {
		return numMaxPostergazione;
	}

	public void setNumMaxPostergazione(int numMaxPostergazione) {
		this.numMaxPostergazione = numMaxPostergazione;
	}

	public String getFlagAnterga() {
		return flagAnterga;
	}

	public void setFlagAnterga(String flagAnterga) {
		if (flagAnterga != null)
			this.flagAnterga = flagAnterga;
	}
	public String getValNumericoAttualePerDeroga() {
		return valNumericoAttualePerDeroga;
	}

	public void setValNumericoAttualePerDeroga(
			String valNumericoAttualePerDeroga) {
		this.valNumericoAttualePerDeroga = valNumericoAttualePerDeroga;
	}

	public String getSoloDateInizioFineTrimestre() {
		return soloDateInizioFineTrimestre;
	}

	public void setSoloDateInizioFineTrimestre(
			String soloDateInizioFineTrimestre) {
		this.soloDateInizioFineTrimestre = soloDateInizioFineTrimestre;
	}

	public String getFlagParametrataObbligatoria() {
		return flagParametrataObbligatoria;
	}

	public void setFlagParametrataObbligatoria(
			String flagParametrataObbligatoria) {
		if (flagParametrataObbligatoria != null)
			this.flagParametrataObbligatoria = flagParametrataObbligatoria;
	}

	public String getIndDefault() {
		return indDefault;
	}

	public void setIndDefault(String indDefault) {
		if (indDefault != null)
			this.indDefault = indDefault;
	}

	public String getIndLiquidazione() {
		return indLiquidazione;
	}

	public void setIndLiquidazione(String indLiquidazione) {
		if (indLiquidazione != null)
			this.indLiquidazione = indLiquidazione;
	}

//	public CondizioneDeroga(
//			com.sanpaolo.condizioni.ejbserver.filiale.elencocondizioniinderogasuconvenzione.dto.CondizioneDTO condizioneInDerogaSuConvenzione) {
//		this();
//		this.setCondizione(new Condizione(
//				condizioneInDerogaSuConvenzione.getPCN6_O_COD_CONDIZIONE(),
//				condizioneInDerogaSuConvenzione
//						.getPCN6_O_COD_SOTTOCONDIZIONE()));
//		this.setCodiceCondizioneInderogabile(
//				condizioneInDerogaSuConvenzione.getPCN6_O_COD_INDEROGABILE());
//		this.setLivelloApplicativo(
//				condizioneInDerogaSuConvenzione.getPCN6_O_LIV_APPL());
//		this.setCodDivisa(condizioneInDerogaSuConvenzione.getPCN6_O_DIVISA());
//		this.setDataDecorrenzaAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_DECO());
//		this.setDataScadenzaAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_DECA());
//		this.setCodOrigineCondizAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_DECOD_ORIGINE());
//		// this.setPesoLivelloDeroga(condizioneInDerogaSuConvenzione.getPCN6_O_PESO_CONDIZIONE());
//		// correzione 16/04/2008 su specifiche host
//		this.setPesoLivelloDeroga(
//				condizioneInDerogaSuConvenzione.getPCN6_O_LIV_APPL());
//		this.setPesoLivelloDeroga(
//				condizioneInDerogaSuConvenzione.getPCN6_O_LIV_APPL());
//		this.setTipoValore(
//				condizioneInDerogaSuConvenzione.getPCN6_O_IND_VALORE());
//		this.setValNumericoAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_VALORE());
//		this.setValoreTestoAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_TESTO());
//		this.setValCodiceAttuale(
//				condizioneInDerogaSuConvenzione.getPCN6_O_CODICE());
//		if (this.getCodOrigineCondizAttuale().matches(".*PAR.*")) {
//			this.setParametrata(true);
//
//		}
//
//		if (condizioneInDerogaSuConvenzione.getParametri().size() > 0) {
//			ArrayList parametri = new ArrayList();
//			int numeroParametri = 0;
//			ArrayList valoriPercParametri = new ArrayList();
//
//			/*
//			 * MODIFICA in data 31/07/2006 da P.Trevisan. Gestisce correttamente
//			 * il caso in cui non ci sia lo spread
//			 */
//			if (((ParametroDTO) condizioneInDerogaSuConvenzione.getParametri()
//					.get(condizioneInDerogaSuConvenzione.getParametri().size()
//							- 1)).getOPERAZ_PARAMETRO().equals("%")) {
//				// caso in cui non c'e' lo spread
//				for (int i = 0; i < condizioneInDerogaSuConvenzione
//						.getParametri().size(); i++) {
//					valoriPercParametri.add(new ParametroCondizioneDeroga(
//							((ParametroDTO) condizioneInDerogaSuConvenzione
//									.getParametri().get(i))
//											.getVALORE_PARAMETRO(),
//							"",
//							((ParametroDTO) condizioneInDerogaSuConvenzione
//									.getParametri().get(i))
//											.getCOD_PARAMETRO()));
//				}
//				this.setParametriCondizioneDeroga(new ParametriCondizioneDeroga(
//						parametri, valoriPercParametri, numeroParametri, "+",
//						"0,0"));
//				this.setParametriCondizioneDerogaApprovati(
//						new ParametriCondizioneDeroga(parametri,
//								valoriPercParametri, numeroParametri, "+",
//								"0,0"));
//
//			} else {
//				// caso in cui c'e' lo spread
//				for (int i = 0; i < condizioneInDerogaSuConvenzione
//						.getParametri().size() - 1; i++) {
//					valoriPercParametri.add(new ParametroCondizioneDeroga(
//							((ParametroDTO) condizioneInDerogaSuConvenzione
//									.getParametri().get(i))
//											.getVALORE_PARAMETRO(),
//							"",
//							((ParametroDTO) condizioneInDerogaSuConvenzione
//									.getParametri().get(i))
//											.getCOD_PARAMETRO()));
//				}
//				String segnoSpreadProposto = ((ParametroDTO) condizioneInDerogaSuConvenzione
//						.getParametri().get(condizioneInDerogaSuConvenzione
//								.getParametri().size() - 1))
//										.getOPERAZ_PARAMETRO();
//				String spreadProposto = ((ParametroDTO) condizioneInDerogaSuConvenzione
//						.getParametri().get(condizioneInDerogaSuConvenzione
//								.getParametri().size() - 1))
//										.getVALORE_PARAMETRO();
//				this.setParametriCondizioneDeroga(new ParametriCondizioneDeroga(
//						parametri, valoriPercParametri, numeroParametri,
//						segnoSpreadProposto, spreadProposto));
//				this.setParametriCondizioneDerogaApprovati(
//						new ParametriCondizioneDeroga(parametri,
//								valoriPercParametri, numeroParametri,
//								segnoSpreadProposto, spreadProposto));
//
//			}
//		}
//
//		// la condizione proviene da Host (utile alla visualizzazione delle
//		// condizioni o sottocondizioni)
//		this.setProvenienzaDaHost(true);
//
//		String unicaSelezionabileHost = condizioneInDerogaSuConvenzione
//				.getPCN6_O_IND_UNICA_COND();
//		this.setUnicaSelezionabileHost((null != unicaSelezionabileHost
//				&& !unicaSelezionabileHost.equals("")
//				&& unicaSelezionabileHost.trim().equals("S")) ? true : false);
//
//		this.setFlagBlindatura((condizioneInDerogaSuConvenzione
//				.getPCN6_O_COD_INDEROGABILE().equals("PS")) ? "S" : "N");
//
//		this.setCodiceProvenienza(
//				condizioneInDerogaSuConvenzione.getPCN6_O_PROVENIENZA());
//		this.setCodiceIdentificativo(
//				condizioneInDerogaSuConvenzione.getPCN6_O_IDENTIFICATIVO());
//
//		this.setCodListino(
//				condizioneInDerogaSuConvenzione.getPCN6_O_COD_LISTINO());
//		this.setTipoCondizionePromo(
//				condizioneInDerogaSuConvenzione.getPCN6_O_TIPO_COND());
//		this.setSegnoBeneficio(
//				condizioneInDerogaSuConvenzione.getPCN6_O_SEGNO_VALORE());
//
//		this.setPresenzaFasceAllaData(
//				condizioneInDerogaSuConvenzione.isPresenzaFasceAllaData());
//
//		this.setPresenzaRollingAllaData(
//				condizioneInDerogaSuConvenzione.isPresenzaRollingAllaData());
//
//		if (condizioneInDerogaSuConvenzione.getPCN6_O_IND_VALORE()
//				.equalsIgnoreCase("1")) {
//			this.setValorePostConvDesc(
//					condizioneInDerogaSuConvenzione.getPCN6_O_VALORE_PCV());
//
//			if (condizioneInDerogaSuConvenzione.getParametriPcv().size() > 0) {
//				ArrayList parametri = new ArrayList();
//				int numeroParametri = 0;
//				ArrayList valoriPercParametri = new ArrayList();
//
//				/*
//				 * MODIFICA in data 31/07/2006 da P.Trevisan. Gestisce
//				 * correttamente il caso in cui non ci sia lo spread
//				 */
//				if (condizioneInDerogaSuConvenzione.getParametriPcv()
//						.get(condizioneInDerogaSuConvenzione.getParametriPcv()
//								.size() - 1)
//						.getOPERAZ_PARAMETRO().equals("%")) {
//					// caso in cui non c'e' lo spread
//					for (int i = 0; i < condizioneInDerogaSuConvenzione
//							.getParametriPcv().size(); i++) {
//						valoriPercParametri.add(new ParametroCondizioneDeroga(
//								condizioneInDerogaSuConvenzione
//										.getParametriPcv().get(i)
//										.getVALORE_PARAMETRO(),
//								"",
//								condizioneInDerogaSuConvenzione
//										.getParametriPcv().get(i)
//										.getCOD_PARAMETRO()));
//					}
//					this.setParametriPostConvenzione(
//							new ParametriCondizioneDeroga(parametri,
//									valoriPercParametri, numeroParametri, "+",
//									"0,0"));
//
//				} else {
//					// caso in cui c'e' lo spread
//					for (int i = 0; i < condizioneInDerogaSuConvenzione
//							.getParametriPcv().size() - 1; i++) {
//						valoriPercParametri.add(new ParametroCondizioneDeroga(
//								condizioneInDerogaSuConvenzione
//										.getParametriPcv().get(i)
//										.getVALORE_PARAMETRO(),
//								"",
//								condizioneInDerogaSuConvenzione
//										.getParametriPcv().get(i)
//										.getCOD_PARAMETRO()));
//					}
//					String segnoSpreadProposto = condizioneInDerogaSuConvenzione
//							.getParametriPcv()
//							.get(condizioneInDerogaSuConvenzione
//									.getParametriPcv().size() - 1)
//							.getOPERAZ_PARAMETRO();
//					String spreadProposto = condizioneInDerogaSuConvenzione
//							.getParametriPcv()
//							.get(condizioneInDerogaSuConvenzione
//									.getParametriPcv().size() - 1)
//							.getVALORE_PARAMETRO();
//					this.setParametriPostConvenzione(
//							new ParametriCondizioneDeroga(parametri,
//									valoriPercParametri, numeroParametri,
//									segnoSpreadProposto, spreadProposto));
//
//				}
//			}
//
//		} else if (condizioneInDerogaSuConvenzione.getPCN6_O_IND_VALORE()
//				.equalsIgnoreCase("3")) {
//			this.setValorePostConvDesc(
//					condizioneInDerogaSuConvenzione.getPCN6_O_CODICE_PCV());
//		}
//
//		// Gerarchia
//		this.setValNumericoAttualeGerarchia(
//				condizioneInDerogaSuConvenzione.getNumValoreAttualeGerarchia());
//		this.setCodiceValoreAttualeGerarchia(condizioneInDerogaSuConvenzione
//				.getCodiceValoreAttualeGerarchia());
//		this.setSegnoValoreStandardGerarchia(condizioneInDerogaSuConvenzione
//				.getSegnoValoreStandardGerarchia());
//
//		/*
//		 * this.livelloGerarchia=condizioneInDerogaSuConvenzione.
//		 * getLivelloGerarchia();
//		 * this.condizionePrimoLivelloGerarchia=condizioneInDerogaSuConvenzione.
//		 * getCondizionePrimoLivelloGerarchia();
//		 * this.condizioneRegolaGerarchia=condizioneInDerogaSuConvenzione.
//		 * getCondizioneRegolaGerarchia();
//		 */
//		this.valoreRegolaGerarchia = condizioneInDerogaSuConvenzione
//				.getValoreRegolaGerarchia();
//
//	}

	// costruttore "copia" (crea una copia della condizione in input)
	// Attenzione: non tutti i campi vengono copiati!!
	public CondizioneDeroga(CondizioneDeroga condizioneDaCopiare) {

		this();

		Condizione condizione = new Condizione();
		this.setCondizione(condizione);
		this.getCondizione().setCodiceCondizione(
				condizioneDaCopiare.getCondizione().getCodiceCondizione());
		this.getCondizione().setCodiceSottocondizione(
				condizioneDaCopiare.getCondizione().getCodiceSottocondizione());

		this.setAzione(condizioneDaCopiare.getAzione());
		this.setTipoValore(condizioneDaCopiare.getTipoValore());

		this.setValNumericoAttuale(condizioneDaCopiare.getValNumericoAttuale());
		this.setValNumericoProposto(
				condizioneDaCopiare.getValNumericoProposto());
		this.setValNumericoApprovato(
				condizioneDaCopiare.getValNumericoApprovato());

		this.setValCodiceAttuale(condizioneDaCopiare.getValCodiceAttuale());
		this.setValCodiceProposto(condizioneDaCopiare.getValCodiceProposto());
		this.setValCodiceApprovato(condizioneDaCopiare.getValCodiceApprovato());

		this.setDataDecorrenzaAttuale(
				condizioneDaCopiare.getDataDecorrenzaAttuale());
		this.setDataDecorrenzaProposta(
				condizioneDaCopiare.getDataDecorrenzaProposta());
		this.setDataDecorrenzaApprovata(
				condizioneDaCopiare.getDataDecorrenzaApprovata());

		this.setDataScadenzaAttuale(
				condizioneDaCopiare.getDataScadenzaAttuale());
		this.setDataScadenzaProposta(
				condizioneDaCopiare.getDataScadenzaProposta());
		this.setDataScadenzaApprovata(
				condizioneDaCopiare.getDataScadenzaApprovata());

		this.setRegime(condizioneDaCopiare.isRegime());
		this.setControllataScaglione(
				condizioneDaCopiare.isControllataScaglione());
		this.setRegimeIsTassoPlus(condizioneDaCopiare.isRegimeIsTassoPlus());
		this.setTassoPlus(condizioneDaCopiare.isTassoPlus());
	}

//	public CondizioneDeroga(CondizioneDTO condizioneInDerogaSuGruppoGiacenza) {
//		this();
//		this.setCondizione(new Condizione(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_COD_CONDIZIONE(),
//				condizioneInDerogaSuGruppoGiacenza
//						.getPCN8_O_COD_SOTTOCONDIZIONE()));
//		this.setCodDivisa(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_DIVISA());
//		this.setDataDecorrenzaAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_DECO());
//		this.setDataScadenzaAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_DECA());
//		this.setCodOrigineCondizAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_DECOD_ORIGINE());
//		this.setTipoValore(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_IND_VALORE());
//		this.setValNumericoAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_VALORE());
//		this.setValoreTestoAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_TESTO());
//		this.setValCodiceAttuale(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_CODICE());
//		if (this.getCodOrigineCondizAttuale().matches(".*PAR.*"))
//			this.setParametrata(true);
//
//		if (condizioneInDerogaSuGruppoGiacenza.getParametri().size() > 0) {
//			ArrayList parametri = new ArrayList();
//			int numeroParametri = 0;
//			ArrayList valoriPercParametri = new ArrayList();
//
//			/*
//			 * MODIFICA in data 31/07/2006 da P.Trevisan. Gestisce correttamente
//			 * il caso in cui non ci sia lo spread
//			 */
//			if (((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//					.getParametri().get(condizioneInDerogaSuGruppoGiacenza
//							.getParametri().size() - 1)).getOPERAZ_PARAMETRO()
//									.equals("%")) {
//				// caso in cui non c'e' lo spread
//				for (int i = 0; i < condizioneInDerogaSuGruppoGiacenza
//						.getParametri().size(); i++) {
//					valoriPercParametri.add(new ParametroCondizioneDeroga(
//							((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//									.getParametri().get(i))
//											.getVALORE_PARAMETRO(),
//							"",
//							((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//									.getParametri().get(i))
//											.getCOD_PARAMETRO()));
//				}
//				this.setParametriCondizioneDeroga(new ParametriCondizioneDeroga(
//						parametri, valoriPercParametri, numeroParametri, "+",
//						"0,0"));
//				this.setParametriCondizioneDerogaApprovati(
//						new ParametriCondizioneDeroga(parametri,
//								valoriPercParametri, numeroParametri, "+",
//								"0,0"));
//
//			} else {
//				// caso in cui c'e' lo spread
//				for (int i = 0; i < condizioneInDerogaSuGruppoGiacenza
//						.getParametri().size() - 1; i++) {
//					valoriPercParametri.add(new ParametroCondizioneDeroga(
//							((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//									.getParametri().get(i))
//											.getVALORE_PARAMETRO(),
//							"",
//							((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//									.getParametri().get(i))
//											.getCOD_PARAMETRO()));
//				}
//				String segnoSpreadProposto = ((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//						.getParametri().get(condizioneInDerogaSuGruppoGiacenza
//								.getParametri().size() - 1))
//										.getOPERAZ_PARAMETRO();
//				String spreadProposto = ((ParametroDTO) condizioneInDerogaSuGruppoGiacenza
//						.getParametri().get(condizioneInDerogaSuGruppoGiacenza
//								.getParametri().size() - 1))
//										.getVALORE_PARAMETRO();
//				this.setParametriCondizioneDeroga(new ParametriCondizioneDeroga(
//						parametri, valoriPercParametri, numeroParametri,
//						segnoSpreadProposto, spreadProposto));
//				this.setParametriCondizioneDerogaApprovati(
//						new ParametriCondizioneDeroga(parametri,
//								valoriPercParametri, numeroParametri,
//								segnoSpreadProposto, spreadProposto));
//
//			}
//		}
//		// la condizione proviene da Host (utile alla visualizzazione delle
//		// condizioni o sottocondizioni)
//		this.setProvenienzaDaHost(true);
//
//		String unicaSelezionabileHost = condizioneInDerogaSuGruppoGiacenza
//				.getPCN8_O_IND_UNICA_COND();
//		this.setUnicaSelezionabileHost((null != unicaSelezionabileHost
//				&& !unicaSelezionabileHost.equals("")
//				&& unicaSelezionabileHost.trim().equals("S")) ? true : false);
//
//		this.setCodiceProvenienza(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_PROVENIENZA());
//
//		this.setCodiceIdentificativo(
//				condizioneInDerogaSuGruppoGiacenza.getPCN8_O_IDENTIFICATIVO());
//	}

//	public CondizioneDeroga(TAG_OUTT08 outt08, String branch,
//			String codIstituto) throws SystemException {
//		this();
//		this.setCondizione(new Condizione(outt08.PCND_O_COD_CONDIZ.trim(),
//				outt08.PCND_O_COD_CONDIZ_ATO.trim()));
//		this.setCodiceCondizioneInderogabile(outt08.PCND_O_COD_COND_INDEROG);
//		this.setValCodiceApprovato(outt08.PCND_O_CODICE_AP.trim());
//		this.setValCodiceProposto(outt08.PCND_O_CODICE_PR.trim());
//		this.setValCodiceAttuale(outt08.PCND_O_CODICE_AT.trim());
//		this.setValNumericoApprovato(
//				Number.parseDouble(outt08.PCND_O_VALORE_AP));
//		this.setValNumericoProposto(
//				Number.parseDouble(outt08.PCND_O_VALORE_PR));
//		this.setValNumericoAttuale(
//				Number.toStringConverter(outt08.PCND_O_VALORE_AT));// per avere
//																	// la
//																	// scritta
//																	// "illimitato"
//																	// in
//																	// visualizzazione
//		this.setDataDecorrenzaApprovata(
//				Format.fromHostDate(outt08.PCND_O_DECO_CONDIZIONE_AP.trim()));
//		this.setDataDecorrenzaAttuale(
//				Format.fromHostDate(outt08.PCND_O_DECO_CONDIZIONE_AT.trim()));
//		this.setDataDecorrenzaProposta(
//				Format.fromHostDate(outt08.PCND_O_DECO_CONDIZIONE_PR.trim()));
//		this.setDataScadenzaApprovata(
//				Format.fromHostDate(outt08.PCND_O_DECA_CONDIZIONE_AP.trim()));
//		this.setDataScadenzaAttuale(
//				Format.fromHostDate(outt08.PCND_O_DECA_CONDIZIONE_AT.trim()));
//		this.setDataScadenzaProposta(
//				Format.fromHostDate(outt08.PCND_O_DECA_CONDIZIONE_PR.trim()));
//		this.setEsitoCondizione(outt08.PCND_O_ESITO_DE.trim());
//		/*
//		 * Modificato da P.Trevisan il 27/10/2006: l'autonomia viene settata ad
//		 * S solo se è in facoltà in riferimento all'uo dell'utente
//		 */
//		if (outt08.PCND_O_FACOLTA.trim().equalsIgnoreCase("S")
//				&& branch.equalsIgnoreCase(outt08.PCND_O_UO_FAC.trim()))
//			this.setAutonomia("S");
//		else
//			this.setAutonomia("N");
//		this.setAzione(outt08.PCND_O_IND_OPERATIV.trim());
//		this.setCodOrigineCondizAttuale(outt08.PCND_O_ORIGINE_VAL_ATT.trim());
//		this.setTipoValore(outt08.PCND_O_IND_VALORE.trim());
//		this.setMessaggioErrore(outt08.PCND_O_MSG_ERRORE.trim());
//		this.setCondizioneErrore(outt08.PCND_O_COND_ERRORE.trim());
//		this.setCodiceErrore(outt08.PCND_O_RET_CODE.trim());
//		if (outt08.PCND_O_TIPO_DEROGA.trim().equalsIgnoreCase("P")) {
//			this.setParametrata(true);
//			this.setParametriCondizioneDeroga(
//					new ParametriCondizioneDeroga(outt08.TAG_OUTCPP));
//			this.setParametriCondizioneDerogaApprovati(
//					new ParametriCondizioneDeroga(outt08.TAG_OUTCPA));
//		}
//		this.setTipoDeroga(outt08.PCND_O_TIPO_DEROGA.trim());
//		this.setTIPO_OPERAZIONE(!(outt08.PCND_O_IND_OPERATIV.trim().equals("S"))
//				? outt08.PCND_O_TIPO_DEROGA.trim()
//				: "S");
//
//		if (this.getTipoValore().equals("2") && outt08.TAG_OUTTES != null
//				&& outt08.TAG_OUTTES.length > 0) {
//			this.setValoreTestoAttuale(
//					outt08.TAG_OUTTES[0].PCND_O_COD_TESTO_LIB.trim());
//		}
//
//		// PARAMETRI OUTPUT CORRELAZIONI FULL/TECNICA/LIGHT
//		this.setIndTipoCorr(outt08.PCND_O_TIPO_CORRELAZIONE.trim());
//		this.setIndCapoFila(outt08.PCND_O_CORR_PRINCIPALE_FL.trim());
//		this.setIndCapoFilaTecnica(outt08.PCND_O_CORR_PRINCIPALE.trim());
//		this.setPacchettoCorr(outt08.PCND_O_PROGR_CORRELAZIONE_FL.trim());
//		this.setPacchettoCorrTecniche(outt08.PCND_O_PROGR_CORRELAZIONE.trim());
//
//		// CONDIZIONI FIGLIE GERARCHIA
//		if (null != outt08.TAG_OUTGER && outt08.TAG_OUTGER.length > 0) {
//			boolean isControllata = GestioneFacoltaDAO.isCondizioneControllata(
//					codIstituto, this.getCondizione().getCodiceCondizione());
//			String strCondizioniGerarchia = "";
//			ArrayList<Condizione> listaOutGER = new ArrayList<Condizione>();
//			for (int q = 0; q < outt08.TAG_OUTGER.length; q++) {
//				strCondizioniGerarchia += outt08.TAG_OUTGER[q].PCND_O_COND_2_LIVELLO
//						.substring(0, 5) + ";";
//				listaOutGER.add(new Condizione(
//						outt08.TAG_OUTGER[q].PCND_O_COND_2_LIVELLO.substring(0,
//								5),
//						outt08.TAG_OUTGER[q].PCND_O_COND_2_LIVELLO.substring(5,
//								8)));
//			}
//			this.setLivelloGerarchia("1");
//
//			this.setListaCondizioniOutGER(listaOutGER);
//			if (isControllata) {
//				this.setStrControllateGerarchia(strCondizioniGerarchia);
//				this.setStrControllatePrimoLivelloGerarchia(
//						outt08.PCND_O_COD_CONDIZ);
//			} else {
//				this.setStrCondizioniGerarchia(strCondizioniGerarchia);
//				this.setCondizionePrimoLivelloGerarchia(
//						outt08.PCND_O_COD_CONDIZ);
//			}
//		}
//	}

	public void addControllataInListaCompilaProposta(
			String codCondizioneControllata) {
		if (null != codCondizioneControllata
				&& !codCondizioneControllata.equals(""))
			listaControllateInCompilaProposta.add(codCondizioneControllata);
		else
			log.debug("codCondizioneControllata passata in input vuota");
	}

	public void addControllataInListaDefault(String codCondizioneControllata) {
		if (null != codCondizioneControllata
				&& !codCondizioneControllata.equals(""))
			listaControllateDefault.add(codCondizioneControllata);
		else
			log.debug("codCondizioneControllata passata in input vuota");
	}

	public void addSottocondizioneInLista(String codSottocondizione) {
		if (null != codSottocondizione && !codSottocondizione.equals(""))
			this.listaCodSottocondizioni.add(codSottocondizione);
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			log.error("CondizioneDeroga.clone()", e);
			return null;
		}
	}

	/**
	 * Metodo utile alla comparazione degli oggetti CondizioneDeroga per poi
	 * poter ordinare con il metodo Collections.sort (usato ad esempio in
	 * GestoreElencoCondizioni) una collezione di oggetti CondizioneDeroga
	 */
	/*
	 * public int compareTo(Object obj){ if (!(obj instanceof CondizioneDeroga))
	 * throw new ClassCastException("A CondizioneDeroga object expected."); //
	 * Ottengo i codici delle condizioni da confrontare: // Se sono regimi //
	 * Allora aggiungo il prefisso 00000 che fa in modo che nel sorting
	 * dell'insiame di condizioni // posiziona i regimi in testa all'insieme
	 * ordinato (così rispetto le specifiche del cliente // che vuole
	 * viualizzare per prima i regimi..poi il resto delle regole di ordinamento
	 * sono applicate nel // metodo di ordinamento
	 * GestoreElencoCondiizoni.getCondizioniDaVisualizzareOrdinate) String
	 * myCodCondizione = (this.regime) ?
	 * "00000"+this.condizione.getCodiceCondizione() :
	 * this.condizione.getCodiceCondizione(); String objCodCondizione =
	 * (((CondizioneDeroga)obj).isRegime()) ?
	 * "00000"+((CondizioneDeroga)obj).getCondizione().getCodiceCondizione() :
	 * ((CondizioneDeroga)obj).getCondizione().getCodiceCondizione(); return
	 * myCodCondizione.compareTo(objCodCondizione); }
	 */
//	@Override
//	public int compareTo(Object obj) {
//		if (!(obj instanceof CondizioneDeroga))
//			throw new ClassCastException("A CondizioneDeroga object expected.");
//
//		// Ottengo i codici delle condizioni da confrontare (unione del cod
//		// condizione + cod sottocondizione) :
//		// Se sono regimi
//		// Allora aggiungo il prefisso 00000 che fa in modo che nel sorting
//		// dell'insiame di condizioni
//		// posiziona i regimi in testa all'insieme ordinato (così rispetto le
//		// specifiche del cliente
//		// che vuole viualizzare per prima i regimi..poi il resto delle regole
//		// di ordinamento sono applicate nel
//		// metodo di ordinamento
//		// GestoreElencoCondiizoni.getCondizioniDaVisualizzareOrdinate)
//		String myCodCondizione = this.condizione.getCodiceCondizione();
//		String myCodSottocondizione = this.condizione
//				.getCodiceSottocondizione();
//		String myCodGerarchia = (livelloGerarchia.equals("1"))
//				? myCodCondizione
//				: "";
//		if (livelloGerarchia.equals("2"))
//			myCodGerarchia = this.condizionePrimoLivelloGerarchia;
//
//		String myCodUnico = "00000000000Z" + myCodGerarchia + myCodCondizione
//				+ myCodSottocondizione;
//		if (!this.codListino.equals(""))
//			myCodUnico = this.codListino + myCodGerarchia + myCodCondizione
//					+ myCodSottocondizione;
//
//		if (this.regime) {
//			if (!this.codListino.equals(""))
//				myCodUnico = this.codListino + "00000" + myCodGerarchia
//						+ myCodCondizione + myCodSottocondizione;
//			else
//				myCodUnico = "00000000000Z00000" + myCodGerarchia
//						+ myCodCondizione + myCodSottocondizione;
//		} else if (this.isControllata()) {
//			if (!this.getCodiceRegimeSconto().equals("")) {
//				if (!this.codListino.equals(""))
//					myCodUnico = this.codListino + "00001" + myCodGerarchia
//							+ myCodCondizione + myCodSottocondizione;
//				else
//					myCodUnico = "00000000000Z00001" + myCodGerarchia
//							+ myCodCondizione + myCodSottocondizione;
//			} else {
//				myCodCondizione = this.codiceRegime;
//				myCodUnico = "00000000000Z00000" + myCodGerarchia
//						+ myCodCondizione + myCodSottocondizione;
//			}
//		}
//
//		String objCodCondizione = ((CondizioneDeroga) obj).getCondizione()
//				.getCodiceCondizione();
//		String objCodSottocondizione = ((CondizioneDeroga) obj).getCondizione()
//				.getCodiceSottocondizione();
//		String objCodGerarchia = ((CondizioneDeroga) obj).getLivelloGerarchia()
//				.equals("1") ? objCodCondizione : "";
//		if (((CondizioneDeroga) obj).getLivelloGerarchia().equals("2"))
//			objCodGerarchia = ((CondizioneDeroga) obj)
//					.getCondizionePrimoLivelloGerarchia();
//
//		String objCodUnico = "00000000000Z" + objCodGerarchia + objCodCondizione
//				+ objCodSottocondizione;
//
//		if (!((CondizioneDeroga) obj).getCodListino().equals(""))
//			objCodUnico = ((CondizioneDeroga) obj).getCodListino()
//					+ objCodGerarchia + objCodCondizione
//					+ objCodSottocondizione;
//
//		if (((CondizioneDeroga) obj).isRegime()) {
//			if (!((CondizioneDeroga) obj).codListino.equals(""))
//				objCodUnico = ((CondizioneDeroga) obj).getCodListino() + "00000"
//						+ objCodGerarchia + objCodCondizione
//						+ objCodSottocondizione;
//			else
//				objCodUnico = "00000000000Z00000" + objCodGerarchia
//						+ objCodCondizione + objCodSottocondizione;
//		} else if (((CondizioneDeroga) obj).isControllata()) {
//			if (!((CondizioneDeroga) obj).getCodiceRegimeSconto().equals("")) {
//				if (!((CondizioneDeroga) obj).codListino.equals(""))
//					objCodUnico = ((CondizioneDeroga) obj).codListino + "00001"
//							+ objCodGerarchia + objCodCondizione
//							+ objCodSottocondizione;
//				else
//					objCodUnico = "00000000000Z00001" + objCodGerarchia
//							+ objCodCondizione + objCodSottocondizione;
//			} else {
//				objCodCondizione = ((CondizioneDeroga) obj).getCodiceRegime();
//				objCodUnico = "00000000000Z00000" + objCodGerarchia
//						+ objCodCondizione + objCodSottocondizione;
//			}
//		}
//
//		return myCodUnico.compareTo(objCodUnico);
//	}

	public boolean esisteCondizioneControllataInCompilaProposta(
			String codCondizioneControllata) {
		return (null != codCondizioneControllata
				&& !codCondizioneControllata.equals(""))
						? this.listaControllateInCompilaProposta
								.contains(codCondizioneControllata)
						: false;
	}

	public boolean esisteCondizioneControllataInListaDefault(
			String codCondizioneControllata) {
		return (null != codCondizioneControllata
				&& !codCondizioneControllata.equals(""))
						? this.listaControllateDefault
								.contains(codCondizioneControllata)
						: false;
	}

	public boolean esistonoControllateInListaCompilaProposta() {
		return (!this.listaControllateInCompilaProposta.isEmpty())
				? true
				: false;
	}

	public boolean esistonoControllateInListaDefault() {
		return (!this.listaControllateDefault.isEmpty()) ? true : false;
	}

	public String getAbiProvenienza() {
		return abiProvenienza;
	}

	public String getAutonomia() {
		return this.autonomia;
	}

	public String getAzione() {
		return this.azione;
	}

//	public BeneficioInEssere getBeneficioInEssereCovenant() {
//		return beneficioInEssereCovenant;
//	}

	public String getBonusVenduto() {
		return bonusVenduto;
	}

	public String getCD_CONDIZIONE_MACROGRUPPO() {
		return CD_CONDIZIONE_MACROGRUPPO;
	}

	public String getCD_CONDIZIONE_SOTTOGRUPPO() {
		return CD_CONDIZIONE_SOTTOGRUPPO;
	}

	public String getCD_SECONDO_DRIVER_TIPO() {
		return CD_SECONDO_DRIVER_TIPO;
	}

	public String getCD_SECONDO_DRIVER_UDM() {
		return CD_SECONDO_DRIVER_UDM;
	}

	public String getCodAggregOriginAtt() {
		return codAggregOriginAtt;
	}

	public String getCodCondIncompatibili() {
		return codCondIncompatibili;
	}

	public String getCodCondizionePrange() {
		String codCondizionePrange = "";
		if (formaTecnicaPrangeHost != null
				&& formaTecnicaPrangeHost.length() > 0) {
			String[] arrayFormaTecnicaPrangeHost = this.formaTecnicaPrangeHost
					.split(";");
			if (arrayFormaTecnicaPrangeHost.length > 1)
				codCondizionePrange = arrayFormaTecnicaPrangeHost[1];
		}
		return codCondizionePrange;
	}

	public String getCodCorrelataPadre() {
		return this.codCorrelataPadre;
	}

	public String getCodDivisa() {
		return codDivisa;
	}

	public String getCodiceCondizione() {
		this.codiceCondizione = getCondizione().getCodiceCondizione();
		return this.codiceCondizione;
	}

	public String getCodiceCondizioneInderogabile() {
		return codiceCondizioneInderogabile;
	}

	public String getCodiceErrore() {
		return codiceErrore;
	}

	// nel popup fasce i valori codiceFasciaConvenzione e
	// numeroFasciaConvenzione hanno nome codiceFasciaBeneficio e
	// numeroFasciaBeneficio
	public String getCodiceFasciaBeneficio() {
		return this.codiceFasciaConvenzione;
	}

	public String getCodiceFasciaConvenzione() {
		return codiceFasciaConvenzione;
	}

	public String getCodiceIdentificativo() {
		return codiceIdentificativo;
	}

	public String getCodiceProvenienza() {
		return codiceProvenienza;
	}

	public String getCodiceProvenienzaDesc() {
		return codiceProvenienzaDesc;
	}

	public String getCodiceRegime() {
		return codiceRegime;
	}

	public String getCodiceRegimeSconto() {
		return codiceRegimeSconto;
	}

	public String getCodiceSottocondizione() {
		this.codiceSottocondizione = getCondizione().getCodiceSottocondizione();
		return this.codiceSottocondizione;
	}

	public String getCodiceTipoCovenantAttuale() {
		return codiceTipoCovenantAttuale;
	}

	public String getCodiceValoreAttualeGerarchia() {
		return codiceValoreAttualeGerarchia;
	}

	public String getCodiceValoreStandardGerarchia() {
		return codiceValoreStandardGerarchia;
	}

	public String getCodListino() {
		return codListino;
	}

	public String getCodOrigineCondizAttuale() {
		return codOrigineCondizAttuale;
	}

	public String getCodVariazione() {
		return codVariazione;
	}

	public String getComposizioneDA() {
		return composizioneDA;
	}

	public Condizione getCondizione() {
		return condizione;
	}

	public String getCondizioneErrore() {
		return condizioneErrore;
	}

	public String getCondizionePrimoLivelloGerarchia() {
		return condizionePrimoLivelloGerarchia;
	}

	public String getCondizioneRegolaGerarchia() {
		return condizioneRegolaGerarchia;
	}

	public String getCondRaggruppamento() {
		return condRaggruppamento;
	}

	public String getCONV_ALTRI_PRD() {
		return CONV_ALTRI_PRD;
	}

//	public Covenant getCovenantAllaData() {
//		return covenantAllaData;
//	}
//
//	public Covenant getCovenantAttuale() {
//		return covenantAttuale;
//	}
//
//	public Covenant getCovenantProposto() {
//		return covenantProposto;
//	}
//
//	public ArrayList<Covenant> getCovenants() {
//		return covenants;
//	}
//
//	public Covenant getCovenantSelezionato() {
//		return covenantSelezionato;
//	}

	public String getDataDecorrenzaApprovata() {
		return dataDecorrenzaApprovata;
	}

	public String getDataDecorrenzaAttuale() {
		return dataDecorrenzaAttuale;
	}

	public String getDataDecorrenzaProposta() {
		return dataDecorrenzaProposta;
	}

	public String getDataDecorrenzaPropostaDaVisualizzare() {
		return Format.getDataDaVisualizzare(dataDecorrenzaProposta);
	}

	public String getDataDecorrenzaStandard() {
		return dataDecorrenzaStandard;
	}

	public String getDataPubblicazioneGerarchia() {
		return dataPubblicazioneGerarchia;
	}

	public String getDataRilevazione() {
		return dataRilevazione;
	}

	public String getDataScadenzaApprovata() {
		return dataScadenzaApprovata;
	}

	public String getDataScadenzaAttuale() {
		return dataScadenzaAttuale;
	}

	public String getDataScadenzaBDR_A() {
		return dataScadenzaBDR_A;
	}

	public String getDataScadenzaBDR_Da() {
		return dataScadenzaBDR_Da;
	}

	public String getDataScadenzaBDR_Selezionata() {
		return dataScadenzaBDR_Selezionata;
	}

	public String getDataScadenzaProposta() {
		return dataScadenzaProposta;
	}

	public String getDataScadenzaPropostaDaVisualizzare() {
		return Format.getDataDaVisualizzare(dataScadenzaProposta);
	}

	public String getDataScadenzaStandard() {
		return dataScadenzaStandard;
	}

//	public PartitaPortafoglio getDatiPartitaPortafoglio() {
//		return datiPartitaPortafoglio;
//	}
//
//	public Opzione getDerogaConsentitaPresenzaCovenant() {
//		return derogaConsentitaPresenzaCovenant;
//	}
//
//	public Opzione getDerogaConsentitaPresenzaCovenantGerarchiaFiglie() {
//		return derogaConsentitaPresenzaCovenantGerarchiaFiglie;
//	}

	public String getDescAggValCodice() {
		return descAggValCodice;
	}

	public String getDescAggValCodice2() {
		return descAggValCodice2;
	}

	public String getDescCodAggregOriginAtt() {
		return descCodAggregOriginAtt;
	}

	public String getDescCodiceApprovato() {
		return descCodiceApprovato;
	}

	public String getDescCodiceApprovato_SHORT() {
		if (this.descCodiceApprovato.length() > 25)
			return descCodiceApprovato.substring(0, 25) + "...";
		else
			return descCodiceApprovato;
	}

	public String getDescCodiceAttuale() {
		return descCodiceAttuale;
	}

	public String getDescCodiceAttuale_SHORT() {
		String descCodiceAttuale_SHORT = this.descCodiceAttuale;
		if (this.descCodiceAttuale.length() > 34) {
			descCodiceAttuale_SHORT = this.descCodiceAttuale.substring(0, 34)
					+ "...";
		}
		return descCodiceAttuale_SHORT;
	}

	public String getDescCodiceAttualeSottocondizione_SHORT() {
		if (this.descCodiceAttuale.length() > 25)
			return descCodiceAttuale.substring(0, 25) + "...";
		else
			return descCodiceAttuale;
	}

	public String getDescCodicePostConvApprovato() {
		return descCodicePostConvApprovato;
	}

	public String getDescCodicePostConvApprovato_SHORT() {
		if (this.descCodicePostConvApprovato.length() > 20)
			return descCodicePostConvApprovato.substring(0, 20) + "...";
		else
			return descCodicePostConvApprovato;
	}

	public String getDescCodicePostConvProposto() {
		return descCodicePostConvProposto;
	}

	public String getDescCodicePostConvProposto_SHORT() {
		if (this.descCodicePostConvProposto.length() > 20)
			return descCodicePostConvProposto.substring(0, 20) + "...";
		else
			return descCodicePostConvProposto;
	}

	public String getDescCodiceRollingApprovato() {
		return descCodiceRollingApprovato;
	}

	public String getDescCodiceRollingAttuale() {
		return descCodiceRollingAttuale;
	}

	public String getDescCodiceRollingProposto() {
		return descCodiceRollingProposto;
	}

	public String getDescCodiceStandard() {
		return descCodiceStandard;
	}

	public String getDescCodiceValoreAttualeGerarchia() {
		return descCodiceValoreAttualeGerarchia;
	}

	public String getDescCodiceValoreAttualeGerarchia_SHORT() {
		String descCodiceAttualeGer_SHORT = this.descCodiceValoreAttualeGerarchia;
		if (this.descCodiceValoreAttualeGerarchia.length() > 34) {
			descCodiceAttualeGer_SHORT = this.descCodiceValoreAttualeGerarchia
					.substring(0, 34) + "...";
		}
		return descCodiceAttualeGer_SHORT;
	}

	public String getDescCodiceValoreStandardGerarchia() {
		return descCodiceValoreStandardGerarchia;
	}

	public String getDescCondizione() {
		return descCondizione;
	}

	public String getDescCondizioneVis() {
		return descCondizioneVis;
	}

	public String getDescFacoltaUoSup() {
		return descFacoltaUoSup;
	}

	public String getIndControlloFacolta() {
		return indControlloFacolta;
	}

	public String getDescMacroGruppo() {
		return descMacroGruppo;
	}

	public String getDesComposizioneDA() {
		return desComposizioneDA;
	}

	/* Dati di supporto, non forniti da Host */
	public String getDescOrigineCondizAttuale() {
		return descOrigineCondizAttuale;
	}

	public String getDescOrigineCondizAttuale_SHORT() {
		String descOrigineCondizAttuale_SHORT = this.descOrigineCondizAttuale;
		if (this.descOrigineCondizAttuale.length() > 30) {
			descOrigineCondizAttuale_SHORT = this.descOrigineCondizAttuale
					.substring(0, 30) + "...";
		}
		return descOrigineCondizAttuale_SHORT;
	}

	public String getDescOrigineCondizAttualeShort() {
		return descOrigineCondizAttualeShort;
	}

	public String getDescOrigineSottocondizAttuale_SHORT() {
		String descOrigineCondizAttuale_SHORT = this.descOrigineCondizAttuale;
		if (this.descOrigineCondizAttuale.length() > 15) {
			descOrigineCondizAttuale_SHORT = this.descOrigineCondizAttuale
					.substring(0, 15) + "...";
		}
		return descOrigineCondizAttuale_SHORT;
	}

	public String getDescPesoLivelloDeroga() {
		return descPesoLivelloDeroga;
	}

	public String getDescrizioneValoreProposto() {
		return descrizioneValoreProposto;
	}

	public String getDescrizioneValoreProposto_SHORT() {
		if (this.descrizioneValoreProposto.length() > 25)
			return descrizioneValoreProposto.substring(0, 25) + "...";
		else
			return descrizioneValoreProposto;
	}

	public String getDescrizioneValoreRollingAllaData() {
		String desc = "";
		if (this.getTipoValore().equalsIgnoreCase("1")) {
			if (this.getTipoRolling().equalsIgnoreCase("N") && !this
					.getValNumericoRollingApprovato().equalsIgnoreCase("")) {
				desc = "Valore: " + this.getValNumericoRollingApprovato()
						+ this.getDescUnitaMisura() + " Durata: "
						+ this.getDurataRollingApprovato() + " mesi";
			} else if (this.getTipoRolling().equalsIgnoreCase("P")) {

				desc = "Valore parametrato "
						+ this.getFormulaParametriRollingApprovati()
						+ "  Durata: " + this.getDurataRollingApprovato()
						+ " mesi";
			}
		} else {
			desc = !this.getDescCodiceRollingApprovato().equalsIgnoreCase("")
					? "Valore: " + this.getDescCodiceRollingApprovato()
							+ " Durata: " + this.getDurataRollingApprovato()
							+ " mesi"
					: "";
		}

		return desc;
	}

	public String getDescSottoGruppo() {
		return descSottoGruppo;
	}

	public String getDescTipoCondizione() {
		return descTipoCondizione;
	}

	public String getDescTipoCondizionePromo() {
		return descTipoCondizionePromo;
	}

	public String getDescUnitaMisura() {
		return descUnitaMisura;
	}

	public String getDescUnitaMisuraTassoCreditoreBDR() {
		return descUnitaMisuraTassoCreditoreBDR;
	}

	public String getDesListino() {
		return desListino;
	}

	public String getDesTipoRendicontazione() {
		return desTipoRendicontazione;
	}

	public Double getDoubleValNumericoApprovato() {

		Double d = 0.0d;

		if ("Illimitato".equalsIgnoreCase(this.valNumericoApprovato)) {
			d = 9.999999999E9;
		} else if (!"".equals(this.valNumericoApprovato)) {
			d = Double.parseDouble(this.valNumericoApprovato.replace(",", "."));
		}

		return d;
	}

	public Double getDoubleValNumericoAttuale() {

		Double d = 0.0d;

		if ("Illimitato".equalsIgnoreCase(this.valNumericoAttuale)) {
			d = 9.999999999E9;
		} else if (!"".equals(this.valNumericoAttuale)) {
			d = Double.parseDouble(this.valNumericoAttuale.replace(",", "."));
		}

		return d;
	}

	public Double getDoubleValNumericoProposto() {

		Double d = 0.0d;

		if ("Illimitato".equalsIgnoreCase(this.valNumericoProposto)) {
			d = 9.999999999E9;
		} else if (!"".equals(this.valNumericoProposto)) {
			d = Double.parseDouble(this.valNumericoProposto.replace(",", "."));
		}

		return d;
	}

	public Double getDoubleValNumPostConvApprovato() {

		Double d = 0.0d;

		if ("Illimitato".equalsIgnoreCase(this.valNumericoPostConvApprovato)) {
			d = 9.999999999E9;
		} else if (!"".equals(this.valNumericoPostConvApprovato)) {
			d = Double.parseDouble(
					this.valNumericoPostConvApprovato.replace(",", "."));
		}

		return d;
	}

	public Double getDoubleValNumPostConvProposto() {

		Double d = 0.0d;

		if ("Illimitato".equalsIgnoreCase(this.valNumericoPostConvProposto)) {
			d = 9.999999999E9;
		} else if (!"".equals(this.valNumericoPostConvProposto)) {
			d = Double.parseDouble(
					this.valNumericoPostConvProposto.replace(",", "."));
		}

		return d;
	}

	// ------------------------------------------------------------------
	// LISTA CONTROLLATE DEFAULT
	// ------------------------------------------------------------------

	public String getDriver1RilevatoDesc() {
		return driver1RilevatoDesc;
	}

	public String getDriver2RilevatoDesc() {
		return driver2RilevatoDesc;
	}

	public String getDS_CONDIZIONE_MACROGRUPPO() {
		return DS_CONDIZIONE_MACROGRUPPO;
	}

	public String getDS_CONDIZIONE_SOTTOGRUPPO() {
		return DS_CONDIZIONE_SOTTOGRUPPO;
	}

	public String getDS_SECONDO_DRIVER() {
		return DS_SECONDO_DRIVER;
	}

	public int getDurataBDR_Selezionata() {
		return durataBDR_Selezionata;
	}

	// ------------------------------------------------------------------
	// LISTA CONTROLLATE IN FASE DI COMPILAZIONE PROPOSTA
	// ------------------------------------------------------------------

	public String getDurataRollingApprovato() {
		return durataRollingApprovato;
	}

	public String getDurataRollingAttuale() {
		return durataRollingAttuale;
	}

	public String getDurataRollingMax() {
		return durataRollingMax;
	}

	public String getDurataRollingProposto() {
		return durataRollingProposto;
	}

	public ArrayList getElencoSottocondizioni() {
		return elencoSottocondizioni;
	}

	public String getEsitoCondizione() {
		return this.esitoCondizione;
	}

	// ------------------------------------------------------------------
	// LISTA CORRELATE
	// ------------------------------------------------------------------

	public String getFacoltaApice() {
		return facoltaApice;
	}

	public String getFacoltaUoSup() {
		return facoltaUoSup;
	}

	public String getFacoltaUoSupParametrata() {
		return facoltaUoSupParametrata;
	}

	public int getFamigliaCond() {
		return famigliaCond;
	}

	public String getFasceJSON() {
		return fasceJSON;
	}

//	public FasceSuConvenzione getFasceSuConvenzioneApprovato() {
//		return fasceSuConvenzioneApprovato;
//	}
//
//	public FasceSuConvenzione getFasceSuConvenzioneProposto() {
//		return fasceSuConvenzioneProposto;
//	}

	public String getFlagBdrInPerdita() {
		return flagBdrInPerdita;
	}

	// ------------------------------------------------------------------
	// LISTA INCOMPATIBILI
	// ------------------------------------------------------------------

	public String getFlagBlindatura() {
		return flagBlindatura;
	}

	public String getFlagCoerenza() {
		return flagCoerenza;
	}

	public String getFlagCondizioneModificata() {
		return flagCondizioneModificata;
	}

	public String getFlagCovenantCondizione() {
		return flagCovenantCondizione;
	}

	public String getFlagCovenantSottogruppo() {
		return flagCovenantSottogruppo;
	}

	public String getFlagDisabilitaMonitoraggio() {
		return flagDisabilitaMonitoraggio;
	}

	public String getFlagFasce() {
		return flagFasce;
	}

	public String getFlagObbligatoriaMlt() {
		return flagObbligatoriaMlt;
	}

	public String getFlagPdrCappatoFloorato() {
		return flagPdrCappatoFloorato;
	}

	public String getFlagPdrPrezzoApplicato() {
		return FlagPdrPrezzoApplicato;
	}

	public String getFlagPeggiorativa() {
		return flagPeggiorativa;
	}

	public String getFlagPilotaBdrInPerdita() {
		return flagPilotaBdrInPerdita;
	}

	public String getFlagPrevedePersonalizzatoConsigliato() {
		return flagPrevedePersonalizzatoConsigliato;
	}

	public String getFormaTecnicaPrange() {
		String formaTecnicaPrange = "";
		if (formaTecnicaPrangeHost != null
				&& formaTecnicaPrangeHost.length() > 0) {
			String[] arrayFormaTecnicaPrangeHost = this.formaTecnicaPrangeHost
					.split(";");
			if (arrayFormaTecnicaPrangeHost.length > 0)
				formaTecnicaPrange = arrayFormaTecnicaPrangeHost[0];
		}
		return formaTecnicaPrange;
	}

	public String getFormaTecnicaPrangeHost() {
		return formaTecnicaPrangeHost;
	}

	public String getFormatoCifreDecimali() {
		return formatoCifreDecimali;
	}

	public String getFormatoCifreIntere() {
		return formatoCifreIntere;
	}

	public String getFormulaApprovata() {
		return formulaApprovata;
	}

	public String getFormulaApprovataPostConvenzione() {
		return formulaApprovataPostConvenzione;
	}

	public String getFormulaAttuale() {
		return formulaAttuale;
	}

	public String getFormulaParametriRollingApprovati() {
		return formulaParametriRollingApprovati;
	}

	public String getFormulaParametriRollingAttuali() {
		return formulaParametriRollingAttuali;
	}

	public String getFormulaParametriRollingProposti() {
		return formulaParametriRollingProposti;
	}

	public String getFormulaPostConvenzione() {
		return formulaPostConvenzione;
	}

	public String getFormulaProposta() {
		return formulaProposta;
	}

	public String getFormulaPropostaPostConvenzione() {
		return formulaPropostaPostConvenzione;
	}

	public String getFormulaStandard() {
		return formulaStandard;
	}

	public String getGestioneDatePos() {
		return gestioneDatePos;
	}

	public Hashtable getHashControllateDefault() {
		return this.hashControllateDefault;
	}

	public Hashtable getHashControllateGerarchia() {
		return hashControllateGerarchia;
	}

	public Hashtable getHashControllateInCompilaProposta() {
		return this.hashControllateInCompilaProposta;
	}

	public String getIdCondizionePrange() {
		return idCondizionePrange;
	}

	public int getIdCovenantInEstinzione() {
		return idCovenantInEstinzione;
	}

	public Long getIdLineaPrange() {
		return idLineaPrange;
	}

	public Long getIdPraticaPrange() {
		return idPraticaPrange;
	}

	public Long getIdScenarioPrange() {
		return idScenarioPrange;
	}

	public double getImportoBDR_A() {
		return importoBDR_A;
	}

	public double getImportoBDR_Da() {
		return importoBDR_Da;
	}

	public String getIndCapoFila() {
		return indCapoFila;
	}

	public String getIndCapoFilaTecnica() {
		return indCapoFilaTecnica;
	}

	public String getIndCondizioneInderogabile() {
		if (this.codiceCondizioneInderogabile != null
				&& this.codiceCondizioneInderogabile.equals("PS"))
			return "S";
		else
			return "N";
	}

	public String getIndCondizionePriceRange() {
		return indCondizionePriceRange;
	}

	public String getIndCondizioneTassoSpread() {
		return indCondizioneTassoSpread;
	}

	public String getIndControlloCrescenza() {
		return indControlloCrescenza;
	}

	public String getIndEsclVecchiaBersani() {
		return indEsclVecchiaBersani;
	}

	public String getIndicatoreRegime() {
		return indicatoreRegime;
	}

	public String getIndPresenzaStandard() {
		return indPresenzaStandard;
	}

	public String getIndPresenzaValoreTrimestrePrec() {
		return indPresenzaValoreTrimestrePrec;
	}

	public String getIndScadenzaObbligatoria() {
		return indScadenzaObbligatoria;
	}

	public String getIndStampaBersani() {
		return indStampaBersani;
	}

	public String getIndStampaPresenteCovenant() {
		return indStampaPresenteCovenant;
	}

	public String getIndTestoLibero() {
		return indTestoLibero;
	}

	public String getIndTipoCorr() {
		return indTipoCorr;
	}

	public String getIndValore() {
		return indValore;
	}

	public String getIndValorePDR() {
		return indValorePDR;
	}

	public String getIndVersoMigliorativo() {
		return indVersoMigliorativo;
	}

	public String getIndVersoMigliorativoTassoCreditoreBDR() {
		return indVersoMigliorativoTassoCreditoreBDR;
	}

//	public InfoSelezionabilitaScollegabilita getInfoSelezionabilitaScollegabilita() {
//		return infoSelezionabilitaScollegabilita;
//	}

	public ArrayList getListaCodSottocondizioni() {
		return listaCodSottocondizioni;
	}

	public ArrayList<Condizione> getListaCondizioniOutGER() {
		return listaCondizioniOutGER;
	}

	public ArrayList<CondizioneDeroga> getListaControllate() {
		return listaControllate;
	}

	public ArrayList getListaControllateDefault() {
		return this.listaControllateDefault;
	}

	public ArrayList getListaControllateInCompilaProposta() {
		return this.listaControllateInCompilaProposta;
	}

	public ArrayList getListaCorrelate() {
		return this.listaCorrelate;
	}

	public ArrayList getListaCorrelateFull() {
		return this.listaCorrelate;
	}

//	public ArrayList<Opzione> getListaDurateAmmesseBDR() {
//		return listaDurateAmmesseBDR;
//	}

	public ArrayList getListaIncompatibili() {
		return this.listaIncompatibili;
	}

	public String getListaTipiPropostaNonSelezionabile() {
		return listaTipiPropostaNonSelezionabile;
	}

//	public ArrayList<CondizioneDerogaPricing> getListFiglie() {
//		return listFiglie;
//	}

	public ArrayList getListini() {
		return listini;
	}

	public int getLivelloApplicativo() {
		return livelloApplicativo;
	}

	public String getLivelloGerarchia() {
		return livelloGerarchia;
	}

	public String getMacroGruppo() {
		return macroGruppo;
	}

	public String getMaxDataDeco() {
		return maxDataDeco;
	}

	public int getMaxMesiScadenzaObbligatoria() {
		return maxMesiScadenzaObbligatoria;
	}

	public String getMaxScadenzaObbligatoria() {
		return maxScadenzaObbligatoria;
	}

	public String getMessaggioCondizione() {
		return this.messaggioCondizione;
	}

	public String getMessaggioErrore() {
		return messaggioErrore;
	}

	public String getMinDataDeco() {
		return minDataDeco;
	}

	public int getMinMesiScadenzaObbligatoria() {
		return minMesiScadenzaObbligatoria;
	}

	public String getMinScadenzaObbligatoria() {
		return minScadenzaObbligatoria;
	}

	public String getMoltiplicatoreFamMerc() {
		return moltiplicatoreFamMerc;
	}

	public String getMoltiplicatoreRating() {
		return moltiplicatoreRating;
	}

	public String getMoltiplicatoreSegmento() {
		return moltiplicatoreSegmento;
	}

	public String getMoltiplicatoreSottoSegComm() {
		return moltiplicatoreSottoSegComm;
	}

	public String getMoltiplicatoreTerritoriale() {
		return moltiplicatoreTerritoriale;
	}

	public String getNotaCovenant() {
		return notaCovenant;
	}

	public int getNumeroFasciaBeneficio() {
		return this.numeroFasciaConvenzione;
	}

	public int getNumeroFasciaConvenzione() {
		return numeroFasciaConvenzione;
	}

	public String getNumOrdine() {
		return numOrdine;
	}

	public int getNumSottocondizioni() {
		return numSottocondizioni;
	}

	public String getPacchettoCorr() {
		return pacchettoCorr;
	}

	public String getPacchettoCorrTecniche() {
		return pacchettoCorrTecniche;
	}

//	public ParametriCondizioneDeroga getParametriCondizioneDeroga() {
//		return this.parametriCondizioneDeroga;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaApprovati() {
//		return this.parametriCondizioneDerogaApprovati;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaAttuali() {
//		return parametriCondizioneDerogaAttuali;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaPostConvApprovati() {
//		return parametriCondizioneDerogaPostConvApprovati;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaPostConvProposti() {
//		return parametriCondizioneDerogaPostConvProposti;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaRollingApprovati() {
//		return parametriCondizioneDerogaRollingApprovati;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaRollingAttuali() {
//		return parametriCondizioneDerogaRollingAttuali;
//	}
//
//	public ParametriCondizioneDeroga getParametriCondizioneDerogaRollingProposti() {
//		return parametriCondizioneDerogaRollingProposti;
//	}
//
//	public ParametriCondizioneDeroga getParametriPostConvenzione() {
//		return parametriPostConvenzione;
//	}

	public String getPERC_NEW_OPER() {
		return PERC_NEW_OPER;
	}

	public int getPesoLivelloDeroga() {
		return pesoLivelloDeroga;
	}

	public String getPresenzaEva() {
		return presenzaEva;
	}

	public String getPrevedeEva() {
		return prevedeEva;
	}

	public int getProgressivoSequenzaMLT() {
		return progressivoSequenzaMLT;
	}

	public String getProvenienza() {
		return provenienza;
	}

	public String getREMUN_PRD_CONV() {
		return REMUN_PRD_CONV;
	}

	public String getSegnoBeneficio() {
		return segnoBeneficio;
	}

	public String getSegnoEva() {
		return segnoEva;
	}

	public String getSegnoValNumericoApprovato() {
		return segnoValNumericoApprovato;
	}

	public String getSegnoValNumericoAttuale() {
		return segnoValNumericoAttuale;
	}

	public String getSegnoValNumericoProposto() {
		return segnoValNumericoProposto;
	}

	public String getSegnoValoreAttualeGerarchia() {
		return segnoValoreAttualeGerarchia;
	}

	public String getSegnoValoreStandard() {
		return segnoValoreStandard;
	}

	public String getSegnoValoreStandardGerarchia() {
		return segnoValoreStandardGerarchia;
	}

	public String getSegnoValoreTrimestrePrec() {
		return segnoValoreTrimestrePrec;
	}

	public String getSottoGruppo() {
		return sottoGruppo;
	}

	public String getStatoGerarchia() {
		return statoGerarchia;
	}

	public String getStrCondizioniGerarchia() {
		return strCondizioniGerarchia;
	}

	public String getStrControllate() {
		return strControllate;
	}

	public String getStrControllateGerarchia() {
		return strControllateGerarchia;
	}

	public String getStrControllatePrimoLivelloGerarchia() {
		return strControllatePrimoLivelloGerarchia;
	}

	public String getStrCorrelate() {
		return strCorrelate;
	}

	public String getStrCorrelateAll() {
		return strCorrelateAll;
	}

	public String getStrCorrelateFull() {
		return strCorrelateFull;
	}

	public String getStrCorrelateGR() {
		return strCorrelateGR;
	}

	public String getStrCorrelateLight() {
		return strCorrelateLight;
	}

	public String getStrCorrelateTecniche() {
		return strCorrelateTecniche;
	}

	public String getStringaFacolta() {
		double facolta = (new Double(
				(null != this.stringaFacolta && !this.stringaFacolta.equals(""))
						? this.stringaFacolta
						: "0")).doubleValue();
		if (facolta <= 0) {
			return "nd";
		} else {
			return Number.toStringConverter(facolta);
		}
	}

	public String getStringaFacoltaParametrata() {
		return stringaFacoltaParametrata;
	}

	public String getStringaFacoltaUoSup() {
		double facolta = (new Double(
				(null != this.facoltaUoSup && !this.facoltaUoSup.equals(""))
						? this.facoltaUoSup
						: "0")).doubleValue();
		if (facolta <= 0) {
			return "nd";
		} else {
			return Number.toStringConverter(facolta);
		}
	}

	public String getStringListaControllateDefault() {
		String stringListaControllateDefault = "";
		Iterator i = (this.listaControllateDefault).iterator();
		while (i.hasNext()) {
			if (stringListaControllateDefault.equals(""))
				stringListaControllateDefault = (String) i.next();
			else
				stringListaControllateDefault += ";" + (String) i.next();
		}
		return stringListaControllateDefault;
	}

	public String getStringListaControllateInCompilaProposta() {
		String stringListaControllateInCompilaProposta = "";
		Iterator i = (this.listaControllateInCompilaProposta).iterator();

		while (i.hasNext()) {
			Object o = i.next();
			if (o instanceof String) {
				if (stringListaControllateInCompilaProposta.equals(""))
					stringListaControllateInCompilaProposta = (String) o;
				else
					stringListaControllateInCompilaProposta += ";" + (String) o;
			} else {
				if (stringListaControllateInCompilaProposta.equals(""))
					stringListaControllateInCompilaProposta = ((CondizioneDeroga) o).condizione
							.getCodiceCondizione();
				else
					stringListaControllateInCompilaProposta += ";"
							+ ((CondizioneDeroga) o).condizione
									.getCodiceCondizione();
			}
		}
		return stringListaControllateInCompilaProposta;
	}

	public String getStringListaCorrelate() {
		String stringListaCorrelate = "";
		Iterator i = (this.listaCorrelate).iterator();
		while (i.hasNext()) {
			if (stringListaCorrelate.equals(""))
				stringListaCorrelate = (String) i.next();
			else
				stringListaCorrelate += ";" + (String) i.next();
		}
		return stringListaCorrelate;
	}

	public String getStringListaCorrelateFull() {
		String stringListaCorrelateFull = "";
		Iterator i = (this.listaCorrelateFull).iterator();
		while (i.hasNext()) {
			if (stringListaCorrelateFull.equals(""))
				stringListaCorrelateFull = (String) i.next();
			else
				stringListaCorrelateFull += ";" + (String) i.next();
		}
		return stringListaCorrelateFull;
	}

	public String getStringListaIncompatibili() {
		String stringListaIncompatibili = "";
		Iterator i = (this.listaIncompatibili).iterator();
		while (i.hasNext()) {
			if (stringListaIncompatibili.equals(""))
				stringListaIncompatibili = (String) i.next();
			else
				stringListaIncompatibili += ";" + (String) i.next();
		}
		return stringListaIncompatibili;
	}

	public String getStrOrigineControllate() {
		return strOrigineControllate;
	}

	public String getStrValoreAttualeCondizioniGerarchia() {
		return strValoreAttualeCondizioniGerarchia;
	}

	public String getTIPO_OPERAZIONE() {
		return TIPO_OPERAZIONE;
	}

	public String getTIPO_OPERAZIONE_PCV() {
		return TIPO_OPERAZIONE_PCV;
	}

	public String getTipoCodAggregOriginAtt() {
		return tipoCodAggregOriginAtt;
	}

	public String getTipoCondizione() {
		return tipoCondizione;
	}

	public String getTipoCondizioneAttMst() {
		return tipoCondizioneAttMst;
	}

	public String getTipoCondizionePromo() {
		return tipoCondizionePromo;
	}

	public String getTipoControllata() {
		return tipoControllata;
	}

	public String getTipoDeroga() {
		return tipoDeroga;
	}

	public String getTipoEntitaAdesione() {
		return tipoEntitaAdesione;
	}

	public String getTipologiaAggregazione() {
		return tipologiaAggregazione;
	}

	public String getTipoOperazioneObbligatoria() {
		return tipoOperazioneObbligatoria;
	}

	public String getTipoRendicontazione() {
		return tipoRendicontazione;
	}

	public String getTipoRolling() {
		return TIPO_OPERAZIONE_ROLLING;
	}

	public String getTipoValore() {
		return tipoValore;
	}

	public String getTipoValoreFromDecoder() {
		return tipoValoreFromDecoder;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public String getValCodiceApprovato() {
		return valCodiceApprovato;
	}

	public String getValCodiceAttuale() {
		return valCodiceAttuale;
	}

	public String getValCodicePostConvApprovato() {
		return valCodicePostConvApprovato;
	}

	public String getValCodicePostConvProposto() {
		return valCodicePostConvProposto;
	}

	public String getValCodiceProposto() {
		return valCodiceProposto;
	}

	public String getValCodiceRollingApprovato() {
		return valCodiceRollingApprovato;
	}

	public String getValCodiceRollingAttuale() {
		return valCodiceRollingAttuale;
	}

	public String getValCodiceRollingProposto() {
		return valCodiceRollingProposto;
	}

	public String getValCodiceStandard() {
		return valCodiceStandard;
	}

	public String getValNumericoApprovato() {
		return valNumericoApprovato;
	}

	public String getValNumericoApprovatoConSegno() {
		String segno = "";
		if (this.getSegnoValNumericoApprovato() != null
				&& this.getSegnoValNumericoApprovato().equals("-"))
			segno = "-";
		return segno + valNumericoApprovato;
	}

	public String getValNumericoAttuale() {
		return valNumericoAttuale;
	}

	public String getValNumericoAttualeGerarchia() {
		return valNumericoAttualeGerarchia;
	}

	public String getValNumericoPostConvApprovato() {
		return valNumericoPostConvApprovato;
	}

	public String getValNumericoPostConvProposto() {
		return valNumericoPostConvProposto;
	}

	public String getValNumericoProposto() {
		return valNumericoProposto;
	}

	public String getValNumericoPropostoConSegno() {
		String segno = "";
		if (this.getSegnoValNumericoProposto() != null
				&& this.getSegnoValNumericoProposto().equals("-"))
			segno = "-";
		return segno + valNumericoProposto;
	}

	public String getValNumericoRollingApprovato() {
		return valNumericoRollingApprovato;
	}

	public String getValNumericoRollingAttuale() {
		return valNumericoRollingAttuale;
	}

	public String getValNumericoRollingProposto() {
		return valNumericoRollingProposto;
	}

	public String getValNumericoStandard() {
		return valNumericoStandard;
	}

	public String getValNumericoStandardGerarchia() {
		return valNumericoStandardGerarchia;
	}

	public String getVALORE_DRIVER() {
		return VALORE_DRIVER;
	}

	public String getVALORE_SECONDO_DRIVER() {
		return VALORE_SECONDO_DRIVER;
	}

	public String getValoreCanaleProposta() {
		return valoreCanaleProposta;
	}

	public double getValoreCondizioneCAP() {
		return valoreCondizioneCAP;
	}

	public double getValoreCondizioneFLOOR() {
		return valoreCondizioneFLOOR;
	}

	public String getValoreDerogaPrevistoPerControllata() {
		return valoreDerogaPrevistoPerControllata;
	}

	public String getValoreEva() {
		return valoreEva;
	}

	public String getValoreMassimo() {
		return valoreMassimo;
	}

	public String getValoreMinimo() {
		return valoreMinimo;
	}

	public String getValoreNonPiuProponibile() {
		return valoreNonPiuProponibile;
	}

	public String getValorePostConvDesc() {
		return valorePostConvDesc;
	}

	public String getValoreRegolaGerarchia() {
		return valoreRegolaGerarchia;
	}

	public String getValoreTestoAttuale() {
		return valoreTestoAttuale;
	}

	public String getValoreTestoAttuale_SHORT() {
		String valAttSHORT = "";
		if (valoreTestoAttuale.length() > 15)
			valAttSHORT = valoreTestoAttuale.substring(0, 15);
		else
			valAttSHORT = valoreTestoAttuale;
		return valAttSHORT;
	}

	public String getValoreTestoProposto() {
		return valoreTestoProposto;
	}

	public String getValoreTestoProposto_SHORT() {
		String valPropSHORT = "";
		if (valoreTestoProposto.length() > 15)
			valPropSHORT = valoreTestoProposto.substring(0, 15);
		else
			valPropSHORT = valoreTestoProposto;
		return valPropSHORT;
	}

	public String getValoreTestoStandard() {
		return valoreTestoStandard;
	}

	public String getValoreTrimestrePrec() {
		return valoreTrimestrePrec;
	}

	public ArrayList getValoriDescrizioniCodice() {
		return valoriDescrizioniCodice;
	}

	public String getValParametro() {
		return valParametro;
	}

	public String getValParametroSegno() {
		return valParametroSegno;
	}

	public String getValTassoCreditorePerSalvadanaio() {
		return valTassoCreditorePerSalvadanaio;
	}

	public String getValuePrangeHost() {
		return this.getIdPraticaPrange() + "-" + this.getIdLineaPrange() + "-"
				+ this.getIdScenarioPrange() + "-"
				+ this.getFormaTecnicaPrange().trim() + "-"
				+ this.getCodCondizionePrange().trim();
	}

	public String getVisibilitaAbc() {
		return visibilitaAbc;
	}

	public boolean isAssoggettataARegimeSconto() {
		return assoggettataARegimeSconto;
	}

	public boolean isBlindaturaNonDerogabileSuConvenzione() {
		return isBlindaturaNonDerogabileSuConvenzione;
	}

	public boolean isBlindaturaSWITCHNonDerogata() {
		return blindaturaSWITCHNonDerogata;
	}

	public boolean isCambioTrimestreBaseline() {
		return cambioTrimestreBaseline;
	}

	public boolean isChecked() {
		return this.checked;
	}

	public boolean isCondizioneGestionePrivateTop() {
		return condizioneGestionePrivateTop;
	}

	public boolean isCondizionePriceLab() {
		return condizionePriceLab;
	}

	public boolean isCondizioneSWITCH() {
		return this.condizioneSWITCH;
	}

	public boolean isCondizioneTestoLibero() {
		boolean retval = false;
		if (this.condizione.getCodiceCondizione().matches("^TL.*"))
			retval = true;
		return retval;
	}

	public boolean isCondizioneTipoCliente() {
		return condizioneTipoCliente;
	}

	public boolean isControllata() {
		return this.controllata;
	}

	public boolean isControllataCondizioneSWITCH() {
		return this.controllataCondizioneSWITCH;
	}

	public boolean isControllataForfait() {
		return controllataForfait;
	}

	public boolean isControllataScaglione() {
		return controllataScaglione;
	}

	public boolean isControllataTasso() {
		return controllataTasso;
	}

	public boolean isControllataCommissione() {
		return controllataCommissione;
	}

	public boolean isControllateParametrate() {
		return this.controllateParametrate;
	}

	public boolean isCorrelata() {
		return correlata;
	}

	public boolean isDerogaObbligata() {
		return derogaObbligata;
	}

	public boolean isEva() {
		return eva;
	}

	public boolean isFaseNonEmissioneInRipristinaProposta() {
		return this.faseNonEmissioneInRipristinaProposta;
	}

	public boolean isFlagCovenantMacroGruppo() {
		return flagCovenantMacroGruppo;
	}

	public boolean isFlagEvaNonObbligatorio() {
		return flagEvaNonObbligatorio;
	}

	public boolean isIndTITmanualeBDR() {
		return indTITmanualeBDR;
	}

	public boolean isParametrabile() {
		return this.parametrabile;
	}

	public boolean isParametrata() {
		return this.parametrata;
	}

	public boolean isParametrataConGestioneNormaleInCompilazione() {
		return parametrataConGestioneNormaleInCompilazione;
	}

	public boolean isPeggiorativa() {
		return peggiorativa;
	}

	public boolean isPenaleEstinzioneAzzerataBDR() {
		return penaleEstinzioneAzzerataBDR;
	}

	public boolean isPopupFasceModificatoInIter() {
		return popupFasceModificatoInIter;
	}

	public boolean isPopupPerConvenzioneModificato() {
		return popupPerConvenzioneModificato;
	}

	public boolean isPresenteCovenant() {
		return presenteCovenant;
	}

	public boolean isPresenteCovenantAllaData() {
		return presenteCovenantAllaData;
	}

	public boolean isPresenteCovenantApprovato() {
		return presenteCovenantApprovato;
	}

	public boolean isPresenteCovenantAttuale() {
		return presenteCovenantAttuale;
	}

	/**
	 * @return the presenteCovenantNonEstinguibile
	 */
	public boolean isPresenteCovenantNonEstinguibile() {
		return presenteCovenantNonEstinguibile;
	}

	public boolean isPresenteCovenantNonVendibile() {
		return presenteCovenantNonVendibile;
	}

	public boolean isPresenteCovenantProposto() {
		return presenteCovenantProposto;
	}

	public boolean isPresenteDerogaRollingApprovato() {
		return presenteDerogaRollingApprovato;
	}

	public boolean isPresenteDerogaRollingProposto() {
		return presenteDerogaRollingProposto;
	}

	public boolean isPresenteModifcaFinessMLT() {
		return presenteModifcaFinessMLT;
	}

	public boolean isPresenteValorePostConv() {
		return isPresenteValorePostConv;
	}

	public boolean isPresentiFasceSuConvenzioneApprovato() {
		return presentiFasceSuConvenzioneApprovato;
	}

	public boolean isPresentiFasceSuConvenzioneProposto() {
		return presentiFasceSuConvenzioneProposto;
	}

	public boolean isPresenzaFasceAllaData() {
		return presenzaFasceAllaData;
	}

	public boolean isPresenzaMoltiplicatori() {
		return PresenzaMoltiplicatori;
	}

	public boolean isPresenzaRollingAllaData() {
		return presenzaRollingAllaData;
	}

	public boolean isPrevedeCovenants() {
		return prevedeCovenants;
	}

	public boolean isPrimaControllata() {
		return this.primaControllata;
	}

	public boolean isProvenienzaDaHost() {
		return this.provenienzaDaHost;
	}

	public boolean isRegime() {
		return this.regime;
	}

	public boolean isRegimeIsTassoPlus() {
		return regimeIsTassoPlus;
	}

	public boolean isRegimeSconto() {
		return regimeSconto;
	}

	public boolean isRiferimentoSalvadanio() {
		return riferimentoSalvadanio;
	}

	public boolean isScollegabileDaPropostaNormale() {
		return scollegabileDaPropostaNormale;
	}

	public boolean isScollegamentoAttrGKCondH() {
		return scollegamentoAttrGKCondH;
	}

	public boolean isSelezionabile() {
		return selezionabile;
	}

	public boolean isSoloScollegabileDaPropostaNormale() {
		return soloScollegabileDaPropostaNormale;
	}

	public boolean isSottocondizione() {
		return sottocondizione;
	}

	public boolean isSpreadBDR() {
		return spreadBDR;
	}

	public boolean isTassoPlus() {
		return tassoPlus;
	}

	public boolean isUnicaSelezionabileDb() {
		return unicaSelezionabileDb;
	}

	public boolean isUnicaSelezionabileHost() {
		return unicaSelezionabileHost;
	}

	public boolean isValoreTestoAttuale_LINK() {
		return valoreTestoAttuale.length() > 15;
	}

	public boolean isViewParametrataProposalCheckbox() {
		return this.viewParametrataProposalCheckbox;
	}

	public boolean isViewProposalCheckbox() {
		return this.viewProposalCheckbox;
	}

	public boolean isVincoliValorizzati() {
		return vincoliValorizzati;
	}

	public void setAbiProvenienza(String abiProvenienza) {
		if (abiProvenienza != null)
			this.abiProvenienza = abiProvenienza;
	}

	public void setAssoggettataARegimeSconto(
			boolean assoggettataARegimeSconto) {
		this.assoggettataARegimeSconto = assoggettataARegimeSconto;
	}

	public void setAutonomia(String autonomia) {
		this.autonomia = (null != autonomia) ? autonomia : "";
	}

	public void setAzione(String azione) {
		this.azione = (null != azione) ? azione : "";
	}

//	public void setBeneficioInEssereCovenant(
//			BeneficioInEssere beneficioInEssereCovenant) {
//		this.beneficioInEssereCovenant = beneficioInEssereCovenant;
//	}

	public void setBlindaturaNonDerogabileSuConvenzione(
			boolean isBlindaturaNonDerogabileSuConvenzione) {
		this.isBlindaturaNonDerogabileSuConvenzione = isBlindaturaNonDerogabileSuConvenzione;
	}

	public void setBlindaturaSWITCHNonDerogata(
			boolean blindaturaSWITCHNonDerogata) {
		this.blindaturaSWITCHNonDerogata = blindaturaSWITCHNonDerogata;
	}

	public void setBonusVenduto(String bonusVenduto) {
		this.bonusVenduto = bonusVenduto;
	}

	public void setCambioTrimestreBaseline(boolean cambioTrimestreBaseline) {
		this.cambioTrimestreBaseline = cambioTrimestreBaseline;
	}

	public void setCD_CONDIZIONE_MACROGRUPPO(String cd_condizione_macrogruppo) {
		if (cd_condizione_macrogruppo != null)
			CD_CONDIZIONE_MACROGRUPPO = cd_condizione_macrogruppo;
	}

	public void setCD_CONDIZIONE_SOTTOGRUPPO(String cd_condizione_sottogruppo) {
		if (cd_condizione_sottogruppo != null)
			CD_CONDIZIONE_SOTTOGRUPPO = cd_condizione_sottogruppo;
	}

	public void setCD_SECONDO_DRIVER_TIPO(String cd_secondo_driver_tipo) {
		if (cd_secondo_driver_tipo != null)
			CD_SECONDO_DRIVER_TIPO = cd_secondo_driver_tipo;
	}

	public void setCD_SECONDO_DRIVER_UDM(String cd_secondo_driver_udm) {
		if (cd_secondo_driver_udm != null)
			CD_SECONDO_DRIVER_UDM = cd_secondo_driver_udm;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setCodAggregOriginAtt(String codAggregOriginAtt) {
		this.codAggregOriginAtt = codAggregOriginAtt;
	}

	public void setCodCondIncompatibili(String codCondIncompatibili) {
		this.codCondIncompatibili = codCondIncompatibili;
	}

	public void setCodCorrelataPadre(String codCorrelataPadre) {
		this.codCorrelataPadre = (null != codCorrelataPadre)
				? codCorrelataPadre
				: "";
	}

	public void setCodDivisa(String codDivisa) {
		if (null != codDivisa)
			this.codDivisa = codDivisa;
	}

	public void setCodiceCondizione(String codiceCondizione) {
		if (null != codiceCondizione) {
			this.codiceCondizione = codiceCondizione;
			this.condizione.setCodiceCondizione(codiceCondizione);
		}
	}

	public void setCodiceCondizioneInderogabile(
			String codiceCondizioneInderogabile) {
		if (codiceCondizioneInderogabile == null)
			this.codiceCondizioneInderogabile = "";
		else
			this.codiceCondizioneInderogabile = codiceCondizioneInderogabile
					.trim();
	}

	public void setCodiceErrore(String codiceErrore) {
		if (null != codiceErrore)
			this.codiceErrore = codiceErrore;
	}

	public void setCodiceFasciaConvenzione(String codiceFasciaConvenzione) {
		this.codiceFasciaConvenzione = codiceFasciaConvenzione;
	}
	public void setCodiceIdentificativo(String codiceIdentificativo) {
		this.codiceIdentificativo = codiceIdentificativo;
	}

	public void setCodiceProvenienza(String codiceProvenienza) {
		this.codiceProvenienza = codiceProvenienza;
	}
	public void setCodiceProvenienzaDesc(String codiceProvenienzaDesc) {
		this.codiceProvenienzaDesc = codiceProvenienzaDesc;
	}

	public void setCodiceRegime(String codiceRegime) {
		if (codiceRegime != null)
			this.codiceRegime = codiceRegime;
	}

	public void setCodiceRegimeSconto(String codiceRegimeSconto) {
		this.codiceRegimeSconto = codiceRegimeSconto;
	}

	public void setCodiceSottocondizione(String codiceSottocondizione) {
		if (null != codiceSottocondizione) {
			this.codiceSottocondizione = codiceSottocondizione;
			this.condizione.setCodiceSottocondizione(codiceSottocondizione);
		}
	}

	public void setCodiceTipoCovenantAttuale(String codiceTipoCovenantAttuale) {
		this.codiceTipoCovenantAttuale = codiceTipoCovenantAttuale;
	}

	public void setCodiceValoreAttualeGerarchia(
			String codiceValoreAttualeGerarchia) {
		this.codiceValoreAttualeGerarchia = codiceValoreAttualeGerarchia;
	}

	public void setCodiceValoreStandardGerarchia(
			String codiceValoreStandardGerarchia) {
		this.codiceValoreStandardGerarchia = codiceValoreStandardGerarchia;
	}

	public void setCodListino(String codListino) {
		if (codListino != null)
			this.codListino = codListino;
	}

	public void setCodOrigineCondizAttuale(String codOrigineCondizAttuale) {
		if (null != codOrigineCondizAttuale)
			this.codOrigineCondizAttuale = codOrigineCondizAttuale;
	}

	public void setCodVariazione(String codVariazione) {
		this.codVariazione = codVariazione;
	}
	public void setComposizioneDA(String composizioneDA) {
		this.composizioneDA = composizioneDA;
	}

	public void setCondizione(Condizione condizione) {
		this.condizione = condizione;
	}

	public void setCondizioneErrore(String condizioneErrore) {
		if (null != condizioneErrore)
			this.condizioneErrore = condizioneErrore;
	}

	public void setCondizioneGestionePrivateTop(
			boolean condizioneGestionePrivateTop) {
		this.condizioneGestionePrivateTop = condizioneGestionePrivateTop;
	}

	public void setCondizionePriceLab(boolean condizionePriceLab) {
		this.condizionePriceLab = condizionePriceLab;
	}

	public void setCondizionePrimoLivelloGerarchia(
			String condizionePrimoLivelloGerarchia) {
		if (condizionePrimoLivelloGerarchia != null)
			this.condizionePrimoLivelloGerarchia = condizionePrimoLivelloGerarchia;
	}

	public void setCondizioneRegolaGerarchia(String condizioneRegolaGerarchia) {
		if (condizioneRegolaGerarchia != null)
			this.condizioneRegolaGerarchia = condizioneRegolaGerarchia;
	}

	public void setCondizioneSWITCH(boolean isCondizioneSWITCH) {
		this.condizioneSWITCH = isCondizioneSWITCH;
	}

	public void setCondizioneTipoCliente(boolean condizioneTipoCliente) {
		this.condizioneTipoCliente = condizioneTipoCliente;
	}

	public void setCondRaggruppamento(String condRaggruppamento) {
		this.condRaggruppamento = condRaggruppamento;
	}

	public void setControllata(boolean controllata) {
		this.controllata = controllata;
	}

	public void setControllataCondizioneSWITCH(
			boolean isControllataCondizioneSWITCH) {

		this.controllataCondizioneSWITCH = isControllataCondizioneSWITCH;
	}

	public void setControllataForfait(boolean controllataForfait) {
		this.controllataForfait = controllataForfait;
	}

	public void setControllataScaglione(boolean controllataScaglione) {
		this.controllataScaglione = controllataScaglione;
	}

	public void setControllataTasso(boolean controllataTasso) {
		this.controllataTasso = controllataTasso;
	}

	public void setControllataCommissione(boolean controllataCommissione) {
		this.controllataCommissione = controllataCommissione;
	}

	public void setControllateParametrate(boolean controllateParametrate) {
		this.controllateParametrate = controllateParametrate;
	}

	public void setCONV_ALTRI_PRD(String conv_altri_prd) {
		if (conv_altri_prd != null)
			CONV_ALTRI_PRD = conv_altri_prd;
	}

	public void setCorrelata(boolean correlata) {
		this.correlata = correlata;
	}

//	public void setCovenantAllaData(Covenant covenantAllaData) {
//		if (covenantAllaData != null)
//			this.covenantAllaData = covenantAllaData;
//	}
//
//	public void setCovenantAttuale(Covenant covenantAttuale) {
//		if (covenantAttuale != null)
//			this.covenantAttuale = covenantAttuale;
//	}
//
//	public void setCovenantProposto(Covenant covenantProposto) {
//		if (covenantProposto != null)
//			this.covenantProposto = covenantProposto;
//	}
//
//	public void setCovenants(ArrayList<Covenant> covenants) {
//		if (covenants != null)
//			this.covenants = covenants;
//	}
//
//	public void setCovenantSelezionato(Covenant covenantSelezionato) {
//		this.covenantSelezionato = covenantSelezionato;
//	}

	public void setDataDecorrenzaApprovata(String dataDecorrenzaApprovata) {
		if (null != dataDecorrenzaApprovata)
			this.dataDecorrenzaApprovata = dataDecorrenzaApprovata;
	}

	public void setDataDecorrenzaAttuale(String dataDecorrenzaAttuale) {
		if (null != dataDecorrenzaAttuale)
			this.dataDecorrenzaAttuale = dataDecorrenzaAttuale;
	}

	public void setDataDecorrenzaProposta(String dataDecorrenzaProposta) {
		if (null != dataDecorrenzaProposta)
			this.dataDecorrenzaProposta = dataDecorrenzaProposta;
	}

	public void setDataDecorrenzaStandard(String dataDecorrenzaStandard) {
		if (dataDecorrenzaStandard != null)
			this.dataDecorrenzaStandard = dataDecorrenzaStandard;
	}

	public void setDataPubblicazioneGerarchia(
			String dataPubblicazioneGerarchia) {
		if (dataPubblicazioneGerarchia != null)
			this.dataPubblicazioneGerarchia = dataPubblicazioneGerarchia;
	}

	public void setDataRilevazione(String dataRilevazione) {
		this.dataRilevazione = dataRilevazione;
	}

	public void setDataScadenzaApprovata(String dataScadenzaApprovata) {
		if (null != dataScadenzaApprovata)
			this.dataScadenzaApprovata = dataScadenzaApprovata;
	}

	public void setDataScadenzaAttuale(String dataScadenzaAttuale) {
		if (null != dataScadenzaAttuale)
			this.dataScadenzaAttuale = dataScadenzaAttuale;
	}

	public void setDataScadenzaBDR_A(String dataScadenzaBDR_A) {
		this.dataScadenzaBDR_A = dataScadenzaBDR_A;
	}

	public void setDataScadenzaBDR_Da(String dataScadenzaBDR_Da) {
		this.dataScadenzaBDR_Da = dataScadenzaBDR_Da;
	}

	public void setDataScadenzaBDR_Selezionata(
			String dataScadenzaBDR_Selezionata) {
		if (dataScadenzaBDR_Selezionata != null)
			this.dataScadenzaBDR_Selezionata = dataScadenzaBDR_Selezionata;
	}

	public void setDataScadenzaProposta(String dataScadenzaProposta) {
		if (null != dataScadenzaProposta)
			this.dataScadenzaProposta = dataScadenzaProposta;
	}

	public void setDataScadenzaStandard(String dataScadenzaStandard) {
		if (dataScadenzaStandard != null)
			this.dataScadenzaStandard = dataScadenzaStandard;
	}

//	public void setDatiPartitaPortafoglio(
//			PartitaPortafoglio datiPartitaPortafoglio) {
//		if (null != datiPartitaPortafoglio)
//			this.datiPartitaPortafoglio = datiPartitaPortafoglio;
//	}
//
//	public void setDerogaConsentitaPresenzaCovenant(
//			Opzione derogaConsentitaPresenzaCovenant) {
//		if (derogaConsentitaPresenzaCovenant != null)
//			this.derogaConsentitaPresenzaCovenant = derogaConsentitaPresenzaCovenant;
//	}
//
//	public void setDerogaConsentitaPresenzaCovenantGerarchiaFiglie(
//			Opzione derogaConsentitaPresenzaCovenantGerarchiaFiglie) {
//		if (derogaConsentitaPresenzaCovenantGerarchiaFiglie != null)
//			this.derogaConsentitaPresenzaCovenantGerarchiaFiglie = derogaConsentitaPresenzaCovenantGerarchiaFiglie;
//	}

	public void setDerogaObbligata(boolean derogaObbligata) {
		this.derogaObbligata = derogaObbligata;
	}

	public void setDescAggValCodice(String descAggValCodice) {
		if (descAggValCodice != null)
			this.descAggValCodice = descAggValCodice;
	}

	public void setDescAggValCodice2(String descAggValCodice2) {
		if (descAggValCodice2 != null)
			this.descAggValCodice2 = descAggValCodice2;
	}

	public void setDescCodAggregOriginAtt(String descCodAggregOriginAtt) {
		this.descCodAggregOriginAtt = descCodAggregOriginAtt;
	}

	public void setDescCodiceApprovato(String descCodiceApprovato) {
		if (null != descCodiceApprovato)
			this.descCodiceApprovato = descCodiceApprovato;
	}

	public void setDescCodiceAttuale(String descCodiceAttuale) {
		if (null != descCodiceAttuale)
			this.descCodiceAttuale = descCodiceAttuale;
	}

	public void setDescCodiceAttualeSottocondizione_SHORT(
			String descCodiceAttualeSottocondizione_SHORT) {
		this.descCodiceAttualeSottocondizione_SHORT = descCodiceAttualeSottocondizione_SHORT;
	}

	public void setDescCodicePostConvApprovato(
			String descCodicePostConvApprovato) {
		this.descCodicePostConvApprovato = descCodicePostConvApprovato;
	}

	public void setDescCodicePostConvProposto(
			String descCodicePostConvProposto) {
		this.descCodicePostConvProposto = descCodicePostConvProposto;
	}

	public void setDescCodiceRollingApprovato(
			String descCodiceRollingApprovato) {
		this.descCodiceRollingApprovato = descCodiceRollingApprovato;
	}

	public void setDescCodiceRollingAttuale(String descCodiceRollingAttuale) {
		this.descCodiceRollingAttuale = descCodiceRollingAttuale;
	}

	public void setDescCodiceRollingProposto(String descCodiceRollingProposto) {
		this.descCodiceRollingProposto = descCodiceRollingProposto;
	}

	public void setDescCodiceStandard(String descCodiceStandard) {
		if (descCodiceStandard != null)
			this.descCodiceStandard = descCodiceStandard;
	}

	public void setDescCodiceValoreAttualeGerarchia(
			String descCodiceValoreAttualeGerarchia) {
		if (descCodiceValoreAttualeGerarchia != null)
			this.descCodiceValoreAttualeGerarchia = descCodiceValoreAttualeGerarchia;
	}

	public void setDescCodiceValoreStandardGerarchia(
			String descCodiceValoreStandardGerarchia) {
		if (descCodiceValoreStandardGerarchia != null)
			this.descCodiceValoreStandardGerarchia = descCodiceValoreStandardGerarchia;
	}

	public void setDescCondizione(String descCondizione) {
		if (null != descCondizione)
			this.descCondizione = descCondizione;
	}

	public void setDescCondizioneVis(String descCondizioneVis) {
		if (descCondizioneVis != null)
			this.descCondizioneVis = descCondizioneVis;
	}

	public void setDescFacoltaUoSup(String descFacoltaUoSup) {
		if (descFacoltaUoSup != null)
			this.descFacoltaUoSup = descFacoltaUoSup;
	}

	public void setIndControlloFacolta(String indControlloFacolta) {
		this.indControlloFacolta = indControlloFacolta;
	}

	public void setDescMacroGruppo(String descMacroGruppo) {
		if (descMacroGruppo != null)
			this.descMacroGruppo = descMacroGruppo;
	}

	public void setDesComposizioneDA(String desComposizioneDA) {
		this.desComposizioneDA = desComposizioneDA;
	}

	public void setDescOrigineCondizAttuale(String descOrigineCondizAttuale) {
		if (null != descOrigineCondizAttuale)
			this.descOrigineCondizAttuale = descOrigineCondizAttuale;
	}

	public String setDescOrigineCondizAttualeShort() {
		this.descOrigineCondizAttualeShort = this.descOrigineCondizAttuale;
		if (this.descOrigineCondizAttuale.length() > 9) {
			this.descOrigineCondizAttualeShort = this.descOrigineCondizAttuale
					.substring(0, 9) + "...";
		}
		return this.descOrigineCondizAttualeShort;
	}

	public void setDescOrigineCondizAttualeShort(
			String descOrigineCondizAttualeShort) {
		this.descOrigineCondizAttualeShort = descOrigineCondizAttualeShort;
	}

	public void setDescPesoLivelloDeroga(String descPesoLivelloDeroga) {
		this.descPesoLivelloDeroga = descPesoLivelloDeroga;
	}

	public void setDescrizioneValoreProposto(String descrizioneValoreProposto) {
		if (null != descrizioneValoreProposto)
			this.descrizioneValoreProposto = descrizioneValoreProposto;
	}

	public void setDescSottoGruppo(String descSottoGruppo) {
		if (descSottoGruppo != null)
			this.descSottoGruppo = descSottoGruppo;
	}

	public void setDescTipoCondizione(String descTipoCondizione) {
		if (descTipoCondizione != null)
			this.descTipoCondizione = descTipoCondizione;
	}

	public void setDescTipoCondizionePromo(String descTipoCondizionePromo) {
		if (descTipoCondizionePromo != null)
			this.descTipoCondizionePromo = descTipoCondizionePromo;
	}

	public void setDescUnitaMisura(String descUnitaMisura) {
		if (null != descUnitaMisura)
			this.descUnitaMisura = descUnitaMisura;
	}

	public void setDescUnitaMisuraTassoCreditoreBDR(
			String descUnitaMisuraTassoCreditoreBDR) {
		this.descUnitaMisuraTassoCreditoreBDR = descUnitaMisuraTassoCreditoreBDR;
	}

	public void setDesListino(String desListino) {
		if (desListino != null)
			this.desListino = desListino;
	}

	public void setDesTipoRendicontazione(String desTipoRendicontazione) {
		this.desTipoRendicontazione = desTipoRendicontazione;
	}

	public void setDoubleValNumericoApprovato(Double valNumericoApprovato) {
		if (null != valNumericoApprovato)
			this.valNumericoApprovato = Double.toString(valNumericoApprovato);
	}

	public void setDoubleValNumericoAttuale(Double valNumericoAttuale) {
		if (null != valNumericoAttuale)
			this.valNumericoAttuale = Double.toString(valNumericoAttuale);
	}

	public void setDoubleValNumericoProposto(Double valNumericoProposto) {
		if (null != valNumericoProposto)
			this.valNumericoProposto = Double.toString(valNumericoProposto);
	}

	public void setDoubleValNumPostConvApprovato(
			Double valNumericoPostConvApprovato) {
		if (null != valNumericoPostConvApprovato)
			this.valNumericoPostConvApprovato = Double
					.toString(valNumericoPostConvApprovato);
	}

	public void setDoubleValNumPostConvProposto(
			Double valNumericoPostConvProposto) {
		if (null != valNumericoPostConvProposto)
			this.valNumericoPostConvProposto = Double
					.toString(valNumericoPostConvProposto);
	}

	public void setDriver1RilevatoDesc(String driver1RilevatoDesc) {
		this.driver1RilevatoDesc = driver1RilevatoDesc;
	}

	public void setDriver2RilevatoDesc(String driver2RilevatoDesc) {
		this.driver2RilevatoDesc = driver2RilevatoDesc;
	}

	public void setDS_CONDIZIONE_MACROGRUPPO(String ds_condizione_macrogruppo) {
		DS_CONDIZIONE_MACROGRUPPO = ds_condizione_macrogruppo;
	}

	public void setDS_CONDIZIONE_SOTTOGRUPPO(String ds_condizione_sottogruppo) {
		if (ds_condizione_sottogruppo != null)
			DS_CONDIZIONE_SOTTOGRUPPO = ds_condizione_sottogruppo;
	}

	public void setDS_SECONDO_DRIVER(String ds_secondo_driver) {
		if (ds_secondo_driver != null)
			DS_SECONDO_DRIVER = ds_secondo_driver;
	}

	public void setDurataBDR_Selezionata(int durataBDR_Selezionata) {
		this.durataBDR_Selezionata = durataBDR_Selezionata;
	}

	public void setDurataRollingApprovato(String durataRollingApprovato) {
		this.durataRollingApprovato = durataRollingApprovato;
	}

	public void setDurataRollingAttuale(String durataRollingAttuale) {
		this.durataRollingAttuale = durataRollingAttuale;
	}

	public void setDurataRollingMax(String durataRollingMax) {
		this.durataRollingMax = durataRollingMax;
	}

	public void setDurataRollingProposto(String durataRollingProposto) {
		this.durataRollingProposto = durataRollingProposto;
	}

	public void setElencoSottocondizioni(ArrayList elencoSottocondizioni) {
		this.elencoSottocondizioni = elencoSottocondizioni;
	}

	public void setEsitoCondizione(String esitoCondizione) {
		this.esitoCondizione = (null != esitoCondizione) ? esitoCondizione : "";
	}

	public void setEva(boolean eva) {
		this.eva = eva;
	}

	public void setFacoltaApice(String facoltaApice) {
		if (facoltaApice != null)
			this.facoltaApice = facoltaApice;
	}

	public void setFacoltaUoSup(String facoltaUoSup) {
		this.facoltaUoSup = (null != facoltaUoSup) ? facoltaUoSup : "";
	}

	public void setFacoltaUoSupParametrata(String facoltaUoSupParametrata) {
		if (facoltaUoSupParametrata != null)
			this.facoltaUoSupParametrata = facoltaUoSupParametrata;
	}

	public void setFamigliaCond(int famigliaCond) {
		this.famigliaCond = famigliaCond;
	}

	public void setFasceJSON(String fasceJSON) {
		this.fasceJSON = fasceJSON;
	}

//	public void setFasceSuConvenzioneApprovato(
//			FasceSuConvenzione fasceSuConvenzioneApprovato) {
//		this.fasceSuConvenzioneApprovato = fasceSuConvenzioneApprovato;
//	}
//
//	public void setFasceSuConvenzioneProposto(
//			FasceSuConvenzione fasceSuConvenzioneProposto) {
//		this.fasceSuConvenzioneProposto = fasceSuConvenzioneProposto;
//	}

	public void setFaseNonEmissioneInRipristinaProposta(
			boolean faseNonEmissioneInRipristinaProposta) {
		this.faseNonEmissioneInRipristinaProposta = faseNonEmissioneInRipristinaProposta;
	}

	public void setFlagBdrInPerdita(String flagBdrInPerdita) {
		this.flagBdrInPerdita = flagBdrInPerdita;
	}

	public void setFlagBlindatura(String flagBlindatura) {
		if (null != flagBlindatura)
			this.flagBlindatura = flagBlindatura;
	}

	public void setFlagCoerenza(String flagCoerenza) {
		this.flagCoerenza = flagCoerenza;
	}

	public void setFlagCondizioneModificata(String flagCondizioneModificata) {
		this.flagCondizioneModificata = flagCondizioneModificata;
	}

	public void setFlagCovenantCondizione(String flagCovenantCondizione) {
		if (flagCovenantCondizione != null)
			this.flagCovenantCondizione = flagCovenantCondizione;
	}

	public void setFlagCovenantMacroGruppo(boolean flagCovenantMacroGruppo) {
		this.flagCovenantMacroGruppo = flagCovenantMacroGruppo;
	}

	public void setFlagCovenantSottogruppo(String flagCovenantSottogruppo) {
		if (flagCovenantSottogruppo != null)
			this.flagCovenantSottogruppo = flagCovenantSottogruppo;
	}

	public void setFlagDisabilitaMonitoraggio(
			String flagDisabilitaMonitoraggio) {
		if (flagDisabilitaMonitoraggio == null)
			this.flagDisabilitaMonitoraggio = "";
		this.flagDisabilitaMonitoraggio = flagDisabilitaMonitoraggio;
	}

	public void setFlagEvaNonObbligatorio(boolean flagEvaNonObbligatorio) {
		this.flagEvaNonObbligatorio = flagEvaNonObbligatorio;

	}

	public void setFlagFasce(String flagFasce) {
		this.flagFasce = flagFasce;
	}

	public void setFlagObbligatoriaMlt(String fL_OBBLIGATORIA_MLT) {
		if (fL_OBBLIGATORIA_MLT != null)
			this.flagObbligatoriaMlt = fL_OBBLIGATORIA_MLT;
	}

	public void setFlagPdrCappatoFloorato(String flagPdrCappatoFloorato) {
		this.flagPdrCappatoFloorato = flagPdrCappatoFloorato;
	}

	public void setFlagPdrPrezzoApplicato(String flagPdrPrezzoApplicato) {
		FlagPdrPrezzoApplicato = flagPdrPrezzoApplicato;
	}

	public void setFlagPeggiorativa(String flagPeggiorativa) {
		if (flagPeggiorativa != null)
			this.flagPeggiorativa = flagPeggiorativa;
	}

	public void setFlagPilotaBdrInPerdita(String flagPilotaBdrInPerdita) {
		this.flagPilotaBdrInPerdita = flagPilotaBdrInPerdita;
	}

	public void setFlagPrevedePersonalizzatoConsigliato(
			String flagPrevedePersonalizzatoConsigliato) {
		if (flagPrevedePersonalizzatoConsigliato != null)
			this.flagPrevedePersonalizzatoConsigliato = flagPrevedePersonalizzatoConsigliato;
	}

	public void setFormaTecnicaPrangeHost(String formaTecnicaPrangeHost) {
		if (formaTecnicaPrangeHost != null)
			this.formaTecnicaPrangeHost = formaTecnicaPrangeHost;
	}

	public void setFormatoCifreDecimali(String formatoCifreDecimali) {
		if (null != formatoCifreDecimali)
			this.formatoCifreDecimali = formatoCifreDecimali;
	}

	public void setFormatoCifreIntere(String formatoCifreIntere) {
		if (null != formatoCifreIntere)
			this.formatoCifreIntere = formatoCifreIntere;
	}

	public void setFormulaApprovata(String formulaApprovata) {
		if (null != formulaApprovata)
			this.formulaApprovata = formulaApprovata;
	}

	public void setFormulaApprovataPostConvenzione(
			String formulaApprovataPostConvenzione) {
		if (formulaApprovataPostConvenzione != null)
			this.formulaApprovataPostConvenzione = formulaApprovataPostConvenzione;
	}

	public void setFormulaAttuale(String formulaAttuale) {
		if (null != formulaAttuale)
			this.formulaAttuale = formulaAttuale;
	}

	public void setFormulaParametriRollingApprovati(
			String formulaParametriRollingApprovati) {
		this.formulaParametriRollingApprovati = formulaParametriRollingApprovati;
	}

	public void setFormulaParametriRollingAttuali(
			String formulaParametriRollingAttuali) {
		this.formulaParametriRollingAttuali = formulaParametriRollingAttuali;
	}

	public void setFormulaParametriRollingProposti(
			String formulaParametriRollingProposti) {
		this.formulaParametriRollingProposti = formulaParametriRollingProposti;
	}

	public void setFormulaPostConvenzione(String formulaPostConvenzione) {
		if (formulaPostConvenzione != null)
			this.formulaPostConvenzione = formulaPostConvenzione;
	}

	public void setFormulaProposta(String formulaProposta) {
		if (null != formulaProposta)
			this.formulaProposta = formulaProposta;
	}

	public void setFormulaPropostaPostConvenzione(
			String formulaPropostaPostConvenzione) {
		if (formulaPropostaPostConvenzione != null)
			this.formulaPropostaPostConvenzione = formulaPropostaPostConvenzione;
	}

	public void setFormulaStandard(String formulaStandard) {
		if (null != formulaStandard)
			this.formulaStandard = formulaStandard;
	}

	public void setGestioneDatePos(String gestioneDatePos) {
		if (null != gestioneDatePos)
			this.gestioneDatePos = gestioneDatePos;
	}

	public void setHashControllateDefault(Hashtable hashControllateDefault) {
		this.hashControllateDefault = (hashControllateDefault != null)
				? hashControllateDefault
				: new Hashtable();
	}

	public void setHashControllateGerarchia(
			Hashtable hashControllateGerarchia) {
		this.hashControllateGerarchia = (hashControllateGerarchia != null)
				? hashControllateGerarchia
				: new Hashtable();
	}

	public void setHashControllateInCompilaProposta(
			Hashtable hashControllateInCompilaProposta) {
		this.hashControllateInCompilaProposta = (hashControllateInCompilaProposta != null)
				? hashControllateInCompilaProposta
				: new Hashtable();
	}

	public void setIdCondizionePrange(String idCondizionePrange) {
		this.idCondizionePrange = idCondizionePrange;
	}

	public void setIdCovenantInEstinzione(int idCovenantInEstinzione) {
		this.idCovenantInEstinzione = idCovenantInEstinzione;
	}

	public void setIdLineaPrange(Long idLineaPrange) {
		this.idLineaPrange = idLineaPrange;
	}

	public void setIdPraticaPrange(Long idPraticaPrange) {
		this.idPraticaPrange = idPraticaPrange;
	}

	public void setIdScenarioPrange(Long idScenarioPrange) {
		this.idScenarioPrange = idScenarioPrange;
	}

	public void setImportoBDR_A(double importoBDR_A) {
		this.importoBDR_A = importoBDR_A;
	}

	public void setImportoBDR_Da(double importoBDR_Da) {
		this.importoBDR_Da = importoBDR_Da;
	}

	public void setIndCapoFila(String indCapoFila) {
		this.indCapoFila = StrUtils.nullToEmpty(indCapoFila);
	}

	public void setIndCapoFilaTecnica(String indCapoFilaTecnica) {
		this.indCapoFilaTecnica = StrUtils.nullToEmpty(indCapoFilaTecnica);
	}

	public void setIndCondizionePriceRange(String indCondizionePriceRange) {
		this.indCondizionePriceRange = indCondizionePriceRange;
	}

	public void setIndCondizioneTassoSpread(String condizioneTassoSpread) {
		if (condizioneTassoSpread != null)
			this.indCondizioneTassoSpread = condizioneTassoSpread;
	}

	public void setIndControlloCrescenza(String indControlloCrescenza) {
		if (indControlloCrescenza != null)
			this.indControlloCrescenza = indControlloCrescenza;
	}

	public void setIndEsclVecchiaBersani(String indEsclVecchiaBersani) {
		this.indEsclVecchiaBersani = indEsclVecchiaBersani;
	}

	public void setIndicatoreRegime(String indicatoreRegime) {
		this.indicatoreRegime = indicatoreRegime;
	}

	public void setIndPresenzaStandard(String indPresenzaStandard) {
		if (indPresenzaStandard != null)
			this.indPresenzaStandard = indPresenzaStandard;
	}

	public void setIndPresenzaValoreTrimestrePrec(
			String indPresenzaValoreTrimestrePrec) {
		if (indPresenzaValoreTrimestrePrec != null)
			this.indPresenzaValoreTrimestrePrec = indPresenzaValoreTrimestrePrec;
	}

	public void setIndScadenzaObbligatoria(String indScadenzaObbligatoria) {
		this.indScadenzaObbligatoria = indScadenzaObbligatoria;
	}

	public void setIndStampaBersani(String indStampaBersani) {
		this.indStampaBersani = indStampaBersani;
	}

	public void setIndStampaPresenteCovenant(String indStampaPresenteCovenant) {
		this.indStampaPresenteCovenant = indStampaPresenteCovenant;
	}

	public void setIndTestoLibero(String indTestoLibero) {
		this.indTestoLibero = indTestoLibero;
	}

	public void setIndTipoCorr(String indTipoCorr) {
		this.indTipoCorr = StrUtils.nullToEmpty(indTipoCorr);
	}

	public void setIndTITmanualeBDR(boolean indTITmanualeBDR) {
		this.indTITmanualeBDR = indTITmanualeBDR;
	}

	public void setIndValore(String indValore) {
		this.indValore = indValore;
	}

	public void setIndValorePDR(String indValorePDR) {
		this.indValorePDR = indValorePDR;
	}

	public void setIndVersoMigliorativo(String indVersoMigliorativo) {
		if (null != indVersoMigliorativo)
			this.indVersoMigliorativo = indVersoMigliorativo;
	}

	public void setIndVersoMigliorativoTassoCreditoreBDR(
			String indVersoMigliorativoTassoCreditoreBDR) {
		this.indVersoMigliorativoTassoCreditoreBDR = indVersoMigliorativoTassoCreditoreBDR;
	}

//	public void setInfoSelezionabilitaScollegabilita(
//			InfoSelezionabilitaScollegabilita infoSelezionabilitaScollegabilita) {
//		this.infoSelezionabilitaScollegabilita = infoSelezionabilitaScollegabilita;
//	}

	public void setListaCodSottocondizioni(ArrayList listaCodSottocondizioni) {
		this.listaCodSottocondizioni = (null != listaCodSottocondizioni)
				? listaCodSottocondizioni
				: new ArrayList();
	}

	public void setListaCondizioniOutGER(
			ArrayList<Condizione> listaCondizioniOutGER) {
		if (listaCondizioniOutGER != null)
			this.listaCondizioniOutGER = listaCondizioniOutGER;
	}

	public void setListaControllate(
			ArrayList<CondizioneDeroga> listaControllate) {
		this.listaControllate = listaControllate;
	}

	public void setListaControllateDefault(ArrayList listaDefault) {
		this.listaControllateDefault = (null != listaDefault)
				? listaDefault
				: new ArrayList();
	}

	public void setListaControllateInCompilaProposta(
			ArrayList listaCompilaProposta) {
		this.listaControllateInCompilaProposta = (null != listaCompilaProposta)
				? listaCompilaProposta
				: new ArrayList();
	}

	public void setListaCorrelate(ArrayList listaCorrelate) {
		this.listaCorrelate = (null != listaCorrelate)
				? listaCorrelate
				: new ArrayList();
	}
	public void setListaCorrelateFull(ArrayList listaCorrelateFull) {
		this.listaCorrelateFull = (null != listaCorrelateFull)
				? listaCorrelateFull
				: new ArrayList();
	}
//	public void setListaDurateAmmesseBDR(
//			ArrayList<Opzione> listaDurateAmmesseBDR) {
//		this.listaDurateAmmesseBDR = listaDurateAmmesseBDR;
//	}

	public void setListaIncompatibili(ArrayList listaIncompatibili) {
		this.listaIncompatibili = (null != listaIncompatibili)
				? listaIncompatibili
				: new ArrayList();
	}

	public void setListaTipiPropostaNonSelezionabile(
			String listaTipiPropostaNonSelezionabile) {
		this.listaTipiPropostaNonSelezionabile = (null != listaTipiPropostaNonSelezionabile)
				? listaTipiPropostaNonSelezionabile
				: "";
	}

//	public void setListFiglie(ArrayList<CondizioneDerogaPricing> listFiglie) {
//		this.listFiglie = listFiglie;
//	}

	public void setListini(ArrayList listini) {
		this.listini = listini;
	}

	public void setLivelloApplicativo(int livelloApplicativo) {
		this.livelloApplicativo = livelloApplicativo;
	}

	public void setLivelloGerarchia(String livelloGerarchia) {
		if (livelloGerarchia != null)
			this.livelloGerarchia = livelloGerarchia;
	}

	public void setMacroGruppo(String macroGruppo) {
		this.macroGruppo = macroGruppo;
	}

	public void setMaxDataDeco(String maxDataDeco) {
		if (null != maxDataDeco)
			this.maxDataDeco = maxDataDeco;
	}

	public void setMaxMesiScadenzaObbligatoria(
			int maxMesiScadenzaObbligatoria) {
		this.maxMesiScadenzaObbligatoria = maxMesiScadenzaObbligatoria;
	}

	public void setMaxScadenzaObbligatoria(String maxScadenzaObbligatoria) {
		this.maxScadenzaObbligatoria = maxScadenzaObbligatoria;
	}

	public void setMessaggioCondizione(String messaggioCondizione) {
		this.messaggioCondizione = (null != messaggioCondizione)
				? messaggioCondizione
				: "";
	}

	public void setMessaggioErrore(String messaggioErrore) {
		if (null != messaggioErrore)
			this.messaggioErrore = messaggioErrore;
	}

	public void setMinDataDeco(String minDataDeco) {
		if (null != minDataDeco)
			this.minDataDeco = minDataDeco;
	}

	public void setMinMesiScadenzaObbligatoria(
			int minMesiScadenzaObbligatoria) {
		this.minMesiScadenzaObbligatoria = minMesiScadenzaObbligatoria;
	}

	public void setMinScadenzaObbligatoria(String minScadenzaObbligatoria) {
		this.minScadenzaObbligatoria = minScadenzaObbligatoria;
	}

	public void setMoltiplicatoreFamMerc(String moltiplicatoreFamMerc) {
		this.moltiplicatoreFamMerc = moltiplicatoreFamMerc;
	}

	public void setMoltiplicatoreRating(String moltiplicatoreRating) {
		this.moltiplicatoreRating = moltiplicatoreRating;
	}

	public void setMoltiplicatoreSegmento(String moltiplicatoreSegmento) {
		this.moltiplicatoreSegmento = moltiplicatoreSegmento;
	}

	public void setMoltiplicatoreSottoSegComm(
			String moltiplicatoreSottoSegComm) {
		this.moltiplicatoreSottoSegComm = moltiplicatoreSottoSegComm;
	}

	public void setMoltiplicatoreTerritoriale(
			String moltiplicatoreTerritoriale) {
		this.moltiplicatoreTerritoriale = moltiplicatoreTerritoriale;
	}

	public void setNotaCovenant(String notaCovenant) {
		this.notaCovenant = notaCovenant;
	}

	public void setNumeroFasciaConvenzione(int numeroFasciaConvenzione) {
		this.numeroFasciaConvenzione = numeroFasciaConvenzione;
	}

	public void setNumOrdine(String numOrdine) {
		this.numOrdine = numOrdine;
	}

	public void setNumSottocondizioni(int numSottocondizioni) {
		this.numSottocondizioni = numSottocondizioni;
	}

	public void setPacchettoCorr(String pacchettoCorr) {
		this.pacchettoCorr = StrUtils.nullToEmpty(pacchettoCorr);
	}

	public void setPacchettoCorrTecniche(String pacchettoCorrTecniche) {
		this.pacchettoCorrTecniche = StrUtils.nullToEmpty(pacchettoCorrTecniche);
	}

	// Indica se la condizione è parametrabile
	// (tale valore viene estratto dal DB dipartimentale: IND_PARAMETRABILE)
	public void setParametrabile(boolean parametrabile) {
		this.parametrabile = parametrabile;
	}

	// A seconda dell'origine della condizione
	// (PAR/RPAR) definisce se un acondizione è parametrata
	public void setParametrata(boolean parametrata) {
		this.parametrata = parametrata;
	}

	public void setParametrataConGestioneNormaleInCompilazione(
			boolean parametrataConGestioneNormaleInCompilazione) {
		this.parametrataConGestioneNormaleInCompilazione = parametrataConGestioneNormaleInCompilazione;
	}

//	public void setParametriCondizioneDeroga(
//			ParametriCondizioneDeroga parametriCondizioneDeroga) {
//		if (null != parametriCondizioneDeroga)
//			this.parametriCondizioneDeroga = parametriCondizioneDeroga;
//	}
//
//	public void setParametriCondizioneDerogaApprovati(
//			ParametriCondizioneDeroga parametriCondizioneDerogaApprovati) {
//		if (null != parametriCondizioneDerogaApprovati)
//			this.parametriCondizioneDerogaApprovati = parametriCondizioneDerogaApprovati;
//	}
//
//	public void setParametriCondizioneDerogaAttuali(
//			ParametriCondizioneDeroga parametriCondizioneDerogaAttuali) {
//		if (null != parametriCondizioneDerogaAttuali)
//			this.parametriCondizioneDerogaAttuali = parametriCondizioneDerogaAttuali;
//	}
//
//	public void setParametriCondizioneDerogaPostConvApprovati(
//			ParametriCondizioneDeroga parametriCondizioneDerogaPostConvApprovati) {
//		this.parametriCondizioneDerogaPostConvApprovati = parametriCondizioneDerogaPostConvApprovati;
//	}
//
//	public void setParametriCondizioneDerogaPostConvProposti(
//			ParametriCondizioneDeroga parametriCondizioneDerogaPostConvProposti) {
//		this.parametriCondizioneDerogaPostConvProposti = parametriCondizioneDerogaPostConvProposti;
//	}
//
//	public void setParametriCondizioneDerogaRollingApprovati(
//			ParametriCondizioneDeroga parametriCondizioneDerogaRollingApprovati) {
//		this.parametriCondizioneDerogaRollingApprovati = parametriCondizioneDerogaRollingApprovati;
//	}
//
//	public void setParametriCondizioneDerogaRollingAttuali(
//			ParametriCondizioneDeroga parametriCondizioneDerogaRollingAttuali) {
//		this.parametriCondizioneDerogaRollingAttuali = parametriCondizioneDerogaRollingAttuali;
//	}
//
//	public void setParametriCondizioneDerogaRollingProposti(
//			ParametriCondizioneDeroga parametriCondizioneDerogaRollingProposti) {
//		this.parametriCondizioneDerogaRollingProposti = parametriCondizioneDerogaRollingProposti;
//	}
//
//	public void setParametriPostConvenzione(
//			ParametriCondizioneDeroga parametriPostConvenzione) {
//		if (parametriPostConvenzione != null)
//			this.parametriPostConvenzione = parametriPostConvenzione;
//	}

	public void setPeggiorativa(boolean peggiorativa) {
		this.peggiorativa = peggiorativa;
	}

	public void setPenaleEstinzioneAzzerataBDR(
			boolean penaleEstinzioneAzzerataBDR) {
		this.penaleEstinzioneAzzerataBDR = penaleEstinzioneAzzerataBDR;
	}

	public void setPERC_NEW_OPER(String perc_new_oper) {
		if (perc_new_oper != null)
			PERC_NEW_OPER = perc_new_oper;
	}

	public void setPesoLivelloDeroga(int pesoLivelloDeroga) {
		this.pesoLivelloDeroga = pesoLivelloDeroga;
	}

	public void setPopupFasceModificatoInIter(
			boolean popupFasceModificatoInIter) {
		this.popupFasceModificatoInIter = popupFasceModificatoInIter;
	}

	public void setPopupPerConvenzioneModificato(
			boolean popupPerConvenzioneModificato) {
		this.popupPerConvenzioneModificato = popupPerConvenzioneModificato;
	}

	public void setPresenteCovenant(boolean presenteCovenanat) {
		this.presenteCovenant = presenteCovenanat;
	}

	public void setPresenteCovenantAllaData(boolean presenteCovenantAllaData) {
		this.presenteCovenantAllaData = presenteCovenantAllaData;
	}

	public void setPresenteCovenantApprovato(
			boolean presenteCovenantApprovato) {
		this.presenteCovenantApprovato = presenteCovenantApprovato;
	}

	public void setPresenteCovenantAttuale(boolean presenteCovenantAttuale) {
		this.presenteCovenantAttuale = presenteCovenantAttuale;
	}

	/**
	 * @param presenteCovenantNonEstinguibile
	 *            the presenteCovenantNonEstinguibile to set
	 */
	public void setPresenteCovenantNonEstinguibile(
			boolean presenteCovenantNonEstinguibile) {
		this.presenteCovenantNonEstinguibile = presenteCovenantNonEstinguibile;
	}

	public void setPresenteCovenantNonVendibile(
			boolean presenteCovenantNonVendibile) {
		this.presenteCovenantNonVendibile = presenteCovenantNonVendibile;
	}

	public void setPresenteCovenantProposto(boolean presenteCovenantProposto) {
		this.presenteCovenantProposto = presenteCovenantProposto;
	}

	public void setPresenteDerogaRollingApprovato(
			boolean presenteDerogaRollingApprovato) {
		this.presenteDerogaRollingApprovato = presenteDerogaRollingApprovato;
	}

	public void setPresenteDerogaRollingProposto(
			boolean presenteDerogaRollingProposto) {
		this.presenteDerogaRollingProposto = presenteDerogaRollingProposto;
	}

	public void setPresenteModifcaFinessMLT(boolean presenteModifcaFinessMLT) {
		this.presenteModifcaFinessMLT = presenteModifcaFinessMLT;
	}

	public void setPresenteValorePostConv(boolean isPresenteValorePostConv) {
		this.isPresenteValorePostConv = isPresenteValorePostConv;
	}

	public void setPresentiFasceSuConvenzioneApprovato(
			boolean presentiFasceSuConvenzioneApprovato) {
		this.presentiFasceSuConvenzioneApprovato = presentiFasceSuConvenzioneApprovato;
	}

	public void setPresentiFasceSuConvenzioneProposto(
			boolean presentiFasceSuConvenzioneProposto) {
		this.presentiFasceSuConvenzioneProposto = presentiFasceSuConvenzioneProposto;
	}

	public void setPresenzaEva(String presenzaEva) {
		if (presenzaEva != null)
			this.presenzaEva = presenzaEva;
	}

	public void setPresenzaFasceAllaData(boolean presenzaFasceAllaData) {

		this.presenzaFasceAllaData = presenzaFasceAllaData;
	}

	public void setPresenzaMoltiplicatori(boolean presenzaMoltiplicatori) {
		PresenzaMoltiplicatori = presenzaMoltiplicatori;
	}

	public void setPresenzaRollingAllaData(boolean presenzaRollingAllaData) {
		this.presenzaRollingAllaData = presenzaRollingAllaData;
	}
	public void setPrevedeCovenants(boolean prevedeCovenants) {
		this.prevedeCovenants = prevedeCovenants;
	}

	public void setPrevedeEva(String prevedeEva) {
		if (prevedeEva != null)
			this.prevedeEva = prevedeEva;
	}

	public void setPrimaControllata(boolean primaControllata) {
		this.primaControllata = primaControllata;
	}

	public void setProgressivoSequenzaMLT(int progressivoSequenzaMLT) {
		this.progressivoSequenzaMLT = progressivoSequenzaMLT;
	}

	public void setProvenienza(String provenienza) {
		if (provenienza != null)
			this.provenienza = provenienza;

	}

	public void setProvenienzaDaHost(boolean provenienzaDaHost) {
		this.provenienzaDaHost = provenienzaDaHost;
	}

	public void setRegime(boolean regime) {
		this.regime = regime;
	}

	public void setRegimeIsTassoPlus(boolean regimeIsTassoPlus) {
		this.regimeIsTassoPlus = regimeIsTassoPlus;
	}

	public void setRegimeSconto(boolean regimeSconto) {
		this.regimeSconto = regimeSconto;
	}

	public void setREMUN_PRD_CONV(String remun_prd_conv) {
		if (remun_prd_conv != null)
			REMUN_PRD_CONV = remun_prd_conv;
	}

	public void setRiferimentoSalvadanio(boolean riferimentoSalvadanio) {
		this.riferimentoSalvadanio = riferimentoSalvadanio;
	}

	public void setScollegabileDaPropostaNormale(
			boolean scollegabileDaPropostaNormale) {
		this.scollegabileDaPropostaNormale = scollegabileDaPropostaNormale;
	}

	public void setScollegamentoAttrGKCondH(boolean scollegamentoAttrGKCondH) {
		this.scollegamentoAttrGKCondH = scollegamentoAttrGKCondH;
	}

	public void setSegnoBeneficio(String segnoBeneficio) {
		if (segnoBeneficio != null)
			this.segnoBeneficio = segnoBeneficio;
	}

	public void setSegnoEva(String segnoEva) {
		if (segnoEva != null)
			this.segnoEva = segnoEva;
	}

	public void setSegnoValNumericoApprovato(String segnoValNumericoApprovato) {
		if (segnoValNumericoApprovato != null)
			this.segnoValNumericoApprovato = segnoValNumericoApprovato;
	}

	public void setSegnoValNumericoAttuale(String segnoValNumericoAttuale) {
		if (segnoValNumericoAttuale != null)
			this.segnoValNumericoAttuale = segnoValNumericoAttuale;
	}

	public void setSegnoValNumericoProposto(String segnoValNumericoProposto) {
		if (segnoValNumericoProposto != null)
			this.segnoValNumericoProposto = segnoValNumericoProposto;
	}

	public void setSegnoValoreAttualeGerarchia(
			String segnoValoreAttualeGerarchia) {
		this.segnoValoreAttualeGerarchia = segnoValoreAttualeGerarchia;
	}

	public void setSegnoValoreStandard(String segnoValoreStandard) {
		if (segnoValoreStandard != null)
			this.segnoValoreStandard = segnoValoreStandard;
	}

	public void setSegnoValoreStandardGerarchia(
			String segnoValoreStandardGerarchia) {
		this.segnoValoreStandardGerarchia = segnoValoreStandardGerarchia;
	}

	public void setSegnoValoreTrimestrePrec(String segnoValoreTrimestrePrec) {
		if (segnoValoreTrimestrePrec != null)
			this.segnoValoreTrimestrePrec = segnoValoreTrimestrePrec;
	}

	public void setSelezionabile(boolean selezionabile) {
		this.selezionabile = selezionabile;
	}

	public void setSoloScollegabileDaPropostaNormale(
			boolean scollegabileDaPropostaNormale) {
		this.soloScollegabileDaPropostaNormale = scollegabileDaPropostaNormale;
	}
	public void setSottocondizione(boolean sottocondizione) {
		this.sottocondizione = sottocondizione;
	}

	public void setSottoGruppo(String sottoGruppo) {
		if (sottoGruppo != null)
			this.sottoGruppo = sottoGruppo;
	}

	public void setSpreadBDR(boolean spreadBDR) {
		this.spreadBDR = spreadBDR;
	}

	public void setStatoGerarchia(String statoGerarchia) {
		this.statoGerarchia = statoGerarchia;
	}

	public void setStrCondizioniGerarchia(String strCondizioniGerarchia) {
		if (strCondizioniGerarchia != null)
			this.strCondizioniGerarchia = strCondizioniGerarchia;
	}

	public void setStrControllate(String strControllate) {
		this.strControllate = strControllate;
	}

	public void setStrControllateGerarchia(String strControllateGerarchia) {
		if (strControllateGerarchia != null)
			this.strControllateGerarchia = strControllateGerarchia;
	}

	public void setStrControllatePrimoLivelloGerarchia(
			String strControllatePrimoLivelloGerarchia) {
		if (strControllatePrimoLivelloGerarchia != null)
			this.strControllatePrimoLivelloGerarchia = strControllatePrimoLivelloGerarchia;
	}

	public void setStrCorrelate(String strCorrelate) {
		this.strCorrelate = strCorrelate;
	}

	public void setStrCorrelateAll(String strCorrelateAll) {
		this.strCorrelateAll = StrUtils.nullToEmpty(strCorrelateAll);
	}

	public void setStrCorrelateFull(String strCorrelateFull) {
		this.strCorrelateFull = StrUtils.nullToEmpty(strCorrelateFull);
	}

	public void setStrCorrelateGR(String strCorrelateGR) {
		this.strCorrelateGR = strCorrelateGR;
	}

	public void setStrCorrelateLight(String strCorrelateLight) {
		this.strCorrelateLight = StrUtils.nullToEmpty(strCorrelateLight);
	}

	public void setStrCorrelateTecniche(String strCorrelateTecniche) {
		this.strCorrelateTecniche = StrUtils.nullToEmpty(strCorrelateTecniche);
	}

	public String getStrCorrelateCompatibilita() {
		return strCorrelateCompatibilita;
	}
	public void setStrCorrelateCompatibilita(String strCorrelateCompatibilita) {
		this.strCorrelateCompatibilita = strCorrelateCompatibilita;
	}
	public void setStringaFacolta(String stringaFacolta) {
		this.stringaFacolta = (null != stringaFacolta) ? stringaFacolta : "";
	}

	public void setStringaFacoltaParametrata(String stringaFacoltaParametrata) {
		if (stringaFacoltaParametrata != null)
			this.stringaFacoltaParametrata = stringaFacoltaParametrata;
	}

	public void setStrOrigineControllate(String strOrigineControllate) {
		this.strOrigineControllate = strOrigineControllate;
	}

	public void setStrValoreAttualeCondizioniGerarchia(
			String strValoreAttualeCondizioniGerarchia) {
		this.strValoreAttualeCondizioniGerarchia = strValoreAttualeCondizioniGerarchia;
	}

	public void setTassoPlus(boolean tassoPlus) {
		this.tassoPlus = tassoPlus;
	}

	public void setTIPO_OPERAZIONE(String tipo_operazione) {
		if (tipo_operazione != null)
			TIPO_OPERAZIONE = tipo_operazione;
	}

	public void setTIPO_OPERAZIONE_PCV(String tipo_operazione_pcv) {
		if (tipo_operazione_pcv != null)
			TIPO_OPERAZIONE_PCV = tipo_operazione_pcv;
	}

	public void setTipoCodAggregOriginAtt(String tipoCodAggregOriginAtt) {
		this.tipoCodAggregOriginAtt = tipoCodAggregOriginAtt;
	}

	public void setTipoCondizione(String tipoCondizione) {
		if (null != tipoCondizione)
			this.tipoCondizione = tipoCondizione;
	}

	public void setTipoCondizioneAttMst(String tipoCondizioneAttMst) {
		if (null != tipoCondizioneAttMst)
			this.tipoCondizioneAttMst = tipoCondizioneAttMst;
	}

	public void setTipoCondizionePromo(String tipoCondizionePromo) {
		if (tipoCondizionePromo != null)
			this.tipoCondizionePromo = tipoCondizionePromo;
	}

	public void setTipoControllata(String tipoControllata) {
		if (tipoControllata != null)
			this.tipoControllata = tipoControllata;
	}

	public void setTipoDeroga(String tipoDeroga) {
		if (null != tipoDeroga)
			this.tipoDeroga = tipoDeroga;
	}

	public void setTipoEntitaAdesione(String codEntitaAdesione) {
		this.tipoEntitaAdesione = codEntitaAdesione;
	}

	public void setTipologiaAggregazione(String tipologiaAggregazione) {
		this.tipologiaAggregazione = tipologiaAggregazione;
	}

	public void setTipoOperazioneObbligatoria(
			String tipoOperazioneObbligatoria) {
		this.tipoOperazioneObbligatoria = tipoOperazioneObbligatoria;
	}

	public void setTipoRendicontazione(String tipoRendicontazione) {
		this.tipoRendicontazione = tipoRendicontazione;
	}

	public void setTipoRolling(String tipoRolling) {
		this.TIPO_OPERAZIONE_ROLLING = tipoRolling;
	}

	public void setTipoValore(String tipoValore) {
		if (null != tipoValore)
			this.tipoValore = tipoValore;
	}

	public void setTipoValoreFromDecoder(String tipoValoreFromDecoder) {
		this.tipoValoreFromDecoder = tipoValoreFromDecoder;
	}

	public void setUnicaSelezionabileDb(boolean unicaSelezionabileDb) {
		this.unicaSelezionabileDb = unicaSelezionabileDb;
	}

	public void setUnicaSelezionabileHost(boolean unicaSelezionabileHost) {
		this.unicaSelezionabileHost = unicaSelezionabileHost;
	}

	public void setUnitaMisura(String unitaMisura) {
		if (null != unitaMisura)
			this.unitaMisura = unitaMisura;
	}

	public void setValCodiceApprovato(String valCodiceApprovato) {
		if (null != valCodiceApprovato)
			this.valCodiceApprovato = valCodiceApprovato;
	}

	public void setValCodiceAttuale(String valCodiceAttuale) {
		if (null != valCodiceAttuale)
			this.valCodiceAttuale = valCodiceAttuale;
	}

	public void setValCodicePostConvApprovato(
			String valCodicePostConvApprovato) {
		this.valCodicePostConvApprovato = valCodicePostConvApprovato;
	}

	public void setValCodicePostConvProposto(String valCodicePostConvProposto) {
		this.valCodicePostConvProposto = valCodicePostConvProposto;
	}

	public void setValCodiceProposto(String valCodiceProposto) {
		if (null != valCodiceProposto)
			this.valCodiceProposto = valCodiceProposto;
	}

	public void setValCodiceRollingApprovato(String valCodiceRollingApprovato) {
		this.valCodiceRollingApprovato = valCodiceRollingApprovato;
	}

	public void setValCodiceRollingAttuale(String valCodiceRollingAttuale) {
		this.valCodiceRollingAttuale = valCodiceRollingAttuale;
	}

	public void setValCodiceRollingProposto(String valCodiceRollingProposto) {
		this.valCodiceRollingProposto = valCodiceRollingProposto;
	}

	public void setValCodiceStandard(String valCodiceStandard) {
		if (valCodiceStandard != null)
			this.valCodiceStandard = valCodiceStandard;
	}

	public void setValNumericoApprovato(String valNumericoApprovato) {
		if (null != valNumericoApprovato)
			this.valNumericoApprovato = valNumericoApprovato;
	}

	public void setValNumericoAttuale(String valNumericoAttuale) {
		if (null != valNumericoAttuale)
			this.valNumericoAttuale = valNumericoAttuale;
	}

	public void setValNumericoAttualeGerarchia(
			String valNumericoAttualeGerarchia) {
		this.valNumericoAttualeGerarchia = valNumericoAttualeGerarchia;
	}

	public void setValNumericoPostConvApprovato(
			String valNumericoPostConvApprovato) {
		if (valNumericoPostConvApprovato != null)
			this.valNumericoPostConvApprovato = valNumericoPostConvApprovato;
	}

	public void setValNumericoPostConvProposto(
			String valNumericoPostConvProposto) {
		if (valNumericoPostConvProposto != null)
			this.valNumericoPostConvProposto = valNumericoPostConvProposto;
	}

	public void setValNumericoProposto(String valNumericoProposto) {
		if (null != valNumericoProposto)
			this.valNumericoProposto = valNumericoProposto;
	}

	public void setValNumericoRollingApprovato(
			String valNumericoRollingApprovato) {
		this.valNumericoRollingApprovato = valNumericoRollingApprovato;
	}

	public void setValNumericoRollingAttuale(String valNumericoRollingAttuale) {
		this.valNumericoRollingAttuale = valNumericoRollingAttuale;
	}

	public void setValNumericoRollingProposto(
			String valNumericoRollingProposto) {
		this.valNumericoRollingProposto = valNumericoRollingProposto;
	}

	public void setValNumericoStandard(String valNumericoStandard) {
		if (valNumericoStandard != null)
			this.valNumericoStandard = valNumericoStandard;
	}

	public void setValNumericoStandardGerarchia(
			String valNumericoStandardGerarchia) {
		this.valNumericoStandardGerarchia = valNumericoStandardGerarchia;
	}

	public void setVALORE_DRIVER(String valore_driver) {
		if (valore_driver != null)
			VALORE_DRIVER = valore_driver;
	}

	public void setVALORE_SECONDO_DRIVER(String valore_secondo_driver) {
		if (valore_secondo_driver != null)
			VALORE_SECONDO_DRIVER = valore_secondo_driver;
	}

	public void setValoreCanaleProposta(String valoreCanaleProposta) {
		this.valoreCanaleProposta = valoreCanaleProposta;
	}

	public void setValoreCondizioneCAP(double valoreCondizioneCAP) {
		this.valoreCondizioneCAP = valoreCondizioneCAP;
	}

	public void setValoreCondizioneFLOOR(double valoreCondizioneFLOOR) {
		this.valoreCondizioneFLOOR = valoreCondizioneFLOOR;
	}

	public void setValoreDerogaPrevistoPerControllata(
			String valoreDerogaPrevistoPerControllata) {
		this.valoreDerogaPrevistoPerControllata = valoreDerogaPrevistoPerControllata;
	}

	public void setValoreEva(String valoreEva) {
		if (valoreEva != null)
			this.valoreEva = valoreEva;
	}

	public void setValoreMassimo(String valoreMassimo) {
		if (null != valoreMassimo)
			this.valoreMassimo = valoreMassimo;
	}

	public void setValoreMinimo(String valoreMinimo) {
		if (null != valoreMinimo)
			this.valoreMinimo = valoreMinimo;
	}

	public void setValoreNonPiuProponibile(String valoreNonPiuProponibile) {
		if (null != valoreNonPiuProponibile)
			this.valoreNonPiuProponibile = valoreNonPiuProponibile;
	}

	public void setValorePostConvDesc(String valorePostConvDesc) {
		this.valorePostConvDesc = valorePostConvDesc;
	}

	public void setValoreRegolaGerarchia(String valoreRegolaGerarchia) {
		if (valoreRegolaGerarchia != null)
			this.valoreRegolaGerarchia = valoreRegolaGerarchia;
	}

	public void setValoreTestoAttuale(String valoreTestoAttuale) {
		if (null != valoreTestoAttuale)
			this.valoreTestoAttuale = valoreTestoAttuale;
	}

	public void setValoreTestoProposto(String valoreTestoProposto) {
		if (null != valoreTestoProposto)
			this.valoreTestoProposto = valoreTestoProposto;
	}

	public void setValoreTestoStandard(String valoreTestoStandard) {
		this.valoreTestoStandard = valoreTestoStandard;
	}

	public void setValoreTrimestrePrec(String valoreTrimestrePrec) {
		if (valoreTrimestrePrec != null)
			this.valoreTrimestrePrec = valoreTrimestrePrec;
	}

	public void setValoriDescrizioniCodice(ArrayList valoriDescrizioniCodice) {
		if (null != valoriDescrizioniCodice)
			this.valoriDescrizioniCodice = valoriDescrizioniCodice;
	}

	public void setValParametro(String valParametro) {
		this.valParametro = valParametro;
	}

	public void setValParametroSegno(String valParametroSegno) {
		this.valParametroSegno = valParametroSegno;
	}

	public void setValTassoCreditorePerSalvadanaio(
			String valTassoCreditorePerSalvadanaio) {
		this.valTassoCreditorePerSalvadanaio = valTassoCreditorePerSalvadanaio;
	}

	public void setValuePrangeHost(String valuePrangeHost) {
		this.valuePrangeHost = valuePrangeHost;
	}

	public void setViewParametrataProposalCheckbox(
			boolean viewParametrataProposalCheckbox) {
		this.viewParametrataProposalCheckbox = viewParametrataProposalCheckbox;
	}

	public void setViewProposalCheckbox(boolean viewProposalCheckbox) {
		this.viewProposalCheckbox = viewProposalCheckbox;
	}

	public void setVincoliValorizzati(boolean vincoliValorizzati) {
		this.vincoliValorizzati = vincoliValorizzati;
	}

	public void setVisibilitaAbc(String visibilitaAbc) {
		if (visibilitaAbc != null)
			this.visibilitaAbc = visibilitaAbc;
	}

	/**
	 * @return the descrizioneProdottoJBilling
	 */
	public String getDescrizioneProdottoJBilling() {
		return descrizioneProdottoJBilling;
	}
	/**
	 * @param descrizioneProdottoJBilling
	 *            the descrizioneProdottoJBilling to set
	 */
	public void setDescrizioneProdottoJBilling(
			String descrizioneProdottoJBilling) {
		this.descrizioneProdottoJBilling = descrizioneProdottoJBilling;
	}
	/**
	 * @return the codiceProdottoJBilling
	 */
	public String getCodiceProdottoJBilling() {
		return codiceProdottoJBilling;
	}
	/**
	 * @param codiceProdottoJBilling
	 *            the codiceProdottoJBilling to set
	 */
	public void setCodiceProdottoJBilling(String codiceProdottoJBilling) {
		this.codiceProdottoJBilling = codiceProdottoJBilling;
	}
	/**
	 * @return the progressivoJBilling
	 */
	public String getProgressivoJBilling() {
		return progressivoJBilling;
	}
	/**
	 * @param progressivoJBilling
	 *            the progressivoJBilling to set
	 */
	public void setProgressivoJBilling(String progressivoJBilling) {
		this.progressivoJBilling = progressivoJBilling;
	}
	public String getSoggettaARegolaDiBilling() {
		return soggettaARegolaDiBilling;
	}
	public void setSoggettaARegolaDiBilling(String soggettaARegolaDiBilling) {
		this.soggettaARegolaDiBilling = soggettaARegolaDiBilling;
	}
	public String getCodiceScenario() {
		return codiceScenario;
	}
	public void setCodiceScenario(String codiceScenario) {
		this.codiceScenario = codiceScenario;
	}
	public String getBillingAccount() {
		return billingAccount;
	}
	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione
	 */
	public boolean isDataDecorrenzaForzataOggiPerEstinzione() {
		return dataDecorrenzaForzataOggiPerEstinzione;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione
	 */
	public void setDataDecorrenzaForzataOggiPerEstinzione(
			boolean dataDecorrenzaForzataOggiPerEstinzione) {
		this.dataDecorrenzaForzataOggiPerEstinzione = dataDecorrenzaForzataOggiPerEstinzione;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione per Beneficio
	 */
	public boolean isDataDecoForzataOggiPerEstinzioneBeneficio() {
		return dataDecoForzataOggiPerEstinzioneBeneficio;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione per Beneficio
	 */
	public void setDataDecoForzataOggiPerEstinzioneBeneficio(
			boolean dataDecoForzataOggiPerEstinzioneBeneficio) {
		this.dataDecoForzataOggiPerEstinzioneBeneficio = dataDecoForzataOggiPerEstinzioneBeneficio;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione
	 */
	public boolean isDataDecoForzataOggiPerEstinzioneAntergazione() {
		return dataDecoForzataOggiPerEstinzioneAntergazione;
	}
	/**
	 * @return indica quando una condizione verrà forzata ad oggi a causa di
	 *         un'estinzione
	 */
	public void setDataDecoForzataOggiPerEstinzioneAntergazione(
			boolean dataDecoForzataOggiPerEstinzioneAntergazione) {
		this.dataDecoForzataOggiPerEstinzioneAntergazione = dataDecoForzataOggiPerEstinzioneAntergazione;
	}
//	@Override
//	public JSONObject toJSON() {
//		JSONObject result = new JSONObject();
//		result.element("codiceCondizione",
//				this.condizione.getCodiceCondizione());
//		result.element("descrizioneCondizione", this.descCondizione);
//
//		result.element("origineCondizione",
//				(!codOrigineCondizAttuale.equals("")
//						&& !codOrigineCondizAttuale.equals("Prop.")
//						&& !codOrigineCondizAttuale.equals("App."))
//								? "[" + this.codOrigineCondizAttuale + "] "
//										+ this.descOrigineCondizAttuale
//								: this.codOrigineCondizAttuale);
//
//		result.element("valoreCondizione", (this.tipoValore.equals("1"))
//				? this.valNumericoAttuale + " " + this.descUnitaMisura
//				: "[" + this.valCodiceAttuale + "] " + this.descCodiceAttuale);
//
//		result.element("dataDecorrenza",
//				(!this.controllata)
//						? ((codOrigineCondizAttuale.equals("Prop."))
//								? this.dataDecorrenzaProposta
//								: (codOrigineCondizAttuale.equals("App."))
//										? this.dataDecorrenzaApprovata
//										: this.dataDecorrenzaAttuale)
//						: "");
//
//		result.element("dataScadenza",
//				(!this.controllata)
//						? ((codOrigineCondizAttuale.equals("Prop."))
//								? this.dataScadenzaProposta
//								: (codOrigineCondizAttuale.equals("App."))
//										? this.dataScadenzaApprovata
//										: this.dataScadenzaAttuale)
//						: "");
//
//		result.element("checkCondizione", this.checked);
//		result.element("blindata", this.flagBlindatura);
//		result.element("controllata", this.controllata);
//		result.element("correlata", this.correlata);
//		result.element("scollegata", this.azione.equals("S") ? true : false);
//		result.element("parametrata", this.parametrata);
//		result.element("formulaAttuale", this.formulaAttuale);
//		result.element("formulaStandard", this.formulaStandard);
//		result.element("formulaProposta", this.formulaProposta);
//		result.element("formulaApprovata", this.formulaApprovata);
//		result.element("codiceErrore", this.codiceErrore);
//		result.element("autonomia", this.autonomia);
//		result.element("messaggioErrore", this.messaggioErrore);
//		result.element("indPresenzaStandard", this.indPresenzaStandard);
//		result.element("segnoValoreStandard", this.segnoValoreStandard);
//		result.element("valNumericoStandard", this.valNumericoStandard);
//		result.element("tipoEntitaAdesione", this.tipoEntitaAdesione);
//
//		result.element("indPresenzaValoreTrimestrePrec",
//				this.indPresenzaValoreTrimestrePrec);
//		result.element("segnoValoreTrimestrePrec",
//				this.segnoValoreTrimestrePrec);
//		result.element("valoreTrimestrePrec", this.valoreTrimestrePrec);
//
//		result.element("valCodiceStandard", this.valCodiceStandard);
//		result.element("descCodiceStandard", this.descCodiceStandard);
//
//		result.element("strListaControllateInCompilaProposta",
//				getStringListaControllateInCompilaProposta());
//		result.element("soloScollegabileDaPropostaNormale",
//				this.soloScollegabileDaPropostaNormale);
//
//		result.element("descUnitaMisura", this.descUnitaMisura);
//		result.element("valoreCondizioneSenzaUDM", (this.tipoValore.equals("1"))
//				? this.valNumericoAttuale
//				: "[" + this.valCodiceAttuale + "] " + this.descCodiceAttuale);
//
//		// aggiunti x proposta rapporto
//		result.element("descCondizione", this.descCondizione);
//		result.element("descOrigineCondizAttuale",
//				this.descOrigineCondizAttuale);
//		result.element("tipoValore", this.tipoValore);
//		result.element("valNumericoAttuale", this.valNumericoAttuale);
//		result.element("valCodiceAttuale", this.valCodiceAttuale);
//		result.element("valCodiceProposto", this.valCodiceProposto);
//		result.element("descCodiceAttuale", this.descCodiceAttuale);
//		result.element("descrizioneValoreProposto",
//				this.descrizioneValoreProposto);
//		result.element("descrizioneValoreProposto_SHORT",
//				this.getDescrizioneValoreProposto_SHORT());
//		result.element("valoreTestoAttuale", this.valoreTestoAttuale);
//		result.element("valoreTestoAttuale_SHORT",
//				this.getValoreTestoAttuale_SHORT());
//		result.element("indValore", this.indValore);
//		result.element("dataDecorrenzaAttuale", this.dataDecorrenzaAttuale);
//		result.element("dataScadenzaAttuale", this.dataScadenzaAttuale);
//		result.element("dataDecorrenzaProposta", this.dataDecorrenzaProposta);
//		result.element("dataScadenzaProposta", this.dataScadenzaProposta);
//		result.element("regime", this.regime);
//		result.element("codiceRegime", this.codiceRegime);
//		result.element("controllata", this.controllata);
//		result.element("infoSelezionabilitaScollegabilita",
//				this.infoSelezionabilitaScollegabilita);
//		result.element("strControllate", this.strControllate);
//		result.element("strCorrelate",
//				this.getInfoSelezionabilitaScollegabilita()
//						.getStrCodiciCondCorrelate());
//		result.element("controllataTasso", this.controllataTasso);
//		result.element("controllataScaglione", this.controllataScaglione);
//		result.element("parametrata", this.parametrata);
//		result.element("valoreMassimo", this.valoreMassimo);
//		result.element("valoreMinimo", this.valoreMinimo);
//		result.element("indPresenzaStandard", this.indPresenzaStandard);
//		result.element("segnoValoreStandard", this.segnoValoreStandard);
//		result.element("valNumericoStandard", this.valNumericoStandard);
//		result.element("valCodiceStandard", this.valCodiceStandard);
//		result.element("descCodiceStandard", this.descCodiceStandard);
//		result.element("formatoCifreIntere", this.formatoCifreIntere);
//		result.element("formatoCifreDecimali", this.formatoCifreDecimali);
//		result.element("minDataDeco", this.minDataDeco);
//		result.element("maxDataDeco", this.maxDataDeco);
//		result.element("gestioneDatePos", this.gestioneDatePos);
//		result.element("messaggioErrore", this.messaggioErrore);
//		result.element("peggiorativa", this.peggiorativa);
//		result.element("azione", this.azione);
//		result.element("parametriCondizioneDeroga",
//				this.parametriCondizioneDeroga);
//		result.element("parametriCondizioneDerogaApprovati",
//				this.parametriCondizioneDerogaApprovati);
//		result.element("parametriCondizioneDerogaAttuali",
//				this.parametriCondizioneDerogaAttuali);
//		result.element("valNumericoProposto", this.valNumericoProposto);
//		result.element("stringaFacolta", this.getStringaFacolta());
//		result.element("stringaFacoltaParametrata",
//				this.getStringaFacoltaParametrata());
//		result.element("facoltaUoSup", this.getFacoltaUoSup());
//		result.element("facoltaUoSupParametrata",
//				this.getFacoltaUoSupParametrata());
//		result.element("valNumericoApprovato", this.valNumericoApprovato);
//		result.element("valCodiceApprovato", this.valCodiceApprovato);
//		result.element("descCodiceApprovato", this.descCodiceApprovato);
//		result.element("descCodiceApprovato_SHORT",
//				this.getDescCodiceApprovato_SHORT());
//		result.element("datiPartitaPortafoglio", this.datiPartitaPortafoglio);
//		result.element("primaControllata", this.primaControllata);
//		result.element("TIPO_OPERAZIONE", this.getTIPO_OPERAZIONE());
//		result.element("dataDecorrenzaApprovata",
//				this.getDataDecorrenzaApprovata());
//		result.element("dataScadenzaApprovata",
//				this.getDataScadenzaApprovata());
//		result.element("codDivisa", this.getCodDivisa());
//		result.element("descrizioneValoreProposto",
//				this.getDescrizioneValoreProposto());
//		result.element("valoreTestoProposto", this.getValoreTestoProposto());
//		result.element("descFacoltaUoSup", this.getDescFacoltaUoSup());
//		result.element("indVersoMigliorativo", this.getIndVersoMigliorativo());
//		result.element("codOrigineCondizAttuale",
//				this.getCodOrigineCondizAttuale());
//		result.element("indEsclVecchiaBersani",
//				this.getIndEsclVecchiaBersani());
//		result.element("indScadenzaObbligatoria",
//				this.getIndScadenzaObbligatoria());
//		result.element("minScadenzaObbligatoria",
//				this.getMinScadenzaObbligatoria());
//		result.element("maxScadenzaObbligatoria",
//				this.getMaxScadenzaObbligatoria());
//
//		result.element("eva", this.isEva());
//		result.element("segnoEva", this.getSegnoEva());
//		result.element("valoreEva", this.getValoreEva().replace('.', ','));
//		result.element("presenzaEva", this.getPresenzaEva());
//		result.element("prevedeEva", this.getPrevedeEva());
//		result.element("indControlloCrescenza",
//				this.getIndControlloCrescenza());
//
//		result.element("sottoCondizione", this.getCodiceSottocondizione());
//		result.element("condizioneTassoSpread",
//				this.getIndCondizioneTassoSpread());
//
//		result.element("regimeSconto", this.isRegimeSconto());
//		result.element("assoggettataARegimeSconto",
//				this.isAssoggettataARegimeSconto());
//		result.element("codiceRegimeSconto", this.getCodiceRegimeSconto());
//		result.element("facoltaApice", this.getFacoltaApice());
//		result.element("tipoOperazioneObbligatoria",
//				this.getTipoOperazioneObbligatoria());
//		result.element("condizionePriceLab", this.isCondizionePriceLab());
//		result.element("derogaObbligata", this.isDerogaObbligata());
//
//		result.element("idLineaPrange", this.getIdLineaPrange());
//		result.element("idPraticaPrange", this.getIdPraticaPrange());
//		result.element("idScenarioPrange", this.getIdScenarioPrange());
//		result.element("idCondizionePrange", this.getIdCondizionePrange());
//		result.element("codCondizionePrange", this.getCodCondizionePrange());
//		result.element("formaTecnicaPrange", this.getFormaTecnicaPrange());
//		result.element("valuePrangeHost",
//				this.getIdPraticaPrange() + "-" + this.getIdLineaPrange() + "-"
//						+ this.getIdScenarioPrange() + "-"
//						+ this.getFormaTecnicaPrange().trim() + "-"
//						+ this.getCodCondizionePrange().trim());
//		result.element("tipoDeroga", this.getTipoDeroga());
//		result.element("presentiFasceSuConvenzioneProposto",
//				this.isPresentiFasceSuConvenzioneProposto());
//		result.element("fasceSuConvenzioneProposto",
//				this.getFasceSuConvenzioneProposto());
//		result.element("presentiFasceSuConvenzioneApprovato",
//				this.isPresentiFasceSuConvenzioneApprovato());
//		result.element("fasceSuConvenzioneApprovato",
//				this.getFasceSuConvenzioneApprovato());
//		result.element("valNumericoPostConvProposto",
//				this.getValNumericoPostConvProposto());
//		result.element("valCodicePostConvProposto",
//				this.getValCodicePostConvProposto());
//		result.element("descCodicePostConvProposto",
//				this.getDescCodicePostConvProposto());
//		result.element("descCodicePostConvProposto_SHORT",
//				this.getDescCodicePostConvProposto_SHORT());
//		result.element("parametriCondizioneDerogaPostConvProposti",
//				this.getParametriCondizioneDerogaPostConvProposti());
//		result.element("valNumericoPostConvApprovato",
//				this.getValNumericoPostConvApprovato());
//		result.element("valCodicePostConvApprovato",
//				this.getValCodicePostConvApprovato());
//		result.element("descCodicePostConvApprovato",
//				this.getDescCodicePostConvApprovato());
//		result.element("descCodicePostConvApprovato_SHORT",
//				this.getDescCodicePostConvApprovato_SHORT());
//		result.element("parametriCondizioneDerogaPostConvApprovati",
//				this.getParametriCondizioneDerogaPostConvApprovati());
//		result.element("formulaPropostaPostConvenzione",
//				this.getFormulaPropostaPostConvenzione());
//		result.element("formulaApprovataPostConvenzione",
//				this.getFormulaApprovataPostConvenzione());
//
//		result.element("tassoPlus", this.isTassoPlus());
//		result.element("regimeIsTassoPlus", this.isRegimeIsTassoPlus());
//		result.element("descCodiceAttuale_SHORT",
//				this.getDescCodiceAttualeSottocondizione_SHORT());
//		result.element("popupPerConvenzioneModificato",
//				this.isPopupPerConvenzioneModificato());
//		result.element("popupFasceModificatoInIter",
//				this.isPopupFasceModificatoInIter());
//
//		result.element("TIPO_OPERAZIONE_PCV", this.getTIPO_OPERAZIONE_PCV());
//		result.element("tipoCondizione", tipoCondizione);
//
//		result.element("controllataCommissione",
//				this.isControllataCommissione());
//
//		// AGGIUNTA 21/9/2015 PER COERENZA CON PCEE
//		result.element("flagDisabilitaMonitoraggio",
//				this.flagDisabilitaMonitoraggio);
//
//		result.element("indTipoCorr", this.indTipoCorr);
//		result.element("strCorrelateFull", this.strCorrelateFull);
//		result.element("strCorrelateTecniche", this.strCorrelateTecniche);
//		result.element("strCorrelateCompatibilita",
//				this.strCorrelateCompatibilita);
//		result.element("strCorrelateLight", this.strCorrelateLight);
//		result.element("strCorrelateAll", this.strCorrelateAll);
//		result.element("pacchettoCorr", this.pacchettoCorr);
//		result.element("pacchettoCorrTecniche", this.pacchettoCorrTecniche);
//		result.element("indCapoFila", this.indCapoFila);
//		result.element("indCapoFilaTecnica", this.indCapoFilaTecnica);
//
//		// AGGIUNTA 04/11/2015 PER MIGLIORIE PRICE
//		result.element("flagObbligatoriaMlt", this.flagObbligatoriaMlt);
//
//		// TASSINEG2016
//		result.element("tipoCondizioneAttMst", this.tipoCondizioneAttMst);
//		result.element("segnoValNumericoApprovato",
//				this.segnoValNumericoApprovato);
//		result.element("segnoValNumericoAttuale", this.segnoValNumericoAttuale);
//		result.element("segnoValNumericoProposto",
//				this.segnoValNumericoProposto);
//
//		// EVACORP2016
//		result.element("flagEvaNonObbligatorio", this.flagEvaNonObbligatorio);
//
//		// CONVENZIONI CON COVENANT
//		result.element("presenteCovenantProposto",
//				this.isPresenteCovenantProposto());
//		result.element("presenteCovenantAttuale",
//				this.isPresenteCovenantAttuale());
//		result.element("presenteCovenantApprovato",
//				this.isPresenteCovenantApprovato());
//		result.element("presenteCovenant", this.isPresenteCovenant());
//		result.element("covenantAttuale", this.getCovenantAttuale());
//		result.element("covenantSelezionato", this.getCovenantSelezionato());
//		result.element("covenantProposto", this.getCovenantProposto());
//		result.element("prevedeCovenants", this.isPrevedeCovenants());
//		result.element("covenants", JsonUtil.toJSONObject(this.getCovenants()));
//		result.element("famigliaCond", this.getFamigliaCond());
//		result.element("presenzaFasceAllaData", this.isPresenzaFasceAllaData());
//		result.element("presenteValorePostConv",
//				this.isPresenteValorePostConv());
//		// CONVENZIONI BDR
//		result.element("spreadBDR", this.isSpreadBDR());
//		result.element("importoBDR_Da", this.getImportoBDR_Da());
//		result.element("importoBDR_A", this.getImportoBDR_A());
//		result.element("dataScadenzaBDR_Da", this.getDataScadenzaBDR_Da());
//		result.element("dataScadenzaBDR_A", this.getDataScadenzaBDR_A());
//		result.element("listaDurateAmmesseBDR",
//				JsonUtil.toJSONObject(this.getListaDurateAmmesseBDR()));
//		result.element("valoreCondizioneFLOOR",
//				this.getValoreCondizioneFLOOR());
//		result.element("valoreCondizioneCAP", this.getValoreCondizioneCAP());
//		result.element("durataBDR_Selezionata",
//				this.getDurataBDR_Selezionata());
//		result.element("dataScadenzaBDR_Selezionata",
//				this.getDataScadenzaBDR_Selezionata());
//		result.element("indTITmanualeBDR", this.isIndTITmanualeBDR());
//		result.element("penaleEstinzioneAzzerataBDR",
//				this.isPenaleEstinzioneAzzerataBDR());
//		result.element("indVersoMigliorativoTassoCreditoreBDR",
//				this.getIndVersoMigliorativoTassoCreditoreBDR());
//		result.element("descUnitaMisuraTassoCreditoreBDR",
//				this.getDescUnitaMisuraTassoCreditoreBDR());
//
//		// GERARCHIA
//		result.element("livelloGerarchia", this.getLivelloGerarchia());
//		result.element("condizionePrimoLivelloGerarchia",
//				this.getCondizionePrimoLivelloGerarchia());
//		result.element("condizioneRegolaGerarchia",
//				this.getCondizioneRegolaGerarchia());
//		result.element("strCondizioniGerarchia",
//				this.getStrCondizioniGerarchia());
//		// result.element("strOutGER", this.strOutGER);
//		result.element("strControllateGerarchia",
//				this.getStrControllateGerarchia());
//		result.element("strControllatePrimoLivelloGerarchia",
//				this.getStrControllatePrimoLivelloGerarchia());
//
//		result.element("strValoreAttualeCondizioniGerarchia",
//				this.getStrValoreAttualeCondizioniGerarchia());
//		result.element("dataPubblicazioneGerarchia",
//				this.getDataPubblicazioneGerarchia());
//		result.element("valoreRegolaGerarchia",
//				this.getValoreRegolaGerarchia());
//		if (!this.getListFiglie().isEmpty())
//			result.element("listFiglie", this.getListFiglie());
//
//		result.element("valNumericoAttualeGerarchia",
//				this.getValNumericoAttualeGerarchia());
//		result.element("segnoValoreAttualeGerarchia",
//				this.getSegnoValoreAttualeGerarchia());
//		result.element("valNumericoStandardGerarchia",
//				this.getValNumericoStandardGerarchia());
//		result.element("segnoValoreStandardGerarchia",
//				this.getSegnoValoreStandardGerarchia());
//		result.element("codiceValoreStandardGerarchia",
//				this.getCodiceValoreStandardGerarchia());
//		result.element("codiceValoreAttualeGerarchia",
//				this.getCodiceValoreAttualeGerarchia());
//
//		result.element("valoreCondizioneGerarchiaSenzaUDM",
//				(this.tipoValore.equals("1"))
//						? this.valNumericoAttualeGerarchia
//						: "[" + this.codiceValoreAttualeGerarchia + "] "
//								+ this.descCodiceAttuale);
//
//		// MLT
//		result.element("progressivoSequenzaMLT", this.progressivoSequenzaMLT);
//
//		// nel popup fasce i valori codiceFasciaConvenzione e
//		// numeroFasciaConvenzione hanno nome codiceFasciaBeneficio e
//		// numeroFasciaBeneficio
//		result.element("codiceFasciaBeneficio",
//				this.getCodiceFasciaBeneficio());
//		result.element("numeroFasciaBeneficio",
//				this.getNumeroFasciaBeneficio());
//
//		result.element("descAggValCodice", this.getDescAggValCodice());
//
//		result.element("descAggValCodice2", this.getDescAggValCodice2());
//
//		result.element("flagFasce", this.getFlagFasce());
//		result.element("CD_CONDIZIONE_MACROGRUPPO",
//				this.getCD_CONDIZIONE_MACROGRUPPO());
//
//		// ROLLING
//		result.element("isPresenteDerogaRollingProposto",
//				this.isPresenteDerogaRollingProposto());
//		result.element("isPresenteDerogaRollingApprovato",
//				this.isPresenteDerogaRollingApprovato());
//		result.element("TIPO_OPERAZIONE_ROLLING", this.TIPO_OPERAZIONE_ROLLING);
//		result.element("valNumericoRollingProposto",
//				this.valNumericoRollingProposto);
//		result.element("valCodiceRollingProposto",
//				this.valCodiceRollingProposto);
//		result.element("descCodiceRollingProposto",
//				this.descCodiceRollingProposto);
//		result.element("parametriCondizioneDerogaRollingProposti",
//				this.parametriCondizioneDerogaRollingProposti);
//		result.element("valNumericoRollingApprovato",
//				this.valNumericoRollingApprovato);
//		result.element("valCodiceRollingApprovato",
//				this.valCodiceRollingApprovato);
//		result.element("descCodiceRollingApprovato",
//				this.descCodiceRollingApprovato);
//		result.element("parametriCondizioneDerogaRollingApprovati",
//				this.parametriCondizioneDerogaRollingApprovati);
//		result.element("valNumericoRollingAttuale",
//				this.valNumericoRollingAttuale);
//		result.element("valCodiceRollingAttuale", this.valCodiceRollingAttuale);
//		result.element("descCodiceRollingAttuale",
//				this.descCodiceRollingAttuale);
//		result.element("parametriCondizioneDerogaRollingAttuali",
//				this.parametriCondizioneDerogaRollingAttuali);
//		result.element("durataRollingProposto", this.durataRollingProposto);
//		result.element("durataRollingApprovato", this.durataRollingApprovato);
//		result.element("durataRollingAttuale", this.durataRollingAttuale);
//		result.element("durataRollingMax", this.durataRollingMax);
//		result.element("formulaParametriRollingProposti",
//				this.formulaParametriRollingProposti);
//		result.element("formulaParametriRollingApprovati",
//				this.formulaParametriRollingApprovati);
//		result.element("formulaParametriRollingAttuali",
//				this.formulaParametriRollingAttuali);
//
//		result.element("presenzaRollingAllaData",
//				this.isPresenzaRollingAllaData());
//
//		result.element("bonusVenduto", this.getBonusVenduto());
//
//		result.element("indCondizioneTassoSpread",
//				this.getIndCondizioneTassoSpread());
//		result.element("indValorePDR", this.getIndValorePDR());
//
//		result.element("codiceProdottoJBilling",
//				this.getCodiceProdottoJBilling());
//		result.element("descrizioneProdottoJBilling",
//				this.getDescrizioneProdottoJBilling());
//		result.element("progressivoJBilling", this.getProgressivoJBilling());
//		result.element("soggettaARegolaDiBilling",
//				this.getSoggettaARegolaDiBilling());
//		result.element("codiceScenario", this.getCodiceScenario());
//		result.element("billingAccount", this.getBillingAccount());
//
//		result.element("indStampaPresenteCovenant",
//				this.getIndStampaPresenteCovenant());
//
//		return result;
//	}
}
