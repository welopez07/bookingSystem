package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.ServiceConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceConsumptionRepository extends JpaRepository<ServiceConsumption, Integer> {
}
