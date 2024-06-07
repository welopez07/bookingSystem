package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service, Integer> {
}
