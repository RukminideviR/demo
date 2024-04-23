package com.mouritech.demo.service;


import java.util.List;

import com.mouritech.demo.dto.EmployeeDto;
import com.mouritech.demo.model.Employee;

public interface EmployeeService {


	EmployeeDto saveEmployee(EmployeeDto empDto);
	public List<EmployeeDto> getValues();
	public EmployeeDto getById(int iid);
	public boolean deleteEmployee(int empId);
	Employee updateEmployee(Employee employee);
	

}
