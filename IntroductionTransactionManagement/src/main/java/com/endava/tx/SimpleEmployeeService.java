//package com.endava.tx;
//
//import com.endava.tx.entity.Employee;
//import com.endava.tx.repo.EmployeeDAO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class SimpleEmployeeService {
//
//    private final EmployeeDAO employeeDAO;
//
//    @Transactional
//    public Stream<Employee> findAll() {
//        log.info("Finding all employees");
//        return employeeDAO.findAll().stream();
//    }
//
//    @Transactional(propagation = Propagation.MANDATORY)
//    public void batchCreate(final List<Employee> employeeList) {
//        employeeDAO.saveAll(employeeList);
//    }
//}
