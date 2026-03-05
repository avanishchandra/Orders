package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaultDTO {

    @JsonProperty("store_in_vault")
    private String storeInVault;

    @JsonProperty("description")
    private String description;

    @JsonProperty("usage_pattern")
    private String usagePattern;

    @JsonProperty("usage_type")
    private String usageType;

    @JsonProperty("customer_type")
    private String customerType;

    @JsonProperty("permit_multiple_payment_tokens")
    private Boolean permitMultiplePaymentTokens;
}