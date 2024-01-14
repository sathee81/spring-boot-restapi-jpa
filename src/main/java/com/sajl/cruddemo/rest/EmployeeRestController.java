package com.sajl.cruddemo.rest;

import com.sajl.cruddemo.dao.EmployeeDAO;
import com.sajl.cruddemo.entity.Employee;
import com.sajl.cruddemo.exception.EmployeeNotFoundException;
import com.sajl.cruddemo.exception.EmployeeResponse;
import com.sajl.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class EmployeeRestController
{
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController ( EmployeeService theEmployeeService )
    {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll( )
    {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable("id") int id )
    {
        Employee employee = employeeService.findById( id );
        if ( Objects.isNull( employee ) )
        {
            throw new EmployeeNotFoundException("Employee id not found - " + id );
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee )
    {
        return employeeService.save( employee );
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int id  )
    {
        System.out.println( "Employee Id to Update : " + id );
        return employeeService.save( employee );
    }

    @DeleteMapping("/employees/{id}")
    public EmployeeResponse deleteEmployee( @PathVariable("id") int id )
    {
        Employee employee = employeeService.findById( id );
        if ( employee == null )
        {
            throw new EmployeeNotFoundException("Employee id not found - " + id );
        }
        employeeService.deleteById( id );
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setStatus(HttpStatus.ACCEPTED.value());
        employeeResponse.setMessage( "Employee Id " + id + " Deleted ");
        employeeResponse.setTimestamp( System.currentTimeMillis() );
        return employeeResponse;
    }

    /*


    @PutMapping("/employees/{id}")
    public Employee updateEmployee ( @RequestBody Employee employee,@PathVariable long id )
    {
        Employee theEmployee = employeeDAO.findById( id ).get();
        if ( Objects.isNull( theEmployee ) )
        {
            throw new EmployeeNotFoundException("Employee id not found - " + id );
        }
        theEmployee.setLastName( employee.getLastName() );
        theEmployee.setFirstName( employee.getFirstName() );
        theEmployee.setEmail( employee.getEmail() );
        return employeeDAO.update( theEmployee );
    }



   */

}
