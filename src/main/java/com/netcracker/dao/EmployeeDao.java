package com.netcracker.dao;

import com.netcracker.dto.Employee;
import com.netcracker.utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RowMapper<Employee> employeeRowMapper = (resultSet, rowNumber)-> {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
        employee.setFirstName(resultSet.getString("FIRST_NAME"));
        employee.setLastName(resultSet.getString("LAST_NAME"));
        employee.setDateOfJoining(String.valueOf(resultSet.getDate("DATE_OF_JOINING")));
        employee.setDateOfBirth(String.valueOf(resultSet.getDate("DATE_OF_BIRTH")));
        employee.setDepartmentId(String.valueOf(resultSet.getInt("DEPARTMENT_ID")));
        employee.setGrade(resultSet.getString("GRADE"));
        employee.setDesignation(resultSet.getString("DESIGNATION"));
        employee.setGender(resultSet.getString("GENDER"));
        employee.setBasePay(resultSet.getInt("BASE_PAY"));
        return employee;
    };

    public int addNewEmployee(Employee employee) {
        Object[] objects = new Object[]{
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                java.sql.Date.valueOf(employee.getDateOfJoining().toString()),
                java.sql.Date.valueOf(employee.getDateOfBirth().toString()),
                employee.getDepartmentId(),
                employee.getGrade(),
                employee.getDesignation(),
                employee.getGender(),
                employee.getBasePay()
        };
        return jdbcTemplate.update(Constant.addNewEmployee,objects);
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query(Constant.getAllEmployees,employeeRowMapper);
    }

}
