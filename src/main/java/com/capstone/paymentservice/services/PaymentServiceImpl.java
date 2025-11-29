package com.capstone.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService
{
    private final PaymentGatewaySelector paymentGatewaySelector;

    public PaymentServiceImpl(PaymentGatewaySelector paymentGatewaySelector) {
        this.paymentGatewaySelector = paymentGatewaySelector;
    }

    @Override
    public String initiatePayment()
    {
        return paymentGatewaySelector
                .get()
                .generatePaymentLink();
    }
}