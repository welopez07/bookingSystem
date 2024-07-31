package com.hotelbookingsystem.service;

import com.hotelbookingsystem.dto.EmployeeRequest;
import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.Role;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.reposotory.IEmployeeRepository;
import com.hotelbookingsystem.reposotory.IRoleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private  final IEmployeeRepository iEmployeeRepository;//SE PUEDE USAR FINAL ACA ??
    private  final IRoleRepository iRoleRepository;
    @Autowired
    public EmployeeService(IEmployeeRepository iEmployeeRepository, IRoleRepository iRoleRepository ){
        this.iEmployeeRepository = iEmployeeRepository;
        this.iRoleRepository = iRoleRepository;
    }
    public Employee addEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        Role role = iRoleRepository.findById(employeeRequest.getRoleId()).orElseThrow(()-> new RuntimeException("Role not found"));
        employee.setRole(role);
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDirection(employeeRequest.getDirection());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setSalary(employeeRequest.getSalary());
        employee.setContractType(employeeRequest.getContractType());
        return iEmployeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return iEmployeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return iEmployeeRepository.findById(id);
    }

    public Employee updateEmployee(Integer id, EmployeeRequest employeeRequest){
        Employee employee = iEmployeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
        Role role = iRoleRepository.findById(employeeRequest.getRoleId()).orElseThrow(()-> new RuntimeException("Role not found"));
        employee.setRole(role);

        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDirection(employeeRequest.getDirection());
        employee.setPhone(employeeRequest.getPhone());
        employee.setEmail(employeeRequest.getEmail());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setSalary(employeeRequest.getSalary());
        employee.setContractType(employeeRequest.getContractType());
        return  iEmployeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        Employee employee = iEmployeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employed not found"));
        iEmployeeRepository.delete(employee);
    }

    public boolean hasAdminAccess(Employee employee){
        return employee.getRole().getRoleType() == RoleType.ADMIN;
    }

    public boolean canEditBookings(Employee employee){
        return employee.getRole().getRoleType() == RoleType.ADMIN || employee.getRole().getRoleType() == RoleType.RECEPCIONIST;
    }

    public boolean canManageEmployees(Employee employee) {
        return employee.getRole().getRoleType() == RoleType.ADMIN;
    }

}
