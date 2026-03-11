package com.example.Orders.DTO.subparentDTOs;

import java.util.List;
import com.example.Orders.DTO.subchildDTOs.ErrorDetailsDTO;
import com.example.Orders.DTO.leafDTOs.LinkDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderErrorEventDTO {

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
