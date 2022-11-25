package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingPojo {
    private Integer bookingId;

    private Integer user;

    private Integer movie;

    private Date showDate;

    private Time showTime;


    private String queue;

    public BookingPojo(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.user = booking.getUser().getId();
        this.movie = booking.getMovie().getId();
        this.showDate = booking.getShowDate();
        this.showTime = booking.getShowTime();
        this.queue = booking.getQueue();
    }
}
