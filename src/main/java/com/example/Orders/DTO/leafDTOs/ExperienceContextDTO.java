package com.example.Orders.DTO.leafDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceContextDTO {

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("shipping_preference")
    private String shippingPreference;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("return_url")
    private String returnUrl;

    @JsonProperty("cancel_url")
    private String cancelUrl;
    
    // Additional fields found in some contexts
    @JsonProperty("landing_page")
    private String landingPage;
    
    @JsonProperty("user_action")
    private String userAction;
    
    @JsonProperty("payment_method_preference")
    private String paymentMethodPreference;
}