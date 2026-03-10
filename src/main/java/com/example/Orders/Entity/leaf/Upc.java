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
@Table(name = "upc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Upc {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "upc_id", updatable = false, nullable = false)
    private UUID upcId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "code", nullable = false)
    private String code;
}
