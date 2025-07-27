package com.company.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.company.analyzer.model.Employee;
import com.company.analyzer.util.CsvReader;

public class CsvReaderTest {

    @Test
    public void testCsvLoading() throws Exception {
        Map<String, Employee> employees = CsvReader.loadEmployees("src/main/resources/employees.csv");
        assertEquals(6, employees.size());
        assertEquals("John", employees.get("1").getName());
    }
}
