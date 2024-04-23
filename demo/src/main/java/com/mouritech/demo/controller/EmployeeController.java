package com.mouritech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.demo.dto.EmployeeDto;
import com.mouritech.demo.model.Employee;
import com.mouritech.demo.service.EmployeeService;

import java.util.List; // Import List from java.util

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeRequest) {
        EmployeeDto response = employeeService.saveEmployee(employeeRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/employees/all")
    public ResponseEntity<List<EmployeeDto>> getAllValues() {
        List<EmployeeDto> employees = employeeService.getValues();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("employees/{iid}")
    public ResponseEntity<?> getById(@PathVariable int iid) {
        EmployeeDto response = employeeService.getById(iid);
        return new ResponseEntity<EmployeeDto>(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteById(@PathVariable ("id") int empId){
		boolean b = employeeService.deleteEmployee(empId);
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
	}
    @PutMapping("/update/{id}")
	public ResponseEntity<?>  updateEmployee(@RequestBody Employee employee){
		Employee response = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(response,HttpStatus.OK);
	}

}
