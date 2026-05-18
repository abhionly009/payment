package com.agh.Payment.controller;

import com.agh.Payment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payment")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/pay/{orderId}/{amount}")
    public ResponseEntity<String> makePayment(@PathVariable long orderId, @PathVariable  double amount){
        String paymentStatus =  paymentService.makePayment(amount);
        return ResponseEntity.ok(paymentStatus);
    }

    @PostMapping("/refund")
    public ResponseEntity<String> processRefund(long orderId){
        String refundStatus = paymentService.initiateRefund(orderId);
        return ResponseEntity.ok(refundStatus);
    }

}
