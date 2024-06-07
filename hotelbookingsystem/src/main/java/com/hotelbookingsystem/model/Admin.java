package com.hotelbookingsystem.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Employee {

    private int idAdmin;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
