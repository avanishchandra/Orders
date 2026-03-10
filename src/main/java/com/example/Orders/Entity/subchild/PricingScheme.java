package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.Price;
import com.example.Orders.Entity.leaf.ReloadThresholdAmount;

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
@Table(name = "pricing_scheme")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "pricing_scheme_id", updatable = false, nullable = false)
    private UUID pricingSchemeId;

    @Column(name = "pricing_model")
    private String pricingModel;

    @Column(name = "start_date")
    private String startDate;

    // Maps 'fixed_price' from POST_order_update_callback.json
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fixed_price_id", referencedColumnName = "price_id")
    private Price fixedPrice;

    // Maps 'price' from POST_create_order.json
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")
    private Price price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reload_threshold_amount_id", referencedColumnName = "reload_threshold_amount_id")
    private ReloadThresholdAmount reloadThresholdAmount;
}