package com.sampark.ctool.service;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.object.ResponseObject;

public interface SlabService {

	ResponseObject slabList();
	
	public ResponseObject saveSlab(SlabEntity slabEntity);
	public ResponseObject deleteSlab(SlabEntity slabEntity);
	public ResponseObject variableRatingList();
	
	public ResponseObject saveRatingVariable(EmployeeRatingVariableNonRoofTop ratingVariableEntity);
	
}
