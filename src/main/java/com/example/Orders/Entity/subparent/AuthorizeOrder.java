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
@Table(name = "authorize_order_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "authorize_order_id", updatable = false, nullable = false)
    private UUID authorizeOrderId;

    // The authorization request often contains the same payment source structure
    // as a capture request, but logically represents a 'Hold' on funds.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_source_id", referencedColumnName = "payment_source_id")
    private PaymentSource paymentSource;
}