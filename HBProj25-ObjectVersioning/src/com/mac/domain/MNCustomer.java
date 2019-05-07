package com.mac.domain;

import java.io.Serializable;

public class MNCustomer implements Serializable{

	private static final long serialVersionUID = 1L;

	private int custId;
	private String custName;
	private long mobileNo;
	private String callerTune;
	private  int  tuneChangeCount;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public int getTuneChangeCount() {
		return tuneChangeCount;
	}
	public void setTuneChangeCount(int tuneChangeCount) {
		this.tuneChangeCount = tuneChangeCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
