package com.coker.employee_management_system.model;

import com.coker.employee_management_system.enums.LeaveStatus;
import com.coker.employee_management_system.enums.LeaveType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "leave_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    private String start_date;
    private String end_date;

    @Enumerated(EnumType.STRING)
    private LeaveStatus leaveStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
