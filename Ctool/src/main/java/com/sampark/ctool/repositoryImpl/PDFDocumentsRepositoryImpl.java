package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.PDFDocuments;
import com.sampark.ctool.repository.PDFDocumentsRepository;

@Repository
public class PDFDocumentsRepositoryImpl implements PDFDocumentsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PDFDocuments> pdfDocumentsList() {
		List<PDFDocuments> list = new ArrayList<PDFDocuments>();
		String sqlQuery = "select * from tbl_pdf_documents order By CREATED_ON DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, PDFDocuments.class);
		list = (List<PDFDocuments>) query.getResultList();	
	     return list;
	}

	@Override
	@Transactional
	public Boolean savePDFDocuments(PDFDocuments pdfDocuments) {
	entityManager.persist(pdfDocuments);
	if(pdfDocuments.getId()>0)
	{
	return true;	
	}
	else
	{
		return false;
	}
	}

	@Override
	@Transactional
	public Boolean savePDFDocuments(List<PDFDocuments> pdfDocuments) {
		
		Iterator<PDFDocuments> it=pdfDocuments.iterator();
		
		while (it.hasNext()) {
			PDFDocuments pdfDocuments2 = (PDFDocuments) it.next();
			
			PDFDocuments pdfDocuments3=	findEmployeeDoc(pdfDocuments2.getEmpCode());
			if(pdfDocuments3!=null)
			{
				pdfDocuments3.setCreatedOn(new Date());
				pdfDocuments3.setName(pdfDocuments2.getName());
				entityManager.merge(pdfDocuments3);
				updateDocStatus(pdfDocuments3.getEmpCode());
			}
			else
			{
				entityManager.persist(pdfDocuments2);	
				updateDocStatus(pdfDocuments2.getEmpCode());
			}
			}
		
		return true;
		
	}
	
	private Boolean updateDocStatus(String empCode)
	{
		try {
		String sqlQuery = "update employee_basic_details set DOC_STATUS=:docStatus  where EMP_CODE =:empCode";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery);
		query.setParameter("empCode",empCode);
		query.setParameter("docStatus",CtoolConstanats.docGenerated);
		int i = query.executeUpdate();
		}catch(Exception ex)
		{
		ex.printStackTrace();
		}
	    return true;
		
	}
	

	private PDFDocuments findEmployeeDoc(String empCode)
	{
		PDFDocuments pdfDocuments = new PDFDocuments();
		String sqlQuery = "select * from tbl_pdf_documents where EMP_CODE=:empCode";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, PDFDocuments.class);
		query.setParameter("empCode", empCode);
		try {
			pdfDocuments = (PDFDocuments) query.getSingleResult();	
		     return pdfDocuments;
		} catch (Exception e) {
           return null;
		}
		
	
	}
}
