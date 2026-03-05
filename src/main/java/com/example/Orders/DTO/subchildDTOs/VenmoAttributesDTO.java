package com.example.Orders.DTO.subchildDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.leafDTOs.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenmoAttributesDTO {

    @JsonProperty("vault")
    private VaultDTO vault;

    @JsonProperty("customer")
    private VenmoCustomerDTO customer;
}