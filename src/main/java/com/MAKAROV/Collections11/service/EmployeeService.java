package com.MAKAROV.Collections11.service;

import com.MAKAROV.Collections11.model.Employee;



public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
   void removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

}
