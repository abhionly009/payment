package com.agh.Payment.service;

import com.agh.Payment.model.PaymentType;
import com.agh.Payment.utils.DebitCardPayment;
import com.agh.Payment.utils.Payment;
import com.agh.Payment.utils.UpiPayment;

import java.util.HashMap;
import java.util.Map;

public class PaymentFactory {
    private final Map<PaymentType, Payment> paymentMethods;

    public PaymentFactory(
            UpiPayment upiPaymentService,
            DebitCardPayment debitCardPayment
    ) {

        paymentMethods = new HashMap<>();

        paymentMethods.put(PaymentType.UPI, upiPaymentService);
        paymentMethods.put(PaymentType.DEBIT, debitCardPayment);
    }

    public Payment getPaymentMethod(String type) {

        Payment payment = null;

        if (type.toUpperCase().equals(PaymentType.DEBIT)){
           payment =  paymentMethods.get(PaymentType.DEBIT);
        } if (type.toUpperCase().equals(PaymentType.CREDIT)){
            payment = paymentMethods.get(PaymentType.CREDIT);
        }

        return payment;
    }
}
