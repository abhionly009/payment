package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class VoucherPayment implements Payment{

    private final String type;
    public VoucherPayment(String type){
        this.type = type;
    }

    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(
                "Voucher payment successful",
                PaymentStatus.SUCCESS,
                UUID.randomUUID().toString()
        );
    }
}
