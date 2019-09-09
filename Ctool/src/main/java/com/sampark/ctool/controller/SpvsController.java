package com.sampark.ctool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.service.SpvsService;

@Controller
@RequestMapping(value="/spvs")
public class SpvsController {
	
	@Autowired 
	SpvsService spvsService;
	
	  @RequestMapping(value="/list",method=RequestMethod.POST)
		public  @ResponseBody  ResponseObject slabList() throws Exception
		{
			return spvsService.spvsList();
		}
	    

}
