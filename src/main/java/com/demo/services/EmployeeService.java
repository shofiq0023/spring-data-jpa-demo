package com.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeReqDto;
import com.demo.entities.Department;
import com.demo.entities.Employee;
import com.demo.repositories.DepartmentRepo;
import com.demo.repositories.EmployeeRepo;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;
	private final DepartmentRepo departmentRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
	}

	public ResponseEntity<?> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepo.findAll().forEach(employees::add);
		return ResponseEntity.ok(employees);
	}

	public ResponseEntity<?> addEmployee(EmployeeReqDto dto) {
		Optional<Department> departmentOpt = departmentRepo.findById(dto.getDepartmentId());
		if (departmentOpt.isEmpty()) {
			return new ResponseEntity<String>("No department found", HttpStatus.NOT_FOUND);
		}
		
		Employee model = new Employee();
		model.setName(dto.getName());
		model.setDepartment(departmentOpt.get());
		
		Employee res = employeeRepo.save(model);
		return ResponseEntity.ok(res);
	}

	public ResponseEntity<?> getEmployeesWithDepartment(long departmentId) {
		Optional<Department> departmentOpt = departmentRepo.findById(departmentId);
		List<Employee> employees = new ArrayList<Employee>();
		
		if (departmentOpt.isPresent()) {
			employees = employeeRepo.findAllByDepartmentId(departmentId);
		} else {
			return new ResponseEntity<String>("No department found", HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(employees);
	}

	
	
}
