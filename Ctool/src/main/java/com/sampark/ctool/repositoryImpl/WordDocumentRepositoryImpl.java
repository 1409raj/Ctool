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
import com.sampark.ctool.entity.PDFDocuments;
import com.sampark.ctool.entity.WordDocument;
import com.sampark.ctool.repository.WordDocumentRepository;

@Repository
public class WordDocumentRepositoryImpl implements WordDocumentRepository{

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WordDocument> wordDocumentsList() {
		List<WordDocument> list = new ArrayList<WordDocument>();
		String sqlQuery = "select * from tbl_word_documents order By CREATED_ON DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, WordDocument.class);
		list = (List<WordDocument>) query.getResultList();
	     return list;
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

	@Transactional
	@Override
	public Boolean saveWordDocuments(WordDocument wordDocuments) {

		entityManager.persist(wordDocuments);
		if(wordDocuments.getId()>0)
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
	public Boolean saveWordDocuments(List<WordDocument> wordDocuments) {
       Iterator<WordDocument> it=wordDocuments.iterator();

		while (it.hasNext()) {
			WordDocument wordDocuments2 = (WordDocument) it.next();

			PDFDocuments wordDocuments3=	findEmployeeDoc(wordDocuments2.getEmpCode());
			if(wordDocuments3!=null)
			{
				wordDocuments3.setCreatedOn(new Date());
				wordDocuments3.setName(wordDocuments2.getName());
				entityManager.merge(wordDocuments3);
				updateDocStatus(wordDocuments3.getEmpCode());
			}
			else
			{
				entityManager.persist(wordDocuments2);
				updateDocStatus(wordDocuments2.getEmpCode());
			}
			}

		return true;
	}
}
