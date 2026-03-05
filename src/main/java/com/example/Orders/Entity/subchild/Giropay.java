package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// IMPORT FIX: Required to find experience_context
import com.example.Orders.Entity.*;

@Entity
@Table(name = "giropay")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Giropay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "giropay_id", updatable = false, nullable = false)
    private UUID giropayId;

    @Column(name = "name")
    private String name;

    @Column(name = "country_code")
    private String countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;
}