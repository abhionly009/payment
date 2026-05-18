package com.agh.Payment.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class OrderCreatedEvent {
    @NotBlank(message = "Order id should be present for making payment")
    private Long orderId;

    @NotBlank(message = "Product id is required for payment")
    @Positive(message = "Product id must be valid")
    private Long productId;
    @NotBlank(message = "User id must be there to process payment")
    @Positive(message = "User id must be valid")
    private Long userId;

    @NotBlank(message = "Quantity of ordered items should be there")
    @Positive(message = "valid product quantity is required")
    @Min(value = 1)
    private int quantity;

    @NotBlank(message = "Total price of product should be there")
    @Positive(message = "Price should be positive")
    private double price;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderCreatedEvent() {
    }
}
