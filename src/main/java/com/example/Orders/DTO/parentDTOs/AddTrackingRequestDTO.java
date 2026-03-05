package com.example.Orders.DTO.parentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subchildDTOs.ItemDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTrackingRequestDTO {

    @JsonProperty("tracking_number")
    private String trackingNumber;

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
}