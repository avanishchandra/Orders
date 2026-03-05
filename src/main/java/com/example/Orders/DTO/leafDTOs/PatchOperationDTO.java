package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchOperationDTO {

    // Matches "string, The operation. Enum: add, remove, replace..."
    @JsonProperty("op")
    private String op; 

    // Matches "string, The JSON Pointer..."
    @JsonProperty("path")
    private String path; 

    // Matches "any, The value to apply..."
    @JsonProperty("value")
    private Object value; 

    // Matches "string, The JSON Pointer..."
    @JsonProperty("from")
    private String from; 
}