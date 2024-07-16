package com.hotelbookingsystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    @JoinColumn(name = "id_role")
    @ManyToOne
    private Role role;
    @Column(name = "salary")
    private double salary;
    @Column(name = "contract_type")
    private String contractType;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
