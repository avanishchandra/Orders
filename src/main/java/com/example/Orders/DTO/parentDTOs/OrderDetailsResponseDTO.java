package com.example.Orders.DTO.parentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subparentDTOs.PayerDTO;
import com.example.Orders.DTO.subparentDTOs.PaymentSourceDTO;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;
import com.example.Orders.DTO.leafDTOs.LinkDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("intent")
    private String intent;

    @JsonProperty("create_time")
    private String createTime;

    @JsonProperty("update_time")
    private String updateTime;

    @JsonProperty("payer")
    private PayerDTO payer;

    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    @JsonProperty("payment_source")
    private PaymentSourceDTO paymentSource;

    @JsonProperty("links")
    private List<LinkDTO> links;
}