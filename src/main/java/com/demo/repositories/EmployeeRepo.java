package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findAllByDepartmentId(long departmentId);

}
