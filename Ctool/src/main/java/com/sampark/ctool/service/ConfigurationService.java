package com.sampark.ctool.service;

import java.util.List;

import com.sampark.ctool.entity.ConfigurationEntity;
import com.sampark.ctool.object.ResponseObject;

public interface ConfigurationService {
	
	public ResponseObject configData();
	
	public ResponseObject saveConfigData(List<ConfigurationEntity> configList);

}
