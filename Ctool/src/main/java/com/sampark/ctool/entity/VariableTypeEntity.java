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
@Table(name="tbl_variable_type")
public class VariableTypeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="variable_Title")
	private String variableTitle;
	
	@Column(name="variable_Description")
	private String variableDescription;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="created_On")
	@CreationTimestamp
	private Date createdOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVariableTitle() {
		return variableTitle;
	}

	public void setVariableTitle(String variableTitle) {
		this.variableTitle = variableTitle;
	}

	public String getVariableDescription() {
		return variableDescription;
	}

	public void setVariableDescription(String variableDescription) {
		this.variableDescription = variableDescription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "VariableTypeEntity [id=" + id + ", variableTitle=" + variableTitle + ", variableDescription="
				+ variableDescription + ", status=" + status + ", createdOn=" + createdOn + "]";
	}
	
	
	

}