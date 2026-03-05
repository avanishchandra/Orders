package com.example.Orders.DTO.parentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subparentDTOs.ApplicationContextDTO;
import com.example.Orders.DTO.subparentDTOs.PayerDTO;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDTO {

    @JsonProperty("intent")
    private String intent;

    @JsonProperty("payer")
    private PayerDTO payer;

    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    @JsonProperty("application_context")
    private ApplicationContextDTO applicationContext;
}