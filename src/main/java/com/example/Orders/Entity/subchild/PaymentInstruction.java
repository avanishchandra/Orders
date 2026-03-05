package com.example.Orders.Entity.subchild;

import java.util.UUID;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// import com.example.Orders.Entity.subchild.PlatformFee; // Will be created in Batch 4

@Entity
@Table(name = "payment_instruction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_instruction_id", updatable = false, nullable = false)
    private UUID paymentInstructionId;

    @Column(name = "disbursement_mode")
    private String disbursementMode;

    @Column(name = "payee_pricing_tier_id")
    private String payeePricingTierId;

    @Column(name = "payee_receivable_fx_rate_id")
    private String payeeReceivableFxRateId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_instruction_id") // OneToMany join column
    private List<PlatformFee> platformFees;
}