package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.Mobile_Web;

public interface Mobile_WebRepository extends JpaRepository<Mobile_Web, UUID> {

}
