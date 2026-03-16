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
@Table(name = "patch_operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "op")
    private String op;

    @Column(name = "path")
    private String path;

    @Column(name = "patch_value")
    private String value;

    @Column(name = "patch_from")
    private String from;
}
