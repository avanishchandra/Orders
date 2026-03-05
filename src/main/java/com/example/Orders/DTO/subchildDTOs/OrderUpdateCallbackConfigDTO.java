package com.example.Orders.DTO.subchildDTOs;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// CallbackEvents is just a string list in JSON usually, but if mapped to DTO:
// import com.example.Orders.DTO.leafDTOs.CallbackEventsDTO; 

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateCallbackConfigDTO {

    @JsonProperty("callback_url")
    private String callbackUrl;

    @JsonProperty("callback_events")
    private List<String> callbackEvents;
}