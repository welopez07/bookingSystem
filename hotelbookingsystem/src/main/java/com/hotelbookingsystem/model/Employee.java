package com.hotelbookingsystem.model;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {

    private int idEmployee;
    private String cargo;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
