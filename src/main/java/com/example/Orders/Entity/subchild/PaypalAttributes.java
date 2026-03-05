package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.Vault;

@Entity
@Table(name = "paypal_attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paypal_attributes_id", updatable = false, nullable = false)
    private UUID paypalAttributesId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vault_id", referencedColumnName = "vault_id")
    private Vault vault;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_customer_id", referencedColumnName = "paypal_customer_id")
    private PaypalCustomer customer;
}