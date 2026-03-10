package com.example.Orders.Entity.subparent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class ShippingAddress {

    @Id
    private UUID id;

}
