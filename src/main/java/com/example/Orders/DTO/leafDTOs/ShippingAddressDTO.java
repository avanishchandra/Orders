package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressDTO {

    @JsonProperty("address_line_1")
    private String addressLine1;

    @JsonProperty("address_line_2")
    private String addressLine2;

    @JsonProperty("admin_area_2")
    private String adminArea2;

    @JsonProperty("admin_area_1")
    private String adminArea1;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("country_code")
    private String countryCode;
}