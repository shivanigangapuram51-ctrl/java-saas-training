
package com.saas.training.model;

public class Employee extends User {

    private String phone;
    private double salary;
    private String department;
    private String status;

    public Employee() {
        super();
    }

    public Employee(Long id, String name) {
        super(id, name, null);
    }

    public Employee(Long id, String name,
                    String email, double salary) {
        super(id, name, email);
        setSalary(salary);
    }

    @Override
    public String getRole() {
        return "EMPLOYEE";
    }

    @Override
    public void showPermissions() {
        System.out.println("View own profile");
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative");
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}




