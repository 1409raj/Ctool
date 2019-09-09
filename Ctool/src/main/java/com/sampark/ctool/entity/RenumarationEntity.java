package com.sampark.ctool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_renumaration")
public class RenumarationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="VARIABLE_TO_BE_DISBURSED")
	private Integer variableToBeDisbursed;
	
	@Column(name="VARIABLE_33")
	private Integer variable33;
	
	@Column(name="VARIABLE_67")
	private Integer VARIABLE_67;
	
	@Column(name="INCREMENT_W_R_T_RATING")
	private Integer incrementwrtRating;
	
	@Column(name="RATIONALISATION_HR_FACTOR")
	private Integer rationalisationHrFactor;
	
	@Column(name="PROMOTION")
	private Integer promotion;
	
	@Column(name="RETENTION_CASE")
	private Integer retentionCase;
	
	@Column(name="INCREMENT_W_E_F_APRIL_YEAR")
	private Integer incrementwefAprilYear;
	
	@Column(name="INCREMENT_AMOUNT")
	private Integer incrementAmount;
	
	@Column(name="NEW_FIXED_SALARY_PER_YEAR")
	private Integer newfixedsalaryperyear;
	
	@Column(name="NEW_FIXED_SALARY_PER_MONTH")
	private Integer newFixedSalaryPermonth;
	
	@Column(name="NEW_VARIABLE")
	private Integer newVariable;
	
	@Column(name="NEW_VARIBALE_PER_YEAR")
	private Integer newVaribalePerYear;
	
	@Column(name="NEW_CTC_YEAR")
	private Integer newCtcYear;
	
	@Column(name="NET_INCREASE_YEARLY")
	private Integer netIncreaseYearly;

    @Column(name="EMP_CODE")
    private String empCode;
    
    @Column(name="CREATED_ON")
    private Date createdOn;
    
    @Column(name="MODIFIED_ON")
    private Date modifiedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVariableToBeDisbursed() {
		return variableToBeDisbursed;
	}

	public void setVariableToBeDisbursed(Integer variableToBeDisbursed) {
		this.variableToBeDisbursed = variableToBeDisbursed;
	}

	public Integer getVariable33() {
		return variable33;
	}

	public void setVariable33(Integer variable33) {
		this.variable33 = variable33;
	}

	public Integer getVARIABLE_67() {
		return VARIABLE_67;
	}

	public void setVARIABLE_67(Integer vARIABLE_67) {
		VARIABLE_67 = vARIABLE_67;
	}

	public Integer getIncrementwrtRating() {
		return incrementwrtRating;
	}

	public void setIncrementwrtRating(Integer incrementwrtRating) {
		this.incrementwrtRating = incrementwrtRating;
	}

	public Integer getRationalisationHrFactor() {
		return rationalisationHrFactor;
	}

	public void setRationalisationHrFactor(Integer rationalisationHrFactor) {
		this.rationalisationHrFactor = rationalisationHrFactor;
	}

	public Integer getPromotion() {
		return promotion;
	}

	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}

	public Integer getRetentionCase() {
		return retentionCase;
	}

	public void setRetentionCase(Integer retentionCase) {
		this.retentionCase = retentionCase;
	}

	public Integer getIncrementwefAprilYear() {
		return incrementwefAprilYear;
	}

	public void setIncrementwefAprilYear(Integer incrementwefAprilYear) {
		this.incrementwefAprilYear = incrementwefAprilYear;
	}

	public Integer getIncrementAmount() {
		return incrementAmount;
	}

	public void setIncrementAmount(Integer incrementAmount) {
		this.incrementAmount = incrementAmount;
	}

	public Integer getNewfixedsalaryperyear() {
		return newfixedsalaryperyear;
	}

	public void setNewfixedsalaryperyear(Integer newfixedsalaryperyear) {
		this.newfixedsalaryperyear = newfixedsalaryperyear;
	}

	public Integer getNewFixedSalaryPermonth() {
		return newFixedSalaryPermonth;
	}

	public void setNewFixedSalaryPermonth(Integer newFixedSalaryPermonth) {
		this.newFixedSalaryPermonth = newFixedSalaryPermonth;
	}

	public Integer getNewVariable() {
		return newVariable;
	}

	public void setNewVariable(Integer newVariable) {
		this.newVariable = newVariable;
	}

	public Integer getNewVaribalePerYear() {
		return newVaribalePerYear;
	}

	public void setNewVaribalePerYear(Integer newVaribalePerYear) {
		this.newVaribalePerYear = newVaribalePerYear;
	}

	public Integer getNewCtcYear() {
		return newCtcYear;
	}

	public void setNewCtcYear(Integer newCtcYear) {
		this.newCtcYear = newCtcYear;
	}

	public Integer getNetIncreaseYearly() {
		return netIncreaseYearly;
	}

	public void setNetIncreaseYearly(Integer netIncreaseYearly) {
		this.netIncreaseYearly = netIncreaseYearly;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
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

	@Override
	public String toString() {
		return "RenumarationEntity [id=" + id + ", variableToBeDisbursed=" + variableToBeDisbursed + ", variable33="
				+ variable33 + ", VARIABLE_67=" + VARIABLE_67 + ", incrementwrtRating=" + incrementwrtRating
				+ ", rationalisationHrFactor=" + rationalisationHrFactor + ", promotion=" + promotion
				+ ", retentionCase=" + retentionCase + ", incrementwefAprilYear=" + incrementwefAprilYear
				+ ", incrementAmount=" + incrementAmount + ", newfixedsalaryperyear=" + newfixedsalaryperyear
				+ ", newFixedSalaryPermonth=" + newFixedSalaryPermonth + ", newVariable=" + newVariable
				+ ", newVaribalePerYear=" + newVaribalePerYear + ", newCtcYear=" + newCtcYear + ", netIncreaseYearly="
				+ netIncreaseYearly + ", empCode=" + empCode + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn
				+ "]";
	}
    
    
    
}
