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
@Table(name = "network_token")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "network_token_id", updatable = false, nullable = false)
    private UUID networkTokenId;

    @Column(name = "token_number", nullable = false)
    private String number;

    @Column(name = "cryptogram", nullable = false, length = 512)
    private String cryptogram;

    @Column(name = "token_requestor_id", nullable = false)
    private String tokenRequestorId;

    @Column(name = "expiry", nullable = false)
    private String expiry;

    @Column(name = "eci_flag", nullable = false)
    private String eciFlag;
}
