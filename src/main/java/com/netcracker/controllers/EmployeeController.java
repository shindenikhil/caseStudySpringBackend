package com.netcracker.controllers;

import com.netcracker.dao.EmployeeDao;
import com.netcracker.dto.Employee;
import com.netcracker.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @RequestMapping(value = "getEmployeeRegistrationForm.html", method = RequestMethod.POST)
    public String getEmployeeRegistrationForm(Model model) {
        model.addAttribute("newEmployee", new Employee());
        List<String> listOfGrades = new ArrayList<>();
        listOfGrades.add("G1");
        listOfGrades.add("G2");
        listOfGrades.add("G3");
        listOfGrades.add("G4");
        listOfGrades.add("G5");
        listOfGrades.add("G6");
        listOfGrades.add("G7");
        model.addAttribute("grade", listOfGrades);
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        model.addAttribute("gender", gender);
        return "employeeRegistration";
    }

    @RequestMapping(value = "addNewEmployee.html", method = RequestMethod.POST)
    public String addNewEmployee(@ModelAttribute("newEmployee") Employee employee, Model model) {
        if (employeeServices.addNewEmployee(employee) == 1) {
            model.addAttribute("successMessage", "New employee successfully created");
            return "adminHomepage";
        } else {
            model.addAttribute("errorMessage", "Failed to create new Employee");
            return "redierct:getEmployeeRegistrationForm.html";
        }

    }

    @RequestMapping(value = "/showAllEmployees.html",method = RequestMethod.POST)
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeServices.getAllEmployees();
        model.addAttribute("allEmployees",allEmployees);
        return "allEmployees";
    }
}
