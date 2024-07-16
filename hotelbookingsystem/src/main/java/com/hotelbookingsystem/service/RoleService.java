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

    public boolean addRole(Role role){
        try{
            iRoleRepository.save(role);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Optional<Role> getById(Integer id){//Optional evita errores con los valores null
        return iRoleRepository.findById(id);
    }

    public List<Role> getAllRoles(){
        return iRoleRepository.findAll();
    }
    public boolean updateRole(Integer id, String roleName, String descriptionRole){
        Optional<Role> optionalRole = iRoleRepository.findById(id);
        if (optionalRole.isPresent()){
            Role role = optionalRole.get();
            role.setRole(roleName);
            role.setDescriptionRole(descriptionRole);
            iRoleRepository.save(role);
            return true;
        }
        return false;
    }
    public Boolean deleteRole(Integer id){
        Optional<Role> optionalRole = iRoleRepository.findById(id);
        if (optionalRole.isPresent()){
            iRoleRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
