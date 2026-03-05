package com.example.Orders.DTO.responseDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Reusing existing Level 2 (Sub-Parent) and Level 4 (Leaf) DTOs
import com.example.Orders.DTO.leafDTOs.LinkDTO;
import com.example.Orders.DTO.subparentDTOs.PayerDTO;
import com.example.Orders.DTO.subparentDTOs.PaymentSourceDTO;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeOrderResponseDTO {

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

    @JsonProperty("payment_source")
    private PaymentSourceDTO paymentSource;

    @JsonProperty("payer")
    private PayerDTO payer;

    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    @JsonProperty("links")
    private List<LinkDTO> links;
}