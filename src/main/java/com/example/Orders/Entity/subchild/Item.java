package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.Tax;
import com.example.Orders.Entity.UnitAmount;
import com.example.Orders.Entity.Upc;

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
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_id", updatable = false, nullable = false)
    private UUID itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "sku")
    private String sku;

    @Column(name = "url")
    private String url;

    @Column(name = "category")
    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    // Use the specific UnitAmount leaf entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_amount_id", referencedColumnName = "unit_amount_id")
    private UnitAmount unitAmount;

    // Use the specific Tax leaf entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_id", referencedColumnName = "tax_id")
    private Tax tax;

    // Use the specific Upc leaf entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upc_id", referencedColumnName = "upc_id")
    private Upc upc;
}