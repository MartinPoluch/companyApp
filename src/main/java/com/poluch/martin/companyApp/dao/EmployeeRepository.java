package com.poluch.martin.companyApp.dao;

import com.poluch.martin.companyApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
