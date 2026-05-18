package com.agh.Payment.service;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.model.PaymentDetails;
import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;
import com.agh.Payment.repository.PaymentRepository;
import com.agh.Payment.utils.MapperService;
import com.agh.Payment.utils.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    @Autowired
    MapperService mapperService;

    @Autowired
    PaymentFactory paymentFactory;

    public void makePayment(PaymentRequestDTO requestDTO){

        System.out.println(requestDTO.getAmount() + "  is being process " );

        Payment payment =
                paymentFactory.getPaymentMethod(requestDTO.getType());

        PaymentResult result =
                payment.pay(requestDTO.getAmount());

        PaymentDetails paymentDetails = mapperService.paymentRequestToEntity(requestDTO);
        paymentDetails.setStatus(result.getStatus());
        paymentDetails.setTransactionId(result.getTransactionId());
        repository.save(paymentDetails);
        if (result.getStatus().equals(PaymentStatus.SUCCESS)){
            // create event to update inventory
        }

    }
    public String initiateRefund(long orderId){

        System.out.println("Refund Initiated...for order " + orderId);

        return "Refund Initiated";
    }
}
