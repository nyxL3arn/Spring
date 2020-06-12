package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//setting up field and constructor injection
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
		
		employeeRepository=theEmployeeRepository;
		
	}
	
	//remove @Transactional : das ist bei SpringData jPA mit dabei
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		//uses Optional-approach https://community.oracle.com/docs/DOC-991686
		Optional<Employee> result = employeeRepository.findById(theId);
		
		//define Employee-reference
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			
			theEmployee=result.get();
	
		}
		else {
			
			throw new RuntimeException("Did not find employee id - "+theId);
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

}
