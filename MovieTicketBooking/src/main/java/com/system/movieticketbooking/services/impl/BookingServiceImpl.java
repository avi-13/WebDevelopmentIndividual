package com.system.movieticketbooking.services.impl;

import com.system.movieticketbooking.entity.Booking;
import com.system.movieticketbooking.pojo.BookingPojo;
import com.system.movieticketbooking.repo.BookingRepo;
import com.system.movieticketbooking.repo.MovieRepo;
import com.system.movieticketbooking.repo.UserRepo;
import com.system.movieticketbooking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;

    @Override
    public BookingPojo saveBooking(BookingPojo bookingPojo) throws IOException {
        Booking booking = new Booking();
        if (bookingPojo.getBookingId() != null) {
            booking.setBookingId(bookingPojo.getBookingId());
        }
        booking.setUser(userRepo.findById(bookingPojo.getUser()).orElseThrow());
        booking.setMovie(movieRepo.findById(bookingPojo.getMovie()).orElseThrow());
        booking.setShowDate(bookingPojo.getShowDate());
        booking.setShowTime(bookingPojo.getShowTime());
        booking.setQueue(bookingPojo.getQueue());
        bookingRepo.save(booking);
        return new BookingPojo(booking);
    }
}
