package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.subparent.PaymentSource;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "capture_order_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptureOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "capture_order_id", updatable = false, nullable = false)
    private UUID captureOrderId;

    @Column(name = "order_id_ref") // Reference to the original Order ID
    private String orderId;

    // Level 2 Sub-Parent: Contains the massive payment source logic (Card, PayPal, etc.)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_source_id", referencedColumnName = "payment_source_id")
    private PaymentSource paymentSource;
}