package com.example.Orders.Repository.parentRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.parent.ConfirmOrder;

public interface ConfirmOrderRepository extends JpaRepository<ConfirmOrder, UUID> {

}
