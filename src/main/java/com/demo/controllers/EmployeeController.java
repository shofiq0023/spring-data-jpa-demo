package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.EmployeeReqDto;
import com.demo.services.EmployeeService;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public ResponseEntity<?> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeReqDto dto) {
		return employeeService.addEmployee(dto);
	}
	
	@GetMapping("/employee/{depId}")
	public ResponseEntity<?> getAllEmployeeWithDepartment(@PathVariable("depId") long departmentId) {
		return employeeService.getEmployeesWithDepartment(departmentId);
	}
}
