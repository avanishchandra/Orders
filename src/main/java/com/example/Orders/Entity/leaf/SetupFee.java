package com.example.Orders.Entity.leaf;

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
@Table(name = "setup_fee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetupFee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "setup_fee_id", updatable = false, nullable = false)
    private UUID setupFeeId;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "value", nullable = false)
    private String value;
}
