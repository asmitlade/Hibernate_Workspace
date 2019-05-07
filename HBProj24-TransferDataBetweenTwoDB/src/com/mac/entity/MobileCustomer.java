package com.mac.entity;

public class MobileCustomer {

	private long mobNo;
	private String custName;
	private String idProofDoc;
	private String status;
	
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getIdProofDoc() {
		return idProofDoc;
	}
	public void setIdProofDoc(String idProofDoc) {
		this.idProofDoc = idProofDoc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
