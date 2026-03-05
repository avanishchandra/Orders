package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.amount;

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
@Table(name = "shipping_option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOption {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipping_option_id", updatable = false, nullable = false)
    private UUID shippingOptionId;

    @Column(name = "option_id_string") // Renamed to avoid ID conflict
    private String id;

    @Column(name = "label")
    private String label;

    @Column(name = "type")
    private String type;

    @Column(name = "selected")
    private Boolean selected;

    // Uses Leaf Entity 'amount'
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
    private amount amount;
}