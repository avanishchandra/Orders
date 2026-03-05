package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.example.Orders.DTO.leafDTOs.Level0DTO;
import com.example.Orders.DTO.leafDTOs.OneClickDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlikDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("email")
    private String email;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;

    @JsonProperty("level_0")
    private Level0DTO level0;

    @JsonProperty("one_click")
    private OneClickDTO oneClick;
}