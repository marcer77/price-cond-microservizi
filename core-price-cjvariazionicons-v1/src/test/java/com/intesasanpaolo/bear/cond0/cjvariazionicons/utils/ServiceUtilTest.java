package com.intesasanpaolo.bear.cond0.cjvariazionicons.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.dsi.business.SSA_FL.integration.jdo.P_FL03S00.INHEADER;
import com.intesasanpaolo.bear.cond0.cj.lib.utils.ServiceUtil;
import com.intesasanpaolo.bear.core.model.ispHeaders.ISPWebservicesHeaderType;

@RunWith(SpringRunner.class)
public class ServiceUtilTest {

	
	@Test
	public void testSetHeaders() {
		
		INHEADER inheader = new INHEADER();
		 
		ISPWebservicesHeaderType ispWebservicesHeaderType=ServiceUtil.buildISPWebservicesHeaderType()
				.applicationID("121")
				.callerCompanyIDCode("01")
				.callerProgramName("121")
				.channelIDCode("")
				.codABI("01025")
				.codUnitaOperativa("00700")
				.customerID("23232")
				.isVirtualUser("false")
				.language("IT")
				.serviceCompanyIDCode("01")
				.serviceID("FL030FLA01")
				.userID("343")
				.transactionId("3434343")
				.timestamp("0")
				.serviceVersion("00").build();
			
		ServiceUtil.setHeaders(inheader, ispWebservicesHeaderType);
		Assert.assertTrue(inheader.COD_ABI.equals("01025"));
		
	}
}
