package com.example.Orders.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Orders.DTO.parentDTOs.AddTrackingRequestDTO;
import com.example.Orders.DTO.parentDTOs.AuthorizeOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CaptureOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.ConfirmOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.CreateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.OrderDetailsResponseDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderCallbackRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateOrderRequestDTO;
import com.example.Orders.DTO.parentDTOs.UpdateTrackingRequestDTO;
import com.example.Orders.DTO.responseDTOs.AddTrackingResponseDTO;
import com.example.Orders.DTO.responseDTOs.AuthorizeOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CaptureOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.ConfirmOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.CreateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderCallbackResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateOrderResponseDTO;
import com.example.Orders.DTO.responseDTOs.UpdateTrackingResponseDTO;
import com.example.Orders.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 1. POST: Create Order
    @PostMapping("/createOrder")
    public ResponseEntity<CreateOrderResponseDTO> createOrder(
            @RequestHeader(value = "PayPal-Request-Id", required = false) String payPalRequestId,
            @RequestHeader(value = "PayPal-Partner-Attribution-Id", required = false) String payPalPartnerAttributionId,
            @RequestHeader(value = "PayPal-Client-Metadata-Id", required = false) String payPalClientMetadataId,
            @RequestHeader(value = "Prefer", required = false) String prefer,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody CreateOrderRequestDTO createOrderRequestDTO) {
        return new ResponseEntity<>(orderService.createOrder(
                payPalRequestId,
                payPalPartnerAttributionId,
                payPalClientMetadataId,
                prefer,
                authorization,
                payPalAuthAssertion,
                createOrderRequestDTO), HttpStatus.CREATED);
    }

    // 2. GET: Show Order Details
    @GetMapping("/showOrderDetails")
    public ResponseEntity<OrderDetailsResponseDTO> showOrderDetails(
            @RequestParam String orderId,
            @RequestParam(required = false) String fields,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion) {
        return new ResponseEntity<>(orderService.showOrderDetails(orderId, fields, authorization, payPalAuthAssertion), HttpStatus.OK);
    }

    // 3. PATCH: Update Order
    @PatchMapping("/updateOrder")
    public ResponseEntity<UpdateOrderResponseDTO> updateOrder(
            @RequestParam String orderId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody UpdateOrderRequestDTO updateOrderRequestDTO) {
        return new ResponseEntity<>(orderService.updateOrder(orderId, authorization, payPalAuthAssertion, updateOrderRequestDTO), HttpStatus.OK);
    }

    // 4. POST: Confirm Order
    @PostMapping("/confirmOrder")
    public ResponseEntity<ConfirmOrderResponseDTO> confirmOrder(
            @RequestParam String orderId,
            @RequestHeader(value = "PayPal-Client-Metadata-Id", required = false) String payPalClientMetadataId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestHeader(value = "Prefer", required = false) String prefer,
            @RequestBody ConfirmOrderRequestDTO confirmOrderRequestDTO) {
        return new ResponseEntity<>(orderService.confirmOrder(orderId, payPalClientMetadataId, authorization, payPalAuthAssertion, prefer, confirmOrderRequestDTO), HttpStatus.OK);
    }

    // 5. POST: Authorize Payment for Order
    @PostMapping("/authorizeOrder")
    public ResponseEntity<AuthorizeOrderResponseDTO> authorizeOrder(
            @RequestParam String orderId,
            @RequestHeader(value = "PayPal-Request-Id", required = false) String payPalRequestId,
            @RequestHeader(value = "Prefer", required = false) String prefer,
            @RequestHeader(value = "PayPal-Client-Metadata-Id", required = false) String payPalClientMetadataId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody AuthorizeOrderRequestDTO authorizeOrderRequestDTO) {
        return new ResponseEntity<>(orderService.authorizeOrder(orderId, payPalRequestId, prefer, payPalClientMetadataId, authorization, payPalAuthAssertion, authorizeOrderRequestDTO), HttpStatus.OK);
    }

    // 6. POST: Capture Payment for Order
    @PostMapping("/captureOrder")
    public ResponseEntity<CaptureOrderResponseDTO> captureOrder(
            @RequestParam String orderId,
            @RequestHeader(value = "PayPal-Request-Id", required = false) String payPalRequestId,
            @RequestHeader(value = "Prefer", required = false) String prefer,
            @RequestHeader(value = "PayPal-Client-Metadata-Id", required = false) String payPalClientMetadataId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody CaptureOrderRequestDTO captureOrderRequestDTO) {
        return new ResponseEntity<>(orderService.captureOrder(orderId, payPalRequestId, prefer, payPalClientMetadataId, authorization, payPalAuthAssertion, captureOrderRequestDTO), HttpStatus.OK);
    }

    // 7. POST: Add Tracking Information
    @PostMapping("/addTracking")
    public ResponseEntity<AddTrackingResponseDTO> addTracking(
            @RequestParam String orderId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody AddTrackingRequestDTO addTrackingRequestDTO) {
        return new ResponseEntity<>(orderService.addTracking(orderId, authorization, payPalAuthAssertion, addTrackingRequestDTO), HttpStatus.CREATED);
    }

    // 8. PATCH: Update or Cancel Tracking
    @PatchMapping("/updateTracking")
    public ResponseEntity<UpdateTrackingResponseDTO> updateTracking(
            @RequestParam String orderId,
            @RequestParam String trackerId,
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestHeader(value = "PayPal-Auth-Assertion", required = false) String payPalAuthAssertion,
            @RequestBody UpdateTrackingRequestDTO updateTrackingRequestDTO) {
        return new ResponseEntity<>(orderService.updateTracking(orderId, trackerId, authorization, payPalAuthAssertion, updateTrackingRequestDTO), HttpStatus.OK);
    }

    // 9. POST: Update Order Callback
    @PostMapping("/updateOrderCallback")
    public ResponseEntity<UpdateOrderCallbackResponseDTO> updateOrderCallback(
            @RequestHeader(value = "Authorization", required = false) String authorization,
            @RequestBody UpdateOrderCallbackRequestDTO updateOrderCallbackRequestDTO) {
        return new ResponseEntity<>(orderService.updateOrderCallback(authorization, updateOrderCallbackRequestDTO), HttpStatus.OK);
    }
}
