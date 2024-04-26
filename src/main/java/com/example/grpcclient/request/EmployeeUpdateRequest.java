package com.example.grpcclient.request;

import org.springframework.format.annotation.NumberFormat;

public class EmployeeUpdateRequest {
    @NumberFormat
    private String phoneNo;

    private Double Salary;

    private String department;

    public EmployeeUpdateRequest() {
    }

    public EmployeeUpdateRequest(String phoneNo, Double salary, String department) {
        this.phoneNo = phoneNo;
        Salary = salary;
        this.department = department;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
