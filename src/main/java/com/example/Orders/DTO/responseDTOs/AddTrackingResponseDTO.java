package com.example.Orders.DTO.responseDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.Orders.DTO.leafDTOs.LinkDTO;
import com.example.Orders.DTO.subchildDTOs.ItemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTrackingResponseDTO {

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("carrier_name_other")
    private String carrierNameOther;

    @JsonProperty("capture_id")
    private String captureId;

    @JsonProperty("notify_payer")
    private Boolean notifyPayer;

    @JsonProperty("items")
    private List<ItemDTO> items;

    @JsonProperty("links")
    private List<LinkDTO> links;
}