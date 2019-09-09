package com.sampark.ctool.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.SlabRepository;
import com.sampark.ctool.service.SlabService;

@Service
public class SlabServiceImpl implements SlabService {
	
	@Autowired
	SlabRepository slabRepository;

	@Override
	public ResponseObject slabList() {
		ResponseObject rsobj=new ResponseObject();
		List<SlabEntity> list = new ArrayList<SlabEntity>();
		list = slabRepository.slabList();
		rsobj.setObject(list);
		rsobj.setStatus(true);
		return rsobj;
		
	}

	@Override
	public ResponseObject saveSlab(SlabEntity slabEntity) {
		ResponseObject rsobj=new ResponseObject();
		rsobj.setStatus(slabRepository.saveSlab(slabEntity));
		return rsobj;
	}

	@Override
	public ResponseObject deleteSlab(SlabEntity slabEntity) {
		ResponseObject rsObject=new ResponseObject();
		if(slabRepository.deleteSlab(slabEntity))
		{

			rsObject.setObject(slabRepository.slabList());
			rsObject.setStatus(true);	
		}
		else
		{
             rsObject.setStatus(false);
		}
		return rsObject;
	}

	@Override
	public ResponseObject variableRatingList() {
		ResponseObject rsObject=new ResponseObject();
		rsObject.setObject(slabRepository.variableRatingList());
		rsObject.setStatus(true);	
		return rsObject;
	}

	@Override
	public ResponseObject saveRatingVariable(EmployeeRatingVariableNonRoofTop ratingVariableEntity) {
		ResponseObject rsobj=new ResponseObject();
		rsobj.setStatus(slabRepository.saveRatingVariable(ratingVariableEntity));
		return rsobj;
	}
	
	
	

}
