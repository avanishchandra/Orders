package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.Vault;
import com.example.Orders.Entity.decrypted_token;
import com.example.Orders.Entity.experience_context;
import com.example.Orders.Entity.phone;

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
@Table(name = "apple_pay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplePay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "apple_pay_id", updatable = false, nullable = false)
    private UUID applePayId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    // Mapping 'phone_number' object to the 'phone' entity in Context
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "national_number", referencedColumnName = "national_number")
    private phone phoneNumber;

    // Using lowercase class name as defined in your LEAF ENTITY CONTEXT
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "decrypted_token_id")
    private decrypted_token decryptedToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vault_id", referencedColumnName = "vault_id")
    private Vault vault;

    // Using lowercase class name as defined in your LEAF ENTITY CONTEXT
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id")
    private experience_context experienceContext;
}