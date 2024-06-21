package com.coker.employee_management_system.repository;

import com.coker.employee_management_system.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
