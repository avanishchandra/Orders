package com.example.Orders.DTO.subparentDTOs;

import java.util.List;
import com.example.Orders.DTO.subchildDTOs.ItemDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTrackingDTO {

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("carrier_name_other")
    private String carrierNameOther;

    @JsonProperty("carrier")
    private String carrier;

    @JsonProperty("capture_id")
    private String captureId;

    @JsonProperty("notify_payer")
    private Boolean notifyPayer;

    @JsonProperty("items")
    private List<ItemDTO> items;
}
