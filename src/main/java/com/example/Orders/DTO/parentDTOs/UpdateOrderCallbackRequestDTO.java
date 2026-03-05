package com.example.Orders.DTO.parentDTOs;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Orders.DTO.subparentDTOs.PurchaseUnitDTO;
import com.example.Orders.DTO.leafDTOs.ShippingAddressDTO;
import com.example.Orders.DTO.subchildDTOs.ShippingOptionDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderCallbackRequestDTO {

    // Often the callback sends a list of purchase units with updated shipping info
    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    // Sometimes shipping info is at the root level in specific callback events
    @JsonProperty("shipping_address")
    private ShippingAddressDTO shippingAddress;

    @JsonProperty("shipping_option")
    private ShippingOptionDTO shippingOption;
}