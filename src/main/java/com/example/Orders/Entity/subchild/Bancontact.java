package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.leaf.experience_context;

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
@Table(name = "bancontact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bancontact {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bancontact_id", updatable = false, nullable = false)
    private UUID bancontactId;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    // Using lowercase class name as defined in your LEAF ENTITY CONTEXT
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id")
    private experience_context experienceContext;
}