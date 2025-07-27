package com.company.analyzer.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.company.analyzer.model.Employee;

public class CsvReader {

	public static Map<String, Employee> loadEmployees(String filePath) throws IOException {
		Map<String, Employee> employees = new HashMap<>();
		List<String> lines = Files.readAllLines(Paths.get(filePath));

		// all Employees
		for (int i = 1; i < lines.size(); i++) {
			String[] parts = lines.get(i).split(",");
			String id = parts[0].trim();
			String name = parts[1].trim();
			double salary = Double.parseDouble(parts[2].trim());
			String managerId = (parts.length > 3 && !parts[3].trim().isEmpty()) ? parts[3].trim() : null;

			employees.put(id, new Employee(id, name, salary, managerId));
		}

		// subordinates after all employees are created
		for (Employee e : employees.values()) {
			if (e.getManagerId() != null) {
				Employee manager = employees.get(e.getManagerId());
				if (manager != null) {
					manager.addSubordinate(e);
				} else {
					System.err.println("Warning: Manager ID " + e.getManagerId() + " not found for " + e.getName());
				}
			}
		}
		return employees;
	}

}
