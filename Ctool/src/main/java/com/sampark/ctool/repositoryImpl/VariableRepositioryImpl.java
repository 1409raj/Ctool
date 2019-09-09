package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.EmployeeRatingVariableNonRoofTop;
import com.sampark.ctool.entity.EmployeeRatingVariableRoofTop;
import com.sampark.ctool.entity.VariableSlabNonRoofTopEntity33;
import com.sampark.ctool.entity.VariableSlabRoofTopEntity40;
import com.sampark.ctool.repository.VariableRepositiory;

@Repository
public class VariableRepositioryImpl implements VariableRepositiory {
	
	
private static final Logger logger = Logger.getLogger(VariableRepositioryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}


	@Override
	@Transactional
	public Boolean saveVariableNonRooftop33(VariableSlabNonRoofTopEntity33 variableSlabNonRoofTopEntity33) {
		
		Boolean flag=false;
		if(variableSlabNonRoofTopEntity33.getId()!=null)
		{
			variableSlabNonRoofTopEntity33.setModifiedOn(new Date());
			entityManager.merge(variableSlabNonRoofTopEntity33);
			flag=true;
		}
		else
		{
			variableSlabNonRoofTopEntity33.setCreatedOn(new Date());
			variableSlabNonRoofTopEntity33.setModifiedOn(new Date());
			variableSlabNonRoofTopEntity33.setModifiedBy("HR");
			variableSlabNonRoofTopEntity33.setCreatedBy("HR");
			variableSlabNonRoofTopEntity33.setStatus(CtoolConstanats.STATUS_ACTIVE);
			entityManager.persist(variableSlabNonRoofTopEntity33);
			flag=true;
				
		}
		return flag;
	}

	@Override
	@Transactional
	public Boolean saveVariableRooftop40(VariableSlabRoofTopEntity40 variableSlabRoofTopEntity40) {
		
		Boolean flag=false;
		if(variableSlabRoofTopEntity40.getId()!=null)
		{
			variableSlabRoofTopEntity40.setModifiedOn(new Date());
			entityManager.merge(variableSlabRoofTopEntity40);
			flag=true;
		}
		else
		{
			variableSlabRoofTopEntity40.setCreatedOn(new Date());
			variableSlabRoofTopEntity40.setModifiedOn(new Date());
			variableSlabRoofTopEntity40.setModifiedBy("HR");
			variableSlabRoofTopEntity40.setCreatedBy("HR");
			variableSlabRoofTopEntity40.setStatus(CtoolConstanats.STATUS_ACTIVE);
			entityManager.persist(variableSlabRoofTopEntity40);
			flag=true;
				
		}
		return flag;
	}


	@Override
	public List<VariableSlabNonRoofTopEntity33> listVariableNonRooftop33() {
		List<VariableSlabNonRoofTopEntity33> list = new ArrayList<VariableSlabNonRoofTopEntity33>();
		String sqlQuery = "select * from tbl_variable_salb_NonRoofTop_33 where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, VariableSlabNonRoofTopEntity33.class);
		list = (List<VariableSlabNonRoofTopEntity33>) query.getResultList();	
	     return list;
	}


	@Override
	public List<VariableSlabRoofTopEntity40> listVariableRooftop40() {
		List<VariableSlabRoofTopEntity40> list = new ArrayList<VariableSlabRoofTopEntity40>();
		String sqlQuery = "select * from tbl_variable_salb_RoofTop_40 where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, VariableSlabRoofTopEntity40.class);
		list = (List<VariableSlabRoofTopEntity40>) query.getResultList();	
	     return list;
	}


	@Override
	public List<EmployeeRatingVariableNonRoofTop> employeeListVariableNonRoofTop() {
		
		List<EmployeeRatingVariableNonRoofTop> list = new ArrayList<EmployeeRatingVariableNonRoofTop>();
		String sqlQuery = "select * from tbl_employee_rating_variable_non_roofTop where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeRatingVariableNonRoofTop.class);
		list = (List<EmployeeRatingVariableNonRoofTop>) query.getResultList();	
	     return list;
	}


	@Override
	public List<EmployeeRatingVariableRoofTop> employeeListVariableRoofTop() {
		
		List<EmployeeRatingVariableRoofTop> list = new ArrayList<EmployeeRatingVariableRoofTop>();
		String sqlQuery = "select * from tbl_employee_rating_variable_roofTop where status='1' order By ID DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeRatingVariableRoofTop.class);
		list = (List<EmployeeRatingVariableRoofTop>) query.getResultList();	
	     return list;
	}


	@Override
	@Transactional
	public Boolean saveEmployeeVariableRoofTop(EmployeeRatingVariableRoofTop employeeRatingVariableRoofTop) {
		
		Boolean flag=false;
		if(employeeRatingVariableRoofTop.getId()!=null)
		{
			employeeRatingVariableRoofTop.setModifiedOn(new Date());
			entityManager.merge(employeeRatingVariableRoofTop);
			flag=true;
		}
		else
		{
			employeeRatingVariableRoofTop.setCreatedOn(new Date());
			employeeRatingVariableRoofTop.setModifiedOn(new Date());
			employeeRatingVariableRoofTop.setModifiedBy("HR");
			employeeRatingVariableRoofTop.setCreatedBy("HR");
			employeeRatingVariableRoofTop.setStatus(CtoolConstanats.STATUS_ACTIVE);
			entityManager.persist(employeeRatingVariableRoofTop);
			flag=true;
				
		}
		return flag;
	}


	@Override
	@Transactional
	public Boolean saveEmployeeVariableNonRoofTop(EmployeeRatingVariableNonRoofTop employeeRatingVariableNonRoofTop) {
		
		Boolean flag=false;
		if(employeeRatingVariableNonRoofTop.getId()!=null)
		{
			employeeRatingVariableNonRoofTop.setModifiedOn(new Date());
			entityManager.merge(employeeRatingVariableNonRoofTop);
			flag=true;
		}
		else
		{
			employeeRatingVariableNonRoofTop.setCreatedOn(new Date());
			employeeRatingVariableNonRoofTop.setModifiedOn(new Date());
			employeeRatingVariableNonRoofTop.setModifiedBy("HR");
			employeeRatingVariableNonRoofTop.setCreatedBy("HR");
			employeeRatingVariableNonRoofTop.setStatus(CtoolConstanats.STATUS_ACTIVE);
			entityManager.persist(employeeRatingVariableNonRoofTop);
			flag=true;
				
		}
		return flag;
	}

}
