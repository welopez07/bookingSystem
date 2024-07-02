package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam RoleType role){
        return employeeService.addEmployee(name, role);
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
