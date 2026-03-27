package com.refaccionaria.orders.model;

import java.time.Instant;
import java.util.List;

public record OrderResponse(String orderId, String status, Instant createdAt, List<CreateOrderRequest.OrderLine> lines) {
}
