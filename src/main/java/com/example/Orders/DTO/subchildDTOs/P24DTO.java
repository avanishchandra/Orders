package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P24DTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;
}