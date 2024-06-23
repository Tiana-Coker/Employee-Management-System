package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.enums.Department;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.repository.EmployeeRepository;
import com.coker.employee_management_system.service.EmployeeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
}

      @GetMapping("/add-employee")
      public String showAddEmployeeForm(){
        return "add-employee";
      }

      @PostMapping("/add-employee")
      public String addEmployee(HttpServletRequest request, Model model){
          String firstName = request.getParameter("firstName");
          String lastName = request.getParameter("lastName");
          Department department = Department.valueOf(request.getParameter("department"));
          Double salary = Double.valueOf(request.getParameter("salary"));
          String username = request.getParameter("username");
          String email = request.getParameter("email");
          String password = request.getParameter("password");

          Employee employee = new Employee();
          employee.setFirstName(firstName);
          employee.setLastName(lastName);
          employee.setDepartment(department);
          employee.setSalary(salary);
          employee.setUsername(username);
          employee.setEmail(email);
          employee.setPassword(password);

          employeeRepository.save(employee);
          return "redirect:/admin-dashboard";

      }


     @GetMapping("/view-employees")
     public String viewEmployees(Model model){
         List<Employee>employees = employeeRepository.findAllExcludingAdmins();
        model.addAttribute("employees",employees);
        return "view-employees";
     }

}
