package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.subchild.ApplePay;
import com.example.Orders.Entity.subchild.Bancontact;
import com.example.Orders.Entity.subchild.Blik;
import com.example.Orders.Entity.subchild.Card;
import com.example.Orders.Entity.subchild.Eps;
import com.example.Orders.Entity.subchild.Giropay;
import com.example.Orders.Entity.subchild.GooglePay;
import com.example.Orders.Entity.subchild.Ideal;
import com.example.Orders.Entity.subchild.Mybank;
import com.example.Orders.Entity.subchild.P24;
import com.example.Orders.Entity.subchild.Paypal;
import com.example.Orders.Entity.subchild.Sofort;
import com.example.Orders.Entity.subchild.Trustly;
import com.example.Orders.Entity.subchild.Venmo;

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
@Table(name = "payment_source")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSource {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_source_id", updatable = false, nullable = false)
    private UUID paymentSourceId;

    // Sub-Child Entities
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "card_id")
    private Card card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_id", referencedColumnName = "paypal_id")
    private Paypal paypal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bancontact_id", referencedColumnName = "bancontact_id")
    private Bancontact bancontact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "blik_id", referencedColumnName = "blik_id")
    private Blik blik;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eps_id", referencedColumnName = "eps_id")
    private Eps eps;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "giropay_id", referencedColumnName = "giropay_id")
    private Giropay giropay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ideal_id", referencedColumnName = "ideal_id")
    private Ideal ideal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mybank_id", referencedColumnName = "mybank_id")
    private Mybank mybank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "p24_id", referencedColumnName = "p24_id")
    private P24 p24;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sofort_id", referencedColumnName = "sofort_id")
    private Sofort sofort;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trustly_id", referencedColumnName = "trustly_id")
    private Trustly trustly;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apple_pay_id", referencedColumnName = "apple_pay_id")
    private ApplePay applePay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "google_pay_id", referencedColumnName = "google_pay_id")
    private GooglePay googlePay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venmo_id", referencedColumnName = "venmo_id")
    private Venmo venmo;
    
    // Token is distinct from NetworkToken, often used for billing agreements
    @Column(name = "token_id")
    private String tokenId;
    
    @Column(name = "token_type")
    private String tokenType;
}