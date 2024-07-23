package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.Employee;
import com.hotelbookingsystem.model.Role;
import com.hotelbookingsystem.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {


    Role findByRoleType(RoleType roleType);
}
