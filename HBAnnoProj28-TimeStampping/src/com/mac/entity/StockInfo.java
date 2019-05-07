package com.mac.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class StockInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int stockId;
	private String stockName;
	private  String company;
	private  float price;
	@UpdateTimestamp
	private  Timestamp lastUpdated;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
