package com.example.Orders.Entity;

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
@Table(name = "level_0")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Level0 {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "level0_id", updatable = false, nullable = false)
    private UUID level0Id;

    @Column(name = "auth_code", nullable = false)
    private String authCode;
}
