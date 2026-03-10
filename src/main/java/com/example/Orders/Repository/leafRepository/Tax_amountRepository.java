package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.tax_amount;

public interface Tax_amountRepository extends JpaRepository<tax_amount, UUID> {

}
