package com.sajl.cruddemo.dao;

import com.sajl.cruddemo.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO
{

    List<Employee> findAll();
    Employee findById (Integer id );
    Employee save(Employee employee );
    void deleteById(Integer id );

}
