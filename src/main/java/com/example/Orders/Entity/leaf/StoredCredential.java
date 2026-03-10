package com.example.Orders.Entity.leaf;

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
@Table(name = "stored_credential")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoredCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "stored_credential_id", updatable = false, nullable = false)
    private UUID storedCredentialId;

    @Column(name = "payment_initiator", nullable = false)
    private String paymentInitiator;

    @Column(name = "charge_pattern", nullable = false)
    private String chargePattern;

    @Column(name = "usage_type", nullable = false)
    private String usage;
}
