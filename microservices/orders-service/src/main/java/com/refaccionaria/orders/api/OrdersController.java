package com.refaccionaria.orders.api;

import com.refaccionaria.orders.model.CreateOrderRequest;
import com.refaccionaria.orders.model.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        OrderResponse response = new OrderResponse(
                UUID.randomUUID().toString(),
                "CREATED",
                Instant.now(),
                request.lines()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, String>> getOrder(@PathVariable String orderId) {
        return ResponseEntity.ok(Map.of("orderId", orderId, "status", "CREATED"));
    }
}
