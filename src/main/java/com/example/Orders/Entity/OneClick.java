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
@Table(name = "one_click")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneClick {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "one_click_id", updatable = false, nullable = false)
    private UUID oneClickId;

    @Column(name = "auth_code", nullable = false)
    private String authCode;

    @Column(name = "consumer_reference", nullable = false)
    private String consumerReference;

    @Column(name = "alias_label", nullable = false)
    private String aliasLabel;

    @Column(name = "alias_key", nullable = false)
    private String aliasKey;
}
