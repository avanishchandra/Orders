package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountDTO {

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("value")
    private String value;
}