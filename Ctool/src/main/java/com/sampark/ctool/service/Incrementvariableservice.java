package com.sampark.ctool.service;

import java.util.List;

import com.sampark.ctool.entity.IncrementLetterDetails;
import com.sampark.ctool.entity.IncrementvariableEntity;
import com.sampark.ctool.object.ResponseObject;

public interface Incrementvariableservice {
	
	public ResponseObject save(IncrementvariableEntity incrementvariableEntity);
	
	public ResponseObject getIncrementVariableList();
	
	
	public ResponseObject getIncrementLetterList();
}
