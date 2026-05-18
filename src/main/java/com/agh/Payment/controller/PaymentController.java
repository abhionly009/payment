package com.agh.Payment.controller;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payment")
public class PaymentController {


    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


//    @PostMapping("/pay")
//    public ResponseEntity<String> makePayment(@Valid @RequestBody PaymentRequestDTO requestDTO){
//        String paymentStatus =  paymentService.makePayment(requestDTO);
//        return ResponseEntity.ok(paymentStatus);
//    }

    @PostMapping("/refund")
    public ResponseEntity<String> processRefund(long orderId){
        String refundStatus = paymentService.initiateRefund(orderId);
        return ResponseEntity.ok(refundStatus);
    }

}
