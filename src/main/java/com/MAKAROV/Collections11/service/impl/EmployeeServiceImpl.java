package com.MAKAROV.Collections11.service.impl;

import com.MAKAROV.Collections11.exception.EmployeeAlreadyAddedException;
import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.model.Employee;
import com.MAKAROV.Collections11.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee > employeeFullName = new HashMap<>();




    @Override
    public Employee addEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, id, fio, salary, department);
        String fullName = getFullName(employee);
        if (employeeFullName.containsKey(fullName)){
            throw new EmployeeAlreadyAddedException();
        }
        employeeFullName.put(fullName, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, id, fio, salary, department);
        String fullName = getFullName(employee);
        if (!employeeFullName.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        employeeFullName.remove(fullName);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee findEmployee = new Employee(firstName, lastName, id, fio, salary, department);
        String fullName = getFullName(findEmployee);
        if (!employeeFullName.containsKey(fullName)) {
            throw new EmployeeNotFoundException();
        }
        return employeeFullName.get(fullName);
    }

    @Override
    public Collection<Employee> getAllEmployee() {
        return employeeFullName.values();
    }
    private String getFullName(Employee employee) {
        return employee.getFirstName() + employee.getLastName();
    }

}
