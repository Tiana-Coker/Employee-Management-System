package com.coker.employee_management_system.controller;

import com.coker.employee_management_system.enums.LeaveStatus;
import com.coker.employee_management_system.enums.LeaveType;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.model.LeaveRequest;
import com.coker.employee_management_system.service.LeaveRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class LeaveRequestController {
    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping("/leave-requests")
    public String showLeaveRequests(HttpSession session, Model model){
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/employee-login";
        }
        model.addAttribute("leaveRequests",leaveRequestService.getLeaveRequestByEmployee(employee));
        return "leave-requests";
    }
    @PostMapping("/request-leave")
    public String requestLeave(HttpSession session,
                               @RequestParam("leaveType") LeaveType leaveType,
                               @RequestParam("start_date") LocalDate start_date,
                               @RequestParam("end_date") LocalDate end_date){
        Employee employee =(Employee) session.getAttribute("employee");
        if(employee==null){
            return "redirect:/employee-login";
        }
        leaveRequestService.requestLeave(employee, leaveType, start_date, end_date);
        return "redirect:/leave-requests";
    }

    @GetMapping("/view-leave-requests")
    public String viewAllLeaveRequests(Model model, HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee == null){
            return "redirect:/admin-login";
        }
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        model.addAttribute("leaveRequests", leaveRequests);
        return "view-leave-requests";
    }

    @PostMapping("/update-leave-status")
    public String updateLeaveStatus(@RequestParam Long leaveRequestId,
                                    @RequestParam LeaveStatus leaveStatus){
        leaveRequestService.updateLeaveStatus(leaveRequestId, leaveStatus);
        return "redirect:/view-leave-requests";
    }
}
