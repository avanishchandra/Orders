package com.example.Orders.DTO.parentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.leafDTOs.LinkDTO;
import com.example.Orders.DTO.subchildDTOs.ErrorDetailsDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("message")
    private String message;

    @JsonProperty("debug_id")
    private String debugId;

    @JsonProperty("details")
    private List<ErrorDetailsDTO> details;

    @JsonProperty("links")
    private List<LinkDTO> links;
}