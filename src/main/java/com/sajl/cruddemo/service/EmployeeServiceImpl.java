package com.sajl.cruddemo.service;

import com.sajl.cruddemo.dao.EmployeeDAO;
import com.sajl.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService
{
    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById( id );
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save( employee );
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        employeeDAO.deleteById( id );
    }
}
