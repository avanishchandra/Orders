package com.example.Orders.Entity.parent;

import java.util.UUID;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.Entity.Link;
import com.example.Orders.Entity.ErrorDetail;

@Entity
@Table(name = "order_error_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderErrorEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "error_event_id", updatable = false, nullable = false)
    private UUID errorEventId;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "debug_id")
    private String debugId;

    // New Level 4 Leaf List
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "error_event_id")
    private List<ErrorDetail> details;

    // New Level 4 Leaf List
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "error_event_id")
    private List<Link> links;
}