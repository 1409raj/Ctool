package com.sampark.ctool.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.WordDocument;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.WordDocumentRepository;
import com.sampark.ctool.service.WordDocumentService;

@Service
public class WordDocumentServiceImpl implements WordDocumentService{

	@Autowired
	WordDocumentRepository wordDocumentRepo;

	@Override
	public List<WordDocument> wordDocumentsList() {
		List<WordDocument> list = new ArrayList<WordDocument>();
		list = wordDocumentRepo.wordDocumentsList();
		list.parallelStream().peek(g -> g.setFileName(CtoolConstanats.server_url+"document?name="+g.getName())).collect(Collectors.toList());

		return list;
	}

	@Override
	public ResponseObject saveWordDocuments(WordDocument wordDocument) {
		ResponseObject rsobj=new ResponseObject();
		Boolean result = null;
		result= wordDocumentRepo.saveWordDocuments(wordDocument);
			if(result)
			{
				rsobj.setStatus(result);
				rsobj.setMessage("success");
			}
			else
			{
				rsobj.setStatus(result);
				rsobj.setMessage("fail");
			}
		return rsobj;
	}

	@Override
	public ResponseObject saveWordDocuments(List<WordDocument> wordDocument) {
		ResponseObject rsobj=new ResponseObject();
		Boolean result = null;
		result= wordDocumentRepo.saveWordDocuments(wordDocument);
			if(result)
			{
				rsobj.setStatus(result);
				rsobj.setMessage("success");
			}
			else
			{
				rsobj.setStatus(result);
				rsobj.setMessage("fail");
			}
		return rsobj;
	}

}
