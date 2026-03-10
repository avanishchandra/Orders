package com.example.Orders.Repository.subparentRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subparent.PurchaseUnits;

public interface PurchaseUnitsRepository extends JpaRepository<PurchaseUnits, UUID> {

}
