package com.coker.employee_management_system.service;

import com.coker.employee_management_system.enums.AttendanceStatus;
import com.coker.employee_management_system.model.Attendance;
import com.coker.employee_management_system.model.Employee;

import java.util.List;

public interface AttendanceService {
    Attendance markAttendance(Employee employee);
    List<Attendance> getAttendanceByEmployee(Employee employee);
    Attendance markClockOut(Employee employee);
    List<Attendance>getAllAttendances();
}
