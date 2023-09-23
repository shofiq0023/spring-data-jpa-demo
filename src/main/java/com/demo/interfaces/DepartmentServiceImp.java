package com.demo.interfaces;

import org.springframework.http.ResponseEntity;

import com.demo.dto.DepartmentReqDto;

public interface DepartmentServiceImp {
	public ResponseEntity<?> addDepartment(DepartmentReqDto dto);

	public ResponseEntity<?> getAllDepartments();
}
