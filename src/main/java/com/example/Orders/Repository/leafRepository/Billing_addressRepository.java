package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.billing_address;

public interface Billing_addressRepository extends JpaRepository<billing_address, UUID> {

}
