package com.example.Orders.Entity.parent;

import java.util.List;
import java.util.UUID;

import com.example.Orders.Entity.Shipping_address;
import com.example.Orders.Entity.subchild.ShippingOption;
import com.example.Orders.Entity.subparent.PurchaseUnit;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "update_order_callback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderCallback {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "callback_id", updatable = false, nullable = false)
    private UUID callbackId;

    // Maps the purchase units list in the update callback
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "callback_id")
    private List<PurchaseUnit> purchaseUnits;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    private Shipping_address shippingAddress;

    // Level 3 Sub-Child
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_option_id", referencedColumnName = "shipping_option_id")
    private ShippingOption shippingOption;
}