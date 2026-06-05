package com.agh.Payment.utils;

import com.agh.Payment.model.PaymentResult;

import java.math.BigDecimal;

public interface Payment {
     PaymentResult pay(double amount);
}
