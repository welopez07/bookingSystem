package com.hotelbookingsystem.model;

public enum RoleType {

    ADMIN("Administrador con permisos especiales",true, true, true),
    RECEPCIONIST("Recepcionista con permisos especiales", false, true, false),
    AUXILIARY ("Auxiliar de servicios generales sin ningún permiso", false, false, false);


    private final String description;
    private final boolean canAccesAdminPanel;
    private final boolean canEditBookings;
    private final boolean canManageEmployees;

    RoleType(String description, boolean canAccesAdminPanel, boolean canEditBookings, boolean canManageEmployees) {
        this.description = description;
        this.canAccesAdminPanel = canAccesAdminPanel;
        this.canEditBookings = canEditBookings;
        this.canManageEmployees = canManageEmployees;
    }

    public String getDescription(){
        return description;
    }

    public boolean canAccesAdminPanel(){
        return canAccesAdminPanel;
    }

    public boolean canEditBookings() {
        return canEditBookings;
    }

    public boolean canManageEmployees() {
        return canManageEmployees;
    }
}
