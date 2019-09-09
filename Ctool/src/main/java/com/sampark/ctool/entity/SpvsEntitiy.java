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
@Table(name="tbl_spvs")
public class SpvsEntitiy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="CREATED_ON")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="MODIFIED_ON")
	@CreationTimestamp
	private Date modifiedOn;
	
	@Column(name="CREATED_By")
	private String createdBy;
	
	@Column(name="MODIFIED_By")
	private String modifiedBy;
	
	@Column(name="STATUS")
	private Integer status;
	
	@Column(name="DIRECTOR")
	private String director;
	
	

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

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

	@Override
	public String toString() {
		return "SpvsEntitiy [id=" + id + ", companyName=" + companyName + ", createdOn=" + createdOn + ", modifiedOn="
				+ modifiedOn + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", status=" + status
				+ ", director=" + director + "]";
	}

	
}
