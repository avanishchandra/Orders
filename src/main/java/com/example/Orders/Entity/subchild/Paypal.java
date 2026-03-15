package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.Name;
import com.example.Orders.Entity.leaf.address;
import com.example.Orders.Entity.leaf.experience_context;
import com.example.Orders.Entity.leaf.phone;
import com.example.Orders.Entity.leaf.tax_info;

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
@Table(name = "paypal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paypal_id", updatable = false, nullable = false)
    private UUID paypalId;

    @Column(name = "billing_agreement_id")
    private String billingAgreementId;

    @Column(name = "vault_id")
    private String vaultId;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "birth_date")
    private String birthDate;

    // Mapping 'name' JSON object to 'Name' leaf entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private phone phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_info_id", referencedColumnName = "id")
    private tax_info taxInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;

    // Link to bonus entity 'PaypalAttributes' below
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_attributes_id", referencedColumnName = "paypal_attributes_id")
    private PaypalAttributes attributes;
}