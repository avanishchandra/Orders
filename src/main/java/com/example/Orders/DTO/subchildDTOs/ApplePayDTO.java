package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.DecryptedTokenDTO;
import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.example.Orders.DTO.leafDTOs.StoredCredentialDTO;
import com.example.Orders.DTO.leafDTOs.VaultDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplePayDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("phone_number")
    private PhoneDTO phoneNumber;

    @JsonProperty("decrypted_token")
    private DecryptedTokenDTO decryptedToken;

    @JsonProperty("vault")
    private VaultDTO vault;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;
    
    // Note: Attributes/StoredCredential might be present in some payloads
    @JsonProperty("stored_credential")
    private StoredCredentialDTO storedCredential;
}