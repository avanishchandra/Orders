package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.AmountDTO;
import com.example.Orders.DTO.leafDTOs.PayeeDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatformFeeDTO {

    @JsonProperty("amount")
    private AmountDTO amount;

    @JsonProperty("payee")
    private PayeeDTO payee;
}