package com.springboot.springbootjparest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootjparest.dao.EmployeeDao;
import com.springboot.springbootjparest.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	// save employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDao.findAll();
	}
	
	//get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Long id){
		Optional<Employee> emp = employeeDao.findOne(id);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(emp);
	}
	
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,@Valid @RequestBody Employee emp){
		
		Optional<Employee> employee = employeeDao.findOne(id);
		
		if(employee==null) {
			return ResponseEntity.notFound().build();
		}
		
		Employee empl = new Employee();
		empl.setName(emp.getName());
		empl.setDesignation(emp.getDesignation());
		empl.setExperties(emp.getExperties());
		
		Employee updateEmp = employeeDao.save(empl);
		return ResponseEntity.ok().body(updateEmp);
	
	}
	
	//delete a employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id){
		Optional<Employee> employee = employeeDao.findOne(id);
		
		if(employee==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.delete(id);
		return ResponseEntity.ok().build();
		
	}
	
}
