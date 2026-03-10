package com.example.Orders.Entity.leaf;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vault")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vault {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "vault_id", updatable = false, nullable = false)
    private UUID vaultId;

    @Column(name = "store_in_vault", nullable = false)
    private String storeInVault;
}
