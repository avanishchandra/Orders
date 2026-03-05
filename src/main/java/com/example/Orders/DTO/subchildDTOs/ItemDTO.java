package com.example.Orders.DTO.subchildDTOs;

import com.example.Orders.DTO.leafDTOs.DiscountAmountDTO;
import com.example.Orders.DTO.leafDTOs.TaxDTO;
import com.example.Orders.DTO.leafDTOs.TotalAmountDTO;
import com.example.Orders.DTO.leafDTOs.UnitAmountDTO;
import com.example.Orders.DTO.leafDTOs.UpcDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("description")
    private String description;

    @JsonProperty("sku")
    private String sku;

    @JsonProperty("url")
    private String url;

    @JsonProperty("image_url")
    private String imageUrl;
    
    @JsonProperty("category")
    private String category;
    
    @JsonProperty("commodity_code")
    private String commodityCode;
    
    @JsonProperty("unit_of_measure")
    private String unitOfMeasure;

    @JsonProperty("unit_amount")
    private UnitAmountDTO unitAmount;

    @JsonProperty("tax")
    private TaxDTO tax;
    
    @JsonProperty("discount_amount")
    private DiscountAmountDTO discountAmount;
    
    @JsonProperty("total_amount")
    private TotalAmountDTO totalAmount;

    @JsonProperty("upc")
    private UpcDTO upc;
}