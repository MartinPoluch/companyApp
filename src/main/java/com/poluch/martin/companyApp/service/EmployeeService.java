package com.poluch.martin.companyApp.service;

import com.poluch.martin.companyApp.entity.Employee;

import java.util.List;


public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
