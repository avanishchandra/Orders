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
public class PaypalCustomerDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("merchant_customer_id")
    private String merchantCustomerId;

    @JsonProperty("phone")
    private PhoneDTO phone;

    @JsonProperty("name")
    private NameDTO name;
}