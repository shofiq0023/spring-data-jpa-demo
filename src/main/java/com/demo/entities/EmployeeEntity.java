package com.demo.entities;

import jakarta.persistence.Entity;

@Entity
public class EmployeeEntity extends BaseEntity {
	private String employeeName;
	private String employeeDesignation;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

}
