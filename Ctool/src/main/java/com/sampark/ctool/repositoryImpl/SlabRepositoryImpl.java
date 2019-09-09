package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.SlabRepository;

@Repository
public class SlabRepositoryImpl implements SlabRepository {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SlabEntity> slabList() {
		List<SlabEntity> list = new ArrayList<SlabEntity>();
		String sqlQuery = "select * from tbl_slab where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, SlabEntity.class);
		list = (List<SlabEntity>) query.getResultList();	
	     return list;
	}

	@Override
	@Transactional
	public Boolean saveSlab(SlabEntity slabEntity) {
		
		if(slabEntity.getId()!=null)
		{
			slabEntity.setModifiedOn(new Date());
			entityManager.merge(slabEntity);
		}
		else
		{
			entityManager.persist(slabEntity);
			
			
				
		}
		
		
		
		return true;
	}

	@Override
	@Transactional
	public Boolean deleteSlab(SlabEntity slabEntity) {
		entityManager.merge(slabEntity);
		return true;
	}

	@Override
	public List<EmployeeRatingVariableNonRoofTop> variableRatingList() {
		List<EmployeeRatingVariableNonRoofTop> list = new ArrayList<EmployeeRatingVariableNonRoofTop>();
		String sqlQuery = "select * from tbl_rating_variable where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeRatingVariableNonRoofTop.class);
		list = (List<EmployeeRatingVariableNonRoofTop>) query.getResultList();	
	     return list;
	}

	@Override
	@Transactional
	public Boolean saveRatingVariable(EmployeeRatingVariableNonRoofTop ratingVariableEntity) {
		
		if(ratingVariableEntity.getId()!=null)
		{
			ratingVariableEntity.setModifiedOn(new Date());
			entityManager.merge(ratingVariableEntity);
		}
		else
		{
			ratingVariableEntity.setCreatedOn(new Date());
			entityManager.persist(ratingVariableEntity);
		}
	
		return true;
	}
	


	
}
