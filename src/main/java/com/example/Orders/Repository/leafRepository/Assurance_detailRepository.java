package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.assurance_detail;

public interface Assurance_detailRepository extends JpaRepository<assurance_detail, UUID> {

}
