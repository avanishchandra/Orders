package com.example.Orders.Entity.subchild;

import java.util.UUID;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.leaf.*;

@Entity
@Table(name = "shipping_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "shipping_detail_id", updatable = false, nullable = false)
    private UUID shippingDetailId;

    @Column(name = "type")
    private String type;

    // Uses Leaf Entity 'Name'
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_id", referencedColumnName = "id")
    private Name name;

    // Uses Leaf Entity 'address'
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private address address;

    @Column(name = "email_address")
    private String emailAddress;

    // Uses Leaf Entity 'phone'
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private phone phoneNumber;

    // One-to-Many relationship for shipping options
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_detail_id")
    private List<ShippingOption> options;
}