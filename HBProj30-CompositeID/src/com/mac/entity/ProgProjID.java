package com.mac.entity;

import java.io.Serializable;

public class ProgProjID implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int progId;
	private int projId;
	
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
