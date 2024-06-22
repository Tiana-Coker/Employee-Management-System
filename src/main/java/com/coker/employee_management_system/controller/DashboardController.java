package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee-dashboard")
    public String showDashboard(HttpSession session, Model model){
        Employee employee =(Employee)session.getAttribute("employee");
        if(employee == null){
            return "redirect:/employee-login";
        }
        model.addAttribute("employee", employee);
        model.addAttribute("name", employee.getFirstName());
        model.addAttribute("lastname",employee.getLastName());
        return "employee-dashboard";
    }
}
