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
@Table(name = "discount_amount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "discount_amount_id", updatable = false, nullable = false)
    private UUID discountAmountId;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "value", nullable = false)
    private String value;
}
