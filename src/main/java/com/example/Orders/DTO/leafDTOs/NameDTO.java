package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameDTO {

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("surname")
    private String surname;
    
    // Sometimes used as a full name string wrapper in shipping objects
    @JsonProperty("full_name")
    private String fullName;
}