package com.sampark.ctool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.EmployeeRatingVariableRoofTop;
import com.sampark.ctool.entity.VariableSlabNonRoofTopEntity33;
import com.sampark.ctool.entity.VariableSlabRoofTopEntity40;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.service.VariableService;

@Controller
@RequestMapping(value="/variable")
public class VariableController {
	
	@Autowired
	VariableService variableService;
	
	
	  @RequestMapping(value="/savenonRooftop",method=RequestMethod.POST)
	  	public  @ResponseBody  ResponseEntity<Object> saveNonRoofTopVariable(@RequestBody VariableSlabNonRoofTopEntity33 variableSlabNonRoofTopEntity33) throws Exception
	  	{
	  		return new ResponseEntity<Object>(variableService.saveVariableNonRooftop33(variableSlabNonRoofTopEntity33), HttpStatus.OK);
	  	}
	  
	  @RequestMapping(value="/saveRooftop",method=RequestMethod.POST)
	  	public  @ResponseBody  ResponseEntity<Object> saveRoofTopVariable(@RequestBody VariableSlabRoofTopEntity40 variableSlabRoofTopEntity40) throws Exception
	  	{
	  		return new ResponseEntity<Object>(variableService.saveVariableRooftop40(variableSlabRoofTopEntity40), HttpStatus.OK);
	  	}
	  
	  
	   @RequestMapping(value="/listnonRoofTop",method=RequestMethod.POST)
		public  @ResponseBody  ResponseEntity<Object> listnonRoofTop33() throws Exception
		{
		   return new ResponseEntity<Object>(variableService.listVariableNonRooftop33(), HttpStatus.OK);
			 
		}
	   
	   
	   @RequestMapping(value="/listRoofTop40",method=RequestMethod.POST)
		public  @ResponseBody  ResponseEntity<Object> listnonRoofTop40() throws Exception
		{
		   return new ResponseEntity<Object>(variableService.listVariableRooftop40(), HttpStatus.OK);
			 
		}
	   
	   @RequestMapping(value="/ratingEmployeeNonRoofTop",method=RequestMethod.POST)
			public  @ResponseBody  ResponseEntity<Object> ratingEmployeeNonRoofTop() throws Exception
			{
			   return new ResponseEntity<Object>(variableService.employeeListVariableNonRoofTop(), HttpStatus.OK);
				 
			}
	   
	    @RequestMapping(value="/ratingEmployeeRoofTop",method=RequestMethod.POST)
		public  @ResponseBody  ResponseEntity<Object> ratingEmployeeRoofTop() throws Exception
		{
		   return new ResponseEntity<Object>(variableService.employeeListVariableRoofTop(), HttpStatus.OK);
			 
		}
	    
	    @RequestMapping(value="/saveEmployeeVariableRoofTop",method=RequestMethod.POST)
	  	public  @ResponseBody  ResponseEntity<Object> saveEmployeeRoofTop(@RequestBody EmployeeRatingVariableRoofTop employeeRatingVariableRoofTop) throws Exception
	  	{
	  		return new ResponseEntity<Object>(variableService.saveEmployeeVariableRoofTop(employeeRatingVariableRoofTop), HttpStatus.OK);
	  	}
	    
	    
	    @RequestMapping(value="/saveEmployeeVariableNonRoofTop",method=RequestMethod.POST)
	  	public  @ResponseBody  ResponseEntity<Object> saveEmployeeVariableNonRoofTop(@RequestBody EmployeeRatingVariableNonRoofTop employeeRatingVariableNonRoofTop) throws Exception
	  	{
	  		return new ResponseEntity<Object>(variableService.saveEmployeeVariableNonRoofTop(employeeRatingVariableNonRoofTop), HttpStatus.OK);
	  	}

}
