package com.example.Orders.Repository.subchildRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subchild.VenmoCustomer;

public interface VenmoCustomerRepository extends JpaRepository<VenmoCustomer, UUID> {

}
