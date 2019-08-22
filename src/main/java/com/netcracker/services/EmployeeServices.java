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

    public String addNewEmployee(Employee employee) {
        if (employee.getEmployeeId()==null){
            return "Invalid employee id";
        }else{
            if(employee.getDepartmentId()==null){
                return "Invalid department Id";
            }else{
                if (employee.getBasePay()==null){
                    return "Invalid salary entered";
                }
            }
        }
        return employeeDao.addNewEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(Integer employeeId) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        return employeeDao.getEmployeeById(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }
}
