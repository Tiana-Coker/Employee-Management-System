package com.coker.employee_management_system.service;

import com.coker.employee_management_system.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findByUsername(String username);
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
