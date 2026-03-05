package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkTokenDTO {

    @JsonProperty("number")
    private String number;

    @JsonProperty("cryptogram")
    private String cryptogram;

    @JsonProperty("token_requestor_id")
    private String tokenRequestorId;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("eci_flag")
    private String eciFlag;
}