package com.example.Orders.DTO.subchildDTOs;

import java.util.List;

import com.example.Orders.DTO.leafDTOs.AddressDTO;
import com.example.Orders.DTO.leafDTOs.NameDTO;
import com.example.Orders.DTO.leafDTOs.PhoneDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetailDTO {

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private NameDTO name;

    @JsonProperty("address")
    private AddressDTO address;
    
    @JsonProperty("email_address")
    private String emailAddress;
    
    @JsonProperty("phone_number")
    private PhoneDTO phoneNumber;

    @JsonProperty("options")
    private List<ShippingOptionDTO> options;
}