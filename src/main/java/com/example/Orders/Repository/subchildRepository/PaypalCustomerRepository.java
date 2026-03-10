package com.example.Orders.Repository.subchildRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subchild.PaypalCustomer;

public interface PaypalCustomerRepository extends JpaRepository<PaypalCustomer, UUID> {

}
