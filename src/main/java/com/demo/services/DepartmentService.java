package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.DepartmentReqDto;
import com.demo.entities.Department;
import com.demo.repositories.DepartmentRepo;

@Service
public class DepartmentService {
	private final DepartmentRepo departmentRepo;
	
	public DepartmentService(DepartmentRepo departmentRepo) {
		this.departmentRepo = departmentRepo;
	}

	public ResponseEntity<?> getAllDepartments() {
		List<Department> departments = new ArrayList<Department>();
		
		departmentRepo.findAll().forEach(departments::add);
		
		return ResponseEntity.ok(departments);
	}

	public ResponseEntity<?> createDepartment(DepartmentReqDto dto) {
		Department model = new Department();
		model.setName(dto.getName());
		
		Department res = departmentRepo.save(model);
		
		return ResponseEntity.ok(res);
	}
	
	
}
