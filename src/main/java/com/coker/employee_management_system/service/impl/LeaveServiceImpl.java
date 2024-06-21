package com.coker.employee_management_system.service.impl;

import com.coker.employee_management_system.model.Leave;
import com.coker.employee_management_system.repository.LeaveRepository;
import com.coker.employee_management_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    @Override
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public Leave updateLeave(Long id, Leave leave) {
        Leave existingLeave = leaveRepository.findById(id).orElse(null);
        if (existingLeave != null) {
            existingLeave.setLeaveType(leave.getLeaveType());
            existingLeave.setStart_date(leave.getStart_date());
            existingLeave.setEnd_date(leave.getEnd_date());
            existingLeave.setLeaveStatus(leave.getLeaveStatus());
            return leaveRepository.save(existingLeave);
        }
        return null;
    }

    @Override
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
