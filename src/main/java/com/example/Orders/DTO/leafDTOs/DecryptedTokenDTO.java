package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecryptedTokenDTO {

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("message_expiration")
    private String messageExpiration;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("authentication_method")
    private String authenticationMethod;

    @JsonProperty("cryptogram")
    private String cryptogram;

    @JsonProperty("eci_indicator")
    private String eciIndicator;
}