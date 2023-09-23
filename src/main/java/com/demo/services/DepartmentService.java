package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.DepartmentReqDto;
import com.demo.entities.DepartmentEntity;
import com.demo.interfaces.DepartmentServiceImp;
import com.demo.repositories.DepartmentRepo;

@Service
public class DepartmentService implements DepartmentServiceImp {
	private final DepartmentRepo repo;
	
	public DepartmentService(DepartmentRepo departmentRepo) {
		this.repo = departmentRepo;
	}

	@Override
	public ResponseEntity<?> addDepartment(DepartmentReqDto dto) {
		DepartmentEntity entity = new DepartmentEntity();
		
		entity.setName(dto.getName());
		
		DepartmentEntity savedEntity = repo.save(entity);
		return ResponseEntity.ok(savedEntity);
	}

	@Override
	public ResponseEntity<?> getAllDepartments() {
		List<DepartmentEntity> responseList = new ArrayList<DepartmentEntity>();
		
		responseList = repo.findAll();
		
		return ResponseEntity.ok(responseList);
	}

}
