package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    @JsonProperty("national_number")
    private String nationalNumber;
    
    // Sometimes phone type is included in customer objects
    @JsonProperty("phone_type")
    private String phoneType;
    
    // Sometimes country code is split out
    @JsonProperty("country_code")
    private String countryCode;
}