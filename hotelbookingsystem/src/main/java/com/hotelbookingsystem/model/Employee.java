package com.hotelbookingsystem.model;

import jakarta.persistence.*;

@Entity
public class Employee extends Person {


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleType role;

    private double salary;

    private String contractType;


    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
