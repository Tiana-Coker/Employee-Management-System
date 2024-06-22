package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    private EmployeeService employeeService;

    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model){
        Employee employee =(Employee) session.getAttribute("employee");
        if(employee ==null){
            return "redirect:/employee-login";
        }
        model.addAttribute("employee",employee);
        return "profile";
    }
}
