package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {

    @JsonProperty("href")
    private String href;

    @JsonProperty("rel")
    private String rel;

    @JsonProperty("method")
    private String method;
}