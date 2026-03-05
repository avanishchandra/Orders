package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.PreviousNetworkTransactionReference;

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
@Table(name = "application_context")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationContext {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "application_context_id", updatable = false, nullable = false)
    private UUID applicationContextId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "landing_page")
    private String landingPage;

    @Column(name = "shipping_preference")
    private String shippingPreference;

    @Column(name = "user_action")
    private String userAction;

    @Column(name = "return_url", columnDefinition = "TEXT")
    private String returnUrl;

    @Column(name = "cancel_url", columnDefinition = "TEXT")
    private String cancelUrl;

    @Column(name = "locale")
    private String locale;

    // Payment Method Preference (Embedded manually as simple fields for simplicity)
    @Column(name = "payment_method_preference")
    private String paymentMethodPreference;
    
    @Column(name = "standard_entry_class_code")
    private String standardEntryClassCode;

    @Column(name = "payee_preferred")
    private String payeePreferred;

    // Stored Payment Source fields
    @Column(name = "payment_initiator")
    private String paymentInitiator;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "usage_type")
    private String usage;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prev_txn_ref_id", referencedColumnName = "primary_id")
    private PreviousNetworkTransactionReference previousNetworkTransactionReference;
}