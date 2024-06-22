package com.coker.employee_management_system.service;

import com.coker.employee_management_system.enums.LeaveStatus;
import com.coker.employee_management_system.enums.LeaveType;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.model.LeaveRequest;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestService {
    LeaveRequest requestLeave(Employee employee, LeaveType leaveType, LocalDate start_date, LocalDate end_date);
    List<LeaveRequest> getLeaveRequestByEmployee(Employee employee);
    LeaveRequest updateLeaveStatus(Long id, LeaveStatus leaveStatus);
    List<LeaveRequest>getAllLeaveRequests();
}
