package com.sampark.ctool.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.entity.IncrementLetterDetails;
import com.sampark.ctool.entity.IncrementvariableEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.Incrementvariablerepositiory;
import com.sampark.ctool.service.Incrementvariableservice;

@Service
public class IncrementvariableserviceImpl implements Incrementvariableservice {
	
	@Autowired
	Incrementvariablerepositiory incrementvariablerepositiory;

	ResponseObject rsObject=null;
	@Override
	public ResponseObject save(IncrementvariableEntity incrementvariableEntity) {
	rsObject=new ResponseObject();
		if(incrementvariablerepositiory.save(incrementvariableEntity))
		{
			rsObject.setStatus(true);
			rsObject.setObject(incrementvariablerepositiory.getIncrementVariableList());
		}
		else
		{
			rsObject.setStatus(false);
			rsObject.setObject(incrementvariablerepositiory.getIncrementVariableList());
		}
		return rsObject;
	}

	@Override
	public ResponseObject getIncrementVariableList() {
		rsObject=new ResponseObject();
		List<IncrementvariableEntity> list = new ArrayList<IncrementvariableEntity>();
		list = incrementvariablerepositiory.getIncrementVariableList();
		rsObject.setObject(list);
		rsObject.setStatus(true);
		return rsObject;
	}

	

	@Override
	public ResponseObject getIncrementLetterList() {
		rsObject=new ResponseObject();
		List<IncrementLetterDetails> list = new ArrayList<IncrementLetterDetails>();
		list = incrementvariablerepositiory.getIncrementLetterList();
		rsObject.setObject(list);
		rsObject.setStatus(true);
		return rsObject;
		
	
	}
	
	
	

}
