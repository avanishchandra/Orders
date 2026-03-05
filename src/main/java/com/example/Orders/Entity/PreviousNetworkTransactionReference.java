package com.example.Orders.Entity;

import java.time.LocalDate;
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
@Table(name = "previous_network_transaction_reference")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousNetworkTransactionReference {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "primary_id", updatable = false, nullable = false)
    private UUID primaryId;

    @Column(name = "transaction_id", nullable = false)
    private String id;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate date;

    @Column(name = "network", nullable = false)
    private String network;

    @Column(name = "acquirer_reference_number", nullable = false)
    private String acquirerReferenceNumber;
}
