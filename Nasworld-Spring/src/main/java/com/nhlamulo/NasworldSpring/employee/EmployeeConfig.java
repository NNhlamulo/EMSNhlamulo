package com.nhlamulo.NasworldSpring.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args->{
           Employee nhlamulo=new Employee(
                    "Nhlamulo",
                    "royaltrsa@gamil.com",
                    LocalDate.of(1996, Month.MAY,22) );

           Employee shaun = new Employee(
                   "Shaun",
                   "Shaun@gamail.com",
                   LocalDate.of(1996,Month.JUNE,23)

           );

            Employee delight = new Employee(
                    "Delight",
                    "Delight@gamail.com",
                    LocalDate.of(1996,Month.APRIL,12)

            );

            repository.saveAll(
                   List.of(nhlamulo,shaun,delight)
           );

        };
    }
}
