package com.sampark.ctool.service;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.EmployeeRatingVariableRoofTop;
import com.sampark.ctool.entity.VariableSlabNonRoofTopEntity33;
import com.sampark.ctool.entity.VariableSlabRoofTopEntity40;
import com.sampark.ctool.object.ResponseObject;

public interface VariableService {
	
	public ResponseObject saveVariableNonRooftop33(VariableSlabNonRoofTopEntity33 variableSlabNonRoofTopEntity33);
	public ResponseObject saveVariableRooftop40(VariableSlabRoofTopEntity40 variableSlabRoofTopEntity40);
	
	public ResponseObject listVariableNonRooftop33();
	public ResponseObject listVariableRooftop40();
	
    public ResponseObject employeeListVariableNonRoofTop();
	public ResponseObject employeeListVariableRoofTop();
	
	public ResponseObject saveEmployeeVariableRoofTop(EmployeeRatingVariableRoofTop employeeRatingVariableRoofTop);
	public ResponseObject saveEmployeeVariableNonRoofTop(EmployeeRatingVariableNonRoofTop employeeRatingVariableNonRoofTop);
	

}
