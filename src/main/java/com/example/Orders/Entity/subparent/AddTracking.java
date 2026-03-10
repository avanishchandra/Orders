package com.example.Orders.Entity.subparent;

import java.util.List;
import java.util.UUID;

import com.example.Orders.Entity.subchild.Item;

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
@Table(name = "add_tracking_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tracking_event_id", updatable = false, nullable = false)
    private UUID trackingEventId;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "carrier_name_other")
    private String carrierNameOther;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "capture_id")
    private String captureId;

    @Column(name = "notify_payer")
    private Boolean notifyPayer;

    // Level 3 Sub-Child List (Items being tracked)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tracking_event_id")
    private List<Item> items;
}