package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.Booking;
import lombok.*;

import java.sql.Date;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingPojo {
    private Integer bId;

    private Integer user;

    private Integer noOfTickets;

    private Integer movie;

    private Date showDate;

    private LocalTime showTime;


    private String queue;

    public BookingPojo(Booking booking) {
        this.bId = booking.getBId();
        this.user = booking.getUserId().getId();
        this.movie = booking.getMovieId().getId();
        this.showDate = booking.getShowDate();
        this.noOfTickets = booking.getTicket();
        this.showTime = booking.getShowTime();
        this.queue = booking.getQueue();
    }
}
