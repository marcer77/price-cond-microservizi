package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import static com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil.withNoException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
import com.intesasanpaolo.bear.core.resource.BaseResource;
import com.intesasanpaolo.bear.exceptions.model.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RunWith(SpringRunner.class)
public class ServiceUtilTest {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	class HeaderMock {
		public int RETCODE;

		public String CODICESTATO;

		public String ID_SERVIZIO;

		public String CODICE_TIPO_CANALE;

		public String CODICE_SOCIETA;

		public String CODICE_SPORTELLO;

		public String CODICE_UO_RICH;

		public String CODICE_USERID;

		public String MQM_NAME_DEST;

		public String COD_RIS_RICH;

		public String COD_RICH_CANALE;

		public String DATA_CONT;

		public int LUNGHEZZA_MSG;

		public String IND_MQ_SINCRONO;

		public String COD_TIPO_LINGUA;

		public String TIPO_SIC_APPL_INP;

		public String TIPO_SIC_APPL_OUT;

		public String IND_COMPRESS_INP;

		public String IND_COMPRESS_OUT;

		public String IND_ROUTING_MSG;

		public String COD_SSA_SERVIZIO;

		public String IND_INOLTRO_REPLY;

		public String COD_ABI;

		public String COD_AZIENDA_DEST;

		public String COD_OPERATIVITA;

		public String FLAG_PAPERLESS;

		public String FLAG_RACF;

		public String COD_RIC_TRAC;

		public String HSP_IND_ATOM;

		public String HSP_TRN_ATOM;

		public String HSP_PGM_ATOM;

		public String HSP_TIMEOUT;

		public String HSP_ACRONIMO;

		public String HSP_FLAG24X7;

		public String HSP_CONV_NULL;

		public String HSP_ACRONIMO_PROVIDER;

		public String HSP_TIMEIIB;

		public String COD_BSM;

		public String SIC_TIMESTAMP;

		public String SIC_KEY;

		public String SIC_MAC;

		public String COD_VERS_SIC;

		public String COD_CLI_RICH;

		public String COD_TERM_CICS;

		public String COD_VERSIONE_BS;

	}

	@Test
	public void testSetHeaders() {
		HeaderMock obj = new HeaderMock();

		// INHEADER inheader = new INHEADER();

		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("121").callerCompanyIDCode("01").callerProgramName("121").channelIDCode("")
				.codABI("01025").codUnitaOperativa("00700").customerID("23232").isVirtualUser("false").language("IT")
				.serviceCompanyIDCode("01").serviceID("FL030FLA01").userID("343").transactionId("3434343")
				.timestamp("0").serviceVersion("00").build();
		// ServiceUtil.setHeaders(obj, ispWebservicesHeaderType);
		// System.out.println(obj.getCOD_ABI());
		// Assert.assertTrue(inheader.COD_ABI.equals("01025"));

	}

