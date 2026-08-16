package com.example.pgf.repository;

import com.example.pgf.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBookingStatus(String bookingStatus);

}