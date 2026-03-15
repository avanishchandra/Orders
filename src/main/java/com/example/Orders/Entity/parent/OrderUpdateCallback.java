package com.example.Orders.Entity.parent;

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
@Table(name = "order_update_callback_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateCallback {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_update_callback_id", updatable = false, nullable = false)
    private UUID id;
}
