package com.mac.entity;

public interface IInsurancePolicy {

	public int getPolicyId();
	public void setPolicyId(int policyId);
	public String getPolicyName();
	public void setPolicyName(String policyName);
	public int getTenure();
	public void setTenure(int tenure);
	public String getCompany();
	public void setCompany(String company);
	public float getInitialAmt();
	public void setInitialAmt(float initialAmt);
}
