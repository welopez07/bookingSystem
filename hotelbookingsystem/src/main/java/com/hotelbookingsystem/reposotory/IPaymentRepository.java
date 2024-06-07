package com.hotelbookingsystem.reposotory;

import com.hotelbookingsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
