package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.AmountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOptionDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("label")
    private String label;

    @JsonProperty("type")
    private String type;

    @JsonProperty("selected")
    private Boolean selected;

    @JsonProperty("amount")
    private AmountDTO amount;
}