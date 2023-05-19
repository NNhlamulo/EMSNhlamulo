package com.nhlamulo.NasworldSpring.employee.config;

import com.nhlamulo.NasworldSpring.employee.entity.Employee;
import com.nhlamulo.NasworldSpring.employee.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args->{
           Employee nhlamulo=new Employee(1L,UUID.randomUUID(),
                    "Nhlamulo",
                    "royaltrsa@gamil.com",
                    LocalDate.of(1996, Month.MAY,22),27 );

           Employee shaun = new Employee(2L,UUID.randomUUID(),
                   "Shaun",
                   "Shaun@gamail.com",
                   LocalDate.of(1996,Month.JUNE,23),27

           );

            Employee delight = new Employee(3L,UUID.randomUUID(),
                    "Delight",
                    "Delight@gamail.com",
                    LocalDate.of(1996,Month.APRIL,12), 27

            );

            repository.saveAll(
                   List.of(nhlamulo,shaun,delight)
           );

        };
    }
}
