package com.coker.employee_management_system.service.impl;

import com.coker.employee_management_system.model.Salary;
import com.coker.employee_management_system.repository.SalaryRepository;
import com.coker.employee_management_system.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    @Override
    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id).orElse(null);
    }

    @Override
    public Salary saveSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public Salary updateSalary(Long id, Salary salary) {
        Salary existingSalary = salaryRepository.findById(id).orElse(null);
        if (existingSalary != null) {
            existingSalary.setBaseSalary(salary.getBaseSalary());
            existingSalary.setBonus(salary.getBonus());
            existingSalary.setPaymentDate(salary.getPaymentDate());
            return salaryRepository.save(existingSalary);
        }
        return null;
    }

    @Override
    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}
