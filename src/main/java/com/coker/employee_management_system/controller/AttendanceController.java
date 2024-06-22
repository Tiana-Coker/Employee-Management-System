package com.coker.employee_management_system.controller;


import com.coker.employee_management_system.model.Attendance;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.service.AttendanceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/attendance")
    public String showAttendance(HttpSession session, Model model){
        Employee employee =(Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/employee-login";
        }
        model.addAttribute("attendances", attendanceService.getAttendanceByEmployee(employee));
        return "attendance";
    }

    @PostMapping("/mark-attendance")
    public String markAttendance(HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/employee-login";
        }
        attendanceService.markAttendance(employee);
        return "redirect:/attendance";
    }

    @PostMapping("/clock-out")
    public String clockOut(HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/employee-login";
        }
        attendanceService.markClockOut(employee);
        return "redirect:/attendance";
    }
}
