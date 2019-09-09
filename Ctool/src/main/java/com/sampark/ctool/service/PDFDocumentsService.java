package com.sampark.ctool.service;

import java.util.List;

import com.sampark.ctool.entity.PDFDocuments;
import com.sampark.ctool.object.ResponseObject;

public interface PDFDocumentsService {

	public List<PDFDocuments> pdfDocumentsList();
	public ResponseObject savePDFDocuments(PDFDocuments pdfDocuments);
	
	public ResponseObject savePDFDocuments(List<PDFDocuments> pdfDocuments);
	
}
