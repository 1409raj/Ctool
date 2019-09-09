package com.sampark.ctool.repository;

import java.util.List;
import com.sampark.ctool.entity.PDFDocuments;

public interface PDFDocumentsRepository {
	public List<PDFDocuments> pdfDocumentsList();
	public Boolean savePDFDocuments(PDFDocuments pdfDocuments);
	
	public Boolean savePDFDocuments(List<PDFDocuments> pdfDocuments);

}
