package com.endava.tx.repo;

import com.endava.tx.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {
    @Override
    Optional<Employee> findById(Long aLong);

    Optional<Employee> findByUsername(String name);
}
