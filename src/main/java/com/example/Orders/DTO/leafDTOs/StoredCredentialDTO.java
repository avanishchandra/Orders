package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoredCredentialDTO {

    @JsonProperty("payment_initiator")
    private String paymentInitiator;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("usage")
    private String usage;

    @JsonProperty("previous_network_transaction_reference")
    private PreviousNetworkTransactionReferenceDTO previousNetworkTransactionReference;
    
    // Additional fields found in confirm/capture
    @JsonProperty("charge_pattern")
    private String chargePattern;
    
    @JsonProperty("usage_pattern")
    private String usagePattern;
}