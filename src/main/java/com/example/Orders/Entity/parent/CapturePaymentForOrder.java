package com.example.Orders.Entity.parent;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "capture_payment_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapturePaymentForOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "capture_payment_id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "payment_source_id", referencedColumnName = "payment_source_id")
    private com.example.Orders.Entity.subparent.PaymentSource paymentSource;
}
