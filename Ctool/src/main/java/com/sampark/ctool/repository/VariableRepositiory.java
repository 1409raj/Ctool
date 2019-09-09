package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.EmployeeRatingVariableRoofTop;
import com.sampark.ctool.entity.VariableSlabNonRoofTopEntity33;
import com.sampark.ctool.entity.VariableSlabRoofTopEntity40;
import com.sampark.ctool.object.ResponseObject;

public interface VariableRepositiory {
	
	public Boolean saveVariableNonRooftop33(VariableSlabNonRoofTopEntity33 variableSlabNonRoofTopEntity33);
	public Boolean saveVariableRooftop40(VariableSlabRoofTopEntity40 variableSlabRoofTopEntity40);
	
	public List<VariableSlabNonRoofTopEntity33> listVariableNonRooftop33();
	public List<VariableSlabRoofTopEntity40> listVariableRooftop40();
	
	public List<EmployeeRatingVariableNonRoofTop> employeeListVariableNonRoofTop();
	public List<EmployeeRatingVariableRoofTop> employeeListVariableRoofTop();
	
	
	public Boolean saveEmployeeVariableRoofTop(EmployeeRatingVariableRoofTop employeeRatingVariableRoofTop);
	public Boolean saveEmployeeVariableNonRoofTop(EmployeeRatingVariableNonRoofTop employeeRatingVariableNonRoofTop);
	
	

}
