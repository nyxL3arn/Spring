package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	//setting up field and constructor injection
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO theEmployeeDAO){
		employeeDAO=theEmployeeDAO;
		//da ich mittlerweile mehrere DAOImplementations habe, muss ich hier mit @Qualifier
		//definieren, welchen Service ich nutzen will
		//in den Klammern nach @Qualifier: die Bean-ID (Klassenname mit Anfangsbuchstabe klein)
	}
	
	
	//implement the methods - on the service level always with @Transactional
	//and delegating the calls to the DAO
	
	@Transactional
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Transactional
	@Override
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
