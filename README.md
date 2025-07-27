# BigCompany Analyzer

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Maven](https://img.shields.io/badge/Maven-Build-brightgreen)
![JUnit](https://img.shields.io/badge/Tested%20with-JUnit5-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

## 📌 Overview
BigCompany Analyzer is a **Java SE console application** that analyzes an organization's hierarchy.  
It ensures:
- Managers earn **at least 20% more** and **no more than 50% more** than their subordinates' average salary.
- Detects employees with a **reporting line longer than allowed** (more than 4 managers between them and the CEO).

✅ This project was developed as part of a coding exercise for a hiring process.

---

## ✅ Features
- Reads employee data from a **CSV file**.
- Reports:
  - Managers earning **less or more than allowed**.
  - Employees with **too many managers above them**.
- Outputs results to **console**.
- Includes **unit tests** using JUnit 5.

---

## 🛠️ Tech Stack
- **Java 11+**
- **Maven** (for build & dependency management)
- **JUnit 5** (for testing)

---
---

## 🧾 Assumptions
- The input file `employees.csv` is well-formed with the following columns:  
  `ID, Name, Salary, ManagerID`
- The CEO is the only employee with no `ManagerID` specified (root of the hierarchy).
- Salaries are numeric and provided in the same currency.
- The reporting line depth rule is: **more than 4 managers between an employee and the CEO is considered too long**.
- For salary validation:
  - A manager should earn at least **20% more** and at most **50% more** than the average salary of their direct subordinates.
- If a ManagerID in the file does not exist in the data set, a warning will be logged, and that relationship is skipped.
- Maximum input size: **up to 1000 employees**, as stated in the problem statement.
- No GUI or web interface; results are printed to **console only**.


## ▶️ How to Run
Clone the repository:
```bash
git clone https://github.com/kumarhegde76/bigcompany-analyzer.git
cd bigcompany-analyzer

Build the project:
mvn clean install

Run the application:
mvn exec:java -Dexec.mainClass="com.company.analyzer.Main"



## 🛠️ Structure
bigcompany-analyzer
 ├── src
 │   ├── main
 │   │   ├── java/com/company/analyzer
 │   │   │   ├── Main.java
 │   │   │   ├── model/Employee.java
 │   │   │   ├── service/EmployeeAnalyzer.java
 │   │   │   └── util/CsvReader.java
 │   │   └── resources/employees.csv
 │   └── test
 │       └── java/com/company/analyzer/CsvReaderTest.java
 ├── pom.xml
 └── README.md
