package com.demo.interfaces;

import org.springframework.http.ResponseEntity;

import com.demo.dto.EmployeeRequestDto;

public interface EmployeeServiceImp {

	public ResponseEntity<?> getEmployees();

	public ResponseEntity<?> addEmployee(EmployeeRequestDto reqDto);

}
