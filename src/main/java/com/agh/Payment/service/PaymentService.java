package com.agh.Payment.service;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.entity.PaymentDetails;
import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;
import com.agh.Payment.model.PaymentType;
import com.agh.Payment.repository.PaymentRepository;
import com.agh.Payment.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository repository;

    @Autowired
    MapperService mapperService;

    private final Map<PaymentType, Payment> paymentMethods;

    public PaymentService(
            UpiPayment upiPaymentService,
            DebitCardPayment debitCardPayment,
            CreditCardPayment creditCardPayment
    ) {

        paymentMethods = new HashMap<>();
        paymentMethods.put(PaymentType.UPI, upiPaymentService);
        paymentMethods.put(PaymentType.DEBIT, debitCardPayment);
        paymentMethods.put(PaymentType.CREDIT, creditCardPayment);
    }

    public Payment getPaymentMethod(String type) {
        if (type== null){
            return paymentMethods.get(PaymentType.UPI);
        }
        PaymentType paymentType = PaymentType.valueOf(type.toUpperCase());

        return paymentMethods.get(paymentType);
    }


    public void makePayment(PaymentRequestDTO requestDTO){

        System.out.println(requestDTO.getAmount() + "  is being process " );

        Payment payment =
                getPaymentMethod(requestDTO.getType());

        PaymentResult result =
                payment.pay(requestDTO.getAmount());

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setStatus(result.getStatus());
        paymentDetails.setType(requestDTO.getType());
        paymentDetails.setTransactionId(result.getTransactionId());
        paymentDetails.setOrderId(requestDTO.getOrderId());
        paymentDetails.setAmount(requestDTO.getAmount());
        paymentDetails.setUserId(requestDTO.getUserId());
        repository.save(paymentDetails);
        if (result.getStatus().equals(PaymentStatus.SUCCESS)){
            // create event to update inventory
            System.err.println("Payment was successful...");
        }

    }
    public String initiateRefund(long orderId){

        System.out.println("Refund Initiated...for order " + orderId);

        return "Refund Initiated";
    }
}
