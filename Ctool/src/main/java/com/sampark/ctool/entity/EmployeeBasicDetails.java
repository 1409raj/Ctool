package com.sampark.ctool.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_basic_details")
public class EmployeeBasicDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="EMP_CODE")
	private String empCode;
	@Column(name="EMP_NAME")
	private String empName;
	@Column(name="LOCATION")
	private String location;
	@Column(name="MOBILE")
	private String mobile;
	@Column(name="EMAIL")
	private String email;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="DEPARTMENT")
	private String department;
	@Column(name="DATE_OF_JOINING")
	private Date dateOfJoining;
	@Column(name="ASSESSMENT_YEAR")
	private String assessmentYear;
	@Column(name="KRA")
	private String kra;
	@Column(name="KRA_RATING")
	private String kraRating;
	@Column(name="BEHAVIOURAL_COMPETENCE_RATING")
	private String behaviouralCompetenceRating;
	@Column(name="BEHAVIOURAL_COMPETENCE")
	private String behaviouralCompetence;
	@Column(name="EXTRA_ORDINARY_INITIATIVE")
	private String extraOrdinaryInitiative;
	@Column(name="EXTRA_ORDINARY_INITIATIVE_RATING")
	private String extraOrdinaryInitiativeRating;
	@Column(name="FINAL_YEAR_RATING")
	private String finalYearRating;
	@Column(name="TOTAL_TENURE")
	private String totalTenure;
	@Column(name="FIXED_SALARY_PER_YEAR")
	private String fixedSalaryPerYear;
	@Column(name="FIXED_SALARY_PER_MONTH")
	private String fixedSalaryPerMonth;
	@Column(name="VARIABLE")
	private String variable;
	@Column(name="VARIABLE_AMOUNT_CURRENT_YEAR")
	private String variableAmountCurrentYear;
	@Column(name="CURRENT_CTC_PER_YEAR")
	private String currentCTCPerYear;
	@Column(name="CURRENT_CTC_PER_MONTH")
	private String currentCTCPerMonth;
	@Column(name="MONTHS_CURRENT_DATE_DOJ")
	private String monthCurrentDateDOJ;
	@Column(name="DISBURSED_VARIABLE")
	private String disbursedVariable;
	@Column(name="VARIABLE_33")
	private String variable33;
	@Column(name="VARIABLE_67")
	private String variable67;
	@Column(name="DISBURSED_VARIABLE_Z")
	private String disbursedVariableZ;
	@Column(name="INCREMENT_WRT_RATING")
	private String incrementWRTRating;
	@Column(name="RATIONALIZATION_HR_FACTOR")
	private String rationalizationHRFactor;
	@Column(name="PROMOTION")
	private String promotion;
	@Column(name="RETENTION")
	private String retention;
	@Column(name="INCREMENT_WEF_APRIL")
	private String incrementWEFApril;
	@Column(name="INCREMENT_AMOUNT")
	private String incrementAmount;
	@Column(name="NEW_FIXED_SALARY_PER_YEAR")
	private String newFixedSalaryPerYear;
	@Column(name="NEW_FIXED_SALARY_PER_MONTH")
	private String newFixedSalaryPerMonth;
	@Column(name="NEW_VARIABLE")
	private String newVariable;
	@Column(name="NEW_VARIABLE_PER_YEAR")
	private String newVariablePerYear;
	@Column(name="NEW_CTC_YEAR")
	private String newCTCYear;
	@Column(name="NET_INCREASE_YEARLY")
	private String netIncreaseYearly;
	@Column(name="New_PROMOTION")
	private String newPromotion;
	@Column(name="NEW_DESIGNATION")
	private String newDesignation;
	@Column(name="SPECIAL_BONUS")
	private String specialBonus;
	@Column(name="BASIC_SALARY")
	private String basicSalary;
	@Column(name="HR")
	private String hr;
	@Column(name="TRANSPORT_ALLOWANCE")
	private String transportAllowance;
	@Column(name="SPECIAL_ALLOWANCE")
	private String specialAllowance;
	@Column(name="SUPPLEMENTARY_ALLOWANCE")
	private String supplementaryAllowance;
	@Column(name="CHILDREN_EDUCATION_ALLOWANCE")
	private String childrenEducationAllowance;
	@Column(name="PF")
	private String pf;
	@Column(name="MEDICAL")
	private String medical;
	@Column(name="RESIDENT_TELEPHONE")
	private String residentTelephone;
	@Column(name="ATTIRE")
	private String attire;
	@Column(name="NEWSPAPER")
	private String newspaper;
	@Column(name="CAR_LEASE")
	private String carLease;
	@Column(name="DRIVER")
	private String driver;
	@Column(name="PETROL")
	private String petrol;
	@Column(name="LTA")
	private String lta;
	@Column(name="GRATUITY")
	private String gratuity;
	@Column(name="VARIABLE_PAY")
	private String variablePay;
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
	@Column(name="DOC_STATUS")
	private Integer docStatus;
	@Column(name="SPVS_ID")
	private Integer spvsId;
	@Column(name="INCREMENT_LETTER_DETAILS_ID")
	private Integer incrementLetterDetailsId;
	@Column(name="variableType_Id")
	private Integer variableTypeId;
	@Column(name="DOCUMENT_NO")
	private String documentNo;
	
	@Column(name="NO_OF_MONTHS")
	private Integer totalmnth;
	
	@Column(name="CAR_LEASE_AMOUNT")
	private Integer carLeaseAmount;
	
	
	
	
	public Integer getCarLeaseAmount() {
		return carLeaseAmount;
	}
	public void setCarLeaseAmount(Integer carLeaseAmount) {
		this.carLeaseAmount = carLeaseAmount;
	}
	public Integer getTotalmnth() {
		return totalmnth;
	}
	public void setTotalmnth(Integer totalmnth) {
		this.totalmnth = totalmnth;
	}
	public String getDocumentNo() {
		return documentNo;
	}
	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}
	public Integer getVariableTypeId() {
		return variableTypeId;
	}
	public void setVariableTypeId(Integer variableTypeId) {
		this.variableTypeId = variableTypeId;
	}
	public Integer getIncrementLetterDetailsId() {
		return incrementLetterDetailsId;
	}
	public void setIncrementLetterDetailsId(Integer incrementLetterDetailsId) {
		this.incrementLetterDetailsId = incrementLetterDetailsId;
	}
	public Integer getSpvsId() {
		return spvsId;
	}
	public void setSpvsId(Integer spvsId) {
		this.spvsId = spvsId;
	}
	public Integer getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(Integer docStatus) {
		this.docStatus = docStatus;
	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getAssessmentYear() {
		return assessmentYear;
	}
	public void setAssessmentYear(String assessmentYear) {
		this.assessmentYear = assessmentYear;
	}
	public String getKra() {
		return kra;
	}
	public void setKra(String kra) {
		this.kra = kra;
	}
	public String getKraRating() {
		return kraRating;
	}
	public void setKraRating(String kraRating) {
		this.kraRating = kraRating;
	}
	public String getBehaviouralCompetenceRating() {
		return behaviouralCompetenceRating;
	}
	public void setBehaviouralCompetenceRating(String behaviouralCompetenceRating) {
		this.behaviouralCompetenceRating = behaviouralCompetenceRating;
	}
	public String getBehaviouralCompetence() {
		return behaviouralCompetence;
	}
	public void setBehaviouralCompetence(String behaviouralCompetence) {
		this.behaviouralCompetence = behaviouralCompetence;
	}
	public String getExtraOrdinaryInitiative() {
		return extraOrdinaryInitiative;
	}
	public void setExtraOrdinaryInitiative(String extraOrdinaryInitiative) {
		this.extraOrdinaryInitiative = extraOrdinaryInitiative;
	}
	public String getExtraOrdinaryInitiativeRating() {
		return extraOrdinaryInitiativeRating;
	}
	public void setExtraOrdinaryInitiativeRating(String extraOrdinaryInitiativeRating) {
		this.extraOrdinaryInitiativeRating = extraOrdinaryInitiativeRating;
	}
	public String getFinalYearRating() {
		return finalYearRating;
	}
	public void setFinalYearRating(String finalYearRating) {
		this.finalYearRating = finalYearRating;
	}
	public String getTotalTenure() {
		return totalTenure;
	}
	public void setTotalTenure(String totalTenure) {
		this.totalTenure = totalTenure;
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
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public String getVariableAmountCurrentYear() {
		return variableAmountCurrentYear;
	}
	public void setVariableAmountCurrentYear(String variableAmountCurrentYear) {
		this.variableAmountCurrentYear = variableAmountCurrentYear;
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
	public String getMonthCurrentDateDOJ() {
		return monthCurrentDateDOJ;
	}
	public void setMonthCurrentDateDOJ(String monthCurrentDateDOJ) {
		this.monthCurrentDateDOJ = monthCurrentDateDOJ;
	}
	public String getDisbursedVariable() {
		return disbursedVariable;
	}
	public void setDisbursedVariable(String disbursedVariable) {
		this.disbursedVariable = disbursedVariable;
	}
	public String getVariable33() {
		return variable33;
	}
	public void setVariable33(String variable33) {
		this.variable33 = variable33;
	}
	public String getVariable67() {
		return variable67;
	}
	public void setVariable67(String variable67) {
		this.variable67 = variable67;
	}
	public String getDisbursedVariableZ() {
		return disbursedVariableZ;
	}
	public void setDisbursedVariableZ(String disbursedVariableZ) {
		this.disbursedVariableZ = disbursedVariableZ;
	}
	public String getIncrementWRTRating() {
		return incrementWRTRating;
	}
	public void setIncrementWRTRating(String incrementWRTRating) {
		this.incrementWRTRating = incrementWRTRating;
	}
	public String getRationalizationHRFactor() {
		return rationalizationHRFactor;
	}
	public void setRationalizationHRFactor(String rationalizationHRFactor) {
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
	public String getNewFixedSalaryPerYear() {
		return newFixedSalaryPerYear;
	}
	public void setNewFixedSalaryPerYear(String newFixedSalaryPerYear) {
		this.newFixedSalaryPerYear = newFixedSalaryPerYear;
	}
	public String getNewFixedSalaryPerMonth() {
		return newFixedSalaryPerMonth;
	}
	public void setNewFixedSalaryPerMonth(String newFixedSalaryPerMonth) {
		this.newFixedSalaryPerMonth = newFixedSalaryPerMonth;
	}
	public String getNewVariable() {
		return newVariable;
	}
	public void setNewVariable(String newVariable) {
		this.newVariable = newVariable;
	}
	public String getNewVariablePerYear() {
		return newVariablePerYear;
	}
	public void setNewVariablePerYear(String newVariablePerYear) {
		this.newVariablePerYear = newVariablePerYear;
	}
	public String getNewCTCYear() {
		return newCTCYear;
	}
	public void setNewCTCYear(String newCTCYear) {
		this.newCTCYear = newCTCYear;
	}
	public String getNetIncreaseYearly() {
		return netIncreaseYearly;
	}
	public void setNetIncreaseYearly(String netIncreaseYearly) {
		this.netIncreaseYearly = netIncreaseYearly;
	}
	public String getNewPromotion() {
		return newPromotion;
	}
	public void setNewPromotion(String newPromotion) {
		this.newPromotion = newPromotion;
	}
	public String getNewDesignation() {
		return newDesignation;
	}
	public void setNewDesignation(String newDesignation) {
		this.newDesignation = newDesignation;
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
	public String getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public String getTransportAllowance() {
		return transportAllowance;
	}
	public void setTransportAllowance(String transportAllowance) {
		this.transportAllowance = transportAllowance;
	}
	public String getSpecialAllowance() {
		return specialAllowance;
	}
	public void setSpecialAllowance(String specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	
	public String getSupplementaryAllowance() {
		return supplementaryAllowance;
	}
	public void setSupplementaryAllowance(String supplementaryAllowance) {
		this.supplementaryAllowance = supplementaryAllowance;
	}
	public String getChildrenEducationAllowance() {
		return childrenEducationAllowance;
	}
	public void setChildrenEducationAllowance(String childrenEducationAllowance) {
		this.childrenEducationAllowance = childrenEducationAllowance;
	}
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}
	public String getMedical() {
		return medical;
	}
	public void setMedical(String medical) {
		this.medical = medical;
	}
	public String getResidentTelephone() {
		return residentTelephone;
	}
	public void setResidentTelephone(String residentTelephone) {
		this.residentTelephone = residentTelephone;
	}
	public String getAttire() {
		return attire;
	}
	public void setAttire(String attire) {
		this.attire = attire;
	}
	public String getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	public String getCarLease() {
		return carLease;
	}
	public void setCarLease(String carLease) {
		this.carLease = carLease;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPetrol() {
		return petrol;
	}
	public void setPetrol(String petrol) {
		this.petrol = petrol;
	}
	public String getLta() {
		return lta;
	}
	public void setLta(String lta) {
		this.lta = lta;
	}
	public String getGratuity() {
		return gratuity;
	}
	public void setGratuity(String gratuity) {
		this.gratuity = gratuity;
	}
	public String getVariablePay() {
		return variablePay;
	}
	public void setVariablePay(String variablePay) {
		this.variablePay = variablePay;
	}
	@Override
	public String toString() {
		return "EmployeeBasicDetails [id=" + id + ", empCode=" + empCode + ", empName=" + empName + ", location="
				+ location + ", mobile=" + mobile + ", email=" + email + ", designation=" + designation
				+ ", department=" + department + ", dateOfJoining=" + dateOfJoining + ", assessmentYear="
				+ assessmentYear + ", kra=" + kra + ", kraRating=" + kraRating + ", behaviouralCompetenceRating="
				+ behaviouralCompetenceRating + ", behaviouralCompetence=" + behaviouralCompetence
				+ ", extraOrdinaryInitiative=" + extraOrdinaryInitiative + ", extraOrdinaryInitiativeRating="
				+ extraOrdinaryInitiativeRating + ", finalYearRating=" + finalYearRating + ", totalTenure="
				+ totalTenure + ", fixedSalaryPerYear=" + fixedSalaryPerYear + ", fixedSalaryPerMonth="
				+ fixedSalaryPerMonth + ", variable=" + variable + ", variableAmountCurrentYear="
				+ variableAmountCurrentYear + ", currentCTCPerYear=" + currentCTCPerYear + ", currentCTCPerMonth="
				+ currentCTCPerMonth + ", monthCurrentDateDOJ=" + monthCurrentDateDOJ + ", disbursedVariable="
				+ disbursedVariable + ", variable33=" + variable33 + ", variable67=" + variable67
				+ ", disbursedVariableZ=" + disbursedVariableZ + ", incrementWRTRating=" + incrementWRTRating
				+ ", rationalizationHRFactor=" + rationalizationHRFactor + ", promotion=" + promotion + ", retention="
				+ retention + ", incrementWEFApril=" + incrementWEFApril + ", incrementAmount=" + incrementAmount
				+ ", newFixedSalaryPerYear=" + newFixedSalaryPerYear + ", newFixedSalaryPerMonth="
				+ newFixedSalaryPerMonth + ", newVariable=" + newVariable + ", newVariablePerYear=" + newVariablePerYear
				+ ", newCTCYear=" + newCTCYear + ", netIncreaseYearly=" + netIncreaseYearly + ", newPromotion="
				+ newPromotion + ", newDesignation=" + newDesignation + ", specialBonus=" + specialBonus
				+ ", basicSalary=" + basicSalary + ", hr=" + hr + ", transportAllowance=" + transportAllowance
				+ ", specialAllowance=" + specialAllowance + ", supplementaryAllowance=" + supplementaryAllowance
				+ ", childrenEducationAllowance=" + childrenEducationAllowance + ", pf=" + pf + ", medical=" + medical
				+ ", residentTelephone=" + residentTelephone + ", attire=" + attire + ", newspaper=" + newspaper
				+ ", carLease=" + carLease + ", driver=" + driver + ", petrol=" + petrol + ", lta=" + lta
				+ ", gratuity=" + gratuity + ", variablePay=" + variablePay + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", status="
				+ status + ", docStatus=" + docStatus + ", spvsId=" + spvsId + ", incrementLetterDetailsId="
				+ incrementLetterDetailsId + ", variableTypeId=" + variableTypeId + ", documentNo=" + documentNo
				+ ", totalmnth=" + totalmnth + "]";
	}
	
	
	
}