	@Test
	public void testFormattaDouble() {
		Double d = new Double(123.5677);
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(d, null));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232, null));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(0.23343, "#######.##"));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(0.23343, "#######"));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232, "#######"));
	}

	@Test
	public void testFormattaNumero() {
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(9.0));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(10000.232));
		System.out.println(">>>>>>" + ServiceUtil.formattaNumero(null));
	}

	

	@Test
	public void testIfNull() {
		ServiceUtil.ifNull(null, "valore");
		ServiceUtil.ifNull("test", "valore");
	}

	@Test
	public void testIfNullAsInt() {
		ServiceUtil.ifNullAsInt(null, 0);
		ServiceUtil.ifNullAsInt(13, 0);
	}

	@Test
	public void testStampaOggetto() {
		BaseResource baseResource=new BaseResource();
		baseResource.setEntityId("12");
		baseResource.setReturnMessages(new HashMap<String, List<ErrorMessage>>());
		String st=ServiceUtil.stampaOggetto(baseResource).toString();
		Assert.assertTrue(!st.equals(""));
	}

	@Test
	public void testSetBSHeaders() {
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("0").callerCompanyIDCode("01").callerProgramName("1").channelIDCode("0").codABI("01025")
				.codUnitaOperativa("0").customerID("0").isVirtualUser("false").language("I").serviceCompanyIDCode("01")
				.serviceID("00").userID("U015886").transactionId("0").timestamp("0").serviceVersion("0").build();

		HeaderMock header = new HeaderMock();

		ServiceUtil.setBSHeaders(header, BSTypeCall.FL03S00_CALL, ispWebservicesHeaderType);

	}
	
	@Test(expected = AssertionError.class)
	public void setHeader() {
		ISPWebservicesHeaderType ispWebservicesHeaderType = ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("0").callerCompanyIDCode("01").callerProgramName("1").channelIDCode("0").codABI("01025")
				.codUnitaOperativa("0").customerID("0").isVirtualUser("false").language("I").serviceCompanyIDCode("01")
				.serviceID("00").userID("U015886").transactionId("0").timestamp("0").serviceVersion("0").build();

		ServiceUtil.setHeader(ispWebservicesHeaderType,"test","prova");
	}
	
	@Test	
	public void testIfNullAsDouble() throws ParseException {
		Double d=ServiceUtil.ifNullAsDouble(null);
		Assert.assertTrue(d==0);
		d=ServiceUtil.ifNullAsDouble(40);
		Assert.assertTrue(d==40);
	}
	
	@Test
	public void testWithNoException() {
		withNoException(()-> "test",null);
	}
	
	@Test
	public void testSostituzioneCaratteriFL03() {
		
		String docXML = "<multiple documentSave = \"SI\" documentResponse = \"SI\" tipoFdig = \"NO\" tipoFea = \"SI\" tipoOperazione = \"OIS\" SSA = \"T1\" CodPratica = \"1981014001\" CodSuperPratica = \"3788861\" CodPropostaCanale = \"0\" CodOperazione = \" \" CodDominio = \"01\" CodSocieta = \"01\" CodFiliale = \"00103\" Utenza = \"U009128\"><root><Archiviazione>NO</Archiviazione><infoPDF><app>FL888</app><template>T1_CONV_FID2.xdp</template><version>6.0</version><contenturi>FL888\\\\6.0\\\\TEMPLATE</contenturi><out>PDF</out></infoPDF><SubformBlocchettoCortoColori><codice_soaBlocchettoCortoCol>01</codice_soaBlocchettoCortoCol></SubformBlocchettoCortoColori><dataPDF><SubformLogoColori><codice_soaLogoCol>01</codice_soaLogoCol></SubformLogoColori><T1COF01_COPIA>C</T1COF01_COPIA><t1cof01_st_cliente>TECNO GARDEN CIOFALO HAMITAT</t1cof01_st_cliente><T1CON01_TIPO_DOCUMENTO>FEA</T1CON01_TIPO_DOCUMENTO><T1COF01_DISTANZA>P</T1COF01_DISTANZA><t1cof01_st_indirizzo>VIA VIA ALERAMO,8 248</t1cof01_st_indirizzo><t1cof01_st_cap>15079</t1cof01_st_cap><t1cof01_st_citta>SEZZADIO</t1cof01_st_citta><t1cof01_st_provincia>AL</t1cof01_st_provincia><ITEMLOOP_T1COF00><LOOP_T1COF00><T1COF01_TIPO_CONTRATTO>APC</T1COF01_TIPO_CONTRATTO><t1cof01_st_ape_credito>00103/1000/00104174</t1cof01_st_ape_credito><t1cof01_st_nr_conto>00103/1000/00104174</t1cof01_st_nr_conto><t1cof01_st_data_aff>Revoca</t1cof01_st_data_aff><ITEMLIST_t1cof01_ls_cond><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> AFFIDAMENTI E TASSI.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Importo totale del credito Apertura di credito in c/c garantita a revoca</t1cof01_elst_voce><t1cof01_elst_valore>10.000,00 euro</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>14,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>25.10.2020</t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>0,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>BBBB</t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> SPESE PER LA GESTIONE DEL RAPPORTO.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Commissione di disponibilita' fondi (C.D.F.)</t1cof01_elst_voce><t1cof01_elst_valore>0,5000 %</t1cof01_elst_valore><t1cof01_elst_nota>(1)</t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM></ITEMLIST_t1cof01_ls_cond></LOOP_T1COF00></ITEMLOOP_T1COF00><t1cof01_st_note>Note</t1cof01_st_note><ITEMLIST_t1cof01_ls_note><ITEM><t1cof01_elst_numero_nota>(1)</t1cof01_elst_numero_nota><t1cof01n>L'importo dovuto a titolo di C.D.F. e' calcolato al termine di ogni trimestre solare, applicando la percentuale indicata alla media dell'ammontare complessivo delle linee di credito concesse al Cliente in essere durante il trimestre stesso, anche solo per parte di questo periodo e anche qualora tale ammontare complessivo sia stato utilizzato, in tutto o in parte. Il valore percentuale esposto sara' applicato anche su tutti gli affidamenti della medesima natura a lei concessi su questo c/c: Aperture di credito in conto corrente.</t1cof01n></ITEM></ITEMLIST_t1cof01_ls_note><t1cof01_st_luogo>CHIAVARI</t1cof01_st_luogo><t1con01_st_data_firma>25.10.2020</t1con01_st_data_firma><t1con01_st_desc_banca>INTESA SANPAOLO S.P.A.</t1con01_st_desc_banca><t1con01_st_desc_filiale>CHIAVARI</t1con01_st_desc_filiale><ITEMLIST_t1cl101_ls_firme><ITEM><t1cl101_elst_firma></t1cl101_elst_firma><t1cl101_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl101_elst_cogn_nome><t1cl101_elst_fdig>{​ISPPC#FDC#093,025#¢;0011072447000;001!#001}​</t1cl101_elst_fdig></ITEM></ITEMLIST_t1cl101_ls_firme><ITEMLIST_t1cl201_ls_firme><ITEM><t1cl201_elst_firma></t1cl201_elst_firma><t1cl201_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl201_elst_cogn_nome><t1cl201_elst_fdig>{​ISPPC#FDC#093,025#¢;0011072447000;001!#002}​</t1cl201_elst_fdig></ITEM></ITEMLIST_t1cl201_ls_firme><aa_skeleton_data>25/10/2020</aa_skeleton_data><aa_skeleton_ora>- 23:36</aa_skeleton_ora><aa_skeleton_int>TECNO GARDEN CIOFALO HAMITAT</aa_skeleton_int><aa_skeleton_copia></aa_skeleton_copia></dataPDF><ARCHIVIAZIONE></ARCHIVIAZIONE></root></multiple>";
		String docXML2 = "<multiple documentSave = \"SI\" documentResponse = \"SI\" tipoFdig = \"NO\" tipoFea = \"SI\" tipoOperazione = \"OIS\" SSA = \"T1\" CodPratica = \"1981014001\" CodSuperPratica = \"3788861\" CodPropostaCanale = \"0\" CodOperazione = \" \" CodDominio = \"01\" CodSocieta = \"01\" CodFiliale = \"00103\" Utenza = \"U009128\"><root><Archiviazione>NO</Archiviazione><infoPDF><app>FL888</app><template>T1_CONV_FID2.xdp</template><version>6.0</version><contenturi>FL888\\\\6.0\\\\TEMPLATE</contenturi><out>PDF</out></infoPDF><SubformBlocchettoCortoColori><codice_soaBlocchettoCortoCol>01</codice_soaBlocchettoCortoCol></SubformBlocchettoCortoColori><dataPDF><SubformLogoColori><codice_soaLogoCol>01</codice_soaLogoCol></SubformLogoColori><T1COF01_COPIA>C</T1COF01_COPIA><t1cof01_st_cliente>TECNO GARDEN CIOFALO HAMITAT</t1cof01_st_cliente><T1CON01_TIPO_DOCUMENTO>FEA</T1CON01_TIPO_DOCUMENTO><T1COF01_DISTANZA>P</T1COF01_DISTANZA><t1cof01_st_indirizzo>VIA VIA ALERAMO,8 248</t1cof01_st_indirizzo><t1cof01_st_cap>15079</t1cof01_st_cap><t1cof01_st_citta>SEZZADIO</t1cof01_st_citta><t1cof01_st_provincia>AL</t1cof01_st_provincia><ITEMLOOP_T1COF00><LOOP_T1COF00><T1COF01_TIPO_CONTRATTO>APC</T1COF01_TIPO_CONTRATTO><t1cof01_st_ape_credito>00103/1000/00104174</t1cof01_st_ape_credito><t1cof01_st_nr_conto>00103/1000/00104174</t1cof01_st_nr_conto><t1cof01_st_data_aff>Revoca</t1cof01_st_data_aff><ITEMLIST_t1cof01_ls_cond><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> AFFIDAMENTI E TASSI.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Importo totale del credito Apertura di credito in c/c garantita a revoca</t1cof01_elst_voce><t1cof01_elst_valore>10.000,00 euro</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>14,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>25.10.2020</t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>0,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>BBBB</t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> SPESE PER LA GESTIONE DEL RAPPORTO.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Commissione di disponibilita' fondi (C.D.F.)</t1cof01_elst_voce><t1cof01_elst_valore>0,5000 %</t1cof01_elst_valore><t1cof01_elst_nota>(1)</t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM></ITEMLIST_t1cof01_ls_cond></LOOP_T1COF00></ITEMLOOP_T1COF00><t1cof01_st_note>Note</t1cof01_st_note><ITEMLIST_t1cof01_ls_note><ITEM><t1cof01_elst_numero_nota>(1)</t1cof01_elst_numero_nota><t1cof01n>L'importo dovuto a titolo di C.D.F. e' calcolato al termine di ogni trimestre solare, applicando la percentuale indicata alla media dell'ammontare complessivo delle linee di credito concesse al Cliente in essere durante il trimestre stesso, anche solo per parte di questo periodo e anche qualora tale ammontare complessivo sia stato utilizzato, in tutto o in parte. Il valore percentuale esposto sara' applicato anche su tutti gli affidamenti della medesima natura a lei concessi su questo c/c: Aperture di credito in conto corrente.</t1cof01n></ITEM></ITEMLIST_t1cof01_ls_note><t1cof01_st_luogo>CHIAVARI</t1cof01_st_luogo><t1con01_st_data_firma>25.10.2020</t1con01_st_data_firma><t1con01_st_desc_banca>INTESA SANPAOLO S.P.A.</t1con01_st_desc_banca><t1con01_st_desc_filiale>CHIAVARI</t1con01_st_desc_filiale><ITEMLIST_t1cl101_ls_firme><ITEM><t1cl101_elst_firma></t1cl101_elst_firma><t1cl101_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl101_elst_cogn_nome></ITEM></ITEMLIST_t1cl101_ls_firme><ITEMLIST_t1cl201_ls_firme><ITEM><t1cl201_elst_firma></t1cl201_elst_firma><t1cl201_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl201_elst_cogn_nome></ITEM></ITEMLIST_t1cl201_ls_firme><aa_skeleton_data>25/10/2020</aa_skeleton_data><aa_skeleton_ora>- 23:36</aa_skeleton_ora><aa_skeleton_int>TECNO GARDEN CIOFALO HAMITAT</aa_skeleton_int><aa_skeleton_copia></aa_skeleton_copia></dataPDF><ARCHIVIAZIONE></ARCHIVIAZIONE></root></multiple>";
		String docXML3 = "<multiple documentSave = \"SI\" documentResponse = \"SI\" tipoFdig = \"NO\" tipoFea = \"SI\" tipoOperazione = \"OIS\" SSA = \"T1\" CodPratica = \"1981014001\" CodSuperPratica = \"3788861\" CodPropostaCanale = \"0\" CodOperazione = \" \" CodDominio = \"01\" CodSocieta = \"01\" CodFiliale = \"00103\" Utenza = \"U009128\"><root><Archiviazione>NO</Archiviazione><infoPDF><app>FL888</app><template>T1_CONV_FID2.xdp</template><version>6.0</version><contenturi>FL888\\\\6.0\\\\TEMPLATE</contenturi><out>PDF</out></infoPDF><SubformBlocchettoCortoColori><codice_soaBlocchettoCortoCol>01</codice_soaBlocchettoCortoCol></SubformBlocchettoCortoColori><dataPDF><SubformLogoColori><codice_soaLogoCol>01</codice_soaLogoCol></SubformLogoColori><T1COF01_COPIA>C</T1COF01_COPIA><t1cof01_st_cliente>TECNO GARDEN CIOFALO HAMITAT</t1cof01_st_cliente><T1CON01_TIPO_DOCUMENTO>FEA</T1CON01_TIPO_DOCUMENTO><T1COF01_DISTANZA>P</T1COF01_DISTANZA><t1cof01_st_indirizzo>VIA VIA ALERAMO,8 248</t1cof01_st_indirizzo><t1cof01_st_cap>15079</t1cof01_st_cap><t1cof01_st_citta>SEZZADIO</t1cof01_st_citta><t1cof01_st_provincia>AL</t1cof01_st_provincia><ITEMLOOP_T1COF00><LOOP_T1COF00><T1COF01_TIPO_CONTRATTO>APC</T1COF01_TIPO_CONTRATTO><t1cof01_st_ape_credito>00103/1000/00104174</t1cof01_st_ape_credito><t1cof01_st_nr_conto>00103/1000/00104174</t1cof01_st_nr_conto><t1cof01_st_data_aff>Revoca</t1cof01_st_data_aff><ITEMLIST_t1cof01_ls_cond><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> AFFIDAMENTI E TASSI.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Importo totale del credito Apertura di credito in c/c garantita a revoca</t1cof01_elst_voce><t1cof01_elst_valore>10.000,00 euro</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>14,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>25.10.2020</t1cof01_elst_data_dec><t1cof01_elst_voce>   Tasso Debitore di interesse nominale annuo (T.A.N.)</t1cof01_elst_voce><t1cof01_elst_valore>0,0000 %</t1cof01_elst_valore><t1cof01_elst_nota></t1cof01_elst_nota><t1cof01_elst_font>BBBB</t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce> SPESE PER LA GESTIONE DEL RAPPORTO.</t1cof01_elst_voce><t1cof01_elst_valore>                                                                                          </t1cof01_elst_valore><t1cof01_elst_nota>     </t1cof01_elst_nota><t1cof01_elst_font> B  </t1cof01_elst_font></ITEM><ITEM><t1cof01_elst_data_dec>          </t1cof01_elst_data_dec><t1cof01_elst_voce>   Commissione di disponibilita' fondi (C.D.F.)</t1cof01_elst_voce><t1cof01_elst_valore>0,5000 %</t1cof01_elst_valore><t1cof01_elst_nota>(1)</t1cof01_elst_nota><t1cof01_elst_font>    </t1cof01_elst_font></ITEM></ITEMLIST_t1cof01_ls_cond></LOOP_T1COF00></ITEMLOOP_T1COF00><t1cof01_st_note>Note</t1cof01_st_note><ITEMLIST_t1cof01_ls_note><ITEM><t1cof01_elst_numero_nota>(1)</t1cof01_elst_numero_nota><t1cof01n>L'importo dovuto a titolo di C.D.F. e' calcolato al termine di ogni trimestre solare, applicando la percentuale indicata alla media dell'ammontare complessivo delle linee di credito concesse al Cliente in essere durante il trimestre stesso, anche solo per parte di questo periodo e anche qualora tale ammontare complessivo sia stato utilizzato, in tutto o in parte. Il valore percentuale esposto sara' applicato anche su tutti gli affidamenti della medesima natura a lei concessi su questo c/c: Aperture di credito in conto corrente.</t1cof01n></ITEM></ITEMLIST_t1cof01_ls_note><t1cof01_st_luogo>CHIAVARI</t1cof01_st_luogo><t1con01_st_data_firma>25.10.2020</t1con01_st_data_firma><t1con01_st_desc_banca>INTESA SANPAOLO S.P.A.</t1con01_st_desc_banca><t1con01_st_desc_filiale>CHIAVARI</t1con01_st_desc_filiale><ITEMLIST_t1cl101_ls_firme><ITEM><t1cl101_elst_firma></t1cl101_elst_firma><t1cl101_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl101_elst_cogn_nome><t1cl101_elst_fdig>{​ISPPC#FDC#093,025#;0011072447000;001#001}​</t1cl101_elst_fdig></ITEM></ITEMLIST_t1cl101_ls_firme><ITEMLIST_t1cl201_ls_firme><ITEM><t1cl201_elst_firma></t1cl201_elst_firma><t1cl201_elst_cogn_nome>TECNO GARDEN CIOFALO HAMITAT</t1cl201_elst_cogn_nome><t1cl201_elst_fdig>{​ISPPC#FDC#093,025#;0011072447000;001#002}​</t1cl201_elst_fdig></ITEM></ITEMLIST_t1cl201_ls_firme><aa_skeleton_data>25/10/2020</aa_skeleton_data><aa_skeleton_ora>- 23:36</aa_skeleton_ora><aa_skeleton_int>TECNO GARDEN CIOFALO HAMITAT</aa_skeleton_int><aa_skeleton_copia></aa_skeleton_copia></dataPDF><ARCHIVIAZIONE></ARCHIVIAZIONE></root></multiple>";
		
		String result = ServiceUtil.sostituzioneCaratteriFL03(docXML);
		
		Assert.assertFalse(result.equals(docXML));
		
		result = ServiceUtil.sostituzioneCaratteriFL03(docXML2);
		
		Assert.assertFalse(result.equals(docXML2));
		
		result = ServiceUtil.sostituzioneCaratteriFL03(docXML3);
		
		Assert.assertFalse(result.equals(docXML3));
	
		result = ServiceUtil.sostituzioneCaratteriFL03("");
		
		Assert.assertTrue(result.equals(""));
		
		result = ServiceUtil.sostituzioneCaratteriFL03(null);

		Assert.assertTrue(result==null);
	}
	
}
