package com.mouritech.demo.service;

import java.util.List;

import com.mouritech.demo.dto.DepartmentDto;
import com.mouritech.demo.dto.EmployeeDto;
import com.mouritech.demo.model.Department;
import com.mouritech.demo.model.Employee;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto departmentDto);
	List<Department> getAllDepartment();
	public boolean  deleteDepartmentId(int depId);
	Department updateDepartment(Department department);
	
	

}
