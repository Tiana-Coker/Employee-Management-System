package com.coker.employee_management_system.repository;

import com.coker.employee_management_system.model.Attendance;
import com.coker.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployee(Employee employee);
    Attendance findTopByEmployeeOrderByClockInTimeDesc(Employee employee);
}
