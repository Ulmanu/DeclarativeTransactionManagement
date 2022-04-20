package com.endava.tx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionManagerConfiguration {

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() {
        LoggingJpaTransactionManager loggingJpaTransactionManager = new LoggingJpaTransactionManager();
        loggingJpaTransactionManager.setNestedTransactionAllowed(true);
        return loggingJpaTransactionManager;
    }
}
