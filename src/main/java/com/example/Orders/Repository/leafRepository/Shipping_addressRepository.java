package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.Shipping_address;

public interface Shipping_addressRepository extends JpaRepository<Shipping_address, UUID> {

}
