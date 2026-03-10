package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.phone;

public interface PhoneRepository extends JpaRepository<phone, UUID> {

}
