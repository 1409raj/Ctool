package com.sampark.ctool.serviceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sampark.ctool.CtoolConstanats;
import com.sampark.ctool.common.EnumarationFromula;
import com.sampark.ctool.entity.EmployeeBasicDetails;
import com.sampark.ctool.entity.FinalCalculations;
import com.sampark.ctool.object.ResponseObject;
import com.sampark.ctool.repository.EmployeeRepository;
import com.sampark.ctool.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	Integer empid=null;

	@Override
	public ResponseObject saveEmployee(List<EmployeeBasicDetails> employeeList) {
		ResponseObject rsobj=new ResponseObject();
		EmployeeBasicDetails employeeBean=new EmployeeBasicDetails();
		Boolean result = null;
		Iterator<EmployeeBasicDetails> it=employeeList.iterator();
		while (it.hasNext()) {
			EmployeeBasicDetails employee = (EmployeeBasicDetails) it.next();
			employeeBean=employeeRepository.isEmployeeExist(employee.getEmpCode(),employee.getAssessmentYear());
			if (employeeBean != null)
			{
				empid=employeeBean.getId();
				try {
					BeanUtils.copyProperties(employeeBean, employee);
					employeeBean.setId(empid);
					employeeBean.setStatus(CtoolConstanats.STATUS_DEACTIVE);
					employeeBean.setDocStatus(CtoolConstanats.docNotGenerated);
					result=employeeRepository.saveEmployee(employeeBean);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			else
			{
				
				result=employeeRepository.saveEmployee(employee);
			}
			if(result)
			{
				rsobj.setStatus(result);
				rsobj.setMessage("success");
			}
			else
			{
				rsobj.setStatus(result);
				rsobj.setMessage("fail");
			}
			
		}
		return rsobj;
	}

	@Override
	public ResponseObject employeeList() {
	ResponseObject rsobj=new ResponseObject();
	List<EmployeeBasicDetails> list = new ArrayList<EmployeeBasicDetails>();
	list=employeeRepository.employeeList();
	rsobj.setObject(list);
	rsobj.setStatus(true);
	return rsobj;
	}

	@Override
	public ResponseObject updateEmployee(EmployeeBasicDetails employee) {
		ResponseObject rsobj=new ResponseObject();
			if(employeeRepository.saveEmployee(employee))
			{
				rsobj.setStatus(true);
				rsobj.setMessage(CtoolConstanats.success);
			}
			else
			{
				rsobj.setStatus(false);
				rsobj.setMessage(CtoolConstanats.fail);
			}
			
		
		return rsobj;
	}

	@Override
	public ResponseObject saveFinalCalculation(List<FinalCalculations> finalCalculationslist) {
		// TODO Auto-generated method stub
				ResponseObject rsobj=new ResponseObject();
				FinalCalculations finalCalculationsEntity = new FinalCalculations();
				Boolean result = null;
				Iterator<FinalCalculations> it = finalCalculationslist.iterator();
				while (it.hasNext()) {
					FinalCalculations finalCalculations = (FinalCalculations) it.next();
					finalCalculationsEntity = employeeRepository.isEmployeeFinalCalculationsExist(finalCalculations.getEmpCode(),finalCalculations.getAssessmentYear());
					if (finalCalculationsEntity != null)
					{
						empid=finalCalculationsEntity.getId();
						try {
							BeanUtils.copyProperties(finalCalculationsEntity, finalCalculationsEntity);
							finalCalculationsEntity.setId(empid);
							result=employeeRepository.saveEmployeeFinalCalculations(finalCalculationsEntity);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						result=employeeRepository.saveEmployeeFinalCalculations(finalCalculations);
					}
					if(result)
					{
						rsobj.setStatus(result);
						rsobj.setMessage("success");
					}
					else
					{
						rsobj.setStatus(result);
						rsobj.setMessage("fail");
					}
				}
				return rsobj;
	}

	

	@Override
	public List<EmployeeBasicDetails> employeePromtionListGenerated() {
		return  employeeRepository.employeePromtionListGenerated();
		}

	@Override
	public List<EmployeeBasicDetails> employeePromtionListNotGenerated() {
		return  employeeRepository.employeePromtionListNotGenerated();
		}

	@Override
	public ResponseObject deleteEmployee(EmployeeBasicDetails employeeBasicDetails) {
		employeeBasicDetails.setStatus(2);
		employeeRepository.deleteEmployee(employeeBasicDetails);
		return employeeList();
	}

	@Override
	public ResponseObject getVariableTypeList() {
		ResponseObject rsObject=new ResponseObject();
		rsObject.setObject(employeeRepository.getVariableTypeList());
		// TODO Auto-generated method stub
		return rsObject;
	}

//	@Override
//	public EmployeeBasicDetails singlePdf(Integer ID) {
//		// TODO Auto-generated method stub
//		return employeeRepository.singlePdf(ID);
//	}
//	
//	


}
