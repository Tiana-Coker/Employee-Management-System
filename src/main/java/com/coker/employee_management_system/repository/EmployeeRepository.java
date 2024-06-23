package com.coker.employee_management_system.repository;

import com.coker.employee_management_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByUsername(String username);

    @Query("SELECT u FROM Employee u WHERE u.email NOT LIKE '%@admin.com'")
    List<Employee>findAllExcludingAdmins();
}
