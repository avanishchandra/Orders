package com.example.Orders.Entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "link")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "link_id", updatable = false, nullable = false)
    private UUID linkId;

    @Column(name = "href", length = 2048)
    private String href;

    @Column(name = "rel")
    private String rel;

    @Column(name = "method")
    private String method;
}