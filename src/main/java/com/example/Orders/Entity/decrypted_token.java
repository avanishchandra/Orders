package com.example.Orders.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class decrypted_token {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "message_id", nullable = false)
    private String messageId;

    @Column(name = "message_expiration")
    private String messageExpiration;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "authentication_method")
    private String authenticationMethod;

    @Column(name = "cryptogram", columnDefinition = "TEXT")
    private String cryptogram;

    @Column(name = "eci_indicator")
    private String eciIndicator;

}
