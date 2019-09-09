package com.sampark.ctool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.SpvsRepository;
import com.sampark.ctool.service.SpvsService;

@Service
public class SpvsServiceImpl implements SpvsService {
	
	@Autowired
	SpvsRepository spvRepository;
	
	ResponseObject rsObject;

	@Override
	public ResponseObject spvsList() {
		rsObject=new ResponseObject();
		rsObject.setObject(spvRepository.spvsList());
		return rsObject;
	}

}
