package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.AssuranceDetailDTO;
import com.example.Orders.DTO.leafDTOs.DecryptedTokenDTO;
import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GooglePayDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("phone_number")
    private PhoneDTO phoneNumber;

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("decrypted_token")
    private DecryptedTokenDTO decryptedToken;

    @JsonProperty("assurance_details")
    private AssuranceDetailDTO assuranceDetails;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;
}