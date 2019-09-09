package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.IncrementLetterDetails;
import com.sampark.ctool.entity.IncrementvariableEntity;

public interface Incrementvariablerepositiory {
	
	public Boolean save(IncrementvariableEntity incrementvariableEntity);
	
	public List<IncrementvariableEntity> getIncrementVariableList();
	
	
	public IncrementLetterDetails getIncrementLetterDetails(Integer id);
	
	public List<IncrementLetterDetails> getIncrementLetterList();

}
