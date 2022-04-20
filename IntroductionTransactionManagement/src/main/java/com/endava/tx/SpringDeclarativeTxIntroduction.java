package com.endava.tx;

import com.endava.tx.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.endava.tx.repo")
@EntityScan(basePackages = "com.endava.tx.entity")
@Slf4j
public class SpringDeclarativeTxIntroduction {
    public static void main(String[] args) {
        SpringApplication.run(SpringDeclarativeTxIntroduction.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(EmployeeService employeeService) {
//        return args -> {
//            employeeService.createEmployees("culmanu", "ipopov", "vmoraru");
//            employeeService.findAll().forEach(employee -> log.info(employee.toString()));
//            employeeService.eraseDatabaseData();
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeService employeeService,
                                               PlatformTransactionManager transactionManager) {
        return args -> {
            TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
//            employeeService.createEmployees("culmanu", "ipopov", "vmoraru"); //mandatory
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    /**
                     * if the second transaction throw
                     * error we need to add a try catch or and the second will be failed
                     */
                    try {
                        employeeService.createEmployees("culmanu1", "ipopov1", "vmoraru1");
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }

                    employeeService.findAll().forEach(employee -> log.info(employee.toString()));
                    employeeService.eraseDatabaseData();
//                    throw new RuntimeException(); //not supported
                }
            });

        };
    }


}
