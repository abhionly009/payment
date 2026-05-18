package com.agh.Payment.kafka;

import com.agh.Payment.model.OrderCreatedEvent;
import com.agh.Payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @Autowired
    PaymentService paymentService;

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void handleOrderCreated(OrderCreatedEvent event) {

        System.out.println("Received order event: " + event.getOrderId());
        paymentService.makePayment(event.getPrice());

    }
}