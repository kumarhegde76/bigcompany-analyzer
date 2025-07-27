package com.company.analyzer.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String id;
	private String name;
	private double salary;
	private String managerId;
	private List<Employee> subordinates = new ArrayList<>();

	public Employee(String id, String name, double salary, String managerId) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getManagerId() {
		return managerId;
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void addSubordinate(Employee emp) {
		subordinates.add(emp);
	}
}
