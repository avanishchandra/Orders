package com.example.Orders.DTO.responseDTOs;

import java.util.List;
import com.example.Orders.DTO.leafDTOs.PatchOperationDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("patch_operations")
    private List<PatchOperationDTO> patchOperations;

}