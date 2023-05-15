package com.nhlamulo.NasworldSpring.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //SELECT * FROM employee WHERE email=?
    @Query("Select s FROM Employee s WHERE s.email=?1")
    Optional<Employee>findEmployeeByEmail(String email);

}
