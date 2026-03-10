package com.example.Orders.Repository.subparentRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subparent.OrderErrorEvent;

public interface OrderErrorEventRepository extends JpaRepository<OrderErrorEvent, UUID> {

}
