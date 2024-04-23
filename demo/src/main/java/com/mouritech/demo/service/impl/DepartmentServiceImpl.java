package com.mouritech.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.demo.dao.DepartmentResository;
import com.mouritech.demo.dto.DepartmentDto;
import com.mouritech.demo.model.Department;
import com.mouritech.demo.model.Employee;
import com.mouritech.demo.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentResository departmentResository;
	
	public DepartmentDto convertEntityToDto(Department department ) {
		
		DepartmentDto deptDto=new DepartmentDto();
	    deptDto.setDepartmentid(department.getDepartmentid());
		deptDto.setDepartmentname(department.getDepartmentname());
		return deptDto;
 	
	}
    		
    public Department convertDtoToEntity (DepartmentDto department ) {
		
		Department dept=new Department();
		dept.setDepartmentid(department.getDepartmentid());
		dept.setDepartmentname(department.getDepartmentname());
		
		return dept;
		
	}
    public DepartmentDto createDepartment(DepartmentDto departmentDto){

    	Department department=convertDtoToEntity(departmentDto);
    	Department resigDepartment= departmentResository.save(department);
    	DepartmentDto response= convertEntityToDto(resigDepartment);
    	return response;

    	}
   
    @Override
    public java.util.List<Department> getAllDepartment() {
    	 java.util.List<Department> list = departmentResository.findAll();
    	
	       return list;
              }

	@Override
	public boolean deleteDepartmentId(int depId) {
		departmentResository.deleteById(depId);
		return true;
	}
	
	  @Override
		 public  Department updateDepartment(Department department) {
		 Department response = departmentResository.save(department);
			return response;
			}
   
		
	
}
