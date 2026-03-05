package com.example.Orders.Entity.parent;

import java.util.List;
import java.util.UUID;

import com.example.Orders.Entity.subparent.ApplicationContext;
import com.example.Orders.Entity.subparent.Payer;
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
@Table(name = "create_order_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "create_order_id", updatable = false, nullable = false)
    private UUID createOrderId;

    @Column(name = "intent")
    private String intent;

    // Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id_pk", referencedColumnName = "payer_id_pk")
    private Payer payer;

    // Level 2 Sub-Parent (List of Purchase Units)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "create_order_id")
    private List<PurchaseUnit> purchaseUnits;
    
    // Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "application_context_id", referencedColumnName = "application_context_id")
    private ApplicationContext applicationContext;
}