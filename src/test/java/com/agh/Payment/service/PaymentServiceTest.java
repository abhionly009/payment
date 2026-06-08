package com.agh.Payment.service;

import com.agh.Payment.dto.PaymentRequestDTO;
import com.agh.Payment.entity.PaymentDetails;
import com.agh.Payment.model.PaymentResult;
import com.agh.Payment.model.PaymentStatus;
import com.agh.Payment.repository.PaymentRepository;
import com.agh.Payment.utils.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository repository;

    @Mock
    private MapperService mapperService;

    @Mock
    private UpiPayment upiPayment;

    @Mock
    private DebitCardPayment debitCardPayment;

    @Mock
    private CreditCardPayment creditCardPayment;

    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        paymentService =
                new PaymentService(
                        upiPayment,
                        debitCardPayment,
                        creditCardPayment
                );

        paymentService.repository = repository;
        paymentService.mapperService = mapperService;
    }

    @Test
    void shouldReturnUpiPaymentMethod() {

        Payment payment =
                paymentService.getPaymentMethod("UPI");

        assertEquals(upiPayment, payment);
    }

    @Test
    void shouldReturnDebitPaymentMethod() {

        Payment payment =
                paymentService.getPaymentMethod("DEBIT");

        assertEquals(debitCardPayment, payment);
    }

    @Test
    void shouldReturnCreditPaymentMethod() {

        Payment payment =
                paymentService.getPaymentMethod("CREDIT");

        assertEquals(creditCardPayment, payment);
    }

    @Test
    void shouldReturnUpiWhenTypeIsNull() {

        Payment payment =
                paymentService.getPaymentMethod(null);

        assertEquals(upiPayment, payment);
    }

    @Test
    void shouldMakePaymentSuccessfully() {

        PaymentRequestDTO request = new PaymentRequestDTO();
        request.setAmount(1000.0);
        request.setType("UPI");
        request.setOrderId(101L);
        request.setUserId(1L);

        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setStatus(PaymentStatus.SUCCESS);
        paymentResult.setTransactionId("TXN123");

        when(upiPayment.pay(1000.0))
                .thenReturn(paymentResult);

        paymentService.makePayment(request);

        ArgumentCaptor<PaymentDetails> captor =
                ArgumentCaptor.forClass(PaymentDetails.class);

        verify(repository, times(1))
                .save(captor.capture());

        PaymentDetails savedPayment =
                captor.getValue();

        assertEquals("UPI", savedPayment.getType());
        assertEquals("TXN123", savedPayment.getTransactionId());
        assertEquals(PaymentStatus.SUCCESS,
                savedPayment.getStatus());
        assertEquals(101L, savedPayment.getOrderId());
        assertEquals(1L, savedPayment.getUserId());
        assertEquals(1000.0, savedPayment.getAmount());
    }

    @Test
    void shouldSaveFailedPayment() {

        PaymentRequestDTO request = new PaymentRequestDTO();
        request.setAmount(500.0);
        request.setType("UPI");
        request.setOrderId(111L);
        request.setUserId(2L);

        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setStatus(PaymentStatus.FAILED);
        paymentResult.setTransactionId("TXN999");

        when(upiPayment.pay(500.0))
                .thenReturn(paymentResult);

        paymentService.makePayment(request);

        verify(repository, times(1))
                .save(any(PaymentDetails.class));
    }

    @Test
    void shouldInitiateRefund() {

        String response =
                paymentService.initiateRefund(100L);

        assertEquals(
                "Refund Initiated",
                response
        );
    }

}