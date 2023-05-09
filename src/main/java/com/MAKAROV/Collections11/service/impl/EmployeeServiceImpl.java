package com.MAKAROV.Collections11.service.impl;

import com.MAKAROV.Collections11.exception.EmployeeAlreadyAddedException;
import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.model.Employee;
import com.MAKAROV.Collections11.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;
    public EmployeeServiceImpl(){
        employees = new ArrayList<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, id, fio,salary, department);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee employee = new Employee(firstName, lastName, id, fio,salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department) {
        Employee findEmployee = new Employee(firstName, lastName, id, fio,salary, department);
        for (Employee employee : employees) {
            if (employee.equals(findEmployee)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

}
