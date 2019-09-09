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
@Table(name = "tbl_slab")
public class SlabEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="DESIGANATION")
	private String designation;
	
	@Column(name="BASIC")
	private Integer basic;
	
	@Column(name="HRA")
	private Integer hra;
	
	@Column(name="SUPPLEMENTARY_ALLOWANCE")
	private Integer supplementaryAllowance;
	
	@Column(name="ASSESSMENT_YEAR")
	private String assessmentYear;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getBasic() {
		return basic;
	}
	public void setBasic(Integer basic) {
		this.basic = basic;
	}
	public Integer getHra() {
		return hra;
	}
	public void setHra(Integer hra) {
		this.hra = hra;
	}
	public Integer getSupplementaryAllowance() {
		return supplementaryAllowance;
	}
	public void setSupplementaryAllowance(Integer supplementaryAllowance) {
		this.supplementaryAllowance = supplementaryAllowance;
	}
	public String getAssessmentYear() {
		return assessmentYear;
	}
	public void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
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
		return "SlabEntity [id=" + id + ", designation=" + designation + ", basic=" + basic + ", hra=" + hra
				+ ", supplementaryAllowance=" + supplementaryAllowance + ", assessmentYear=" + assessmentYear
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", status=" + status + "]";
	}
	
	
	
}
