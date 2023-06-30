package com.MAKAROV.Collections11.controller;

import com.MAKAROV.Collections11.exception.EmployeeNotFoundException;
import com.MAKAROV.Collections11.model.Employee;
import com.MAKAROV.Collections11.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam Integer id, @RequestParam String fio, @RequestParam Integer salary, @RequestParam Integer department) {
        return employeeService.addEmployee(firstName, lastName, id, fio,salary, department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam Integer id, @RequestParam String fio, @RequestParam Integer salary, @RequestParam Integer department) {
        return employeeService.removeEmployee(firstName, lastName, id, fio,salary, department);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,@RequestParam Integer id, @RequestParam String fio, @RequestParam Integer salary, @RequestParam Integer department) {
        Employee employee = employeeService.findEmployee(firstName, lastName, id, fio,salary, department);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
}
