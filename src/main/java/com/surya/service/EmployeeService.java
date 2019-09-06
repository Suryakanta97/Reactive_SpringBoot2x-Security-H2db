package com.surya.service;

import java.util.List;

import com.surya.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	Flux<Employee> getAllEmployees();
	Mono<Employee> getEmployeeById(String empid);
}