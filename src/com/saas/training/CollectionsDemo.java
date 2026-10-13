
package com.saas.training;

import com.saas.training.model.Employee;
import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Map<Long, Employee> employeeMap = new HashMap<>();
        Set<String> departments = new HashSet<>();

        Employee e1 = new Employee(
                101L, "Shivani", "shivani@example.com", 30000
        );

        Employee e2 = new Employee(
                102L, "Rahul", "rahul@example.com", 35000
        );

        e1.setDepartment("IT");
        e2.setDepartment("HR");

        employees.add(e1);
        employees.add(e2);

        employeeMap.put(e1.getId(), e1);
        employeeMap.put(e2.getId(), e2);

        departments.add("IT");
        departments.add("HR");
        departments.add("IT");

        System.out.println("--- Employees ---");
        for (Employee employee : employees) {
            System.out.println(
                    employee.getId() + " - " + employee.getName()
            );
        }

        System.out.println("\n--- Search by ID ---");
        System.out.println(employeeMap.get(101L).getName());

        System.out.println("\n--- Departments ---");
        System.out.println(departments);
    }
}

