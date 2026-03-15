package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.assurance_detail;
import com.example.Orders.Entity.leaf.decrypted_token;
import com.example.Orders.Entity.leaf.experience_context;
import com.example.Orders.Entity.leaf.phone;

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
@Table(name = "google_pay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GooglePay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "google_pay_id", updatable = false, nullable = false)
    private UUID googlePayId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private phone phoneNumber;


    // Google Pay contains a nested Card object in the JSON
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private Card card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "decrypted_token_id", referencedColumnName = "id")
    private decrypted_token decryptedToken;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assurance_detail_id", referencedColumnName = "id")
    private assurance_detail assuranceDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;
}