package com.example.Orders.Entity.subchild;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.*;

@Entity
@Table(name = "venmo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venmo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "venmo_id", updatable = false, nullable = false)
    private UUID venmoId;

    @Column(name = "vault_id")
    private String vaultId;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "experience_context_id", referencedColumnName = "id")
    private experience_context experienceContext;

    // Dependency defined below
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "callback_config_id", referencedColumnName = "callback_config_id")
    private OrderUpdateCallbackConfig orderUpdateCallbackConfig;

    // Dependency defined below
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venmo_attributes_id", referencedColumnName = "venmo_attributes_id")
    private VenmoAttributes attributes;
}