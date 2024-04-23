package com.mouritech.demo.dto;

import java.time.LocalDate;

import com.mouritech.demo.model.Employee;

public class EmployeeDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String number;
	private LocalDate hireDate;
	private Integer departmentID;
	private Integer managerID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Integer departmentID) {
		this.departmentID = departmentID;
	}

	public Integer getManagerID() {
		return managerID;
	}

	public void setManagerID(Integer managerID) {
		this.managerID = managerID;
	}

	// Convert Entity to Dto
	public EmployeeDto(Employee employee) {
		this.id = employee.getId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.number = employee.getPhonenumber();
		this.hireDate = employee.getHireDate();
		this.departmentID = employee.getDepartmentid();
		this.managerID = employee.getManagerid();

	}

	// default constructor
	public EmployeeDto() {

	}

}
