package com.netcracker.services;

import com.netcracker.dao.EmployeeDao;
import com.netcracker.dto.Employee;
import com.netcracker.utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeDao employeeDao;

    public int addNewEmployee(Employee employee){
        return employeeDao.addNewEmployee(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeDao.getAllEmployees();
    }
}
