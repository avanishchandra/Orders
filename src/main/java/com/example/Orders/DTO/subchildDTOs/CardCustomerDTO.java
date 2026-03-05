package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.NameDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardCustomerDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("phone")
    private PhoneDTO phone;
    
    // Sometimes name is broken out here
    @JsonProperty("name")
    private NameDTO name;

    @JsonProperty("merchant_customer_id")
    private String merchantCustomerId;
}