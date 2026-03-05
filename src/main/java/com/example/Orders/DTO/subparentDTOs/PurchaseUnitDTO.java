package com.example.Orders.DTO.subparentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.leafDTOs.*;
import com.example.Orders.DTO.subchildDTOs.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseUnitDTO {

    @JsonProperty("reference_id")
    private String referenceId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("custom_id")
    private String customId;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("soft_descriptor")
    private String softDescriptor;

    @JsonProperty("items")
    private List<ItemDTO> items;

    @JsonProperty("amount")
    private PurchaseUnitAmountDTO amount;

    @JsonProperty("payee")
    private PayeeDTO payee;

    @JsonProperty("payment_instruction")
    private PaymentInstructionDTO paymentInstruction;

    @JsonProperty("shipping")
    private ShippingDetailDTO shipping;

    // Handling the nested billing_plan -> billing_cycles structure
    @JsonProperty("billing_plan")
    private BillingPlanDTO billingPlan; 
    
    // Note: If you didn't create a BillingPlanDTO specifically, you can use an inner static class 
    // or map 'billing_cycles' directly if your logic flattens it. 
    // For completeness, I'll add the inner class here or you can request a standalone file.
    
    @Data
    public static class BillingPlanDTO {
        @JsonProperty("name")
        private String name;
        
        @JsonProperty("setup_fee")
        private SetupFeeDTO setupFee;
        
        @JsonProperty("billing_cycles")
        private List<BillingCycleDTO> billingCycles;
    }

    @JsonProperty("supplementary_data")
    private SupplementaryDataDTO supplementaryData;
}