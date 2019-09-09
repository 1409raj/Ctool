package com.sampark.ctool.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.sampark.ctool.entity.ConfigurationEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.service.ConfigurationService;

@Controller
@RequestMapping(value="/config")
public class ConfigurationController {
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody ResponseObject configList()
	{
		ResponseObject rsobj=new ResponseObject();
		rsobj=configurationService.configData();
		return rsobj;
	}

	
	@RequestMapping(value = "/bulk", method = RequestMethod.POST)
	public @ResponseBody ResponseObject saveDocument(@RequestParam("file1") MultipartFile file,HttpSession session ) throws ParseException {
		ResponseObject rsobj=new ResponseObject();
		 BufferedReader br;
		 List<ConfigurationEntity> configlist = new ArrayList<ConfigurationEntity>();
		 try {
		      String line;
		      boolean check = true;
		      InputStream is = file.getInputStream();
		      br = new BufferedReader(new InputStreamReader(is));
		      while ((line = br.readLine()) != null) {	
		    	  String[] parst = null;
		    	  if(check == true )
		    	  {
		    	  parst =  line.split(",");
		    	  check = false;
		    	  }
		    	  else
		    	  {
		    		  parst =  line.split(",");
		    		  ConfigurationEntity config=new ConfigurationEntity();
		    		  config.setLocation(parst[0]);
		    		  config.setDepartment(parst[1]);
		    		  config.setDesignation(parst[2]);
//		    		  Date doj=new SimpleDateFormat("dd.MM.yyyy").parse(parst[3]);
		    		  config.setDoj(new Date());
		    		  config.setAssessmentyear(parst[4]);
		    		  config.setKra(Integer.valueOf(parst[5]));
		    		  config.setExtraOrdinaryInitiative(Integer.valueOf(parst[6]));
		    		  config.setBehaviorCompetence(Integer.valueOf(parst[7]));
		    		  config.setVariableCurrentyear(Integer.valueOf(parst[8]));
		    		  config.setVariable33(Integer.valueOf(parst[9]));
		    		  config.setVariable67(Integer.valueOf(parst[10]));
		    		  config.setIncrementWRTrating(Integer.valueOf(parst[11]));
		    		  config.setRationalizationHrFactor(Integer.valueOf(parst[12]));
		    		  config.setPromotionpercentage(Integer.valueOf(parst[13]));
		    		  config.setRetentioncase(Integer.valueOf(parst[14]));
		    		  config.setNewvariable(Integer.valueOf(parst[15]));
		    		  config.setSpecialBonusamount(Integer.valueOf(parst[16]));
		    		  configlist.add(config);
		    	 }
		      }
		      try {
				 rsobj=configurationService.saveConfigData(configlist);
				
			} catch (Exception e) {
				
				e.printStackTrace();	
			}
		   } catch (IOException e) {
			   
			   e.printStackTrace();
		   }
		return rsobj;
	}

}
