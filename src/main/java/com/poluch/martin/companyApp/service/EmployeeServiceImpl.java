package com.poluch.martin.companyApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.poluch.martin.companyApp.dao.EmployeeRepository;
import com.poluch.martin.companyApp.dao.PositionRepository;
import com.poluch.martin.companyApp.entity.Employee;
import com.poluch.martin.companyApp.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private PositionRepository positionRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
		this.employeeRepository = employeeRepository;
		this.positionRepository = positionRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Override
	public List<Position> findAllPositions() {
		return positionRepository.findAll();
	}
}






