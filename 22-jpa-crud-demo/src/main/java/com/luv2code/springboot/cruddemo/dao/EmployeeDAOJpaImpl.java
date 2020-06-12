package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	//define field ==>the EntityManager is automatically created by Springboot 
	private EntityManager entityManager;
	
	//define Constructor with Constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		
		entityManager=theEntityManager;
	}

	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get the employee  (ID wird automatisch gefunden, da primary key)
		//hier wird davon ausgegangen, dass die Query schon da ist
		
		Employee theEmployee = entityManager.find(Employee.class,theId)	;	
		//return the employee
			
		return null;
	}

	@Override
	public void save(Employee theEmployee) {
		
		// merge the new information into Employee //if id==0[non-existing]: insert/save, else: update
		Employee dbEmployee = entityManager.merge(theEmployee)	;	
		
		
		//update with id from db .. so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		// delete object with given primary key: hier wird employeeId als parameter übergeben
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		//hier wird der parameter employeeId definiert mit value theId
		theQuery.setParameter("employeeId",theId);
		
		theQuery.executeUpdate();
			
	}

}
