package com.example.Orders.Entity.subchild;

import java.util.List;
import java.util.UUID;

import com.example.Orders.Entity.CallbackEvents;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_update_callback_config")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateCallbackConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "callback_config_id", updatable = false, nullable = false)
    private UUID callbackConfigId;

    @Column(name = "callback_url")
    private String callbackUrl;

    // Maps the list of event strings to the Leaf Entity 'CallbackEvents'
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "callback_config_id")
    private List<CallbackEvents> callbackEvents;
}