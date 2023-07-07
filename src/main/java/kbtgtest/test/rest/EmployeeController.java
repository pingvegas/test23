package kbtgtest.test.rest;


import kbtgtest.test.entity.Employee;
import kbtgtest.test.service.EmployeeService;
import kbtgtest.test.service.impl.EmployeeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById( @PathVariable int employeeId )
    {
        Employee employee = employeeService.findById( employeeId );

        if ( employee == null )
        {
            throw new RuntimeException( "Employee id not found - " + employeeId );
        }

        return employee;
    }

    @DeleteMapping ( "/employees/{employeeId}" )
    public String deleteEmployeeId( @PathVariable int employeeId )
    {
        Employee employee = employeeService.findById( employeeId );

        if ( employee == null )
        {
            throw new RuntimeException( "Employee id not found - " + employeeId );
        }

        employeeService.deleteById( employeeId );

        return "Deleted employee id - " + employeeId;
    }

    @PostMapping ( "/employees" )
    public Employee addEmployees( @RequestBody Employee employee )
    {
        employee.setId( 0 );

        Employee newEmployee = employeeService.save( employee );

        return newEmployee;
    }


}
