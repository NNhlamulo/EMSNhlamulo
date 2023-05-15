package com.nhlamulo.NasworldSpring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("api/nasworld")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();


    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);

    }

    @DeleteMapping(path ="{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id){
        employeeService.deleteEmployee(id);

    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        employeeService.updateEmployee(employeeId,name,email);
    }

    }