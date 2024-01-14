package com.sajl.cruddemo.dao;

import com.sajl.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements  EmployeeDAO
{
    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        TypedQuery<Employee> theQuery = entityManager.createQuery( "From Employee order by lastName asc" , Employee.class );
        return theQuery.getResultList();
    }


    @Override
    public Employee findById(Integer id)
    {
        return entityManager.find(Employee.class , id );
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge( employee );
    }

    @Override
    public void deleteById(Integer id)
    {
        Employee employee = entityManager.find(Employee.class , id );
        entityManager.remove( employee );
    }
}
