package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.Shipping_amount;

public interface Shipping_amountRepository extends JpaRepository<Shipping_amount, UUID> {

}
