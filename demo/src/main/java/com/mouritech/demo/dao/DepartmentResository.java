package com.mouritech.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mouritech.demo.model.Department;

@Repository
public interface DepartmentResository extends JpaRepository<Department, Integer> {

}
