package com.sampark.ctool.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.PDFDocuments;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.PDFDocumentsRepository;
import com.sampark.ctool.service.PDFDocumentsService;

@Service
public class PDFDocumentsServiceImpl implements PDFDocumentsService {
	
	@Autowired
	PDFDocumentsRepository pdfdocumentsRepository;

	@Override
	public List<PDFDocuments> pdfDocumentsList() {
		
		List<PDFDocuments> list = new ArrayList<PDFDocuments>();
		list = pdfdocumentsRepository.pdfDocumentsList();
		list.parallelStream().peek(g -> g.setFileName(CtoolConstanats.server_url+"document?name="+g.getName())).collect(Collectors.toList());
		
		return list;
		
	}

	@Override
	public ResponseObject savePDFDocuments(PDFDocuments pdfDocuments) {
		ResponseObject rsobj=new ResponseObject();
		Boolean result = null;
		result= pdfdocumentsRepository.savePDFDocuments(pdfDocuments);
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
	public ResponseObject savePDFDocuments(List<PDFDocuments> pdfDocuments) {
		ResponseObject rsobj=new ResponseObject();
		Boolean result = null;
		result= pdfdocumentsRepository.savePDFDocuments(pdfDocuments);
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
