package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;

public class VoucherPayment implements Payment{

    private final String type;
    public VoucherPayment(String type){

        this.type = type;
    }

    @Override
    public PaymentResult pay(double amount) {

        return null;
    }
}
