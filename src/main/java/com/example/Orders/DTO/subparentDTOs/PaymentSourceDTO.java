package com.example.Orders.DTO.subparentDTOs;

import com.example.Orders.DTO.subchildDTOs.ApplePayDTO;
import com.example.Orders.DTO.subchildDTOs.BancontactDTO;
import com.example.Orders.DTO.subchildDTOs.BlikDTO;
import com.example.Orders.DTO.subchildDTOs.CardDTO;
import com.example.Orders.DTO.subchildDTOs.EpsDTO;
import com.example.Orders.DTO.subchildDTOs.GiropayDTO;
import com.example.Orders.DTO.subchildDTOs.GooglePayDTO;
import com.example.Orders.DTO.subchildDTOs.IdealDTO;
import com.example.Orders.DTO.subchildDTOs.MybankDTO;
import com.example.Orders.DTO.subchildDTOs.P24DTO;
import com.example.Orders.DTO.subchildDTOs.PaypalDTO;
import com.example.Orders.DTO.subchildDTOs.SofortDTO;
import com.example.Orders.DTO.subchildDTOs.TrustlyDTO;
import com.example.Orders.DTO.subchildDTOs.VenmoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSourceDTO {

    @JsonProperty("card")
    private CardDTO card;

    @JsonProperty("paypal")
    private PaypalDTO paypal;

    @JsonProperty("bancontact")
    private BancontactDTO bancontact;

    @JsonProperty("blik")
    private BlikDTO blik;

    @JsonProperty("eps")
    private EpsDTO eps;

    @JsonProperty("giropay")
    private GiropayDTO giropay;

    @JsonProperty("ideal")
    private IdealDTO ideal;

    @JsonProperty("mybank")
    private MybankDTO mybank;

    @JsonProperty("p24")
    private P24DTO p24;

    @JsonProperty("sofort")
    private SofortDTO sofort;

    @JsonProperty("trustly")
    private TrustlyDTO trustly;

    @JsonProperty("apple_pay")
    private ApplePayDTO applePay;

    @JsonProperty("google_pay")
    private GooglePayDTO googlePay;

    @JsonProperty("venmo")
    private VenmoDTO venmo;

    @JsonProperty("token")
    private com.example.Orders.DTO.leafDTOs.NetworkTokenDTO token; // Sometimes generic token usage
}