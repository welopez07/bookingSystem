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
        employee.setName(employeeRequest.getName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDirection(employeeRequest.getDirection());
        employee.setBirthday(employeeRequest.getBirthday());
        employee.setSalary(employeeRequest.getSalary());
        employee.setContractType(employeeRequest.getContractType());

        Role role = iRoleRepository.findById(employeeRequest.getRoleId()).orElseThrow(()-> new IllegalArgumentException("Invalid role ID: " + employeeRequest.getRoleId()));

        employee.setRole(role);
        return iEmployeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return iEmployeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return iEmployeeRepository.findById(id);
    }

    public Optional<Employee> updateEmployee(Integer id, EmployeeRequest employeeRequest){
        return iEmployeeRepository.findById(id).map(employee -> {
            employee.setName(employeeRequest.getName());
            employee.setSalary(employeeRequest.getSalary());
            employee.setContractType(employeeRequest.getContractType());

            Role role = iRoleRepository.findById(employeeRequest.getRoleId()).orElseThrow(() -> new IllegalArgumentException("Role not found"));
            employee.setRole(role);
            return iEmployeeRepository.save(employee);
        });
    }

    public boolean  deleteEmployee(Integer id){
        if(iEmployeeRepository.existsById(id)){
            iEmployeeRepository.deleteById(id);
            return true;
        }
        return false;
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
