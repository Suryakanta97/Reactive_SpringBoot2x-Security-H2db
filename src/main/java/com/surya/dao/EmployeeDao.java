package com.surya.dao;

import java.util.List;

import com.surya.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	Flux<Employee> getAllEmployees();
	Mono<Employee>getEmployeeById(String empId);
}