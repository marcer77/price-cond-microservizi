package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

import java.util.List;

import com.intesasanpaolo.bear.bear_v3.connector.ws.mavengen.iibcdprcms.IIBCDPRCMSSingleRequestType;

public class IIBCDPRCMSRequest {

	private List<IIBCDPRCMSSingleRequestType> body;
	
	private IIBCDPRCMSHeader header;

	public IIBCDPRCMSRequest() {
	}

	public List<IIBCDPRCMSSingleRequestType> getBody() {
		return body;
	}

	public void setBody(List<IIBCDPRCMSSingleRequestType> body) {
		this.body = body;
	}

	public IIBCDPRCMSHeader getHeader() {
		return header;
	}

	public void setHeader(IIBCDPRCMSHeader header) {
		this.header = header;
	}
}
