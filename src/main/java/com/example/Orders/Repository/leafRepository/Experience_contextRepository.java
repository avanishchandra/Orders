package com.example.Orders.Repository.leafRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.leaf.experience_context;

public interface Experience_contextRepository extends JpaRepository<experience_context, UUID> {

}
