package com.example.Orders.Repository.subparentRepository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Orders.Entity.subparent.PaymentSource;

public interface PaymentSourceRepository extends JpaRepository<PaymentSource, UUID> {

}
