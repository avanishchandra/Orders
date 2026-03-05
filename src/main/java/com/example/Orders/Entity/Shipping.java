package com.example.Orders.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shipping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipping_id", updatable = false, nullable = false)
    private UUID shippingId;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "value", nullable = false)
    private String value;
}
