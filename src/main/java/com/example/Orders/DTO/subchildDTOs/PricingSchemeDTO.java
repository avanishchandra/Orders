package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.PriceDTO;
import com.example.Orders.DTO.leafDTOs.ReloadThresholdAmountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricingSchemeDTO {

    @JsonProperty("pricing_model")
    private String pricingModel;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("price")
    private PriceDTO price;

    // Found in some callback structures
    @JsonProperty("fixed_price")
    private PriceDTO fixedPrice;

    @JsonProperty("reload_threshold_amount")
    private ReloadThresholdAmountDTO reloadThresholdAmount;
}