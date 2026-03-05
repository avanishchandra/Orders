package com.example.Orders.Entity.subchild;

import java.util.UUID;

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
@Table(name = "eps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eps {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "eps_id", updatable = false, nullable = false)
    private UUID epsId;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;
}