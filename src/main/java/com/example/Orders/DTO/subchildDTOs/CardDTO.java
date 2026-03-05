package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.BillingAddressDTO;
import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.example.Orders.DTO.leafDTOs.NetworkTokenDTO;
import com.example.Orders.DTO.leafDTOs.StoredCredentialDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("number")
    private String number;

    @JsonProperty("security_code")
    private String securityCode;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("type")
    private String type;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("vault_id")
    private String vaultId;

    @JsonProperty("billing_address")
    private BillingAddressDTO billingAddress;

    @JsonProperty("stored_credential")
    private StoredCredentialDTO storedCredential;

    @JsonProperty("network_token")
    private NetworkTokenDTO networkToken;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;

    @JsonProperty("attributes")
    private CardAttributesDTO attributes;
    
    // Single Use Token sometimes present
    @JsonProperty("single_use_token")
    private String singleUseToken;
}