package com.example.Orders.Entity.subparent;

import java.util.UUID;

import com.example.Orders.Entity.leaf.Name;
import com.example.Orders.Entity.leaf.address;
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
@Table(name = "payer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payer_id_pk", updatable = false, nullable = false)
    private UUID payerIdPk;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "payer_id_string") // Renamed to avoid PK conflict
    private String payerId;

    @Column(name = "birth_date")
    private String birthDate;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "national_number", referencedColumnName = "national_number")
    private phone phone;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_info_id", referencedColumnName = "id")
    private tax_info taxInfo;

    // Leaf Entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private address address;
}