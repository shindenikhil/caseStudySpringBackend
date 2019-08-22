package com.netcracker.utility;

public class Constant {

    public static String getAdminByUsernameAndPassword = "SELECT COUNT(*) FROM admin WHERE USERNAME=? AND PASSWORD = ?";
    public static String addNewEmployee = "INSERT INTO EMPTABLE VALUES(?,?,?,?,?,?,?,?,?,?)";
    public static String getAllEmployees = "SELECT * FROM emptable";
}
