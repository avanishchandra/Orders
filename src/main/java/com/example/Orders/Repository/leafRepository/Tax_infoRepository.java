package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.tax_info;

public interface Tax_infoRepository extends JpaRepository<tax_info, UUID> {

}
