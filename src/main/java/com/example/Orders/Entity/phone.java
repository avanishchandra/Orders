package com.example.Orders.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class phone {

    @Id
    @Column(name = "national_number", nullable = false, unique = true)
    private String nationalNumber;

}
