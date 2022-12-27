package com.system.movieticketbooking.services;

import com.system.movieticketbooking.entity.Booking;
import com.system.movieticketbooking.pojo.BookingPojo;

import java.io.IOException;
import java.util.List;

public interface BookingService {
    BookingPojo saveBooking(BookingPojo bookingPojo) throws IOException;

    List<Booking> fetchAll();

    Booking fetchById(Integer id);
}
