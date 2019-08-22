package com.netcracker.utility;

public class Constant {

    public static String getAdminByUsernameAndPassword = "SELECT COUNT(*) FROM admin WHERE USERNAME=? AND PASSWORD = ?";
    public static String addNewEmployee = "INSERT INTO EMPTABLE VALUES(?,?,?,?,?,?,?,?,?,?)";
    public static String getAllEmployees = "SELECT * FROM emptable";
    public static String getEmployeeById = "SELECT * FROM emptable WHERE EMPLOYEE_ID = ?";
    public static String updateEmployeeById = "UPDATE EMPTABLE" + " SET first_name = ?," +
            "last_name = ?," +
            "date_of_joining = ?," +
            "date_of_birth = ?," +
            "department_id = ?," +
            "grade = ?," +
            "designation = ?," +
            "gender = ?," +
            "base_pay = ? " +
            "WHERE employee_id = ?";
}
