//package com.endava.tx;
//
//import com.endava.tx.entity.Employee;
//import com.endava.tx.repo.EmployeeDAO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AdviceMode;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.EnableLoadTimeWeaving;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//@SpringBootApplication
//@Slf4j
////Load time weaving
//@EnableTransactionManagement(mode= AdviceMode.ASPECTJ)
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
//public class ThirdSpringFailApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ThirdSpringFailApplication.class, args);
//    }
//
//
//    @Bean
//    public CommandLineRunner initFailOne(BatchEmployeeService service) {
//        return args -> {
//            log.info("Batch creating employees");
//            service.batchCreate(Arrays.asList(
//                    Employee.builder().username("alexandru35").build(),
//                    Employee.builder().username("dumitru35").build()
//            ));
//            log.info("Finding all employees");
//        };
//    }
//
//    @Service
//    @Slf4j
//    public static class BatchEmployeeService {
//
////        @Autowired
////        private BatchEmployeeService proxy;
//
//        @Autowired
//        private EmployeeDAO employeeDAO;
//
//
//        @Transactional(propagation = Propagation.REQUIRES_NEW)
//        public Employee create(Employee employee) {
//            //will not create a proxy with weaving
//            //will add instructions for transaction create
//            log.info("Creating an employee");
//            return employeeDAO.save(employee);
//
//            //commit
//        }
//
//        @Transactional
//        public Collection<Employee> batchCreate(Collection<Employee> employees) {
//            log.info("Batch creating users");
//            return employees.stream()
//                    .map(this::create)
//                    .collect(Collectors.toList());
////
////            return employees.stream()
////                    .map(proxy::create)
////                    .collect(Collectors.toList());
//        }
//    }
//}
