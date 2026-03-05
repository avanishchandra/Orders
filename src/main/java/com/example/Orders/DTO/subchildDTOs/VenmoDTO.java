package com.example.Orders.DTO.subchildDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.leafDTOs.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenmoDTO {

    @JsonProperty("vault_id")
    private String vaultId;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;

    @JsonProperty("order_update_callback_config")
    private OrderUpdateCallbackConfigDTO orderUpdateCallbackConfig;

    @JsonProperty("attributes")
    private VenmoAttributesDTO attributes;
}