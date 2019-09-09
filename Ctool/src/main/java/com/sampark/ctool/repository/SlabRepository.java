package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.object.ResponseObject;

public interface SlabRepository {
	public List<SlabEntity> slabList();
	public Boolean saveSlab(SlabEntity slabEntity);
	public Boolean deleteSlab(SlabEntity slabEntity);
	
	public List<EmployeeRatingVariableNonRoofTop> variableRatingList();
	
	public Boolean saveRatingVariable(EmployeeRatingVariableNonRoofTop ratingVariableEntity);
	

}
