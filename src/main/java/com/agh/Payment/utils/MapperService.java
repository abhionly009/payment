package com.agh.Payment.utils;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.model.OrderCreatedEvent;
import com.agh.Payment.model.PaymentDetails;
import com.agh.Payment.model.PaymentStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MapperService {

    public PaymentRequestDTO eventToPaymentRequestDTO(OrderCreatedEvent event){

        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setAmount(event.getPrice().multiply(BigDecimal.valueOf(event.getQuantity())));
        paymentRequestDTO.setOrderId(event.getOrderId());
        paymentRequestDTO.setUserId(event.getUserId());
        paymentRequestDTO.setType(event.getPaymentType());

        return paymentRequestDTO;
    }

    public PaymentDetails paymentRequestToEntity(PaymentRequestDTO requestDTO){

        PaymentDetails payment = new PaymentDetails();
        payment.setAmount(requestDTO.getAmount());
        payment.setCurrency(requestDTO.getCurrency());
        payment.setStatus(PaymentStatus.PROCESSING);
        payment.setOrderId(requestDTO.getOrderId());
        payment.setType(requestDTO.getType());
        payment.setUserId(requestDTO.getUserId());

        return payment;
    }
}
