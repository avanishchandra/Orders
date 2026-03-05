package com.example.Orders.DTO.subparentDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subchildDTOs.AmountBreakdownDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseUnitAmountDTO {

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("value")
    private String value;

    @JsonProperty("breakdown")
    private AmountBreakdownDTO breakdown;
}