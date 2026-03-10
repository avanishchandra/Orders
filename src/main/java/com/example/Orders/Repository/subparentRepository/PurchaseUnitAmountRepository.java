package com.example.Orders.Repository.subparentRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subparent.PurchaseUnitAmount;

public interface PurchaseUnitAmountRepository extends JpaRepository<PurchaseUnitAmount, UUID> {

}
