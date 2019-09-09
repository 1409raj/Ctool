package com.sampark.ctool.repository;

import java.util.List;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.FinalCalculations;
import com.sampark.ctool.entity.VariableTypeEntity;

public interface EmployeeRepository {
	
	
	public EmployeeBasicDetails isEmployeeExist(String empcode,String assesmentYear);
	
	public Boolean saveEmployee(EmployeeBasicDetails employeeList);
	
	//public EmployeeBasicDetails singlePdf(Integer ID);
	
	public List<EmployeeBasicDetails> employeeList();

	public FinalCalculations isEmployeeFinalCalculationsExist(String empCode, String assessmentYear);

	public Boolean saveEmployeeFinalCalculations(FinalCalculations finalCalculationsEntity);

	public List<EmployeeBasicDetails> employeePromtionListGenerated();
	public List<EmployeeBasicDetails> employeePromtionListNotGenerated();
	
	public Boolean deleteEmployee(EmployeeBasicDetails employeeBasicDetails);
	
	public List<VariableTypeEntity> getVariableTypeList();

}
