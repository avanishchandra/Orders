package com.example.Orders.Entity.parent;


import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.Link;
import com.example.Orders.Entity.subparent.Payer;
import com.example.Orders.Entity.subparent.PurchaseUnit;
import com.example.Orders.Entity.subparent.PaymentSource;

@Entity
@Table(name = "show_order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowOrderDetails {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id; // Maps the external Order ID (e.g., "5O190127TN457281P")

    @Column(name = "status")
    private String status;

    @Column(name = "intent")
    private String intent;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    // Reusing Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id_pk", referencedColumnName = "payer_id_pk")
    private Payer payer;

    // Reusing Level 2 Sub-Parent List
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_order_details_id")
    private List<PurchaseUnit> purchaseUnits;

    // Reusing Level 2 Sub-Parent
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_source_id", referencedColumnName = "payment_source_id")
    private PaymentSource paymentSource;

    // New Level 4 Leaf List
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_order_details_id")
    private List<Link> links;
}