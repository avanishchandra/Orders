package com.example.Orders.DTO.leafDTOs;

// No JsonProperty needed here as this DTO usually holds the single string value 
// mapped from a list of strings ["EVENT_A", "EVENT_B"].
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CallbackEventsDTO {
    
    private String eventType;
}