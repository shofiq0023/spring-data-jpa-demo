package com.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class DepartmentEntity extends BaseEntity {
	private String name;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
