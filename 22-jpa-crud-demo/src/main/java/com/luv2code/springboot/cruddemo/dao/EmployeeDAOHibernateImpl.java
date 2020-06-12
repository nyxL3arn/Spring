package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define fields for entitymanager
	private EntityManager entityManager;
	/*the Entitymanager is automatically created by Springboot */
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	// @Transactional =>We remove it because we'll build a service for transactions:
	//
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		return employees;
	
	}

	@Override
	public Employee findById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId); //automatisch die ID, da primary key
		
		//return the employee
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save the employee		remember: if id=0 then save/insert else: update
		currentSession.saveOrUpdate(theEmployee);	
								
	}

	@Override
	public void deleteById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery= currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId",theId);
		
		theQuery.executeUpdate();
	}

}
