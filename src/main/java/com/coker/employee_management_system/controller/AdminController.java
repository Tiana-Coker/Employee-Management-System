package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.repository.EmployeeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/admin-login")
    public String showLoginForm(){
        return "admin-login";
    }

    @PostMapping("/admin-login")
    public String login(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = employeeRepository.findByUsername(username);

        if(employee != null && employee.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            model.addAttribute("name", employee.getUsername());
            return "admin-dashboard";
        }else{
            model.addAttribute("error","Invalid username or password");
            return "admin-login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin-login";
    }



    @GetMapping("/admin-dashboard")
    public String showAdminDashboard(HttpSession session, Model model){
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/admin-login";
        }
        String name = (String) session.getAttribute("name");
        model.addAttribute("name", name);
        return "admin-dashboard";
    }

}
