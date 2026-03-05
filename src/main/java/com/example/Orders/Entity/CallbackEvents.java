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
@Table(name = "callback_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallbackEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "callback_event_id", updatable = false, nullable = false)
    private UUID callbackEventId;

    @Column(name = "event_type", nullable = false)
    private String eventType;
}
