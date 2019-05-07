package com.mac.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="BANKACC")
public class BankAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ACCNO")
	private int accNo;
	@Column(name="HOLDERNAME")
	private String holderName;
	@Column(name="BALANCE")
	private float balance;
	@Column(name="TYPE")
	private String type;
	@CreationTimestamp
	@Column(name="OPENACCOUNT")
	private Timestamp openAccount;
	@Version
	@Column(name="UPDATECOUNT")
	private int updateCount;
	@UpdateTimestamp
	@Column(name="LASTUPDATE")
	private Timestamp lastUpdate;
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getOpenAccount() {
		return openAccount;
	}
	public void setOpenAccount(Timestamp openAccount) {
		this.openAccount = openAccount;
	}
	public int getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
