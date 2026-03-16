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
@Table(name = "add_tracking_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTrackingInformationForAnOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "add_tracking_id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "carrier")
    private String carrier;

    @Column(name = "carrier_name_other")
    private String carrierNameOther;

    @Column(name = "capture_id")
    private String captureId;

    @Column(name = "notify_payer")
    private Boolean notifyPayer;

    @jakarta.persistence.OneToMany(cascade = jakarta.persistence.CascadeType.ALL)
    @jakarta.persistence.JoinColumn(name = "add_tracking_id")
    private java.util.List<com.example.Orders.Entity.subchild.Item> items;
}
