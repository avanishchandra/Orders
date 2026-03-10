package com.example.Orders.Entity.parent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class CapturePaymentForOrder {

    @Id
    private UUID id;

}
