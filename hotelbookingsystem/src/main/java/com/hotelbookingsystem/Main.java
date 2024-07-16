package com.hotelbookingsystem;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.Role;

public class Main {

    public static void main(String[] args) {

        //query
        //select * from role;
        //select rol from Role;

        //select rol.id_role, rol.description_role, rol.role from role rol;  SQL
        //select rol.id, rol.descriptionRole, rol.role from Role rol;  JPQL

        /*
        Role role1 = new Role();
        role1.setId(1);
        role1.setRole("Admin");

        Role role2 = new Role();
        role2.setId(2);
        role2.setRole("Aux");

        Role role3 = new Role();
        role3.setId(3);
        role3.setRole("Receptionist");


        Employee employee1  = new Employee();
        employee1.setRole(role1);

        Employee employee2  = new Employee();
        employee2.setRole(role2);

        Employee employee3  = new Employee();
        employee3.setRole(role3);

        System.out.println("Employee 1: " + employee1.getRole().getRole());
        System.out.println("Employee 2: " + employee2.getRole().getRole());
        System.out.println("Employee 3: " + employee3.getRole().getRole());
        */






    }

}
