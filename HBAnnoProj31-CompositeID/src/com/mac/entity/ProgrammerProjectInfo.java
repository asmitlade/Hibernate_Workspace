package com.mac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="PROGRAMMER_PROJECT")
public class ProgrammerProjectInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgProjID id;
	@Column(length=10)
	private String progName;
	@Column(length=10)
	private String projName;
	@Column(length=10, precision=2)
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
