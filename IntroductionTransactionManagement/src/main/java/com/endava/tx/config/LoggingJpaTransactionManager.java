package com.endava.tx.config;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionStatus;

public class LoggingJpaTransactionManager extends JpaTransactionManager {


    @Override
    protected void doBegin(final Object transaction, final TransactionDefinition definition) {
        super.doBegin(transaction, definition);
//        TransactionAttribute transactionDefinition = (TransactionAttribute) definition;
//        System.out.println(transactionDefinition.getLabels());
        System.out.println("**********************************************");
        System.out.println("************* CREATE TRANSACTION *************");
        System.out.println("**********************************************");
        System.out.println();
    }

    @Override
    protected void doCommit(final DefaultTransactionStatus status) {
        super.doCommit(status);
        System.out.println("**********************************************");
        System.out.println("************* COMMIT TRANSACTION *************");
        System.out.println("**********************************************");
        System.out.println();
    }

    @Override
    protected void doRollback(final DefaultTransactionStatus status) {
        super.doRollback(status);
        System.out.println("**********************************************");
        System.out.println("************ ROLLBACK TRANSACTION ************");
        System.out.println("**********************************************");
        System.out.println();
    }
}
