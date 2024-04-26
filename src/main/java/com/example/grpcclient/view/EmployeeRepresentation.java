package com.example.grpcclient.view;

import java.util.Date;

public class EmployeeRepresentation {

    private int EmployeeID;
    private String name;
    private String email;
    private String phoneNo;
    private String hireDate;
    private double salary;
    private String department;


    public EmployeeRepresentation() {
    }

    public EmployeeRepresentation(int employeeID, String name, String email, String phoneNo, String hireDate, double salary, String department) {
        EmployeeID = employeeID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
