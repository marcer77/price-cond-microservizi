//package com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.intesasanpaolo.bear.BaseTest;
//import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.EsitoInviaPropostaV2Response;
//import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.gen.propostecjpos.InviaPropostaV2;
//import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2RequestTransformer;
//import com.intesasanpaolo.bear.cond0.cjdispositiva.connector.ws.transformers.ProposteCJPOSWSInviaPropostaV2ResponseTransformer;
//import com.intesasanpaolo.bear.cond0.cjdispositiva.utils.ProposteCJPOSWSUtils;
//import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;
//
//public class ProposteCJPOSWSInviaPropostaV2ConnectorTest extends BaseTest {
//
//	@Autowired
//	private ProposteCJPOSWSInviaPropostaV2Connector proposteCJPOSWSInviaPropostaV2Connector;
//
//	@Autowired
//	private ProposteCJPOSWSInviaPropostaV2RequestTransformer proposteCJPOSWSInviaPropostaV2RequestTransformer;
//
//	@Autowired
//	private ProposteCJPOSWSInviaPropostaV2ResponseTransformer proposteCJPOSWSInviaPropostaV2ResponseTransformer;
//
//	private ISPWebservicesHeaderType header;
//
//	private InviaPropostaV2 inviaProposta;
//
//	@Before
//	public void initMocks() throws Exception {
//
//		header = ProposteCJPOSWSUtils._buildMockedHeader();
//
//		inviaProposta = ProposteCJPOSWSUtils._buildMockInviaPropostaV2();
//
//	}
//
////	@Test
////	public void callKOTest() {
////		EsitoInviaPropostaV2Response esito = proposteCJPOSWSInviaPropostaV2Connector.call(inviaProposta,
////				proposteCJPOSWSInviaPropostaV2RequestTransformer, proposteCJPOSWSInviaPropostaV2ResponseTransformer,
////				header);
////	}
//
//	@Test
//	public void callOKTest() {
//		EsitoInviaPropostaV2Response esito = proposteCJPOSWSInviaPropostaV2Connector.call(null, proposteCJPOSWSInviaPropostaV2RequestTransformer,
//				proposteCJPOSWSInviaPropostaV2ResponseTransformer, null);
//		
//		assertTrue(esito==null);
//	}
//}
