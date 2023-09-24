package com.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeEntity extends BaseEntity {
	private String employeeName;
	private String employeeDesignation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // To prevent serialisation issue
	private DepartmentEntity department;

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(String employeeName, String employeeDesignation, DepartmentEntity department) {
		super();
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.department = department;
	}

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

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
