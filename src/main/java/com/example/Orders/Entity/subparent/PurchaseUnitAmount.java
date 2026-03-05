package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.subchild.AmountBreakdown;

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
@Table(name = "purchase_unit_amount")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseUnitAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "purchase_unit_amount_id", updatable = false, nullable = false)
    private UUID purchaseUnitAmountId;

    @Column(name = "currency_code", nullable = false)
    private String currencyCode;

    @Column(name = "value", nullable = false)
    private String value;

    // Level 3 Sub-Child
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "breakdown_id", referencedColumnName = "breakdown_id")
    private AmountBreakdown breakdown;
}