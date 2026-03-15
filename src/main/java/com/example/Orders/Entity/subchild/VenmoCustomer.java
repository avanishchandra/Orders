package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.Name;
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
@Table(name = "venmo_customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenmoCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "venmo_customer_id", updatable = false, nullable = false)
    private UUID venmoCustomerId;

    @Column(name = "customer_id_string")
    private String id;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private phone phone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;
}