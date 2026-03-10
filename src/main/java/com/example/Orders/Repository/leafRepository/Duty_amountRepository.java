package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.duty_amount;

public interface Duty_amountRepository extends JpaRepository<duty_amount, UUID> {

}
