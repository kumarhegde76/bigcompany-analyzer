package com.company.analyzer.service;

import java.util.Map;

import com.company.analyzer.model.Employee;

public class EmployeeAnalyzer {

	public void analyze(Map<String, Employee> employees) {
		// Find CEO (no managerId)
		Employee ceo = employees.values().stream().filter(e -> e.getManagerId() == null).findFirst()
				.orElseThrow(() -> new RuntimeException("No CEO found"));

		System.out.println("\n--- Managers earning less than allowed ---");
		checkSalaryDeviation(ceo, true);

		System.out.println("\n--- Managers earning more than allowed ---");
		checkSalaryDeviation(ceo, false);

		System.out.println("\n--- Employees with too long reporting line ---");
		checkReportingLine(ceo, 0);
	}

	// Check if manager salary is below or above allowed range
	private void checkSalaryDeviation(Employee manager, boolean checkLess) {
		if (!manager.getSubordinates().isEmpty()) {
			double avg = manager.getSubordinates().stream().mapToDouble(Employee::getSalary).average().orElse(0);
			double minAllowed = avg * 1.20;
			double maxAllowed = avg * 1.50;

			if (checkLess && manager.getSalary() < minAllowed) {
				System.out.printf("%s earns %.2f but should earn at least %.2f%n", manager.getName(),
						manager.getSalary(), minAllowed);
			} else if (!checkLess && manager.getSalary() > maxAllowed) {
				System.out.printf("%s earns %.2f but should earn no more than %.2f%n", manager.getName(),
						manager.getSalary(), maxAllowed);
			}
		}
		for (Employee e : manager.getSubordinates()) {
			checkSalaryDeviation(e, checkLess);
		}
	}

	// Check if employee's reporting depth exceeds allowed limit
	private void checkReportingLine(Employee emp, int depth) {
		if (depth > 4) {
			System.out.printf("%s has reporting line too long by %d levels%n", emp.getName(), depth - 4);
		}
		for (Employee sub : emp.getSubordinates()) {
			checkReportingLine(sub, depth + 1);
		}
	}
}
