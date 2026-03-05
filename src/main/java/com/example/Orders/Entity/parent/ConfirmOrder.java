package com.example.Orders.Entity.parent;

import java.util.UUID;

import com.example.Orders.Entity.subparent.ApplicationContext;
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
@Table(name = "confirm_order_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "confirm_order_id", updatable = false, nullable = false)
    private UUID confirmOrderId;

    // Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_context_id", referencedColumnName = "application_context_id")
    private ApplicationContext applicationContext;

    // Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_source_id", referencedColumnName = "payment_source_id")
    private PaymentSource paymentSource;
}