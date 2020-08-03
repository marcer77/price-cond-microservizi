package com.intesasanpaolo.bear.cond0.cj.lib.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BsTypeCallTest {

	@Test
	public void test() {

		System.out.println(
				"Enum name " + BSTypeCall.FL03S00_CALL.name()+
				"getAcronimoOwnerBS " + BSTypeCall.FL03S00_CALL.getAcronimoOwnerBS()+
				"getBsType " + BSTypeCall.FL03S00_CALL.getBsType()+
				"getChannel " + BSTypeCall.FL03S00_CALL.getChannel()+
				"getLenArea " + BSTypeCall.FL03S00_CALL.getLenArea()+
				"getRecyclingVersion " + BSTypeCall.FL03S00_CALL.getRecyclingVersion()+
				"getVersion  " + BSTypeCall.FL03S00_CALL.getVersion()
				);
		
		System.out.println(
				"Enum name " + BSTypeCall.PCUJS00_CALL.name()+
				"getAcronimoOwnerBS " + BSTypeCall.PCUJS00_CALL.getAcronimoOwnerBS()+
				"getBsType " + BSTypeCall.PCUJS00_CALL.getBsType()+
				"getChannel " + BSTypeCall.PCUJS00_CALL.getChannel()+
				"getLenArea " + BSTypeCall.PCUJS00_CALL.getLenArea()+
				"getRecyclingVersion " + BSTypeCall.PCUJS00_CALL.getRecyclingVersion()+
				"getVersion  " + BSTypeCall.PCUJS00_CALL.getVersion()
				);
		
		System.out.println(
				"Enum name " + BSTypeCall.T1SJ00_CALL.name()+
				"getAcronimoOwnerBS " + BSTypeCall.T1SJ00_CALL.getAcronimoOwnerBS()+
				"getBsType " + BSTypeCall.T1SJ00_CALL.getBsType()+
				"getChannel " + BSTypeCall.T1SJ00_CALL.getChannel()+
				"getLenArea " + BSTypeCall.T1SJ00_CALL.getLenArea()+
				"getRecyclingVersion " + BSTypeCall.T1SJ00_CALL.getRecyclingVersion()+
				"getVersion  " + BSTypeCall.T1SJ00_CALL.getVersion()
				);
		
		System.out.println(
				"Enum name " + BSTypeCall.WKCJS00_CALL.name()+
				"getAcronimoOwnerBS " + BSTypeCall.WKCJS00_CALL.getAcronimoOwnerBS()+
				"getBsType " + BSTypeCall.WKCJS00_CALL.getBsType()+
				"getChannel " + BSTypeCall.WKCJS00_CALL.getChannel()+
				"getLenArea " + BSTypeCall.WKCJS00_CALL.getLenArea()+
				"getRecyclingVersion " + BSTypeCall.WKCJS00_CALL.getRecyclingVersion()+
				"getVersion  " + BSTypeCall.WKCJS00_CALL.getVersion()
				);

	}

}
