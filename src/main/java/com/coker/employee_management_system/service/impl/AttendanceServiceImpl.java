package com.coker.employee_management_system.service.impl;

import com.coker.employee_management_system.enums.AttendanceStatus;
import com.coker.employee_management_system.model.Attendance;
import com.coker.employee_management_system.model.Employee;
import com.coker.employee_management_system.repository.AttendanceRepository;
import com.coker.employee_management_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance markAttendance(Employee employee) {
        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(LocalDate.now());
        attendance.setClockInTime(LocalDateTime.now());
        attendance.setAttendanceStatus(AttendanceStatus.Present);

        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance markClockOut(Employee employee){
        Attendance attendance = attendanceRepository.findTopByEmployeeOrderByClockInTimeDesc(employee);
        if(attendance != null && attendance.getClockOutTime() == null){
            attendance.setClockOutTime(LocalDateTime.now());
            attendanceRepository.save(attendance);
        }
        return attendance;
    }



    @Override
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findByEmployee(employee);
    }


}
