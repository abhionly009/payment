package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;

public interface Payment {
    public PaymentResult pay(double amount);
}
