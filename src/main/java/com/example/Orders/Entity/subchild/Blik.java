package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.Level0;
import com.example.Orders.Entity.OneClick;
import com.example.Orders.Entity.experience_context;

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
@Table(name = "blik")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blik {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "blik_id", updatable = false, nullable = false)
    private UUID blikId;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "email")
    private String email;

    // Using lowercase class name as defined in your LEAF ENTITY CONTEXT
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id")
    private experience_context experienceContext;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level0_id", referencedColumnName = "level0_id")
    private Level0 level0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "one_click_id", referencedColumnName = "one_click_id")
    private OneClick oneClick;
}