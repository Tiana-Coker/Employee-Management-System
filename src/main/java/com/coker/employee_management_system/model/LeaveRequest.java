package com.coker.employee_management_system.model;

import com.coker.employee_management_system.enums.LeaveStatus;
import com.coker.employee_management_system.enums.LeaveType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "leave_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private LocalDate start_date;
    private LocalDate end_date;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus =LeaveStatus.Pending;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
