package com.sampark.ctool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_word_documents")
public class WordDocument {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="NAME")
	private String name;

	@Transient
	private String fileName;

	@Column(name="CREATED_ON")
	private Date createdOn;
	@Column(name="STATUS")
	private Integer status;
	@Column(name="EMP_CODE")
	private String empCode;
	@Column(name="EMP_NAME")
	private String empName;


	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "WordDocument [id=" + id + ", name=" + name + ", fileName=" + fileName + ", createdOn=" + createdOn
				+ ", status=" + status + ", empCode=" + empCode + ", empName=" + empName + "]";
	}

}
