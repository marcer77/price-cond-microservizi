//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.0 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2020.07.21 alle 12:10:20 PM CEST 
//


package com.intesasanpaolo.connector.ws.gen.convenzionihostservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import com.intesasanpaolo.connector.ws.gen.convenzionihostservice.xsd3.ISPWebservicesHeader;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.intesasanpaolo.connector.ws.gen.convenzionihostservice package. 
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

    private final static QName _ISPWebservicesHeader_QNAME = new QName("http://tempuri.org/", "ISPWebservicesHeader");
    private final static QName _CovenantPerConvenzioneRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CovenantPerConvenzione_Request");
    private final static QName _ResponseGetCovenantPerConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetCovenantPerConvenzione");
    private final static QName _ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione");
    private final static QName _ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfResponse_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione.CovenantDaAttivare");
    private final static QName _ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione.CovenantDaAttivare");
    private final static QName _RequestStoreCovenantAdesioneConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Request_StoreCovenantAdesioneConvenzione");
    private final static QName _ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare");
    private final static QName _ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaCessare");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Request_StoreCovenantAdesioneConvenzione.CovenantDaCessare");
    private final static QName _ResponseStoreCovenantAdesioneConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_StoreCovenantAdesioneConvenzione");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione");
    private final static QName _ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaAttivare");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaAttivare");
    private final static QName _ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare");
    private final static QName _ClassEsito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Class.Esito");
    private final static QName _RequestPartiVariabiliPerAddendum_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Request_PartiVariabiliPerAddendum");
    private final static QName _ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfRequest_PartiVariabiliPerAddendum.CovenantAttivato");
    private final static QName _RequestPartiVariabiliPerAddendumCovenantAttivato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Request_PartiVariabiliPerAddendum.CovenantAttivato");
    private final static QName _ResponseGetPartiVariabiliPerAddendum_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetPartiVariabiliPerAddendum");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum");
    private final static QName _ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato");
    private final static QName _ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.Glossario");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.Glossario");
    private final static QName _GetBaselinePerHostRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "GetBaselinePerHost_Request");
    private final static QName _GetBaselinePerHostResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "GetBaselinePerHost_Response");
    private final static QName _ArrayOfGetBaselinePerHostResponseBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ArrayOfGetBaselinePerHost_Response.Baseline");
    private final static QName _GetBaselinePerHostResponseBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "GetBaselinePerHost_Response.Baseline");
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
    private final static QName _GetCovenantPerConvenzioneInput_QNAME = new QName("http://tempuri.org/", "input");
    private final static QName _GetCovenantPerConvenzioneResponseGetCovenantPerConvenzioneResult_QNAME = new QName("http://tempuri.org/", "GetCovenantPerConvenzioneResult");
    private final static QName _StoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzioneResult_QNAME = new QName("http://tempuri.org/", "StoreCovenantAdesioneConvenzioneResult");
    private final static QName _GetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendumResult_QNAME = new QName("http://tempuri.org/", "GetPartiVariabiliPerAddendumResult");
    private final static QName _BaselinePerHostRequestParametriAdesione_QNAME = new QName("http://tempuri.org/", "parametriAdesione");
    private final static QName _ResponseBodyGetBaselineGetBaselineResponse_QNAME = new QName("http://tempuri.org/", "getBaselineResponse");
    private final static QName _GetBaselinePerHostResponseBaselineCodiceTipoBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceTipoBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineCodiceUDMBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceUDMBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineDescrizioneBreveTipoBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "descrizioneBreveTipoBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineDescrizioneEstesaTipoBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "descrizioneEstesaTipoBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineDescrizioneUDMBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "descrizioneUDMBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineEsito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "esito");
    private final static QName _GetBaselinePerHostResponseBaselineMessaggio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "messaggio");
    private final static QName _GetBaselinePerHostResponseBaselinePeriodoDataA_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "periodoDataA");
    private final static QName _GetBaselinePerHostResponseBaselinePeriodoDataDa_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "periodoDataDa");
    private final static QName _GetBaselinePerHostResponseBaselinePeriodoDescrizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "periodoDescrizione");
    private final static QName _GetBaselinePerHostResponseBaselineTipoBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "tipoBaseline");
    private final static QName _GetBaselinePerHostResponseBaselineValoreBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "valoreBaseline");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioCodice_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codice");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioOrdinePosizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ordinePosizione");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Cod_Condizione");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Progressivo");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Categoria");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Conto");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Rapporto_Filiale");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceTemplate");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "errorMessage");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtApplicazioneBeneficio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtApplicazioneBeneficio");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtBaseline1");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline2_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtBaseline2");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtEventoComposto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtEventoComposto");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtModalitaRilevazione1");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione2_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtModalitaRilevazione2");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtPerimetroMonitoraggio1");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio2_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtPerimetroMonitoraggio2");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione1_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtPeriodicitaRilevazione1");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione2_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "idTxtPeriodicitaRilevazione2");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoResultCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "resultCode");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "versioneTemplate");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumEsito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Esito");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaCovenantAttivati_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaCovenantAttivati");
    private final static QName _ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaGlossario_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaGlossario");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ErroriListaCovenantDaAttivare");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ErroriListaCovenantDaCessare");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioCondizionato_DataFine");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioCondizionato_DataInizio");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIncondizionato_DataFine");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIncondizionato_DataInizio");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIncondizionato_NumRilevazioni");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIncondizionato_Presente");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataFine_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIngresso_DataFine");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIngresso_DataInizio");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoPresente_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "BeneficioIngresso_Presente");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizioneRealeMLT_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Cod_CondizioneReale_MLT");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataFine_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Covenant_DataFine");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataInizio_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Covenant_DataInizio");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareFlagEntitaPrincipale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Flag_EntitaPrincipale");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCondizioniFiglie_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "condizioniFiglie");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareLivelloGerarchia_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "livelloGerarchia");
    private final static QName _ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEffettoRilevato_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Flag_EffettoRilevato");
    private final static QName _ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEventoEtaCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Flag_EventoEtaCliente");
    private final static QName _ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneListaCovenantDaAttivare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaCovenantDaAttivare");
    private final static QName _GetBaselinePerHostResponseListaBaseline_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaBaseline");
    private final static QName _GetBaselinePerHostRequestABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ABI");
    private final static QName _GetBaselinePerHostRequestCodCondizione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CodCondizione");
    private final static QName _GetBaselinePerHostRequestLanguage_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Language");
    private final static QName _GetBaselinePerHostRequestProdotto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Prodotto");
    private final static QName _GetBaselinePerHostRequestUserABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "UserABI");
    private final static QName _GetBaselinePerHostRequestUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "UserId");
    private final static QName _GetBaselinePerHostRequestUserUO_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "UserUO");
    private final static QName _GetBaselinePerHostRequestCodTemplate_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codTemplate");
    private final static QName _GetBaselinePerHostRequestCodiceAmbitoEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceAmbitoEvento");
    private final static QName _GetBaselinePerHostRequestCodiceEvento_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceEvento");
    private final static QName _GetBaselinePerHostRequestCodiceModaitaRilevazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codiceModaitaRilevazione");
    private final static QName _GetBaselinePerHostRequestCodicePeriodicitaRilevazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "codicePeriodicitaRilevazione");
    private final static QName _GetBaselinePerHostRequestDataRichiesta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "dataRichiesta");
    private final static QName _GetBaselinePerHostRequestTipologiaTemplate_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "tipologiaTemplate");
    private final static QName _GetBaselinePerHostRequestValoreAmbito_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "valoreAmbito");
    private final static QName _ResponseGetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendum_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ResponseGetPartiVariabiliPerAddendum");
    private final static QName _RequestPartiVariabiliPerAddendumApplicativoId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Applicativo_Id");
    private final static QName _RequestPartiVariabiliPerAddendumCodConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CodConvenzione");
    private final static QName _RequestPartiVariabiliPerAddendumDataProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "DataProposta");
    private final static QName _RequestPartiVariabiliPerAddendumDataOperazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Data_Operazione");
    private final static QName _RequestPartiVariabiliPerAddendumFilialeUserId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Filiale_UserId");
    private final static QName _RequestPartiVariabiliPerAddendumIDProdottoCovenant_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ID_ProdottoCovenant");
    private final static QName _RequestPartiVariabiliPerAddendumNumeroProposta_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "NumeroProposta");
    private final static QName _ResponseStoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ResponseStoreCovenantAdesioneConvenzione");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneApplicativoId_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Applicativo_id");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneCodConvenzioneOLD_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "CodConvenzione_OLD");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneListaCovenantDaCessare_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ListaCovenantDaCessare");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneNSG_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "NSG");
    private final static QName _RequestStoreCovenantAdesioneConvenzioneTipoOperazione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "TipoOperazione");
    private final static QName _ResponseGetCovenantPerConvenzioneResponseGetCovenantPerConvenzione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "ResponseGetCovenantPerConvenzione");
    private final static QName _CovenantPerConvenzioneRequestDataDiNascita_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "DataDiNascita");
    private final static QName _CovenantPerConvenzioneRequestDataAdesione_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "Data_Adesione");
    private final static QName _CovenantPerConvenzioneRequestRapportoABI_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "RapportoABI");
    private final static QName _CovenantPerConvenzioneRequestRapportoCategoria_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "RapportoCategoria");
    private final static QName _CovenantPerConvenzioneRequestRapportoConto_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "RapportoConto");
    private final static QName _CovenantPerConvenzioneRequestRapportoFiliale_QNAME = new QName("http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", "RapportoFiliale");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.intesasanpaolo.connector.ws.gen.convenzionihostservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCovenantPerConvenzione }
     * 
     */
    public GetCovenantPerConvenzione createGetCovenantPerConvenzione() {
        return new GetCovenantPerConvenzione();
    }

    /**
     * Create an instance of {@link CovenantPerConvenzioneRequest }
     * 
     */
    public CovenantPerConvenzioneRequest createCovenantPerConvenzioneRequest() {
        return new CovenantPerConvenzioneRequest();
    }

    /**
     * Create an instance of {@link GetCovenantPerConvenzioneResponse }
     * 
     */
    public GetCovenantPerConvenzioneResponse createGetCovenantPerConvenzioneResponse() {
        return new GetCovenantPerConvenzioneResponse();
    }

    /**
     * Create an instance of {@link ResponseGetCovenantPerConvenzione }
     * 
     */
    public ResponseGetCovenantPerConvenzione createResponseGetCovenantPerConvenzione() {
        return new ResponseGetCovenantPerConvenzione();
    }

    /**
     * Create an instance of {@link StoreCovenantAdesioneConvenzione }
     * 
     */
    public StoreCovenantAdesioneConvenzione createStoreCovenantAdesioneConvenzione() {
        return new StoreCovenantAdesioneConvenzione();
    }

    /**
     * Create an instance of {@link RequestStoreCovenantAdesioneConvenzione }
     * 
     */
    public RequestStoreCovenantAdesioneConvenzione createRequestStoreCovenantAdesioneConvenzione() {
        return new RequestStoreCovenantAdesioneConvenzione();
    }

    /**
     * Create an instance of {@link StoreCovenantAdesioneConvenzioneResponse }
     * 
     */
    public StoreCovenantAdesioneConvenzioneResponse createStoreCovenantAdesioneConvenzioneResponse() {
        return new StoreCovenantAdesioneConvenzioneResponse();
    }

    /**
     * Create an instance of {@link ResponseStoreCovenantAdesioneConvenzione }
     * 
     */
    public ResponseStoreCovenantAdesioneConvenzione createResponseStoreCovenantAdesioneConvenzione() {
        return new ResponseStoreCovenantAdesioneConvenzione();
    }

    /**
     * Create an instance of {@link GetPartiVariabiliPerAddendum }
     * 
     */
    public GetPartiVariabiliPerAddendum createGetPartiVariabiliPerAddendum() {
        return new GetPartiVariabiliPerAddendum();
    }

    /**
     * Create an instance of {@link RequestPartiVariabiliPerAddendum }
     * 
     */
    public RequestPartiVariabiliPerAddendum createRequestPartiVariabiliPerAddendum() {
        return new RequestPartiVariabiliPerAddendum();
    }

    /**
     * Create an instance of {@link GetPartiVariabiliPerAddendumResponse }
     * 
     */
    public GetPartiVariabiliPerAddendumResponse createGetPartiVariabiliPerAddendumResponse() {
        return new GetPartiVariabiliPerAddendumResponse();
    }

    /**
     * Create an instance of {@link ResponseGetPartiVariabiliPerAddendum }
     * 
     */
    public ResponseGetPartiVariabiliPerAddendum createResponseGetPartiVariabiliPerAddendum() {
        return new ResponseGetPartiVariabiliPerAddendum();
    }

    /**
     * Create an instance of {@link BaselinePerHostRequest }
     * 
     */
    public BaselinePerHostRequest createBaselinePerHostRequest() {
        return new BaselinePerHostRequest();
    }

    /**
     * Create an instance of {@link GetBaselinePerHostRequest }
     * 
     */
    public GetBaselinePerHostRequest createGetBaselinePerHostRequest() {
        return new GetBaselinePerHostRequest();
    }

    /**
     * Create an instance of {@link ResponseBodyGetBaseline }
     * 
     */
    public ResponseBodyGetBaseline createResponseBodyGetBaseline() {
        return new ResponseBodyGetBaseline();
    }

    /**
     * Create an instance of {@link GetBaselinePerHostResponse }
     * 
     */
    public GetBaselinePerHostResponse createGetBaselinePerHostResponse() {
        return new GetBaselinePerHostResponse();
    }

    /**
     * Create an instance of {@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }
     * 
     */
    public ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione() {
        return new ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione();
    }

    /**
     * Create an instance of {@link ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }
     * 
     */
    public ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare createArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare() {
        return new ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }
     * 
     */
    public ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare() {
        return new ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }
     * 
     */
    public ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare() {
        return new ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }
     * 
     */
    public RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare() {
        return new RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }
     * 
     */
    public ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare() {
        return new ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare();
    }

    /**
     * Create an instance of {@link RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }
     * 
     */
    public RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare() {
        return new RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare();
    }

    /**
     * Create an instance of {@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }
     * 
     */
    public ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione() {
        return new ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione();
    }

    /**
     * Create an instance of {@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }
     * 
     */
    public ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare createArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare() {
        return new ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }
     * 
     */
    public ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare() {
        return new ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare();
    }

    /**
     * Create an instance of {@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }
     * 
     */
    public ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare createArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare() {
        return new ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare();
    }

    /**
     * Create an instance of {@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }
     * 
     */
    public ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare() {
        return new ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare();
    }

    /**
     * Create an instance of {@link ClassEsito }
     * 
     */
    public ClassEsito createClassEsito() {
        return new ClassEsito();
    }

    /**
     * Create an instance of {@link ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato }
     * 
     */
    public ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato createArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato() {
        return new ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato();
    }

    /**
     * Create an instance of {@link RequestPartiVariabiliPerAddendumCovenantAttivato }
     * 
     */
    public RequestPartiVariabiliPerAddendumCovenantAttivato createRequestPartiVariabiliPerAddendumCovenantAttivato() {
        return new RequestPartiVariabiliPerAddendumCovenantAttivato();
    }

    /**
     * Create an instance of {@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum }
     * 
     */
    public ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum() {
        return new ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum();
    }

    /**
     * Create an instance of {@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }
     * 
     */
    public ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato createArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato() {
        return new ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato();
    }

    /**
     * Create an instance of {@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }
     * 
     */
    public ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato() {
        return new ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato();
    }

    /**
     * Create an instance of {@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }
     * 
     */
    public ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario createArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario() {
        return new ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario();
    }

    /**
     * Create an instance of {@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }
     * 
     */
    public ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario() {
        return new ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario();
    }

    /**
     * Create an instance of {@link ArrayOfGetBaselinePerHostResponseBaseline }
     * 
     */
    public ArrayOfGetBaselinePerHostResponseBaseline createArrayOfGetBaselinePerHostResponseBaseline() {
        return new ArrayOfGetBaselinePerHostResponseBaseline();
    }

    /**
     * Create an instance of {@link GetBaselinePerHostResponseBaseline }
     * 
     */
    public GetBaselinePerHostResponseBaseline createGetBaselinePerHostResponseBaseline() {
        return new GetBaselinePerHostResponseBaseline();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ISPWebservicesHeader }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ISPWebservicesHeader }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ISPWebservicesHeader")
    public JAXBElement<ISPWebservicesHeader> createISPWebservicesHeader(ISPWebservicesHeader value) {
        return new JAXBElement<ISPWebservicesHeader>(_ISPWebservicesHeader_QNAME, ISPWebservicesHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovenantPerConvenzioneRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CovenantPerConvenzioneRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CovenantPerConvenzione_Request")
    public JAXBElement<CovenantPerConvenzioneRequest> createCovenantPerConvenzioneRequest(CovenantPerConvenzioneRequest value) {
        return new JAXBElement<CovenantPerConvenzioneRequest>(_CovenantPerConvenzioneRequest_QNAME, CovenantPerConvenzioneRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetCovenantPerConvenzione")
    public JAXBElement<ResponseGetCovenantPerConvenzione> createResponseGetCovenantPerConvenzione(ResponseGetCovenantPerConvenzione value) {
        return new JAXBElement<ResponseGetCovenantPerConvenzione>(_ResponseGetCovenantPerConvenzione_QNAME, ResponseGetCovenantPerConvenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione")
    public JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione(ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione value) {
        return new JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione_QNAME, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfResponse_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione.CovenantDaAttivare")
    public JAXBElement<ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare> createArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare(ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare>(_ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare_QNAME, ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetCovenantPerConvenzione.RespGetCovenantPerConvenzione.CovenantDaAttivare")
    public JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare(ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare_QNAME, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Request_StoreCovenantAdesioneConvenzione")
    public JAXBElement<RequestStoreCovenantAdesioneConvenzione> createRequestStoreCovenantAdesioneConvenzione(RequestStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<RequestStoreCovenantAdesioneConvenzione>(_RequestStoreCovenantAdesioneConvenzione_QNAME, RequestStoreCovenantAdesioneConvenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaAttivare")
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare(ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME, ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Request_StoreCovenantAdesioneConvenzione.CovenantDaAttivare")
    public JAXBElement<RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare(RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfRequest_StoreCovenantAdesioneConvenzione.CovenantDaCessare")
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> createArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare(ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME, ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Request_StoreCovenantAdesioneConvenzione.CovenantDaCessare")
    public JAXBElement<RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare(RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_StoreCovenantAdesioneConvenzione")
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzione> createResponseStoreCovenantAdesioneConvenzione(ResponseStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzione>(_ResponseStoreCovenantAdesioneConvenzione_QNAME, ResponseStoreCovenantAdesioneConvenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione")
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione(ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione>(_ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione_QNAME, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaAttivare")
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare(ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME, ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaAttivare")
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare(ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare_QNAME, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfResponse_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare")
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare> createArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare(ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME, ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_StoreCovenantAdesioneConvenzione.RespStoreCovenantAdesioneConvenzione.CovenantDaCessare")
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare(ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare_QNAME, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Request_PartiVariabiliPerAddendum")
    public JAXBElement<RequestPartiVariabiliPerAddendum> createRequestPartiVariabiliPerAddendum(RequestPartiVariabiliPerAddendum value) {
        return new JAXBElement<RequestPartiVariabiliPerAddendum>(_RequestPartiVariabiliPerAddendum_QNAME, RequestPartiVariabiliPerAddendum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfRequest_PartiVariabiliPerAddendum.CovenantAttivato")
    public JAXBElement<ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato> createArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato(ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato>(_ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato_QNAME, ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Request_PartiVariabiliPerAddendum.CovenantAttivato")
    public JAXBElement<RequestPartiVariabiliPerAddendumCovenantAttivato> createRequestPartiVariabiliPerAddendumCovenantAttivato(RequestPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<RequestPartiVariabiliPerAddendumCovenantAttivato>(_RequestPartiVariabiliPerAddendumCovenantAttivato_QNAME, RequestPartiVariabiliPerAddendumCovenantAttivato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetPartiVariabiliPerAddendum")
    public JAXBElement<ResponseGetPartiVariabiliPerAddendum> createResponseGetPartiVariabiliPerAddendum(ResponseGetPartiVariabiliPerAddendum value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendum>(_ResponseGetPartiVariabiliPerAddendum_QNAME, ResponseGetPartiVariabiliPerAddendum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum")
    public JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum(ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum_QNAME, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato")
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato> createArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato(ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato>(_ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato_QNAME, ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.CovenantAttivato")
    public JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato(ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato_QNAME, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfResponse_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.Glossario")
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario> createArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario(ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario value) {
        return new JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario>(_ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario_QNAME, ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Response_GetPartiVariabiliPerAddendum.RespGetPartiVariabiliPerAddendum.Glossario")
    public JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario(ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario_QNAME, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "GetBaselinePerHost_Request")
    public JAXBElement<GetBaselinePerHostRequest> createGetBaselinePerHostRequest(GetBaselinePerHostRequest value) {
        return new JAXBElement<GetBaselinePerHostRequest>(_GetBaselinePerHostRequest_QNAME, GetBaselinePerHostRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "GetBaselinePerHost_Response")
    public JAXBElement<GetBaselinePerHostResponse> createGetBaselinePerHostResponse(GetBaselinePerHostResponse value) {
        return new JAXBElement<GetBaselinePerHostResponse>(_GetBaselinePerHostResponse_QNAME, GetBaselinePerHostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ArrayOfGetBaselinePerHost_Response.Baseline")
    public JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline> createArrayOfGetBaselinePerHostResponseBaseline(ArrayOfGetBaselinePerHostResponseBaseline value) {
        return new JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline>(_ArrayOfGetBaselinePerHostResponseBaseline_QNAME, ArrayOfGetBaselinePerHostResponseBaseline.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponseBaseline }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponseBaseline }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "GetBaselinePerHost_Response.Baseline")
    public JAXBElement<GetBaselinePerHostResponseBaseline> createGetBaselinePerHostResponseBaseline(GetBaselinePerHostResponseBaseline value) {
        return new JAXBElement<GetBaselinePerHostResponseBaseline>(_GetBaselinePerHostResponseBaseline_QNAME, GetBaselinePerHostResponseBaseline.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CovenantPerConvenzioneRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CovenantPerConvenzioneRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "input", scope = GetCovenantPerConvenzione.class)
    public JAXBElement<CovenantPerConvenzioneRequest> createGetCovenantPerConvenzioneInput(CovenantPerConvenzioneRequest value) {
        return new JAXBElement<CovenantPerConvenzioneRequest>(_GetCovenantPerConvenzioneInput_QNAME, CovenantPerConvenzioneRequest.class, GetCovenantPerConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetCovenantPerConvenzioneResult", scope = GetCovenantPerConvenzioneResponse.class)
    public JAXBElement<ResponseGetCovenantPerConvenzione> createGetCovenantPerConvenzioneResponseGetCovenantPerConvenzioneResult(ResponseGetCovenantPerConvenzione value) {
        return new JAXBElement<ResponseGetCovenantPerConvenzione>(_GetCovenantPerConvenzioneResponseGetCovenantPerConvenzioneResult_QNAME, ResponseGetCovenantPerConvenzione.class, GetCovenantPerConvenzioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "input", scope = StoreCovenantAdesioneConvenzione.class)
    public JAXBElement<RequestStoreCovenantAdesioneConvenzione> createStoreCovenantAdesioneConvenzioneInput(RequestStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<RequestStoreCovenantAdesioneConvenzione>(_GetCovenantPerConvenzioneInput_QNAME, RequestStoreCovenantAdesioneConvenzione.class, StoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "StoreCovenantAdesioneConvenzioneResult", scope = StoreCovenantAdesioneConvenzioneResponse.class)
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzione> createStoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzioneResult(ResponseStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzione>(_StoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzioneResult_QNAME, ResponseStoreCovenantAdesioneConvenzione.class, StoreCovenantAdesioneConvenzioneResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RequestPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "input", scope = GetPartiVariabiliPerAddendum.class)
    public JAXBElement<RequestPartiVariabiliPerAddendum> createGetPartiVariabiliPerAddendumInput(RequestPartiVariabiliPerAddendum value) {
        return new JAXBElement<RequestPartiVariabiliPerAddendum>(_GetCovenantPerConvenzioneInput_QNAME, RequestPartiVariabiliPerAddendum.class, GetPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "GetPartiVariabiliPerAddendumResult", scope = GetPartiVariabiliPerAddendumResponse.class)
    public JAXBElement<ResponseGetPartiVariabiliPerAddendum> createGetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendumResult(ResponseGetPartiVariabiliPerAddendum value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendum>(_GetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendumResult_QNAME, ResponseGetPartiVariabiliPerAddendum.class, GetPartiVariabiliPerAddendumResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "parametriAdesione", scope = BaselinePerHostRequest.class)
    public JAXBElement<GetBaselinePerHostRequest> createBaselinePerHostRequestParametriAdesione(GetBaselinePerHostRequest value) {
        return new JAXBElement<GetBaselinePerHostRequest>(_BaselinePerHostRequestParametriAdesione_QNAME, GetBaselinePerHostRequest.class, BaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBaselinePerHostResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "getBaselineResponse", scope = ResponseBodyGetBaseline.class)
    public JAXBElement<GetBaselinePerHostResponse> createResponseBodyGetBaselineGetBaselineResponse(GetBaselinePerHostResponse value) {
        return new JAXBElement<GetBaselinePerHostResponse>(_ResponseBodyGetBaselineGetBaselineResponse_QNAME, GetBaselinePerHostResponse.class, ResponseBodyGetBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTipoBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineCodiceTipoBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineCodiceTipoBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceUDMBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineCodiceUDMBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineCodiceUDMBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "descrizioneBreveTipoBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineDescrizioneBreveTipoBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineDescrizioneBreveTipoBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "descrizioneEstesaTipoBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineDescrizioneEstesaTipoBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineDescrizioneEstesaTipoBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "descrizioneUDMBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineDescrizioneUDMBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineDescrizioneUDMBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "esito", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineEsito(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineEsito_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "messaggio", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineMessaggio(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineMessaggio_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "periodoDataA", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselinePeriodoDataA(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselinePeriodoDataA_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "periodoDataDa", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselinePeriodoDataDa(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselinePeriodoDataDa_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "periodoDescrizione", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselinePeriodoDescrizione(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselinePeriodoDescrizione_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "tipoBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<String> createGetBaselinePerHostResponseBaselineTipoBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineTipoBaseline_QNAME, String.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "valoreBaseline", scope = GetBaselinePerHostResponseBaseline.class)
    public JAXBElement<BigDecimal> createGetBaselinePerHostResponseBaselineValoreBaseline(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_GetBaselinePerHostResponseBaselineValoreBaseline_QNAME, BigDecimal.class, GetBaselinePerHostResponseBaseline.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codice", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioCodice(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioCodice_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ordinePosizione", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioOrdinePosizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossarioOrdinePosizione_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_Condizione", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Conto", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTemplate", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "errorMessage", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtApplicazioneBeneficio", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtApplicazioneBeneficio(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtApplicazioneBeneficio_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtBaseline1", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline1(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline1_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtBaseline2", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline2(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtBaseline2_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtEventoComposto", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtEventoComposto(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtEventoComposto_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtModalitaRilevazione1", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione1(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione1_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtModalitaRilevazione2", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione2(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtModalitaRilevazione2_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtPerimetroMonitoraggio1", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio1(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio1_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtPerimetroMonitoraggio2", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio2(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPerimetroMonitoraggio2_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtPeriodicitaRilevazione1", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione1(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione1_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "idTxtPeriodicitaRilevazione2", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione2(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoIdTxtPeriodicitaRilevazione2_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "resultCode", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoResultCode(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoResultCode_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "versioneTemplate", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME, String.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Esito", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class)
    public JAXBElement<ClassEsito> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumEsito(ClassEsito value) {
        return new JAXBElement<ClassEsito>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumEsito_QNAME, ClassEsito.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCovenantAttivati", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class)
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaCovenantAttivati(ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaCovenantAttivati_QNAME, ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivato.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaGlossario", scope = ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class)
    public JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario> createResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaGlossario(ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario value) {
        return new JAXBElement<ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaGlossario_QNAME, ArrayOfResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumGlossario.class, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_Condizione", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoCodCondizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Conto", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoRapportoConto(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTemplate", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "versioneTemplate", scope = RequestPartiVariabiliPerAddendumCovenantAttivato.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME, String.class, RequestPartiVariabiliPerAddendumCovenantAttivato.class, value);
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
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage_QNAME, String.class, ClassEsito.class, value);
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
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoResultCode_QNAME, String.class, ClassEsito.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessareProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "errorMessage", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessareErrorMessage(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage_QNAME, String.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivareProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "errorMessage", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivareErrorMessage(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoErrorMessage_QNAME, String.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ErroriListaCovenantDaAttivare", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaAttivare(ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaAttivare_QNAME, ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ErroriListaCovenantDaCessare", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaCessare(ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneErroriListaCovenantDaCessare_QNAME, ArrayOfResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClassEsito }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Esito", scope = ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ClassEsito> createResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzioneEsito(ClassEsito value) {
        return new JAXBElement<ClassEsito>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumEsito_QNAME, ClassEsito.class, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_Condizione", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareCodCondizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoCategoria(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Conto", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoConto(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareRapportoFiliale(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTemplate", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareCodiceTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "versioneTemplate", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaCessareVersioneTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioCondizionato_DataFine", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioCondizionato_DataInizio", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_DataFine", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_DataInizio", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_NumRilevazioni", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_Presente", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_DataFine", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataFine_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_DataInizio", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_Presente", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoPresente(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoPresente_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_Condizione", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_CondizioneReale_MLT", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizioneRealeMLT(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodCondizioneRealeMLT_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Covenant_DataFine", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataFine_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Covenant_DataInizio", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataInizio_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Flag_EntitaPrincipale", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareFlagEntitaPrincipale(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareFlagEntitaPrincipale_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Progressivo", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareProgressivo(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoProgressivo_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Categoria", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoCategoria(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoCategoria_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Conto", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoConto(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoConto_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Rapporto_Filiale", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareRapportoFiliale(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoRapportoFiliale_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTemplate", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCodiceTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "condizioniFiglie", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCondizioniFiglie(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCondizioniFiglie_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "livelloGerarchia", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareLivelloGerarchia(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareLivelloGerarchia_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "versioneTemplate", scope = RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareVersioneTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME, String.class, RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioCondizionato_DataFine", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataFine_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioCondizionato_DataInizio", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioCondizionatoDataInizio_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_DataFine", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataFine_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_DataInizio", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoDataInizio_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_NumRilevazioni", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoNumRilevazioni_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIncondizionato_Presente", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIncondizionatoPresente_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_DataFine", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIngressoDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataFine_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_DataInizio", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoDataInizio_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "BeneficioIngresso_Presente", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareBeneficioIngressoPresente(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareBeneficioIngressoPresente_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Cod_Condizione", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareCodCondizione(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodCondizione_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Covenant_DataFine", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareCovenantDataFine(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataFine_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Covenant_DataInizio", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareCovenantDataInizio(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCovenantDaAttivareCovenantDataInizio_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Flag_EffettoRilevato", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEffettoRilevato(String value) {
        return new JAXBElement<String>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEffettoRilevato_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Flag_EventoEtaCliente", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEventoEtaCliente(String value) {
        return new JAXBElement<String>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareFlagEventoEtaCliente_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTemplate", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareCodiceTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoCodiceTemplate_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "versioneTemplate", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class)
    public JAXBElement<String> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivareVersioneTemplate(String value) {
        return new JAXBElement<String>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumCovenantAttivatoVersioneTemplate_QNAME, String.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCovenantDaAttivare", scope = ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione.class)
    public JAXBElement<ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare> createResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneListaCovenantDaAttivare(ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneListaCovenantDaAttivare_QNAME, ArrayOfResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneCovenantDaAttivare.class, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfGetBaselinePerHostResponseBaseline }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaBaseline", scope = GetBaselinePerHostResponse.class)
    public JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline> createGetBaselinePerHostResponseListaBaseline(ArrayOfGetBaselinePerHostResponseBaseline value) {
        return new JAXBElement<ArrayOfGetBaselinePerHostResponseBaseline>(_GetBaselinePerHostResponseListaBaseline_QNAME, ArrayOfGetBaselinePerHostResponseBaseline.class, GetBaselinePerHostResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ABI", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestABI(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestABI_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodCondizione", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodCondizione(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodCondizione_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Language", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestLanguage(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestLanguage_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Prodotto", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestProdotto(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestProdotto_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserABI", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestUserABI(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserABI_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserId", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestUserId(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserId_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserUO", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestUserUO(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserUO_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codTemplate", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodTemplate(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodTemplate_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceAmbitoEvento", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodiceAmbitoEvento(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodiceAmbitoEvento_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceEvento", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodiceEvento(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodiceEvento_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceModaitaRilevazione", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodiceModaitaRilevazione(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodiceModaitaRilevazione_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codicePeriodicitaRilevazione", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodicePeriodicitaRilevazione(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestCodicePeriodicitaRilevazione_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "codiceTipoBaseline", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestCodiceTipoBaseline(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostResponseBaselineCodiceTipoBaseline_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "dataRichiesta", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestDataRichiesta(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestDataRichiesta_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "tipologiaTemplate", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestTipologiaTemplate(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestTipologiaTemplate_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "valoreAmbito", scope = GetBaselinePerHostRequest.class)
    public JAXBElement<String> createGetBaselinePerHostRequestValoreAmbito(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestValoreAmbito_QNAME, String.class, GetBaselinePerHostRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ResponseGetPartiVariabiliPerAddendum", scope = ResponseGetPartiVariabiliPerAddendum.class)
    public JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum> createResponseGetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendum(ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum value) {
        return new JAXBElement<ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum>(_ResponseGetPartiVariabiliPerAddendumResponseGetPartiVariabiliPerAddendum_QNAME, ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendum.class, ResponseGetPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ABI", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumABI(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestABI_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Applicativo_Id", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumApplicativoId(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumApplicativoId_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodConvenzione", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumCodConvenzione(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumCodConvenzione_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "DataProposta", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumDataProposta(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumDataProposta_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Data_Operazione", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumDataOperazione(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumDataOperazione_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Filiale_UserId", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumFilialeUserId(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumFilialeUserId_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ID_ProdottoCovenant", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumIDProdottoCovenant(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumIDProdottoCovenant_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCovenantAttivati", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato> createRequestPartiVariabiliPerAddendumListaCovenantAttivati(ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato value) {
        return new JAXBElement<ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato>(_ResponseGetPartiVariabiliPerAddendumRespGetPartiVariabiliPerAddendumListaCovenantAttivati_QNAME, ArrayOfRequestPartiVariabiliPerAddendumCovenantAttivato.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "NumeroProposta", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumNumeroProposta(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumNumeroProposta_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserId", scope = RequestPartiVariabiliPerAddendum.class)
    public JAXBElement<String> createRequestPartiVariabiliPerAddendumUserId(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserId_QNAME, String.class, RequestPartiVariabiliPerAddendum.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ResponseStoreCovenantAdesioneConvenzione", scope = ResponseStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione> createResponseStoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzione(ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione value) {
        return new JAXBElement<ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione>(_ResponseStoreCovenantAdesioneConvenzioneResponseStoreCovenantAdesioneConvenzione_QNAME, ResponseStoreCovenantAdesioneConvenzioneRespStoreCovenantAdesioneConvenzione.class, ResponseStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ABI", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneABI(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestABI_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Applicativo_id", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneApplicativoId(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneApplicativoId_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodConvenzione", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCodConvenzione(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumCodConvenzione_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodConvenzione_OLD", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneCodConvenzioneOLD(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneCodConvenzioneOLD_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "DataProposta", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneDataProposta(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumDataProposta_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Data_Operazione", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneDataOperazione(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumDataOperazione_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Filiale_UserId", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneFilialeUserId(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumFilialeUserId_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ID_ProdottoCovenant", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneIDProdottoCovenant(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumIDProdottoCovenant_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCovenantDaAttivare", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare> createRequestStoreCovenantAdesioneConvenzioneListaCovenantDaAttivare(ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare value) {
        return new JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare>(_ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzioneListaCovenantDaAttivare_QNAME, ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaAttivare.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ListaCovenantDaCessare", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare> createRequestStoreCovenantAdesioneConvenzioneListaCovenantDaCessare(ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare value) {
        return new JAXBElement<ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare>(_RequestStoreCovenantAdesioneConvenzioneListaCovenantDaCessare_QNAME, ArrayOfRequestStoreCovenantAdesioneConvenzioneCovenantDaCessare.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "NSG", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneNSG(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneNSG_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "NumeroProposta", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneNumeroProposta(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumNumeroProposta_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "TipoOperazione", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneTipoOperazione(String value) {
        return new JAXBElement<String>(_RequestStoreCovenantAdesioneConvenzioneTipoOperazione_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserId", scope = RequestStoreCovenantAdesioneConvenzione.class)
    public JAXBElement<String> createRequestStoreCovenantAdesioneConvenzioneUserId(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserId_QNAME, String.class, RequestStoreCovenantAdesioneConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ResponseGetCovenantPerConvenzione", scope = ResponseGetCovenantPerConvenzione.class)
    public JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione> createResponseGetCovenantPerConvenzioneResponseGetCovenantPerConvenzione(ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione value) {
        return new JAXBElement<ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione>(_ResponseGetCovenantPerConvenzioneResponseGetCovenantPerConvenzione_QNAME, ResponseGetCovenantPerConvenzioneRespGetCovenantPerConvenzione.class, ResponseGetCovenantPerConvenzione.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ABI", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestABI(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestABI_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Applicativo_Id", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestApplicativoId(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumApplicativoId_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "CodConvenzione", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestCodConvenzione(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumCodConvenzione_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "DataDiNascita", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestDataDiNascita(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestDataDiNascita_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Data_Adesione", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestDataAdesione(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestDataAdesione_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "Filiale_UserId", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestFilialeUserId(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumFilialeUserId_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "ID_ProdottoCovenant", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestIDProdottoCovenant(String value) {
        return new JAXBElement<String>(_RequestPartiVariabiliPerAddendumIDProdottoCovenant_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "RapportoABI", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestRapportoABI(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestRapportoABI_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "RapportoCategoria", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestRapportoCategoria(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestRapportoCategoria_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "RapportoConto", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestRapportoConto(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestRapportoConto_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "RapportoFiliale", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestRapportoFiliale(String value) {
        return new JAXBElement<String>(_CovenantPerConvenzioneRequestRapportoFiliale_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/IntesaSanPaolo.Pricing.WebServices.Common.DAL.Entities", name = "UserId", scope = CovenantPerConvenzioneRequest.class)
    public JAXBElement<String> createCovenantPerConvenzioneRequestUserId(String value) {
        return new JAXBElement<String>(_GetBaselinePerHostRequestUserId_QNAME, String.class, CovenantPerConvenzioneRequest.class, value);
    }

}
