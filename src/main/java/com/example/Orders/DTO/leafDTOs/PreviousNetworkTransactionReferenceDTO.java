package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreviousNetworkTransactionReferenceDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("date")
    private String date; // Using String to match JSON format (e.g., "0225" or "2024-01-01")

    @JsonProperty("network")
    private String network;

    @JsonProperty("acquirer_reference_number")
    private String acquirerReferenceNumber;
}