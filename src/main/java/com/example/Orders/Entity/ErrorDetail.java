package com.example.Orders.Entity;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "error_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "error_detail_id", updatable = false, nullable = false)
    private UUID errorDetailId;

    @Column(name = "field")
    private String field;

    @Column(name = "value")
    private String value;

    @Column(name = "location")
    private String location;

    @Column(name = "issue")
    private String issue;

    @Column(name = "description", length = 1000)
    private String description;
}