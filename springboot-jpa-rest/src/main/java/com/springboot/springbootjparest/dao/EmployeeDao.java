package com.springboot.springbootjparest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springbootjparest.model.Employee;
import com.springboot.springbootjparest.repository.EmployeeRepository;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	// save employee
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	//find all 
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	//get  employee by id
	public Optional<Employee> findOne(Long id) {
		return employeeRepository.findById(id);
	}
	
	// delete 
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}
	
}
