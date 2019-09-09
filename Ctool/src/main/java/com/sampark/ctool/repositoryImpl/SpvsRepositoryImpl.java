package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sampark.ctool.entity.SlabEntity;
import com.sampark.ctool.entity.SpvsDetailsEntity;
import com.sampark.ctool.entity.SpvsEntitiy;
import com.sampark.ctool.repository.SpvsRepository;

@Repository
public class SpvsRepositoryImpl implements SpvsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<SpvsEntitiy> spvsList() {
		List<SpvsEntitiy> list = new ArrayList<SpvsEntitiy>();
		String sqlQuery = "select * from tbl_spvs where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, SpvsEntitiy.class);
		list = (List<SpvsEntitiy>) query.getResultList();	
	     return list;
	}

	@Override
	public SpvsDetailsEntity spvsDetails(Integer spvsId) {
		SpvsDetailsEntity spvsDetailsEntity = new SpvsDetailsEntity();
		String sqlQuery = "select * from tbl_spvs_details where  SPVS_ID=:spvsId";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, SpvsDetailsEntity.class);
		query.setParameter("spvsId", spvsId);
		spvsDetailsEntity = (SpvsDetailsEntity) query.getSingleResult();
	     return spvsDetailsEntity;
	}

}
