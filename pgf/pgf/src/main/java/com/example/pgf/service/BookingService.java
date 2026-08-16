package com.example.pgf.service;

import com.example.pgf.dto.BookingDto;

import java.util.List;

public interface BookingService {

    BookingDto saveBooking(BookingDto bookingDto);

    BookingDto updateBooking(Long id, BookingDto bookingDto);

    BookingDto getBookingById(Long id);

    List<BookingDto> getAllBookings();

    void deleteBooking(Long id);

}