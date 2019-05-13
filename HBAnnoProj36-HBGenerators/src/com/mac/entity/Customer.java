package com.mac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	@Id
	@Column(name="CUSTID")
	/* @GeneratedValue(strategy = GenerationType.IDENTITY) */
	
	 /*@GenericGenerator(name="seq1", strategy = "sequence",
	 parameters=@Parameter(name="sequence_name",value="custId_seq1"))
	 @GeneratedValue(generator = "seq1")*/
	 
	/*@TableGenerator(name="gen1", table = "custId", pkColumnName = "pk_col", valueColumnName = "val_col", pkColumnValue = "custId", initialValue = 100, allocationSize = 5)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.TABLE)*/
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	
	@Column(name="CUSTNAME")
	private String custName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="MOBNO")
	private long mobNo;
	
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
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", mobNo=" + mobNo
				+ "]";
	}
	
}
