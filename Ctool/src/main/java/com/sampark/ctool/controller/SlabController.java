package com.sampark.ctool.controller;

import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.service.SlabService;

/* Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/slab")
public class SlabController {

	private static final Logger logger = LoggerFactory.getLogger(SlabController.class);
    private static ResourceBundle messages = ResourceBundle.getBundle("messages");
   
    @Autowired
    SlabService slabService;
    
    @RequestMapping(value="/list",method=RequestMethod.POST)
	public  @ResponseBody  ResponseObject slabList() throws Exception
	{
		ResponseObject rsobj=new ResponseObject();
		rsobj=slabService.slabList();
		return rsobj;
	}
    
    @RequestMapping(value="/rating/variable",method=RequestMethod.POST)
   	public  @ResponseBody  ResponseObject ratingVariableList() throws Exception
   	{
   		ResponseObject rsobj=new ResponseObject();
   		rsobj=slabService.variableRatingList();
   		return rsobj;
   	}
    @RequestMapping(value="/save",method=RequestMethod.POST)
  	public  @ResponseBody  ResponseEntity<Object> save(@RequestBody SlabEntity slabEntity) throws Exception
  	{
    	slabEntity.setStatus(CtoolConstanats.STATUS_ACTIVE);
  		return new ResponseEntity<Object>(slabService.saveSlab(slabEntity), HttpStatus.OK);
  	}
    @RequestMapping(value="/save/variable",method=RequestMethod.POST)
  	public  @ResponseBody  ResponseEntity<Object> saveVariable(@RequestBody EmployeeRatingVariableNonRoofTop ratingVariableEntity) throws Exception
  	{
    	ratingVariableEntity.setStatus(CtoolConstanats.STATUS_ACTIVE);
  		return new ResponseEntity<Object>(slabService.saveRatingVariable(ratingVariableEntity), HttpStatus.OK);
  	}
    
    @RequestMapping(value="/delete",method=RequestMethod.POST)
  	public  @ResponseBody  ResponseEntity<Object> delete(@RequestBody SlabEntity slabEntity) throws Exception
  	{
    	slabEntity.setStatus(CtoolConstanats.STATUS_DEACTIVE);
  		return new ResponseEntity<Object>(slabService.deleteSlab(slabEntity), HttpStatus.OK);
  	}
}
