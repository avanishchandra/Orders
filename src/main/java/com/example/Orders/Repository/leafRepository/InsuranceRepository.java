package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {

}
