package com.hotelbookingsystem.service;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.Role;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.reposotory.IEmployeeRepository;
import com.hotelbookingsystem.reposotory.IRoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private  final IEmployeeRepository iEmployeeRepository;//SE PUEDE USAR FINAL ACA ??
    private  final IRoleRepository iRoleRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository iEmployeeRepository, IRoleRepository iRoleRepository ){
        this.iEmployeeRepository = iEmployeeRepository;
        this.iRoleRepository = iRoleRepository;
    }
    public Employee addEmployee(String name, RoleType roleType, double salary, String contractType ){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setContractType(contractType);

        Role role = iRoleRepository.findByRole(roleType.name());
        if (role == null){
            throw new IllegalArgumentException("Role not found");
        }
        employee.setRole(role);
        return iEmployeeRepository.save(employee);
    }

    public Employee findById(Integer id){
        return iEmployeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado."));
    }

    public boolean hasAdminAccess(Employee employee){
        return "Admin".equalsIgnoreCase(employee.getRole().getRole());
    }

    public boolean canEditBookings(Employee employee){
        return "Admin".equalsIgnoreCase(employee.getRole().getRole());
    }

}
