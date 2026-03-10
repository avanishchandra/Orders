package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.leaf.Vault;

@Entity
@Table(name = "venmo_attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenmoAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "venmo_attributes_id", updatable = false, nullable = false)
    private UUID venmoAttributesId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vault_id", referencedColumnName = "vault_id")
    private Vault vault;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venmo_customer_id", referencedColumnName = "venmo_customer_id")
    private VenmoCustomer customer;
}