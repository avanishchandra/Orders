package com.example.Orders.DTO.parentDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subparentDTOs.PaymentSourceDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorizeOrderRequestDTO {

    @JsonProperty("payment_source")
    private PaymentSourceDTO paymentSource;
}