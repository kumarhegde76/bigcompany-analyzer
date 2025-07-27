# BigCompany Analyzer

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Maven](https://img.shields.io/badge/Maven-Build-brightgreen)
![JUnit](https://img.shields.io/badge/Tested%20with-JUnit5-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

## 📌 Overview
A **Java SE console application** for analyzing organizational structures in a company.  
It ensures:
- Managers earn **at least 20% more** and **no more than 50% more** than their subordinates' average salary.
- Detects employees with a **reporting line longer than allowed**.

This project solves **Code Exercise 106** as part of the Swiss Re hiring process.

---

## ✅ Features
- Reads employee data from a **CSV file**.
- Detects:
  - Managers earning **less or more than allowed**.
  - Employees with **too many managers above them**.
- Outputs results to **console**.
- Includes **unit tests** using JUnit 5.

---

## 🛠️ Tech Stack
- **Java 11+**
- **Maven**
- **JUnit 5** for testing

---

## ▶️ How to Run
Clone the repository:
```bash
git clone https://github.com/kumarhegde76/bigcompany-analyzer.git
cd bigcompany-analyzer
