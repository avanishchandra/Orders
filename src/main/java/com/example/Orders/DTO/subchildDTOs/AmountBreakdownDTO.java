package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.DiscountDTO;
import com.example.Orders.DTO.leafDTOs.HandlingDTO;
import com.example.Orders.DTO.leafDTOs.InsuranceDTO;
import com.example.Orders.DTO.leafDTOs.ItemTotalDTO;
import com.example.Orders.DTO.leafDTOs.ShippingDTO;
import com.example.Orders.DTO.leafDTOs.ShippingDiscountDTO;
import com.example.Orders.DTO.leafDTOs.TaxTotalDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountBreakdownDTO {

    @JsonProperty("item_total")
    private ItemTotalDTO itemTotal;

    @JsonProperty("shipping")
    private ShippingDTO shipping;

    @JsonProperty("handling")
    private HandlingDTO handling;

    @JsonProperty("tax_total")
    private TaxTotalDTO taxTotal;

    @JsonProperty("insurance")
    private InsuranceDTO insurance;

    @JsonProperty("shipping_discount")
    private ShippingDiscountDTO shippingDiscount;

    @JsonProperty("discount")
    private DiscountDTO discount;
}