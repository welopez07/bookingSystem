package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.Role;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.reposotory.IEmployeeRepository;
import com.hotelbookingsystem.reposotory.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    public Role addRole(RoleType roleType, String descriptionRole){
        Role role = new Role();
        role.setRoleType(roleType);
        role.setDescriptionRole(descriptionRole);
        return iRoleRepository.save(role);

    }
    public Optional<Role> getRoleById(Integer id){//Optional evita errores con los valores null
        return iRoleRepository.findById(id);
    }

    public List<Role> getAllRoles(){
        return iRoleRepository.findAll();
    }
    public Role updateRole(Integer id, RoleType roleType, String descriptionRole){
        Role role = iRoleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role not found"));
        role.setRoleType(roleType);
        role.setDescriptionRole(descriptionRole);
        return iRoleRepository.save(role);
    }

    public void deleteRole(Integer id){
        Role role = iRoleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role not found"));
        iRoleRepository.delete(role);
    }

}
