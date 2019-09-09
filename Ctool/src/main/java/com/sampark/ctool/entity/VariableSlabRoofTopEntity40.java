package com.sampark.ctool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_variable_salb_RoofTop_40")
public class VariableSlabRoofTopEntity40 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	
	@Column(name="VARIABLE")
	private Integer variable;
	
	@Column(name="CREATED_ON")
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	@CreationTimestamp
	private Date modifiedOn;
	
	@Column(name="created_By")
	private String createdBy;
	
	@Column(name="modified_By")
	private String modifiedBy;
	
	@Column(name="STATUS")
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getVariable() {
		return variable;
	}
	public void setVariable(Integer variable) {
		this.variable = variable;
	}
	@Override
	public String toString() {
		return "VariableSlabNonRoofTopEntity33 [id=" + id + ", variable=" + variable + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", status="
				+ status + "]";
	}
	
	

}
