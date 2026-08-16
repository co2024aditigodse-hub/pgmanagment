package com.example.pgf.service.service.impl;

import com.example.pgf.dto.BookingDto;
import com.example.pgf.entity.Booking;
import com.example.pgf.entity.Room;
import com.example.pgf.entity.User;
import com.example.pgf.repository.BookingRepository;
import com.example.pgf.repository.RoomRepository;
import com.example.pgf.repository.UserRepository;
import com.example.pgf.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public BookingDto saveBooking(BookingDto bookingDto) {

        User user = userRepository.findById(bookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Room room = roomRepository.findById(bookingDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room Not Found"));

        Booking booking = new Booking();

        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        booking.setBookingStatus(bookingDto.getBookingStatus());
        booking.setUser(user);
        booking.setRoom(room);

        return convertToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto updateBooking(Long id, BookingDto bookingDto) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));

        booking.setBookingStatus(bookingDto.getBookingStatus());

        return convertToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDto getBookingById(Long id) {
        return convertToDto(bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found")));
    }

    @Override
    public List<BookingDto> getAllBookings() {

        List<BookingDto> list = new ArrayList<>();

        for (Booking booking : bookingRepository.findAll()) {
            list.add(convertToDto(booking));
        }

        return list;
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingDto convertToDto(Booking booking) {

        BookingDto dto = new BookingDto();

        dto.setId(booking.getId());
        dto.setBookingDate(booking.getBookingDate());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        dto.setBookingStatus(booking.getBookingStatus());
        dto.setUserId(booking.getUser().getId());
        dto.setRoomId(booking.getRoom().getId());

        return dto;
    }
}