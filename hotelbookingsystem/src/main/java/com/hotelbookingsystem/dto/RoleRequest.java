package com.hotelbookingsystem.dto;

import com.hotelbookingsystem.model.RoleType;

public class RoleRequest {

    private RoleType roleType;
    private String descriptionRole;

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }
}
