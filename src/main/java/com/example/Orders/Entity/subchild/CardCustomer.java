package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.phone;

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
@Table(name = "card_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "card_customer_id", updatable = false, nullable = false)
    private UUID cardCustomerId;

    @Column(name = "customer_id_string") // Renamed to avoid conflict with UUID id
    private String id;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private phone phone;

    
    // Nested Name object (given_name, surname) isn't in Leaf Context explicitly as a standalone 
    // strictly for this usage, but if you have a Name leaf, use it:
    // @OneToOne
    // private Name name; 
    // Otherwise, simplified for this specific structure:
    @Column(name = "given_name")
    private String givenName;
    
    @Column(name = "surname")
    private String surname;
}