package com.example.Orders.DTO.subparentDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptureOrderDTO {

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("payment_source")
    private PaymentSourceDTO paymentSource;
}
