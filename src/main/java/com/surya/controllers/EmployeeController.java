package com.surya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.surya.model.Employee;
import com.surya.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addNewEmployee", "emp", new Employee());
	}

	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("emp") Employee emp) {

		employeeService.insertEmployee(emp);
		Flux<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployees")
	public ModelAndView getEmployees() {
		Flux<Employee> employees = employeeService.getAllEmployees();
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employees);
		return model;
	}

	@RequestMapping("/getEmployee/{id}")
	public ModelAndView getEmployeesbyid(@PathVariable String id) {
		Mono<Employee> employee = employeeService.getEmployeeById(id);
		ModelAndView model = new ModelAndView("getEmployees");
		model.addObject("employees", employee);
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}
