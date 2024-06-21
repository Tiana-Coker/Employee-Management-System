package com.coker.employee_management_system.service.impl;

import com.coker.employee_management_system.model.Attendance;
import com.coker.employee_management_system.repository.AttendanceRepository;
import com.coker.employee_management_system.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(id).orElse(null);
        if (existingAttendance != null) {
            existingAttendance.setAttendanceStatus(attendance.getAttendanceStatus());
            existingAttendance.setDate(attendance.getDate());
            existingAttendance.setTime_in(attendance.getTime_in());
            existingAttendance.setTime_out(attendance.getTime_out());
            return attendanceRepository.save(existingAttendance);
        }
        return null;
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
