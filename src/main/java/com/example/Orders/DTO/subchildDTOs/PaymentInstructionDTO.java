package com.example.Orders.DTO.subchildDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// PlatformFeeDTO is in this same package
// import com.example.Orders.DTO.subchildDTOs.PlatformFeeDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInstructionDTO {

    @JsonProperty("disbursement_mode")
    private String disbursementMode;

    @JsonProperty("payee_pricing_tier_id")
    private String payeePricingTierId;

    @JsonProperty("payee_receivable_fx_rate_id")
    private String payeeReceivableFxRateId;

    @JsonProperty("platform_fees")
    private List<PlatformFeeDTO> platformFees;
}