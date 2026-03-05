package com.example.Orders.DTO.subchildDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetailsDTO {

    @JsonProperty("field")
    private String field;

    @JsonProperty("value")
    private String value;

    @JsonProperty("location")
    private String location;

    @JsonProperty("issue")
    private String issue;

    @JsonProperty("description")
    private String description;
}