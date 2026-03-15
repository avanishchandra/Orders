package com.example.Orders.Entity.parent;

import java.util.List;
import java.util.UUID;

import com.example.Orders.DTO.leafDTOs.PatchOperationDTO;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "update_order_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrder {


@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "update_order_id", updatable = false, nullable = false)
private UUID id;

// Stores PATCH operations received from request
@ElementCollection
private List<PatchOperationDTO> patchOperations;


}
