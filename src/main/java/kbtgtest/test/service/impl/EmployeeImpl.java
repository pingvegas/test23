package kbtgtest.test.service.impl;

import kbtgtest.test.entity.Employee;
import kbtgtest.test.exception.NotFoundResourceException;
import kbtgtest.test.repository.EmployeeRepository;
import kbtgtest.test.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List < Employee > getAllEmployee()
    {
        return EmployeeRepository.findAll();
    }


    public Employee getEmployeeById( Integer id )
    {
        Optional < Employee > todoItem = EmployeeRepository.findById( id );
        if ( todoItem.isPresent() )
        {
            return todoItem.get();
        }
        throw new NotFoundResourceException( "Employee not found ID: " + id );
    }



    @Override
    public Employee createNewEmployee(Employee employee) {
        return null;
    }


    @Override
    public void deleteEmployeeById( Integer id )
    {
        Optional < Employee > todoItem = EmployeeRepository.findById( id );
        if ( todoItem.isEmpty() )
        {
            throw new NotFoundResourceException( "TodoItem not found ID: " + id );
        }
        EmployeeRepository.delete( todoItem.get() );
    }


    public Employee createNewEmployee( Employee employee )
    {
        return EmployeeRepository.save( employee );
    }

    @Override
    public Employee updateEmployee( Employee updatedEmployee )
    {
        return EmployeeRepository.save( updatedEmployee );
    }
}
