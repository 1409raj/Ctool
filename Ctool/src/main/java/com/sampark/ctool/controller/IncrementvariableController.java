package com.sampark.ctool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.IncrementvariableEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.service.Incrementvariableservice;

@Controller
@RequestMapping("/increment")
public class IncrementvariableController {
	
	@Autowired
	Incrementvariableservice incrementvariableservice;
	
	 @RequestMapping(value="/save",method=RequestMethod.POST)
	  	public  @ResponseBody  ResponseEntity<Object> save(@RequestBody IncrementvariableEntity incrementvariableEntity) throws Exception
	  	{
		 incrementvariableEntity.setStatus(CtoolConstanats.STATUS_ACTIVE);
	  		return new ResponseEntity<Object>(incrementvariableservice.save(incrementvariableEntity), HttpStatus.OK);
	  	}
	 
	 @RequestMapping(value="/list",method=RequestMethod.POST)
		public  @ResponseBody  ResponseObject incrementVariableList() throws Exception
		{
		 return incrementvariableservice.getIncrementVariableList();
		}
	 
	 
	 @RequestMapping(value="/letterDetails/list",method=RequestMethod.POST)
		public  @ResponseBody  ResponseObject incrementLetterDetailsList() throws Exception
		{
		
			return incrementvariableservice.getIncrementLetterList();
		}
	 

}
