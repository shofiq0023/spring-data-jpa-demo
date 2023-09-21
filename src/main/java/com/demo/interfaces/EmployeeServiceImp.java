package com.demo.interfaces;

import org.springframework.http.ResponseEntity;

import com.demo.dto.EmployeeRequestDto;

public interface EmployeeServiceImp {

	String getEmployees();

	ResponseEntity<?> addEmployee(EmployeeRequestDto reqDto);

}
