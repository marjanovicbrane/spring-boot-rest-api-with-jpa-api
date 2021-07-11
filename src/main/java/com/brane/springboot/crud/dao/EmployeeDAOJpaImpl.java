package com.brane.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brane.springboot.crud.entity.Employee;

//THIS IS DAO LAYER
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	//private field entityManager, so we can do constructor dependency injection
	private EntityManager entityManager;
			
	//constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
	entityManager = theEntityManager;
	}
			
			
	@Override
	public List<Employee> findAll() {
		
		//create a query
		//WE ARE USING HERE STANDARD JPA API and JPQL
		Query query=entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees=query.getResultList();
		
		// return the results	
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// now retrieve/read object from database using the primary key
		//we are using find() method, because we are using STANDARD JPA API
		Employee empoloyee=entityManager.find(Employee.class, theId);
				
		return empoloyee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
