package com.mac.entity;

import java.io.Serializable;


public class BrandFactory implements Serializable {
	private static final long serialVersionUID = 1L;
	private long custMobileNo;
	private  String custName;
	private  String custAddrs; 
	private  int rewardPoints;
	
	public long getCustMobileNo() {
		return custMobileNo;
	}
	public void setCustMobileNo(long custMobileNo) {
		this.custMobileNo = custMobileNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddrs() {
		return custAddrs;
	}
	public void setCustAddrs(String custAddrs) {
		this.custAddrs = custAddrs;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BrandFactory [custMobileNo=" + custMobileNo + ", custName=" + custName + ", custAddrs=" + custAddrs
				+ ", rewardPoints=" + rewardPoints + "]";
	}
	
}
