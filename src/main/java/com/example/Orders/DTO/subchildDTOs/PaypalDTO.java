package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.AddressDTO;
import com.example.Orders.DTO.leafDTOs.ExperienceContextDTO;
import com.example.Orders.DTO.leafDTOs.NameDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.example.Orders.DTO.leafDTOs.StoredCredentialDTO;
import com.example.Orders.DTO.leafDTOs.TaxInfoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalDTO {

    @JsonProperty("billing_agreement_id")
    private String billingAgreementId;

    @JsonProperty("vault_id")
    private String vaultId;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("name")
    private NameDTO name;

    @JsonProperty("phone")
    private PhoneDTO phone;

    @JsonProperty("tax_info")
    private TaxInfoDTO taxInfo;

    @JsonProperty("address")
    private AddressDTO address;

    @JsonProperty("experience_context")
    private ExperienceContextDTO experienceContext;
    
    @JsonProperty("attributes")
    private PaypalAttributesDTO attributes;
    
    @JsonProperty("order_update_callback_config")
    private OrderUpdateCallbackConfigDTO orderUpdateCallbackConfig;
    
    @JsonProperty("stored_credential")
    private StoredCredentialDTO storedCredential;
}