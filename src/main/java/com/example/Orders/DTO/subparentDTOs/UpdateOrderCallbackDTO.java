package com.example.Orders.DTO.subparentDTOs;

import java.util.List;
import com.example.Orders.DTO.leafDTOs.ShippingAddressDTO;
import com.example.Orders.DTO.subchildDTOs.ShippingOptionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderCallbackDTO {

    @JsonProperty("purchase_units")
    private List<PurchaseUnitDTO> purchaseUnits;

    @JsonProperty("shipping_address")
    private ShippingAddressDTO shippingAddress;

    @JsonProperty("shipping_option")
    private ShippingOptionDTO shippingOption;
}
