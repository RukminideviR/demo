package com.mouritech.demo.controller;

import java.util.List;


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

import com.mouritech.demo.dto.DepartmentDto;
import com.mouritech.demo.model.Department;
import com.mouritech.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto depertmentRequest) {
        DepartmentDto response = departmentService.createDepartment(depertmentRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping("department/all")
	public ResponseEntity<?>  getAllDepartment(){
		List<Department> responseList = departmentService.getAllDepartment();
		return new ResponseEntity<List<Department>>(responseList,HttpStatus.OK);
		
	}
    @DeleteMapping("/department/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable("id") int depId){
        boolean deleted = departmentService.deleteDepartmentId(depId);
        return ResponseEntity.ok(deleted);
    }
    @PutMapping("department/update")
   	public ResponseEntity<?>  updateDepartment(@RequestBody Department department){
   		Department response = departmentService.updateDepartment(department);
   		return new ResponseEntity<Department>(response,HttpStatus.OK);
   	}
       

    

}
