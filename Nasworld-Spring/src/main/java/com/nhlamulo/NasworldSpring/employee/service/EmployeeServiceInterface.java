package com.nhlamulo.NasworldSpring.employee.service;

import com.nhlamulo.NasworldSpring.employee.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    List<Employee> getEmployees();

    void addNewEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    void updateEmployee(Long employeeId, String name, String email);
}

