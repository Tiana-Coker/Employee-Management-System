package com.coker.employee_management_system.service;

import com.coker.employee_management_system.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee( Employee employee);
    void deleteEmployeeById(Long id);
}
