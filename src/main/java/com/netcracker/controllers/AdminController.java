package com.netcracker.controllers;

import com.netcracker.dto.Admin;
import com.netcracker.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @RequestMapping("/index.html")
    public String getLoginForm(Model model){
        model.addAttribute("admin",new Admin());
        return "login";
    }

    @RequestMapping(value = "/verifyAdmin.html",method = RequestMethod.POST)
    public String verifyAdmin(@ModelAttribute("admin") Admin admin,Model model){
        if(adminServices.getAdminByUsernameAndPassword(admin)!=null){
            return "adminHomepage";
        }
        return "redirect:index.html";
    }
}
