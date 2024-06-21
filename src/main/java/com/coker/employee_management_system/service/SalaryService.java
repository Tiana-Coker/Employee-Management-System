package com.coker.employee_management_system.service;

import com.coker.employee_management_system.model.Leave;
import com.coker.employee_management_system.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalaries();
    Salary getSalaryById(Long id);
    Salary saveSalary(Salary salary);
    Salary updateSalary(Long id, Salary salary);
    void deleteSalary(Long id);
}
