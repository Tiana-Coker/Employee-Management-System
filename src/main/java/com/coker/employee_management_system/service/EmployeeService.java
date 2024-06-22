package com.coker.employee_management_system.service;

import com.coker.employee_management_system.model.Employee;

public interface EmployeeService {
    Employee findByUsername(String username);
    Employee saveEmployee(Employee employee);
}
