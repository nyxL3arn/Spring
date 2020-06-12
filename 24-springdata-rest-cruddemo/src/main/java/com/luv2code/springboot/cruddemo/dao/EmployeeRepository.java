package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

@RepositoryRestResource(path="members") //damit kann ich /members als Startseite festlegen
//sonst wäre es automatisch der kleingeschriebene Plural meiner entity: employees (bzw magic-api/members,
//weil ich das in application.properties eingetragen habe)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//that's it!!
}
