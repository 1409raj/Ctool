package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.ctool.entity.ConfigurationEntity;
import com.sampark.ctool.repository.ConfigurationRepository;

@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {
	
	private static final Logger logger = Logger.getLogger(ConfigurationRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	public List<ConfigurationEntity> configData() {
	
	List<ConfigurationEntity> configurationEntity = new  ArrayList<ConfigurationEntity>();
	String sqlQuery = "select * from tbl_config";
	Query query = null;
	query = getEntityManager().createNativeQuery(sqlQuery, ConfigurationEntity.class);
	
	configurationEntity = (List<ConfigurationEntity>) query.getResultList();
	return configurationEntity;
	}


	@Override
	@Transactional
	public Boolean saveConfigData(List<ConfigurationEntity> configList) {
		Iterator<ConfigurationEntity> it=configList.iterator();
		while (it.hasNext()) {
			ConfigurationEntity configurationEntity = (ConfigurationEntity) it.next();
			entityManager.persist(configurationEntity);
		}
		return true;
	}

}
