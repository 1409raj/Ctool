package com.sampark.ctool.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_config")
public class ConfigurationEntity {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="location")
	private String location;
	
	@Column(name="ASSESSMENT_YEAR")
	private String assessmentyear;
	
	@Column(name="DEPARTMENT")
	private String department;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="DATE_OF_JOINING")
	private Date doj;
	
	@Column(name="KRA")
	private Integer kra;
	
	@Column(name="EXTRA_ORDINARY_INITIATIVE")
	private Integer extraOrdinaryInitiative; 

    @Column(name="BEHAVIOURAL_COMPETENCE")
	private Integer behaviorCompetence;
    
    @Column(name="VARIABLE_CURRENT_YEAR")
    private Integer variableCurrentyear;
    
    @Column(name="VARIABLE_33")
    private Integer variable33;
    
    @Column(name="VARIABLE_67")
    private Integer variable67;
    
    @Column(name="INCREMENT_WRT_RATING")
    private Integer incrementWRTrating;
    
    @Column(name="RATIONALIZATION_HR_FACTOR")
    private Integer rationalizationHrFactor;
    
    @Column(name="PROMOTION_PERCENTAGE")
    private Integer Promotionpercentage;
    
    @Column(name="RETENTION_CASE")
    private Integer retentioncase;
    
    @Column(name="NEW_VARIABLE")
    private Integer newvariable;
    
    @Column(name="SPECIAL_BONUS_AMOUNT")
    private Integer specialBonusamount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAssessmentyear() {
		return assessmentyear;
	}

	public void setAssessmentyear(String assessmentyear) {
		this.assessmentyear = assessmentyear;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Integer getKra() {
		return kra;
	}

	public void setKra(Integer kra) {
		this.kra = kra;
	}

	public Integer getExtraOrdinaryInitiative() {
		return extraOrdinaryInitiative;
	}

	public void setExtraOrdinaryInitiative(Integer extraOrdinaryInitiative) {
		this.extraOrdinaryInitiative = extraOrdinaryInitiative;
	}

	public Integer getBehaviorCompetence() {
		return behaviorCompetence;
	}

	public void setBehaviorCompetence(Integer behaviorCompetence) {
		this.behaviorCompetence = behaviorCompetence;
	}

	public Integer getVariableCurrentyear() {
		return variableCurrentyear;
	}

	public void setVariableCurrentyear(Integer variableCurrentyear) {
		this.variableCurrentyear = variableCurrentyear;
	}

	public Integer getVariable33() {
		return variable33;
	}

	public void setVariable33(Integer variable33) {
		this.variable33 = variable33;
	}

	public Integer getVariable67() {
		return variable67;
	}

	public void setVariable67(Integer variable67) {
		this.variable67 = variable67;
	}

	public Integer getIncrementWRTrating() {
		return incrementWRTrating;
	}

	public void setIncrementWRTrating(Integer incrementWRTrating) {
		this.incrementWRTrating = incrementWRTrating;
	}

	public Integer getRationalizationHrFactor() {
		return rationalizationHrFactor;
	}

	public void setRationalizationHrFactor(Integer rationalizationHrFactor) {
		this.rationalizationHrFactor = rationalizationHrFactor;
	}

	public Integer getPromotionpercentage() {
		return Promotionpercentage;
	}

	public void setPromotionpercentage(Integer promotionpercentage) {
		Promotionpercentage = promotionpercentage;
	}

	public Integer getRetentioncase() {
		return retentioncase;
	}

	public void setRetentioncase(Integer retentioncase) {
		this.retentioncase = retentioncase;
	}

	public Integer getNewvariable() {
		return newvariable;
	}

	public void setNewvariable(Integer newvariable) {
		this.newvariable = newvariable;
	}

	public Integer getSpecialBonusamount() {
		return specialBonusamount;
	}

	public void setSpecialBonusamount(Integer specialBonusamount) {
		this.specialBonusamount = specialBonusamount;
	}

	@Override
	public String toString() {
		return "ConfigurationEntity [id=" + id + ", location=" + location + ", assessmentyear=" + assessmentyear
				+ ", department=" + department + ", designation=" + designation + ", doj=" + doj + ", kra=" + kra
				+ ", extraOrdinaryInitiative=" + extraOrdinaryInitiative + ", behaviorCompetence=" + behaviorCompetence
				+ ", variableCurrentyear=" + variableCurrentyear + ", variable33=" + variable33 + ", variable67="
				+ variable67 + ", incrementWRTrating=" + incrementWRTrating + ", rationalizationHrFactor="
				+ rationalizationHrFactor + ", Promotionpercentage=" + Promotionpercentage + ", retentioncase="
				+ retentioncase + ", newvariable=" + newvariable + ", specialBonusamount=" + specialBonusamount + "]";
	}

	
		
}
