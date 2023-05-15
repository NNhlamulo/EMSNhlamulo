package com.nhlamulo.NasworldSpring.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();

    }

    public void addNewEmployee(Employee employee) {
        //System.out.println(employee);
        Optional<Employee> employeeOptional =employeeRepository
                .findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
       employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {

      boolean exists=  employeeRepository.existsById(employeeId);
      if(!exists){
          throw new IllegalStateException("employee with id "+ employeeId + "does not exist");
      }
      employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Long employeeId, String name, String email) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalStateException(
                "employee with id "+employeeId+ "does not exist"
        ));
        if(name !=null && name.length()>0 && !Objects.equals(employee.getName(), name)){
            employee.setName(name);
        }
        if(email !=null && email.length()>0 && !Objects.equals(employee.getEmail(), email)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            employee.setEmail(email);
        }
    }
}
