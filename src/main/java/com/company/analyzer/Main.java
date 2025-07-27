package com.company.analyzer;

import java.util.Map;

import com.company.analyzer.model.Employee;
import com.company.analyzer.service.EmployeeAnalyzer;
import com.company.analyzer.util.CsvReader;

public class Main {
	public static void main(String[] args) {
		try {
			String filePath = "src/main/resources/employees.csv";
			Map<String, Employee> employees = CsvReader.loadEmployees(filePath);

			EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
			analyzer.analyze(employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
