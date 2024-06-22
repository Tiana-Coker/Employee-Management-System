package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee-login")
    public String showLoginForm(){
        return "employee-login";
    }

    @PostMapping("/employee-login")
    public String login(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = employeeRepository.findByUsername(username);

        if(employee != null && employee.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            model.addAttribute("name", employee.getFirstName());
            model.addAttribute("lastname",employee.getLastName());
            return "employee-dashboard";
        }else{
            model.addAttribute("error","Invalid username or password");
            return "employee-login";
        }
    }


     @GetMapping("/employee-logout")
        public String logout(HttpSession session){
            session.invalidate();
            return "redirect:/employee-login";
}       }
