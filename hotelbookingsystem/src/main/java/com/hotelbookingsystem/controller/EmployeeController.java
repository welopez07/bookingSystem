package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.dto.EmployeeRequest;
import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.addEmployee(
                employeeRequest.getName(),
                employeeRequest.getRole(),
                employeeRequest.getSalary(),
                employeeRequest.getContractType()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }
    @GetMapping("/{id}/canEditBookings")
    public boolean canEditBookings(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        return employeeService.canEditBookings(employee);
    }
    @GetMapping("/{id}/hasAdminAccess")
    public boolean hasAdminAccess(@PathVariable Integer id){
        Employee employee = employeeService.findById(id);
        return employeeService.hasAdminAccess(employee);
    }


}
