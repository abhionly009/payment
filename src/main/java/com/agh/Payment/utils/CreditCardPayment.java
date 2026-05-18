package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class CreditCardPayment implements Payment{
    @Override
    public PaymentResult pay(BigDecimal amount) {

        return new PaymentResult(
                "Credit card payment successful",
                PaymentStatus.SUCCESS,
                UUID.randomUUID().toString()
        );
    }
}
