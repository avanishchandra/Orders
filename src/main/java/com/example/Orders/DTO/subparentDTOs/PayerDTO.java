package com.example.Orders.DTO.subparentDTOs;

import com.example.Orders.DTO.leafDTOs.AddressDTO;
import com.example.Orders.DTO.leafDTOs.NameDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.example.Orders.DTO.leafDTOs.TaxInfoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayerDTO {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("payer_id")
    private String payerId;

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
}