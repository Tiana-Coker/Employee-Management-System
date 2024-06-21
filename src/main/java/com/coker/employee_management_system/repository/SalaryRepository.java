package com.coker.employee_management_system.repository;


import com.coker.employee_management_system.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
