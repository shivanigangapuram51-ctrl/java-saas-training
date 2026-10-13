package com.saas.training.service;

import com.saas.training.exception.EmployeeNotFoundException;
import com.saas.training.exception.InvalidOrganizationException;
import com.saas.training.exception.InvalidSalaryException;
import com.saas.training.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeService {

    // Task 16: Java Collections
    private final List<Employee> employees = new ArrayList<>();
    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private final Set<String> departments = new HashSet<>();

    // Task 17: Add Employee
    public void addEmployee(Employee employee) {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException(
                    "Employee and employee ID are required");
        }

        if (employeeMap.containsKey(employee.getId())) {
            throw new IllegalArgumentException(
                    "Employee ID already exists");
        }

        validateSalary(employee.getSalary());

        employees.add(employee);
        employeeMap.put(employee.getId(), employee);

        if (employee.getDepartment() != null
                && !employee.getDepartment().isBlank()) {
            departments.add(employee.getDepartment());
        }

        System.out.println("Employee added successfully.");
    }

    // Task 17: View Employees
    public List<Employee> viewEmployees() {
        return new ArrayList<>(employees);
    }

    // Task 17: Search Employee
    public Employee searchEmployee(Long id) {
        Employee employee = employeeMap.get(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                    "Employee not found with ID: " + id);
        }

        return employee;
    }

    // Task 17: Update Employee
    public void updateEmployee(Long id, String newName) {
        Employee employee = searchEmployee(id);

        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException(
                    "Employee name cannot be empty");
        }

        employee.setName(newName);
        System.out.println("Employee updated successfully.");
    }

    // Task 17: Delete Employee
    public void deleteEmployee(Long id) {
        Employee employee = searchEmployee(id);

        employees.remove(employee);
        employeeMap.remove(id);

        System.out.println("Employee deleted successfully.");
    }

    // Task 16: View unique departments
    public Set<String> viewDepartments() {
        return new HashSet<>(departments);
    }

    // Task 18: Validate Salary
    public void validateSalary(double salary) {
        if (salary < 0) {
            throw new InvalidSalaryException(
                    "Salary cannot be negative");
        }
    }

    // Task 18: Validate Organization
    public void validateOrganization(String organizationName) {
        if (organizationName == null || organizationName.isBlank()) {
            throw new InvalidOrganizationException(
                    "Organization name is required");
        }
    }

    // Task 18: throws example
    public Employee findEmployee(Long id)
            throws EmployeeNotFoundException {
        return searchEmployee(id);
    }
}

