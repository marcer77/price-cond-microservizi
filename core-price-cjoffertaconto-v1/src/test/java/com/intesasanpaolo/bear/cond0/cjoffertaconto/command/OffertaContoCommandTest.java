package com.intesasanpaolo.bear.cond0.cjoffertaconto.command;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.intesasanpaolo.bear.cond0.cjoffertaconto.resource.EsponiResponseResource;

@RunWith(SpringRunner.class)
public class OffertaContoCommandTest {
	
	@Test
	public void testMock() {
		OffertaContoCommand offertaContoCommand=new OffertaContoCommand(null, null);
		EsponiResponseResource res=offertaContoCommand.getMockResponse();
		Assert.assertTrue(res.getEsito()!=null);
	}
}
