package com.system.movieticketbooking.services;

import com.system.movieticketbooking.pojo.BookingPojo;

import java.io.IOException;

public interface BookingService {
    BookingPojo saveBooking(BookingPojo bookingPojo) throws IOException;

}
