//package com.endava.tx;
//
//import com.endava.tx.entity.Employee;
//import com.endava.tx.repo.EmployeeDAO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.support.TransactionCallbackWithoutResult;
//import org.springframework.transaction.support.TransactionTemplate;
//
//import javax.annotation.PostConstruct;
//
//@SpringBootApplication
//@Slf4j
//public class SecondSpringFailApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SecondSpringFailApplication.class, args);
//    }
//
//
//    @Slf4j
//    @RequiredArgsConstructor
//    @Service
//    public static class InitMethodService
//            implements ApplicationListener<ContextRefreshedEvent>
//    {
//        private final EmployeeDAO employeeDAO;
//
//        private final PlatformTransactionManager transactionManager;
//
////
//////        @Transactional
////        @PostConstruct
////        public void init() {
////
////            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
////            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
////                @Override
////                protected void doInTransactionWithoutResult(TransactionStatus status) {
////                    try {
////                        employeeDAO.save(Employee.builder()
////                                .username("leonid").email("aggg@a.com").build());
////                    } catch (Exception e) {
////                        log.error(e.getMessage());
////                    }
////                }
////            });
////
//////            employeeDAO.save(Employee.builder()
//////                    .username("leonid").email("a@a.com").build());
////
////        }
//
//        @Transactional
//        @Override
//        public void onApplicationEvent(ContextRefreshedEvent event) {
//           employeeDAO.save(Employee.builder()
//                   .username("leonid").email("a@a.com").build());
//        }
//    }
//}
//
//
//
