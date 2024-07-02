package com.hotelbookingsystem.model;

public enum RoleType {

    ADMIN("Administrador con permisos especiales"),
    RECEPCIONIST("Recepcionista con permisos especiales");

    private final String description;

    RoleType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public boolean canAccessAdminPanel(){
        return this == ADMIN;
    }

    public boolean canEditBookings(){
        return this == ADMIN || this == RECEPCIONIST;
    }


}
