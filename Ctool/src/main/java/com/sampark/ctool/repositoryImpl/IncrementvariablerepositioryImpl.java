package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.ctool.entity.IncrementLetterDetails;
import com.sampark.ctool.entity.IncrementvariableEntity;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.repository.Incrementvariablerepositiory;

@Repository
public class IncrementvariablerepositioryImpl implements Incrementvariablerepositiory {
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@Transactional
	public Boolean save(IncrementvariableEntity incrementvariableEntity) {
		if(incrementvariableEntity.getId()!=null)
		{
			incrementvariableEntity.setModifiedOn(new Date());
			incrementvariableEntity.setModifiedBy("HR");
			entityManager.merge(incrementvariableEntity);
		}
		else
		{
			incrementvariableEntity.setCreatedOn(new Date());
			incrementvariableEntity.setCreatedBy("HR");
			entityManager.persist(incrementvariableEntity);
		}
		return true;
	}

	@Override
	public List<IncrementvariableEntity> getIncrementVariableList() {
		
		List<IncrementvariableEntity> list = new ArrayList<IncrementvariableEntity>();
		String sqlQuery = "select * from tbl_increment_variable where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, IncrementvariableEntity.class);
		list = (List<IncrementvariableEntity>) query.getResultList();	
	     return list;
	}

	@Override
	public IncrementLetterDetails getIncrementLetterDetails(Integer id) {
	    IncrementLetterDetails incrementLetterDetails = new IncrementLetterDetails();
		String sqlQuery = "select * from tbl_incrementLetter_details where ID=:id and status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, IncrementLetterDetails.class);
		query.setParameter("id", id);
		incrementLetterDetails = (IncrementLetterDetails) query.getSingleResult();	
	     return incrementLetterDetails;
	}

	@Override
	public List<IncrementLetterDetails> getIncrementLetterList() {
		
		List<IncrementLetterDetails> list = new ArrayList<IncrementLetterDetails>();
		String sqlQuery = "select * from tbl_incrementLetter_details where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, IncrementLetterDetails.class);
		list = (List<IncrementLetterDetails>) query.getResultList();	
	     return list;
	}

}
