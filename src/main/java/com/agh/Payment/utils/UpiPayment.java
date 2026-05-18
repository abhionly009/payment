package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class UpiPayment implements Payment{
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                "UPI payment successful",
                PaymentStatus.SUCCESS,
                UUID.randomUUID().toString()
        );
    }
}
