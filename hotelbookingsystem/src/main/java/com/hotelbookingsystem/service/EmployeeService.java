package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.reposotory.IEmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private IEmployeeRepository iEmployeeRepository;

    public Employee addEmployee(String name, RoleType role){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setRole(role);
        return iEmployeeRepository.save(employee);
    }

    public Employee findById(Integer id){
        return iEmployeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado."));
    }

    public boolean hasAdminAccess(Employee employee){
        return employee.getRole().canAccessAdminPanel();
    }

    public boolean canEditBookings(Employee employee){
        return employee.getRole().canEditBookings();
    }

}
