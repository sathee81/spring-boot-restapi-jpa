package com.sajl.cruddemo.service;

import com.sajl.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> findAll();
    Employee findById (Integer id );
    Employee save(Employee employee );
    void deleteById(Integer id );
}
