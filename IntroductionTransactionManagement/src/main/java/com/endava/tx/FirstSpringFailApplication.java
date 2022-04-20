//package com.endava.tx;
//
//import com.endava.tx.entity.Employee;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@SpringBootApplication
//@Slf4j
//public class FirstSpringFailApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(FirstSpringFailApplication.class, args);
//    }
//
//
//    @Bean
//    public CommandLineRunner initFailOne(SimpleEmployeeService service) {
//        return args -> {
//            log.info("Batch creating employees");
//            service.batchCreate(Arrays.asList(
//                    Employee.builder().username("alexandru").build(),
//                    Employee.builder().username("dumitru").build()
//            ));
//            log.info("Finding all employees");
//            final Stream<Employee> employeeStream = service.findAll();
//            log.info("All emplyees: {}",employeeStream.collect(Collectors.toList()));
//        };
//    }
//}
//
