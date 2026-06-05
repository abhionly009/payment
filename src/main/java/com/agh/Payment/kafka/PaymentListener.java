package com.agh.Payment.kafka;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.entity.PaymentEvent;
import com.agh.Payment.model.OrderCreatedEvent;
import com.agh.Payment.repository.ProcessedEventRepository;
import com.agh.Payment.service.PaymentService;
import com.agh.Payment.utils.MapperService;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.internals.Acknowledgements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentListener {

    @Autowired
    PaymentService paymentService;

    @Autowired
    MapperService mapperService;

    @Autowired
    ProcessedEventRepository processedEventRepository;

    @KafkaListener(topics = "order-created", groupId = "payment-group-v2")
    public void handleOrderCreated(GenericRecord event) {

        String eventId =  event.get("eventId").toString();
        System.err.println("Received order event with event Id: " + event.get("eventId"));
        System.err.println("Received order event with order Id: " + event.get("orderId"));

       boolean alreadyProcessed = processedEventRepository.existsById(eventId);

       if (alreadyProcessed){
           System.out.println("This event has been already processed we are ignoring it " );
        return;
       }


       String type =  event.get("type").toString();
       double amount = (double) event.get("price");
       String orderId =  event.get("orderId").toString();
       String userId =  event.get("userId").toString();
       String currency =  event.get("type").toString();

       PaymentRequestDTO requestDTO = new PaymentRequestDTO();
       requestDTO.setOrderId(Long.parseLong(orderId));
       requestDTO.setType(type);
       requestDTO.setUserId(Long.parseLong(userId));
       requestDTO.setAmount(amount);
       requestDTO.setCurrency(currency);
       paymentService.makePayment(requestDTO);

       processedEventRepository.save(new PaymentEvent(eventId));
//       System.exit(1);

        /**
         * Here we are exiting from system due to this, kafka will not be able to commit
         * offset so whenever this application will restart kafka will deliver old message
         * this scenario will showcase actual duplicate message delivered
         */
//        System.exit(1);



    }


}