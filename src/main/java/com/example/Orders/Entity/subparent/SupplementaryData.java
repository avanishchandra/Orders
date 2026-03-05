package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.TaxTotal;

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
@Table(name = "supplementary_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplementaryData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "supplementary_data_id", updatable = false, nullable = false)
    private UUID supplementaryDataId;

    // Card Level 2 Data
    @Column(name = "card_level_2_invoice_id")
    private String cardLevel2InvoiceId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_level_2_tax_total_id", referencedColumnName = "tax_total_id")
    private TaxTotal cardLevel2TaxTotal;

    // Card Level 3 Data
    @Column(name = "card_level_3_ships_from_postal_code")
    private String cardLevel3ShipsFromPostalCode;

    // Note: Level 3 line items are complex and often mirror standard items. 
    // For simplicity in this architecture, we map the shipping/discount amounts here.
    
    @Column(name = "card_level_3_shipping_amount_value")
    private String cardLevel3ShippingAmountValue;
    
    @Column(name = "card_level_3_discount_amount_value")
    private String cardLevel3DiscountAmountValue;

    @Column(name = "card_level_3_duty_amount_value")
    private String cardLevel3DutyAmountValue;
}