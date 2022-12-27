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
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;
    private final MovieRepo movieRepo;

    @Override
    public BookingPojo saveBooking(BookingPojo bookingPojo) throws IOException {
        Booking booking = new Booking();

        booking.setBId(bookingPojo.getBId());
        booking.setUserId(userRepo.findById(bookingPojo.getUser()).orElseThrow());
        booking.setMovieId(movieRepo.findById(bookingPojo.getMovie()).orElseThrow());
        booking.setShowDate(bookingPojo.getShowDate());
        booking.setShowTime(bookingPojo.getShowTime());
        booking.setTicket(bookingPojo.getNoOfTickets());
        booking.setQueue(bookingPojo.getQueue());
        bookingRepo.save(booking);
        return new BookingPojo(booking);
    }

    @Override
    public List<Booking> fetchAll() {
        return bookingRepo.findAll();
    }

    @Override
    public Booking fetchById(Integer id) {
        return bookingRepo.findById(id).orElseThrow(()-> new RuntimeException("CouldNot Find"));

    }
}
