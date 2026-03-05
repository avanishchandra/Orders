package com.example.Orders.DTO.parentDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subparentDTOs.ApplicationContextDTO;
import com.example.Orders.DTO.subparentDTOs.PaymentSourceDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmOrderRequestDTO {

    @JsonProperty("payment_source")
    private PaymentSourceDTO paymentSource;

    @JsonProperty("application_context")
    private ApplicationContextDTO applicationContext;
}