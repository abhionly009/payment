package com.agh.Payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String makePayment(double amount){

        System.out.println(amount + "  is being process " );

        return "success";
    }
    public String initiateRefund(long orderId){

        System.out.println("Refund Initiated...for order " + orderId);

        return "Refund Initiated";
    }
}
