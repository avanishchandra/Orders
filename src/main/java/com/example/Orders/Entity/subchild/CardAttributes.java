package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.*;

@Entity
@Table(name = "card_attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_attributes_id", updatable = false, nullable = false)
    private UUID cardAttributesId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vault_id", referencedColumnName = "vault_id")
    private Vault vault;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verification_id", referencedColumnName = "verification_id")
    private Verification verification;

    // This maps to the specific customer structure found inside Card attributes
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_customer_id", referencedColumnName = "card_customer_id")
    private CardCustomer customer;
}