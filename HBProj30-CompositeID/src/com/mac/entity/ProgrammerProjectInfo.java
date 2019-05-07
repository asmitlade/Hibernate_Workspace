package com.mac.entity;

import java.io.Serializable;

public class ProgrammerProjectInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ProgProjID id;
	private String progName;
	private String projName;
	private float salary;
	
	public ProgProjID getId() {
		return id;
	}
	public void setId(ProgProjID id) {
		this.id = id;
	}
	public String getProgName() {
		return progName;
	}
	public void setProgName(String progName) {
		this.progName = progName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}
