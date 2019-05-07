package com.mac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name="CUSTID")
	private int custNo;
	@Column(name="CUSTNAME")
	private String custName;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="MOBNO")
	private long mobNo;
	
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
}
