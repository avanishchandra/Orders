package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.Name;
import com.example.Orders.Entity.phone;

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
@Table(name = "paypal_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paypal_customer_id", updatable = false, nullable = false)
    private UUID paypalCustomerId;

    @Column(name = "customer_id_string")
    private String id;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "merchant_customer_id")
    private String merchantCustomerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "national_number", referencedColumnName = "national_number")
    private phone phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;
}