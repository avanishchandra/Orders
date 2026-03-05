package com.example.Orders.Service;

// Import all Request DTOs
import com.example.Orders.DTO.parentDTOs.AddTrackingRequestDTO;
import com.example.Orders.DTO.parentDTOs.AuthorizeOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CaptureOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.ConfirmOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CreateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.OrderDetailsResponseDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderCallbackRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateTrackingRequestDTO; // The GET response you already had
import com.example.Orders.DTO.responseDTOs.AddTrackingResponseDTO;
import com.example.Orders.DTO.responseDTOs.AuthorizeOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CaptureOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.ConfirmOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CreateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderCallbackResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateTrackingResponseDTO;

public interface OrderService {

    // 1. POST: Create Order
    CreateOrderResponseDTO createOrder(
        String payPalRequestId,
        String payPalPartnerAttributionId,
        String payPalClientMetadataId,
        String prefer,
        String authorization,
        String payPalAuthAssertion,
        CreateOrderRequestDTO createOrderRequestDTO
    );

    // 2. GET: Show Order Details
    OrderDetailsResponseDTO showOrderDetails(
        String orderId,
        String fields,
        String authorization,
        String payPalAuthAssertion
    );

    // 3. PATCH: Update Order
    UpdateOrderResponseDTO updateOrder(
        String orderId,
        String authorization,
        String payPalAuthAssertion,
        UpdateOrderRequestDTO updateOrderRequestDTO
    );

    // 4. POST: Confirm Order
    ConfirmOrderResponseDTO confirmOrder(
        String orderId,
        String payPalClientMetadataId,
        String authorization,
        String payPalAuthAssertion,
        String prefer,
        ConfirmOrderRequestDTO confirmOrderRequestDTO
    );

    // 5. POST: Authorize Payment for Order
    AuthorizeOrderResponseDTO authorizeOrder(
        String orderId,
        String payPalRequestId,
        String prefer,
        String payPalClientMetadataId,
        String authorization,
        String payPalAuthAssertion,
        AuthorizeOrderRequestDTO authorizeOrderRequestDTO
    );

    // 6. POST: Capture Payment for Order
    CaptureOrderResponseDTO captureOrder(
        String orderId,
        String payPalRequestId,
        String prefer,
        String payPalClientMetadataId,
        String authorization,
        String payPalAuthAssertion,
        CaptureOrderRequestDTO captureOrderRequestDTO
    );

    // 7. POST: Add Tracking Information
    AddTrackingResponseDTO addTracking(
        String orderId,
        String authorization,
        String payPalAuthAssertion,
        AddTrackingRequestDTO addTrackingRequestDTO
    );

    // 8. PATCH: Update or Cancel Tracking
    UpdateTrackingResponseDTO updateTracking(
        String orderId,
        String trackerId,
        String authorization,
        String payPalAuthAssertion,
        UpdateTrackingRequestDTO updateTrackingRequestDTO
    );

    // 9. POST: Update Order Callback
    UpdateOrderCallbackResponseDTO updateOrderCallback(
        String authorization,
        UpdateOrderCallbackRequestDTO updateOrderCallbackRequestDTO
    );
}