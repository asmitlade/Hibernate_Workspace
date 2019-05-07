package com.mac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgProjID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(length=10)
	private int progId;
	@Column(length=10)
	private int projId;
	
	public ProgProjID() {
		System.out.println("ProgProjID : 0-param constructor");
	}
	public int getProgId() {
		return progId;
	}
	public void setProgId(int progId) {
		this.progId = progId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
}
