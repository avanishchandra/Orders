package com.example.Orders.DTO.subparentDTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.leafDTOs.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplementaryDataDTO {

    @JsonProperty("card")
    private CardSupplementaryDTO card;

    // Inner DTO to handle the specific nesting of supplementary card data
    @Data
    public static class CardSupplementaryDTO {
        @JsonProperty("level_2")
        private Level2DTO level2;

        @JsonProperty("level_3")
        private Level3DTO level3;
    }

    @Data
    public static class Level2DTO {
        @JsonProperty("invoice_id")
        private String invoiceId;

        @JsonProperty("tax_total")
        private TaxTotalDTO taxTotal;
    }

    @Data
    public static class Level3DTO {
        @JsonProperty("ships_from_postal_code")
        private String shipsFromPostalCode;

        @JsonProperty("shipping_amount")
        private ShippingAmountDTO shippingAmount;

        @JsonProperty("discount_amount")
        private DiscountAmountDTO discountAmount;

        @JsonProperty("duty_amount")
        private DutyAmountDTO dutyAmount;
        
        // Note: level_3 often has its own 'line_items' list, 
        // but for this DTO we are mapping the high-level summary fields 
        // found in your specific JSON snippet.
    }
}