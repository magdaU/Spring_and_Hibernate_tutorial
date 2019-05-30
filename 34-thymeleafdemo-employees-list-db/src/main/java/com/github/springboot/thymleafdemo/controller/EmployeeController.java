package com.github.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.springboot.thymleafdemo.entity.Employee;
import com.github.springboot.thymleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService=theEmployeeService;
	}


	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		//get employees from db
		List<Employee> theEmployees= employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

}
