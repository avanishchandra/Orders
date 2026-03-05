package com.example.Orders.DTO.subparentDTOs;

import com.example.Orders.DTO.leafDTOs.StoredCredentialDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationContextDTO {

    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("landing_page")
    private String landingPage;

    @JsonProperty("shipping_preference")
    private String shippingPreference;

    @JsonProperty("user_action")
    private String userAction;

    @JsonProperty("return_url")
    private String returnUrl;

    @JsonProperty("cancel_url")
    private String cancelUrl;

    @JsonProperty("locale")
    private String locale;

    @JsonProperty("payment_method_preference")
    private String paymentMethodPreference;

    @JsonProperty("stored_payment_source")
    private StoredCredentialDTO storedPaymentSource;
}