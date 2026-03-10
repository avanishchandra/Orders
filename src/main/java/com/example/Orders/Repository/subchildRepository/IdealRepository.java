package com.example.Orders.Repository.subchildRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subchild.Ideal;

public interface IdealRepository extends JpaRepository<Ideal, UUID> {

}
