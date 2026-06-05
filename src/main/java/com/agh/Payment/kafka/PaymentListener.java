package com.agh.Payment.kafka;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.model.OrderCreatedEvent;
import com.agh.Payment.service.PaymentService;
import com.agh.Payment.utils.MapperService;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.internals.Acknowledgements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @Autowired
    PaymentService paymentService;

    @Autowired
    MapperService mapperService;

    @KafkaListener(topics = "order-created", groupId = "payment-group-v2")
    public void handleOrderCreated(GenericRecord event) {

        System.err.println("Received order event with event Id: " + event.get("eventId"));
        System.err.println("Received order event with order Id: " + event.get("orderId"));

        /**
         * Here we are exiting from system due to this, kafka will not be able to commit
         * offset so whenever this application will restart kafka will deliver old message
         * this scenario will showcase actual duplicate message delivered
         */
        System.exit(1);
//        PaymentRequestDTO requestDTO = mapperService.eventToPaymentRequestDTO(event);
//        paymentService.makePayment(requestDTO);
    }


}