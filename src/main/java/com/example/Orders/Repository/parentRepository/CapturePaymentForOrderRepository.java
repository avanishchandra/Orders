package com.example.Orders.Repository.parentRepository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Orders.Entity.parent.CapturePaymentForOrder;

public interface CapturePaymentForOrderRepository extends JpaRepository<CapturePaymentForOrder, UUID> {
}
