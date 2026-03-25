package com.example.Orders.DTO.responseDTOs;

import java.util.List;

import com.example.Orders.DTO.leafDTOs.AddressDTO;
import com.example.Orders.DTO.subchildDTOs.ShippingOptionDTO;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderCallbackResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    @JsonProperty("shipping_address")
    private AddressDTO shippingAddress;

    @JsonProperty("shipping_option")
    private ShippingOptionDTO shippingOption;
}