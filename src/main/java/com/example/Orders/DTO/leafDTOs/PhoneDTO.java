package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    // Sometimes phone type is included in customer objects
    @JsonProperty("phone_type")
    private String phoneType;

    // Sometimes country code is split out
    @JsonProperty("country_code")
    private String countryCode;

    // The JSON nests national_number inside phone_number object
    @JsonProperty("phone_number")
    private PhoneNumberInnerDTO phoneNumber;

    // Direct national_number for flat phone structures (e.g., apple_pay.phone_number)
    @JsonProperty("national_number")
    private String nationalNumber;

    // Internal resolved value (not exposed in JSON)
    @JsonIgnore
    private String resolvedNationalNumber;

    // Getter ignored from JSON
    @JsonIgnore
    public String getResolvedNationalNumber() {
        return resolvedNationalNumber;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PhoneNumberInnerDTO {

        @JsonProperty("national_number")
        private String nationalNumber;
    }
}