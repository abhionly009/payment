package com.agh.Payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class PaymentRequestDTO {
    @NotBlank(message = "Payment type should be there")
    private String type;

    @Positive(message = "Amount should be positive")
    private BigDecimal amount;

    @NotBlank(message = "In order to process payment order Id is required")
    @Positive(message = "Order id should be positive")
    private long orderId;

    @NotBlank(message = "To differentiate payment user Id is required ")
    @Positive(message = "User id should be valid")
    private Long userId;

    @NotBlank(message = "Currency is must be available so that conversion is easy")
    private String currency;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public PaymentRequestDTO() {
    }
}
