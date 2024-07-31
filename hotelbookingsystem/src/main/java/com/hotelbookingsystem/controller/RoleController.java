package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.dto.RoleRequest;
import com.hotelbookingsystem.dto.RoleResponse;
import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.model.Role;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.reposotory.IRoleRepository;
import com.hotelbookingsystem.service.ClientService;
import com.hotelbookingsystem.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping()
    public ResponseEntity<Role> addRole(@RequestBody RoleRequest roleRequest){
        Role role = roleService.addRole(roleRequest.getRoleType(), roleRequest.getDescriptionRole());
        return new ResponseEntity<>(role,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer id, @RequestBody RoleRequest roleRequest){
        Role role = roleService.updateRole(id, roleRequest.getRoleType(), roleRequest.getDescriptionRole());
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
