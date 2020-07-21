//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 11:01:01 AM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzioniservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.intesasanpaolo.connector.ws.gen.convenzioniservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AdesioneRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Adesione_Request");
    private final static QName _ArrayOfCodiceFiscale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfCodiceFiscale");
    private final static QName _CodiceFiscale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CodiceFiscale");
    private final static QName _AdesioneResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Adesione_Response");
    private final static QName _ClassEsito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Class.Esito");
    private final static QName _ArrayOfAdesioneResponseBenefici_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfAdesione_Response.Benefici");
    private final static QName _AdesioneResponseBenefici_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Adesione_Response.Benefici");
    private final static QName _AdesioneResponseBeneficioValoreParametrato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Adesione_Response.beneficio_ValoreParametrato");
    private final static QName _ArrayOfAdesioneResponseAdesioneDettaglio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfAdesione_Response.Adesione_Dettaglio");
    private final static QName _AdesioneResponseAdesioneDettaglio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Adesione_Response.Adesione_Dettaglio");
    private final static QName _AnagraficaRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Anagrafica_Request");
    private final static QName _AnagraficaResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Anagrafica_Response");
    private final static QName _ResponseLog_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.Entities", "ResponseLog");
    private final static QName _ConfigurazioneFasce_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Configurazione_Fasce");
    private final static QName _ArrayOfFasce_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfFasce");
    private final static QName _Fasce_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Fasce");
    private final static QName _ValoreIndicatore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Indicatore");
    private final static QName _Valore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore");
    private final static QName _BloccoValore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Blocco_Valore");
    private final static QName _ValoreParametrato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Parametrato");
    private final static QName _Convenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Convenzione");
    private final static QName _Controparte_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Controparte");
    private final static QName _Delibera_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Delibera");
    private final static QName _UserInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "UserInfo");
    private final static QName _ArrayOfCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfCondizione");
    private final static QName _Condizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Condizione");
    private final static QName _ArrayOfIndicatoreDifferenziazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfIndicatore_Differenziazione");
    private final static QName _IndicatoreDifferenziazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Indicatore_Differenziazione");
    private final static QName _FasciaFatturato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "FasciaFatturato");
    private final static QName _FasciaPortafoglioSSC_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "FasciaPortafoglioSSC");
    private final static QName _ArrayOfPortafoglioAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfPortafoglio_Adesione");
    private final static QName _PortafoglioAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Portafoglio_Adesione");
    private final static QName _ArrayOfRating_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfRating");
    private final static QName _Rating_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Rating");
    private final static QName _ArrayOfRequisitiAdesioneGenerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfRequisitiAdesioneGenerico");
    private final static QName _RequisitiAdesioneGenerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "RequisitiAdesioneGenerico");
    private final static QName _ArrayOfRequisitiEstinzioneGenerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ArrayOfRequisitiEstinzioneGenerico");
    private final static QName _RequisitiEstinzioneGenerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "RequisitiEstinzioneGenerico");
    private final static QName _Proposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Proposta");
    private final static QName _ReqAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Req_Adesione");
    private final static QName _ReqEstinzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Req_Estinzione");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _GetRequisitiAdesioneConvenzioneInput_QNAME = new QName("http://tempuri.org/", "input");
    private final static QName _GetRequisitiAdesioneConvenzioneResponseGetRequisitiAdesioneConvenzioneResult_QNAME = new QName("http://tempuri.org/", "GetRequisitiAdesioneConvenzioneResult");
    private final static QName _GetAnagraficaConvenzioneResponseGetAnagraficaConvenzioneResult_QNAME = new QName("http://tempuri.org/", "GetAnagraficaConvenzioneResult");
    private final static QName _ReqEstinzioneAccreditoStipendio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "AccreditoStipendio");
    private final static QName _ReqEstinzioneDataScadenza_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DataScadenza");
    private final static QName _ReqEstinzioneDataValidataDocumento_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Data_Validata_Documento");
    private final static QName _ReqEstinzioneEstinzioneAnticipata_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "EstinzioneAnticipata");
    private final static QName _ReqEstinzioneMancataAttivazioneROL_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Mancata_Attivazione_ROL");
    private final static QName _ReqEstinzionePresenzaGaranzieEleggibile_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Presenza_Garanzie_Eleggibile");
    private final static QName _ReqEstinzioneRateImpagateMLT_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "RateImpagate_MLT");
    private final static QName _ReqEstinzioneSconfinamentoBT_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Sconfinamento_BT");
    private final static QName _ReqAdesioneAdesioneDataAccensione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Adesione_Data_Accensione");
    private final static QName _ReqAdesioneDataAccensione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DataAccensione");
    private final static QName _ReqAdesioneEvaCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "EvaCliente");
    private final static QName _ReqAdesioneEvaClienteA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "EvaCliente_A");
    private final static QName _ReqAdesioneEvaClienteDa_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "EvaCliente_Da");
    private final static QName _ReqAdesioneFatturato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Fatturato");
    private final static QName _ReqAdesioneFatturatoA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Fatturato_A");
    private final static QName _ReqAdesioneFatturatoDa_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Fatturato_Da");
    private final static QName _ReqAdesioneFlagDataAccensione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Flag_Data_Accensione");
    private final static QName _ReqAdesioneMinter_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Minter");
    private final static QName _ReqAdesioneMinterA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Minter_A");
    private final static QName _ReqAdesioneMinterDA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Minter_DA");
    private final static QName _ReqAdesionePortafoglio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Portafoglio");
    private final static QName _ReqAdesioneROL_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ROL");
    private final static QName _ReqAdesioneRatingOnline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "RatingOnline");
    private final static QName _ReqAdesioneVersoControllo_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "VersoControllo");
    private final static QName _PropostaDataProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DataProposta");
    private final static QName _PropostaNumeroProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "NumeroProposta");
    private final static QName _RequisitiEstinzioneGenericoCodiceRequisito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "CodiceRequisito");
    private final static QName _RequisitiEstinzioneGenericoListaEntita_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaEntita");
    private final static QName _RequisitiEstinzioneGenericoListaValori_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaValori");
    private final static QName _PortafoglioAdesioneIndicazionePortafoglio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Indicazione_Portafoglio");
    private final static QName _PortafoglioAdesioneTipologiaPortafoglio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Tipologia_Portafoglio");
    private final static QName _FasciaPortafoglioSSCSSCGruppo_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "SSC_Gruppo");
    private final static QName _FasciaFatturatoFatturatoA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "FatturatoA");
    private final static QName _FasciaFatturatoFatturatoDA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "FatturatoDA");
    private final static QName _CondizioneCodiceCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codice_Condizione");
    private final static QName _CondizioneConfigurazioneFasceApprovato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Configurazione_Fasce_Approvato");
    private final static QName _CondizioneConfigurazioneFasceProposto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Configurazione_Fasce_Proposto");
    private final static QName _CondizioneDataDecorrenzaApprovata_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Data_Decorrenza_Approvata");
    private final static QName _CondizioneDataDecorrenzaProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Data_Decorrenza_Proposta");
    private final static QName _CondizioneDataScadenzaApprovata_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Data_Scadenza_Approvata");
    private final static QName _CondizioneDataScadenzaProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Data_Scadenza_Proposta");
    private final static QName _CondizioneTipoValore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "TipoValore");
    private final static QName _CondizioneValoreApprovato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Approvato");
    private final static QName _CondizioneValorePostApprovato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Post_Approvato");
    private final static QName _CondizioneValorePostProposto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Post_Proposto");
    private final static QName _CondizioneValoreProposto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Proposto");
    private final static QName _UserInfoUserABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "UserABI");
    private final static QName _UserInfoUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "UserId");
    private final static QName _UserInfoUserUO_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "UserUO");
    private final static QName _DeliberaDataDelibera_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DataDelibera");
    private final static QName _ControparteDenominazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Denominazione");
    private final static QName _ControparteNDG_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "NDG");
    private final static QName _ControparteSegmentoRegolamentare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Segmento_Regolamentare");
    private final static QName _ConvenzioneCodiceABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "CodiceABI");
    private final static QName _ConvenzioneCodiceConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "CodiceConvenzione");
    private final static QName _ConvenzioneControGaranziaStato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ControGaranzia_Stato");
    private final static QName _ConvenzioneDataDecorrenza_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DataDecorrenza");
    private final static QName _ConvenzioneDescrizioneConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "DescrizioneConvenzione");
    private final static QName _ConvenzioneListaCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaCondizione");
    private final static QName _ConvenzioneListaIndicatoreDifferenziazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaIndicatore_Differenziazione");
    private final static QName _ConvenzioneListaPortafoglioAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaPortafoglio_Adesione");
    private final static QName _ConvenzioneListaRating_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaRating");
    private final static QName _ConvenzioneListaRequisitiAdesioneGenerici_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaRequisitiAdesioneGenerici");
    private final static QName _ConvenzioneListaRequisitiEstinzioneGenerici_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaRequisitiEstinzioneGenerici");
    private final static QName _ConvenzionePresenzaGaranzia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Presenza_Garanzia");
    private final static QName _ConvenzioneRequisitiAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Requisiti_Adesione");
    private final static QName _ConvenzioneRequisitiEstinzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Requisiti_Estinzione");
    private final static QName _ConvenzioneStato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Stato");
    private final static QName _ConvenzioneTipoDifferenziazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Tipo_Differenziazione");
    private final static QName _ValoreParametratoCodice1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codice1");
    private final static QName _ValoreParametratoPerc1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Perc1");
    private final static QName _ValoreParametratoSpread_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Spread");
    private final static QName _BloccoValoreCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codice");
    private final static QName _BloccoValoreTipoDeroga_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "TipoDeroga");
    private final static QName _BloccoValoreValoreNumerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Valore_Numerico");
    private final static QName _ValoreBlocco_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Blocco");
    private final static QName _ValoreIndicatoreAlfanumericoSogliaA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "AlfanumericoSoglia_A");
    private final static QName _ValoreIndicatoreAlfanumericoSogliaDa_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "AlfanumericoSoglia_Da");
    private final static QName _ValoreIndicatoreCodiceFasciaIndicatore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codice_Fascia_Indicatore");
    private final static QName _ValoreIndicatoreNumericoSogliaA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "NumericoSoglia_A");
    private final static QName _ValoreIndicatoreNumericoSogliaDa_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "NumericoSoglia_Da");
    private final static QName _ValoreIndicatoreTipoIndicatore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "TipoIndicatore");
    private final static QName _ConfigurazioneFasceCodiceFasciaIndicatoreBeneficiIn_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codice_Fascia_Indicatore_Benefici_In");
    private final static QName _ConfigurazioneFasceCodificaIndicatore_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Codifica_Indicatore");
    private final static QName _ConfigurazioneFasceDisabilitaMonitoraggio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Disabilita_Monitoraggio");
    private final static QName _ConfigurazioneFasceListaFasce_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "ListaFasce");
    private final static QName _ConfigurazioneFascePeriodicita_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", "Periodicita");
    private final static QName _ResponseLogErrorDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.Entities", "ErrorDescription");
    private final static QName _AdesioneResponseAdesioneDettaglioFlagRequisito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "flagRequisito");
    private final static QName _AdesioneResponseAdesioneDettaglioIndicatoreRequisito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "indicatoreRequisito");
    private final static QName _AdesioneResponseAdesioneDettaglioValoreAlfanumericoRequisito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "valoreAlfanumericoRequisito");
    private final static QName _AdesioneResponseAdesioneDettaglioValoreNumericoRequisisto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "valoreNumericoRequisisto");
    private final static QName _AdesioneResponseBeneficioValoreParametratoParametroCodice1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "parametro_Codice1");
    private final static QName _AdesioneResponseBeneficioValoreParametratoParametroPerc1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "parametro_Perc1");
    private final static QName _AdesioneResponseBeneficioValoreParametratoParametroSpread_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "parametro_Spread");
    private final static QName _AdesioneResponseBeneficiConfigurazioneFasceApprovato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Configurazione_Fasce_Approvato");
    private final static QName _AdesioneResponseBeneficiBeneficioTipologia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "beneficio_Tipologia");
    private final static QName _AdesioneResponseBeneficiBeneficioValoreCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "beneficio_ValoreCodice");
    private final static QName _AdesioneResponseBeneficiBeneficioValoreNumerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "beneficio_ValoreNumerico");
    private final static QName _AdesioneResponseBeneficiBeneficioValoreParametrato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "beneficio_ValoreParametrato");
    private final static QName _AdesioneResponseBeneficiCodiceCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceCondizione");
    private final static QName _AdesioneResponseBeneficiCodiceFascia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceFascia");
    private final static QName _AdesioneResponseBeneficiDataDecorrenza_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "dataDecorrenza");
    private final static QName _AdesioneResponseBeneficiDataScadenza_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "dataScadenza");
    private final static QName _AdesioneResponseBeneficiDriver1Tipologia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver1_Tipologia");
    private final static QName _AdesioneResponseBeneficiDriver1ValoreCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver1_ValoreCodice");
    private final static QName _AdesioneResponseBeneficiDriver1ValoreNumerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver1_ValoreNumerico");
    private final static QName _AdesioneResponseBeneficiDriver2Tipologia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver2_Tipologia");
    private final static QName _AdesioneResponseBeneficiDriver2ValoreCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver2_ValoreCodice");
    private final static QName _AdesioneResponseBeneficiDriver2ValoreNumerico_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "driver2_ValoreNumerico");
    private final static QName _AdesioneResponseBeneficiFlagRolling_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "flagRolling");
    private final static QName _AdesioneResponseBeneficiNumeroFascia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "numeroFascia");
    private final static QName _ClassEsitoErrorMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "errorMessage");
    private final static QName _ClassEsitoResultCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "resultCode");
    private final static QName _CodiceFiscaleCF_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CF");
    private final static QName _AnagraficaResponseEsito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Esito");
    private final static QName _AnagraficaResponseResponseLog_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ResponseLog");
    private final static QName _AnagraficaResponseNumeroProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "numeroProposta");
    private final static QName _AnagraficaRequestConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Convenzione");
    private final static QName _AdesioneResponseTabellaBenefici_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "TabellaBenefici");
    private final static QName _AdesioneResponseTabellaRequisiti_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "TabellaRequisiti");
    private final static QName _AdesioneRequestABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ABI");
    private final static QName _AdesioneRequestApplicativoId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ApplicativoId");
    private final static QName _AdesioneRequestCodiceConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Codice_Convenzione");
    private final static QName _AdesioneRequestDataAccensione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "DataAccensione");
    private final static QName _AdesioneRequestDataAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Data_Adesione");
    private final static QName _AdesioneRequestFiliale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Filiale");
    private final static QName _AdesioneRequestFlagTipoCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Flag_Tipo_Cliente");
    private final static QName _AdesioneRequestListaCodiciFiscali_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaCodiciFiscali");
    private final static QName _AdesioneRequestNDG_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "NDG");
    private final static QName _AdesioneRequestPIVA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "PIVA");
    private final static QName _AdesioneRequestROL_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ROL");
    private final static QName _AdesioneRequestRapportoCategoria_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Categoria");
    private final static QName _AdesioneRequestRapportoCategoriaStipendio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Categoria_Stipendio");
    private final static QName _AdesioneRequestRapportoCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Codice");
    private final static QName _AdesioneRequestRapportoCodiceStipendio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Codice_Stipendio");
    private final static QName _AdesioneRequestRapportoFiliale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Filiale");
    private final static QName _AdesioneRequestRapportoFilialeStipendio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Filiale_Stipendio");
    private final static QName _AdesioneRequestRating_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rating");
    private final static QName _AdesioneRequestTipoChiamata_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Tipo_Chiamata");
    private final static QName _AdesioneRequestUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "UserId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.intesasanpaolo.connector.ws.gen.convenzioniservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRequisitiAdesioneConvenzione }
     * 
     */
    public GetRequisitiAdesioneConvenzione createGetRequisitiAdesioneConvenzione() {
        return new GetRequisitiAdesioneConvenzione();
    }

    /**
     * Create an instance of {@link AdesioneRequest }
     * 
     */
    public AdesioneRequest createAdesioneRequest() {
        return new AdesioneRequest();
    }

    /**
     * Create an instance of {@link GetRequisitiAdesioneConvenzioneResponse }
     * 
     */
    public GetRequisitiAdesioneConvenzioneResponse createGetRequisitiAdesioneConvenzioneResponse() {
        return new GetRequisitiAdesioneConvenzioneResponse();
    }

    /**
     * Create an instance of {@link AdesioneResponse }
     * 
     */
    public AdesioneResponse createAdesioneResponse() {
        return new AdesioneResponse();
    }

    /**
     * Create an instance of {@link GetAnagraficaConvenzione }
     * 
     */
    public GetAnagraficaConvenzione createGetAnagraficaConvenzione() {
        return new GetAnagraficaConvenzione();
    }

    /**
     * Create an instance of {@link AnagraficaRequest }
     * 
     */
    public AnagraficaRequest createAnagraficaRequest() {
        return new AnagraficaRequest();
    }

    /**
     * Create an instance of {@link GetAnagraficaConvenzioneResponse }
     * 
     */
    public GetAnagraficaConvenzioneResponse createGetAnagraficaConvenzioneResponse() {
        return new GetAnagraficaConvenzioneResponse();
    }

    /**
     * Create an instance of {@link AnagraficaResponse }
     * 
     */
    public AnagraficaResponse createAnagraficaResponse() {
        return new AnagraficaResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCodiceFiscale }
     * 
     */
    public ArrayOfCodiceFiscale createArrayOfCodiceFiscale() {
        return new ArrayOfCodiceFiscale();
    }

    /**
     * Create an instance of {@link CodiceFiscale }
     * 
     */
    public CodiceFiscale createCodiceFiscale() {
        return new CodiceFiscale();
    }

    /**
     * Create an instance of {@link ClassEsito }
     * 
     */
    public ClassEsito createClassEsito() {
        return new ClassEsito();
    }

    /**
     * Create an instance of {@link ArrayOfAdesioneResponseBenefici }
     * 
     */
    public ArrayOfAdesioneResponseBenefici createArrayOfAdesioneResponseBenefici() {
        return new ArrayOfAdesioneResponseBenefici();
    }

    /**
     * Create an instance of {@link AdesioneResponseBenefici }
     * 
     */
    public AdesioneResponseBenefici createAdesioneResponseBenefici() {
        return new AdesioneResponseBenefici();
    }

    /**
     * Create an instance of {@link AdesioneResponseBeneficioValoreParametrato }
     * 
     */
    public AdesioneResponseBeneficioValoreParametrato createAdesioneResponseBeneficioValoreParametrato() {
        return new AdesioneResponseBeneficioValoreParametrato();
    }

    /**
     * Create an instance of {@link ArrayOfAdesioneResponseAdesioneDettaglio }
     * 
     */
    public ArrayOfAdesioneResponseAdesioneDettaglio createArrayOfAdesioneResponseAdesioneDettaglio() {
        return new ArrayOfAdesioneResponseAdesioneDettaglio();
    }

    /**
     * Create an instance of {@link AdesioneResponseAdesioneDettaglio }
     * 
     */
    public AdesioneResponseAdesioneDettaglio createAdesioneResponseAdesioneDettaglio() {
        return new AdesioneResponseAdesioneDettaglio();
    }

    /**
     * Create an instance of {@link ResponseLog }
     * 
     */
    public ResponseLog createResponseLog() {
        return new ResponseLog();
    }

    /**
     * Create an instance of {@link ConfigurazioneFasce }
     * 
     */
    public ConfigurazioneFasce createConfigurazioneFasce() {
        return new ConfigurazioneFasce();
    }

    /**
     * Create an instance of {@link ArrayOfFasce }
     * 
     */
    public ArrayOfFasce createArrayOfFasce() {
        return new ArrayOfFasce();
    }

    /**
     * Create an instance of {@link Fasce }
     * 
     */
    public Fasce createFasce() {
        return new Fasce();
    }

    /**
     * Create an instance of {@link ValoreIndicatore }
     * 
     */
    public ValoreIndicatore createValoreIndicatore() {
        return new ValoreIndicatore();
    }

    /**
     * Create an instance of {@link Valore }
     * 
     */
    public Valore createValore() {
        return new Valore();
    }

    /**
     * Create an instance of {@link BloccoValore }
     * 
     */
    public BloccoValore createBloccoValore() {
        return new BloccoValore();
    }

    /**
     * Create an instance of {@link ValoreParametrato }
     * 
     */
    public ValoreParametrato createValoreParametrato() {
        return new ValoreParametrato();
    }

    /**
     * Create an instance of {@link Convenzione }
     * 
     */
    public Convenzione createConvenzione() {
        return new Convenzione();
    }

    /**
     * Create an instance of {@link Controparte }
     * 
     */
    public Controparte createControparte() {
        return new Controparte();
    }

    /**
     * Create an instance of {@link Delibera }
     * 
     */
    public Delibera createDelibera() {
        return new Delibera();
    }

    /**
     * Create an instance of {@link UserInfo }
     * 
     */
    public UserInfo createUserInfo() {
        return new UserInfo();
    }

    /**
     * Create an instance of {@link ArrayOfCondizione }
     * 
     */
    public ArrayOfCondizione createArrayOfCondizione() {
        return new ArrayOfCondizione();
    }

    /**
     * Create an instance of {@link Condizione }
     * 
     */
    public Condizione createCondizione() {
        return new Condizione();
    }

    /**
     * Create an instance of {@link ArrayOfIndicatoreDifferenziazione }
     * 
     */
    public ArrayOfIndicatoreDifferenziazione createArrayOfIndicatoreDifferenziazione() {
        return new ArrayOfIndicatoreDifferenziazione();
    }

    /**
     * Create an instance of {@link IndicatoreDifferenziazione }
     * 
     */
    public IndicatoreDifferenziazione createIndicatoreDifferenziazione() {
        return new IndicatoreDifferenziazione();
    }

    /**
     * Create an instance of {@link FasciaFatturato }
     * 
     */
    public FasciaFatturato createFasciaFatturato() {
        return new FasciaFatturato();
    }

    /**
     * Create an instance of {@link FasciaPortafoglioSSC }
     * 
     */
    public FasciaPortafoglioSSC createFasciaPortafoglioSSC() {
        return new FasciaPortafoglioSSC();
    }

    /**
     * Create an instance of {@link ArrayOfPortafoglioAdesione }
     * 
     */
    public ArrayOfPortafoglioAdesione createArrayOfPortafoglioAdesione() {
        return new ArrayOfPortafoglioAdesione();
    }

    /**
     * Create an instance of {@link PortafoglioAdesione }
     * 
     */
    public PortafoglioAdesione createPortafoglioAdesione() {
        return new PortafoglioAdesione();
    }

    /**
     * Create an instance of {@link ArrayOfRating }
     * 
     */
    public ArrayOfRating createArrayOfRating() {
        return new ArrayOfRating();
    }

    /**
     * Create an instance of {@link Rating }
     * 
     */
    public Rating createRating() {
        return new Rating();
    }

    /**
     * Create an instance of {@link ArrayOfRequisitiAdesioneGenerico }
     * 
     */
    public ArrayOfRequisitiAdesioneGenerico createArrayOfRequisitiAdesioneGenerico() {
        return new ArrayOfRequisitiAdesioneGenerico();
    }

    /**
     * Create an instance of {@link RequisitiAdesioneGenerico }
     * 
     */
    public RequisitiAdesioneGenerico createRequisitiAdesioneGenerico() {
        return new RequisitiAdesioneGenerico();
    }

    /**
     * Create an instance of {@link ArrayOfRequisitiEstinzioneGenerico }
     * 
     */
    public ArrayOfRequisitiEstinzioneGenerico createArrayOfRequisitiEstinzioneGenerico() {
        return new ArrayOfRequisitiEstinzioneGenerico();
    }

    /**
     * Create an instance of {@link RequisitiEstinzioneGenerico }
     * 
     */
    public RequisitiEstinzioneGenerico createRequisitiEstinzioneGenerico() {
        return new RequisitiEstinzioneGenerico();
    }

    /**
     * Create an instance of {@link Proposta }
     * 
     */
    public Proposta createProposta() {
        return new Proposta();
    }

    /**
     * Create an instance of {@link ReqAdesione }
     * 
     */
    public ReqAdesione createReqAdesione() {
        return new ReqAdesione();
    }

    /**
     * Create an instance of {@link ReqEstinzione }
     * 
     */
    public ReqEstinzione createReqEstinzione() {
        return new ReqEstinzione();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Adesione_Request")
    public JAXBElement<AdesioneRequest> createAdesioneRequest(AdesioneRequest value) {
        return new JAXBElement<AdesioneRequest>(_AdesioneRequest_QNAME, AdesioneRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfCodiceFiscale")
    public JAXBElement<ArrayOfCodiceFiscale> createArrayOfCodiceFiscale(ArrayOfCodiceFiscale value) {
        return new JAXBElement<ArrayOfCodiceFiscale>(_ArrayOfCodiceFiscale_QNAME, ArrayOfCodiceFiscale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodiceFiscale }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodiceFiscale }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodiceFiscale")
    public JAXBElement<CodiceFiscale> createCodiceFiscale(CodiceFiscale value) {
        return new JAXBElement<CodiceFiscale>(_CodiceFiscale_QNAME, CodiceFiscale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Adesione_Response")
    public JAXBElement<AdesioneResponse> createAdesioneResponse(AdesioneResponse value) {
        return new JAXBElement<AdesioneResponse>(_AdesioneResponse_QNAME, AdesioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Class.Esito")
    public JAXBElement<ClassEsito> createClassEsito(ClassEsito value) {
        return new JAXBElement<ClassEsito>(_ClassEsito_QNAME, ClassEsito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfAdesione_Response.Benefici")
    public JAXBElement<ArrayOfAdesioneResponseBenefici> createArrayOfAdesioneResponseBenefici(ArrayOfAdesioneResponseBenefici value) {
        return new JAXBElement<ArrayOfAdesioneResponseBenefici>(_ArrayOfAdesioneResponseBenefici_QNAME, ArrayOfAdesioneResponseBenefici.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBenefici }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBenefici }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Adesione_Response.Benefici")
    public JAXBElement<AdesioneResponseBenefici> createAdesioneResponseBenefici(AdesioneResponseBenefici value) {
        return new JAXBElement<AdesioneResponseBenefici>(_AdesioneResponseBenefici_QNAME, AdesioneResponseBenefici.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Adesione_Response.beneficio_ValoreParametrato")
    public JAXBElement<AdesioneResponseBeneficioValoreParametrato> createAdesioneResponseBeneficioValoreParametrato(AdesioneResponseBeneficioValoreParametrato value) {
        return new JAXBElement<AdesioneResponseBeneficioValoreParametrato>(_AdesioneResponseBeneficioValoreParametrato_QNAME, AdesioneResponseBeneficioValoreParametrato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfAdesione_Response.Adesione_Dettaglio")
    public JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio> createArrayOfAdesioneResponseAdesioneDettaglio(ArrayOfAdesioneResponseAdesioneDettaglio value) {
        return new JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio>(_ArrayOfAdesioneResponseAdesioneDettaglio_QNAME, ArrayOfAdesioneResponseAdesioneDettaglio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponseAdesioneDettaglio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponseAdesioneDettaglio }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Adesione_Response.Adesione_Dettaglio")
    public JAXBElement<AdesioneResponseAdesioneDettaglio> createAdesioneResponseAdesioneDettaglio(AdesioneResponseAdesioneDettaglio value) {
        return new JAXBElement<AdesioneResponseAdesioneDettaglio>(_AdesioneResponseAdesioneDettaglio_QNAME, AdesioneResponseAdesioneDettaglio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Anagrafica_Request")
    public JAXBElement<AnagraficaRequest> createAnagraficaRequest(AnagraficaRequest value) {
        return new JAXBElement<AnagraficaRequest>(_AnagraficaRequest_QNAME, AnagraficaRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagraficaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnagraficaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Anagrafica_Response")
    public JAXBElement<AnagraficaResponse> createAnagraficaResponse(AnagraficaResponse value) {
        return new JAXBElement<AnagraficaResponse>(_AnagraficaResponse_QNAME, AnagraficaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.Entities", name = "ResponseLog")
    public JAXBElement<ResponseLog> createResponseLog(ResponseLog value) {
        return new JAXBElement<ResponseLog>(_ResponseLog_QNAME, ResponseLog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Configurazione_Fasce")
    public JAXBElement<ConfigurazioneFasce> createConfigurazioneFasce(ConfigurazioneFasce value) {
        return new JAXBElement<ConfigurazioneFasce>(_ConfigurazioneFasce_QNAME, ConfigurazioneFasce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfFasce")
    public JAXBElement<ArrayOfFasce> createArrayOfFasce(ArrayOfFasce value) {
        return new JAXBElement<ArrayOfFasce>(_ArrayOfFasce_QNAME, ArrayOfFasce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Fasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Fasce")
    public JAXBElement<Fasce> createFasce(Fasce value) {
        return new JAXBElement<Fasce>(_Fasce_QNAME, Fasce.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Indicatore")
    public JAXBElement<ValoreIndicatore> createValoreIndicatore(ValoreIndicatore value) {
        return new JAXBElement<ValoreIndicatore>(_ValoreIndicatore_QNAME, ValoreIndicatore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Valore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Valore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore")
    public JAXBElement<Valore> createValore(Valore value) {
        return new JAXBElement<Valore>(_Valore_QNAME, Valore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Blocco_Valore")
    public JAXBElement<BloccoValore> createBloccoValore(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_BloccoValore_QNAME, BloccoValore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Parametrato")
    public JAXBElement<ValoreParametrato> createValoreParametrato(ValoreParametrato value) {
        return new JAXBElement<ValoreParametrato>(_ValoreParametrato_QNAME, ValoreParametrato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Convenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Convenzione")
    public JAXBElement<Convenzione> createConvenzione(Convenzione value) {
        return new JAXBElement<Convenzione>(_Convenzione_QNAME, Convenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Controparte")
    public JAXBElement<Controparte> createControparte(Controparte value) {
        return new JAXBElement<Controparte>(_Controparte_QNAME, Controparte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Delibera")
    public JAXBElement<Delibera> createDelibera(Delibera value) {
        return new JAXBElement<Delibera>(_Delibera_QNAME, Delibera.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserInfo")
    public JAXBElement<UserInfo> createUserInfo(UserInfo value) {
        return new JAXBElement<UserInfo>(_UserInfo_QNAME, UserInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfCondizione")
    public JAXBElement<ArrayOfCondizione> createArrayOfCondizione(ArrayOfCondizione value) {
        return new JAXBElement<ArrayOfCondizione>(_ArrayOfCondizione_QNAME, ArrayOfCondizione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Condizione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Condizione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Condizione")
    public JAXBElement<Condizione> createCondizione(Condizione value) {
        return new JAXBElement<Condizione>(_Condizione_QNAME, Condizione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfIndicatore_Differenziazione")
    public JAXBElement<ArrayOfIndicatoreDifferenziazione> createArrayOfIndicatoreDifferenziazione(ArrayOfIndicatoreDifferenziazione value) {
        return new JAXBElement<ArrayOfIndicatoreDifferenziazione>(_ArrayOfIndicatoreDifferenziazione_QNAME, ArrayOfIndicatoreDifferenziazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndicatoreDifferenziazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IndicatoreDifferenziazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Indicatore_Differenziazione")
    public JAXBElement<IndicatoreDifferenziazione> createIndicatoreDifferenziazione(IndicatoreDifferenziazione value) {
        return new JAXBElement<IndicatoreDifferenziazione>(_IndicatoreDifferenziazione_QNAME, IndicatoreDifferenziazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FasciaFatturato")
    public JAXBElement<FasciaFatturato> createFasciaFatturato(FasciaFatturato value) {
        return new JAXBElement<FasciaFatturato>(_FasciaFatturato_QNAME, FasciaFatturato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FasciaPortafoglioSSC")
    public JAXBElement<FasciaPortafoglioSSC> createFasciaPortafoglioSSC(FasciaPortafoglioSSC value) {
        return new JAXBElement<FasciaPortafoglioSSC>(_FasciaPortafoglioSSC_QNAME, FasciaPortafoglioSSC.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfPortafoglio_Adesione")
    public JAXBElement<ArrayOfPortafoglioAdesione> createArrayOfPortafoglioAdesione(ArrayOfPortafoglioAdesione value) {
        return new JAXBElement<ArrayOfPortafoglioAdesione>(_ArrayOfPortafoglioAdesione_QNAME, ArrayOfPortafoglioAdesione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PortafoglioAdesione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PortafoglioAdesione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Portafoglio_Adesione")
    public JAXBElement<PortafoglioAdesione> createPortafoglioAdesione(PortafoglioAdesione value) {
        return new JAXBElement<PortafoglioAdesione>(_PortafoglioAdesione_QNAME, PortafoglioAdesione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfRating")
    public JAXBElement<ArrayOfRating> createArrayOfRating(ArrayOfRating value) {
        return new JAXBElement<ArrayOfRating>(_ArrayOfRating_QNAME, ArrayOfRating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Rating }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Rating }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Rating")
    public JAXBElement<Rating> createRating(Rating value) {
        return new JAXBElement<Rating>(_Rating_QNAME, Rating.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfRequisitiAdesioneGenerico")
    public JAXBElement<ArrayOfRequisitiAdesioneGenerico> createArrayOfRequisitiAdesioneGenerico(ArrayOfRequisitiAdesioneGenerico value) {
        return new JAXBElement<ArrayOfRequisitiAdesioneGenerico>(_ArrayOfRequisitiAdesioneGenerico_QNAME, ArrayOfRequisitiAdesioneGenerico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequisitiAdesioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequisitiAdesioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "RequisitiAdesioneGenerico")
    public JAXBElement<RequisitiAdesioneGenerico> createRequisitiAdesioneGenerico(RequisitiAdesioneGenerico value) {
        return new JAXBElement<RequisitiAdesioneGenerico>(_RequisitiAdesioneGenerico_QNAME, RequisitiAdesioneGenerico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ArrayOfRequisitiEstinzioneGenerico")
    public JAXBElement<ArrayOfRequisitiEstinzioneGenerico> createArrayOfRequisitiEstinzioneGenerico(ArrayOfRequisitiEstinzioneGenerico value) {
        return new JAXBElement<ArrayOfRequisitiEstinzioneGenerico>(_ArrayOfRequisitiEstinzioneGenerico_QNAME, ArrayOfRequisitiEstinzioneGenerico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequisitiEstinzioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequisitiEstinzioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "RequisitiEstinzioneGenerico")
    public JAXBElement<RequisitiEstinzioneGenerico> createRequisitiEstinzioneGenerico(RequisitiEstinzioneGenerico value) {
        return new JAXBElement<RequisitiEstinzioneGenerico>(_RequisitiEstinzioneGenerico_QNAME, RequisitiEstinzioneGenerico.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Proposta")
    public JAXBElement<Proposta> createProposta(Proposta value) {
        return new JAXBElement<Proposta>(_Proposta_QNAME, Proposta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Req_Adesione")
    public JAXBElement<ReqAdesione> createReqAdesione(ReqAdesione value) {
        return new JAXBElement<ReqAdesione>(_ReqAdesione_QNAME, ReqAdesione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Req_Estinzione")
    public JAXBElement<ReqEstinzione> createReqEstinzione(ReqEstinzione value) {
        return new JAXBElement<ReqEstinzione>(_ReqEstinzione_QNAME, ReqEstinzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "input", scope = GetRequisitiAdesioneConvenzione.class)
    public JAXBElement<AdesioneRequest> createGetRequisitiAdesioneConvenzioneInput(AdesioneRequest value) {
        return new JAXBElement<AdesioneRequest>(_GetRequisitiAdesioneConvenzioneInput_QNAME, AdesioneRequest.class, GetRequisitiAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetRequisitiAdesioneConvenzioneResult", scope = GetRequisitiAdesioneConvenzioneResponse.class)
    public JAXBElement<AdesioneResponse> createGetRequisitiAdesioneConvenzioneResponseGetRequisitiAdesioneConvenzioneResult(AdesioneResponse value) {
        return new JAXBElement<AdesioneResponse>(_GetRequisitiAdesioneConvenzioneResponseGetRequisitiAdesioneConvenzioneResult_QNAME, AdesioneResponse.class, GetRequisitiAdesioneConvenzioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnagraficaRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "input", scope = GetAnagraficaConvenzione.class)
    public JAXBElement<AnagraficaRequest> createGetAnagraficaConvenzioneInput(AnagraficaRequest value) {
        return new JAXBElement<AnagraficaRequest>(_GetRequisitiAdesioneConvenzioneInput_QNAME, AnagraficaRequest.class, GetAnagraficaConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnagraficaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnagraficaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetAnagraficaConvenzioneResult", scope = GetAnagraficaConvenzioneResponse.class)
    public JAXBElement<AnagraficaResponse> createGetAnagraficaConvenzioneResponseGetAnagraficaConvenzioneResult(AnagraficaResponse value) {
        return new JAXBElement<AnagraficaResponse>(_GetAnagraficaConvenzioneResponseGetAnagraficaConvenzioneResult_QNAME, AnagraficaResponse.class, GetAnagraficaConvenzioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "AccreditoStipendio", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneAccreditoStipendio(String value) {
        return new JAXBElement<String>(_ReqEstinzioneAccreditoStipendio_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataScadenza", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneDataScadenza(String value) {
        return new JAXBElement<String>(_ReqEstinzioneDataScadenza_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Validata_Documento", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneDataValidataDocumento(String value) {
        return new JAXBElement<String>(_ReqEstinzioneDataValidataDocumento_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "EstinzioneAnticipata", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneEstinzioneAnticipata(String value) {
        return new JAXBElement<String>(_ReqEstinzioneEstinzioneAnticipata_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Mancata_Attivazione_ROL", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneMancataAttivazioneROL(String value) {
        return new JAXBElement<String>(_ReqEstinzioneMancataAttivazioneROL_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Presenza_Garanzie_Eleggibile", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzionePresenzaGaranzieEleggibile(String value) {
        return new JAXBElement<String>(_ReqEstinzionePresenzaGaranzieEleggibile_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "RateImpagate_MLT", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneRateImpagateMLT(String value) {
        return new JAXBElement<String>(_ReqEstinzioneRateImpagateMLT_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Sconfinamento_BT", scope = ReqEstinzione.class)
    public JAXBElement<String> createReqEstinzioneSconfinamentoBT(String value) {
        return new JAXBElement<String>(_ReqEstinzioneSconfinamentoBT_QNAME, String.class, ReqEstinzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "AccreditoStipendio", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneAccreditoStipendio(String value) {
        return new JAXBElement<String>(_ReqEstinzioneAccreditoStipendio_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Adesione_Data_Accensione", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneAdesioneDataAccensione(String value) {
        return new JAXBElement<String>(_ReqAdesioneAdesioneDataAccensione_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataAccensione", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneDataAccensione(String value) {
        return new JAXBElement<String>(_ReqAdesioneDataAccensione_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Validata_Documento", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneDataValidataDocumento(String value) {
        return new JAXBElement<String>(_ReqEstinzioneDataValidataDocumento_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "EvaCliente", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneEvaCliente(String value) {
        return new JAXBElement<String>(_ReqAdesioneEvaCliente_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "EvaCliente_A", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneEvaClienteA(String value) {
        return new JAXBElement<String>(_ReqAdesioneEvaClienteA_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "EvaCliente_Da", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneEvaClienteDa(String value) {
        return new JAXBElement<String>(_ReqAdesioneEvaClienteDa_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Fatturato", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneFatturato(String value) {
        return new JAXBElement<String>(_ReqAdesioneFatturato_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Fatturato_A", scope = ReqAdesione.class)
    public JAXBElement<BigDecimal> createReqAdesioneFatturatoA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ReqAdesioneFatturatoA_QNAME, BigDecimal.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Fatturato_Da", scope = ReqAdesione.class)
    public JAXBElement<BigDecimal> createReqAdesioneFatturatoDa(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ReqAdesioneFatturatoDa_QNAME, BigDecimal.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Flag_Data_Accensione", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneFlagDataAccensione(String value) {
        return new JAXBElement<String>(_ReqAdesioneFlagDataAccensione_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Minter", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneMinter(String value) {
        return new JAXBElement<String>(_ReqAdesioneMinter_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Minter_A", scope = ReqAdesione.class)
    public JAXBElement<BigDecimal> createReqAdesioneMinterA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ReqAdesioneMinterA_QNAME, BigDecimal.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Minter_DA", scope = ReqAdesione.class)
    public JAXBElement<BigDecimal> createReqAdesioneMinterDA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ReqAdesioneMinterDA_QNAME, BigDecimal.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Portafoglio", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesionePortafoglio(String value) {
        return new JAXBElement<String>(_ReqAdesionePortafoglio_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ROL", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneROL(String value) {
        return new JAXBElement<String>(_ReqAdesioneROL_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "RatingOnline", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneRatingOnline(String value) {
        return new JAXBElement<String>(_ReqAdesioneRatingOnline_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "VersoControllo", scope = ReqAdesione.class)
    public JAXBElement<String> createReqAdesioneVersoControllo(String value) {
        return new JAXBElement<String>(_ReqAdesioneVersoControllo_QNAME, String.class, ReqAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataProposta", scope = Proposta.class)
    public JAXBElement<String> createPropostaDataProposta(String value) {
        return new JAXBElement<String>(_PropostaDataProposta_QNAME, String.class, Proposta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "NumeroProposta", scope = Proposta.class)
    public JAXBElement<String> createPropostaNumeroProposta(String value) {
        return new JAXBElement<String>(_PropostaNumeroProposta_QNAME, String.class, Proposta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserInfo", scope = Proposta.class)
    public JAXBElement<UserInfo> createPropostaUserInfo(UserInfo value) {
        return new JAXBElement<UserInfo>(_UserInfo_QNAME, UserInfo.class, Proposta.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "CodiceRequisito", scope = RequisitiEstinzioneGenerico.class)
    public JAXBElement<String> createRequisitiEstinzioneGenericoCodiceRequisito(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoCodiceRequisito_QNAME, String.class, RequisitiEstinzioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaEntita", scope = RequisitiEstinzioneGenerico.class)
    public JAXBElement<String> createRequisitiEstinzioneGenericoListaEntita(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoListaEntita_QNAME, String.class, RequisitiEstinzioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaValori", scope = RequisitiEstinzioneGenerico.class)
    public JAXBElement<String> createRequisitiEstinzioneGenericoListaValori(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoListaValori_QNAME, String.class, RequisitiEstinzioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "CodiceRequisito", scope = RequisitiAdesioneGenerico.class)
    public JAXBElement<String> createRequisitiAdesioneGenericoCodiceRequisito(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoCodiceRequisito_QNAME, String.class, RequisitiAdesioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaEntita", scope = RequisitiAdesioneGenerico.class)
    public JAXBElement<String> createRequisitiAdesioneGenericoListaEntita(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoListaEntita_QNAME, String.class, RequisitiAdesioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaValori", scope = RequisitiAdesioneGenerico.class)
    public JAXBElement<String> createRequisitiAdesioneGenericoListaValori(String value) {
        return new JAXBElement<String>(_RequisitiEstinzioneGenericoListaValori_QNAME, String.class, RequisitiAdesioneGenerico.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "RatingOnline", scope = Rating.class)
    public JAXBElement<String> createRatingRatingOnline(String value) {
        return new JAXBElement<String>(_ReqAdesioneRatingOnline_QNAME, String.class, Rating.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Indicazione_Portafoglio", scope = PortafoglioAdesione.class)
    public JAXBElement<String> createPortafoglioAdesioneIndicazionePortafoglio(String value) {
        return new JAXBElement<String>(_PortafoglioAdesioneIndicazionePortafoglio_QNAME, String.class, PortafoglioAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Tipologia_Portafoglio", scope = PortafoglioAdesione.class)
    public JAXBElement<String> createPortafoglioAdesioneTipologiaPortafoglio(String value) {
        return new JAXBElement<String>(_PortafoglioAdesioneTipologiaPortafoglio_QNAME, String.class, PortafoglioAdesione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "SSC_Gruppo", scope = FasciaPortafoglioSSC.class)
    public JAXBElement<String> createFasciaPortafoglioSSCSSCGruppo(String value) {
        return new JAXBElement<String>(_FasciaPortafoglioSSCSSCGruppo_QNAME, String.class, FasciaPortafoglioSSC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Tipologia_Portafoglio", scope = FasciaPortafoglioSSC.class)
    public JAXBElement<String> createFasciaPortafoglioSSCTipologiaPortafoglio(String value) {
        return new JAXBElement<String>(_PortafoglioAdesioneTipologiaPortafoglio_QNAME, String.class, FasciaPortafoglioSSC.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FatturatoA", scope = FasciaFatturato.class)
    public JAXBElement<BigDecimal> createFasciaFatturatoFatturatoA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FasciaFatturatoFatturatoA_QNAME, BigDecimal.class, FasciaFatturato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FatturatoDA", scope = FasciaFatturato.class)
    public JAXBElement<BigDecimal> createFasciaFatturatoFatturatoDA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_FasciaFatturatoFatturatoDA_QNAME, BigDecimal.class, FasciaFatturato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FasciaFatturato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FasciaFatturato", scope = IndicatoreDifferenziazione.class)
    public JAXBElement<FasciaFatturato> createIndicatoreDifferenziazioneFasciaFatturato(FasciaFatturato value) {
        return new JAXBElement<FasciaFatturato>(_FasciaFatturato_QNAME, FasciaFatturato.class, IndicatoreDifferenziazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FasciaPortafoglioSSC }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "FasciaPortafoglioSSC", scope = IndicatoreDifferenziazione.class)
    public JAXBElement<FasciaPortafoglioSSC> createIndicatoreDifferenziazioneFasciaPortafoglioSSC(FasciaPortafoglioSSC value) {
        return new JAXBElement<FasciaPortafoglioSSC>(_FasciaPortafoglioSSC_QNAME, FasciaPortafoglioSSC.class, IndicatoreDifferenziazione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codice_Condizione", scope = Condizione.class)
    public JAXBElement<String> createCondizioneCodiceCondizione(String value) {
        return new JAXBElement<String>(_CondizioneCodiceCondizione_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Configurazione_Fasce_Approvato", scope = Condizione.class)
    public JAXBElement<ConfigurazioneFasce> createCondizioneConfigurazioneFasceApprovato(ConfigurazioneFasce value) {
        return new JAXBElement<ConfigurazioneFasce>(_CondizioneConfigurazioneFasceApprovato_QNAME, ConfigurazioneFasce.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Configurazione_Fasce_Proposto", scope = Condizione.class)
    public JAXBElement<ConfigurazioneFasce> createCondizioneConfigurazioneFasceProposto(ConfigurazioneFasce value) {
        return new JAXBElement<ConfigurazioneFasce>(_CondizioneConfigurazioneFasceProposto_QNAME, ConfigurazioneFasce.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Decorrenza_Approvata", scope = Condizione.class)
    public JAXBElement<String> createCondizioneDataDecorrenzaApprovata(String value) {
        return new JAXBElement<String>(_CondizioneDataDecorrenzaApprovata_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Decorrenza_Proposta", scope = Condizione.class)
    public JAXBElement<String> createCondizioneDataDecorrenzaProposta(String value) {
        return new JAXBElement<String>(_CondizioneDataDecorrenzaProposta_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Scadenza_Approvata", scope = Condizione.class)
    public JAXBElement<String> createCondizioneDataScadenzaApprovata(String value) {
        return new JAXBElement<String>(_CondizioneDataScadenzaApprovata_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Data_Scadenza_Proposta", scope = Condizione.class)
    public JAXBElement<String> createCondizioneDataScadenzaProposta(String value) {
        return new JAXBElement<String>(_CondizioneDataScadenzaProposta_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "TipoValore", scope = Condizione.class)
    public JAXBElement<String> createCondizioneTipoValore(String value) {
        return new JAXBElement<String>(_CondizioneTipoValore_QNAME, String.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Approvato", scope = Condizione.class)
    public JAXBElement<BloccoValore> createCondizioneValoreApprovato(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_CondizioneValoreApprovato_QNAME, BloccoValore.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Post_Approvato", scope = Condizione.class)
    public JAXBElement<BloccoValore> createCondizioneValorePostApprovato(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_CondizioneValorePostApprovato_QNAME, BloccoValore.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Post_Proposto", scope = Condizione.class)
    public JAXBElement<BloccoValore> createCondizioneValorePostProposto(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_CondizioneValorePostProposto_QNAME, BloccoValore.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Proposto", scope = Condizione.class)
    public JAXBElement<BloccoValore> createCondizioneValoreProposto(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_CondizioneValoreProposto_QNAME, BloccoValore.class, Condizione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserABI", scope = UserInfo.class)
    public JAXBElement<String> createUserInfoUserABI(String value) {
        return new JAXBElement<String>(_UserInfoUserABI_QNAME, String.class, UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserId", scope = UserInfo.class)
    public JAXBElement<String> createUserInfoUserId(String value) {
        return new JAXBElement<String>(_UserInfoUserId_QNAME, String.class, UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserUO", scope = UserInfo.class)
    public JAXBElement<String> createUserInfoUserUO(String value) {
        return new JAXBElement<String>(_UserInfoUserUO_QNAME, String.class, UserInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataDelibera", scope = Delibera.class)
    public JAXBElement<String> createDeliberaDataDelibera(String value) {
        return new JAXBElement<String>(_DeliberaDataDelibera_QNAME, String.class, Delibera.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "UserInfo", scope = Delibera.class)
    public JAXBElement<UserInfo> createDeliberaUserInfo(UserInfo value) {
        return new JAXBElement<UserInfo>(_UserInfo_QNAME, UserInfo.class, Delibera.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Denominazione", scope = Controparte.class)
    public JAXBElement<String> createControparteDenominazione(String value) {
        return new JAXBElement<String>(_ControparteDenominazione_QNAME, String.class, Controparte.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "NDG", scope = Controparte.class)
    public JAXBElement<String> createControparteNDG(String value) {
        return new JAXBElement<String>(_ControparteNDG_QNAME, String.class, Controparte.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Rating", scope = Controparte.class)
    public JAXBElement<String> createControparteRating(String value) {
        return new JAXBElement<String>(_Rating_QNAME, String.class, Controparte.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Segmento_Regolamentare", scope = Controparte.class)
    public JAXBElement<String> createControparteSegmentoRegolamentare(String value) {
        return new JAXBElement<String>(_ControparteSegmentoRegolamentare_QNAME, String.class, Controparte.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "CodiceABI", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneCodiceABI(String value) {
        return new JAXBElement<String>(_ConvenzioneCodiceABI_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "CodiceConvenzione", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneCodiceConvenzione(String value) {
        return new JAXBElement<String>(_ConvenzioneCodiceConvenzione_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ControGaranzia_Stato", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneControGaranziaStato(String value) {
        return new JAXBElement<String>(_ConvenzioneControGaranziaStato_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Controparte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Controparte", scope = Convenzione.class)
    public JAXBElement<Controparte> createConvenzioneControparte(Controparte value) {
        return new JAXBElement<Controparte>(_Controparte_QNAME, Controparte.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataDecorrenza", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneDataDecorrenza(String value) {
        return new JAXBElement<String>(_ConvenzioneDataDecorrenza_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DataScadenza", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneDataScadenza(String value) {
        return new JAXBElement<String>(_ReqEstinzioneDataScadenza_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Delibera }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Delibera", scope = Convenzione.class)
    public JAXBElement<Delibera> createConvenzioneDelibera(Delibera value) {
        return new JAXBElement<Delibera>(_Delibera_QNAME, Delibera.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "DescrizioneConvenzione", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneDescrizioneConvenzione(String value) {
        return new JAXBElement<String>(_ConvenzioneDescrizioneConvenzione_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCondizione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaCondizione", scope = Convenzione.class)
    public JAXBElement<ArrayOfCondizione> createConvenzioneListaCondizione(ArrayOfCondizione value) {
        return new JAXBElement<ArrayOfCondizione>(_ConvenzioneListaCondizione_QNAME, ArrayOfCondizione.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfIndicatoreDifferenziazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaIndicatore_Differenziazione", scope = Convenzione.class)
    public JAXBElement<ArrayOfIndicatoreDifferenziazione> createConvenzioneListaIndicatoreDifferenziazione(ArrayOfIndicatoreDifferenziazione value) {
        return new JAXBElement<ArrayOfIndicatoreDifferenziazione>(_ConvenzioneListaIndicatoreDifferenziazione_QNAME, ArrayOfIndicatoreDifferenziazione.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPortafoglioAdesione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaPortafoglio_Adesione", scope = Convenzione.class)
    public JAXBElement<ArrayOfPortafoglioAdesione> createConvenzioneListaPortafoglioAdesione(ArrayOfPortafoglioAdesione value) {
        return new JAXBElement<ArrayOfPortafoglioAdesione>(_ConvenzioneListaPortafoglioAdesione_QNAME, ArrayOfPortafoglioAdesione.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRating }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaRating", scope = Convenzione.class)
    public JAXBElement<ArrayOfRating> createConvenzioneListaRating(ArrayOfRating value) {
        return new JAXBElement<ArrayOfRating>(_ConvenzioneListaRating_QNAME, ArrayOfRating.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiAdesioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaRequisitiAdesioneGenerici", scope = Convenzione.class)
    public JAXBElement<ArrayOfRequisitiAdesioneGenerico> createConvenzioneListaRequisitiAdesioneGenerici(ArrayOfRequisitiAdesioneGenerico value) {
        return new JAXBElement<ArrayOfRequisitiAdesioneGenerico>(_ConvenzioneListaRequisitiAdesioneGenerici_QNAME, ArrayOfRequisitiAdesioneGenerico.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequisitiEstinzioneGenerico }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaRequisitiEstinzioneGenerici", scope = Convenzione.class)
    public JAXBElement<ArrayOfRequisitiEstinzioneGenerico> createConvenzioneListaRequisitiEstinzioneGenerici(ArrayOfRequisitiEstinzioneGenerico value) {
        return new JAXBElement<ArrayOfRequisitiEstinzioneGenerico>(_ConvenzioneListaRequisitiEstinzioneGenerici_QNAME, ArrayOfRequisitiEstinzioneGenerico.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Presenza_Garanzia", scope = Convenzione.class)
    public JAXBElement<String> createConvenzionePresenzaGaranzia(String value) {
        return new JAXBElement<String>(_ConvenzionePresenzaGaranzia_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Proposta }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Proposta", scope = Convenzione.class)
    public JAXBElement<Proposta> createConvenzioneProposta(Proposta value) {
        return new JAXBElement<Proposta>(_Proposta_QNAME, Proposta.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqAdesione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Requisiti_Adesione", scope = Convenzione.class)
    public JAXBElement<ReqAdesione> createConvenzioneRequisitiAdesione(ReqAdesione value) {
        return new JAXBElement<ReqAdesione>(_ConvenzioneRequisitiAdesione_QNAME, ReqAdesione.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqEstinzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Requisiti_Estinzione", scope = Convenzione.class)
    public JAXBElement<ReqEstinzione> createConvenzioneRequisitiEstinzione(ReqEstinzione value) {
        return new JAXBElement<ReqEstinzione>(_ConvenzioneRequisitiEstinzione_QNAME, ReqEstinzione.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Stato", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneStato(String value) {
        return new JAXBElement<String>(_ConvenzioneStato_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Tipo_Differenziazione", scope = Convenzione.class)
    public JAXBElement<String> createConvenzioneTipoDifferenziazione(String value) {
        return new JAXBElement<String>(_ConvenzioneTipoDifferenziazione_QNAME, String.class, Convenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codice1", scope = ValoreParametrato.class)
    public JAXBElement<String> createValoreParametratoCodice1(String value) {
        return new JAXBElement<String>(_ValoreParametratoCodice1_QNAME, String.class, ValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Perc1", scope = ValoreParametrato.class)
    public JAXBElement<Float> createValoreParametratoPerc1(Float value) {
        return new JAXBElement<Float>(_ValoreParametratoPerc1_QNAME, Float.class, ValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Spread", scope = ValoreParametrato.class)
    public JAXBElement<BigDecimal> createValoreParametratoSpread(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ValoreParametratoSpread_QNAME, BigDecimal.class, ValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codice", scope = BloccoValore.class)
    public JAXBElement<String> createBloccoValoreCodice(String value) {
        return new JAXBElement<String>(_BloccoValoreCodice_QNAME, String.class, BloccoValore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "TipoDeroga", scope = BloccoValore.class)
    public JAXBElement<String> createBloccoValoreTipoDeroga(String value) {
        return new JAXBElement<String>(_BloccoValoreTipoDeroga_QNAME, String.class, BloccoValore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Numerico", scope = BloccoValore.class)
    public JAXBElement<BigDecimal> createBloccoValoreValoreNumerico(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_BloccoValoreValoreNumerico_QNAME, BigDecimal.class, BloccoValore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValoreParametrato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Parametrato", scope = BloccoValore.class)
    public JAXBElement<ValoreParametrato> createBloccoValoreValoreParametrato(ValoreParametrato value) {
        return new JAXBElement<ValoreParametrato>(_ValoreParametrato_QNAME, ValoreParametrato.class, BloccoValore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BloccoValore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Blocco", scope = Valore.class)
    public JAXBElement<BloccoValore> createValoreBlocco(BloccoValore value) {
        return new JAXBElement<BloccoValore>(_ValoreBlocco_QNAME, BloccoValore.class, Valore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "AlfanumericoSoglia_A", scope = ValoreIndicatore.class)
    public JAXBElement<String> createValoreIndicatoreAlfanumericoSogliaA(String value) {
        return new JAXBElement<String>(_ValoreIndicatoreAlfanumericoSogliaA_QNAME, String.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "AlfanumericoSoglia_Da", scope = ValoreIndicatore.class)
    public JAXBElement<String> createValoreIndicatoreAlfanumericoSogliaDa(String value) {
        return new JAXBElement<String>(_ValoreIndicatoreAlfanumericoSogliaDa_QNAME, String.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codice_Fascia_Indicatore", scope = ValoreIndicatore.class)
    public JAXBElement<String> createValoreIndicatoreCodiceFasciaIndicatore(String value) {
        return new JAXBElement<String>(_ValoreIndicatoreCodiceFasciaIndicatore_QNAME, String.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "NumericoSoglia_A", scope = ValoreIndicatore.class)
    public JAXBElement<BigDecimal> createValoreIndicatoreNumericoSogliaA(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ValoreIndicatoreNumericoSogliaA_QNAME, BigDecimal.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "NumericoSoglia_Da", scope = ValoreIndicatore.class)
    public JAXBElement<BigDecimal> createValoreIndicatoreNumericoSogliaDa(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_ValoreIndicatoreNumericoSogliaDa_QNAME, BigDecimal.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "TipoIndicatore", scope = ValoreIndicatore.class)
    public JAXBElement<String> createValoreIndicatoreTipoIndicatore(String value) {
        return new JAXBElement<String>(_ValoreIndicatoreTipoIndicatore_QNAME, String.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Valore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Valore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore", scope = ValoreIndicatore.class)
    public JAXBElement<Valore> createValoreIndicatoreValore(Valore value) {
        return new JAXBElement<Valore>(_Valore_QNAME, Valore.class, ValoreIndicatore.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValoreIndicatore }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Valore_Indicatore", scope = Fasce.class)
    public JAXBElement<ValoreIndicatore> createFasceValoreIndicatore(ValoreIndicatore value) {
        return new JAXBElement<ValoreIndicatore>(_ValoreIndicatore_QNAME, ValoreIndicatore.class, Fasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codice_Fascia_Indicatore_Benefici_In", scope = ConfigurazioneFasce.class)
    public JAXBElement<String> createConfigurazioneFasceCodiceFasciaIndicatoreBeneficiIn(String value) {
        return new JAXBElement<String>(_ConfigurazioneFasceCodiceFasciaIndicatoreBeneficiIn_QNAME, String.class, ConfigurazioneFasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Codifica_Indicatore", scope = ConfigurazioneFasce.class)
    public JAXBElement<String> createConfigurazioneFasceCodificaIndicatore(String value) {
        return new JAXBElement<String>(_ConfigurazioneFasceCodificaIndicatore_QNAME, String.class, ConfigurazioneFasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Disabilita_Monitoraggio", scope = ConfigurazioneFasce.class)
    public JAXBElement<String> createConfigurazioneFasceDisabilitaMonitoraggio(String value) {
        return new JAXBElement<String>(_ConfigurazioneFasceDisabilitaMonitoraggio_QNAME, String.class, ConfigurazioneFasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "ListaFasce", scope = ConfigurazioneFasce.class)
    public JAXBElement<ArrayOfFasce> createConfigurazioneFasceListaFasce(ArrayOfFasce value) {
        return new JAXBElement<ArrayOfFasce>(_ConfigurazioneFasceListaFasce_QNAME, ArrayOfFasce.class, ConfigurazioneFasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities.Convenzione", name = "Periodicita", scope = ConfigurazioneFasce.class)
    public JAXBElement<String> createConfigurazioneFascePeriodicita(String value) {
        return new JAXBElement<String>(_ConfigurazioneFascePeriodicita_QNAME, String.class, ConfigurazioneFasce.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.Entities", name = "ErrorDescription", scope = ResponseLog.class)
    public JAXBElement<String> createResponseLogErrorDescription(String value) {
        return new JAXBElement<String>(_ResponseLogErrorDescription_QNAME, String.class, ResponseLog.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "flagRequisito", scope = AdesioneResponseAdesioneDettaglio.class)
    public JAXBElement<String> createAdesioneResponseAdesioneDettaglioFlagRequisito(String value) {
        return new JAXBElement<String>(_AdesioneResponseAdesioneDettaglioFlagRequisito_QNAME, String.class, AdesioneResponseAdesioneDettaglio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "indicatoreRequisito", scope = AdesioneResponseAdesioneDettaglio.class)
    public JAXBElement<String> createAdesioneResponseAdesioneDettaglioIndicatoreRequisito(String value) {
        return new JAXBElement<String>(_AdesioneResponseAdesioneDettaglioIndicatoreRequisito_QNAME, String.class, AdesioneResponseAdesioneDettaglio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "valoreAlfanumericoRequisito", scope = AdesioneResponseAdesioneDettaglio.class)
    public JAXBElement<String> createAdesioneResponseAdesioneDettaglioValoreAlfanumericoRequisito(String value) {
        return new JAXBElement<String>(_AdesioneResponseAdesioneDettaglioValoreAlfanumericoRequisito_QNAME, String.class, AdesioneResponseAdesioneDettaglio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "valoreNumericoRequisisto", scope = AdesioneResponseAdesioneDettaglio.class)
    public JAXBElement<BigDecimal> createAdesioneResponseAdesioneDettaglioValoreNumericoRequisisto(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseAdesioneDettaglioValoreNumericoRequisisto_QNAME, BigDecimal.class, AdesioneResponseAdesioneDettaglio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "parametro_Codice1", scope = AdesioneResponseBeneficioValoreParametrato.class)
    public JAXBElement<String> createAdesioneResponseBeneficioValoreParametratoParametroCodice1(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficioValoreParametratoParametroCodice1_QNAME, String.class, AdesioneResponseBeneficioValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "parametro_Perc1", scope = AdesioneResponseBeneficioValoreParametrato.class)
    public JAXBElement<BigDecimal> createAdesioneResponseBeneficioValoreParametratoParametroPerc1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseBeneficioValoreParametratoParametroPerc1_QNAME, BigDecimal.class, AdesioneResponseBeneficioValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "parametro_Spread", scope = AdesioneResponseBeneficioValoreParametrato.class)
    public JAXBElement<BigDecimal> createAdesioneResponseBeneficioValoreParametratoParametroSpread(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseBeneficioValoreParametratoParametroSpread_QNAME, BigDecimal.class, AdesioneResponseBeneficioValoreParametrato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConfigurazioneFasce }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Configurazione_Fasce_Approvato", scope = AdesioneResponseBenefici.class)
    public JAXBElement<ConfigurazioneFasce> createAdesioneResponseBeneficiConfigurazioneFasceApprovato(ConfigurazioneFasce value) {
        return new JAXBElement<ConfigurazioneFasce>(_AdesioneResponseBeneficiConfigurazioneFasceApprovato_QNAME, ConfigurazioneFasce.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "beneficio_Tipologia", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiBeneficioTipologia(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiBeneficioTipologia_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "beneficio_ValoreCodice", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiBeneficioValoreCodice(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiBeneficioValoreCodice_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "beneficio_ValoreNumerico", scope = AdesioneResponseBenefici.class)
    public JAXBElement<BigDecimal> createAdesioneResponseBeneficiBeneficioValoreNumerico(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseBeneficiBeneficioValoreNumerico_QNAME, BigDecimal.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdesioneResponseBeneficioValoreParametrato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "beneficio_ValoreParametrato", scope = AdesioneResponseBenefici.class)
    public JAXBElement<AdesioneResponseBeneficioValoreParametrato> createAdesioneResponseBeneficiBeneficioValoreParametrato(AdesioneResponseBeneficioValoreParametrato value) {
        return new JAXBElement<AdesioneResponseBeneficioValoreParametrato>(_AdesioneResponseBeneficiBeneficioValoreParametrato_QNAME, AdesioneResponseBeneficioValoreParametrato.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceCondizione", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiCodiceCondizione(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiCodiceCondizione_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceFascia", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiCodiceFascia(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiCodiceFascia_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "dataDecorrenza", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDataDecorrenza(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDataDecorrenza_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "dataScadenza", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDataScadenza(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDataScadenza_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver1_Tipologia", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDriver1Tipologia(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDriver1Tipologia_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver1_ValoreCodice", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDriver1ValoreCodice(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDriver1ValoreCodice_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver1_ValoreNumerico", scope = AdesioneResponseBenefici.class)
    public JAXBElement<BigDecimal> createAdesioneResponseBeneficiDriver1ValoreNumerico(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseBeneficiDriver1ValoreNumerico_QNAME, BigDecimal.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver2_Tipologia", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDriver2Tipologia(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDriver2Tipologia_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver2_ValoreCodice", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiDriver2ValoreCodice(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiDriver2ValoreCodice_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "driver2_ValoreNumerico", scope = AdesioneResponseBenefici.class)
    public JAXBElement<BigDecimal> createAdesioneResponseBeneficiDriver2ValoreNumerico(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AdesioneResponseBeneficiDriver2ValoreNumerico_QNAME, BigDecimal.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "flagRolling", scope = AdesioneResponseBenefici.class)
    public JAXBElement<String> createAdesioneResponseBeneficiFlagRolling(String value) {
        return new JAXBElement<String>(_AdesioneResponseBeneficiFlagRolling_QNAME, String.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "numeroFascia", scope = AdesioneResponseBenefici.class)
    public JAXBElement<Short> createAdesioneResponseBeneficiNumeroFascia(Short value) {
        return new JAXBElement<Short>(_AdesioneResponseBeneficiNumeroFascia_QNAME, Short.class, AdesioneResponseBenefici.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "errorMessage", scope = ClassEsito.class)
    public JAXBElement<String> createClassEsitoErrorMessage(String value) {
        return new JAXBElement<String>(_ClassEsitoErrorMessage_QNAME, String.class, ClassEsito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "resultCode", scope = ClassEsito.class)
    public JAXBElement<String> createClassEsitoResultCode(String value) {
        return new JAXBElement<String>(_ClassEsitoResultCode_QNAME, String.class, ClassEsito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CF", scope = CodiceFiscale.class)
    public JAXBElement<String> createCodiceFiscaleCF(String value) {
        return new JAXBElement<String>(_CodiceFiscaleCF_QNAME, String.class, CodiceFiscale.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Esito", scope = AnagraficaResponse.class)
    public JAXBElement<ClassEsito> createAnagraficaResponseEsito(ClassEsito value) {
        return new JAXBElement<ClassEsito>(_AnagraficaResponseEsito_QNAME, ClassEsito.class, AnagraficaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ResponseLog", scope = AnagraficaResponse.class)
    public JAXBElement<ResponseLog> createAnagraficaResponseResponseLog(ResponseLog value) {
        return new JAXBElement<ResponseLog>(_AnagraficaResponseResponseLog_QNAME, ResponseLog.class, AnagraficaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "numeroProposta", scope = AnagraficaResponse.class)
    public JAXBElement<String> createAnagraficaResponseNumeroProposta(String value) {
        return new JAXBElement<String>(_AnagraficaResponseNumeroProposta_QNAME, String.class, AnagraficaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Convenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Convenzione", scope = AnagraficaRequest.class)
    public JAXBElement<Convenzione> createAnagraficaRequestConvenzione(Convenzione value) {
        return new JAXBElement<Convenzione>(_AnagraficaRequestConvenzione_QNAME, Convenzione.class, AnagraficaRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Esito", scope = AdesioneResponse.class)
    public JAXBElement<ClassEsito> createAdesioneResponseEsito(ClassEsito value) {
        return new JAXBElement<ClassEsito>(_AnagraficaResponseEsito_QNAME, ClassEsito.class, AdesioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseLog }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ResponseLog", scope = AdesioneResponse.class)
    public JAXBElement<ResponseLog> createAdesioneResponseResponseLog(ResponseLog value) {
        return new JAXBElement<ResponseLog>(_AnagraficaResponseResponseLog_QNAME, ResponseLog.class, AdesioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseBenefici }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "TabellaBenefici", scope = AdesioneResponse.class)
    public JAXBElement<ArrayOfAdesioneResponseBenefici> createAdesioneResponseTabellaBenefici(ArrayOfAdesioneResponseBenefici value) {
        return new JAXBElement<ArrayOfAdesioneResponseBenefici>(_AdesioneResponseTabellaBenefici_QNAME, ArrayOfAdesioneResponseBenefici.class, AdesioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfAdesioneResponseAdesioneDettaglio }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "TabellaRequisiti", scope = AdesioneResponse.class)
    public JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio> createAdesioneResponseTabellaRequisiti(ArrayOfAdesioneResponseAdesioneDettaglio value) {
        return new JAXBElement<ArrayOfAdesioneResponseAdesioneDettaglio>(_AdesioneResponseTabellaRequisiti_QNAME, ArrayOfAdesioneResponseAdesioneDettaglio.class, AdesioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ABI", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestABI(String value) {
        return new JAXBElement<String>(_AdesioneRequestABI_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ApplicativoId", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestApplicativoId(String value) {
        return new JAXBElement<String>(_AdesioneRequestApplicativoId_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Codice_Convenzione", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestCodiceConvenzione(String value) {
        return new JAXBElement<String>(_AdesioneRequestCodiceConvenzione_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "DataAccensione", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestDataAccensione(String value) {
        return new JAXBElement<String>(_AdesioneRequestDataAccensione_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Data_Adesione", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestDataAdesione(String value) {
        return new JAXBElement<String>(_AdesioneRequestDataAdesione_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Filiale", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestFiliale(String value) {
        return new JAXBElement<String>(_AdesioneRequestFiliale_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Flag_Tipo_Cliente", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestFlagTipoCliente(String value) {
        return new JAXBElement<String>(_AdesioneRequestFlagTipoCliente_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfCodiceFiscale }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCodiciFiscali", scope = AdesioneRequest.class)
    public JAXBElement<ArrayOfCodiceFiscale> createAdesioneRequestListaCodiciFiscali(ArrayOfCodiceFiscale value) {
        return new JAXBElement<ArrayOfCodiceFiscale>(_AdesioneRequestListaCodiciFiscali_QNAME, ArrayOfCodiceFiscale.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "NDG", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestNDG(String value) {
        return new JAXBElement<String>(_AdesioneRequestNDG_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "PIVA", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestPIVA(String value) {
        return new JAXBElement<String>(_AdesioneRequestPIVA_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ROL", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestROL(String value) {
        return new JAXBElement<String>(_AdesioneRequestROL_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoCategoria(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoCategoria_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria_Stipendio", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoCategoriaStipendio(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoCategoriaStipendio_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Codice", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoCodice(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoCodice_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Codice_Stipendio", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoCodiceStipendio(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoCodiceStipendio_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoFiliale(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoFiliale_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale_Stipendio", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRapportoFilialeStipendio(String value) {
        return new JAXBElement<String>(_AdesioneRequestRapportoFilialeStipendio_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rating", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestRating(String value) {
        return new JAXBElement<String>(_AdesioneRequestRating_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Tipo_Chiamata", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestTipoChiamata(String value) {
        return new JAXBElement<String>(_AdesioneRequestTipoChiamata_QNAME, String.class, AdesioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserId", scope = AdesioneRequest.class)
    public JAXBElement<String> createAdesioneRequestUserId(String value) {
        return new JAXBElement<String>(_AdesioneRequestUserId_QNAME, String.class, AdesioneRequest.class, value);
    }

}
