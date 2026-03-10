package com.example.Orders.Repository.parentRepository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Orders.Entity.parent.AuthorizePaymentForOrder;

public interface AuthorizePaymentForOrderRepository extends JpaRepository<AuthorizePaymentForOrder, UUID> {
}
