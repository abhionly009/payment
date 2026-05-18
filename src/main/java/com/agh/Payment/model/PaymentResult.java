package com.agh.Payment.model;

public class PaymentResult {

    private String message;
    private boolean status;

    public PaymentResult(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public PaymentResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
