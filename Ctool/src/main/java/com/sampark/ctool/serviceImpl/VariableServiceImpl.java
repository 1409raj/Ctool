package com.sampark.ctool.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.EmployeeRatingVariableRoofTop;
import com.sampark.ctool.entity.VariableSlabNonRoofTopEntity33;
import com.sampark.ctool.entity.VariableSlabRoofTopEntity40;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.VariableRepositiory;
import com.sampark.ctool.service.VariableService;

@Service
public class VariableServiceImpl  implements VariableService{
	
	@Autowired
	VariableRepositiory variableRepositiory;
	
	
	ResponseObject rsObject=null;

	@Override
	public ResponseObject saveVariableNonRooftop33(VariableSlabNonRoofTopEntity33 variableSlabNonRoofTopEntity33) {
		rsObject=new ResponseObject();
		if(variableRepositiory.saveVariableNonRooftop33(variableSlabNonRoofTopEntity33))
		{
			rsObject.setStatus(true);
			rsObject.setMessage("Success");
			rsObject.setObject(variableRepositiory.listVariableNonRooftop33());
			
		}
		else
		{
			rsObject.setStatus(false);
			rsObject.setMessage("Somethinf went wrong");
		}
		return rsObject;
	}

	@Override
	public ResponseObject saveVariableRooftop40(VariableSlabRoofTopEntity40 variableSlabRoofTopEntity40) {
		rsObject=new ResponseObject();
		if(variableRepositiory.saveVariableRooftop40(variableSlabRoofTopEntity40))
		{
			rsObject.setStatus(true);
			rsObject.setMessage("Success");
			rsObject.setObject(variableRepositiory.listVariableRooftop40());
			
		}
		else
		{
			rsObject.setStatus(false);
			rsObject.setMessage("Somethinf went wrong");
		}
		return rsObject;
	}

	@Override
	public ResponseObject listVariableNonRooftop33() {
		rsObject=new ResponseObject();
		rsObject.setObject(variableRepositiory.listVariableNonRooftop33());
		// TODO Auto-generated method stub
		return rsObject;
	}

	@Override
	public ResponseObject listVariableRooftop40() {
		rsObject=new ResponseObject();
		rsObject.setObject(variableRepositiory.listVariableRooftop40());
		// TODO Auto-generated method stub
		return rsObject;
	}

	@Override
	public ResponseObject employeeListVariableNonRoofTop() {
		rsObject=new ResponseObject();
		rsObject.setObject(variableRepositiory.employeeListVariableNonRoofTop());
		// TODO Auto-generated method stub
		return rsObject;
	}

	@Override
	public ResponseObject employeeListVariableRoofTop() {
		rsObject=new ResponseObject();
		rsObject.setObject(variableRepositiory.employeeListVariableRoofTop());
		// TODO Auto-generated method stub
		return rsObject;
	}

	@Override
	public ResponseObject saveEmployeeVariableRoofTop(EmployeeRatingVariableRoofTop employeeRatingVariableRoofTop) {
		rsObject=new ResponseObject();
		if(variableRepositiory.saveEmployeeVariableRoofTop(employeeRatingVariableRoofTop))
		{
			rsObject.setStatus(true);
			rsObject.setMessage("Success");
			rsObject.setObject(variableRepositiory.employeeListVariableRoofTop());
			
		}
		else
		{
			rsObject.setStatus(false);
			rsObject.setMessage("Somethinf went wrong");
		}
		return rsObject;
	}

	@Override
	public ResponseObject saveEmployeeVariableNonRoofTop(EmployeeRatingVariableNonRoofTop employeeRatingVariableNonRoofTop) {

		rsObject=new ResponseObject();
		if(variableRepositiory.saveEmployeeVariableNonRoofTop(employeeRatingVariableNonRoofTop))
		{
			rsObject.setStatus(true);
			rsObject.setMessage("Success");
			rsObject.setObject(variableRepositiory.employeeListVariableNonRoofTop());
			
		}
		else
		{
			rsObject.setStatus(false);
			rsObject.setMessage("Somethinf went wrong");
		}
		return rsObject;
	
	}

}
