package com.demo.services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeRequestDto;
import com.demo.entities.DepartmentEntity;
import com.demo.entities.EmployeeEntity;
import com.demo.interfaces.EmployeeServiceImp;
import com.demo.repositories.DepartmentRepo;
import com.demo.repositories.EmployeeRepo;

@Service
public class EmployeeServices implements EmployeeServiceImp {
	private final EmployeeRepo employeeRepo;
	private final DepartmentRepo departmentRepo;
	
	public EmployeeServices(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
	}

	@Override
	public String getEmployees() {
		return "hello";
	}

	@Override
	public ResponseEntity<?> addEmployee(EmployeeRequestDto reqDto) {
		Optional<DepartmentEntity> departmentOpt = departmentRepo.findById(reqDto.getDepartmentId());
		
		if (departmentOpt.isEmpty()) {
			return new ResponseEntity<String>("No department found", HttpStatus.NOT_FOUND);
		}
		
		DepartmentEntity department = departmentOpt.get();
		EmployeeEntity entity = new EmployeeEntity();
		
		entity.setEmployeeName(reqDto.getEmployeeName());
		entity.setEmployeeDesignation(reqDto.getEmployeeDesignation());
		entity.setDepartment(department);
		
		EmployeeEntity savedEntity = employeeRepo.save(entity);
		
		ResponseEntity<?> res = ResponseEntity.ok(savedEntity);
		
		return res;
	}

}
