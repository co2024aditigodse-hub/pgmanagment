package com.example.pgf.service.service.impl;

import com.example.pgf.dto.PaymentDto;
import com.example.pgf.entity.Booking;
import com.example.pgf.entity.Payment;
import com.example.pgf.repository.BookingRepository;
import com.example.pgf.repository.PaymentRepository;
import com.example.pgf.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public PaymentDto savePayment(PaymentDto paymentDto) {

        Booking booking = bookingRepository.findById(paymentDto.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));

        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMode(paymentDto.getPaymentMode());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setBooking(booking);

        return convertToDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));

        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMode(paymentDto.getPaymentMode());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());

        return convertToDto(paymentRepository.save(payment));
    }

    @Override
    public PaymentDto getPaymentById(Long id) {

        return convertToDto(paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found")));
    }

    @Override
    public List<PaymentDto> getAllPayments() {

        List<PaymentDto> list = new ArrayList<>();

        for (Payment payment : paymentRepository.findAll()) {
            list.add(convertToDto(payment));
        }

        return list;
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    private PaymentDto convertToDto(Payment payment) {

        PaymentDto dto = new PaymentDto();

        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentMode(payment.getPaymentMode());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setPaymentDate(payment.getPaymentDate());

        if (payment.getBooking() != null) {
            dto.setBookingId(payment.getBooking().getId());
        }

        return dto;
    }
}