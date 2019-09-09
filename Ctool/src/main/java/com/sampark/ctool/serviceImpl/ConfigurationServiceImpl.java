package com.sampark.ctool.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.entity.ConfigurationEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.ConfigurationRepository;
import com.sampark.ctool.service.ConfigurationService;
@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	
	@Autowired
	ConfigurationRepository  configurationRepository;

	@Override
	public ResponseObject configData() {
		ResponseObject rsobj=new ResponseObject();
		List<ConfigurationEntity> configurationEntity = new  ArrayList<ConfigurationEntity>();
		configurationEntity=configurationRepository.configData();
		if(configurationEntity.isEmpty())
		{
			rsobj.setStatus(false);
			rsobj.setMessage("No Data Found");
		}
		else
		{
			rsobj.setStatus(true);
			rsobj.setObject(configurationEntity);
			
		}
		 return rsobj;
		 }

	@Override
	@Transactional
	public ResponseObject saveConfigData(List<ConfigurationEntity> configList) {
		ResponseObject rsobj=new ResponseObject();
		if(configurationRepository.saveConfigData(configList))
		{
			rsobj.setStatus(true);
		}
		else
		{
			rsobj.setStatus(false);
		}
		
		
		// TODO Auto-generated method stub
		return rsobj;
	}
}
