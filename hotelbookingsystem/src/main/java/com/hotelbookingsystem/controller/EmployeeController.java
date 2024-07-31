package com.hotelbookingsystem.controller;

import com.hotelbookingsystem.dto.EmployeeRequest;
import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.RoleType;
import com.hotelbookingsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeService.updateEmployee(id, employeeRequest);
        return ResponseEntity.ok(employee);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
