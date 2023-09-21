package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.EmployeeRequestDto;
import com.demo.interfaces.EmployeeServiceImp;

@RestController
@RequestMapping("/api/")
public class EmployeeControllers {
	private final EmployeeServiceImp employeeService;
	
	public EmployeeControllers(EmployeeServiceImp employeeServiceImp) {
		this.employeeService = employeeServiceImp;
	}
	
	@GetMapping("/hello")
	public String getEmployees() {
		return employeeService.getEmployees();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequestDto reqDto) {
		return employeeService.addEmployee(reqDto);
	}
}
