package com.sampark.ctool.common;

public class EnumarationFromula {
	
	Integer result=null;
	
	public Integer currentCtcYear(Integer currentfixedSalaryPerYear,Integer variable)
	{
		return result= (int) (currentfixedSalaryPerYear + (currentfixedSalaryPerYear*0.10));
				
	}
	
	public Integer currentCtcMonth(Integer currentCtcYear)
	{
		return result=currentCtcYear/12;
	}
	
	public Integer variable33(Integer variableTobedisbursed)
	{
		return result=(variableTobedisbursed*33)/100;
	}
	
	public Integer incrementAmount(Integer currentFixedSalaryperYear,Integer incrementwefAprilYear)
	{
		return result=currentFixedSalaryperYear*incrementwefAprilYear;
	}
	
	public Integer newFixedSalaryPerYear(Integer currentFixedSalaryPerYear,Integer IncrementAmount) {
		
		return result=currentFixedSalaryPerYear*IncrementAmount;
		
	}
	
	public Integer newFixedSalaryPerMonth(Integer newFixedSalaryPeryear)
	{
		return result=newFixedSalaryPeryear/12;
	}
	
	public  Integer newVariablePerYear(Integer newFixedSalary)
	{
		return result=(newFixedSalary*10)/100;
	}
	public Integer newCtcYear(Integer newFixedSalaryPerYear,Integer newvariablePerYear)
	{
		return result=newFixedSalaryPerYear + newvariablePerYear;
	}
	
	public Integer netIncreaseYearly(Integer newCtcYear,Integer currentCtcYear)
	{
		return result=newCtcYear-currentCtcYear;
	}

	
	
	public Integer variableTobedisbursed(Integer totalVariable,Integer noOfMonthinCompany)
	{
		return result=(totalVariable/12)*noOfMonthinCompany;
	}
	
	
	public Integer variableAmoutCurrentYear(Integer variable,Integer currentFixedSalary)
	{
		return result=(currentFixedSalary*variable)/100;
	}
	
	
	public Integer currentFixedSalaryPerMonth(Integer currentFixedSalaryPerYear)
	{
		return result=currentFixedSalaryPerYear/12;
	}
}
