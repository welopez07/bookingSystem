package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.dto.RoleResponse;
import com.hotelbookingsystem.model.Client;
import com.hotelbookingsystem.model.Role;
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
    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<RoleResponse> addRole(@RequestBody Role role){
        boolean response = roleService.addRole(role);
        RoleResponse roleResponse = new RoleResponse();

        if (response) {
            roleResponse.setInserted(true);
            roleResponse.setCodeError("200");
            roleResponse.setMessage("Se inserto con exito");
        } else {
            roleResponse.setInserted(false);
            roleResponse.setCodeError("500");
            roleResponse.setMessage("No se pudo insertar el rol, consulte el administrador");
        }

        return ResponseEntity.ok(roleResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer id) {
        Optional<Role> optionalRole = roleService.getById(id);
        if (optionalRole.isPresent()) {
            return ResponseEntity.ok(optionalRole.get()); // devuelve el detalle de cada rol
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // respnde con 404 Not Found
        }
    }
    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable Integer id, @RequestBody Role role) {
        boolean isUpdated = roleService.updateRole(id, role.getRoleType(), role.getDescriptionRole());
        RoleResponse response = new RoleResponse();
        if (isUpdated) {
            response.setInserted(true);
            response.setCodeError("0");
            response.setMessage("Role updated successfully");
            return ResponseEntity.ok(response); // envia un mensaje de tipo 200 OK
        } else {
            response.setInserted(false);
            response.setCodeError("1");
            response.setMessage("Failed to update role");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // envia  500 Internal Server Error
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleResponse> deleteRole(@PathVariable Integer id) {
        boolean isDeleted = roleService.deleteRole(id);
        RoleResponse response = new RoleResponse();
        if (isDeleted) {
            response.setInserted(true);
            response.setCodeError("0");
            response.setMessage("Role deleted successfully");
            return ResponseEntity.ok(response); // responde un mensaje 200 OK, eliminado exitoso
        } else {
            response.setInserted(false);
            response.setCodeError("1");
            response.setMessage("Failed to delete role");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response); // envia  500 Internal Server Error
        }
    }
}
