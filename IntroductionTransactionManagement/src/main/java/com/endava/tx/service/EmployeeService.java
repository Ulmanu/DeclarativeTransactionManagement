package com.endava.tx.service;

import com.endava.tx.entity.Employee;
import com.endava.tx.repo.EmployeeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeDAO employeeDAO;


//        @Transactional(transactionManager = "transactionManager")
//    @Transactional(label = {"Insert employees transaction"})
//    @Transactional(timeout = 15)
//    @Transactional(rollbackFor = {IOException.class},noRollbackFor = {RuntimeException.class})
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.MANDATORY)
    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional
    public void createEmployees(String... employees)  {
        log.info("Creating employees: {}", Arrays.toString(employees));
        for (String name : employees) {
            employeeDAO.save(Employee.builder().username(name).build());
            log.info("Saved the employee: {}", name);
        }
//        throw new RuntimeException();
//        throw new IOException();
    }


//    @Transactional(readOnly = false)
//    public void createEmployees(String... employees) {
//        log.info("Creating employees: {}", Arrays.toString(employees));
//        for (String name : employees) {
//            Employee e = employeeDAO.findByUsername(name).orElse(Employee.builder().username(name).build());
//            e.setEmail("t@a.com");
//            employeeDAO.save(e);
//            log.info("Saved the employee: {}", name);
//        }
//    }

//    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Transactional
    public Iterable<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    public void eraseDatabaseData() {
        log.warn("Database is cleared");
        employeeDAO.deleteAll();
    }
}
