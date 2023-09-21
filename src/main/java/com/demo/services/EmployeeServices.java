package com.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeRequestDto;
import com.demo.entities.EmployeeEntity;
import com.demo.interfaces.EmployeeServiceImp;
import com.demo.repositories.EmployeeRepo;

@Service
public class EmployeeServices implements EmployeeServiceImp {
	private final EmployeeRepo employeeRepo;
	
	public EmployeeServices(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public String getEmployees() {
		return "hello";
	}

	@Override
	public ResponseEntity<?> addEmployee(EmployeeRequestDto reqDto) {
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setEmployeeName(reqDto.getEmployeeName());
		entity.setEmployeeDesignation(reqDto.getEmployeeDesignation());
		
		EmployeeEntity savedEntity = employeeRepo.save(entity);
		
		ResponseEntity<?> res = ResponseEntity.ok(savedEntity);
		
		return res;
	}

}
