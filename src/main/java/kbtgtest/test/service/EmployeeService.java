// EmployeeService.java
package kbtgtest.test.service;

import kbtgtest.test.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List < Employee > getAllEmployee();

    Employee getEmployee( Integer id );

    Employee createNewEmployee(Employee employee);

    void deleteEmployeeById(Integer id );

    Employee createNewEmployee( Employee employee );

    Employee updateEmployee( Employee employee );

    List<Employee> getAllEmployee();
}