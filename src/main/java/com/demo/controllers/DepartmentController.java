package com.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.DepartmentReqDto;
import com.demo.services.DepartmentService;

@RestController
public class DepartmentController {
	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/departments")
	public ResponseEntity<?> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@PostMapping("/department")
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentReqDto dto) {
		return departmentService.createDepartment(dto);
	}
}
