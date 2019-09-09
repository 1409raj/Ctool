package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.SpvsDetailsEntity;
import com.sampark.ctool.entity.SpvsEntitiy;

public interface SpvsRepository {
	
	public List<SpvsEntitiy> spvsList();
	
	public SpvsDetailsEntity spvsDetails(Integer spvsId);

}
