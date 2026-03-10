package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.leaf.*;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_id", updatable = false, nullable = false)
    private UUID cardId;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "expiry")
    private String expiry;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "vault_id")
    private String vaultId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private billing_address billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stored_credential_id", referencedColumnName = "stored_credential_id")
    private StoredCredential storedCredential;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "network_token_id", referencedColumnName = "network_token_id")
    private NetworkToken networkToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_attributes_id", referencedColumnName = "card_attributes_id")
    private CardAttributes attributes;
}