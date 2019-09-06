package com.surya.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surya.dao.EmployeeDao;
import com.surya.model.Employee;
import com.surya.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	public Flux<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Mono<Employee> getEmployeeById(String empId) {
		return employeeDao.getEmployeeById(empId);
		
	}

}