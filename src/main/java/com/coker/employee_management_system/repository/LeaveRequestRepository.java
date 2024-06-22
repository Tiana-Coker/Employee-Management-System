package com.coker.employee_management_system.repository;

import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByEmployee(Employee employee);
}
