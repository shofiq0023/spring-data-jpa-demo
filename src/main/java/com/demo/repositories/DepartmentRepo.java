package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long>{

}
