package com.netcracker.dto;

import lombok.Data;

@Data
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String dateOfJoining;
    private String dateOfBirth;
    private String departmentId;
    private String grade;
    private String designation;
    private String gender;
    private int basePay;
}
