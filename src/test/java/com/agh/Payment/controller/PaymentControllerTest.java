package com.agh.Payment.controller;

import com.agh.Payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@WebMvcTest(PaymentController.class)
public class PaymentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PaymentService paymentService;

//    @Test
//    void testMakePayment() throws Exception {
//        String paymentStatus = "SUCCESS";
//
//       when(paymentService.makePayment(500L)).thenReturn(paymentStatus);
//
//        mockMvc.perform(post("/payment/pay",12,500)
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isOk());
//
//    }

}
