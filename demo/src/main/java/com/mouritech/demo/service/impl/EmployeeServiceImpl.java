package com.mouritech.demo.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.demo.dao.EmployeeRepository;
import com.mouritech.demo.dto.EmployeeDto;
import com.mouritech.demo.model.Employee;
import com.mouritech.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private Employee convertDtoToEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhonenumber(employeeDto.getNumber());
		employee.setHireDate(employeeDto.getHireDate());
		employee.setDepartmentid(employeeDto.getDepartmentID());
		employee.setManagerid(employeeDto.getManagerID());
		return employee;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto empDto) {
		Employee employee = convertDtoToEntity(empDto);
		Employee registeredEmployee = employeeRepository.save(employee);
		return new EmployeeDto(registeredEmployee);
	}

	@Override
	public List<EmployeeDto> getValues() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDto> empDtos = new ArrayList<>();
		for (Employee employee : employees) {
			empDtos.add(new EmployeeDto(employee));
		}
		return empDtos;
	}

	@Override
	public EmployeeDto getById(int iid) {
		Optional<Employee> option = employeeRepository.findById(iid);
		if (option.isPresent()) {
			Employee employee = option.get();
			EmployeeDto dto = new EmployeeDto();
			dto.setId(employee.getId());
			dto.setFirstName(employee.getFirstName());
			dto.setLastName(employee.getLastName());
			dto.setEmail(employee.getEmail());
			dto.setNumber(employee.getPhonenumber());
			dto.setHireDate(employee.getHireDate());
			dto.setDepartmentID(employee.getDepartmentid());
			dto.setManagerID(employee.getManagerid());
			return dto;
		}
		return null;
	}

	public boolean deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return true;
	}

	public Employee updateEmployee(Employee employee) {
		Employee response = employeeRepository.save(employee);
		return response;
	}

}
