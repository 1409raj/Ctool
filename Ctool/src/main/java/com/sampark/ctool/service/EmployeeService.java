package com.sampark.ctool.service;

import java.util.List;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.FinalCalculations;
import com.sampark.ctool.entity.VariableTypeEntity;
import com.sampark.ctool.object.ResponseObject;

public interface EmployeeService {
	
	public ResponseObject saveEmployee(List<EmployeeBasicDetails> employeeList);
	//public EmployeeBasicDetails singlePdf(Integer ID);
	public ResponseObject employeeList();
	
	public ResponseObject updateEmployee(EmployeeBasicDetails employee);

	public ResponseObject saveFinalCalculation(List<FinalCalculations> finalCalculationslist);

	public List<EmployeeBasicDetails> employeePromtionListGenerated();
	public List<EmployeeBasicDetails> employeePromtionListNotGenerated();
	
	public ResponseObject deleteEmployee(EmployeeBasicDetails employeeBasicDetails);
	
	public ResponseObject getVariableTypeList();

	


}
