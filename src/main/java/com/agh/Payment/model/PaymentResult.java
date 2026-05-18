package com.agh.Payment.model;

public class PaymentResult {

    private String message;

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    private PaymentStatus status;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    private String transactionId;


    public PaymentResult() {
    }

    public PaymentResult(String message, PaymentStatus status, String transactionId) {
        this.message = message;
        this.status = status;
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
