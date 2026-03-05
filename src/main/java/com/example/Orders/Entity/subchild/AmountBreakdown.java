package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// IMPORT FIX: This line lets this file see ItemTotal, Shipping, etc.
import com.example.Orders.Entity.*;

@Entity
@Table(name = "amount_breakdown")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountBreakdown {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "breakdown_id", updatable = false, nullable = false)
    private UUID breakdownId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_total_id", referencedColumnName = "item_total_id")
    private ItemTotal itemTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id", referencedColumnName = "shipping_id")
    private Shipping shipping;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "handling_id", referencedColumnName = "handling_id")
    private Handling handling;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_total_id", referencedColumnName = "tax_total_id")
    private TaxTotal taxTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance_id", referencedColumnName = "insurance_id")
    private Insurance insurance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_discount_id", referencedColumnName = "shipping_discount_id")
    private ShippingDiscount shippingDiscount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id", referencedColumnName = "discount_id")
    private Discount discount;
}