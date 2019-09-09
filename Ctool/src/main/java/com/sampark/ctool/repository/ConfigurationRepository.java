package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.ConfigurationEntity;
import com.sampark.ctool.object.ResponseObject;

public interface ConfigurationRepository {
	
	public List<ConfigurationEntity> configData();
	
	public Boolean saveConfigData(List<ConfigurationEntity> configList);

}
