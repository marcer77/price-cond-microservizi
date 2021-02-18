package com.intesasanpaolo.bear.bear_v3.model.inquirycontocnd;

public class IIBCDPRCMSHeader {
	
	private String userID;
	private String ispServiceCompanyIDCode;
	private String ispCallerCompanyIDCode;
	private String codABI;
	private String ispBranchCode;
	
	public IIBCDPRCMSHeader() {
		
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getIspServiceCompanyIDCode() {
		return ispServiceCompanyIDCode;
	}

	public void setIspServiceCompanyIDCode(String ispServiceCompanyIDCode) {
		this.ispServiceCompanyIDCode = ispServiceCompanyIDCode;
	}

	public String getIspCallerCompanyIDCode() {
		return ispCallerCompanyIDCode;
	}

	public void setIspCallerCompanyIDCode(String ispCallerCompanyIDCode) {
		this.ispCallerCompanyIDCode = ispCallerCompanyIDCode;
	}

	public String getCodABI() {
		return codABI;
	}

	public void setCodABI(String codABI) {
		this.codABI = codABI;
	}

	public String getIspBranchCode() {
		return ispBranchCode;
	}

	public void setIspBranchCode(String ispBranchCode) {
		this.ispBranchCode = ispBranchCode;
	}

}
