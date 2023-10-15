package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
