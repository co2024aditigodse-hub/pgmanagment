package com.example.pgf.service;

import com.example.pgf.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto savePayment(PaymentDto paymentDto);

    PaymentDto updatePayment(Long id, PaymentDto paymentDto);

    PaymentDto getPaymentById(Long id);

    List<PaymentDto> getAllPayments();

    void deletePayment(Long id);

}