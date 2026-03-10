package com.example.Orders.Repository.subchildRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subchild.PricingScheme;

public interface PricingSchemeRepository extends JpaRepository<PricingScheme, UUID> {

}
