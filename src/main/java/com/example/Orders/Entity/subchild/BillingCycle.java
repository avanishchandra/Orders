package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// PricingScheme is in the same package (subchild), so no import needed for it.

@Entity
@Table(name = "billing_cycle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "billing_cycle_id", updatable = false, nullable = false)
    private UUID billingCycleId;

    @Column(name = "tenure_type")
    private String tenureType;

    @Column(name = "sequence")
    private Integer sequence;

    @Column(name = "total_cycles")
    private Integer totalCycles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_scheme_id")
    private PricingScheme pricingScheme;
}