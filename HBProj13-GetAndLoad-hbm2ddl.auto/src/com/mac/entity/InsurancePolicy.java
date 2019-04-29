package com.mac.entity;

public class InsurancePolicy {

	private int policyId;
	private String policyName;
	private int tenure;
	private String company;
	private float initialAmt;
	
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getInitialAmt() {
		return initialAmt;
	}
	public void setInitialAmt(float initialAmt) {
		this.initialAmt = initialAmt;
	}
}
