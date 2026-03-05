package com.example.Orders.Entity.subparent;

import java.util.UUID;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.*;
import com.example.Orders.Entity.subchild.*;

@Entity
@Table(name = "purchase_unit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "purchase_unit_id", updatable = false, nullable = false)
    private UUID purchaseUnitId;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "description")
    private String description;

    @Column(name = "custom_id")
    private String customId;

    @Column(name = "invoice_id")
    private String invoiceId;

    @Column(name = "soft_descriptor")
    private String softDescriptor;

    // Level 3 Sub-Child List
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_unit_id")
    private List<Item> items;

    // Sub-Parent Entity (Defined below in this batch)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_unit_amount_id", referencedColumnName = "purchase_unit_amount_id")
    private PurchaseUnitAmount amount;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payee_id", referencedColumnName = "id")
    private payee payee;

    // Level 3 Sub-Child
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_instruction_id", referencedColumnName = "payment_instruction_id")
    private PaymentInstruction paymentInstruction;

    // Level 3 Sub-Child
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_detail_id", referencedColumnName = "shipping_detail_id")
    private ShippingDetail shipping;
    
    // Level 3 Sub-Child (Billing Cycle List wrapper needed or direct list)
    // Mapping complex billing_plan structure
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_unit_id")
    private List<BillingCycle> billingCycles;
    
    @Column(name = "billing_plan_name")
    private String billingPlanName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "setup_fee_id", referencedColumnName = "setup_fee_id")
    private SetupFee setupFee;

    // Sub-Parent Entity (Defined below in this batch)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplementary_data_id", referencedColumnName = "supplementary_data_id")
    private SupplementaryData supplementaryData;
    
    // Leaf Entity (Risk)
    @Column(name = "risk_ip_address")
    private String riskIpAddress;
}