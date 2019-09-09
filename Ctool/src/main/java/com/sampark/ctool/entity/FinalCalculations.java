package com.sampark.ctool.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_final_calculation")
public class FinalCalculations {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;	
	@Column(name="EMP_CODE")
	private String empCode;
	@Column(name="EMP_NAME")
	private String empName;
	@Column(name="DATE_OF_JOINING")
	private Date dateOfJoining;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="ASSESSMENT_YEAR")
	private String assessmentYear;
	@Column(name="KRA_RATING")
	private String kraRating;
	@Column(name="PROMOTION_INDICATOR")
	private Integer promotionIndicator;
	@Column(name="TENURE_MONTH")
	private String tenureMonth;
	@Column(name="EXTRA_ORDINARY_INITIATIVE")
	private String extraOrdinaryInitiative;
	@Column(name="BEHAVIOURAL_COMPETENCE_RATING")
	private String behaviouralCompetenceRating;
	@Column(name="NEW_DESIGNATION")
	private String newDesignation;
	@Column(name="FINAL_YEAR_RATING")
	private String finalYearRating;
	@Column(name="CURRENT_FIX_SALARY_PER_YEAR")
	private String currentFixedSalaryPerYear;
	@Column(name="FIX_SALARY_PER_YEAR")
	private String fixedSalaryPerYear;
	@Column(name="FIX_SALARY_PER_MONTH")
	private String fixedSalaryPerMonth;
	@Column(name="CURRENT_VARIABLE")
	private Integer currentVariable;
	@Column(name="CURRENT_VARIABLE_AMOUNT_CURRENT_YEAR")
	private Integer currentVariableAmountCurrentYear;
	@Column(name="CURRENT_CTC_PER_YEAR")
	private String currentCTCPerYear;
	@Column(name="CURRENT_CTC_PER_MONTH")
	private String currentCTCPerMonth;
	@Column(name="DISBURSED_VARIABLE")
	private Integer disbursedVariable;
	@Column(name="VARIABLE_X")
	private Integer variableX;
	@Column(name="VARIABLE_Y")
	private Integer variableY;
	@Column(name="INCREMENT_WRT_RATING")
	private String incrementWRTRating;
	@Column(name="RATIONALIZATION_HR_FACTOR")
	private Integer rationalizationHRFactor;
	@Column(name="PROMOTION")
	private String promotion;
	@Column(name="RETENTION")
	private String retention;
	@Column(name="VARIABLE_X_33_PER")
	private Integer variableX33Per;
	@Column(name="VARIABLE_X_67_PER")
	private Integer variableX67Per;
	@Column(name="DISBURSED_VARIABLE_D")
	private String disbursedVariableD;
	@Column(name="INCREMENT_WEF_APRIL")
	private String incrementWEFApril;
	@Column(name="INCREMENT_AMOUNT")
	private String incrementAmount;
	@Column(name="NEW_FIX_SALARY_PER_YEAR")
	private String newFixSalaryPerYear;
	@Column(name="NEW_FIX_SALARY_PER_MONTH")
	private String newFixSalaryPerMonth;
	@Column(name="NEW_VARIABLE")
	private Integer newVariable;
	@Column(name="NEW_CTC")
	private String newCTC;
	@Column(name="NET_INCREASE_YEARLY")
	private String netIncreaseYearly;
	@Column(name="SPECIAL_BONUS")
	private String specialBonus;
	@Column(name="CREATED_ON")
	private Date createdOn;
	@Column(name="MODIFIED_ON")
	private Date modifiedOn;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	@Column(name="STATUS")
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAssessmentYear() {
		return assessmentYear;
	}
	public void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
	}
	public String getKraRating() {
		return kraRating;
	}
	public void setKraRating(String kraRating) {
		this.kraRating = kraRating;
	}
	public Integer getPromotionIndicator() {
		return promotionIndicator;
	}
	public void setPromotionIndicator(Integer promotionIndicator) {
		this.promotionIndicator = promotionIndicator;
	}
	public String getTenureMonth() {
		return tenureMonth;
	}
	public void setTenureMonth(String tenureMonth) {
		this.tenureMonth = tenureMonth;
	}
	public String getExtraOrdinaryInitiative() {
		return extraOrdinaryInitiative;
	}
	public void setExtraOrdinaryInitiative(String extraOrdinaryInitiative) {
		this.extraOrdinaryInitiative = extraOrdinaryInitiative;
	}
	public String getBehaviouralCompetenceRating() {
		return behaviouralCompetenceRating;
	}
	public void setBehaviouralCompetenceRating(String behaviouralCompetenceRating) {
		this.behaviouralCompetenceRating = behaviouralCompetenceRating;
	}
	public String getNewDesignation() {
		return newDesignation;
	}
	public void setNewDesignation(String newDesignation) {
		this.newDesignation = newDesignation;
	}
	public String getFinalYearRating() {
		return finalYearRating;
	}
	public void setFinalYearRating(String finalYearRating) {
		this.finalYearRating = finalYearRating;
	}
	public String getCurrentFixedSalaryPerYear() {
		return currentFixedSalaryPerYear;
	}
	public void setCurrentFixedSalaryPerYear(String currentFixedSalaryPerYear) {
		this.currentFixedSalaryPerYear = currentFixedSalaryPerYear;
	}
	public String getFixedSalaryPerYear() {
		return fixedSalaryPerYear;
	}
	public void setFixedSalaryPerYear(String fixedSalaryPerYear) {
		this.fixedSalaryPerYear = fixedSalaryPerYear;
	}
	public String getFixedSalaryPerMonth() {
		return fixedSalaryPerMonth;
	}
	public void setFixedSalaryPerMonth(String fixedSalaryPerMonth) {
		this.fixedSalaryPerMonth = fixedSalaryPerMonth;
	}
	public Integer getCurrentVariable() {
		return currentVariable;
	}
	public void setCurrentVariable(Integer currentVariable) {
		this.currentVariable = currentVariable;
	}
	public Integer getCurrentVariableAmountCurrentYear() {
		return currentVariableAmountCurrentYear;
	}
	public void setCurrentVariableAmountCurrentYear(Integer currentVariableAmountCurrentYear) {
		this.currentVariableAmountCurrentYear = currentVariableAmountCurrentYear;
	}
	public String getCurrentCTCPerYear() {
		return currentCTCPerYear;
	}
	public void setCurrentCTCPerYear(String currentCTCPerYear) {
		this.currentCTCPerYear = currentCTCPerYear;
	}
	public String getCurrentCTCPerMonth() {
		return currentCTCPerMonth;
	}
	public void setCurrentCTCPerMonth(String currentCTCPerMonth) {
		this.currentCTCPerMonth = currentCTCPerMonth;
	}
	public Integer getDisbursedVariable() {
		return disbursedVariable;
	}
	public void setDisbursedVariable(Integer disbursedVariable) {
		this.disbursedVariable = disbursedVariable;
	}
	public Integer getVariableX() {
		return variableX;
	}
	public void setVariableX(Integer variableX) {
		this.variableX = variableX;
	}
	public Integer getVariableY() {
		return variableY;
	}
	public void setVariableY(Integer variableY) {
		this.variableY = variableY;
	}
	public String getIncrementWRTRating() {
		return incrementWRTRating;
	}
	public void setIncrementWRTRating(String incrementWRTRating) {
		this.incrementWRTRating = incrementWRTRating;
	}
	public Integer getRationalizationHRFactor() {
		return rationalizationHRFactor;
	}
	public void setRationalizationHRFactor(Integer rationalizationHRFactor) {
		this.rationalizationHRFactor = rationalizationHRFactor;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getRetention() {
		return retention;
	}
	public void setRetention(String retention) {
		this.retention = retention;
	}
	public Integer getVariableX33Per() {
		return variableX33Per;
	}
	public void setVariableX33Per(Integer variableX33Per) {
		this.variableX33Per = variableX33Per;
	}
	public Integer getVariableX67Per() {
		return variableX67Per;
	}
	public void setVariableX67Per(Integer variableX67Per) {
		this.variableX67Per = variableX67Per;
	}
	public String getDisbursedVariableD() {
		return disbursedVariableD;
	}
	public void setDisbursedVariableD(String disbursedVariableD) {
		this.disbursedVariableD = disbursedVariableD;
	}
	public String getIncrementWEFApril() {
		return incrementWEFApril;
	}
	public void setIncrementWEFApril(String incrementWEFApril) {
		this.incrementWEFApril = incrementWEFApril;
	}
	public String getIncrementAmount() {
		return incrementAmount;
	}
	public void setIncrementAmount(String incrementAmount) {
		this.incrementAmount = incrementAmount;
	}
	public String getNewFixSalaryPerYear() {
		return newFixSalaryPerYear;
	}
	public void setNewFixSalaryPerYear(String newFixSalaryPerYear) {
		this.newFixSalaryPerYear = newFixSalaryPerYear;
	}
	public String getNewFixSalaryPerMonth() {
		return newFixSalaryPerMonth;
	}
	public void setNewFixSalaryPerMonth(String newFixSalaryPerMonth) {
		this.newFixSalaryPerMonth = newFixSalaryPerMonth;
	}
	public Integer getNewVariable() {
		return newVariable;
	}
	public void setNewVariable(Integer newVariable) {
		this.newVariable = newVariable;
	}
	public String getNewCTC() {
		return newCTC;
	}
	public void setNewCTC(String newCTC) {
		this.newCTC = newCTC;
	}
	public String getNetIncreaseYearly() {
		return netIncreaseYearly;
	}
	public void setNetIncreaseYearly(String netIncreaseYearly) {
		this.netIncreaseYearly = netIncreaseYearly;
	}
	public String getSpecialBonus() {
		return specialBonus;
	}
	public void setSpecialBonus(String specialBonus) {
		this.specialBonus = specialBonus;
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
		return "FinalCalculations [id=" + id + ", empCode=" + empCode + ", empName=" + empName + ", dateOfJoining="
				+ dateOfJoining + ", department=" + department + ", designation=" + designation + ", assessmentYear="
				+ assessmentYear + ", kraRating=" + kraRating + ", promotionIndicator=" + promotionIndicator
				+ ", tenureMonth=" + tenureMonth + ", extraOrdinaryInitiative=" + extraOrdinaryInitiative
				+ ", behaviouralCompetenceRating=" + behaviouralCompetenceRating + ", newDesignation=" + newDesignation
				+ ", finalYearRating=" + finalYearRating + ", currentFixedSalaryPerYear=" + currentFixedSalaryPerYear
				+ ", fixedSalaryPerYear=" + fixedSalaryPerYear + ", fixedSalaryPerMonth=" + fixedSalaryPerMonth
				+ ", currentVariable=" + currentVariable + ", currentVariableAmountCurrentYear="
				+ currentVariableAmountCurrentYear + ", currentCTCPerYear=" + currentCTCPerYear
				+ ", currentCTCPerMonth=" + currentCTCPerMonth + ", disbursedVariable=" + disbursedVariable
				+ ", variableX=" + variableX + ", variableY=" + variableY + ", incrementWRTRating=" + incrementWRTRating
				+ ", rationalizationHRFactor=" + rationalizationHRFactor + ", promotion=" + promotion + ", retention="
				+ retention + ", variableX33Per=" + variableX33Per + ", variableX67Per=" + variableX67Per
				+ ", disbursedVariableD=" + disbursedVariableD + ", incrementWEFApril=" + incrementWEFApril
				+ ", incrementAmount=" + incrementAmount + ", newFixSalaryPerYear=" + newFixSalaryPerYear
				+ ", newFixSalaryPerMonth=" + newFixSalaryPerMonth + ", newVariable=" + newVariable + ", newCTC="
				+ newCTC + ", netIncreaseYearly=" + netIncreaseYearly + ", specialBonus=" + specialBonus
				+ ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", status=" + status + "]";
	}
	
	
	}
