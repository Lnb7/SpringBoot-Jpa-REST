package com.springboot.springbootjparest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootjparest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
