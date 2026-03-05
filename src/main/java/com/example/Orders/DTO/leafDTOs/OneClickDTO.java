package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneClickDTO {

    @JsonProperty("auth_code")
    private String authCode;

    @JsonProperty("consumer_reference")
    private String consumerReference;

    @JsonProperty("alias_label")
    private String aliasLabel;

    @JsonProperty("alias_key")
    private String aliasKey;
}