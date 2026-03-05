package com.example.Orders.DTO.subchildDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// PricingSchemeDTO is in this same package, so no import needed.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycleDTO {

    @JsonProperty("tenure_type")
    private String tenureType;

    @JsonProperty("sequence")
    private Integer sequence;

    @JsonProperty("total_cycles")
    private Integer totalCycles;

    @JsonProperty("pricing_scheme")
    private PricingSchemeDTO pricingScheme;
}