package com.coker.employee_management_system.repository;

import com.coker.employee_management_system.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
