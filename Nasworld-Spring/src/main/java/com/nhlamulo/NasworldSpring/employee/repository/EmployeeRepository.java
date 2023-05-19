package com.nhlamulo.NasworldSpring.employee.repository;

import com.nhlamulo.NasworldSpring.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Optional<Employee>findEmployeeByEmail(String email);

}
