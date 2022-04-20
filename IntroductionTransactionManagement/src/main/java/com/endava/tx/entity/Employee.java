package com.endava.tx.entity;

import lombok.*;


import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "test")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    @Setter(AccessLevel.PRIVATE)
    private Long employeeId;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "Employee with id: " + employeeId
                + " username: " + username
                + " phone: " + phone
                + " email: " + email;
    }
}
