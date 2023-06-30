package com.MAKAROV.Collections11.service;

import com.MAKAROV.Collections11.model.Employee;

import java.util.Collection;


public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department);


    Employee removeEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department);

    Employee findEmployee(String firstName, String lastName, Integer id, String fio, Integer salary, Integer department);

    Collection<Employee> getAllEmployee();
}
