package com.example.Orders.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Orders.Service.OrderService;
import com.example.Orders.DTO.parentDTOs.*;
import com.example.Orders.DTO.responseDTOs.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL =
            "https://api-m.sandbox.paypal.com/v2/checkout/orders";

    /**
     * Centralized PayPal header builder
     */
    private HttpHeaders buildHeaders(
            String authorization,
            String payPalRequestId,
            String prefer,
            String payPalClientMetadataId,
            String payPalPartnerAttributionId,
            String payPalAuthAssertion) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (authorization != null)
            headers.set("Authorization", authorization);

        if (payPalRequestId != null)
            headers.set("PayPal-Request-Id", payPalRequestId);

        if (prefer != null)
            headers.set("Prefer", prefer);

        if (payPalClientMetadataId != null)
            headers.set("PayPal-Client-Metadata-Id", payPalClientMetadataId);

        if (payPalPartnerAttributionId != null)
            headers.set("PayPal-Partner-Attribution-Id", payPalPartnerAttributionId);

        if (payPalAuthAssertion != null)
            headers.set("PayPal-Auth-Assertion", payPalAuthAssertion);

        return headers;
    }

    /**
     * 1. CREATE ORDER
     */
    @Override
    public CreateOrderResponseDTO createOrder(
            String payPalRequestId,
            String payPalPartnerAttributionId,
            String payPalClientMetadataId,
            String prefer,
            String authorization,
            String payPalAuthAssertion,
            CreateOrderRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                payPalRequestId,
                prefer,
                payPalClientMetadataId,
                payPalPartnerAttributionId,
                payPalAuthAssertion);

        HttpEntity<CreateOrderRequestDTO> request =
                new HttpEntity<>(dto, headers);

        ResponseEntity<CreateOrderResponseDTO> response =
                restTemplate.exchange(
                        BASE_URL,
                        HttpMethod.POST,
                        request,
                        CreateOrderResponseDTO.class);

        return response.getBody();
    }

    /**
     * 2. SHOW ORDER DETAILS
     */
    @Override
    public OrderDetailsResponseDTO showOrderDetails(
            String orderId,
            String fields,
            String authorization,
            String payPalAuthAssertion) {

        HttpHeaders headers = buildHeaders(
                authorization,
                null,
                null,
                null,
                null,
                payPalAuthAssertion);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        String url = UriComponentsBuilder
                .fromHttpUrl(BASE_URL + "/" + orderId)
                .queryParamIfPresent("fields", Optional.ofNullable(fields))
                .toUriString();

        ResponseEntity<OrderDetailsResponseDTO> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        request,
                        OrderDetailsResponseDTO.class);

        return response.getBody();
    }

    /**
     * 3. UPDATE ORDER (PATCH)
     * PayPal returns 204 No Content
     */
    @Override
    public UpdateOrderResponseDTO updateOrder(
            String orderId,
            String authorization,
            String payPalAuthAssertion,
            UpdateOrderRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                null,
                null,
                null,
                null,
                payPalAuthAssertion);

        HttpEntity<UpdateOrderRequestDTO> request =
                new HttpEntity<>(dto, headers);

        restTemplate.exchange(
                BASE_URL + "/" + orderId,
                HttpMethod.PATCH,
                request,
                Void.class);

        return new UpdateOrderResponseDTO();
    }

    /**
     * 4. CONFIRM ORDER
     */
    @Override
    public ConfirmOrderResponseDTO confirmOrder(
            String orderId,
            String payPalClientMetadataId,
            String authorization,
            String payPalAuthAssertion,
            String prefer,
            ConfirmOrderRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                null,
                prefer,
                payPalClientMetadataId,
                null,
                payPalAuthAssertion);

        HttpEntity<ConfirmOrderRequestDTO> request =
                new HttpEntity<>(dto, headers);

        ResponseEntity<ConfirmOrderResponseDTO> response =
                restTemplate.exchange(
                        BASE_URL + "/" + orderId + "/confirm-payment-source",
                        HttpMethod.POST,
                        request,
                        ConfirmOrderResponseDTO.class);

        return response.getBody();
    }

    /**
     * 5. AUTHORIZE ORDER
     */
    @Override
    public AuthorizeOrderResponseDTO authorizeOrder(
            String orderId,
            String payPalRequestId,
            String prefer,
            String payPalClientMetadataId,
            String authorization,
            String payPalAuthAssertion,
            AuthorizeOrderRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                payPalRequestId,
                prefer,
                payPalClientMetadataId,
                null,
                payPalAuthAssertion);

        HttpEntity<AuthorizeOrderRequestDTO> request =
                new HttpEntity<>(dto, headers);

        ResponseEntity<AuthorizeOrderResponseDTO> response =
                restTemplate.exchange(
                        BASE_URL + "/" + orderId + "/authorize",
                        HttpMethod.POST,
                        request,
                        AuthorizeOrderResponseDTO.class);

        return response.getBody();
    }

    /**
     * 6. CAPTURE ORDER
     */
    @Override
    public CaptureOrderResponseDTO captureOrder(
            String orderId,
            String payPalRequestId,
            String prefer,
            String payPalClientMetadataId,
            String authorization,
            String payPalAuthAssertion,
            CaptureOrderRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                payPalRequestId,
                prefer,
                payPalClientMetadataId,
                null,
                payPalAuthAssertion);

        HttpEntity<CaptureOrderRequestDTO> request =
                new HttpEntity<>(dto, headers);

        ResponseEntity<CaptureOrderResponseDTO> response =
                restTemplate.exchange(
                        BASE_URL + "/" + orderId + "/capture",
                        HttpMethod.POST,
                        request,
                        CaptureOrderResponseDTO.class);

        return response.getBody();
    }

    /**
     * 7. ADD TRACKING
     */
    @Override
    public AddTrackingResponseDTO addTracking(
            String orderId,
            String authorization,
            String payPalAuthAssertion,
            AddTrackingRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                null,
                null,
                null,
                null,
                payPalAuthAssertion);

        HttpEntity<AddTrackingRequestDTO> request =
                new HttpEntity<>(dto, headers);

        ResponseEntity<AddTrackingResponseDTO> response =
                restTemplate.exchange(
                        BASE_URL + "/" + orderId + "/track",
                        HttpMethod.POST,
                        request,
                        AddTrackingResponseDTO.class);

        return response.getBody();
    }

    /**
     * 8. UPDATE TRACKING (PATCH)
     * Returns 204 No Content
     */
    @Override
    public UpdateTrackingResponseDTO updateTracking(
            String orderId,
            String trackerId,
            String authorization,
            String payPalAuthAssertion,
            UpdateTrackingRequestDTO dto) {

        HttpHeaders headers = buildHeaders(
                authorization,
                null,
                null,
                null,
                null,
                payPalAuthAssertion);

        HttpEntity<UpdateTrackingRequestDTO> request =
                new HttpEntity<>(dto, headers);

        restTemplate.exchange(
                BASE_URL + "/" + orderId + "/trackers/" + trackerId,
                HttpMethod.PATCH,
                request,
                Void.class);

        return new UpdateTrackingResponseDTO();
    }

    /**
     * 9. UPDATE ORDER CALLBACK (WEBHOOK HANDLER)
     */
    @Override
    public UpdateOrderCallbackResponseDTO updateOrderCallback(
            String authorization,
            UpdateOrderCallbackRequestDTO dto) {

        // In production this method should:
        // 1. Validate PayPal webhook signature
        // 2. Parse webhook event
        // 3. Update database state

        UpdateOrderCallbackResponseDTO response =
                new UpdateOrderCallbackResponseDTO();

        return response;
    }
}