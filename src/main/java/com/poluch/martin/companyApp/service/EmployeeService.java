package com.poluch.martin.companyApp.service;

import com.poluch.martin.companyApp.entity.Employee;
import com.poluch.martin.companyApp.entity.Position;

import java.util.List;
import java.util.Set;


public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int id);
	
	void save(Employee theEmployee);
	
	void deleteById(int id);

	List<Position> findAllPositions();


	
}
