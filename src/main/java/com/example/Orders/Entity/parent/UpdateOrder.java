package com.example.Orders.Entity.parent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class UpdateOrder {

    @Id
    private UUID id;

}
