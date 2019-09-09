package com.sampark.ctool.repositoryImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.FinalCalculations;
import com.sampark.ctool.entity.VariableTypeEntity;
import com.sampark.ctool.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public EmployeeBasicDetails isEmployeeExist(String empcode,String assesmentYear) {	
		String sqlQuery = "select * from employee_basic_details where EMP_CODE=:empcode and ASSESSMENT_YEAR=:assesmentYear";
		Query query = null;
		EmployeeBasicDetails bean=null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeBasicDetails.class);
		query.setParameter("empcode",empcode);
		query.setParameter("assesmentYear",assesmentYear);
		
		try {
			 bean = (EmployeeBasicDetails) query.getSingleResult();	
			return bean;
		} catch (Exception e) {
			return bean;
	
		}	
		}

	@Override
	@Transactional
	public Boolean saveEmployee(EmployeeBasicDetails employee) {
		if(employee.getId()!=null)
			{
			  employee.setModifiedOn(new Date());
	   		  employee.setModifiedBy("HR");
	   	
			entityManager.merge(employee);
		}
		else
		{
			employee.setStatus(CtoolConstanats.STATUS_DEACTIVE);
			employee.setDocStatus(CtoolConstanats.docNotGenerated);
			employee.setMedical("0");
			employee.setCarLeaseAmount(0);
			entityManager.persist(employee);
		}
			
		if(employee.getId()>0)
		{
		return true;	
		}
		else
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBasicDetails> employeeList() {
	List<EmployeeBasicDetails> list = new ArrayList<EmployeeBasicDetails>();
	String sqlQuery = "select * from employee_basic_details where STATUS !='2'";
	Query query = null;
	query = getEntityManager().createNativeQuery(sqlQuery, EmployeeBasicDetails.class);
	list = (List<EmployeeBasicDetails>) query.getResultList();	
     return list;
	}



	@Override
	public FinalCalculations isEmployeeFinalCalculationsExist(String empCode,String assessmentYear) {
		String sqlQuery = "select * from tbl_final_calculation where EMP_CODE=:empcode and ASSESSMENT_YEAR =:assessmentYear";
		Query query = null;
		FinalCalculations bean=null;
		query = getEntityManager().createNativeQuery(sqlQuery, FinalCalculations.class);
		query.setParameter("empcode",empCode);
		query.setParameter("assessmentYear",assessmentYear);
		try {
			 bean = (FinalCalculations) query.getSingleResult();	
			return bean;
		} catch (Exception e) {
			return bean;
		}	
	}
	
   
	@Override
	 @Transactional
	public Boolean saveEmployeeFinalCalculations(FinalCalculations finalCalculationsEntity) {
		if(finalCalculationsEntity.getId()!=null)
		{
		finalCalculationsEntity.setModifiedOn(new Date());
		finalCalculationsEntity.setModifiedBy("HR");
		entityManager.merge(finalCalculationsEntity);
		}
		else
		{
			try {
				entityManager.persist(finalCalculationsEntity);	
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("EXCEPTION--------->"+ e);
				e.printStackTrace();
			}
		}
		if(finalCalculationsEntity.getId()>0)
		{
		return true;	
		}
		else
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBasicDetails> employeePromtionListGenerated() {
		List<EmployeeBasicDetails> list = new ArrayList<EmployeeBasicDetails>();
		try {
		String sqlQuery = "select * from employee_basic_details where STATUS =:status and DOC_STATUS=:docStatus ORDER BY MODIFIED_ON DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeBasicDetails.class);
		query.setParameter("status",CtoolConstanats.STATUS_ACTIVE);
		query.setParameter("docStatus",CtoolConstanats.docGenerated);
		list = query.getResultList();
		}catch(Exception ex)
		{
		ex.printStackTrace();
		}
	    return list;
		
	}

	@Override
	public List<EmployeeBasicDetails> employeePromtionListNotGenerated() {
		List<EmployeeBasicDetails> list = new ArrayList<EmployeeBasicDetails>();
		try {
		String sqlQuery = "select * from employee_basic_details where STATUS =:status and DOC_STATUS=:docStatus ORDER BY MODIFIED_ON DESC";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeBasicDetails.class);
		query.setParameter("status",CtoolConstanats.STATUS_ACTIVE);
		query.setParameter("docStatus",CtoolConstanats.docNotGenerated);
		list = query.getResultList();
		}catch(Exception ex)
		{
		ex.printStackTrace();
		}
	    return list;
		
	}

	@Override
	@Transactional
	public Boolean deleteEmployee(EmployeeBasicDetails employeeBasicDetails) {
		employeeBasicDetails.setModifiedOn(new Date());
		employeeBasicDetails.setModifiedBy("HR");
		entityManager.merge(employeeBasicDetails);
		return true;
	}

	@Override
	public List<VariableTypeEntity> getVariableTypeList() {
		List<VariableTypeEntity> list = new ArrayList<VariableTypeEntity>();
		String sqlQuery = "select * from tbl_variable_type where STATUS ='1'";
		Query query = null;
		query = getEntityManager().createNativeQuery(sqlQuery, VariableTypeEntity.class);
		list = (List<VariableTypeEntity>) query.getResultList();	
	     return list;
		
	}

//	@Override
//	public EmployeeBasicDetails singlePdf(Integer ID) {
//		String sqlQuery = "select * from employee_basic_details where ID=:ID ";
//		Query query = null;
//		EmployeeBasicDetails bean=null;
//		query = getEntityManager().createNativeQuery(sqlQuery, EmployeeBasicDetails.class);
//		query.setParameter("ID",ID);
//		
//		
//		try {
//			 bean = (EmployeeBasicDetails) query.getSingleResult();	
//			return bean;
//		} catch (Exception e) {
//			return bean;
//	
//		}	
//		
//	}
	
	

}
