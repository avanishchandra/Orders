package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayeeDTO {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("merchant_id")
    private String merchantId;
}