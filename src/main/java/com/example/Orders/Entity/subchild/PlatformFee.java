package com.example.Orders.Entity.subchild;

import java.util.UUID;

import com.example.Orders.Entity.amount;
import com.example.Orders.Entity.payee;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "platform_fee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatformFee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "platform_fee_id", updatable = false, nullable = false)
    private UUID platformFeeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_id", referencedColumnName = "id")
    private amount amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payee_id", referencedColumnName = "id")
    private payee payee;
}