package com.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.DepartmentReqDto;
import com.demo.interfaces.DepartmentServiceImp;

@RestController
@RequestMapping("/api/")
public class DepartmentController {
	private final DepartmentServiceImp departmentService;
	
	public DepartmentController(DepartmentServiceImp departmentService) {
		this.departmentService = departmentService;
	}
	
	@PostMapping("/department")
	public ResponseEntity<?> addDepartment(@RequestBody DepartmentReqDto dto) {
		return departmentService.addDepartment(dto);
	}
	
	@GetMapping("/departments")
	public ResponseEntity<?> getAllDepartment() {
		try {
			return departmentService.getAllDepartments();
			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		return null;
	}
}
