package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BsTypeTest {

	@Test
	public void test() {

		System.out.println("Enum " + BSType.FL03S00.name() + " codice: " + BSType.FL03S00.getCode() + " descrizione: "
				+ BSType.FL03S00.getDesc() + " idServizio: " + BSType.FL03S00.getIdServizio());

		System.out.println("Enum " + BSType.T1SJS00.name() + " codice: " + BSType.T1SJS00.getCode() + " descrizione: "
				+ BSType.T1SJS00.getDesc() + " idServizio: " + BSType.T1SJS00.getIdServizio());

		System.out.println("Enum " + BSType.WKCJS00.name() + " codice: " + BSType.WKCJS00.getCode() + " descrizione: "
				+ BSType.WKCJS00.getDesc() + " idServizio: " + BSType.WKCJS00.getIdServizio());

		System.out.println("Enum " + BSType.PCUJS00.name() + " codice: " + BSType.PCUJS00.getCode() + " descrizione: "
				+ BSType.PCUJS00.getDesc() + " idServizio: " + BSType.PCUJS00.getIdServizio());

	}

}
