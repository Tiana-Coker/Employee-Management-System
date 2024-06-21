package com.coker.employee_management_system.service;

import com.coker.employee_management_system.model.Leave;

import java.util.List;

public interface LeaveService {
    List<Leave> getAllLeaves();
    Leave getLeaveById(Long id);
    Leave saveLeave(Leave leave);
    Leave updateLeave(Long id, Leave leave);
    void deleteLeave(Long id);

}
