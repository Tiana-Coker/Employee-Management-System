package com.coker.employee_management_system.service.impl;

import com.coker.employee_management_system.enums.LeaveStatus;
import com.coker.employee_management_system.enums.LeaveType;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.model.LeaveRequest;
import com.coker.employee_management_system.repository.LeaveRequestRepository;
import com.coker.employee_management_system.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Override
    public LeaveRequest requestLeave(Employee employee, LeaveType leaveType, LocalDate start_date, LocalDate end_date) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployee(employee);
        leaveRequest.setLeaveType(leaveType);
        leaveRequest.setStart_date(start_date);
        leaveRequest.setEnd_date(end_date);
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> getLeaveRequestByEmployee(Employee employee) {
        return leaveRequestRepository.findByEmployee(employee);
    }

    @Override
    public LeaveRequest updateLeaveStatus(Long id, LeaveStatus leaveStatus) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequest.setLeaveStatus(leaveStatus);
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }
}
